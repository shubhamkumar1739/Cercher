package com.example.cercher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cercher.Requests.JSONObjectRequest;
import com.example.cercher.Requests.JSONRequestResponseListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button m_SearchButton;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        m_SearchButton = findViewById(R.id.searchBtn);
        editText = findViewById(R.id.search_text);

        m_SearchButton.setOnClickListener(v -> {
            String text = editText.getText().toString();
            JSONObjectRequest request = new JSONObjectRequest(MainActivity.this);
            request.makeRequest("http://192.168.43.253:5000/search?results="+text, new JSONRequestResponseListener() {
                @Override
                public void onResponse(JSONObject obj) {
                    Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
                    intent.putExtra("results", obj.toString());
                    startActivity(intent);
                }
            });
        });
    }
}