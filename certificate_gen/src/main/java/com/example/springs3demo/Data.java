/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springs3demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author Manav Rajput
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Data {
    
    
    private String adminCode;
    private String loginToken;
    private String device;
    private String appVersion;
    private String deviceId;
    private String adminId;
    private String clientId;
    private String loginClientId;
    private String checksum;
    private ArrayList<Certificate> data;
    private String type;
    

    public Data(String adminCode, String loginToken, String device, String appVersion, String deviceId, String adminId, String clientId, String loginClientId, String checksum, ArrayList<Certificate> data) {
        this.adminCode = adminCode;
        this.loginToken = loginToken;
        this.device = device;
        this.appVersion = appVersion;
        this.deviceId = deviceId;
        this.adminId = adminId;
        this.clientId = clientId;
        this.loginClientId = loginClientId;
        this.checksum = checksum;
        this.data = data;
    }

    
    
    

    public Data() {
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public ArrayList<Certificate> getData() {
        return data;
    }

    public void setData(ArrayList<Certificate> data) {
        this.data = data;
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

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data(String adminCode, String loginToken, String device, String appVersion, String deviceId, String adminId, String clientId, String loginClientId, String checksum, ArrayList<Certificate> data, String type) {
        this.adminCode = adminCode;
        this.loginToken = loginToken;
        this.device = device;
        this.appVersion = appVersion;
        this.deviceId = deviceId;
        this.adminId = adminId;
        this.clientId = clientId;
        this.loginClientId = loginClientId;
        this.checksum = checksum;
        this.data = data;
        this.type = type;
    }
    
    
    
    
}
