package com.rp.sampleapp.pojo;

import com.rp.util.adapter.IRAdapterViewType;

public class MultiData implements IRAdapterViewType {

    private int pos;

    public MultiData(int pos) {
        this.pos = pos;
    }

    @Override
    public int getViewType() {
        if (pos % 2 == 0)
            return 0;
        return 1;
    }
}
