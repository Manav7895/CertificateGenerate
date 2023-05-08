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
import static com.example.springs3demo.S3Contoller.Save2;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.mock.web.MockMultipartFile;

public class ImagePdf {
    static int flag=0;
    private boolean hasBeenCalled = false;
    static ArrayList<Certificate> Save6 = new ArrayList<>();
    public ImagePdf(com.amazonaws.services.s3.AmazonS3 s3) {
        this.s3 = s3;
    }
        
    private  final AmazonS3 s3;
        

    public static ArrayList<String> generateImage(String filename, int count, int par1, String name) throws IOException, JSONException{
        S3Contoller obj=new S3Contoller();
        System.out.println(filename);
        ArrayList<String> resultList = new ArrayList<>(); 
        String space = name;
        space = space.replaceAll("\\s+", "");
            switch (par1) {
                case 1 ->   {
                        System.out.println(space);
                        //set your path of your template where it have.
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.BOLD, 40);
                        Color color = Color.GRAY;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 680;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }

                case 2 ->   {
                    
//                     
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.BOLD, 140);
                        Color color = Color.ORANGE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 1300;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 3 ->   {
                     
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.ITALIC, 90);
                        Color color = Color.BLUE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2 - 5);
                        int y = 1150;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 4 ->   {
//                      
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.BOLD, 150);
                        Color color = Color.GRAY;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 1200;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            
            case 5 ->   {
                        
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.BOLD, 130);
                        Color color = Color.GRAY;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)+200;
                        int y = 1420;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            
            case 28 ->   {
                        
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.ITALIC, 100);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)+650;
                        int y = 1000;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 29 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.ITALIC, 40);
                        Color color = Color.WHITE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 400;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 30 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.ITALIC, 40);
                        Color color = Color.WHITE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 400;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 31 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.ITALIC, 40);
                        Color color = Color.WHITE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 400;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 32 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.PLAIN, 90);
                        Color color = Color.WHITE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = "Dear "+filename;
//                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = 100;
                        int y = 430;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 33 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.PLAIN, 50);
                        Color color = Color.WHITE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = "Dear "+filename;
//                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = 170;
                        int y = 330;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 38 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.BOLD, 70);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)+220;
                        int y = 550;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 39 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.BOLD, 60);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 650;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 41 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Concert One", Font.BOLD, 100);
                        Color color = Color.GRAY;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)+20;
                        int y = 1270;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 42 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Concert One", Font.BOLD, 130);
                        Color color = Color.GRAY;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)+20;
                        int y = 1300;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 43 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Concert One", Font.BOLD, 130);
                        Color color = Color.GRAY;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 1290;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 44 ->   {
                    
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Concert One", Font.BOLD, 130);
                        Color color = Color.GRAY;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 1340;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 45 ->   {
    
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Cookie", Font.ITALIC, 130);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 850;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 46 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Cookie", Font.ITALIC, 130);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 850;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 6 ->   {
                    
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.PLAIN, 120);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 1650;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 7 ->   {
                     
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.PLAIN, 120);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 1650;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }

            case 17 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Great Vibes", Font.BOLD, 140);
                        Color color = Color.GRAY;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 1300;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 34 ->   {
        
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.BOLD, 90);
                        Color color = Color.BLUE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2 - 5);
                        int y = 2100;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 35 ->   {
    
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.BOLD, 90);
                        Color color = Color.BLUE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2 - 5);
                        int y = 2100;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 36 ->   {

                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.BOLD, 90);
                        Color color = Color.BLUE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2 - 5);
                        int y = 2100;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            case 37 ->   {
            
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.BOLD, 90);
                        Color color = Color.BLUE;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2 - 5);
                        int y = 2100;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
            
            case 71 ->   {
                        
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.PLAIN, 40);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 550;
                        g2d.drawString(text, x, y);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                        String png=obj.handleFileUpload2(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        // Save the document to file
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                    }
            case 72 ->   {
                        
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Soege", Font.PLAIN, 40);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2)+200;
                        int y = 830;
                        g2d.drawString(text, x, y);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        // Save the document to file
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                    }
            case 73 ->   {
                     
                        URL imageUrl = new URL("https://example.com/path/to/path/"+space+".png");
                        BufferedImage image = ImageIO.read(imageUrl);
          
                        // Get the graphics context for the image
                        Graphics2D g2d = image.createGraphics();
                        // Set the font and color for the text
                        Font font = new Font("Lato Black", Font.PLAIN, 45);
                        Color color = Color.BLACK;
                        g2d.setFont(font);
                        g2d.setColor(color);
                        // Draw the text on the image
                        String text = filename;
                        int textWidth = g2d.getFontMetrics().stringWidth(text);
                        int x = ((image.getWidth() - textWidth) / 2);
                        int y = 430;
                        g2d.drawString(text, x, y);
                                                
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] bytes = baos.toByteArray();
                        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file",filename+count+".png", "image/png", new ByteArrayInputStream(bytes));
                   
                        String png=obj.handleFileUpload3(mockMultipartFile1);
                        ArrayList<Certificate> abcd=savecertificate1(png,count);
                        

                        // Load the edited image from file
                        // Create a new PDF document
                        PDDocument document = new PDDocument();
                        
                        // Create a new page in the document
                        PDPage page = new PDPage();
                        document.addPage(page);
                        
                        // Convert the image to a PDImageXObject and add it to the page
                        PDImageXObject imageObject = LosslessFactory.createFromImage(document, image);
                        float pageWidth = page.getMediaBox().getWidth();
                        float pageHeight = page.getMediaBox().getHeight();
                        float imageWidth = imageObject.getWidth();
                        float imageHeight = imageObject.getHeight();
                        float widthScale = pageWidth / imageWidth;
                        float heightScale = pageHeight / imageHeight;
                        float scale = Math.min(widthScale, heightScale);
                        float scaledWidth = imageWidth * scale;
                        float scaledHeight = imageHeight * scale;
                        float e = (pageWidth - scaledWidth) / 2;
                        float f = (pageHeight - scaledHeight) / 2;
                        
                        
                        try (var contentStream = new PDPageContentStream(document, page)) {
                            contentStream.drawImage(imageObject, e, f, scaledWidth, scaledHeight);
                        }
                        
                        
                        // Save the document to file              
                        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                        document.save(baos1);
                        document.close();
                        byte[] bytes1 = baos1.toByteArray();
                            
                        // Create a MockMultipartFile object from the byte array
                        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", filename + count + ".pdf", "application/pdf", new ByteArrayInputStream(bytes1));
                        String pdf =obj.handleFileUpload(mockMultipartFile);
                        ArrayList<Certificate> abc=savecertificate1(pdf,count);
                     
                    }
                default -> {
                }
            } 
        
        
          return resultList;    
            
            
        
     
    }
        
        
public static ArrayList<Certificate> savecertificate1(String url, int count) throws IOException {
    ArrayList<Certificate> dataList = (ArrayList<Certificate>) S3Contoller.Save;
    boolean hasBeenCalled = false;
    boolean isFirstCall = true; // added variable to track if it's the first call
    int maxAutoId = -1;
    for (Certificate cert : dataList) {
        if (cert.getAutoId() > maxAutoId) {
            maxAutoId = cert.getAutoId();
        }
        
        if (cert.getAutoId() == count) {
            if (url.endsWith(".png")) {
                cert.setCertificateImg(url);
            } else if (url.endsWith(".pdf")) {
                cert.setCertificatepdf(url);
            }
        }
    }

    if (count == maxAutoId) {
        if (hasBeenCalled) {
            return null;
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = objectMapper.writeValueAsString(dataList);
            System.out.println(jsonData); 
            int a=dataList.size();
            System.out.println(a);
            dataList = dataList;
            hasBeenCalled = true;
          
            if (isFirstCall) {
                isFirstCall = false;
                ImagePdf.Save6.clear();
                ImagePdf.Save6.addAll(dataList);// set the flag to false after the first call
            } else {
                flag=1;
                ImagePdf.Save6.addAll(dataList); // execute this block in the second call
                System.out.println("This is list of Image "+ImagePdf.Save6);
                return Save2;
            }
        }
    } else {
        return null;
    }
    return null;
}

   
}

