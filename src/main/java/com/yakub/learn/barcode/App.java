package com.yakub.learn.barcode;

import com.google.zxing.BarcodeFormat;
import com.yakub.learn.barcode.reader.BarcodeReader;
import com.yakub.learn.barcode.write.BarcodeWriter;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        String endodedInput = "6951958000113";
        int width = 900;
        int height = 400;
        String imageFormat = "png";
        String path = "/media/yakub/DriveA/xxxxxxxxxx"+"."+imageFormat;
        //BarcodeWriter.writeBarcode(endodedInput, width, height, imageFormat, path, BarcodeFormat.EAN_13);
        BarcodeReader.readBarcode(path);
    }
}
