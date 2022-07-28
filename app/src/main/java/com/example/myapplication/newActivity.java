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
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class newActivity extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private compitionAdapter madapter;
    private ArrayList<Datalist> mdataList = new ArrayList<>();
    private String id;
    private String url ="?token=3e0e77298ef32518821a2490c457300c&per_page=50";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        mdataList = new ArrayList<>();
        mrecyclerView = findViewById(R.id.recyclerView1);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setHasFixedSize(true);

        //action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Details");
        //back buttons
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        //get data from intent
        Intent intent = getIntent();
        String  id = intent.getStringExtra("Url");
       // Log.i("hghsgdha::::::::::::::",id);
        //Add in url to get url
        url =  "https://rest.entitysport.com/v2/" + id + url;
       Log.i("ukhdkjckljhckjckjhkxjhkjv",url);
        loadData();
    }
    public  void loadData()
    {

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject res = response.getJSONObject("response");
                                    JSONArray arr = res.getJSONArray("items");
                                   // Log.i("hoo",arr.toString());
                                    for (int i=0; i < arr.length();i++ ) {
                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String title = jsonObject.getString("title");
                                        String  abbr = jsonObject.getString("abbr");
                                        String  startDate = jsonObject.getString("datestart");
                                        String  endDate = jsonObject.getString("dateend");
                                        String  season = jsonObject.getString("season");
                                        mdataList.add(new Datalist(title,abbr,startDate,endDate,season));

                                        //Log.i("hllhjgjhgjgkjgk",name);

                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                madapter = new compitionAdapter(newActivity.this,mdataList);
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