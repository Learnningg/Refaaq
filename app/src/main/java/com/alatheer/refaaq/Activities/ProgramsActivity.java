package com.alatheer.refaaq.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alatheer.refaaq.Adapters.ProgramsAdapter;
import com.alatheer.refaaq.R;


public class ProgramsActivity extends AppCompatActivity {
    String [] programsNames = {"البرنامج السابع","البرنامج السادس","البرنامج الخامس","البرنامج الرابع","البرنامج الثالث","البرنامج الثانى","البرنامج الاول "};
    String [] programsRate = {"25$","100$","94$","25$","100$","94$","100$"};
    int [] programsImg = {R.drawable.program5,R.drawable.program2,R.drawable.program3,R.drawable.program7,R.drawable.program5,R.drawable.program6,R.drawable.program7};
    RecyclerView programRecyclerView;
    ProgramsAdapter programRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);
        programRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        programRecyclerAdapter = new ProgramsAdapter(ProgramsActivity.this,programsNames,programsRate,programsImg);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        programRecyclerView.setLayoutManager(layoutManager);
        programRecyclerView.setHasFixedSize(true);
        programRecyclerView.setAdapter(programRecyclerAdapter);
    }
}
