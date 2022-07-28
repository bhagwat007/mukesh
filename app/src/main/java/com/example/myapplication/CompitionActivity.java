package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CompitionActivity extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private RoundAdapter madapter;
    private ArrayList<RoundList> mroundList = new ArrayList<>();
    private String url ="/competitions?token=3e0e77298ef32518821a2490c457300c&per_page=50";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compition);
        mroundList = new ArrayList<>();
        mrecyclerView = findViewById(R.id.roundrecyclerView);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setHasFixedSize(true);

        //action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Details");
        //back buttons
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);



        Intent intent = getIntent();
        String  id1 = intent.getStringExtra("Url");
        if (id1.length()>4){
            id1 = id1.substring(0, 4) + id1.substring(4+1);
        }
        //Log.i("hghsgdha",id1);
        url =  "https://rest.entitysport.com/v2/seasons/" + id1 + url;
  Log.i("link>>>>>>> ",url);
        //TextView textView = findViewById(R.id.text12);

       loadData();
    }

    public  void loadData(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    JSONObject res = response.getJSONObject("response");
                                    JSONArray arr = res.getJSONArray("items");
                                    //Log.i("hoo",arr.toString());
                                    for (int i=0; i < arr.length();i++ ) {
                                        JSONObject mk = arr.getJSONObject(i);
                                        JSONArray rounds = mk.getJSONArray("rounds");
                                      for (int j=0; j<rounds.length();j++) {
                                          JSONObject jsonObject = rounds.getJSONObject(i);

                                          String name = jsonObject.getString("name");
                                          String format = jsonObject.getString("match_format");
                                          String datestart = jsonObject.getString("datestart");
                                          String dateend = jsonObject.getString("dateend");
                                          String type = jsonObject.getString("type");
                                          String  match_url = jsonObject.getString("matches_url");
                                          mroundList.add(new RoundList(name,type, format, datestart, dateend, match_url));

                                         // Log.i("hllhjgjhgjgkjgk", name);
                                      }

                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                madapter = new RoundAdapter(CompitionActivity.this,mroundList);
                                mrecyclerView.setAdapter(madapter);

                            }

                        }, error -> {
                });
        queue.add(jsonObjectRequest);
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}