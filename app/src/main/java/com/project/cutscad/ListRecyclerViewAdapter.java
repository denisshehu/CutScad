package com.project.cutscad;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.cutscad.Models.ColoredProducts;
import com.project.cutscad.Models.ProductList;

import java.util.ArrayList;

public class ListRecyclerViewAdapter extends
        RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder> {

    private ArrayList<ProductList> lists;
    private Context context;

    public ListRecyclerViewAdapter(ArrayList<ProductList> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_card,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ProductList productList = lists.get(i);
        final String listName = productList.getListName();
        final ColoredProducts filteredProducts = productList.filterProducts();

        viewHolder.listName.setText(listName);
        viewHolder.redProducts.setText(filteredProducts.getRedProducts());
        viewHolder.redPercentage.setText(filteredProducts.getRedPercentage());
        viewHolder.orangeProducts.setText(filteredProducts.getOrangeProducts());
        viewHolder.orangePercentage.setText(filteredProducts.getOrangePercentage());
        viewHolder.greenProducts.setText(filteredProducts.getGreenProducts());
        viewHolder.greenPercentage.setText(filteredProducts.getGreenPercentage());

        viewHolder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, PopUpListActivity.class));
                PopUpListActivity.update(productList, true);
            }
        });

        viewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, PopUpDeleteActivity.class));
                PopUpDeleteActivity.productListInformation(productList, true);
            }
        });

        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ProductActivity.class));
                ProductActivity.setInformation(productList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView listName;
        TextView redProducts;
        TextView redPercentage;
        TextView orangeProducts;
        TextView orangePercentage;
        TextView greenProducts;
        TextView greenPercentage;
        ImageButton editButton;
        ImageButton deleteButton;
        LinearLayout card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listName = itemView.findViewById(R.id.productName);
            redProducts = itemView.findViewById(R.id.redProducts);
            redPercentage = itemView.findViewById(R.id.redPercentageValue);
            orangeProducts = itemView.findViewById(R.id.orangeProducts);
            orangePercentage = itemView.findViewById(R.id.orangePercentageValue);
            greenProducts = itemView.findViewById(R.id.greenProducts);
            greenPercentage = itemView.findViewById(R.id.greenPercentageValue);
            editButton = itemView.findViewById(R.id.editButtonListCard);
            deleteButton = itemView.findViewById(R.id.deleteButtonProductCard);
            card = itemView.findViewById(R.id.productListCard);
        }
    }
}
