package com.mpewpazi.android.awaljunisidang.model;

import java.util.Date;

/**
 * Created by mpewpazi on 6/1/16.
 */
public class Notification {
    private int idNotification;
    private String userId;
    private String fromUserId;
    private Date notifyDate;
    private String notifyMessage;
    private String notifyTitle;
    private String notifyStatus;

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Date getNotifyDate() {
        return notifyDate;
    }

    public void setNotifyDate(Date notifyDate) {
        this.notifyDate = notifyDate;
    }

    public String getNotifyMessage() {
        return notifyMessage;
    }

    public void setNotifyMessage(String notifyMessage) {
        this.notifyMessage = notifyMessage;
    }

    public String getNotifyTitle() {
        return notifyTitle;
    }

    public void setNotifyTitle(String notifyTitle) {
        this.notifyTitle = notifyTitle;
    }

    public String getNotifyStatus() {
        return notifyStatus;
    }

    public void setNotifyStatus(String notifyStatus) {
        this.notifyStatus = notifyStatus;
    }
}
