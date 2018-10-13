package com.rp.basefiles

import android.arch.lifecycle.ViewModel

abstract class BasePresenterVM<V : IBaseView> : ViewModel(), IBasePresenter<V> {

    private var view: V? = null

    override fun onAttach(baseView: V) {
        this.view = baseView
    }

    fun view(): V? = view

    override fun onDestroy() = onCleared()

    override fun onCleared() {
        super.onCleared()
        view = null
    }
}