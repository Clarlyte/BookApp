package com.dti.dtimanual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SubjectModel>list;
    SubjectAdapter adapter;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menu;
    View header;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if the action bar is not null before hiding it
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        recyclerView = findViewById(R.id.recySubject);
        menu = findViewById(R.id.menu);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        list.add(new SubjectModel("Introduction"));
        list.add(new SubjectModel("Rule 1000"));
        list.add(new SubjectModel("Rule 1010"));
        list.add(new SubjectModel("Rule 1020"));
        list.add(new SubjectModel("Rule 1030"));
        list.add(new SubjectModel("Rule 1040"));
        list.add(new SubjectModel("Rule 1050"));
        list.add(new SubjectModel("Rule 1060"));
        list.add(new SubjectModel("Rule 1070"));
        list.add(new SubjectModel("Rule 1080"));
        list.add(new SubjectModel("Rule 1200"));
        list.add(new SubjectModel("Rule 1210"));
        list.add(new SubjectModel("Rule 1210"));
        list.add(new SubjectModel("Rule 1220"));
        list.add(new SubjectModel("Rule 1230"));
        list.add(new SubjectModel("Rule 1240"));
        list.add(new SubjectModel("Rule 1410"));
        list.add(new SubjectModel("Rule 1420"));
        list.add(new SubjectModel("Rule 1940"));
        list.add(new SubjectModel("Rule 1950"));
        list.add(new SubjectModel("Rule 1960"));
        list.add(new SubjectModel("Rule 1970"));
        list.add(new SubjectModel("Rule 1980"));
        list.add(new SubjectModel("Rule 1990"));
        list.add(new SubjectModel("Annexes"));


        adapter = new SubjectAdapter(this,list);
        recyclerView.setAdapter(adapter);

        header = navigationView.getHeaderView(0);

        menu.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.share) {
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.rate) {
                Toast.makeText(MainActivity.this, "Rate", Toast.LENGTH_SHORT).show();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });



    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();


        }



    }
}