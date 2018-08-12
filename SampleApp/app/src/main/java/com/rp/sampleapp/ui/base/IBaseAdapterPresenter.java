package com.rp.sampleapp.ui.base;

import java.util.List;

/**
 * Created by rahul on 14/1/18.
 */

public interface IBaseAdapterPresenter<E> {

    void onAttach(IBaseHolderView baseHolderView);

    int getCount();
    void onAttachAdapter(BaseAdapter adapter);
    void onBind(int position);

    void addNewList(List<E> listNewItems);
    void addItem(E data);
    void addItemAt(int position, E data);
    void removeItem(int position);
    E getFrom(int position);
    List<E> getAll();
}
