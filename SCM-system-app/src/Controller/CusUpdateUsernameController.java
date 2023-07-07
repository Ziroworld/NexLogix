
package Controller;
import View.*;
import Model.*;
import Database.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class CusUpdateUsernameController {
    private final CupdateFrame view;
    private CusUpdateUsernameModel model;
    private final CusUpdateUsernameDatabase database;
    
    public CusUpdateUsernameController ( CupdateFrame view){
        this.view = view;
        this.database = new CusUpdateUsernameDatabase();
        view.addButtonListener(new ButtonListener());
    }
    
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                model = view.getData();
                if (isInputValid(model)) {
                    if (checkUserExist(model.getOldusername())) {
                        if (updateUsername(model.getOldusername(), model.getNewusername(), model.getPassword())) {
                            view.clearMeData();
                            showMessage("Customer data updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            showMessage("Failed to update customer data.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        showMessage("User does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    showMessage("All Field are Required.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(HeadlessException e1)
            {
                e1.getMessage();
            }
        }
    }
    
    private boolean isInputValid(CusUpdateUsernameModel model) {
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
