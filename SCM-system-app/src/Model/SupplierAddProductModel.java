
package Model;

public class SupplierAddProductModel {
    String productname ;
    Double productprice;
    String suppliername;
    
    public SupplierAddProductModel(String productname, Double productprice, String suppliername){
        this.productname = productname;
        this.productprice = productprice;
        this.suppliername = suppliername;
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
