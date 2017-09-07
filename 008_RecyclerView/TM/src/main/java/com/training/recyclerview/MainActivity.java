package com.training.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Country> mListCountry;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter ;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mListCountry = new ArrayList<>();
        mAdapter = new MyAdapter(this,mListCountry);
        for (int i = 0; i<mAdapter.mImageId.length; i++){
            mListCountry.add(new Country(mAdapter.mCountryName[i],1000000,mAdapter.mImageId[i]));
        }
        mRecyclerView.setAdapter(mAdapter);
    }
}
