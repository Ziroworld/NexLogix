
package Model;

public class CusUpdateUsernameModel {
    private String oldusername;
    private String newusername;
    private String password;
    
    public CusUpdateUsernameModel(String oldusername, String newusername, String password){
        this.oldusername = oldusername;
        this.newusername = newusername;
        this.password = password;
    }

    public String getOldusername() {
        return oldusername;
    }

    public void setOldusername(String oldusername) {
        this.oldusername = oldusername;
    }

    public String getNewusername() {
        return newusername;
    }

    public void setNewusername(String newusername) {
        this.newusername = newusername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean hasEmptyFields() {
        return oldusername.isEmpty() || newusername.isEmpty() || password.isEmpty();
    }
}
