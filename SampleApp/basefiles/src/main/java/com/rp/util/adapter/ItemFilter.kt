package com.rp.util.adapter

import android.widget.Filter
import com.rp.basefiles.IBaseAdapterPresenter

class ItemFilter<E>(baseAdapterPresenter: IBaseAdapterPresenter<E>) : Filter() {

    private val originalList = listOf(baseAdapterPresenter.all)

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        val filterResults = FilterResults()

        if (constraint.isNullOrBlank() || constraint.isNullOrEmpty()) {
            filterResults.count = originalList.size
            filterResults.values = originalList
        } else {

        }

        return filterResults
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}