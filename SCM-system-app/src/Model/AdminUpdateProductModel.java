
package Model;

public class AdminUpdateProductModel {
    private int pid;
    private String productname;
    private Double productprice;
    
    public AdminUpdateProductModel(int pid, String productname, Double productprice){
        this.pid = pid;
        this.productname = productname;
        this.productprice = productprice;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }
    
}
