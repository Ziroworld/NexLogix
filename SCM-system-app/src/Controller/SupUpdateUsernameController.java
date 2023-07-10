
package Controller;
import Database.*;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class SupUpdateUsernameController {
    private final SupdateFrame view;
    private SupUpdateUsernameModel model;
    private final SupUpdateUsernameDatabase database ;
    private boolean result;
    public boolean testdata;
    
    public SupUpdateUsernameController(SupdateFrame view){
        this.view = view;
        this.database = new SupUpdateUsernameDatabase();
        view.addButtonListener(new ButtonListener());
    }
    
    class ButtonListener implements ActionListener 
    {
        @Override
        public void actionPerformed( ActionEvent e){
            try{
                result = false;
                model = view.getData();
                if (isInputValid(model)) {
                    if (checkUserExist(model.getOldusername())) {
                        if (updateUsername(model.getOldusername(), model.getNewusername(), model.getPassword())) {
                            result = true;
                            view.clearMeData();
                            showMessage("Supplier data updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            showMessage("Failed to update supplier data.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        showMessage("Username does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    showMessage("All Field are Required.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception e1){
                e1.getMessage();
            }
        }
    }
    
    public boolean testdata(){
        return result;
    }
    
    private boolean isInputValid(SupUpdateUsernameModel model) {
        if (!model.hasEmptyFields()){
        return true;
        }
        return false;
    }
    
    public boolean checkUserExist(String oldUsername) {
        return database.checkUser(oldUsername);
    }

    public boolean updateUsername(String oldUsername, String newUsername, String password) {
        return database.updateUsername(oldUsername, newUsername, password);
    }
    
    private void showMessage(String message, String title, int messageType) {
        view.setMessageBoxText(message);
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setMessageBoxText("");
            }
        });

        timer.setRepeats(false);
        timer.start();
    }
}
