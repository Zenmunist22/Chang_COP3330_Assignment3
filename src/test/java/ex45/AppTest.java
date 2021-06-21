package ex45;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

public class AppTest extends TestCase {

    public void testReplaceWithUse() {
        String str = "He found his art never progressed when he literally utilized his sweat and tears.";
        Assertions.assertEquals("He found his art never progressed when he literally used his sweat and tears.", App.replaceWithUse(str));
    }
}