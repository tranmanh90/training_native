package com.training.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by TMMT on 9/1/2017.
 */

public class CountryAdapter extends BaseAdapter {

    private String mCountryName[];
    private int mFlag[];
    private Context mContext;
    LayoutInflater mLayoutInflater;

    public CountryAdapter(Context applicationContext, int[] flag, String[] countryName) {
        this.mContext = applicationContext;
        this.mCountryName = countryName;
        this.mFlag = flag;
        mLayoutInflater = LayoutInflater.from(applicationContext);
    }

    @Override
    public int getCount() {
        return mCountryName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(R.layout.items_layout, null);
        TextView country = (TextView) convertView.findViewById(R.id.tv_country_name);
        ImageView flag = (ImageView) convertView.findViewById(R.id.img_flag);
        country.setText(mCountryName[position]);
        Glide.with(mContext).load(mFlag[position]).into(flag);
//        flag.setImageResource(mFlag[position]);
        return convertView;
    }
}
