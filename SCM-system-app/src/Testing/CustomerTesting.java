
package Testing;
import Controller.*;
import View.customerDashboard;
import View.CupdateFrame;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerTesting {
    private CusDeleteSelfController test1;
    private CusUpdateSelfController test2;
    private CusUpdateUsernameController test3;
    private CustomerDeleteOrderController test4;
    private CustomerOrderController test5;
    private customerDashboard board;
    private CupdateFrame board1;
    
    @Test 
    public void TestDeleteSelf(){
        board = new customerDashboard();
        test1 = new CusDeleteSelfController(board);
        boolean actual = test1.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestUpdateSelf(){
        board = new customerDashboard();
        test2 = new CusUpdateSelfController(board);
        boolean actual = test2.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestUpdateUsername(){
        board = new customerDashboard();
        test3 = new CusUpdateUsernameController(board1);
        boolean actual = test3.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestDeleteOrder(){
        board = new customerDashboard();
        test4 = new CustomerDeleteOrderController(board);
        boolean actual = test4.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestCustomerOrder(){
        board = new customerDashboard();
        test5 = new CustomerOrderController(board);
        boolean actual = test5.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
}
