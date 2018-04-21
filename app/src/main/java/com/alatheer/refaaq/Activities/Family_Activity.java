package com.alatheer.refaaq.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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

public class Family_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AHBottomNavigation bottomNvBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__family);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.family_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            Intent intent=new Intent(Family_Activity.this,NewsActivity.class);
            startActivity(intent);        } else if (id == R.id.nav_programs) {
            Intent intent=new Intent(Family_Activity.this,ProgramsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contact) {
            Intent intent=new Intent(Family_Activity.this,CallUsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            Intent intent=new Intent(Family_Activity.this,AboutUsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
