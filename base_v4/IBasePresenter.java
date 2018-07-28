package com.dev.rahul.basefilesamples.base_v4;

/**
 * Created by rahul on 4/1/18.
 */

public interface IBasePresenter<V extends IBaseView> {

    void onAttach(V baseView);
    void onDetach();
    void onDestroy();
}
