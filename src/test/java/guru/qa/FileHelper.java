package guru.qa;

import net.lingala.zip4j.exception.ZipException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileHelper {
    private FileHelper() {
    }

    public static String readPDFFile(String fileName) {
        String st = null;
        try {
            PDDocument document = null;
            document = PDDocument.load(new File(fileName));
            document.getClass();
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper Tstripper = new PDFTextStripper();
                st = Tstripper.getText(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    public static String readDocFile(String filePath, String data) throws IOException {
        File file = new File(filePath);
        String parag = null;
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        XWPFDocument document = new XWPFDocument(fis);

        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph para : paragraphs) {
            parag = para.getText();
            Assertions.assertTrue(para.getText().contains(data));
        }
        fis.close();
        return parag;
    }

    public static String readXlsxFile(String file) throws IOException {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheet("Лист1");
        XSSFRow row = myExcelSheet.getRow(0);
        String name = row.getCell(0).getStringCellValue();
        myExcelBook.close();
        return name;
    }

    public static void readZipFile(String zipFilePath, String password, String unzipFolderPath) throws ZipException {
        net.lingala.zip4j.core.ZipFile zipFile = new net.lingala.zip4j.core.ZipFile(zipFilePath);

        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password);
        }
        zipFile.extractAll(unzipFolderPath);
    }

    public static StringBuffer readTextFile(String path) throws FileNotFoundException {
        File directoryPath = new File(path);
        File filesList[] = directoryPath.listFiles();
        Scanner sc = null;
        StringBuffer sb = null;
        for (File file : filesList) {
            sc = new Scanner(file);
            String input;
            sb = new StringBuffer();
            while (sc.hasNextLine()) {
                input = sc.nextLine();
                sb.append(input + " ");
            }
            System.out.println("Contents of the file: " + sb.toString());
        }
        return sb;
    }
}


