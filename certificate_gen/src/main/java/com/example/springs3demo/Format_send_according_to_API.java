/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springs3demo;

/**
 *
 * @author benepik
 */
public class Format_send_according_to_API {
    
        //1) This below format in encryption form of this preview API http://localhost:8080/certificate/preview  
        
        //{
        //    "checksum": "U2FsdGVkX18rnCRLrL7MFKuI9+JpeCXg3JFkTTUkC+jILD3Tt3Nif7OjfghpkdaN/grpWtnTXaKG+WfL3ecqydV92DjivoGXlB2DFGluN+X6rm8QEe/leZrJQtOAT4s9EeGqqJ+ieaZe2rLfrHB9S4bPL9VGSqJeib4XT95nq2L9D77JgYfvialH3Ratl+vlG3Nu94AcefDUSFmaracAdwBb1tcUfejevB1gOEOlgUDSG4zCemjFJCIysOiTn8JEoUROJD+4ylpH+Lmb6dZzFx3ePB7hccIouj1sWizq0PFatjGTs8YEmxjT0f5NWwSTR5expYZXBqxjjD5xCrBzRhMFsdzMUMfqWXP55ZF3jEAxzR7QHvsiwR8uGR0KhbIhrehDcmOHU/FZckFBLO/gl3btfYqZEgls//GKyLy78rk8tfGMCOQWLAjmZHI5gkMid9CCzYhahNO0d8RMEtqLpSqsuIm8XcG8bf9vSqdytxZvsrUc1HxpV3oe3prylh59VBo6KyGvEBwa1ijkrD+sLWo/3JwFgZ5wqPqk9T5n4KMhxzdic1VT5Fgw+m/ZSZ+cJW85zTo8LaflXZI8Lujy83zGEdTuq6mOv3GsdjWwYcuRbmWsxe8uS8qRJ2tacN7r"
        //}
        
                
        //if we decrypt the encryption form look like this 
    
        //{
        //    "certificateId": "71",
        //    "certificateName": "xcvzcvvcx",
        //    "certificateType": "12",
        //    "content": "",
        //    "logo": "",
        //    "username": "",
        //    "designation": "",
        //    "date": "",
        //    "period": "2001-06-30",
        //    "departmentText": "",
        //    "signature": "",
        //    "subType": "D",
        //    "action": "1",
        //    "imagedecode": "CERTIFICATE_II_2",
        //    "imageencode": "",
        //    "adminCode": "649",
        //    "loginToken": "sdasdasdascswdwefasasdsad84ASAs",
        //    "device": "1",
        //    "appVersion": "1",
        //    "deviceId": "browser",
        //    "adminID": "1058",
        //    "clientId": "649",
        //    "loginClientId": "649"
        //}
    
        // 2) This below format in encryption form if we hit the api then we used the encryotion form of data and then hit data API http://localhost:8080/certificate/data
    
    //{
   //   "checksum": "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"
    //}
            
//        If we decrypt the Encrypt data so look like this 
    
    
    
        //{
        //    "data": [
        //        {
        //            "autoId": 1,
        //            "userName": "Manav Rajput",
        //            "email": "ManavRaput@gmail.com",
        //            "cc": "ManavRaput1@gmail.com",
        //            "bcc": "ManavRaput12@gmail.com",
        //            "number": "7895151522",
        //            "countryCode": "91",
        //            "campaignName": "bob1",
        //            "messageFrom": "Manav",
        //            "personelMsg": "Welcome To Java MicroService",
        //            "certificateName": "Man of the Match",
        //            "certificates": null,
        //            "certificatepdf": "",
        //            "setCertificate": "0",
        //            "certificateImg": "",
        //            "campaignType": "649",
        //            "certificateId": "297",
        //            "sendCertificate": "yes",
        //            "rewardResource": "Email",
        //            "autoNotify": "2",
        //            "notifyOn": "email,sms",
        //            "clientId": "649",
        //            "adminId": "1058",
        //            "jsonFilePath": null,
        //            "certificateArr": {
        //                "certificateName": "Trizet",
        //                "certificateId": "1",
        //                "image": "",
        //                "img_name": "bg_certificate1650"
        //            }
        //        },
        //       {
        //            "autoId": 1,
        //            "userName": "Manav Rajput",
        //            "email": "ManavRaput@gmail.com",
        //            "cc": "ManavRaput1@gmail.com",
        //            "bcc": "ManavRaput12@gmail.com",
        //            "number": "7895151522",
        //            "countryCode": "91",
        //            "campaignName": "bob1",
        //            "messageFrom": "Manav",
        //            "personelMsg": "Welcome To Java MicroService",
        //            "certificateName": "Man of the Match",
        //            "certificates": null,
        //            "certificatepdf": "",
        //            "setCertificate": "0",
        //            "certificateImg": "",
        //            "campaignType": "649",
        //            "certificateId": "297",
        //            "sendCertificate": "yes",
        //            "rewardResource": "Email",
        //            "autoNotify": "2",
        //            "notifyOn": "email,sms",
        //            "clientId": "649",
        //            "adminId": "1058",
        //            "jsonFilePath": null,
        //            "certificateArr": {
        //                "certificateName": "Trizet",
        //                "certificateId": "1",
        //                "image": "",
        //                "img_name": "bg_certificate1650"
        //            }
        //        }
        //    ],
        //    "adminCode": "649",
        //    "loginToken": "IJASDIOAFNASJF5154ADFASDFBASDASD74",
        //    "device": "1",
        //    "appVersion": "1",
        //    "deviceId": "browser",
        //    "adminID": "1058",
        //    "clientId": "649",
        //    "dataType": "insert",
        //    "loginClientId": "649",
        //    "type": "certificate"
        //}
    
    
    
        //     3) This below format in decryption form if we hit the api then we used the decryption form of data and then hit data API http://localhost:8080/certificate/data2

    
        //    {
        //    "data": [
        //        {
        //            "autoId": "8484",
        //            "userName": "ManavRajput",
        //            "email": "ManavRajput258@gmail.com",
        //            "cc": null,
        //            "bcc": null,
        //            "messageFrom": "NA",
        //            "personelMsg": "",
        //            "certificateName": "SILVER AWARD",
        //            "certificateSendCheck": "1",
        //            "certificate": null,
        //            "certificateImg": null,
        //            "campaignType": "",
        //            "awardTypeChild": "",
        //            "certificateId": "1",
        //            "rewardResource": "",
        //            "autoNotify": "",
        //            "clientId": "807",
        //            "adminId": "1386",
        //            "certificatepdf": null,
        //            "certificateArr": {
        //                "certificateId": "1",
        //                "certificateName": "SILVER AWARD",
        //                "image": "",
        //                "img_name": "bg_certificate1108"
        //            },
        //            "setCertificate": "0"
        //        },
        //        {
        //            "autoId": "8483",
        //            "userName": "Anmol",
        //            "email": "Anmol@benepik.com",
        //            "cc": null,
        //            "bcc": null,
        //            "messageFrom": "NA",
        //            "personelMsg": "",
        //            "certificateName": "SILVER AWARD",
        //            "certificateSendCheck": "1",
        //            "certificate": null,
        //            "certificateImg": null,
        //            "campaignType": "",
        //            "awardTypeChild": "",
        //            "certificateId": "1",
        //            "rewardResource": "",
        //            "autoNotify": "",
        //            "clientId": "807",
        //            "adminId": "1386",
        //            "certificatepdf": null,
        //            "certificateArr": {
        //                "certificateId": "1",
        //                "certificateName": "SILVER AWARD",
        //                "image": "",
        //                "img_name": "bg_certificate1108"
        //            },
        //            "setCertificate": "0"
        //        }
        //    ],
        //    "adminCode": "807",
        //    "loginToken": "ASDASUDBASF984SDF4SD5F4SD8F4SDFSD51F5",
        //    "device": "1",
        //    "appVersion": "1",
        //    "deviceId": "browser",
        //    "type": "reward",
        //    "adminID": "78965",
        //    "clientId": "8789",
        //    "loginClientId": "847"
        //}
}
