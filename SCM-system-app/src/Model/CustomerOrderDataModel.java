
package Model;

public class CustomerOrderDataModel {
    private int orderid;
    private String customername;
    private int productid;
    
    // constructor
    public CustomerOrderDataModel(int orderid, String customername, int productid){
        this.orderid = orderid;
        this.customername = customername;
        this.productid = productid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
    
    
}
