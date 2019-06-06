package com.project.cutscad;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class InventoryRecyclerViewAdapter extends
        RecyclerView.Adapter<InventoryRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> headers = new ArrayList<>();
    private ArrayList<String> redProducts = new ArrayList<>();
    private ArrayList<String> orangeProducts = new ArrayList<>();
    private ArrayList<String> greenProducts = new ArrayList<>();
    private Context context;

    public InventoryRecyclerViewAdapter(ArrayList<String> headers, ArrayList<String> redProducts,
                                        ArrayList<String> orangeProducts,
                                        ArrayList<String> greenProducts, Context context) {
        this.headers = headers;
        this.redProducts = redProducts;
        this.orangeProducts = orangeProducts;
        this.greenProducts = greenProducts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_category_card,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final String headerText = headers.get(i);

        viewHolder.header.setText(headerText);
        viewHolder.redProducts.setText(redProducts.get(i));
        viewHolder.orangeProducts.setText(orangeProducts.get(i));
        viewHolder.greenProducts.setText(greenProducts.get(i));

        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ProductActivity.class));
                ProductActivity.setHeader(headerText);
            }
        });
    }

    @Override
    public int getItemCount() {
        return headers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView header;
        TextView redProducts;
        TextView orangeProducts;
        TextView greenProducts;
        LinearLayout card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.productName);
            redProducts = itemView.findViewById(R.id.redProducts);
            orangeProducts = itemView.findViewById(R.id.orangeProducts);
            greenProducts = itemView.findViewById(R.id.greenProducts);
            card = itemView.findViewById(R.id.productListCard);
        }
    }
}
