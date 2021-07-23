package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class XlsxTest {

    @Test
    public void readXlsxTest() throws IOException {
        String textInXlsxFile = FileHelper.readXlsxFile("./src/test/resources/xlsx_test.xlsx");
        Assertions.assertTrue(textInXlsxFile.contains("Hello"));
    }
}
