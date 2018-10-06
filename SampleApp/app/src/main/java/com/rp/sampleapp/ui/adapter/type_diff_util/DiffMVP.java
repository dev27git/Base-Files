package com.rp.sampleapp.ui.adapter.type_diff_util;

import com.rp.basefiles.IBaseAdapterPresenter;
import com.rp.basefiles.IBaseHolderView;
import com.rp.sampleapp.pojo.DiffUtilData;

public interface DiffMVP {

    interface IView extends IBaseHolderView {
        void showValue(String value);
    }

    interface IPresenter extends IBaseAdapterPresenter<DiffUtilData> {

    }
}
