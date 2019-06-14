package com.project.cutscad.Models;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Product {

    private Date purchaseDate;
    private Date expirationDate;
    private Double weight;

    public Product(Date purchaseDate, Date expirationDate, Double weight) {
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getPassedDays() {
        Long milliseconds = purchaseDate.getTime() - Calendar.getInstance().getTimeInMillis();
        Long days = TimeUnit.MILLISECONDS.toDays(milliseconds);
        return days.intValue();
    }

    public Integer getRemainingDays() {
        Long milliseconds = expirationDate.getTime() - Calendar.getInstance().getTimeInMillis();
        Long days = TimeUnit.MILLISECONDS.toDays(milliseconds);
        return days.intValue();
    }
}
