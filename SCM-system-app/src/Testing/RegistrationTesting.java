
package Testing;
import Controller.*;
import View.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class RegistrationTesting {
    private supUserController initcont1;
    private cusUserController initcont2;
    
    
    @Test 
    public void TestSupRegistration(){
        supRegistration win = new supRegistration();
        initcont1 = new supUserController(win);
        boolean actual = initcont1.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestCusRegistraion(){
        CusRegistration win = new CusRegistration();
        initcont2 = new cusUserController(win);
        boolean actual = initcont2.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
}
