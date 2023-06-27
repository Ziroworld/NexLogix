
package Model;

public class AdminSendProdDataModel {
    private int pid;
    private String productname;
    private Double productprice;
    private String suppliername;
    
    public AdminSendProdDataModel(int pid, String productname, Double productprice, String suppliername){
        this.pid = pid;
        this.productname = productname;
        this.productprice = productprice;
        this.suppliername = suppliername;
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

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }
    
    
}
