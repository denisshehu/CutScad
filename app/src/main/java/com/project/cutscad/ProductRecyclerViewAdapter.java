package com.project.cutscad;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.cutscad.Models.Product;
import com.project.cutscad.Models.ProductList;

public class ProductRecyclerViewAdapter extends
        RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {

    static private ProductList products;
    private Context context;

    public ProductRecyclerViewAdapter(ProductList productList, Context context) {
        products = productList;
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

        final Product product = products.getProducts().get(i);
        final TextView purchaseDate = viewHolder.purchaseDate;
        final TextView expirationDate = viewHolder.expirationDate;
        final TextView passedDays = viewHolder.passedDays;
        final TextView lifespan = viewHolder.lifespan;
        final TextView weightText = viewHolder.weightText;
        final TextView weight = viewHolder.weight;
        final TextView remainingDays = viewHolder.remainingDays;
        final TextView daysText = viewHolder.daysText;
        final Button throwButton = viewHolder.throwButton;
        final Button editButton = viewHolder.editButton;
        final LinearLayout cardColor = viewHolder.cardColor;
        final ImageButton addDaysButton = viewHolder.addDaysButton;
        final ImageButton subtractDaysButton = viewHolder.subtractDaysButton;

        displayInformation(product, purchaseDate, expirationDate, passedDays, lifespan, weightText,
                weight, remainingDays, daysText, cardColor);

        throwButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, PopUpDeleteActivity.class));
                PopUpDeleteActivity.productInformation(product);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, PopUpProductActivity.class));
                PopUpProductActivity.update(product);
            }
        });

        checkSubtractButtonVisibility(product.writeRemainingDays(), subtractDaysButton);

        addDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.incrementLifespan();
                System.out.println(product.getLifespanInDays());
                product.setExpirationDate();
                displayInformation(product, purchaseDate, expirationDate, passedDays, lifespan,
                        weightText, weight, remainingDays, daysText, cardColor);
                checkSubtractButtonVisibility(product.writeRemainingDays(), subtractDaysButton);
            }
        });

        subtractDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.decrementLifespan();
                System.out.println(product.getLifespanInDays());
                product.setExpirationDate();
                displayInformation(product, purchaseDate, expirationDate, passedDays, lifespan,
                        weightText, weight, remainingDays, daysText, cardColor);
                checkSubtractButtonVisibility(product.writeRemainingDays(), subtractDaysButton);
            }
        });
    }

    private void displayInformation(Product product, TextView purchaseDate, TextView expirationDate,
                                    TextView passedDays, TextView lifespan, TextView weightText,
                                    TextView weight, TextView remainingDays, TextView daysText,
                                    LinearLayout cardColor) {
        String daysRemaining = product.writeRemainingDays();
        Double daysRemainingD = Double.valueOf(daysRemaining);

        purchaseDate.setText(product.writeDate(product.getPurchaseDate()));
        expirationDate.setText(product.writeDate(product.getExpirationDate()));
        passedDays.setText(product.writePassedDays());
        lifespan.setText(product.writeLifespan());
        weight.setText(product.writeWeight());
        checkWeightVisibility(weightText, weight, weight.getText().toString());

        remainingDays.setText(daysRemaining);
        daysText.setText(product.writeDaysText(daysRemaining));

        if (daysRemainingD < 2.0) {
            cardColor.setBackgroundResource(R.drawable.red_right_panel);
        } else if (daysRemainingD / product.getLifespanInDays().doubleValue() <= 0.5) {
            cardColor.setBackgroundResource(R.drawable.orange_right_panel);
        } else {
            cardColor.setBackgroundResource(R.drawable.green_right_panel);
        }
    }

    private void checkSubtractButtonVisibility(String daysRemaining,
                                               ImageButton subtractDaysButton) {
        if (daysRemaining.equals("0")) {
            subtractDaysButton.setVisibility(View.INVISIBLE);
            subtractDaysButton.setClickable(false);
        } else {
            subtractDaysButton.setVisibility(View.VISIBLE);
            subtractDaysButton.setClickable(true);
        }
    }

    public void checkWeightVisibility(TextView weightText, TextView weight, String weightValue) {
        if (weightValue.equals("NaN")) {
            weightText.setVisibility(View.GONE);
            weight.setVisibility(View.GONE);
        } else {
            weightText.setVisibility(View.VISIBLE);
            weight.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return products.getProducts().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView purchaseDate;
        TextView expirationDate;
        TextView passedDays;
        TextView lifespan;
        TextView weightText;
        TextView weight;
        TextView remainingDays;
        TextView daysText;
        Button throwButton;
        Button editButton;
        LinearLayout cardColor;
        ImageButton addDaysButton;
        ImageButton subtractDaysButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            purchaseDate = itemView.findViewById(R.id.purchaseDate);
            expirationDate = itemView.findViewById(R.id.expirationDate);
            passedDays = itemView.findViewById(R.id.passedDays);
            lifespan = itemView.findViewById(R.id.lifespanValue);
            weightText = itemView.findViewById(R.id.weightText);
            weight = itemView.findViewById(R.id.weightValue);
            remainingDays = itemView.findViewById(R.id.remainingDays);
            daysText = itemView.findViewById(R.id.daysText);
            throwButton = itemView.findViewById(R.id.throwButton);
            editButton = itemView.findViewById(R.id.editButtonProductCard);
            cardColor = itemView.findViewById(R.id.rightProductCard);
            addDaysButton = itemView.findViewById(R.id.addDaysButton);
            subtractDaysButton = itemView.findViewById(R.id.subtractDaysButton);
        }
    }
}
