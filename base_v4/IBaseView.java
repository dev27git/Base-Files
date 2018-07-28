package com.dev.rahul.basefilesamples.base_v4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

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

    void showProgressDialog();
    void hideProgressDialog();

    void onFailed(@NonNull String message);
    void onError(@NonNull String error);
    void onSuccess(@NonNull String message);

    void initializeSnackBar(View view);
    void showSnackBarMessage(String message);

    void onAttachFragment(@NonNull Fragment fragment, @NonNull String tag);
    void onAttachFragment(@NonNull Fragment fragment, @NonNull String tag, boolean addToBackStack);
    void onDetachFragment(@NonNull String tag);
    void removeAllBackStackFragments();

    void hideKeyboard(View view);

    Bundle getBundleData();
}
