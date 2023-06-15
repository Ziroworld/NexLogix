/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rohan-manandhar
 */
public class supRegModel {
    private String username;
    private String companyname;
    private String email;
    private int phone;
    private String password;
    private String Cpassword;

    public supRegModel(String username, String companyname, String email, int phone, String password, String Cpassword) {
        this.username = username;
        this.companyname = companyname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.Cpassword = Cpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public void setCpassword(String Cpassword) {
        this.Cpassword = Cpassword;
    }
    
}
