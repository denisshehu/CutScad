package com.project.cutscad.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Product {

    private Date purchaseDate;
    private Date expirationDate;
    private Integer lifespanInDays;
    private Double weight;

    public Product(Date purchaseDate, Integer lifespan, Frequency frequency, Double weight) {
        this.purchaseDate = purchaseDate;
        lifespanInDays = initialLifespan(lifespan, frequency);
        setExpirationDate();
        this.weight = weight;
    }

    public Product(Date purchaseDate, Integer lifespan, Frequency frequency) {
        this.purchaseDate = purchaseDate;
        lifespanInDays = initialLifespan(lifespan, frequency);
        setExpirationDate();
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Integer getLifespanInDays() {
        return lifespanInDays;
    }

    public Double getWeight() {
        return weight;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(purchaseDate);
        calendar.add(Calendar.DAY_OF_YEAR, lifespanInDays);
        expirationDate = calendar.getTime();
    }

    public void setLifespanInDays(Integer lifespanInDays) {
        this.lifespanInDays = lifespanInDays;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer initialLifespan(Integer lifespan, Frequency frequency) {
        if (frequency == Frequency.WEEK) {
            return 7 * lifespan;
        }

        return lifespan;
    }

    public String writeDate(Date date) {
        DateFormat format = new SimpleDateFormat("dd MMM yyyy");
        return format.format(date);
    }

    public String fillPurchaseField() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(purchaseDate);
    }

    public String fillWeightField() {
        return weight.toString();
    }

    public String writePassedDays() {
        Long milliseconds = Calendar.getInstance().getTimeInMillis() - purchaseDate.getTime();
        String days = Long.toString(TimeUnit.MILLISECONDS.toDays(milliseconds));

        if (days.equals("0")) {
            return "today";
        } else if (days.equals("1")) {
            return "yesterday";
        } else {
            return days + " days ago";
        }
    }

    public String writeLifespan() {
        if (lifespanInDays == 1) {
            return "1 day";
        } else {
            return lifespanInDays + " days";
        }
    }

    public String writeWeight() {
        if (weight == null) {
                return "NaN";
        }

        return weight.toString() + " kg";
    }

    public String writeRemainingDays() {
        long milliseconds = Calendar.getInstance().getTimeInMillis() - purchaseDate.getTime();
        long days = lifespanInDays - TimeUnit.MILLISECONDS.toDays(milliseconds);
        if (days < 0) {
            return "0";
        } else {
            return Long.toString(days);
        }
    }

    public String writeDaysText(String remainingDays) {
        if (remainingDays.equals("1")) {
            return "day";
        } else {
            return "days";
        }
    }

    public void incrementLifespan() {
        lifespanInDays += 1;
    }

    public void decrementLifespan() {
        lifespanInDays -= 1;
    }
}
