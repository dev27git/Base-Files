package com.rp.basefiles.adapter;

import com.rp.basefiles.BaseAdapter;
import com.rp.basefiles.IBaseAdapterPresenter;

public final class RSingleAdapter<E, P extends IBaseAdapterPresenter<E>> extends BaseAdapter<E,P> {

    private IRAdapterParser parser;

    public RSingleAdapter(P presenter, IRAdapterParser parser) {
        super(presenter);
        this.parser = parser;
    }

    @Override
    public int getLayoutRes(int viewType) {
        return parser.getLayoutResource().get(0);
    }

    @Override
    public Class getClassHolder(int viewType) {
        return parser.getClassHolder().get(0);
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }
}
