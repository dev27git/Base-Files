package com.nits.livestream.ui.base;

/**
 * Created by rahul on 4/1/18.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V baseView;

    @Override
    public void onAttach(V baseView) {
        this.baseView = baseView;
    }

    @Override
    public void onDetach() {
        baseView = null;
    }

    public V getBaseView() {
        return baseView;
    }
}
