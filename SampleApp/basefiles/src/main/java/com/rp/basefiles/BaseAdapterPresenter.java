package com.rp.basefiles;

import android.support.v7.recyclerview.extensions.AsyncListDiffer;
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
    private AsyncListDiffer<E> mDiffer;
    private DiffUtil.ItemCallback<E> DIFF_CALLBACK;

    public BaseAdapterPresenter() {
        this.list = new ArrayList<>();
    }

    public BaseAdapterPresenter(List<E> list) {
        this.list = list;
    }

    public void init(List<E> list) {
        this.list = list;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
//            mDiffer.submitList(list);
        }
    }

    @Override
    public void onAttach(IBaseHolderView baseHolderView) {
        this.baseHolderView = (V) baseHolderView;
    }

    @Override
    public void onAttachAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
        mDiffer = new AsyncListDiffer(adapter, DIFF_CALLBACK);
    }

    @Override
    public void onAttachDiffCallback(DiffUtil.Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onAttachDiffCallback(DiffUtil.ItemCallback<E> callback) {
        this.DIFF_CALLBACK = callback;
    }

    public V view() {
        return baseHolderView;
    }

    @Override
    public int getCount() {
//        return list != null ? list.size() : 0;
        return mDiffer.getCurrentList().size();
    }

    @Override
    public void addNewList(List<E> listNewItems) {
        /*if (callback == null) {
            int currentSize = getCount();
            list.addAll(listNewItems);
            adapter.notifyItemRangeInserted(currentSize, getCount());
        } else {
            addNewDiffList(listNewItems);
        }*/

        //List<E> dataList = new ArrayList<>(mDiffer.getCurrentList());
        //dataList.addAll(listNewItems);

        mDiffer.submitList(listNewItems);
    }

    // For DiffUtil
    private void addNewDiffList(List<E> newList) {

        if (callback instanceof RAdapterDiffUtilCallback) {
            RAdapterDiffParser<E> diffParser = new RAdapterDiffParser<>(this.list, newList);
            ((RAdapterDiffUtilCallback) callback).setDiffParser(diffParser);
        }

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);

        /*list.clear();
        list.addAll(newList);*/

        diffResult.dispatchUpdatesTo(adapter);

//        list.clear();
        list.addAll(newList);
    }

    @Override
    public void addItem(E data) {
        list.add(data);
        adapter.notifyItemInserted(getCount());
    }

    @Override
    public void addItemAt(int position, E data) {
        //list.add(data);
        mDiffer.getCurrentList().add(data);
        adapter.notifyItemInserted(position);
    }

    @Override
    public void removeItem(int position) {
        //list.remove(position);
        mDiffer.getCurrentList().remove(position);
        adapter.notifyItemRemoved(position);
    }

    @Override
    public E getFrom(int position) {
        //return list.get(position);
        return mDiffer.getCurrentList().get(position);
    }

    @Override
    public List<E> getAll() {
        //return list;
        return mDiffer.getCurrentList();
    }
}
