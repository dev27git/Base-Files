package com.rp.sampleapp.ui.adapter.type_diff_util;

import com.rp.basefiles.BaseAdapterPresenter;
import com.rp.sampleapp.pojo.DiffUtilData;

public class DiffPresenter extends BaseAdapterPresenter<DiffMVP.IView, DiffUtilData>
        implements DiffMVP.IPresenter {

    @Override
    public void onBind(int position) {
        view().showValue(getFrom(position).getName());
    }

    @Override
    public void onBind(int position, Object payloads) {
        view().showValue(payloads.toString());
    }
}
