package com.example.wr;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BaseCustomActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;


    protected void onNavBarSettings(boolean is_nav_btn) {
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_running:
                Toast.makeText(getApplicationContext(), "러닝버튼 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_records:
                Toast.makeText(getApplicationContext(), "기록버튼 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_friends:
                Toast.makeText(getApplicationContext(), "친구버튼 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_compete:
                Toast.makeText(getApplicationContext(), "겨루기버튼 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_challenge:
                Toast.makeText(getApplicationContext(), "챌린지버튼 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(getApplicationContext(), "설정버튼 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_user:
                Toast.makeText(getApplicationContext(), "사용자버튼 클릭", Toast.LENGTH_SHORT).show();
                break;
            default:
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
        }
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}