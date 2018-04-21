package com.alatheer.refaaq.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alatheer.refaaq.R;

public class DetailsNewsActivity extends AppCompatActivity {
    TextView title,desc;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_news);

        title= (TextView) findViewById(R.id.detail_title);
        desc=(TextView) findViewById(R.id.detail_desc);
        img=(ImageView)findViewById(R.id.detail_img);


        Intent u = getIntent();

        title.setText(u.getStringExtra("title"));
        desc.setText(u.getStringExtra("detail"));
        img.setImageResource(u.getIntExtra("img",0));
    }
}
