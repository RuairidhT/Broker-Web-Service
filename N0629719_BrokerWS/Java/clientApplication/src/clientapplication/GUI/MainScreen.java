/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapplication.GUI;

import java.awt.Toolkit;
import static java.lang.Float.parseFloat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ruairidh
 */
public class MainScreen extends javax.swing.JFrame {

    DefaultTableModel model;
    java.util.List<org.netbeans.xml.schema.companyinfo.Company> companies = displayAll();

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        if (spAPI() == false) {
            JOptionPane.showMessageDialog(this, "Prices aren't up to date");
        }
        changeIcon();
        initComponents();
        updateSharePrices();
        addCurrencytoCB();
        runAPI();
        getHost();
        tfCost.setEditable(false);
    }

    //https://youtu.be/GAl1FSKvoFY?t=620
    public void addRowToJTable() {

        java.util.List<org.netbeans.xml.schema.companyinfo.Company> companies = displayAll();

        model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[6];
        for (int i = 0; i < companies.size(); i++) {
            rowData[0] = companies.get(i).getCompanyName();
            rowData[1] = companies.get(i).getCompanySymbol();
            rowData[2] = companies.get(i).getShareAvailability();
            rowData[3] = companies.get(i).getSharePrice().getCurrency();
            rowData[4] = companies.get(i).getSharePrice().getValue();
            rowData[5] = companies.get(i).getSharePrice().getLastUpdate();
            model.addRow(rowData);
        }

    }

    public void addCurrencytoCB() {

        java.util.List<java.lang.String> currencyCodes = getCurrencyCodes();

        for (int i = 0; i < currencyCodes.size(); i++) {
            String c = currencyCodes.get(i);
            String code = c.substring(0, Math.min(c.length(), 3));
            cbCurrency.addItem(code);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfAvailableShares = new javax.swing.JTextField();
        bBuy = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCost = new javax.swing.JTextField();
        cbCurrency = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        updateConversion = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jlServerHost = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oh Yeah Yeah");
        setPreferredSize(new java.awt.Dimension(1000, 470));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company Name", "Company Symbol", "Available Shares", "Currency", "Share Price", "Last Updated"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Buy Shares: ");

        tfAvailableShares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAvailableSharesKeyReleased(evt);
            }
        });

        bBuy.setText("Buy");
        bBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuyActionPerformed(evt);
            }
        });

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Search: ");

        jLabel3.setText("Cost: ");

        cbCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"GBP" }));
        cbCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCurrencyActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel4.setText("Shares Brokering Service");

        updateConversion.setText("Update Conversion Rates");
        updateConversion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateConversionMouseClicked(evt);
            }
        });

        jLabel5.setText("Server Hosted: ");

        jlServerHost.setText("jLabel6");

        jButton1.setText("Update Share Prices");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(cbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(tfAvailableShares, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(44, 44, 44)
                            .addComponent(tfCost, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bBuy)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlServerHost, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(updateConversion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateConversion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(tfAvailableShares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tfCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bBuy)
                        .addComponent(jLabel5)
                        .addComponent(jlServerHost)))
                .addGap(30, 30, 30))
        );

        setBounds(0, 0, 937, 554);
    }// </editor-fold>//GEN-END:initComponents

    private void bBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuyActionPerformed

        if (!this.jTable1.getSelectionModel().isSelectionEmpty()) {
            if (parseFloat(this.tfAvailableShares.getText()) > parseFloat(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString())) {
                JOptionPane.showMessageDialog(this, "Not enough shares are avaialable!");
            } else {
                String s = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString();
                buyShares(s, Integer.parseInt(this.tfAvailableShares.getText()));

                String amount = this.tfAvailableShares.getText();
                String company = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString();
                float sharePrice = parseFloat(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString());
                String shareA = this.tfAvailableShares.getText();
                float nShares = parseFloat(shareA);
                String cost = String.valueOf(sharePrice * nShares);
                String currency = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString();
                JOptionPane.showMessageDialog(this, "You've bought " + amount + " Shares of " + company + " for " + cost + " " + currency);

                addRowToJTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a company");
        }

    }//GEN-LAST:event_bBuyActionPerformed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(tfSearch.getText().toUpperCase()));
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tfAvailableSharesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAvailableSharesKeyReleased
        int x = -1;
        try {
            x = Integer.parseInt(tfAvailableShares.getText());
        } catch (NumberFormatException nfe) {
            tfAvailableShares.setText("");
        }
        if (x > 0) {
            updatePriceBox();
        }
    }//GEN-LAST:event_tfAvailableSharesKeyReleased

    private void cbCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCurrencyActionPerformed

        String cCurrency = this.jTable1.getValueAt(2, 3).toString();
        String nCurrency = String.valueOf(cbCurrency.getSelectedItem());

        float conversion = (float) getConversionRate(cCurrency, nCurrency);

        model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[6];
        for (int i = 0; i < companies.size(); i++) {

            float x = companies.get(i).getSharePrice().getValue();
            float nNumber = x * conversion;

            companies.get(i).getSharePrice().setValue(nNumber);
            companies.get(i).getSharePrice().setCurrency(nCurrency);

            rowData[0] = companies.get(i).getCompanyName();
            rowData[1] = companies.get(i).getCompanySymbol();
            rowData[2] = companies.get(i).getShareAvailability();
            rowData[3] = companies.get(i).getSharePrice().getCurrency();
            rowData[4] = companies.get(i).getSharePrice().getValue();
            rowData[5] = companies.get(i).getSharePrice().getLastUpdate();
            model.addRow(rowData);

        }

    }//GEN-LAST:event_cbCurrencyActionPerformed

    private void updateConversionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateConversionMouseClicked
        runAPI();
    }//GEN-LAST:event_updateConversionMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        spAPI();
        updateSharePrices();
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void changeIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ruairidh\\Documents\\NetBeansProjects\\clientApplication\\taha.jpg"));
    }

    public void getHost() {
        String serverHost = getServerInfo();
        jlServerHost.setText(serverHost);
    }

    public void updateSharePrices() {
        updatedPrice();
        addRowToJTable();

    }

    public void updatePriceBox() {
        String shareA = this.tfAvailableShares.getText();

        if (!this.jTable1.getSelectionModel().isSelectionEmpty()) {
            if (isNumeric(shareA) == true) {
                try {
                    float nShares = parseFloat(shareA);
                    float sharePrice = parseFloat(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString());

                    String cost;
                    cost = String.valueOf(sharePrice * nShares);

                    tfCost.setText(cost);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Please enter a number.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a company");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuy;
    private javax.swing.JComboBox<String> cbCurrency;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlServerHost;
    private javax.swing.JTextField tfAvailableShares;
    private javax.swing.JTextField tfCost;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JButton updateConversion;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<org.netbeans.xml.schema.companyinfo.Company> displayAll() {
        org.me.broker.BrokerWS_Service service = new org.me.broker.BrokerWS_Service();
        org.me.broker.BrokerWS port = service.getBrokerWSPort();
        return port.displayAll();
    }

    private static boolean buyShares(java.lang.String companySymbol, int shareAmount) {
        org.me.broker.BrokerWS_Service service = new org.me.broker.BrokerWS_Service();
        org.me.broker.BrokerWS port = service.getBrokerWSPort();
        return port.buyShares(companySymbol, shareAmount);
    }

    private static java.util.List<java.lang.String> getCurrencyCodes() {
        docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
        docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
        return port.getCurrencyCodes();
    }

    private static double getConversionRate(java.lang.String arg0, java.lang.String arg1) {
        docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
        docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
        return port.getConversionRate(arg0, arg1);
    }

    private static boolean runAPI() {
        docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
        docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
        return port.runAPI();
    }

    private static String getServerInfo() {
        org.me.broker.BrokerWS_Service service = new org.me.broker.BrokerWS_Service();
        org.me.broker.BrokerWS port = service.getBrokerWSPort();
        return port.getServerInfo();
    }

    private static boolean updatedPrice() {
        org.me.broker.BrokerWS_Service service = new org.me.broker.BrokerWS_Service();
        org.me.broker.BrokerWS port = service.getBrokerWSPort();
        return port.updatedPrice();
    }

    private static boolean spAPI() {
        org.me.broker.BrokerWS_Service service = new org.me.broker.BrokerWS_Service();
        org.me.broker.BrokerWS port = service.getBrokerWSPort();
        return port.spAPI();
    }

}