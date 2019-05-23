package com.project.cutscad;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView header;
        View separator;
        TextView noProductsText;
        RecyclerView products;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.productListCard);
            header = itemView.findViewById(R.id.productListName);
            separator = itemView.findViewById(R.id.headerSeparatorPUL);
            noProductsText = itemView.findViewById(R.id.noProductsTextInventory);
            products = itemView.findViewById(R.id.recyclerViewList);
        }
    }
}
