package com.rp.basefiles;

import android.support.v7.util.DiffUtil;

import com.rp.util.adapter.RAdapterDiffParser;
import com.rp.util.adapter.RAdapterDiffUtilCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 20/1/18.
 */

public abstract class BaseAdapterPresenter<V extends IBaseHolderView, E>
        implements IBaseAdapterPresenter<E> {

    private List<E> list;
    private BaseAdapter adapter;
    private V baseHolderView;

    private DiffUtil.Callback callback;

    public BaseAdapterPresenter() {
        this.list = new ArrayList<>();
    }

    public BaseAdapterPresenter(List<E> list) {
        this.list = list;
    }

    public void init(List<E> list) {
        this.list = list;
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(IBaseHolderView baseHolderView) {
        this.baseHolderView = (V) baseHolderView;
    }

    @Override
    public void onAttachAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onAttachDiffCallback(DiffUtil.Callback callback) {
        this.callback = callback;
    }

    public V view() {
        return baseHolderView;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public void addNewList(List<E> listNewItems) {
        if (callback == null) {
            int currentSize = getCount();
            list.addAll(listNewItems);
            adapter.notifyItemRangeInserted(currentSize, getCount());
        } else {
            addNewDiffList(listNewItems);
        }
    }

    // For DiffUtil
    private void addNewDiffList(List<E> newList) {

        if (callback instanceof RAdapterDiffUtilCallback) {
            RAdapterDiffParser<E> diffParser = new RAdapterDiffParser<>(list, newList);
            ((RAdapterDiffUtilCallback) callback).setDiffParser(diffParser);
        }

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);
        diffResult.dispatchUpdatesTo(adapter);
        list.addAll(newList);
    }

    @Override
    public void addItem(E data) {
        list.add(data);
        adapter.notifyItemInserted(getCount());
    }

    @Override
    public void addItemAt(int position, E data) {
        list.add(data);
        adapter.notifyItemInserted(position);
    }

    @Override
    public void removeItem(int position) {
        list.remove(position);
        adapter.notifyItemRemoved(position);
    }

    @Override
    public E getFrom(int position) {
        return list.get(position);
    }

    @Override
    public List<E> getAll() {
        return list;
    }
}
