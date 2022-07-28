package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_Activity extends DrawerBaseActivity {

    BottomNavigationView bottomNavigationView;

    ActivityMainBinding activityMainBinding;

    activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(activityMainBinding.getRoot());

    bottomNavigationView=findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.seasons:
                    startActivity(new Intent(getApplicationContext(),LiveMatch_activity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.home:
                    return true;

                case R.id.stats:
                    startActivity(new Intent(getApplicationContext(),season_Activity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.menu:
                    startActivity(new Intent(getApplicationContext(),Main_Activity.class));
                    overridePendingTransition(0,0);
                    return true;


            }
            return false;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



                Button season = (Button) findViewById(R.id.button3);
        season.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Main_Activity.this, season_Activity.class);
                startActivity(numbersIntent);

            }
        });
        Button Live = (Button) findViewById(R.id.button4);
        Live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Main_Activity.this, LiveMatch_activity.class);
                startActivity(numbersIntent);

            }
        });
        Button Ranking = (Button) findViewById(R.id.Ranking);
        Ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Activity.this, IccRankingActivity.class);
                startActivity(intent);

            }
        });
        Button Completed = (Button) findViewById(R.id.matches);
        Completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new CompletedFragment());
            }
        });

    }
    private void replacefragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.schedulefgrame,fragment);
        fragmentTransaction.commit();


    }
}

