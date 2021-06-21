package ex41;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class AppTest extends TestCase {

    @Test
    public void testSplitNames() {
        String str = "Ling, Mai" + "  " + "Johnson, Jim";
        Assertions.assertEquals(true, App.splitNames(str)[0].equals("Ling, Mai") && App.splitNames(str)[1].equals("Johnson, Jim"));

    }
}