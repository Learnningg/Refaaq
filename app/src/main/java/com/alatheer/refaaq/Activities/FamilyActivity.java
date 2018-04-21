package com.alatheer.refaaq.Activities;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.alatheer.refaaq.Fragments.Family_Member_Fragment;
import com.alatheer.refaaq.Fragments.Finance_Fragment;
import com.alatheer.refaaq.Fragments.Living_Fragment;
import com.alatheer.refaaq.Fragments.Main_Info_Frament;
import com.alatheer.refaaq.Fragments.Parent_Info_Fragment;

import com.alatheer.refaaq.R;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;

import me.anwarshahriar.calligrapher.Calligrapher;

public class FamilyActivity extends AppCompatActivity {

    private AHBottomNavigation bottomNvBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);

        initView();
    }

    private void initView() {
        bottomNvBar = findViewById(R.id.bottomNvBar);
        bottomNvBar.setAccentColor(ContextCompat.getColor(this,R.color.yellow));
        bottomNvBar.setInactiveColor(ContextCompat.getColor(this,R.color.white));
        bottomNvBar.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNvBar.setTitleTextSizeInSp(13f,9f);
        bottomNvBar.setCurrentItem(0,false);
        bottomNvBar.setDefaultBackgroundResource(R.color.colorPrimary);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new Family_Member_Fragment()).commit();

        AHBottomNavigationAdapter adapter = new AHBottomNavigationAdapter(this,R.menu.nav_menu);
        adapter.setupWithBottomNavigation(bottomNvBar);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"JannaLT-Regular.ttf");
        bottomNvBar.setTitleTypeface(typeface);
        bottomNvBar.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position)
                {
                    case 0:
                        bottomNvBar.setCurrentItem(position,false);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Family_Member_Fragment()).commit();

                        break;
                    case 1:
                        bottomNvBar.setCurrentItem(position,false);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Finance_Fragment()).commit();

                        break;
                    case 2:
                        bottomNvBar.setCurrentItem(position,false);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Living_Fragment()).commit();

                        break;
                    case 3:
                        bottomNvBar.setCurrentItem(position,false);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Parent_Info_Fragment()).commit();

                        break;
                    case 4:
                        bottomNvBar.setCurrentItem(position,false);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Main_Info_Frament()).commit();

                        break;
                }
                return false;
            }
        });


    }


}
