package com.green.GreenClassRoom.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ResizeImgUtil {
    public static void resizeImg(MultipartFile reImg, String filePath, String formatName) throws Exception{
        BufferedImage inputImg = ImageIO.read(reImg.getInputStream());
        int originWidth = inputImg.getWidth();
        int originHeight = inputImg.getHeight();
        int newWidth = 500;
        int newHeight = 500;
        if(originWidth > newWidth || originHeight > newHeight){
            if(originWidth > newWidth){
                newWidth = (int)(originWidth * ((double)newWidth / originWidth));
            }else if(originHeight > newHeight){
                newHeight = (int)(originHeight * ((double)newHeight / originHeight));
            }
            Image resizeImage = inputImg.getScaledInstance(newWidth, newHeight, Image.SCALE_FAST);
            BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = newImage.getGraphics();
            graphics.drawImage(resizeImage, 0, 0, null);
            graphics.dispose();
            File newFile = new File(filePath);
            ImageIO.write(newImage, formatName, newFile);
        }else{
            reImg.transferTo(new java.io.File(filePath));
        }
    }
}
