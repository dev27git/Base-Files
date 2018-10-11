package com.rp.basefiles;

import android.support.v7.util.DiffUtil;

import com.rp.util.adapter.RAdapterPayloadWatcher;

import java.util.List;

/**
 * Created by rahul on 14/1/18.
 */

public interface IBaseAdapterPresenter<E> {

    void onAttach(IBaseHolderView baseHolderView);
    void onAttachAdapter(BaseAdapter adapter);
    void onAttachDiffCallback(DiffUtil.ItemCallback<E> callback);

    void onAttachPayloadWatcher(RAdapterPayloadWatcher<E> payloadWatcher);

    int getCount();
    void onBind(int position);
    void onBind(int position, Object payloads);

    void update(List<E> list);
    void addNewList(List<E> listNewItems);
    void addItem(E data);
    void addItemAt(int position, E data);
    void removeItem(int position);

    E getFrom(int position);
    List<E> getAll();
}
