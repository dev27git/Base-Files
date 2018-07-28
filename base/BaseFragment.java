package com.dev.rahul.liboio.ui.base;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rahul on 4/1/18.
 */

public abstract class BaseFragment extends Fragment implements IBaseView, SwipeRefreshLayout.OnRefreshListener {

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
        baseActivity.setSwipeListener(this);
    }

    @Override
    public void onAttachSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        baseActivity.onAttachSwipeRefreshLayout(swipeRefreshLayout);
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
    public void setSwipeListener(SwipeRefreshLayout.OnRefreshListener listener) {
        baseActivity.setSwipeListener(listener);
    }

    @Override
    public void onShowLoading() {
        baseActivity.onShowLoading();
    }

    @Override
    public void onHideLoading() {
        baseActivity.onHideLoading();
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
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override
    public void onAddFragment(@NonNull Fragment fragment, @NonNull String tag) {
        baseActivity.onAddFragment(fragment, tag);
    }

    @Override
    public void onReplaceFragment(@NonNull Fragment fragment, @NonNull String tag) {
        baseActivity.onReplaceFragment(fragment,tag);
    }

    @Override
    public void onShowFragment(@NonNull Fragment fragment) {
        baseActivity.onShowFragment(fragment);
    }

    @Override
    public void onHideFragment(@NonNull String tag) {
        baseActivity.onHideFragment(tag);
    }

    @Override
    public void onRemoveFragment(@NonNull String tag) {
        baseActivity.onRemoveFragment(tag);
    }

    @Override
    public Bundle getBundleData() {
        return getArguments();
    }
}
