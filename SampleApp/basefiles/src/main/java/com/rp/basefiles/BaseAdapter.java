package com.rp.basefiles;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by rahul on 14/1/18.
 */

public abstract class BaseAdapter<E, P extends IBaseAdapterPresenter<E>>
        extends RecyclerView.Adapter<BaseHolder<P>> {

    private final String TAG = BaseAdapter.class.getSimpleName();

    private P presenter;

    public BaseAdapter(P presenter) {
        this.presenter = presenter;
        this.presenter.onAttachAdapter(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public BaseHolder<P> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(viewType), parent, false);
        BaseHolder<P> baseHolder = null;
        try {
            Class<?> aClass = getClassHolder(viewType);
            baseHolder = (BaseHolder<P>) aClass.getConstructor(View.class).newInstance(inflate);
            baseHolder.setPresenter(presenter);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return baseHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolder<P> holder, int position) {
        Log.e(TAG, "onBindViewHolder: called");
        presenter.onAttach(holder.getView());
        presenter.onBind(position);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolder<P> holder, int position, @NonNull List<Object> payloads) {
        Log.e(TAG, "onBindViewHolder: payload called");
        if (payloads.isEmpty())
            onBindViewHolder(holder, position);
        else {
            presenter.onAttach(holder.getView());
            Log.e(TAG, "onBindViewHolder: payload Size => " + payloads.size()
                    + " position : " + position + " payload value : " + payloads.get(0));
            presenter.onBind(position, payloads.get(0));
        }
    }

    @Override
    public void onViewRecycled(@NonNull BaseHolder<P> holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public P presenter() {
        return presenter;
    }

    public abstract int getLayoutRes(int viewType);
    public abstract Class<?> getClassHolder(int viewType);
    public abstract int getViewType(int position);
}
