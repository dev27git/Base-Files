package com.rp.sampleapp.ui.adapter.type_multi;

import com.rp.basefiles.BaseAdapterPresenter;
import com.rp.basefiles.IBaseHolderView;
import com.rp.basefiles.IBaseView;
import com.rp.sampleapp.pojo.MultiData;
import com.rp.sampleapp.pojo.SingleData;

public class MultiPresenter<E extends MultiData> extends BaseAdapterPresenter<IBaseHolderView, E>
        implements MultiMVP.IPresenter<E> {

    @Override
    public void onBind(int position) {
        if (view() instanceof MultiMVP.IViewOne)
            onBind((MultiMVP.IViewOne) view(), position);
        else
            onBind(((MultiMVP.IViewTwo) view()), position);
    }

    private void onBind(MultiMVP.IViewOne viewOne, int position) {

    }

    private void onBind(MultiMVP.IViewTwo viewTwo, int position) {

    }
}
