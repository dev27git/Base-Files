package com.rp.sampleapp.ui.adapter.type_multi;

import android.view.View;

import com.rp.basefiles.BaseHolder;
import com.rp.sampleapp.pojo.MultiData;
import com.rp.sampleapp.pojo.SingleData;

public class MultiHolderOne extends BaseHolder<MultiPresenter>
        implements MultiMVP.IViewTwo {

    public MultiHolderOne(View itemView) {
        super(itemView);
    }
}
