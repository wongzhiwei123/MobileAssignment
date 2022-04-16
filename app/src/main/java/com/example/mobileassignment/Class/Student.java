package com.example.mobileassignment.Class;

public class Student {
    String userName;
    String phoneNumber;
    String bookingDate;
    String bookingTime;
    String image;

    public Student() {
    }

    public Student(String userName, String phoneNumber, String bookingDate, String bookingTime, String image) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
