package com.rp.sampleapp.ui.adapter.type_single;

import com.rp.basefiles.BaseAdapterPresenter;
import com.rp.sampleapp.pojo.SingleData;

public class SinglePresenter<E extends SingleData> extends BaseAdapterPresenter<SingleMVP.IView, E>
        implements SingleMVP.IPresenter<E> {

    @Override
    public void onBind(int position) {

    }
}
