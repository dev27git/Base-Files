package com.rp.basefiles;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

    void onShowLoading();
    void onHideLoading();

    void onFailed(@NonNull String message);
    void onError(@NonNull String error);
    void onSuccess(@NonNull String message);

    void initializeSnackBar(View view);
    void showSnackBarMessage(String message);

    void hideKeyboard(View view);

    Bundle getBundleData();
    boolean isConnectedToNetwork();
}
