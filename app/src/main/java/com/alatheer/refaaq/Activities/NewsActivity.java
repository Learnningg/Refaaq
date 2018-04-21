package com.alatheer.refaaq.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alatheer.refaaq.Adapters.News_Adapter;
import com.alatheer.refaaq.R;

public class NewsActivity extends AppCompatActivity {
    String [] programsNames = {String.valueOf(R.string.tit),String.valueOf(R.string.tit),String.valueOf(R.string.tit),"البرنامج الرابع","البرنامج الثالث","البرنامج الثانى","البرنامج الاول "};
    int [] programsImg = {R.drawable.program5,R.drawable.program2,R.drawable.program3,R.drawable.program7,R.drawable.program5,R.drawable.program6,R.drawable.program7};
    RecyclerView programRecyclerView;
    News_Adapter programRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        programRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        programRecyclerAdapter = new News_Adapter(NewsActivity.this,programsNames,programsImg);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        programRecyclerView.setLayoutManager(layoutManager);
        programRecyclerView.setHasFixedSize(true);


        programRecyclerView.setAdapter(programRecyclerAdapter);
    }
}
