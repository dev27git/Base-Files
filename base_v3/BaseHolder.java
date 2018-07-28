package com.dev.rahul.basefilesamples.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rahul on 14/1/18.
 */

public abstract class BaseHolder<P extends IBaseAdapterPresenter> extends RecyclerView.ViewHolder {

    public P presenter;

    public BaseHolder(View itemView) {
        super(itemView);
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public P getPresenter() {
        return presenter;
    }
}
