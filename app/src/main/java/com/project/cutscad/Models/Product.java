package com.project.cutscad.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Product {

    private Date purchaseDate;
    private Date expirationDate;
    private Integer lifespan;
    private Double weight;

    public Product(Date purchaseDate, Integer lifespan, Double weight) {
        this.purchaseDate = purchaseDate;
        setExpirationDate(lifespan);
        this.lifespan = lifespan;
        this.weight = weight;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Integer getLifespan() {
        return lifespan;
    }

    public Double getWeight() {
        return weight;
    }

    public void setExpirationDate(Integer lifespan) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(purchaseDate);
        calendar.add(Calendar.DAY_OF_YEAR, lifespan);
        expirationDate = calendar.getTime();
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    public String writeDate(Date date) {
        DateFormat format = new SimpleDateFormat("dd MMM yyyy");
        return format.format(date);
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

    public String writeLifespan(Integer lifespan, Frequency productFrequency) {
        String frequency = productFrequency.toString().toLowerCase();

        if (lifespan == 1) {
            return lifespan + " " + frequency;
        } else {
            return lifespan + " " + frequency + "s";
        }
    }

    public String writeWeight() {
        return weight.toString() + " kg";
    }

    public String writeRemainingDays() {
        long milliseconds = Calendar.getInstance().getTimeInMillis() - purchaseDate.getTime();
        long days = lifespan - TimeUnit.MILLISECONDS.toDays(milliseconds);
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
}
