package com.example.cercher;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ResultsViewHolder extends RecyclerView.ViewHolder {
    TextView mName;
    public ResultsViewHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.name);
    }

    public void bind(String filename) {
        mName.setText(filename);
    }
}
