package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DocTest {
    @Test
    public void readDocFile() throws IOException {
        String textInDocFile = FileHelper.readDocFile("./src/test/resources/test_doc.docx", "Hello");
        Assertions.assertTrue(textInDocFile.contains("Hello"));

    }
}
