package com.example.feedbackapp.FeedbackList;

public class FeedbackData {

    private String id;
    private String fullname;
    private String email;
    private String phone;
    private String feedback;

    public FeedbackData(String id, String fullname, String email, String phone, String feedback) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.feedback = feedback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
