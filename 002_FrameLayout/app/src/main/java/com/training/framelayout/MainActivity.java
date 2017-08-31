package com.training.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mImageButton1;
    private ImageButton mImageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageButton1 = (ImageButton) findViewById(R.id.image_button_1);
        mImageButton2 = (ImageButton) findViewById(R.id.image_button_2);
        mImageButton1.setOnClickListener(this);
        mImageButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_button_1:
                mImageButton1.setVisibility(v.GONE);
                mImageButton2.setVisibility(v.VISIBLE);
                break;

            case R.id.image_button_2:
                mImageButton1.setVisibility(v.VISIBLE);
                mImageButton2.setVisibility(v.GONE);
                break;
        }
    }
}
