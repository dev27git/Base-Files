package com.rp.util.adapter;

import com.rp.basefiles.BaseAdapter;
import com.rp.basefiles.IBaseAdapterPresenter;

import java.util.Arrays;
import java.util.List;

public final class RAdapter<E, P extends IBaseAdapterPresenter<E>> extends BaseAdapter<E,P> {

    private List<Integer> layouts;
    private List<Class<?>> holders;

    private RAdapter(P presenter, List<Integer> layouts, List<Class<?>> holders) {
        super(presenter);
        this.layouts = layouts;
        this.holders = holders;
    }

    @Override
    public int getLayoutRes(int viewType) {
        return layouts.get(viewType);
    }

    @Override
    public Class getClassHolder(int viewType) {
        return holders.get(viewType);
    }

    @Override
    public int getViewType(int position) {

        E from = presenter().getFrom(position);
        if (from instanceof IRAdapterViewType) {
            return ((IRAdapterViewType) from).getViewType();
        } else return 0;
    }

    public static class Builder<E, P extends IBaseAdapterPresenter<E>> {

        private IBaseAdapterPresenter<E> presenter;
        private List<Class<?>> classes;
        private List<Integer> layouts;

        public Builder(IBaseAdapterPresenter<E> presenter) {
            this.presenter = presenter;
        }

        public Builder<E,P> addHolders(Class<?>... classes) {
            this.classes = Arrays.asList(classes);
            return this;
        }

        public Builder<E,P> addLayouts(Integer... layouts) {
            this.layouts = Arrays.asList(layouts);
            return this;
        }

        public RAdapter<E,P> build() {
            return new RAdapter<>((P) presenter, layouts, classes);
        }
    }
}
