package com.dev.rahul.basefilesamples.base;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rahul on 14/1/18.
 */

public abstract class BaseAdapter<T extends BaseHolder,E extends Object, P extends IBaseAdapterPresenter<T,E>>
        extends RecyclerView.Adapter<T> {

    private final String TAG = BaseAdapter.class.getSimpleName();

    private P presenter;

    public BaseAdapter(P presenter) {
        this.presenter = presenter;
        this.presenter.onAttachAdapter(this);
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(viewType), parent, false);
        String str = getClassHolder().getName();
        try {
            Class aClass = Class.forName(str);
            T t = (T) aClass.getConstructor(View.class).newInstance(inflate);
            t.setPresenter(presenter);
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        presenter.onBind(holder,position);
    }

    @Override
    public void onViewRecycled(T holder) {
        presenter.onRecycle(holder);
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public P presenter() {
        return presenter;
    }

    public abstract int getLayoutRes(int viewType);
    public abstract Class getClassHolder();
    public abstract int getViewType(int position);
}
