package com.example.wr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_running:
                Toast.makeText(getApplicationContext(), "러닝버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_records:
                Toast.makeText(getApplicationContext(), "기록버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_friends:
                Toast.makeText(getApplicationContext(), "친구버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_compete:
                Toast.makeText(getApplicationContext(), "겨루기버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_challenge:
                Toast.makeText(getApplicationContext(), "챌린지버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_settings:
                Toast.makeText(getApplicationContext(), "설정버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_user:
                Toast.makeText(getApplicationContext(), "사용자버튼 클릭", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}