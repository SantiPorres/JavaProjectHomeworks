
package views;

import config.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainTeacher extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    int id;
    public String course_id;
    public String teacher_id;
    JCalendar calendar = new JCalendar();
    Date date_now;
    int selected_row;
    String homework_code;
    
    public MainTeacher() throws ParseException {
        initComponents();
        setLocationRelativeTo(null);
        DateFormat dateFormat = new SimpleDateFormat("MMM d, y");        
        date_now = dateFormat.parse(dateFormat.format(new Date()));
        jdateDeadline.setDate(date_now);
        btnOpen.setEnabled(false);
    }
    
    public void set_teacher_id(String login_teacher_id) {
        teacher_id = login_teacher_id;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HomeworksTable = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        txtTittle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtResource = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jdateDeadline = new com.toedter.calendar.JDateChooser();
        btnClean = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tareas asignadas:"));

        HomeworksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tarea", "Fecha limite"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        HomeworksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeworksTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(HomeworksTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCreate.setText("CREAR TAREA");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnOpen.setText("ABRIR");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        txtTittle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTittleActionPerformed(evt);
            }
        });

        jLabel1.setText("Titulo de la tarea");

        jLabel2.setText("Descripción de la tarea");

        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        jLabel3.setText("Fecha limite");

        txtResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResourceActionPerformed(evt);
            }
        });

        jLabel4.setText("Link recursos");

        btnClean.setText("LIMPIAR");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnClose.setText("CERRAR");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpen))
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTittle, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdateDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtResource, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnClean))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdateDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtResource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String tittle = txtTittle.getText();
        String description = txtDescription.getText();
        java.util.Date date = jdateDeadline.getDate();
        java.sql.Date deadline = new java.sql.Date(date.getTime());
        String resource = txtResource.getText();
        
        if (tittle.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un titulo para crear la tarea");
            if (date.before(date_now)) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una fecha valida");
            }
        } else {
            if (date.before(date_now)) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una fecha valida");
            } else {
                create_homework(tittle, description, deadline, resource);
                f_list();
                clean_fields();
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        HomeworkTeacher form = new HomeworkTeacher();
        form.set_homework_tittle(homework_code);
        form.setVisible(true);
        form.get_homework_fields();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void txtTittleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTittleActionPerformed
        //
    }//GEN-LAST:event_txtTittleActionPerformed

    private void txtResourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResourceActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clean_fields();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void HomeworksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeworksTableMouseClicked
        btnOpen.setEnabled(true);
        selected_row = HomeworksTable.getSelectedRow();
        if (selected_row == -1) {
            JOptionPane.showMessageDialog(null, "Tarea no seleccionada");
        } else {
            homework_code = (String)HomeworksTable.getValueAt(selected_row, 0);
        }
    }//GEN-LAST:event_HomeworksTableMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    
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
            java.util.logging.Logger.getLogger(MainTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainTeacher().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(MainTeacher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void f_list() {
        
        String SQL="SELECT code, tittle, deadline FROM homeworks h INNER JOIN course c "
                + "ON c.id=h.course_id INNER JOIN teacher t ON t.id=c.teacher_id WHERE t.id='"+teacher_id+"'";
        
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(SQL);
            clean_table();
            Object[]homework=new Object[3];
            modelo=(DefaultTableModel)HomeworksTable.getModel();
            while (rs.next()) {
                homework[0]=rs.getString("code");
                homework[1]=rs.getString("tittle");
                homework[2]=rs.getString("deadline");
                modelo.addRow(homework);
            }
            HomeworksTable.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void get_course_by_teacher(String teacher_id) {
        if (teacher_id.equals("")) {
            JOptionPane.showMessageDialog(null, "Error");
        } else {
            String SQL = "SELECT id FROM course WHERE teacher_id='"+teacher_id+"'";
        
            try {
                cn=con.getConnection();
                st=cn.createStatement();
                rs=st.executeQuery(SQL);
                
                if (rs.next()) {
                    course_id = rs.getString("id");
                }

            } catch (SQLException e) {
                System.out.println("get_course_id");
                JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    public void create_homework(String tittle, String description, java.sql.Date deadline, String resource) {
        
        get_course_by_teacher(teacher_id);
        
        if (course_id.equals("")) {
            JOptionPane.showMessageDialog(null, "Error");
        } else {
            String SQL = "INSERT INTO homeworks (course_id, tittle, description, deadline, resource) "
                    + "VALUES('"+course_id+"','"+tittle+"','"+description+"','"+deadline+"','"+resource+"')";
        
            try {
                cn=con.getConnection();
                st=cn.createStatement();
                int rowsAffected=st.executeUpdate(SQL);
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Tarea creada correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "La tarea no se pudo crear");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
                e.printStackTrace();
            }
        }        
    }
    
    public void clean_table() {
        int rowCount = HomeworksTable.getRowCount();
        if (rowCount != 0) {
            for (int i = rowCount-1; i>=0; i--) {
                modelo.removeRow(i);
            }
        }
        
    }
    
    public void clean_fields() {
        txtTittle.setText("");
        txtDescription.setText("");
        jdateDeadline.setDate(date_now);
        txtResource.setText("");
        btnOpen.setEnabled(false);
        HomeworksTable.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HomeworksTable;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnOpen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdateDeadline;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtResource;
    private javax.swing.JTextField txtTittle;
    // End of variables declaration//GEN-END:variables
}
