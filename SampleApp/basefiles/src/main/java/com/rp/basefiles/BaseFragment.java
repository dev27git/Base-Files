package com.rp.basefiles;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rahul on 4/1/18.
 */

public abstract class BaseFragment extends Fragment implements IBaseView, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;

    private Context context;
    private BaseActivity baseActivity;

    public abstract int getLayoutRes();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        baseActivity = (BaseActivity) context;
    }

    @Override
    public void onAttachSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void enableBackButton() {
        baseActivity.enableBackButton();
    }

    @Override
    public void disableBackButton() {
        baseActivity.disableBackButton();
    }

    @Override
    public void setTitle(String title) {
        baseActivity.setTitle(title);
    }

    @Override
    public void setSubTitle(String subTitle) {
        baseActivity.setSubTitle(subTitle);
    }

    @Override
    public Context getBaseContext() {
        return context;
    }

    @Override
    public void onShowLoading() {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onHideLoading() {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFailed(@NonNull String message) {
        baseActivity.onFailed(message);
    }

    @Override
    public void onError(@NonNull String error) {
        baseActivity.onError(error);
    }

    @Override
    public void onSuccess(@NonNull String message) {
        baseActivity.onSuccess(message);
    }

    @Override
    public void initializeSnackBar(View view) {
        baseActivity.initializeSnackBar(view);
    }

    @Override
    public void showSnackBarMessage(String message) {
        baseActivity.showSnackBarMessage(message);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override
    public void hideKeyboard(View view) {
        baseActivity.hideKeyboard(view);
    }

    @Override
    public Bundle getBundleData() {
        return getArguments();
    }

    @Override
    public boolean isConnectedToNetwork() {
        return baseActivity.isConnectedToNetwork();
    }

    public TextView changeToolbarFont(Toolbar toolbar, Context context) {
        return baseActivity.changeToolbarFont(toolbar, context);
    }
}
