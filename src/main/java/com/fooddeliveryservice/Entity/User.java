package com.fooddeliveryservice.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

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
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address addressId;
    private String emailAddress;
    private String phoneNumber;
    private java.sql.Timestamp lastLogin;
    private java.sql.Timestamp lastOrder;
    @OneToOne
    @JoinColumn(name = "subscriptionId")
    private Subscription subscriptionId;

    public User(){
    }

    public User(String firstName, String lastName, String userName, String userPassword, Role role, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.role = role;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(Timestamp lastOrder) {
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", role=" + role +
                ", addressId=" + addressId +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastLogin=" + lastLogin +
                ", lastOrder=" + lastOrder +
                ", subscriptionId=" + subscriptionId +
                '}';
    }
}
