package com.rp.sampleapp.ui.activity.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rp.basefiles.BaseActivity;
import com.rp.sampleapp.R;
import com.rp.sampleapp.pojo.DiffUtilData;
import com.rp.sampleapp.ui.adapter.type_diff_util.DiffHolder;
import com.rp.sampleapp.ui.adapter.type_diff_util.DiffPresenter;
import com.rp.util.adapter.RAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

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

        List<DiffUtilData> list = new ArrayList<>();

        for (int i = 0 ; i < 5 ; i++) {
            list.add(new DiffUtilData(i, "Value " + i));
        }

        DiffPresenter presenter = new DiffPresenter();
        presenter.init(list);

        RAdapter adapter = new RAdapter.Builder<>(presenter)
                .addHolders(DiffHolder.class)
                .addLayouts(R.layout.recycler_layout_one)
                .enableDiffCallback((oldData, newData) -> ((DiffUtilData) newData).getName())
                .build();

        recyclerView.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<DiffUtilData> list2 = new ArrayList<>();
                for (int i = 3 ; i < 8 ; i++) {
                    list2.add(new DiffUtilData(i, "Value New " + i));
                }
                presenter.addNewList(list2);
            }
        },5000);



    }

    @Override
    public void onRefresh() {

    }
}
