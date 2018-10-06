package com.rp.sampleapp.ui.adapter.type_multi;

import com.rp.basefiles.BaseAdapterPresenter;
import com.rp.basefiles.IBaseHolderView;
import com.rp.sampleapp.pojo.MultiData;

public class MultiPresenter extends BaseAdapterPresenter<IBaseHolderView, MultiData>
        implements MultiMVP.IPresenter {

    @Override
    public void onBind(int position) {
        if (view() instanceof
                MultiMVP.IViewOne)
            onBind((MultiMVP.IViewOne) view(), position);
        else
            onBind(((MultiMVP.IViewTwo) view()), position);
    }

    @Override
    public void onBind(int position, Object payloads) {

    }

    private void onBind(MultiMVP.IViewOne viewOne, int position) {

    }

    private void onBind(MultiMVP.IViewTwo viewTwo, int position) {

    }
}
