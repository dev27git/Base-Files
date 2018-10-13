package com.rp.basefiles

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View


interface IBaseView {

    val bundleData: Bundle
    val isConnectedToNetwork: Boolean

    fun enableBackButton()
    fun disableBackButton()

    fun setTitle(title: String)
    fun setSubTitle(subTitle: String)

    fun onAttachSwipeRefreshLayout(swipeRefreshLayout: SwipeRefreshLayout)

    fun onShowLoading()
    fun onHideLoading()

    fun initializeSnackBar(view: View)
    fun showSnackBarMessage(message: String)

    fun hideKeyboard(view: View)
}