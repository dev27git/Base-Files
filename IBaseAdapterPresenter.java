package com.nits.livestream.ui.base;

import java.util.List;

/**
 * Created by rahul on 14/1/18.
 */

public interface IBaseAdapterPresenter<T extends BaseHolder, E extends Object> {

    int getCount();
    void onAttachAdapter(BaseAdapter adapter);
    void onBind(T holder, int position);
    void onRecycle(T holder);

    void addNewItems(List<E> listNewItems);
    void addItem(E data);
    void removeItem(int position);
    List<E> getAllElements();
}
