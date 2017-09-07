package com.training.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by TMMT on 9/7/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Country> listAdapter;
    private Context mContext;

    public MyAdapter(Context context, List<Country> list) {
        this.listAdapter = list;
        this.mContext = context;
    }

    /** Create new views (invoked by the layout manager) */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** create a new view */
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_items, parent, false);
        /** set the view's size, margins, paddings and layout parameters */
//        ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    /** Replace the contents of a view (invoked by the layout manager) */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /** get element from your dataset at this position
         *  replace the contents of the view with that element
         */
        Country country = this.listAdapter.get(position);
        holder.countryName.setText(country.getmCountryName());
        holder.area.setText(String.valueOf(country.getmArea()));
//        holder.flag.setImageResource();
        Glide.with(mContext).load(country.getmFlagId()).into(holder.flag);
    }

    @Override
    public int getItemCount() {
        return listAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView countryName;
        public TextView area;
        public ImageView flag;

        public ViewHolder(View itemView) {
            super(itemView);
            countryName = (TextView) itemView.findViewById(R.id.first_line);
            area = (TextView) itemView.findViewById(R.id.second_line);
            flag = (ImageView) itemView.findViewById(R.id.icon);
        }
    }

    int mImageId[] = {
            R.drawable.a001_algeria, R.drawable.a002_austria,
            R.drawable.a003_bhutan, R.drawable.a004_burkina_faso,
            R.drawable.a005_china, R.drawable.a006_cyprus,
            R.drawable.a007_czech, R.drawable.a008_france,
            R.drawable.a009_georgia, R.drawable.a010_japan,
            R.drawable.a011_kenya, R.drawable.a012_lesotho,
            R.drawable.a013_madagascar, R.drawable.a014_malawi,
            R.drawable.a015_malta, R.drawable.a016_mauritania,
            R.drawable.a017_morocco, R.drawable.a018_mozambique,
            R.drawable.a019_namibia, R.drawable.a020_netherlands,
            R.drawable.a021_pakistan, R.drawable.a022_peru,
            R.drawable.a023_russia, R.drawable.a024_senegal,
            R.drawable.a025_slovakia, R.drawable.a026_somalia,
            R.drawable.a027_south_africa, R.drawable.a028_south_korea,
            R.drawable.a029_suriname, R.drawable.a030_syria,
            R.drawable.a031_tanzania, R.drawable.a032_thailand,
            R.drawable.a033_turkmenistan, R.drawable.a034_uganda,
            R.drawable.a035_uruguay, R.drawable.a036_venezuela,
            R.drawable.a037_vietnam
    };

    String mCountryName[] = {
            "Algeria", "Austria",
            "Bhutan", "Bukina Faso",
            "China", "Cyprus",
            "Czech", "France",
            "Georgia", "Japan",
            "Kenya", "Lesotho",
            "Madagascar", "Malawi",
            "Malta", "Mauritania",
            "Morocco", "Mozambique",
            "Namibia", "Netherlands",
            "Pakistan", "Peru",
            "Russia", "Senegal",
            "Slovakia", "Somalia",
            "South Africa", "South Korea",
            "Suriname", "Syria",
            "Tanzania", "Thailand",
            "Turkmenistan", "Uganda",
            "Uruguay", "Venezuela",
            "Vietnam"
    };
}
