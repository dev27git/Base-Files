package com.rp.basefiles.adapter;

import com.rp.basefiles.IBaseAdapterPresenter;

import java.util.Arrays;
import java.util.List;

public final class RAdapter {

    public static class SingleBuilder<E, P extends IBaseAdapterPresenter<E>> implements IRAdapterParser {

        private IBaseAdapterPresenter<E> presenter;
        private List<Class<?>> classes;
        private List<Integer> layouts;

        public SingleBuilder(IBaseAdapterPresenter<E> presenter) {
            this.presenter = presenter;
        }

        public SingleBuilder<E,P> holders(Class<?>... classes) {
            this.classes = Arrays.asList(classes);
            return this;
        }

        public SingleBuilder<E,P> layouts(Integer... layouts) {
            this.layouts = Arrays.asList(layouts);
            return this;
        }

        @Override
        public List<Class<?>> getClassHolder() {
            return null;
        }

        @Override
        public List<Integer> getLayoutResource() {
            return null;
        }

        @Override
        public List<?> getComparableValue() {
            return null;
        }

        public RSingleAdapter<E,P> build() {
            return new RSingleAdapter<>((P) presenter, this);
        }
    }
}
