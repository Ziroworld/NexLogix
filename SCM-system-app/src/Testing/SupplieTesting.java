
package Testing;
import Controller.*;
import View.supplierDashboard;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SupplieTesting {
    private SupDeleteProductController test1;
    private supplierDashboard board;
    
     @Test 
    public void TestAdminCreateCustomer(){
        board = new supplierDashboard();
        test1 = new SupDeleteProductController(board);
        boolean actual = test1.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
}
