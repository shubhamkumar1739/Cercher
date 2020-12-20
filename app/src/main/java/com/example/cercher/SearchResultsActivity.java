package com.example.cercher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    ResultsAdapter adapter;
    ArrayList<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        mList = new ArrayList<>();
        initViews();
        updateRecyclerView();
    }

    private void updateRecyclerView() {
        try {
            String response = getIntent().getStringExtra("results");
            JSONObject obj = new JSONObject(response);
            JSONArray jsonArray = obj.getJSONArray("results");
            for(int i = 0; i < jsonArray.length(); i++) {
                mList.add(jsonArray.get(i).toString());
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(this);
        adapter = new ResultsAdapter(this, mList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}