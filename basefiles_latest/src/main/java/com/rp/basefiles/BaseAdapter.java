package com.rp.basefiles;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rahul on 14/1/18.
 */

public abstract class BaseAdapter<E, P extends IBaseAdapterPresenter<E>>
        extends RecyclerView.Adapter<BaseHolder<P>> {

    private final String TAG = BaseAdapter.class.getSimpleName();

    private P presenter;

    public BaseAdapter(P presenter) {
        this.presenter = presenter;
        this.presenter.onAttachAdapter(this);
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(viewType), parent, false);
//        String str = getClassHolder(viewType).getName();
        try {
            Class aClass = getClassHolder(viewType);
            BaseHolder baseHolder = (BaseHolder) aClass.getConstructor(View.class).newInstance(inflate);
            baseHolder.setPresenter(presenter);
            return baseHolder;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHolder<P> holder, int position) {
        presenter.onAttach(holder.getView());
        presenter.onBind(position);
    }

    @Override
    public void onViewRecycled(@NonNull BaseHolder holder) {
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
    public abstract Class getClassHolder(int viewType);
    public abstract int getViewType(int position);
}
