package com.alatheer.refaaq.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.alatheer.refaaq.Fragments.FragmentAytamKaffel;
import com.alatheer.refaaq.Fragments.FragmentProfileKaffel;
import com.alatheer.refaaq.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    Button profile,aytam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initView();
    }

    private void initView() {
        profile=findViewById(R.id.btn_profile_kafeel);
        aytam=findViewById(R.id.btn_aytam_kafeel);

        profile.setOnClickListener(this);
        aytam.setOnClickListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentkafeel,new FragmentProfileKaffel())
                .commit();
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
            Intent intent=new Intent(MainActivity.this,NewsActivity.class);
            startActivity(intent);        } else if (id == R.id.nav_programs) {
            Intent intent=new Intent(MainActivity.this,ProgramsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contact) {
            Intent intent=new Intent(MainActivity.this,CallUsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            Intent intent=new Intent(MainActivity.this,AboutUsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
