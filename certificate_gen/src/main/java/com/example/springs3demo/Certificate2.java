package com.example.springs3demo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Manav Rajput
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.stereotype.Component;


//@Entity
//@Table(name="Certificate")
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Certificate2 implements Serializable{
    private int autoId;
    private String userName;
    private String certificateName;
    private String campaignName;
    private String email;
    private String cc;
    private String bcc;
    private String personelMsg;
    private String messageFrom;
    private String countryCode;
    private String number;
    private String certificateImg;
    private String certificateId;
    private CertificateArr certificateArr;
    private ArrayList<Certificate> certificates;
    private String JsonFilePath;
    private String Certificatepdf;
    private String campaignType;
    private String sendCertificate;
    private String rewardResource;
    private String clientId;
    private String adminId;
    private String autoNotify;
    private String notifyOn;
    private String img_name;
    private String setCertificate;
    private ArrayList<Certificate> data;   
    
    private String dataType;
    private String adminCode;
    private String loginToken;
    private String device;
    private String appVersion;
    private String deviceId;
//    private String adminId;
//    private String clientId;
    private String loginClientId;
    private String checksum;
    private String type;
    
       public Certificate2(ArrayList<Certificate> certificates, String JsonFilePath) {
        this.certificates = certificates;
        this.JsonFilePath = JsonFilePath;
        this.img_name = img_name;
    }



   
    
    
    // constructor, getter and setter methods for the fields

    public static class CertificateArr implements Serializable{
        private String certificateName;
        private String certificateId;
        private String image;
        private String img_name;
        
        
        // constructor, getter and setter methods for the fields

        public String getCertificateName() {
            return certificateName;
        }

        public void setCertificateName(String certificateName) {
            this.certificateName = certificateName;
        }

        public String getCertificateId() {
            return certificateId;
        }

        public void setCertificateId(String certificateId) {
            this.certificateId = certificateId;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImg_name() {
            return img_name;
        }

        public void setImg_name(String img_name) {
            this.img_name = img_name;
        }
        
        
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getPersonelMsg() {
        return personelMsg;
    }

    public void setPersonelMsg(String personelMsg) {
        this.personelMsg = personelMsg;
    }

    public String getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(String messageFrom) {
        this.messageFrom = messageFrom;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCertificateImg() {
        return certificateImg;
    }

    public void setCertificateImg(String certificateImg) {
        this.certificateImg = certificateImg;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public CertificateArr getCertificateArr() {
        return certificateArr;
    }

    public void setCertificateArr(CertificateArr certificateArr) {
        this.certificateArr = certificateArr;
    }

    public ArrayList<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(ArrayList<Certificate> certificates) {
        this.certificates = certificates;
    }

    public String getJsonFilePath() {
        return JsonFilePath;
    }

    public void setJsonFilePath(String JsonFilePath) {
        this.JsonFilePath = JsonFilePath;
    }

    public String getCertificatepdf() {
        return Certificatepdf;
    }

    public void setCertificatepdf(String Certificatepdf) {
        this.Certificatepdf = Certificatepdf;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    public String getSendCertificate() {
        return sendCertificate;
    }

    public void setSendCertificate(String sendCertificate) {
        this.sendCertificate = sendCertificate;
    }

    public String getRewardResource() {
        return rewardResource;
    }

    public void setRewardResource(String rewardResource) {
        this.rewardResource = rewardResource;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAutoNotify() {
        return autoNotify;
    }

    public void setAutoNotify(String autoNotify) {
        this.autoNotify = autoNotify;
    }

    public String getNotifyOn() {
        return notifyOn;
    }

    public void setNotifyOn(String notifyOn) {
        this.notifyOn = notifyOn;
    }

   
    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public String getSetCertificate() {
        return setCertificate;
    }

    public void setSetCertificate(String setCertificate) {
        this.setCertificate = setCertificate;
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

    public String getLoginClientId() {
        return loginClientId;
    }

    public void setLoginClientId(String loginClientId) {
        this.loginClientId = loginClientId;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Certificate2(int autoId, String userName, String certificateName, String campaignName, String email, String cc, String bcc, String personelMsg, String messageFrom, String countryCode, String number, String certificateImg, String certificateId, CertificateArr certificateArr, ArrayList<Certificate> certificates, String JsonFilePath, String Certificatepdf, String campaignType, String sendCertificate, String rewardResource, String clientId, String adminId, String autoNotify, String notifyOn, String img_name, String setCertificate, ArrayList<Certificate> data, String dataType, String adminCode, String loginToken, String device, String appVersion, String deviceId, String loginClientId, String checksum, String type) {
        this.autoId = autoId;
        this.userName = userName;
        this.certificateName = certificateName;
        this.campaignName = campaignName;
        this.email = email;
        this.cc = cc;
        this.bcc = bcc;
        this.personelMsg = personelMsg;
        this.messageFrom = messageFrom;
        this.countryCode = countryCode;
        this.number = number;
        this.certificateImg = certificateImg;
        this.certificateId = certificateId;
        this.certificateArr = certificateArr;
        this.certificates = certificates;
        this.JsonFilePath = JsonFilePath;
        this.Certificatepdf = Certificatepdf;
        this.campaignType = campaignType;
        this.sendCertificate = sendCertificate;
        this.rewardResource = rewardResource;
        this.clientId = clientId;
        this.adminId = adminId;
        this.autoNotify = autoNotify;
        this.notifyOn = notifyOn;
        this.img_name = img_name;
        this.setCertificate = setCertificate;
        this.data = data;
        this.dataType = dataType;
        this.adminCode = adminCode;
        this.loginToken = loginToken;
        this.device = device;
        this.appVersion = appVersion;
        this.deviceId = deviceId;
        this.loginClientId = loginClientId;
        this.checksum = checksum;
        this.type = type;
    }

    public Certificate2() {
        super();
    }
}

