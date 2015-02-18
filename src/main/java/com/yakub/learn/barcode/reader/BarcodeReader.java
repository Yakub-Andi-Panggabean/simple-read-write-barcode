/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yakub.learn.barcode.reader;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author yakub
 */
public class BarcodeReader {

    public static void readBarcode(String filePath) {
        try {
            InputStream inputStream = new FileInputStream(filePath);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            Result result = reader.decode(bitmap);
            System.out.println(bufferedImage.toString());
            System.out.println("Decoded Code of " + filePath + "is :" + result.getText());
        } catch (Exception e) {
            //System.out.println("Exception :" + e.getMessage());
            e.printStackTrace();
        }
    }
}
