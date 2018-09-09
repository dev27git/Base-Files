package com.rp.basefiles;

/**
 * Created by rahul on 4/1/18.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

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
        view = null;
    }
}
