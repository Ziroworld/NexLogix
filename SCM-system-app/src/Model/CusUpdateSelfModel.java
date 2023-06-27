
package Model;

public class CusUpdateSelfModel {
    String txtusername;
    String txtfname;
    String txtlname; 
    String txtemail;
    String txtphone;
    String txtpassword;
    
    public CusUpdateSelfModel(String txtusername, String txtfname, String txtlname, String txtemail, String txtphone, String txtpassword){
        this.txtusername = txtusername;
        this.txtfname = txtfname;
        this.txtlname = txtlname;
        this.txtemail = txtemail;
        this.txtphone = txtphone;
        this.txtpassword = txtpassword;
    }

    public String getTxtusername() {
        return txtusername;
    }

    public void setTxtusername(String txtusername) {
        this.txtusername = txtusername;
    }

    public String getTxtfname() {
        return txtfname;
    }

    public void setTxtfname(String txtfname) {
        this.txtfname = txtfname;
    }

    public String getTxtlname() {
        return txtlname;
    }

    public void setTxtlname(String txtlname) {
        this.txtlname = txtlname;
    }

    public String getTxtemail() {
        return txtemail;
    }

    public void setTxtemail(String txtemail) {
        this.txtemail = txtemail;
    }

    public String getTxtphone() {
        return txtphone;
    }

    public void setTxtphone(String txtphone) {
        this.txtphone = txtphone;
    }

    public String getTxtpassword() {
        return txtpassword;
    }

    public void setTxtpassword(String txtpassword) {
        this.txtpassword = txtpassword;
    }
}
