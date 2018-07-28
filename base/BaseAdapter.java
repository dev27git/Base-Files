package com.dev.rahul.liboio.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by rahul on 14/1/18.
 */

public abstract class BaseAdapter<T extends BaseHolder,E extends Object, P extends IBaseAdapterPresenter<T,E>>
        extends RecyclerView.Adapter<T> {

    private P presenter;

    public BaseAdapter(P presenter) {
        this.presenter = presenter;
        this.presenter.onAttachAdapter(this);
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        return getHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        presenter.onBind(holder,position);
    }

    @Override
    public void onViewRecycled(T holder) {
        super.onViewRecycled(holder);
        presenter.onRecycle(holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getCount();
    }

    public abstract T getHolder(ViewGroup parent, int viewType);
}
