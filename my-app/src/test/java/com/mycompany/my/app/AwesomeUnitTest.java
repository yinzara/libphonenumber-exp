package com.mycompany.my.app;

import org.example.awesome.AwesomeFacade;
import org.junit.Test;

/**
 *
 * @author Matt Morrissette
 */
public class AwesomeUnitTest {
    
    private final AwesomeFacade facade = new AwesomeFacade();

    @Test
    public void testDoSomethingAwesome() {
        final String testNumber = "7023331122";
        facade.doSomethingAwesomeWithThisPhoneNumber(testNumber);
    }

}
