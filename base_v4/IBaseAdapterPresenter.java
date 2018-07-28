package com.dev.rahul.basefilesamples.base_v4;

import java.util.List;

/**
 * Created by rahul on 14/1/18.
 */

public interface IBaseAdapterPresenter<E extends Object> {

    void onAttach(IBaseHolderView baseHolderView);

    int getCount();
    void onAttachAdapter(BaseAdapter adapter);
    void onBind(int position);

    void addNewItems(List<E> listNewItems);
    void addItem(E data);
    void removeItem(int position);
    E getElementAtPos(int position);
    List<E> getAllElements();
}
