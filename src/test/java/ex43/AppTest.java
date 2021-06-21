package ex43;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class AppTest extends TestCase {

    public void testCreateDir() {
        if (App.createDir("test") == false){
            File x = new File("test");
            x.delete();
        }
        Assertions.assertEquals(true, App.createDir("test"));
    }
}