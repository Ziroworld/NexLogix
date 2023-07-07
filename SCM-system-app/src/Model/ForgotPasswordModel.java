
package Model;

public class ForgotPasswordModel {
    private String username;
    private String newpasswords;
    private String confirmpassword;
    
    public ForgotPasswordModel(String username, String newpassword, String confirmpassword){
        this.username = username;
        this.newpasswords = newpassword;
        this.confirmpassword = confirmpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewpasswords() {
        return newpasswords;
    }

    public void setNewpasswords(String newpasswords) {
        this.newpasswords = newpasswords;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    
}
