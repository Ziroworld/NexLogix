
package Testing;
import Controller.*;
import View.customerDashboard;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerTesting {
    private CusDeleteSelfController test1;
    private customerDashboard board;
    
     @Test 
    public void TestAdminCreateCustomer(){
        board = new customerDashboard();
        test1 = new CusDeleteSelfController(board);
        boolean actual = test1.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
}
