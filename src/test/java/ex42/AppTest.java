package ex42;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

public class AppTest extends TestCase {

    public void testSplitNames() {
        String str = "Ling,Mai";
        Assertions.assertEquals("Ling", App.splitNames(str)[0]);
    }
}