package com.application.model;

public class NotificationMessage {

    String primaryHeader;
    String subHeader;
    String mainMessage;


    public NotificationMessage() {

    }

    public NotificationMessage(String primaryHeader, String subHeader, String mainMessage) {
        this.primaryHeader = primaryHeader;
        this.subHeader = subHeader;
        this.mainMessage = mainMessage;
    }

    public String getPrimaryHeader() {
        return primaryHeader;
    }

    public void setPrimaryHeader(String primaryHeader) {
        this.primaryHeader = primaryHeader;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public String getMainMessage() {
        return mainMessage;
    }

    public void setMainMessage(String mainMessage) {
        this.mainMessage = mainMessage;
    }
}
