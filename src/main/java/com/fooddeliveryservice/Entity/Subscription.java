package com.fooddeliveryservice.Entity;

import javax.persistence.*;

@Entity(name="subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String subscriptionType;
    private int numberOfMealsAllowed;
    private double subscriptionFee;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public int getNumberOfMealsAllowed() {
        return numberOfMealsAllowed;
    }

    public void setNumberOfMealsAllowed(int numberOfMealsAllowed) {
        this.numberOfMealsAllowed = numberOfMealsAllowed;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", numberOfMealsAllowed=" + numberOfMealsAllowed +
                ", subscriptionFee=" + subscriptionFee +
                ", description='" + description + '\'' +
                '}';
    }
}
