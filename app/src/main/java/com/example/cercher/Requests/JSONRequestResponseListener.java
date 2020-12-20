package com.example.cercher.Requests;

import org.json.JSONException;
import org.json.JSONObject;

public interface JSONRequestResponseListener {
    void onResponse(JSONObject obj) throws JSONException;
}
