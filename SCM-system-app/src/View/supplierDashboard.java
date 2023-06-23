
package View;

import javax.swing.*;
import Model.*;
import Controller.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class supplierDashboard extends javax.swing.JFrame {
    SupplierAddProductModel Model;
    private SupplierAddProductController S1;
    DefaultTableModel dtm;
    private SupDeleteProductController controller;
    
    /**
     * Creates new form supplierDashboard
     */
    public supplierDashboard() {
        initComponents();
        controller = new SupDeleteProductController(this);
    }
    public SupplierAddProductModel getProduct()
    {
        String productName = txtproductname.getText();
        double productPrice = Double.parseDouble(txtproductprice.getText());
        String supplierName = txtsuppliername.getText();

        Model = new SupplierAddProductModel(productName, productPrice, supplierName);
        return Model;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        producttable = new javax.swing.JTable();
        btnaddProduct = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        btnProductView = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        txtproductname = new javax.swing.JTextField();
        txtproductprice = new javax.swing.JTextField();
        txtsuppliername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sOrdertable = new javax.swing.JTable();
        btnorderview = new javax.swing.JButton();
        txtCheck = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSview = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        profiletable = new javax.swing.JTable();
        txtSdeleteId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUusername = new javax.swing.JTextField();
        txtUcompanyname = new javax.swing.JTextField();
        txtUemail = new javax.swing.JTextField();
        txtUphone = new javax.swing.JTextField();
        txtUpassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnlogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supplier Dashboard");

        mainPanel.setBackground(new java.awt.Color(149, 173, 217));

        jPanel4.setBackground(new java.awt.Color(102, 0, 102));

        producttable.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        producttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Product name", "Product price", "Supplier name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        producttable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(producttable);

        btnaddProduct.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        btnaddProduct.setText("Add product");
        btnaddProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnaddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddProductActionPerformed(evt);
            }
        });

        btnUpdateProduct.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        btnUpdateProduct.setText("Update Product");
        btnUpdateProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnProductView.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        btnProductView.setText("View Product");
        btnProductView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductViewActionPerformed(evt);
            }
        });

        btnDeleteProduct.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        btnDeleteProduct.setText("Delete Product");

        txtproductname.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        txtproductname.setBorder(null);
        txtproductname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtproductnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtproductnameFocusLost(evt);
            }
        });

        txtproductprice.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        txtproductprice.setBorder(null);
        txtproductprice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtproductpriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtproductpriceFocusLost(evt);
            }
        });

        txtsuppliername.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        txtsuppliername.setBorder(null);
        txtsuppliername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsuppliernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsuppliernameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnUpdateProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProductView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnDeleteProduct, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnaddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtproductname, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtproductprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(txtsuppliername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator2)
                                .addComponent(jSeparator3)))
                        .addGap(86, 86, 86))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproductname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtproductprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProductView)))
                    .addComponent(btnUpdateProduct))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsuppliername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(btnDeleteProduct)
                        .addGap(28, 28, 28))))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Products", jPanel4);

        jPanel5.setBackground(new java.awt.Color(102, 0, 102));

        sOrdertable.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        sOrdertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order Id", "Customer name", "Product Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(sOrdertable);

        btnorderview.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        btnorderview.setText("View order");
        btnorderview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnorderviewActionPerformed(evt);
            }
        });

        txtCheck.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        txtCheck.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCheckFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCheckFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnorderview, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txtCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnorderview, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Orders", jPanel5);

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

        jButton1.setText("Update");

        jButton2.setText("Delete Account");

        btnSview.setText("View My Data");

        profiletable.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        profiletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Username", "Company Name", "Email", "Phone", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(profiletable);

        txtSdeleteId.setText("Username");

        jLabel2.setText("Image");

        txtUusername.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        txtUusername.setText("username");

        txtUcompanyname.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        txtUcompanyname.setText("Company name");

        txtUemail.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        txtUemail.setText("email");

        txtUphone.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        txtUphone.setText("Phone");

        txtUpassword.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        txtUpassword.setText("Password");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnSview, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUcompanyname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUusername, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUemail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUphone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSdeleteId, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSview)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUcompanyname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtUemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUphone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtSdeleteId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("My Profile", jPanel3);

        jLabel1.setFont(new java.awt.Font("Liberation Mono", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome Supplier");

        btnlogout.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        btnlogout.setText("Logout here...");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlogout)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlogout, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        JOptionPane.showMessageDialog(this, "Thanks for the hardwork", "supplier", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnaddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddProductActionPerformed
        if (S1 == null) {
        S1 = new SupplierAddProductController(this);
        }
    }//GEN-LAST:event_btnaddProductActionPerformed

    private void txtproductpriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtproductpriceFocusGained
        if (txtproductprice.getText().equals("Enter Product Price"))
        {
            txtproductprice.setText("");
            txtproductprice.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtproductpriceFocusGained

    private void txtproductpriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtproductpriceFocusLost
        if (txtproductprice.getText().equals(""))
        {
            txtproductprice.setText("Enter Product Price");
            txtproductprice.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtproductpriceFocusLost

    private void txtsuppliernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsuppliernameFocusGained
        if (txtsuppliername.getText().equals("Enter Supplier Name"))
        {
            txtsuppliername.setText("");
            txtsuppliername.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtsuppliernameFocusGained

    private void txtsuppliernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsuppliernameFocusLost
        if (txtsuppliername.getText().equals(""))
        {
            txtsuppliername.setText("Enter Supplier Name");
            txtsuppliername.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtsuppliernameFocusLost

    private void txtproductnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtproductnameFocusGained
        if (txtproductname.getText().equals("Enter Product Name "))
        {
            txtproductname.setText("");
            txtproductname.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtproductnameFocusGained

    private void txtproductnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtproductnameFocusLost
        if (txtproductname.getText().equals(""))
        {
            txtproductname.setText("Enter Product Name ");
            txtproductname.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtproductnameFocusLost

    private void btnProductViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductViewActionPerformed
        pViewModel Model = new pViewModel();
        // Getting the value
        List <SupplierViewProductModel> productList = Model.getProductData();
        
        dtm = (DefaultTableModel) producttable.getModel();
        
        // Clear existing rows in the table
        dtm.setRowCount(0);

        // Iterate over the product list and access the data
        for (SupplierViewProductModel product : productList) {
            int pid = product.getPid();
            String productName = product.getProductname();
            double productPrice = product.getProductprice();
            String supplierUsername = product.getSuppplierusername();

            // Create an object with product data
            Object[] rowData = {pid, productName, productPrice, supplierUsername};

            // Add the row to the table model
            dtm.addRow((Object[]) rowData);
        }
    }//GEN-LAST:event_btnProductViewActionPerformed

    private void btnorderviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnorderviewActionPerformed
        String checkId = txtCheck.getText();
        
        if (checkId.isEmpty()) {
        // Displaying an error message if the check ID is empty
        JOptionPane.showMessageDialog(null, "Please enter a valid check ID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    SupOrderViewModel model = new SupOrderViewModel();
    List<SupOrderDataModel> orderList = model.getOrderData(checkId); // Getting the order data
    
    if (orderList.isEmpty()) {
        // Displaying a message if no order data found for the check ID
        JOptionPane.showMessageDialog(null, "No order data found for the specified check ID.", "No Data", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    dtm = (DefaultTableModel) sOrdertable.getModel();
    dtm.setRowCount(0);

    for (SupOrderDataModel order : orderList) {
        int orderId = order.getOrderid();
        String customerName = order.getCustomername();
        int productId = order.getProductid();

        Object[] rowData = {orderId, customerName, productId};
        dtm.addRow(rowData);
        }  
    }//GEN-LAST:event_btnorderviewActionPerformed

    private void txtCheckFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCheckFocusGained
        if (txtCheck.getText().equals("Enter your ID: "))
        {
            txtCheck.setText("");
            txtCheck.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtCheckFocusGained

    private void txtCheckFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCheckFocusLost
        if (txtCheck.getText().equals(""))
        {
            txtCheck.setText("Enter your ID: ");
            txtCheck.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtCheckFocusLost

    // Add ActionListener
    public void addProductListener(ActionListener log)
    {
        btnaddProduct.removeActionListener(log); 
        btnaddProduct.addActionListener(log);
    }
    
    // DELETE ACTIONS   //
    
    public void addButtonListener(ActionListener listener) {
        btnDeleteProduct.addActionListener(listener);
    }

    public JButton getBtnDeleteProduct() {
        System.out.println(" demo");
        return btnDeleteProduct;
    }

    public JTable getProductTable() {
        return producttable;
    }
    
    
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displaySuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(supplierDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplierDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplierDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplierDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new supplierDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnProductView;
    private javax.swing.JButton btnSview;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JButton btnaddProduct;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnorderview;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable producttable;
    private javax.swing.JTable profiletable;
    private javax.swing.JTable sOrdertable;
    private javax.swing.JTextField txtCheck;
    private javax.swing.JTextField txtSdeleteId;
    private javax.swing.JTextField txtUcompanyname;
    private javax.swing.JTextField txtUemail;
    private javax.swing.JTextField txtUpassword;
    private javax.swing.JTextField txtUphone;
    private javax.swing.JTextField txtUusername;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JTextField txtproductprice;
    private javax.swing.JTextField txtsuppliername;
    // End of variables declaration//GEN-END:variables
}
