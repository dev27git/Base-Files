package com.rp.sampleapp.ui.base;

/**
 * Created by rahul on 4/1/18.
 */

public interface IBasePresenter<V extends IBaseView> {

    void onAttach(V baseView);
    void onDetach();
    void onDestroy();
}
