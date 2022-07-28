package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class PlayerActivity extends AppCompatActivity {
    String token = "https://rest.entitysport.com/v2/players/";
    String url = "?token=3e0e77298ef32518821a2490c457300c&per_page=50";
    TextView name,role,birth,nationalty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Players");
        //back buttons
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        name=findViewById(R.id.playername);
        role =findViewById(R.id.role);
        birth = findViewById(R.id.playerdatebirth);
        nationalty = findViewById(R.id.ntionality);

//       Intent intent1 =getIntent();
        //get data from intent
        Intent i = getIntent();
        String id = i.getStringExtra("bowlerid");
//        String id2 = i.getStringExtra("bowlerid");
        Log.i("id::>>>>>",id);
url=token+id+url;
Log.i("url::>>>>??????????????",url);

//        Intent int1 =getIntent();
//        String id2 = int1.getStringExtra("Batsmenid");
//
//        Log.i("id::>>>>",id2);
        loaddata();
    }


    public void loaddata(){

        RequestQueue queue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject res = response.getJSONObject("response");
                    JSONObject player = res.getJSONObject("player");
                    String Playername = player.getString("title");
                    name.setText(Playername);
                    String birthdate = player.getString("birthdate");
                    birth.setText(birthdate);
                    String batting_style = player.getString("batting_style");
                    role.setText(batting_style);
                    String bowling_style = player.getString("bowling_style");
                    String nationality = player.getString("nationality");
                    nationalty.setText(nationality);

                    JSONObject batting = res.getJSONObject("batting");
                    String matches = batting.getString("matches");
                    String innings = batting.getString("innings");
                    String runs = batting.getString("runs");
                    String balls = batting.getString("balls");
                    String highest = batting.getString("highest");
                    String run100 = batting.getString("run100");
                    String run50 = batting.getString("run50");
                    //String run50 = batting.getString("run50");
                   // String run50 = batting.getString("run50");
                    String average = batting.getString("average");
                    String strike = batting.getString("strike");





                } catch (JSONException e) {
                    e.printStackTrace();
                }

                
            }

        }, error -> {
        });
        queue.add(jsonObjectRequest);
        // mroundList.add(new DataScorecad( 1,"tbatsmen","ball_faced","sfour","ssixes","sssr","out"));

    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}