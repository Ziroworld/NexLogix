
package Testing;
import Controller.*;
import View.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class LoginTesting {
    private LoginController test;
    
    @Test 
    public void TestLogin(){
        Loginwin win = new Loginwin();
        test = new LoginController(win);
        boolean actual = test.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
}
