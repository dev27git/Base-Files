package com.rp.sampleapp.ui.activity.main;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.rp.basefiles.BaseActivity;
import com.rp.sampleapp.R;
import com.rp.sampleapp.pojo.DiffUtilData;
import com.rp.sampleapp.ui.adapter.type_diff_util.DiffHolder;
import com.rp.sampleapp.ui.adapter.type_diff_util.DiffPresenter;
import com.rp.util.adapter.RAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView recyclerView;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /**
         * For single layouts
         */

        /*List<SingleData> dataOne = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            dataOne.add(new SingleData());
        }

        SinglePresenter dataSinglePresenter = new SinglePresenter();
        dataSinglePresenter.init(dataOne);

        RAdapter singleAdapter = new RAdapter.Builder<>(dataSinglePresenter)
                .addHolders(SingleHolder.class)
                .addLayouts(R.layout.recycler_layout_one)
                .build();

        recyclerView.setAdapter(singleAdapter);*/

        /**
         * For multi layouts
         */

        /*List<MultiData> dataOne = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            dataOne.add(new MultiData(i));
        }

        MultiPresenter dataMultiPresenter = new MultiPresenter();
        dataMultiPresenter.init(dataOne);

        RAdapter multiAdapter = new RAdapter.Builder<>(dataMultiPresenter)
                .addHolders(MultiHolderOne.class, MultiHolderTwo.class)
                .addLayouts(R.layout.recycler_layout_one, R.layout.recycler_layout_two)
                .build();

        recyclerView.setAdapter(multiAdapter);*/


        init();
    }

    public void init() {
        List<DiffUtilData> list = new ArrayList<>();

        for (int i = 0 ; i < 5 ; i++) {
            list.add(new DiffUtilData(i, "Value " + i));
        }

        DiffPresenter presenter = new DiffPresenter();
        RAdapter adapter = new RAdapter.Builder<>(presenter)
                .addHolders(DiffHolder.class)
                .addLayouts(R.layout.recycler_layout_one)
                .addPayload((oldData, newData) -> {

                    if (!TextUtils.equals(oldData.getName(), newData.getName()))
                        return newData.getName();

                    return "other";
                })
                .build();

        recyclerView.setAdapter(adapter);
        presenter.update(list);

        new Handler().postDelayed(() -> {
            List<DiffUtilData> list2 = new ArrayList<>();


            list2.add(new DiffUtilData(0, "Value " + 0));
            list2.add(new DiffUtilData(2, "Value " + 2));
            list2.add(new DiffUtilData(1, "Value " + 1));
            list2.add(new DiffUtilData(3, "Value " + 3));
            list2.add(new DiffUtilData(5, "Value " + 5));


            Log.e(TAG, "run: called");
            presenter.addNewList(list2);


        },3000);

        new Handler().postDelayed(() -> presenter.addItemAt(2,new DiffUtilData(6, "Single added")), 5000);

        new Handler().postDelayed(() -> presenter.filter("Va"), 7000);

        new Handler().postDelayed(() -> presenter.filter("Sin"), 9000);

        new Handler().postDelayed(() -> presenter.filter(""), 12000);

    }

    @Override
    public void onRefresh() {

    }
}
