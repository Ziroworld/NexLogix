
package Controller;
import View.*;
import Database.*;
import Model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class ForgotpasswordController {
    private ForgotPasswordView view;
    private ForgotPasswordModel model;
    private ForgotPasswordDatabase database;
    private boolean result;
    public boolean testdata;
    
    public ForgotpasswordController(ForgotPasswordView view){
        this.view = view;
        this.database = new ForgotPasswordDatabase();
        view.addForgotListener(new ButtonListener());
    }
    
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent e){
            try{
                result = false;
                model = view.getData();
                if (validateFields(model)) {
                    if (database.checkUser(model.getUsername())) {
                        if (database.passwordUpdated(model)) {
                            result = true;
                            showMessage("Password updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            view.clearFields();
                        } else {
                            showMessage("Failed to update password.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        showMessage("Invalid username.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            catch(Exception e1){
                e1.getMessage();
            }
        }
    }
    
    public boolean testData(){
        return result;
    }
    
    private boolean validateFields(ForgotPasswordModel model) {
            if (model.getUsername().isEmpty() || model.getNewpasswords().isEmpty() || model.getConfirmpassword().isEmpty()) {
                showMessage("All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (model.getNewpasswords().length() < 8) {
                showMessage("Password must be at least 8 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (!model.getNewpasswords().equals(model.getConfirmpassword())) {
                showMessage("Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
    }
    
        public void showMessage(String message, String title, int messageType) {
        JDialog dialog = new JDialog((Frame) null, title, true);
        JOptionPane optionPane = new JOptionPane(message, messageType);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setBackground(Color.DARK_GRAY);
        dialog.pack();

        // Set the dialog location to the center of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int dialogWidth = dialog.getWidth();
        int dialogHeight = dialog.getHeight();
        int dialogX = (screenSize.width - dialogWidth) / 2;
        int dialogY = (screenSize.height - dialogHeight) / 2;
        dialog.setLocation(dialogX, dialogY);

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
    }
}
