package com.rp.util.adapter;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

public final class RAdapterDiffUtilCallback extends DiffUtil.Callback {

    private IRAdapterDiffParser diffParser;
    private RAdapterPayloadWatcher payloadWatcher;

    public RAdapterDiffUtilCallback() {}

    public RAdapterDiffUtilCallback(IRAdapterDiffParser diffParser) {
        this.diffParser = diffParser;
    }

    public RAdapterDiffUtilCallback(IRAdapterDiffParser diffParser, RAdapterPayloadWatcher payloadWatcher) {
        this.diffParser = diffParser;
        this.payloadWatcher = payloadWatcher;
    }

    public IRAdapterDiffParser getDiffParser() {
        return diffParser;
    }

    public void setDiffParser(IRAdapterDiffParser diffParser) {
        this.diffParser = diffParser;
    }

    public void setPayloadWatcher(RAdapterPayloadWatcher payloadWatcher) {
        this.payloadWatcher = payloadWatcher;
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
        if (payloadWatcher == null)
            return null;

        RAdapterDiffParser parser = (RAdapterDiffParser) diffParser;
        return payloadWatcher.getPayloadData(
                parser.getOldData(oldItemPosition),
                parser.getNewData(newItemPosition)
        );
    }
}
