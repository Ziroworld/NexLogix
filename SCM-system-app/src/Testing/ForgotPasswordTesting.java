
package Testing;

import Controller.ForgotpasswordController;
import View.ForgotPasswordView;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ForgotPasswordTesting {
        private ForgotpasswordController initcont;
    
    @Test 
    public void TestLogin(){
        ForgotPasswordView win = new ForgotPasswordView();
        initcont = new ForgotpasswordController(win);
        boolean actual = initcont.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
}
