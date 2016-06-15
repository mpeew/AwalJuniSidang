package com.mpewpazi.android.awaljunisidang.modelExtras;

import java.util.Date;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class User {
    private String userId;
    private String codeId;
    private String type;
    private String fullName;
    private int companyName;
    private String email;
    private String password;
    private String securityCode;
    private String secretQuestion;
    private String answerSecretQuestion;
    private int isReset;
    private String resetCode;
    private int isActivated;
    private Date createdDate;
    private String ipAddresCreated;
    private int hitCount;
    private Date lastLogin;
    private Date lastLogout;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCompanyName() {
        return companyName;
    }

    public void setCompanyName(int companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getAnswerSecretQuestion() {
        return answerSecretQuestion;
    }

    public void setAnswerSecretQuestion(String answerSecretQuestion) {
        this.answerSecretQuestion = answerSecretQuestion;
    }

    public int getIsReset() {
        return isReset;
    }

    public void setIsReset(int isReset) {
        this.isReset = isReset;
    }

    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public int getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(int isActivated) {
        this.isActivated = isActivated;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getIpAddresCreated() {
        return ipAddresCreated;
    }

    public void setIpAddresCreated(String ipAddresCreated) {
        this.ipAddresCreated = ipAddresCreated;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(Date lastLogout) {
        this.lastLogout = lastLogout;
    }
}
