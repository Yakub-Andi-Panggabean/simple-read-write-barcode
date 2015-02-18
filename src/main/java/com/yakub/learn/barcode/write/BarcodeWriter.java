/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yakub.learn.barcode.write;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Reader;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEANWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author yakub
 */
public class BarcodeWriter {

    public static void writeBarcode(String encodedInput, int width, int height, String imageFormat, String outputPath, BarcodeFormat format) {
        try {
            BitMatrix bitMatrix = null;
            if (format == BarcodeFormat.QR_CODE) {
                bitMatrix = new QRCodeWriter().encode(encodedInput, BarcodeFormat.QR_CODE, width, height);
            } else if (format == BarcodeFormat.AZTEC) {
                bitMatrix = new AztecWriter().encode(encodedInput, BarcodeFormat.AZTEC, width, height);
            } else if (format == BarcodeFormat.CODABAR) {
                bitMatrix = new CodaBarWriter().encode(encodedInput, BarcodeFormat.CODABAR, width, height);
            } else if (format == BarcodeFormat.CODE_128) {
                bitMatrix = new Code128Writer().encode(encodedInput, BarcodeFormat.CODE_128, width, height);
            } else if (format == BarcodeFormat.CODE_39) {
                bitMatrix = new Code39Writer().encode(encodedInput, BarcodeFormat.CODE_39, width, height);
            } else if (format == BarcodeFormat.EAN_8) {
                bitMatrix = new EAN8Writer().encode(encodedInput, BarcodeFormat.EAN_8, width, height);
            } else if (format == BarcodeFormat.EAN_13) {
                bitMatrix = new EAN13Writer().encode(encodedInput, BarcodeFormat.EAN_13, width, height);
            } else {
                throw new IllegalArgumentException("Unspesified Format Parameter");
            }
            MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, new FileOutputStream(new File(outputPath)));
            System.out.println("Successfully Encoded");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
