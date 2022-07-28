package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class IccRankingActivity extends AppCompatActivity {
View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icc_ranking);
        Button bt1= findViewById(R.id.teams_rank_id);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="3";
                replacefragment(new Ranking_teams(url));
            }
        });
        Button bt2= findViewById(R.id.batsman_icc_id);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="2";
                replacefragment(new Ranking_teams(url));
            }
        });
        Button bt3= findViewById(R.id.all_rounder_id);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="1";
                replacefragment(new Ranking_teams(url));
            }
        });
        Button bt4= findViewById(R.id.bowler_icc_id);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="0";
                replacefragment(new Ranking_teams(url));
            }
        });

    }
    private void replacefragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_rankings,fragment);
        fragmentTransaction.commit();

    }

}