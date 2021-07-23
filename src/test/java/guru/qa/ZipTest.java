package guru.qa;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ZipTest {
    @Test
    public void readZipFile() throws ZipException, IOException {
        FileHelper.readZipFile("./src/test/resources/zip/test_zip.zip", "1234", "./src/test/resources/unzip/");
        StringBuffer textFile = FileHelper.readTextFile("./src/test/resources/unzip/");
        Assertions.assertTrue(textFile.toString().contains("Hello"));
    }
}

