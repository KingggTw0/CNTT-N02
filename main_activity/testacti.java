package com.example.admin.kiemtrab.main_activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.kiemtrab.Database_main;
import com.example.admin.kiemtrab.R;
import com.example.admin.kiemtrab.Fragment_view.main_home;
import com.example.admin.kiemtrab.giaotiep;

public class testacti extends AppCompatActivity implements giaotiep {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Spinner spinner;
    Database_main db_main=new Database_main(this,"hocky.sqlite",null,1);
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testacti);
        maping();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        set_intent(1);
                        Toast.makeText(testacti.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        break;
                    case 2:
                        set_intent(2);
                        Toast.makeText(testacti.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        break;
                    case 3:
                        set_intent(3);
                        Toast.makeText(testacti.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        break;
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_bottom, new main_home()).commit();
                        drawerLayout.closeDrawers();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Toolbar toolbar=(Toolbar)findViewById(R.id.ac_tool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);
//        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
//                R.string.Open,R.string.Close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                menuItem.setChecked(true);
//                drawerLayout.closeDrawers();
                if (menuItem.getItemId()==R.id.item2){
                    onBackPressed();
                }
                return true;
            }
        });
    }

    public void set_intent(int i){
        Intent intent=new Intent(this,ac_theloai.class);
        intent.putExtra("menu",i);
        this.startActivity(intent);
    }
    private void maping(){
        drawerLayout=(DrawerLayout)findViewById(R.id.ac_drawer);
        navigationView=(NavigationView)findViewById(R.id.ac_navition);
        spinner =(Spinner) findViewById(R.id.spin_main);
    }
    private void back() {
        Intent j=new Intent();
       // j.putExtra("back","hh");
        setResult(RESULT_OK,j);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.timkiem,menu);
        return true;
    }

    @Override
    public void ganID(int vt) {
        Intent id=new Intent(this,ac_chitiet.class);
        id.putExtra("id",vt);
        startActivity(id);
    }

    @Override
    public void suasp(int vt) {

    }

    @Override
    public void ganrow(String row) {

    }
}
