package com.example.cercher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultsAdapter extends RecyclerView.Adapter{
    Context mContext;
    ArrayList<String> mList;
    ResultsAdapter(Context context, ArrayList<String> list) {
        mContext = context;
        mList = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.result_view, null);
        return new ResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ResultsViewHolder)holder).bind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
