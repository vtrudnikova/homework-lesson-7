package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PDFTest {
    @Test
    public void readTest() {

        String textInPDFFile = FileHelper.readPDFFile("./src/test/resources/test_pdf.pdf");
        Assertions.assertTrue(textInPDFFile.contains("Hello"));
    }
}