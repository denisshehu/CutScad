package com.project.cutscad;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductRecyclerViewAdapter extends
        RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {

    private ArrayList<ArrayList<String>> data = new ArrayList<>();
    private Context context;

    public ProductRecyclerViewAdapter(ArrayList<ArrayList<String>> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_card,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final TextView remainingDays = viewHolder.remainingDays;
        Button addDaysButton = viewHolder.addDaysButton;
        Button subtractDaysButton = viewHolder.subtractDaysButton;

        viewHolder.purchaseDate.setText(data.get(i).get(0));
        viewHolder.expirationDate.setText(data.get(i).get(1));
        viewHolder.daysAgo.setText(data.get(i).get(2));
        viewHolder.lifespan.setText(data.get(i).get(3));
        viewHolder.weight.setText(data.get(i).get(4));
        remainingDays.setText(data.get(i).get(5));
        viewHolder.daysText.setText(data.get(i).get(6));

        if (Integer.parseInt(remainingDays.getText().toString()) == 0) {
            subtractDaysButton.setVisibility(View.INVISIBLE);
        } else {
            subtractDaysButton.setVisibility(View.VISIBLE);
        }

        addDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newValue = Integer.parseInt(remainingDays.getText().toString()) + 1;
                remainingDays.setText(newValue);
            }
        });

        subtractDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newValue = Integer.parseInt(remainingDays.getText().toString()) - 1;
                remainingDays.setText(newValue);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView purchaseDate;
        TextView expirationDate;
        TextView daysAgo;
        TextView lifespan;
        TextView weight;
        TextView remainingDays;
        TextView daysText;

        Button addDaysButton;
        Button subtractDaysButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            purchaseDate = itemView.findViewById(R.id.purchaseDate);
            expirationDate = itemView.findViewById(R.id.expirationDate);
            daysAgo = itemView.findViewById(R.id.daysAgo);
            lifespan = itemView.findViewById(R.id.lifespanValue);
            weight = itemView.findViewById(R.id.weightValue);
            remainingDays = itemView.findViewById(R.id.remainingDays);
            daysText = itemView.findViewById(R.id.daysText);

            addDaysButton = itemView.findViewById(R.id.addDaysButton);
            subtractDaysButton = itemView.findViewById(R.id.subtractDaysButton);
        }
    }
}
