package com.example.warehouse.shared;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class BarCodeGenerator {
    public static byte[] generateQRCodeImage(String content, int width, int height) throws WriterException, IOException {
        Code128Writer codeWriter = new Code128Writer();
        BitMatrix bitMatrix = codeWriter.encode(content, BarcodeFormat.CODE_128, width, height);

        try (ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream()) {
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            return pngOutputStream.toByteArray();
        }
    }
}
