package com.rp.sampleapp.ui.adapter.type_diff_util;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.rp.basefiles.BaseHolder;
import com.rp.sampleapp.R;

public class DiffHolder extends BaseHolder<DiffPresenter>
        implements DiffMVP.IView {

    AppCompatTextView tvValue;

    public DiffHolder(View itemView) {
        super(itemView);
        tvValue = itemView.findViewById(R.id.tvValue);
    }

    @Override
    public void showValue(String value) {
        tvValue.setText(value);
    }
}
