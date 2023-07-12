
package Testing;
import Controller.*;
import View.supplierDashboard;
import View.SupdateFrame;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SupplieTesting {
    private SupDeleteProductController test1;
    private SupDeleteSelfController test2;
    private SupUpdateProductController test3;
    private SupUpdateSelfController test4;
    private SupUpdateUsernameController test5;
    private SupplierAddProductController test6;
    private supplierDashboard board;
    private SupdateFrame board1;
    
     @Test 
    public void TestDeleteProduct(){
        board = new supplierDashboard();
        test1 = new SupDeleteProductController(board);
        boolean actual = test1.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
     @Test 
    public void TestDeleteSelf(){
        board = new supplierDashboard();
        test2 = new SupDeleteSelfController(board);
        boolean actual = test2.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
     @Test 
    public void TestUpdateproduct(){
        board = new supplierDashboard();
        test3 = new SupUpdateProductController(board);
        boolean actual = test3.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
     @Test 
    public void TestUpdateSelf(){
        board = new supplierDashboard();
        test4 = new SupUpdateSelfController(board);
        boolean actual = test4.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
     @Test 
    public void TestUpdateUsername(){
        board = new supplierDashboard();
        test5 = new SupUpdateUsernameController(board1);
        boolean actual = test5.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
    
     @Test 
    public void TestAddProduct(){
        board = new supplierDashboard();
        test6 = new SupplierAddProductController(board);
        boolean actual = test6.testdata;
        boolean expected =true || false ;
        assertEquals(expected,actual);
        System.out.println("done testing");
    }
}
