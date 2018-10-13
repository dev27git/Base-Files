package com.rp.sampleapp.ui.adapter.type_single;

import com.rp.basefiles.IBaseAdapterPresenter;
import com.rp.basefiles.IBaseHolderView;
import com.rp.sampleapp.pojo.SingleData;

public interface SingleMVP {

    interface IView extends IBaseHolderView {

    }

    interface IPresenter extends IBaseAdapterPresenter<SingleData> {

    }
}
