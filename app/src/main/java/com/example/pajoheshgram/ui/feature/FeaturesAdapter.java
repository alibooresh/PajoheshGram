package com.example.pajoheshgram.ui.feature;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeaturesAdapter extends RecyclerView.Adapter<FeaturesAdapter.FeatureViewHolder> {

    private List<String> features;

    public FeaturesAdapter(List<String> features) {
        this.features = features;
    }

    @NonNull
    @Override
    public FeatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new FeatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeatureViewHolder holder, int position) {
        holder.featureText.setText(features.get(position));
    }

    @Override
    public int getItemCount() {
        return features.size();
    }

    static class FeatureViewHolder extends RecyclerView.ViewHolder {
        TextView featureText;

        public FeatureViewHolder(@NonNull View itemView) {
            super(itemView);
            featureText = itemView.findViewById(android.R.id.text1);
        }
    }
}
