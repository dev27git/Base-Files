package com.rp.basefiles;

import android.arch.lifecycle.ViewModel;

/**
 * Created by rahul on 4/1/18.
 */

public abstract class BasePresenterVM<V extends IBaseView> extends ViewModel implements IBasePresenter<V> {

    private V view;

    @Override
    public void onAttach(V baseView) {
        this.view = baseView;
    }

    public V view() {
        return view;
    }

    @Override
    public void onDestroy() {
        onCleared();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        view = null;
    }
}
