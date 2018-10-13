package com.rp.basefiles

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseHolder<P : IBaseAdapterPresenter<*>>(itemView: View)
    : RecyclerView.ViewHolder(itemView), IBaseHolderView {

    lateinit var presenter: P

    override val view: IBaseHolderView
        get() = this
}