package com.example.springs3demo;

/**
 *
 * @author Manav Rajput
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
//import java.util.Collections;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/certificate")
public class S3Contoller {
    static int flag=0;
    
    static ArrayList<Certificate> Save = new ArrayList<>();
    static ArrayList<Certificate> Save2 = new ArrayList<>();
    
    private boolean hasBeenCalled = false;
    
    @Autowired
    private Certificate certificate;
    
    @Autowired
    private Data data;
    
    @Autowired
    public RestTemplate restTemplate;

    

 
//This Function upload Certificate in pdf form  on AWS S3 Bucket.
public String handleFileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException{
    
    Map<String, Object> result = new HashMap<>();
    String url = null;
    
    // Set up Your AWS credentials if you upload Generated Certificate on AWS
    String accessKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    String secretKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

    // Create an instance of AmazonS3
    AmazonS3 s3 = AmazonS3ClientBuilder.standard()
            
    //Set Your Amazon region
    .withRegion(Regions.US_EAST_1)
    .withCredentials(new AWSStaticCredentialsProvider(credentials))
    .build();

    // Set the S3 bucket name and path of where you upload it
    String bucketName = "bucketname/path/to/path";
    String key = "" + file.getOriginalFilename();

     
    try {
        // Create a temporary file
        File tempFile = File.createTempFile("temp", ".pdf");

        // Save the uploaded file to the temporary file
        file.transferTo(tempFile);

            
        // Get the S3 object URL
        url = s3.getUrl(bucketName, key).toString();
       
        //Upload the file to S3
        PutObjectRequest request = new PutObjectRequest(bucketName, key, tempFile);
        request.setCannedAcl(CannedAccessControlList.PublicRead);
        s3.putObject(request);

        result.put("url", url);

        tempFile.delete(); 
        
    } catch ( IllegalStateException e) {
        return url;
    }        
    return url;
}


    @CrossOrigin(origins = "*")
    @GetMapping("/healthcheck")
    public String healthCheck() {
         return "{\"status\":true,\"message\":\"Health Check success\"}";
    }

    //This Function upload Certificate in png form  on AWS S3 Bucket.
    @CrossOrigin(origins = "*")   
    @PostMapping("/upload")
    public String handleFileUpload2(@RequestParam(value = "file") MultipartFile file) throws IOException{

        Map<String, Object> result = new HashMap<>();
        String url = null;

        // Set up Your AWS credentials if you upload Generated Certificate on AWS
        String accessKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        String secretKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        // Create an instance of AmazonS3
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()

         //Set Your Amazon region
        .withRegion(Regions.US_EAST_1)
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .build();

        // Set the S3 bucket name and path of where you upload it
        String bucketName = "bucketname/path/to/path";
        String key = "" + file.getOriginalFilename();


        try {
            // Create a temporary file
            File tempFile = File.createTempFile("temp", ".png");

            // Save the uploaded file to the temporary file
            file.transferTo(tempFile);


            // Get the S3 object URL
            url = s3.getUrl(bucketName, key).toString();

            //Upload the file to S3
            PutObjectRequest request = new PutObjectRequest(bucketName, key, tempFile);
            request.setCannedAcl(CannedAccessControlList.PublicRead);
            s3.putObject(request);

            result.put("url", url);

            tempFile.delete(); 

        } catch ( IllegalStateException e) {
            return url;
        }        
        return url;
    }

    //This Function upload Certificate in pdf form  on AWS S3 Bucket and also reduce the size(MB to KB) of Certificate.
    public String handleFileUpload3(@RequestParam(value = "file") MultipartFile file) throws IOException{

        Map<String, Object> result = new HashMap<>();
        String url = null;



        // Set up Your AWS credentials if you upload Generated Certificate on AWS
        String accessKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        String secretKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        // Create an instance of AmazonS3
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()

        //Set Your Amazon region
        .withRegion(Regions.US_EAST_1)
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .build();

        // Set the S3 bucket name and path of where you upload it
        String bucketName = "bucketname/path/to/path";
        String key = "" + file.getOriginalFilename();


        try {

            File tempFile = File.createTempFile("temp", ".png");

            // Save the uploaded file to the temporary file
            file.transferTo(tempFile);

            // Compress the image using ImageIO
            System.out.println("Hello World");
            BufferedImage originalImage = ImageIO.read(tempFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resize(originalImage, originalImage.getWidth()/2, originalImage.getHeight()/2), "png", baos);
            byte[] compressedBytes = baos.toByteArray();

            // Upload the compressed file to S3
            InputStream compressedInputStream = new ByteArrayInputStream(compressedBytes);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(compressedBytes.length);
            metadata.setContentType("image/png");

            PutObjectRequest request = new PutObjectRequest(bucketName, key, compressedInputStream, metadata);
            request.setCannedAcl(CannedAccessControlList.PublicRead);
            s3.putObject(request);

            // Get the S3 object URL
            url = s3.getUrl(bucketName, key).toString();

            // Cleanup temporary file
            tempFile.delete();


        } catch ( IllegalStateException e) {
            return url;
        }        
        return url;
    }
    
    private BufferedImage resize(BufferedImage image, int width, int height) {
        Image tmp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/try")
    public String hey(){
        return "Hello";
    }

    // In the receiveData method of the MyController class
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/data")
    public Map<String, Object> receiveData(@RequestBody Check data1) throws IOException, Exception {
    System.out.println(data1);
    ObjectMapper mapper = new ObjectMapper();
    String jsonData1 = mapper.writeValueAsString(data1);
    String encrypt = jsonData1;
    Map<String, String> map = mapper.readValue(encrypt, Map.class);
    String value1 = map.get("checksum");
    System.out.println(encrypt);
    String decrypted = Encryption.decryptText(value1);
    System.out.println(decrypted);

    String token = null;
    List<Data> dataList = new ArrayList<>();
    
    // Attempt to deserialize the input JSON as a list of Data objects
    try {
        dataList = mapper.readValue(decrypted, new TypeReference<List<Data>>() {});
    } catch (MismatchedInputException e) {
        // If the input JSON is not a list, try to deserialize it as a single Data object
        Data dataObj = mapper.readValue(decrypted, Data.class);
        dataList.add(dataObj);
    }
      String type=null;
    S3Contoller.Save.clear();
    for (Data data2 : dataList) {
        token = data2.getLoginToken();
        List<Certificate> certificates = data2.getData();
        S3Contoller.Save.addAll(certificates);
      
        type=data2.getType();
        // Process the Data object here
        List<String> resultList = new ArrayList<>();
        // manipulate the list of Certificate objects as needed
        for (Certificate certificate : certificates) {
            certificate.setSetCertificate("1");
            int a = Integer.parseInt(certificate.getCertificateArr().getCertificateId());
            List<String> result = ImagePdf.generateImage(certificate.getUserName(), certificate.getAutoId(), a, certificate.getCertificateArr().getImg_name());
            resultList.addAll(result);
        }
        // iterate over the results list and update the Certificate objects as needed
        int x = 0;
        int maxAutoId = 0;
        for (Certificate cert : certificates) {
            if (cert.getAutoId() > maxAutoId) {
                maxAutoId = cert.getAutoId();
                x = maxAutoId;
            }
        }
        System.out.println(x);
    }
    
    System.out.println("This is also list of ImagePdf to check the data "+ImagePdf.Save6);
    Map<String, Object> store = new HashMap<>();
    List<Certificate> data = new ArrayList<>(ImagePdf.Save6);
    Map<String, List<Certificate>> dataMap = new HashMap<>();
    dataMap.put("data", data);
    System.out.println(ImagePdf.Save6);

    // Create a new HashMap to hold the modified list
    Map<String, Object> newData = new HashMap<>();
    newData.put("data", dataMap.get("data"));

    String insert="insert";
    // Add the "data" key to the new HashMap
    newData.put("data", data);
    newData.put("dataType", insert);
    newData.put("type", type );
    newData.put("loginToken", token);

    String json = mapper.writeValueAsString(newData);
    
        //set url where you store the data if you have otherwise ignore it.
    //    String url = "https://benepik.in/bpcp_new/api/v1/storeUploadedJavaCertificateData";
    //    HttpHeaders headers = new HttpHeaders();
    //
    //    headers.setContentType(MediaType.APPLICATION_JSON);
    //    headers.set("loginToken", token);
    //    HttpEntity<String> entity = new HttpEntity<>(json, headers);
    //    System.out.println(headers);
    //    System.out.println(token);
    //    System.out.println(entity);
    //    ResponseEntity<Data> response = restTemplate.exchange(url, HttpMethod.POST, entity, Data.class);
    //    
    //    Data responseBody = response.getBody();
    //      if (response.getStatusCode() == HttpStatus.OK) {
    //        return Collections.singletonMap("message", "Success");
    //    } else {
    //        return Collections.singletonMap("message", "Not success");
    //    }
    return newData;

    }


    @CrossOrigin(origins = "*")
    @PostMapping(value = "/data2")
    public Map<String, Object> receiveData4(@RequestBody Certificate2 data1) throws IOException, Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonData1 = mapper.writeValueAsString(data1);


        String token = null;
        List<Certificate2> dataList = new ArrayList<>();

        // Attempt to deserialize the input JSON as a list of Data objects
        try {
            dataList = mapper.readValue(jsonData1, new TypeReference<List<Certificate2>>() {});
        } catch (MismatchedInputException e) {
            // If the input JSON is not a list, try to deserialize it as a single Data object
            Certificate2 dataObj = mapper.readValue(jsonData1, Certificate2.class);
            dataList.add(dataObj);
        }
        List<Certificate> certificates = data1.getData();
        token=data1.getLoginToken();
        String type=null;
        type=data1.getType();
        String update="update";
        S3Contoller.Save.clear();
        for (Certificate2 data2 : dataList) {
            S3Contoller.Save.addAll(certificates);
            // Process the Data object here
            List<String> resultList = new ArrayList<>();
            // manipulate the list of Certificate objects as needed
            for (Certificate certificate : certificates) {
                certificate.setSetCertificate("1");
                int a = Integer.parseInt(certificate.getCertificateArr().getCertificateId());
                List<String> result = ImagePdf.generateImage(certificate.getUserName(), certificate.getAutoId(), a, certificate.getCertificateArr().getImg_name());
                resultList.addAll(result);
            }
            // iterate over the results list and update the Certificate objects as needed
            int x = 0;
            int maxAutoId = 0;
            for (Certificate cert : certificates) {
                if (cert.getAutoId() > maxAutoId) {
                    maxAutoId = cert.getAutoId();
                    x = maxAutoId;
                }
            }
            System.out.println(x);
        }

        System.out.println("This is also list of ImagePdf to check the data "+ImagePdf.Save6);
        Map<String, Object> store = new HashMap<>();
        List<Certificate> data = new ArrayList<>(ImagePdf.Save6);
        Map<String, List<Certificate>> dataMap = new HashMap<>();
        dataMap.put("data", data);
        System.out.println(ImagePdf.Save6);

        // Create a new HashMap to hold the modified list
        Map<String, Object> newData = new HashMap<>();
        newData.put("data", dataMap.get("data"));

        String insert="insert";
        // Add the "data" key to the new HashMap
        newData.put("data", data);
        newData.put("dataType", update);
        newData.put("type", type);
        newData.put("loginToken", token);


        String json = mapper.writeValueAsString(newData);

        //set url where you store the data if you have otherwise ignore it.
    //    String url = "https://example.in/api/JavaCertificate";
    //    HttpHeaders headers = new HttpHeaders();
    //
    //    headers.setContentType(MediaType.APPLICATION_JSON);
    //    headers.set("loginToken", token);
    //    HttpEntity<String> entity = new HttpEntity<>(json, headers);
    //    System.out.println(headers);
    //    System.out.println(token);
    //    System.out.println(entity);
    //    ResponseEntity<Data> response = restTemplate.exchange(url, HttpMethod.POST, entity, Data.class);
    //    
    //    Data responseBody = response.getBody();
    //      if (response.getStatusCode() == HttpStatus.OK) {
    //        return Collections.singletonMap("message", "Success");
    //    } else {
    //        return Collections.singletonMap("message", "Not success");
    //    }
    return newData;
    //      
    }


    // Preview API
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/preview")
    public List<Certificate1> receiveData1(@RequestBody Check data1) throws IOException, Exception {
        System.out.println(data1);
        ObjectMapper mapper = new ObjectMapper();
        String jsonData1 = mapper.writeValueAsString(data1);
        String encrypt = jsonData1;
        Map<String, String> map = mapper.readValue(encrypt, Map.class);
        String value1 = map.get("checksum");
        System.out.println(encrypt);
        String decrypted = Encryption.decryptText(value1);
        System.out.println(decrypted);

        String token = null;
        List<Certificate1> dataList = new ArrayList<>();

        // Attempt to deserialize the input JSON as a list of Data objects
        try {
            dataList = mapper.readValue(decrypted, new TypeReference<List<Certificate1>>() {});
        } catch (MismatchedInputException e) {
            // If the input JSON is not a list, try to deserialize it as a single Data object
            Certificate1 dataObj = mapper.readValue(decrypted, Certificate1.class);
            dataList.add(dataObj);
        }
        String encode=null;

            List<String> resultList = new ArrayList<>();
            // manipulate the list of Certificate objects as needed
            for (Certificate1 certificate : dataList) {
           int a = Integer.parseInt(certificate.getCertificateId());
           int abc = 1;
          encode = ImagePdf2.generateImage(certificate.getLogo(),certificate.getSignature(), certificate.getDate(),certificate.getPeriod(), certificate.getContent(), certificate.getDesignation(), abc, a, certificate.getCertificateName(), certificate.getImagedecode());
           certificate.setImageencode(encode);
           resultList.add(encode);
           }
           System.out.println(encode);

            return dataList;
    }
}
