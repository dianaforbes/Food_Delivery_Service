package com.fooddeliveryservice.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    private User user;
    private String firstName;
    private String lastName;
    private String userName;
    private String userPassword;
    private String permission;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address addressId;
    private String emailAddress;
    private String phoneNumber;
    java.sql.Date lastLogin;
    java.sql.Date lastOrder;
    @OneToOne
    @JoinColumn(name = "subscriptionId")
    private Subscription subscriptionId;
//    public User getUser() {
//        return user;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(Date lastOrder) {
        this.lastOrder = lastOrder;
    }

    public Subscription getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Subscription subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
//                ", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", permission='" + permission + '\'' +
                ", addressId=" + addressId +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastLogin=" + lastLogin +
                ", lastOrder=" + lastOrder +
                ", subscriptionId=" + subscriptionId +
                '}';
    }
}
