/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springs3demo;

/**
 *
 * @author Manav Rajput
 */
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ImageDecoder {

    public static BufferedImage decode(String base64String) throws IOException {
                System.out.println(base64String);

        base64String = base64String.replaceFirst("^data\\:[^;]*;base64,?", "");
        byte[] imageBytes = Base64.decodeBase64(base64String);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        BufferedImage image = ImageIO.read(bis);
        bis.close();

        return image;
    }
    
    public static BufferedImage decode2(String base64String) throws IOException {
                System.out.println(base64String);

        System.out.println("Hello World");
        base64String = base64String.replaceFirst("^data\\:[^;]*;base64,?", "");
        byte[] imageBytes = Base64.decodeBase64(base64String);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        BufferedImage image = ImageIO.read(bis);
        bis.close();

        return image;
    }

}
