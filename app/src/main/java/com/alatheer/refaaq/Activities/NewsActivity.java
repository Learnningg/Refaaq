package com.alatheer.refaaq.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alatheer.refaaq.Adapters.News_Adapter;
import com.alatheer.refaaq.R;

public class NewsActivity extends AppCompatActivity {
    int [] NewsImg = {R.drawable.program5,R.drawable.program2,R.drawable.program3,R.drawable.program7,R.drawable.program5,R.drawable.program6,R.drawable.program7};


    String[] title ={"الخبر القاني","الخبر الاول ","الخبر القاني","الخبر الاول ","الخبر القاني","الخبر القاني","الخبر الاول ","الخبر الاول "};
    String[] Deatail={"الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني",
            "الخبر الاولالخبر الاولالخبر الاولالخبر الاولالخبر الاولالخبر الاولالخبر الاول",
            "الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني",
            "الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني",
            "الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني",
            "الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني",
            "الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني",
            "الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني الخبر القاني",};
    RecyclerView programRecyclerView;
    News_Adapter programRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        programRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        programRecyclerAdapter = new News_Adapter(NewsActivity.this,title,NewsImg);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        programRecyclerView.setLayoutManager(layoutManager);
        programRecyclerView.setHasFixedSize(true);


        programRecyclerView.setAdapter(programRecyclerAdapter);
    }

    public void pos(int pos) {


        Intent i = new Intent(NewsActivity.this, DetailsNewsActivity.class);


        i.putExtra("title",title[pos]);
        i.putExtra("detail",Deatail[pos]);
        i.putExtra("img", NewsImg[pos]);


        startActivity(i);


    }
}
