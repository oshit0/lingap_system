package com.lingap;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class DocxIO{
    public static void maloid() {
        try (XWPFDocument doc = new XWPFDocument();
             FileOutputStream out = new FileOutputStream("output.docx")) {

            XWPFParagraph paragraph1 = doc.createParagraph();
            XWPFRun run1 = paragraph1.createRun();

            InputStream imageStream = new FileInputStream("test/src/main/resources/maloi.jpg");
            run1.addPicture(imageStream,
                    XWPFDocument.PICTURE_TYPE_JPEG,
                    "maloi.jpg",
                    Units.toEMU(200), // width in EMUs
                    Units.toEMU(200)); // height in EMUs
            imageStream.close();

            XWPFParagraph paragraph2 = doc.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            run2.setText("Maloi Patient Information Record:");

            XWPFTable table = doc.createTable(3, 3);

            table.getRow(0).getCell(0).setText("Header 1");
            table.getRow(0).getCell(1).setText("Header 2");
            table.getRow(0).getCell(2).setText("Header 3");

            table.getRow(1).getCell(0).setText("Data 1");
            table.getRow(1).getCell(1).setText("Data 2");
            table.getRow(1).getCell(2).setText("Data 3");

            table.getRow(2).getCell(0).setText("Data 4");
            table.getRow(2).getCell(1).setText("Data 5");
            table.getRow(2).getCell(2).setText("Data 6");

            doc.write(out);

            System.out.println("Image and text added to document successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

