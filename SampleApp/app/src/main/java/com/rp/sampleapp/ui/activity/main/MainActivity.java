package com.rp.sampleapp.ui.activity.main;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rp.basefiles.BaseActivity;
import com.rp.sampleapp.R;

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

        /**
         * For single layouts
         */

       /* List<SingleData> dataOne = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            dataOne.add(new SingleData());
        }

        SinglePresenter<SingleData> dataSinglePresenter = new SinglePresenter<>();
        dataSinglePresenter.init(dataOne);

        RAdapter singleAdapter = new RAdapter.Builder<>(dataSinglePresenter)
                .addHolders(SingleHolder.class)
                .addLayouts(R.id.recycler_layout_one)
                .build();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(singleAdapter);*/

        /**
         * For multi layouts
         */

        /*List<MultiData> dataOne = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            dataOne.add(new MultiData(i));
        }

        MultiPresenter<MultiData> dataMultiPresenter = new MultiPresenter<>();
        dataMultiPresenter.init(dataOne);

        RAdapter multiAdapter = new RAdapter.Builder<>(dataMultiPresenter)
                .addHolders(MultiHolderOne.class, MultiHolderTwo.class)
                .addLayouts(R.id.recycler_layout_one, R.id.recycler_layout_two)
                .build();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(multiAdapter);*/

    }

    @Override
    public void onRefresh() {

    }
}
