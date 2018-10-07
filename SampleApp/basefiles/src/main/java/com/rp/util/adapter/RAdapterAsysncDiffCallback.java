package com.rp.util.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.util.Log;

import com.rp.util.adapter.annotations.Unique;

import java.lang.reflect.Field;
import java.util.Objects;

public class RAdapterAsysncDiffCallback<T> extends DiffUtil.ItemCallback<T> {

    public static final String TAG = RAdapterAsysncDiffCallback.class.getSimpleName();
    private RAdapterPayloadWatcher payloadWatcher;

    public RAdapterAsysncDiffCallback(RAdapterPayloadWatcher payloadWatcher) {
        this.payloadWatcher = payloadWatcher;
    }

    @Override
    public boolean areItemsTheSame(@NonNull T t, @NonNull T t1) {

        Object oldValue = getValue(t);
        Object newValue = getValue(t1);

        Log.e(TAG, "isUnique: old : " + oldValue + " new : " + newValue + " equal : " + Objects.equals(oldValue, newValue));

        return Objects.equals(oldValue, newValue);
    }

    @Override
    public boolean areContentsTheSame(@NonNull T t, @NonNull T t1) {
        return t.equals(t1);//isContentSame(t,t1);
    }

    @Nullable
    @Override
    public Object getChangePayload(@NonNull T oldItem, @NonNull T newItem) {

        if (payloadWatcher == null)
            return null;

        return payloadWatcher.getPayloadData(oldItem, newItem);
    }

    private Object getValue(Object element) {

        Field[] declaredFields = element.getClass().getDeclaredFields();

        Object data = null;

        for (Field declaredField : declaredFields) {

            boolean isAccessible = declaredField.isAccessible();

            if (!isAccessible)
                declaredField.setAccessible(true);

            if (declaredField.isAnnotationPresent(Unique.class)) {
                try {
                    data = declaredField.get(element);
                    //declaredField.setAccessible(isAccessible);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }

        }

        return data;
    }

    private boolean isContentSame(Object oldData, Object newData) {

        Class<?> oldClass = oldData.getClass();
        Class<?> newClass = newData.getClass();

        Field[] oldDeclaredFields = oldClass.getDeclaredFields();
        Field[] newDeclaredFields = newClass.getDeclaredFields();

        boolean isSame = true;

        for (int i = 0; i < oldDeclaredFields.length; i++) {
            Field oldfield = oldDeclaredFields[i];
            Field newFields = newDeclaredFields[i];

            boolean isAccessible = oldfield.isAccessible();

            if (!isAccessible) {
                oldfield.setAccessible(true);
                newFields.setAccessible(true);
            }

            try {
                Object dataOne = oldfield.get(oldData);
                Object dataTwo = newFields.get(newData);

                System.out.println("Old " + oldfield.getName()+" : "+oldfield.get(oldData));
                System.out.println("New " + newFields.getName()+" : "+newFields.get(newData));

                if (!Objects.deepEquals(dataOne, dataTwo)) {
                    isSame = false;
                    break;
                }

//                oldfield.setAccessible(isAccessible);
//                newFields.setAccessible(isAccessible);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Log.w(TAG, "isContentSame: isSame => " + isSame);
        return isSame;
    }
}
