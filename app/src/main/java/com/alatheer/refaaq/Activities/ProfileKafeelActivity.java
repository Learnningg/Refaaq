package com.alatheer.refaaq.Activities;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileKafeelActivity extends AppCompatActivity implements View.OnClickListener {
Button profile,aytam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_kafeel);

        initView();
    }

    private void initView() {
        profile=findViewById(R.id.btn_profile_kafeel);
        aytam=findViewById(R.id.btn_aytam_kafeel);

        profile.setOnClickListener(this);
        aytam.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_profile_kafeel:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentkafeel,new FragmentProfileKaffel())
                        .commit();

                    break;

            case R.id.btn_aytam_kafeel:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentkafeel,new FragmentAytamKaffel())
                        .commit();

                break;


        }
    }
}
