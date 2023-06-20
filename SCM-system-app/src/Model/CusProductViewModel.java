
package Model;


public class CusProductViewModel {
    private int pid; 
    private String productname;
    private Double productprice;
    private String suppplierusername;
    
    // constructor
    public CusProductViewModel(int pid, String productname, Double productprice, String supplierusername)
    {
        this.pid = pid;
        this.productname = productname;
        this.productprice = productprice;
        this.suppplierusername = supplierusername;
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

    public String getSuppplierusername() {
        return suppplierusername;
    }

    public void setSuppplierusername(String suppplierusername) {
        this.suppplierusername = suppplierusername;
    }
    
    
}
