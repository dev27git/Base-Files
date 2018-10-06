package com.rp.util.adapter;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

public final class RAdapterDiffUtilCallback<E> extends DiffUtil.Callback {

    IRAdapterDiffParser diffParser;

    public RAdapterDiffUtilCallback(IRAdapterDiffParser diffParser) {
        this.diffParser = diffParser;
    }

    @Override
    public int getOldListSize() {
        return diffParser.getOldListSize();
    }

    @Override
    public int getNewListSize() {
        return diffParser.getNewListSize();
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        return diffParser.areItemsTheSame(i,i1);
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return diffParser.areContentsTheSame(i,i1);
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
