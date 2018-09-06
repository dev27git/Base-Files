package com.rp.basefiles.adapter;

import java.util.List;

interface IRAdapterParser {

    List<Class<?>> getClassHolder();
    List<Integer> getLayoutResource();
    List<?> getComparableValue();
}
