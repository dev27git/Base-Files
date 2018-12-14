package com.rp.util.adapter

import android.widget.Filter
import com.rp.basefiles.IBaseAdapterPresenter
import com.rp.util.adapter.annotations.parser.FilterWithParser

class ItemFilter<E>(private val baseAdapterPresenter: IBaseAdapterPresenter<E>) : Filter() {

    private val originalList = baseAdapterPresenter.all

    override fun performFiltering(constraint: CharSequence?): FilterResults? {
        val filterResults = FilterResults()

        if (constraint.isNullOrBlank() || constraint.isNullOrEmpty()) {
            filterResults.count = originalList.size
            filterResults.values = originalList
        } else {
            var newList = originalList.filter {
                FilterWithParser.isQueryAvailable(it, constraint as String?)
            }

            if (newList.isNullOrEmpty()) return null

            filterResults.count = newList.size
            filterResults.values = newList
        }

        return filterResults
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        results?.let {
            baseAdapterPresenter.update(it.values as List<E>)
        }
    }
}