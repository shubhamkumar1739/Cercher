package com.example.cercher.Requests;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSONObjectRequest {
    Context mContext;
    public JSONObjectRequest( Context context) {
        mContext = context;
    }
    public void makeRequest(String url, JSONRequestResponseListener listener) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            listener.onResponse(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Error");
                        Toast.makeText(mContext, "Error " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestSingleton.getInstance(mContext).addToRequestQueue(jsonObjectRequest);
    }
}
