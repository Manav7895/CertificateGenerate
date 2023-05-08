/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springs3demo;

/**
 *
 * @author Manav Rajput
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import org.springframework.stereotype.Component;

//@Entity
//@Table(name="Certificate")
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Certificate1 implements Serializable{
    private String certificateId;
    private String certificateName;
    private String certificateType;
    private String content;
    private String logo;
    private String username;
    private String designation;
    private String date;
    private String period;
    private String departmentText;
    private String signature;
    private String subType;
    private String action;
    private String adminCode;
    private String loginToken;
    private String device;
    private String appVersion;
    private String deviceId;
    private String adminID;
    private String clientId;
    private String loginClientId;
    private String imagedecode;
    private String imageencode;
  

    // add getters and setters for all properties

    public Certificate1() {
        super();
    }

    public Certificate1(String certificateId, String certificateName, String certificateType, String content, String logo, String username, String designation, String date, String period, String departmentText, String signature, String subType, String action, String adminCode, String loginToken, String device, String appVersion, String deviceId, String adminID, String clientId, String loginClientId, String imagedecode, String imageencode) {
        this.certificateId = certificateId;
        this.certificateName = certificateName;
        this.certificateType = certificateType;
        this.content = content;
        this.logo = logo;
        this.username = username;
        this.designation = designation;
        this.date = date;
        this.period = period;
        this.departmentText = departmentText;
        this.signature = signature;
        this.subType = subType;
        this.action = action;
        this.adminCode = adminCode;
        this.loginToken = loginToken;
        this.device = device;
        this.appVersion = appVersion;
        this.deviceId = deviceId;
        this.adminID = adminID;
        this.clientId = clientId;
        this.loginClientId = loginClientId;
        this.imagedecode = imagedecode;
        this.imageencode = imageencode;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDepartmentText() {
        return departmentText;
    }

    public void setDepartmentText(String departmentText) {
        this.departmentText = departmentText;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getLoginClientId() {
        return loginClientId;
    }

    public void setLoginClientId(String loginClientId) {
        this.loginClientId = loginClientId;
    }

    public String getImagedecode() {
        return imagedecode;
    }

    public void setImagedecode(String imagedecode) {
        this.imagedecode = imagedecode;
    }

    public String getImageencode() {
        return imageencode;
    }

    public void setImageencode(String imageencode) {
        this.imageencode = imageencode;
    }

    
      
}
