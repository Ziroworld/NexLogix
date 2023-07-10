
package Controller;
import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDeleteOrderController {
    private customerDashboard view;
    private CustomerDeleteOrderModel model;
    private boolean result;
    public boolean testdata;
    
    public CustomerDeleteOrderController(customerDashboard view){
        this.view = view;
        this.view.AddDeleteButtonLIstener(new DeleteButtonListener());
    }
    
    class DeleteButtonListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("rediredted succesfully");
            
            if (e.getSource() == view.getBtnDeleteOrder()){
                int selectedRow = view.getOrderTable().getSelectedRow();
                
                if(selectedRow != 1){
                    int orderid = (int) view.getOrderTable().getValueAt(selectedRow, 0);
                    System.out.println("Done");
                    System.out.println(orderid);
                    deleteOrder(orderid);
                }else{
                    view.displayErrorMessage("Please Select a order to delete");
                }
            }
        }
        
    public boolean testdata(){
        return result;
    }
        
        public void deleteOrder(int orderid){
            result = false;
            model = new CustomerDeleteOrderModel();
            if (model.checkOrder(orderid)) {
                if (model.deleteOrder(orderid)) {
                    result = true;
                    view.displaySuccessMessage("Order deleted successfully.");
                } else {
                    view.displayErrorMessage("Failed to delete order.");
                }
            } else {
                view.displayErrorMessage("Order not found.");
            }
        }
    }
    
    
}
