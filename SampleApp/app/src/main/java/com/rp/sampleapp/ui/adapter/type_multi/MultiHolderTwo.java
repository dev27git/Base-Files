package com.rp.sampleapp.ui.adapter.type_multi;

import android.view.View;

import com.rp.basefiles.BaseHolder;
import com.rp.sampleapp.pojo.MultiData;

public class MultiHolderTwo extends BaseHolder<MultiPresenter<MultiData>>
        implements MultiMVP.IViewTwo {

    public MultiHolderTwo(View itemView) {
        super(itemView);
    }
}
