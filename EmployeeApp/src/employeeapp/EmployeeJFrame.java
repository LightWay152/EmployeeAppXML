package employeeapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * @author DaoNguyen
 */
public class EmployeeJFrame extends javax.swing.JFrame {

    DocumentBuilderFactory dbf;
    DocumentBuilder builder;
    Document doc;
    String fileName = "src/employeeapp/employee.xml";
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<Employee> employeeList;
    
    public void displayTableInfo(){     
        try {
            dbf = DocumentBuilderFactory.newInstance();
            builder = dbf.newDocumentBuilder();
            doc = builder.parse(fileName);
            
            //get nodes in xml file
            NodeList listId = doc.getElementsByTagName("id");
            NodeList listFullName = doc.getElementsByTagName("fullName");
            NodeList listAddress = doc.getElementsByTagName("address");
            NodeList listSalary = doc.getElementsByTagName("salary");
            NodeList listDepartmentName = doc.getElementsByTagName("departmentName");
            NodeList listMobile = doc.getElementsByTagName("mobile");
            
            //add nodes got into arraylist
            employeeList = new ArrayList<>();
            for(int i=0; i<listId.getLength(); i++){
                Employee emp = new Employee();
                emp.setId(listId.item(i).getTextContent());
                emp.setFullName(listFullName.item(i).getTextContent());
                emp.setAddress(listAddress.item(i).getTextContent());
                emp.setSalary(listSalary.item(i).getTextContent());
                emp.setDepartmentName(listDepartmentName.item(i).getTextContent());
                emp.setMobile(listMobile.item(i).getTextContent());
                
                employeeList.add(emp);
            }
            
            //add data into table
            model.setRowCount(0);
            model.setColumnCount(0);
            
            model.addColumn("Id");
            model.addColumn("Full Name");
            model.addColumn("Address");
            model.addColumn("Salary");
            model.addColumn("Department Name");
            model.addColumn("Mobile");
            
            for (Employee employee : employeeList) {
                Vector vec = new Vector();
                vec.add(employee.getId());
                vec.add(employee.getFullName());
                vec.add(employee.getAddress());
                vec.add(employee.getSalary());
                vec.add(employee.getDepartmentName());
                vec.add(employee.getMobile());
                
                model.addRow(vec);
            }
            
            tblInfo.setModel(model);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(EmployeeJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(EmployeeJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public EmployeeJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        displayTableInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        LabelFullName = new javax.swing.JLabel();
        LabelAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        LabelSalary = new javax.swing.JLabel();
        LabelDepartmentName = new javax.swing.JLabel();
        txtDepartmentName = new javax.swing.JTextField();
        LabelMobile = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInfo = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        txtFullName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee App");

        LabelId.setText("Id");

        LabelFullName.setText("Full Name");

        LabelAddress.setText("Address");

        LabelSalary.setText("Salary");

        LabelDepartmentName.setText("Department Name");

        txtDepartmentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartmentNameActionPerformed(evt);
            }
        });

        LabelMobile.setText("Mobile");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInfo);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelFullName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelDepartmentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelMobile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelSalary)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnReload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelFullName)
                    .addComponent(LabelDepartmentName)
                    .addComponent(txtDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(btnClear)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelMobile)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int check = 1;
        Employee emp = new Employee();
        emp.setId(txtId.getText());
        emp.setFullName(txtFullName.getText());
        emp.setAddress(txtAddress.getText());
        emp.setSalary(txtSalary.getText());
        emp.setDepartmentName(txtDepartmentName.getText());
        emp.setMobile(txtMobile.getText());
            
        //handle new employee duplicated
        for(int i=0; i<employeeList.size(); i++){
            if(employeeList.get(i).getId().compareToIgnoreCase(txtId.getText())==0){
                //if check employee id:
                // if result is 0 -> id duplicated
                // if result is 1 -> id not duplicated
                
                //if id duplicated -> check = 0, break to out of loop
                check = 0;
                break;
            }
        }
        if(check == 1){
            JOptionPane.showMessageDialog(null, "Employee Id is not existed !!!");
        }
        else{//check == 0
            removeEmployee();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void txtDepartmentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartmentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartmentNameActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        displayTableInfo();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void onMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onMouseClicked
        int row = tblInfo.getSelectedRow();
        String id = (String) tblInfo.getValueAt(row, 0);
        String fullName = (String) tblInfo.getValueAt(row, 1);
        String address = (String) tblInfo.getValueAt(row, 2);
        String salary = (String) tblInfo.getValueAt(row, 3);
        String departmentName = (String) tblInfo.getValueAt(row, 4);
        String mobile = (String) tblInfo.getValueAt(row, 5);
        
        //get value at cell on textView
        txtId.setText(id);
        txtFullName.setText(fullName);
        txtAddress.setText(address);
        txtSalary.setText(salary);
        txtDepartmentName.setText(departmentName);
        txtMobile.setText(mobile);
    }//GEN-LAST:event_onMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int ret=JOptionPane.showConfirmDialog(null, 
                        "Are you sure want to exit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION);
        if(ret==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       clearTableInfo();
    }//GEN-LAST:event_btnClearActionPerformed

    public void clearTableInfo(){
        txtId.setText("");
        txtFullName.setText("");
        txtAddress.setText("");
        txtSalary.setText("");
        txtDepartmentName.setText("");
        txtMobile.setText("");
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int check = 1;
        Employee emp = new Employee();
        emp.setId(txtId.getText());
        emp.setFullName(txtFullName.getText());
        emp.setAddress(txtAddress.getText());
        emp.setSalary(txtSalary.getText());
        emp.setDepartmentName(txtDepartmentName.getText());
        emp.setMobile(txtMobile.getText());
            
        //handle new employee duplicated
        for(int i=0; i<employeeList.size(); i++){
            if(employeeList.get(i).getId().compareToIgnoreCase(txtId.getText())==0){
                //if check employee id:
                // if result is 0 -> id duplicated
                // if result is 1 -> id not duplicated
                
                //if id duplicated -> check = 0, break to out of loop
                check = 0;
                break;
            }
        }
        if(check == 0){
            JOptionPane.showMessageDialog(null, "Employee Id duplicated !!!");
        }
        else if(txtId.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Employee Id empty !!!");
        }
        else{
            int ret=JOptionPane.showConfirmDialog(null, 
                            "Employee Id is not duplicated.\nAre you sure want to add new?",
                            "Confirm Add New",
                            JOptionPane.YES_NO_OPTION);
            if(ret==JOptionPane.YES_OPTION)
            {
                Element company = doc.getDocumentElement();
                addNewEmployee(doc, company, emp);
                saveFile();
                displayTableInfo();
                JOptionPane.showMessageDialog(null, "Add new employee successfully !!!");
            }
           
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int check = 1;
        Employee emp = new Employee();
        emp.setId(txtId.getText());
        emp.setFullName(txtFullName.getText());
        emp.setAddress(txtAddress.getText());
        emp.setSalary(txtSalary.getText());
        emp.setDepartmentName(txtDepartmentName.getText());
        emp.setMobile(txtMobile.getText());
            
        //handle new employee duplicated
        for(int i=0; i<employeeList.size(); i++){
            if(employeeList.get(i).getId().compareToIgnoreCase(txtId.getText())==0){
                //if check employee id:
                // if result is 0 -> id duplicated
                // if result is 1 -> id not duplicated
                
                //if id duplicated -> check = 0, break to out of loop
                check = 0;
                break;
            }
        }
        if(check == 1){
            JOptionPane.showMessageDialog(null, "Employee Id is not existed !!!");
        }
        else{//check == 0
            int ret=JOptionPane.showConfirmDialog(null, 
                            "Employee Id is existed.\nAre you sure want to edit?",
                            "Confirm Edit",
                            JOptionPane.YES_NO_OPTION);
            if(ret==JOptionPane.YES_OPTION)
            {
                updateEmployeeInfo();
                JOptionPane.showMessageDialog(null, "Edit employee successfully !!!");
            }
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAddress;
    private javax.swing.JLabel LabelDepartmentName;
    private javax.swing.JLabel LabelFullName;
    private javax.swing.JLabel LabelId;
    private javax.swing.JLabel LabelMobile;
    private javax.swing.JLabel LabelSalary;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInfo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDepartmentName;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables

    private void addNewEmployee(Document document, Element company, Employee employee) {
        Element employeeElement = document.createElement("employee");
        Element id = document.createElement("id");
        Element fullName = document.createElement("fullName");
        Element address = document.createElement("address");
        Element salary = document.createElement("salary");
        Element department = document.createElement("department");
        Element departmentName = document.createElement("departmentName");
        Element mobile = document.createElement("mobile");
        
        Text txtId = document.createTextNode(employee.getId());
        Text txtFullName = document.createTextNode(employee.getFullName());
        Text txtAddress = document.createTextNode(employee.getAddress());
        Text txtSalary = document.createTextNode(employee.getSalary());
        Text txtDepartmentName = document.createTextNode(employee.getDepartmentName());
        Text txtMobile = document.createTextNode(employee.getMobile());
        
        company.appendChild(employeeElement);
        employeeElement.appendChild(id);
        employeeElement.appendChild(fullName);
        employeeElement.appendChild(address);
        employeeElement.appendChild(salary);
        employeeElement.appendChild(department);
        department.appendChild(departmentName);
        department.appendChild(mobile);
        
        id.appendChild(txtId);
        fullName.appendChild(txtFullName);
        address.appendChild(txtAddress);
        salary.appendChild(txtSalary);
        departmentName.appendChild(txtDepartmentName);
        mobile.appendChild(txtMobile);
    }
    
    public void saveFile(){
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer;
            transformer = factory.newTransformer();
        
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("src/employeeapp/employee.xml");
            transformer.transform(source, result);
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(EmployeeJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(EmployeeJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateEmployeeInfo() {
        try {
            String st = "company/employee[id= '"+txtId.getText()+"']";
            XPathFactory xpf = XPathFactory.newInstance();
            XPath path = xpf.newXPath();
            Node emp = (Node) path.evaluate(st, doc,XPathConstants.NODE);
            
            NodeList child = emp.getChildNodes();
            child.item(3).setTextContent(txtFullName.getText());
            child.item(6).setTextContent(txtAddress.getText());
            child.item(7).setTextContent(txtSalary.getText());
            
            NodeList childLevel2 = child.item(9).getChildNodes();
            childLevel2.item(1).setTextContent(txtDepartmentName.getText());
            childLevel2.item(3).setTextContent(txtMobile.getText());
            
            saveFile();
            displayTableInfo();
            
        } catch (XPathExpressionException ex) {
            Logger.getLogger(EmployeeJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void removeEmployee() {
        try {
            String st = "company/employee[id= '"+txtId.getText()+"']";
            XPathFactory xpf = XPathFactory.newInstance();
            XPath path = xpf.newXPath();
            Node emp = (Node) path.evaluate(st, doc,XPathConstants.NODE);
            
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?");
            if(confirm == 0){
                //get parent node of node needed to delete
                Node parent = emp.getParentNode();
                //delete child node of parent node
                parent.removeChild(emp);
                
                //after delete save file and display table info again
                saveFile();
                clearTableInfo();
                displayTableInfo();
                JOptionPane.showMessageDialog(null, "Remove employee successfully !!!");
            }
            
        } catch (XPathExpressionException ex) {
            Logger.getLogger(EmployeeJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
