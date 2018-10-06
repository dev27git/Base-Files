package com.rp.util.adapter;

public interface RAdapterPayloadWatcher<T, E> {

    T getPayloadData(E oldData, E newData);
}
