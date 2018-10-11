package com.rp.basefiles;

import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.DiffUtil;

import com.rp.util.adapter.RAdapterAsyncDiffCallback;
import com.rp.util.adapter.RAdapterPayloadWatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 20/1/18.
 */

public abstract class BaseAdapterPresenter<V extends IBaseHolderView, E>
        implements IBaseAdapterPresenter<E> {

    private V baseHolderView;

    private AsyncListDiffer<E> mDiffer;
    private DiffUtil.ItemCallback<E> DIFF_CALLBACK;

    public BaseAdapterPresenter() {
        this.DIFF_CALLBACK = new RAdapterAsyncDiffCallback<>();
    }

    @Override
    public void onAttach(IBaseHolderView baseHolderView) {
        this.baseHolderView = (V) baseHolderView;
    }

    @Override
    public void onAttachAdapter(BaseAdapter adapter) {
        mDiffer = new AsyncListDiffer<>(adapter, DIFF_CALLBACK);
    }

    @Override
    public void onAttachDiffCallback(DiffUtil.ItemCallback<E> callback) {
        this.DIFF_CALLBACK = callback;
    }

    @Override
    public void onAttachPayloadWatcher(RAdapterPayloadWatcher<E> payloadWatcher) {
        if (DIFF_CALLBACK instanceof RAdapterAsyncDiffCallback)
            ((RAdapterAsyncDiffCallback<E>) DIFF_CALLBACK)
                    .addPayloadWatcher(payloadWatcher);
    }

    public V view() {
        return baseHolderView;
    }

    @Override
    public void update(List<E> list) {
        mDiffer.submitList(list);
    }

    @Override
    public int getCount() {
//        return list != null ? list.size() : 0;
        return mDiffer.getCurrentList().size();
    }

    @Override
    public void addNewList(List<E> listNewItems) {
        List<E> oldList = new ArrayList<>(mDiffer.getCurrentList());
        oldList.addAll(listNewItems);
        mDiffer.submitList(oldList);
    }

    @Override
    public void addItem(E data) {
        List<E> oldList = new ArrayList<>(mDiffer.getCurrentList());
        oldList.add(data);
        mDiffer.submitList(oldList);
    }

    @Override
    public void addItemAt(int position, E data) {
        List<E> oldList = new ArrayList<>(mDiffer.getCurrentList());
        oldList.add(position, data);
        mDiffer.submitList(oldList);
    }

    @Override
    public void removeItem(int position) {
        List<E> oldList = new ArrayList<>(mDiffer.getCurrentList());
        oldList.remove(position);
        mDiffer.submitList(oldList);
    }

    @Override
    public E getFrom(int position) {
        return mDiffer.getCurrentList().get(position);
    }

    @Override
    public List<E> getAll() {
        return mDiffer.getCurrentList();
    }
}
