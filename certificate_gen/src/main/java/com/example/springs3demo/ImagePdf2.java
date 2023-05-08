/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springs3demo;

/**
 *
 * @author Manav Rajput
 */


import com.amazonaws.services.s3.AmazonS3;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.mock.web.MockMultipartFile;




/**
 *
 * @author benepik
 */

public class ImagePdf2 {
    static int flag=0;
    private boolean hasBeenCalled = false;
    static ArrayList<Certificate> Save6 = new ArrayList<>();
    public ImagePdf2(com.amazonaws.services.s3.AmazonS3 s3) {
        this.s3 = s3;
    }
        
    private  final AmazonS3 s3;
        

    public static String generateImage(String filename, String Signature, String Date,String period, String content, String Designation, int count, int par1 , String name, String imagedecoder) throws IOException, JSONException{
        S3Contoller obj=new S3Contoller();
        BufferedImage Image = ImageDecoder.decode(filename);
        BufferedImage signImage = ImageDecoder.decode(Signature);
        
        ArrayList<String> resultList = new ArrayList<>(); 
        System.out.println(imagedecoder);
        String space = filename;
        space = space.replaceAll("\\s+", "");
        String outputFileName = space + ".png";
//        File outputFile = new File("/home/benepik/Documents/Images/"+outputFileName);
//        ImageIO.write(Image, "png", outputFile);
        System.out.println(par1);
            switch (par1) {
                 case 1 ->   {
                     System.out.println("This is image decoder "+imagedecoder);
                         URL imageUrl = new URL("https://example.com/path/to/path/"+space+".jpg");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.PLAIN, 100);
                        Color color = Color.RED;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = name;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 550;
                        System.out.println(text.length());
                         if (text.length() <= 5) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth() - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 10) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 15) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2) ;
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 25) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }
                        Font font2 = new Font("Soege", Font.ROMAN_BASELINE, 50);
                        Color color2 = Color.GRAY;
                        g2d.setFont(font2);
                        g2d.setColor(color2);                        

                        String text2 = content;
                        int textWidth1 = g2d.getFontMetrics().stringWidth(text2);
                        int x1 = ((image.getWidth()+400 - textWidth1) / 2);
                        int y2 = 1500;

                       if (text2.length() <= 10) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth()+ 50  - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 30) {
                            // Draw the text on the image with x-value of 300
                            int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 40){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 50){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        }else {
                               // Split the text into multiple lines of maximum 60 characters each
                               String[] lines = splitString(text2, 60);

                               // Draw each line on the image, shifting the y-coordinate by 30 pixels for each line
                               for (int i = 0; i < lines.length; i++) {
                                   String line = lines[i];
                                   int y3 = y2 + i * 60;
                                   g2d.drawString(line, x1, y3);
                               }
                           }
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int newWidth = 300;
                        int newHeight = 250;
                        Image scaledImage = Image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        BufferedImage compressedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
                        Graphics2D g = compressedImage.createGraphics();
                        g.drawImage(scaledImage, 0, 0, null);
                        g.dispose();
                        // now you can use compressedImage for drawing
                        int imageX = ((image.getWidth()  - textWidth) / 2)+200;
//                        int imageX = ((compressedImage.getWidth() - textWidth) / 2) ;
                        int imageY = 1800;
                        g2d.drawImage(compressedImage, imageX, imageY, null);
                        ImageIO.write(image, "png", baos);
//
                        byte[] imageBytes = baos.toByteArray();
                        String imageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
                        byte[] bytes = baos.toByteArray();
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999
                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));
                        String png = obj.handleFileUpload3(mockMultipartFile1);
                        // Return the image string
                        return png;
                    }
                
                case 2 ->   {

                     URL imageUrl = new URL("https://example.com/path/to/path/"+space+".jpg");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.PLAIN, 90);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = name;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 400;
                        System.out.println(text.length());
                         if (text.length() <= 5) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth() - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 10) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 15) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2) ;
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 25) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }
                         
                         Font font2 = new Font("Soege", Font.ROMAN_BASELINE, 50);
                        Color color2 = Color.BLACK;
                        g2d.setFont(font2);
                        g2d.setColor(color2);                        

                        String text2 = content;
                        int textWidth1 = g2d.getFontMetrics().stringWidth(text2);
                        int x1 = ((image.getWidth()+700 - textWidth1) / 2);
                        int y2 = 1350;

                       if (text2.length() <= 10) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth()+ 50  - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 30) {
                            // Draw the text on the image with x-value of 300
                            int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 40){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 50){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        }else {
                               // Split the text into multiple lines of maximum 60 characters each
                               String[] lines = splitString(text2, 60);

                               // Draw each line on the image, shifting the y-coordinate by 30 pixels for each line
                               for (int i = 0; i < lines.length; i++) {
                                   String line = lines[i];
                                   int y3 = y2 + i * 60;
                                   g2d.drawString(line, x1, y3);
                               }
                           }
                        
                       ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int newWidth = 300;
                        int newHeight = 300;
                        Image scaledImage = Image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        BufferedImage compressedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
                        Graphics2D g = compressedImage.createGraphics();
                        g.drawImage(scaledImage, 0, 0, null);
                        g.dispose();
                        // now you can use compressedImage for drawing
                        int imageX = ((image.getWidth()-1600  - textWidth) / 2);
                        int imageY = 1850;
                        g2d.drawImage(compressedImage, imageX, imageY, null);
                     
                        
                        int newWidth1 = 650;
                        int newHeight1 = 200;
                        Image scaledImage1 = signImage.getScaledInstance(newWidth1, newHeight1, Image.SCALE_SMOOTH);
                        BufferedImage compressedImage1 = new BufferedImage(newWidth1, newHeight1, BufferedImage.TRANSLUCENT);
                        Graphics2D g1 = compressedImage1.createGraphics();
                        g1.drawImage(scaledImage1, 0, 0, null);
                        g1.dispose();

                        int signX = ((Image.getWidth() + 2800 - textWidth) / 2) / 2 + 1600;
                        int signY = 1800;
                        g2d.drawImage(compressedImage1, signX, signY, null);

                        ImageIO.write(image, "png", baos);

                        byte[] logoImageBytes = baos.toByteArray();
                        String logoImageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(logoImageBytes);

                        byte[] signImageBytes = baos.toByteArray();
                        String signImageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(signImageBytes);

                        byte[] bytes = baos.toByteArray();
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999

                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));
                        
                        
                        String png = obj.handleFileUpload2(mockMultipartFile1);
                        // Return the image string
                        return png;
//                        
                    }
            case 3 ->   {
                
                URL imageUrl = new URL("https://example.com/path/to/path/"+space+".jpg");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.PLAIN, 90);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = name;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth()-60 - textWidth) / 2);
                        int y = 1300;
                        System.out.println(text.length());
                         if (text.length() <= 5) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth()-60 - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 10) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()-60  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 15) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()-60 - textWidth) / 2) ;
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()-60 - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 25) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()-60  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }
                         
                        Font font2 = new Font("Soege", Font.ROMAN_BASELINE, 50);
                        Color color2 = Color.BLACK;
                        g2d.setFont(font2);
                        g2d.setColor(color2);                        

                        String text2 = content;
                        int textWidth1 = g2d.getFontMetrics().stringWidth(text2);
                        int x1 = ((image.getWidth()+700 - textWidth1) / 2);
                        int y2 = 1750;

                       if (text2.length() <= 10) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth()+ 50  - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 30) {
                            // Draw the text on the image with x-value of 300
                            int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 40){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 50){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        }else {
                               // Split the text into multiple lines of maximum 60 characters each
                               String[] lines = splitString(text2, 60);

                               // Draw each line on the image, shifting the y-coordinate by 30 pixels for each line
                               for (int i = 0; i < lines.length; i++) {
                                   String line = lines[i];
                                   int y3 = y2 + i * 60;
                                   g2d.drawString(line, x1, y3);
                               }
                           }
                           
                       
                        Font dateFont = new Font("Soege", Font.PLAIN, 60);
                        Color dateColor = Color.BLACK;
                        g2d.setFont(dateFont);
                        g2d.setColor(dateColor);
                        // Draw the text on the image
                        String dateText = Date;
//                        int textWidth = g2d.getFontMetrics().stringWidth(text3);
                        int dateX = 700;
                        int dateY = 2220;
                        g2d.drawString(dateText, dateX, dateY);
                        
                       ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int newWidth = 300;
                        int newHeight = 300;
                        Image scaledImage = Image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        BufferedImage compressedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
                        Graphics2D g = compressedImage.createGraphics();
                        g.drawImage(scaledImage, 0, 0, null);
                        g.dispose();
                        // now you can use compressedImage for drawing
                        int imageX = ((image.getWidth()+2200  - textWidth) / 2);
                        int imageY = 2000;
                        g2d.drawImage(compressedImage, imageX, imageY, null);
                     
                        
                        ImageIO.write(image, "png", baos);
                        
                        byte[] logoImageBytes = baos.toByteArray();
                        String logoImageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(logoImageBytes);
                        
                        byte[] bytes = baos.toByteArray();
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999

                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));
                        
                        
                        String png = obj.handleFileUpload2(mockMultipartFile1);
                        // Return the image string
                        return png;
                
                
                
            }
            
            case 4 ->   {
                       URL imageUrl = new URL("https://example.com/path/to/path/"+space+".jpg");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.PLAIN, 90);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                         String text = name;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)-50;
                        int y = 350;
                        g2d.drawString(text, x, y);
                        System.out.println(text.length());
                         if (text.length() <= 5) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth() - textWidth) / 2)-50;
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 10) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2)-50;
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 15) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2)-50 ;
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2)-50;
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 25) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2)-50;
                            g2d.drawString(text, x3, y);
                        }

                       Font font2 = new Font("Soege", Font.ROMAN_BASELINE, 50);
                        Color color2 = Color.BLACK;
                        g2d.setFont(font2);
                        g2d.setColor(color2);                        

                        String text2 = content;
                        int textWidth1 = g2d.getFontMetrics().stringWidth(text2);
                        int x1 = ((image.getWidth()+700 - textWidth1) / 2);
                        int y2 = 1450;

                       if (text2.length() <= 10) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth()+ 50  - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 30) {
                            // Draw the text on the image with x-value of 300
                            int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 40){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 50){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        }else {
                               // Split the text into multiple lines of maximum 60 characters each
                               String[] lines = splitString(text2, 60);

                               // Draw each line on the image, shifting the y-coordinate by 30 pixels for each line
                               for (int i = 0; i < lines.length; i++) {
                                   String line = lines[i];
                                   int y3 = y2 + i * 60;
                                   g2d.drawString(line, x1, y3);
                               }
                           }

                       
//                        Font dateFont = new Font("Soege", Font.PLAIN, 60);
//                        Color dateColor = Color.BLACK;
//                        g2d.setFont(dateFont);
//                        g2d.setColor(dateColor);
//                        // Draw the text on the image
//                        String dateText = Date;
////                        int textWidth = g2d.getFontMetrics().stringWidth(text3);
//                        int dateX = 700;
//                        int dateY = 2220;
//                        g2d.drawString(dateText, dateX, dateY);
                        
                       ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int newWidth = 300;
                        int newHeight = 300;
                        Image scaledImage = Image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        BufferedImage compressedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
                        Graphics2D g = compressedImage.createGraphics();
                        g.drawImage(scaledImage, 0, 0, null);
                        g.dispose();
                        // now you can use compressedImage for drawing
                        int imageX = 250;
                        int imageY = 200;
                        g2d.drawImage(compressedImage, imageX, imageY, null);
                     
                        
                        ImageIO.write(image, "png", baos);
                        
                        byte[] logoImageBytes = baos.toByteArray();
                        String logoImageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(logoImageBytes);
                        
                        byte[] bytes = baos.toByteArray();
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999

                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));
                        
                        
                        String png = obj.handleFileUpload2(mockMultipartFile1);
                        // Return the image string
                        return png;
                
                     
                    }
                     
            case 28 ->   {
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".jpg");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.PLAIN, 120);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = name;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)-50;
                        int y = 350;
                        g2d.drawString(text, x, y);
                          
                      
                        Font font2 = new Font("Great Vibes", Font.ROMAN_BASELINE, 50);
                        Color color2 = Color.BLACK;
                        g2d.setFont(font2);
                        g2d.setColor(color2);                        

                        String text2 = content;
                        int textWidth1 = g2d.getFontMetrics().stringWidth(text2);
                        int x1 = ((image.getWidth() + 2000 - textWidth1) / 2+700);
                        int y2 = 1450;

                       if (text2.length() <= 10) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth() + 490 - textWidth1) / 2) / 2 + 620;
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() + 200 - textWidth1) / 2) / 2 + 620;
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 30) {
                            // Draw the text on the image with x-value of 300
                            int x3 = ((image.getWidth() + 50 - textWidth1) / 2) / 2 + 620;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 40){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() + 20 - textWidth1) / 2) / 2 + 500;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 50){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() + 17 - textWidth1) / 2) / 2 + 430;
                            g2d.drawString(text2, x3, y2);
                        }else {
                               // Split the text into multiple lines of maximum 60 characters each
                               String[] lines = splitString(text2, 60);

                               // Draw each line on the image, shifting the y-coordinate by 30 pixels for each line
                               for (int i = 0; i < lines.length; i++) {
                                   String line = lines[i];
                                   int y3 = y2 + i * 60;
                                   g2d.drawString(line, x1, y3);
                               }
                           }

                        
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        
                        int newWidth = 450;
                        int newHeight = 250;
                        Image scaledImage = Image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        BufferedImage compressedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
                        Graphics2D g = compressedImage.createGraphics();
                        g.drawImage(scaledImage, 0, 0, null);
                        g.dispose();
                        
                        int imageX = 250;
                        int imageY = 200;
                        g2d.drawImage(Image, imageX, imageY, null);
                        
                        ImageIO.write(image, "png", baos);
//                        
                        byte[] imageBytes = baos.toByteArray();
                        String imageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);

                        byte[] bytes = baos.toByteArray();
                        
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999

                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));

                        String png = obj.handleFileUpload2(mockMultipartFile1);
                        // Return the image string
                        return png;
                     
                    }
            
            case 5 ->   {
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".jpg");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.PLAIN, 90);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                         String text = name;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)+180;
                        int y = 1050;
                      
                        System.out.println(text.length());
                         if (text.length() <= 5) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth() - textWidth) / 2)+180;
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 10) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2)+180;
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 15) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2)+180 ;
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2)+180;
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 25) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2)+180;
                            g2d.drawString(text, x3, y);
                        }
                         
                        Font font2 = new Font("Soege", Font.ROMAN_BASELINE, 50);
                        Color color2 = Color.BLACK;
                        g2d.setFont(font2);
                        g2d.setColor(color2);                        

                        String text2 = content;
                        int textWidth1 = g2d.getFontMetrics().stringWidth(text2);
                        int x1 = ((image.getWidth()+1650 - textWidth1) / 2);
                        int y2 = 1600;

                       if (text2.length() <= 10) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth()+ 50  - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() + 200 - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 30) {
                            // Draw the text on the image with x-value of 300
                            int x3 = ((image.getWidth() + 400 - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 40){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() + 400 - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 50){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() + 400 - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        }else {
                               // Split the text into multiple lines of maximum 60 characters each
                               String[] lines = splitString(text2, 60);

                               // Draw each line on the image, shifting the y-coordinate by 30 pixels for each line
                               for (int i = 0; i < lines.length; i++) {
                                   String line = lines[i];
                                   int y3 = y2 + i * 60;
                                   g2d.drawString(line, x1, y3);
                               }
                           }


                       
                        Font dateFont = new Font("Soege", Font.ROMAN_BASELINE, 60);
                        Color dateColor = Color.BLACK;
                        g2d.setFont(dateFont);
                        g2d.setColor(dateColor);
                        // Draw the text on the image
                        String dateText = Date;
//                        int textWidth = g2d.getFontMetrics().stringWidth(text3);
                        int dateX = 1100;
                        int dateY = 2040;
                        g2d.drawString(dateText, dateX, dateY);
                        
                        String DesignationText = Designation;
                        int DesignationX = 2380;
                        int DesignationY = 2060;
                        g2d.drawString(DesignationText, DesignationX, DesignationY);
                             
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                
                        ImageIO.write(image, "png", baos);                    
                        byte[] logoImageBytes = baos.toByteArray();
                        String logoImageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(logoImageBytes);
                        
                        byte[] bytes = baos.toByteArray();
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999

                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));
                        
                        
                        String png = obj.handleFileUpload2(mockMultipartFile1);
                        // Return the image string
                        return png;
                
                     
                    }
            
            case 6 ->   {
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".jpg");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.PLAIN, 150);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                         String text = name;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 1370;
                      
                        System.out.println(text.length());
                         if (text.length() <= 5) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth() - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 10) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 15) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2) ;
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 25) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }
                         
                        Font font2 = new Font("Soege", Font.ROMAN_BASELINE, 60);
                        Color color2 = Color.BLACK;
                        g2d.setFont(font2);
                        g2d.setColor(color2);                        

                        String text2 = content;
                        int textWidth1 = g2d.getFontMetrics().stringWidth(text2);
                        int x1 = ((image.getWidth()+500 - textWidth1) / 2);
                        int y2 = 2700;

                       if (text2.length() <= 10) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth()  - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 30) {
                            // Draw the text on the image with x-value of 300
                            int x3 = ((image.getWidth()- textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 40){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 50){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        }else {
                               // Split the text into multiple lines of maximum 60 characters each
                               String[] lines = splitString(text2, 60);

                               // Draw each line on the image, shifting the y-coordinate by 30 pixels for each line
                               for (int i = 0; i < lines.length; i++) {
                                   String line = lines[i];
                                   int y3 = y2 + i * 60;
                                   g2d.drawString(line, x1, y3);
                               }
                           }
                        
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        
                        int newWidth = 400;
                        int newHeight = 350;
                        Image scaledImage = Image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        BufferedImage compressedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
                        Graphics2D g = compressedImage.createGraphics();
                        g.drawImage(scaledImage, 0, 0, null);
                        g.dispose();
                        
                        int imageX = ((image.getWidth() - textWidth) / 2);
                        int imageY = 3350;
                        g2d.drawImage(compressedImage, imageX, imageY, null);
                        
                        ImageIO.write(image, "png", baos);
//                        
                        byte[] imageBytes = baos.toByteArray();
                        String imageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);

                        byte[] bytes = baos.toByteArray();
                        
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999

                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));

                        String png = obj.handleFileUpload2(mockMultipartFile1);
                        // Return the image string
                        return png;
                     
                    }
            
            case 7 ->   {
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".jpg");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.PLAIN, 150);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                         String text = name;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 1300;
                      
                        System.out.println(text.length());
                         if (text.length() <= 5) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth() - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 10) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        } else if (text.length() <= 15) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2) ;
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }else if (text.length() <= 25) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth()  - textWidth) / 2);
                            g2d.drawString(text, x3, y);
                        }
                         
                        Font font2 = new Font("Soege", Font.ROMAN_BASELINE, 60);
                        Color color2 = Color.BLACK;
                        g2d.setFont(font2);
                        g2d.setColor(color2);                        

                        String text2 = content;
                        int textWidth1 = g2d.getFontMetrics().stringWidth(text2);
                        int x1 = ((image.getWidth() +300 - textWidth1) / 2);
                        int y2 = 2700;

                       if (text2.length() <= 10) {
                        // Draw the text on the image with x-value of 100
                        int x3 = ((image.getWidth()  - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 20) {
                            // Draw the text on the image with x-value of 200
                             int x3 = ((image.getWidth() - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        } else if (text2.length() <= 30) {
                            // Draw the text on the image with x-value of 300
                            int x3 = ((image.getWidth()- textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 40){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2) ;
                            g2d.drawString(text2, x3, y2);
                        } else if(text2.length() <= 50){
                            // Draw the text on the image with x-value of 400
                             int x3 = ((image.getWidth() - textWidth1) / 2);
                            g2d.drawString(text2, x3, y2);
                        }else {
                               // Split the text into multiple lines of maximum 60 characters each
                               String[] lines = splitString(text2, 60);

                               // Draw each line on the image, shifting the y-coordinate by 30 pixels for each line
                               for (int i = 0; i < lines.length; i++) {
                                   String line = lines[i];
                                   int y3 = y2 + i * 60;
                                   g2d.drawString(line, x1, y3);
                               }
                           }
                        
                        Font dateFont = new Font("Soege", Font.ROMAN_BASELINE, 90);
                        Color dateColor = Color.BLACK;
                        g2d.setFont(dateFont);
                        g2d.setColor(dateColor);
                        // Draw the text on the image
                        String dateText = Date;
//                        int textWidth = g2d.getFontMetrics().stringWidth(text3);
                        int dateX = ((image.getWidth() - textWidth) / 2)+100;
                        int dateY = 3200;
                        g2d.drawString(dateText, dateX, dateY);
                       
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        
                        int newWidth = 450;
                        int newHeight = 400;
                        Image scaledImage = Image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        BufferedImage compressedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
                        Graphics2D g = compressedImage.createGraphics();
                        g.drawImage(scaledImage, 0, 0, null);
                        g.dispose();
                        
                        int imageX = ((image.getWidth() - textWidth) / 2)+200;
                        int imageY = 3400;
                        g2d.drawImage(compressedImage, imageX, imageY, null);
                        
                        ImageIO.write(image, "png", baos);
//                        
                        byte[] imageBytes = baos.toByteArray();
                        String imageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);

                        byte[] bytes = baos.toByteArray();
                        
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999

                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));

                        String png = obj.handleFileUpload2(mockMultipartFile1);
                        // Return the image string
                        return png;
                     
                    }

            case 72 ->   {
                        URL imageUrl = new URL("https://benepik.s3.amazonaws.com/dev/benepikPlus/campaign/certificate/"+imagedecoder+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] imageBytes = baos.toByteArray();
                        String imageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
                        byte[] bytes = baos.toByteArray();
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999
                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));
                        String png = obj.handleFileUpload3(mockMultipartFile1);
                        // Return the image string
                        return png;
                    }
             case 71 ->   {
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.PLAIN, 50);
                        Color color = Color.GRAY;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        Date date = null;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String quarterString = null;
                        try {
                            date = dateFormat.parse(period);
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(date);
                            int quarter = (calendar.get(Calendar.MONTH) / 3) + 1;
                            String yearString = String.valueOf(calendar.get(Calendar.YEAR));
                            switch (quarter) {
                                case 1:
                                    quarterString = "Quater I "+yearString;
                                    break;
                                case 2:
                                    quarterString = "Quater II "+yearString;
                                    break;
                                case 3:
                                    quarterString = "Quater III "+yearString;
                                    break;
                                case 4:
                                    quarterString = "Quater IV "+yearString;
                                    break;
                                default:
                                    quarterString = "Invalid quarter";
                            }
                            // Do something with the parsed date
                        } catch (ParseException e) {
                            // Handle the parse exception
                            e.printStackTrace();
                        }
                        int textWidth = g2d.getFontMetrics().stringWidth(quarterString);
                        int x = ((image.getWidth() - textWidth) / 2)+550;
                        int y = 1230;
                        g2d.drawString(quarterString, x, y);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] imageBytes = baos.toByteArray();
                        String imageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
                        byte[] bytes = baos.toByteArray();
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999
                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));
                        String png = obj.handleFileUpload3(mockMultipartFile1);
                        // Return the image string
                        return png;
                    }
             case 73 ->   {
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.PLAIN, 110);
                        Color color = Color.ORANGE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = content;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)+650;
                        int y = 530;
                        g2d.drawString(text, x, y);
                        // Get the graphics context for the image
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] imageBytes = baos.toByteArray();
                        String imageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
                        byte[] bytes = baos.toByteArray();
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(1000); // Generate a random number between 0 and 999
                        String fileName = imagedecoder + randomNumber + ".png";
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", fileName, "image/png", new ByteArrayInputStream(bytes));
                        String png = obj.handleFileUpload3(mockMultipartFile1);
                        // Return the image string
                        return png;
                    }
                default -> {
                }
            } 
        
        
          return null;    
            
            
        
     
    }
        
public static String[] splitString(String s, int maxLength) {
    List<String> lines = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
        int endIndex = i + maxLength;
        if (endIndex >= s.length()) {
            lines.add(s.substring(i));
            break;
        }
        int lastSpaceIndex = s.lastIndexOf(' ', endIndex);
        if (lastSpaceIndex > i) {
            lines.add(s.substring(i, lastSpaceIndex));
            i = lastSpaceIndex + 1;
        } else {
            lines.add(s.substring(i, endIndex));
            i = endIndex;
        }
    }
    return lines.toArray(new String[0]);
}

}
