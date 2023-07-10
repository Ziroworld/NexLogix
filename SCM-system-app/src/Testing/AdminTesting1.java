
package Testing;
import Controller.*;
import View.AdminDashboard;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdminTesting1 {
    private AdminCreateCustomerController test1;
    private AdminCreateSupController test2;
    private AdminDeleteProductController test3;
    private AdminDeleteSupController test4;
    private AdminUpdateProductController test5;
    private adminCdeleteController test6;
    private AdminDashboard board;
    
    @Test 
    public void TestAdminCreateCustomer(){
        board = new AdminDashboard();
        test1 = new AdminCreateCustomerController(board);
        boolean actual = test1.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestAdminCreateSupplier(){
        board = new AdminDashboard();
        test2 = new AdminCreateSupController(board);
        boolean actual = test2.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestAdminDeleteProduct(){
        board = new AdminDashboard();
        test3 = new AdminDeleteProductController(board);
        boolean actual = test3.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestAdminDeleteSupplier(){
        board = new AdminDashboard();
        test4 = new AdminDeleteSupController(board);
        boolean actual = test4.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestAdminUpdateProduct(){
        board = new AdminDashboard();
        test5 = new AdminUpdateProductController(board);
        boolean actual = test5.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
    @Test 
    public void TestAdminDeleteCustomer(){
        board = new AdminDashboard();
        test6 = new adminCdeleteController(board);
        boolean actual = test6.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
}
