package com.example.nemol.googlephotokiller.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.nemol.googlephotokiller.BitmapTransform;
import com.example.nemol.googlephotokiller.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullImageActivity extends AppCompatActivity {

    @BindView(R.id.full_image)
    ImageView image;
    /*private static final int MAX_WIDTH = 3840;
    private static final int MAX_HEIGHT = 2160;*/
    private static final int MAX_WIDTH = 5000;
    private static final int MAX_HEIGHT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        // TODO: 03.03.2018 добавить share

        String photoLink = getIntent().getStringExtra("photoLink");
        int size = (int) Math.ceil(Math.sqrt(MAX_WIDTH * MAX_HEIGHT));
        Picasso.with(this).load(photoLink).transform(new BitmapTransform(MAX_WIDTH, MAX_HEIGHT))
                .resize(size, size)
                .centerInside().into(image);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
