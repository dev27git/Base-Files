package com.rp.sampleapp.ui.activity.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rp.basefiles.IBaseAdapterPresenter;
import com.rp.basefiles.adapter.RAdapter;
import com.rp.sampleapp.R;
import com.rp.sampleapp.pojo.MultiData;
import com.rp.sampleapp.pojo.SingleData;
import com.rp.sampleapp.ui.adapter.type_multi.MultiHolderOne;
import com.rp.sampleapp.ui.adapter.type_multi.MultiHolderTwo;
import com.rp.sampleapp.ui.adapter.type_multi.MultiPresenter;
import com.rp.sampleapp.ui.adapter.type_single.SingleHolder;
import com.rp.sampleapp.ui.adapter.type_single.SinglePresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        /**
         * For single layouts
         */

        /*List<SingleData> dataOne = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            dataOne.add(new SingleData());
        }

        SinglePresenter<SingleData> dataSinglePresenter = new SinglePresenter<>();
        dataSinglePresenter.init(dataOne);

        RAdapter singleAdapter = new RAdapter.Builder<>(dataSinglePresenter)
                .addHolders(SingleHolder.class)
                .addLayouts(R.layout.recycler_layout_one)
                .build();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(singleAdapter);*/

        List<MultiData> dataOne = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            dataOne.add(new MultiData(i));
        }

        MultiPresenter<MultiData> dataMultiPresenter = new MultiPresenter<>();
        dataMultiPresenter.init(dataOne);

        RAdapter multiAdapter = new RAdapter.Builder<>(dataMultiPresenter)
                .addHolders(MultiHolderOne.class, MultiHolderTwo.class)
                .addLayouts(R.layout.recycler_layout_one, R.layout.recycler_layout_two)
                .build();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(multiAdapter);

    }
}
