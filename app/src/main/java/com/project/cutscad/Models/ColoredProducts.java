package com.project.cutscad.Models;

import java.util.ArrayList;

public class ColoredProducts {

    private String redProducts;
    private String redPercentage;
    private String orangeProducts;
    private String orangePercentage;
    private String greenProducts;
    private String greenPercentage;

    public ColoredProducts(ArrayList<Product> products, Integer lifespan) {
        Product product;
        double remainingDays;
        int totalProducts = products.size();

        Double red = 0.0;
        Double redPercent;
        Double orange = 0.0;
        Double orangePercent;
        Double green = 0.0;
        Double greenPercent;

        for (int i = 0; i < products.size(); i++) {
            product = products.get(i);
            remainingDays = Double.parseDouble(product.writeRemainingDays());

            if (remainingDays < 2.0) {
                red++;
            } else if (remainingDays / lifespan.doubleValue() <= 0.5) {
                orange++;
            } else {
                green++;
            }
        }

        redPercent = (red * 100) / totalProducts;
        orangePercent = (orange * 100) / totalProducts;
        greenPercent = (green * 100) / totalProducts;

        redProducts = Integer.toString(red.intValue());
        redPercentage = redPercent.intValue() + "%";
        orangeProducts = Integer.toString(orange.intValue());
        orangePercentage = orangePercent.intValue() + "%";
        greenProducts = Integer.toString(green.intValue());
        greenPercentage = greenPercent.intValue() + "%";
    }

    public String getRedProducts() {
        return redProducts;
    }

    public String getRedPercentage() {
        return redPercentage;
    }

    public String getOrangeProducts() {
        return orangeProducts;
    }

    public String getOrangePercentage() {
        return orangePercentage;
    }

    public String getGreenProducts() {
        return greenProducts;
    }

    public String getGreenPercentage() {
        return greenPercentage;
    }
}
