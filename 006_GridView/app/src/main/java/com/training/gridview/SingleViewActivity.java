package com.training.gridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Created by TMMT on 9/1/2017.
 */

public class SingleViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        /** Get intent data */
        Intent i = getIntent();

        /** Selected image */
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(imageAdapter.mThumIds[position]);
    }
}
