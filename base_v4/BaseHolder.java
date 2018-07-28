package com.dev.rahul.basefilesamples.base_v4;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by rahul on 14/1/18.
 */

public abstract class BaseHolder<P extends IBaseAdapterPresenter> extends RecyclerView.ViewHolder
        implements IBaseHolderView {

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

    @Override
    public IBaseHolderView getView() {
        return this;
    }
}
