package com.dev.rahul.liboio.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by rahul on 4/1/18.
 */

public interface IBaseView {

    Context getBaseContext();

    void enableBackButton();
    void disableBackButton();

    void setTitle(String title);
    void setSubTitle(String subTitle);

    void onAttachSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout);
    void setSwipeListener(SwipeRefreshLayout.OnRefreshListener listener);

    void onShowLoading();
    void onHideLoading();

    void onFailed(@NonNull String message);
    void onError(@NonNull String error);
    void onSuccess(@NonNull String message);

    void onAddFragment(@NonNull Fragment fragment, @NonNull String tag);
    void onReplaceFragment(@NonNull Fragment fragment, @NonNull String tag);
    void onShowFragment(@NonNull Fragment fragment);
    void onHideFragment(@NonNull String tag);
    void onRemoveFragment(@NonNull String tag);

    Bundle getBundleData();
}
