package com.rp.util.adapter;

import com.rp.util.adapter.annotations.Unique;

import java.lang.reflect.Field;
import java.util.List;

public final class RAdapterDiffParser<E> implements IRAdapterDiffParser {

    private List<E> oldList;
    private List<E> newList;

    public RAdapterDiffParser(List<E> oldList, List<E> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? oldList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldPos, int newPos) {
        return isUnique(oldPos, newPos);
    }

    @Override
    public boolean areContentsTheSame(int oldPos, int newPos) {
        return isContentSame(oldPos, newPos);
    }

    private boolean isUnique(int oldPos, int newPos) {

        Object oldValue = getValue(oldList.get(oldPos));
        Object newValue = getValue(newList.get(newPos));

        return oldValue.equals(newValue);
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
                    declaredField.setAccessible(isAccessible);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }

        }

        return data;
    }

    private boolean isContentSame(int oldPos, int newPos) {

        Object oldData = oldList.get(oldPos);
        Object newData = newList.get(newPos);

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
                if (!oldfield.get(oldData).equals(newFields.get(newData))) {
                    isSame = false;
                }

                oldfield.setAccessible(isAccessible);
                newFields.setAccessible(isAccessible);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return isSame;
    }
}
