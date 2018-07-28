package com.dev.rahul.liboio.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dev.rahul.liboio.ui.fragment.contributor.ContributorsFragment;

/**
 * Created by rahul on 4/1/18.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements IBaseView, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
    }

    @Override
    public void onAttachSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
        setSwipeListener(this);
    }

    @Override
    public void setSwipeListener(SwipeRefreshLayout.OnRefreshListener listener) {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setOnRefreshListener(listener);
    }

    @Override
    public void enableBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void disableBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void setSubTitle(String subTitle) {
        getSupportActionBar().setSubtitle(subTitle);
    }

    @Override
    public void onShowLoading() {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onHideLoading() {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFailed(@NonNull String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(@NonNull String error) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(@NonNull String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddFragment(@NonNull Fragment fragment, @NonNull String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(getFragmentContainerId(),fragment,tag);
        fragmentTransaction.commit();
    }

    @Override
    public void onReplaceFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(getFragmentContainerId(),fragment,tag);
        fragmentTransaction.commit();

    }

    @Override
    public void onShowFragment(@NonNull Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onHideFragment(@NonNull String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onRemoveFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
    }

    @Override
    public Bundle getBundleData() {
        return getIntent() != null ? getIntent().getExtras() : null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        context = null;
        swipeRefreshLayout = null;
    }

    public abstract int getLayoutRes();
    public abstract int getFragmentContainerId();
}
