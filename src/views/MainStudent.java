/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import config.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainStudent extends javax.swing.JFrame {
    
    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo1;
    DefaultTableModel modelo2;
    String student_id;
    String student_fullname;
    String course_id;
    int selected_row;
    String homework_code;
    
    public MainStudent() {
        initComponents();
        setLocationRelativeTo(null);
        btnOpen.setEnabled(false);
        btnOpen2.setEnabled(false);
    }
    
    public void set_student_id(String login_student_id) {
        student_id = login_student_id;
    }
    
    public void set_student_fullname(String login_student_fullname) {
        student_fullname = login_student_fullname;
        txtStudentName.setText(student_fullname);
    }
    
    public void set_course_id(String login_course_id) {
        course_id = login_course_id;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStudentName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PendingHomeworksTable = new javax.swing.JTable();
        btnOpen = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        RealizedHomeworksTable = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        btnClean2 = new javax.swing.JButton();
        btnOpen2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtStudentName.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        txtStudentName.setText("Nombre del estudiante");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel5.setText("Estudiante:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tareas pendientes:"));

        PendingHomeworksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        PendingHomeworksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PendingHomeworksTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(PendingHomeworksTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnOpen.setText("ABRIR");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnClean.setText("LIMPIAR");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tareas enviadas:"));

        RealizedHomeworksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tarea", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RealizedHomeworksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RealizedHomeworksTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(RealizedHomeworksTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnClose.setText("CERRAR");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnClean2.setText("LIMPIAR");
        btnClean2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClean2ActionPerformed(evt);
            }
        });

        btnOpen2.setText("ABRIR");
        btnOpen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpen2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOpen)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStudentName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClose)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClean2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOpen2)
                                .addGap(9, 9, 9)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStudentName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnClean))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen2)
                    .addComponent(btnClean2))
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PendingHomeworksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PendingHomeworksTableMouseClicked
        btnOpen.setEnabled(true);
        selected_row = PendingHomeworksTable.getSelectedRow();
        if (selected_row == -1) {
            JOptionPane.showMessageDialog(null, "Tarea no seleccionada");
        } else {
            homework_code = (String)PendingHomeworksTable.getValueAt(selected_row, 0);
        }
    }//GEN-LAST:event_PendingHomeworksTableMouseClicked

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clean_fields_pending();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void RealizedHomeworksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RealizedHomeworksTableMouseClicked
        btnOpen2.setEnabled(true);
        selected_row = RealizedHomeworksTable.getSelectedRow();
        if (selected_row == -1) {
            JOptionPane.showMessageDialog(null, "Tarea no seleccionada");
        } else {
            homework_code = (String)RealizedHomeworksTable.getValueAt(selected_row, 0);
        }
    }//GEN-LAST:event_RealizedHomeworksTableMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        PendingHomeworkStudent form = new PendingHomeworkStudent();
        form.set_homework_code(homework_code);
        form.set_student_id(student_id);
        form.set_student_fullname(student_fullname);
        form.setVisible(true);
        form.get_homework_fields();
        this.dispose();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnClean2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClean2ActionPerformed
        clean_fields_realized();
    }//GEN-LAST:event_btnClean2ActionPerformed

    private void btnOpen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpen2ActionPerformed
        RealizedHomeworkStudent form = new RealizedHomeworkStudent();
        form.set_homework_code(homework_code);
        form.set_student_id(student_id);
        form.set_student_fullname(student_fullname);
        form.setVisible(true);
        form.get_homework_fields();
        this.dispose();
    }//GEN-LAST:event_btnOpen2ActionPerformed
/****/
    
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
            java.util.logging.Logger.getLogger(MainStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainStudent().setVisible(true);
            }
        });
    }
    
    public void f_list() {
        
        String SQL = "SELECT code, tittle, deadline FROM homeworks h WHERE h.code "
                + "NOT IN (SELECT homework_code FROM grade WHERE student_id='"+student_id+"')";
        
        String SQL2 = "SELECT h.code, h.tittle, g.score, g.status "
             + "FROM homeworks h "
             + "INNER JOIN grade g ON h.code = g.homework_code "
             + "WHERE g.student_id = '" + student_id + "'";
        
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(SQL);
            
            Object[]homework=new Object[3];
            modelo1=(DefaultTableModel)PendingHomeworksTable.getModel();
            modelo1.setRowCount(0);
            while (rs.next()) {
                homework[0]=rs.getString("code");
                homework[1]=rs.getString("tittle");
                homework[2]=rs.getString("deadline");
                modelo1.addRow(homework);
            }
            PendingHomeworksTable.setModel(modelo1);
            
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(SQL2);
            
            Object[]homeworkR=new Object[3];
            modelo2=(DefaultTableModel)RealizedHomeworksTable.getModel();
            modelo2.setRowCount(0);
            
            while (rs.next()) {
                homeworkR[0]=rs.getString("code");
                homeworkR[1]=rs.getString("tittle");
                if (rs.getString("status").equals("pending")) {
                    homeworkR[2]="Pendiente";
                } else {
                    homeworkR[2]=rs.getFloat("score");
                }
                
                modelo2.addRow(homeworkR);
            }            
            RealizedHomeworksTable.setModel(modelo2);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void clean_table() {
        int row_count = PendingHomeworksTable.getRowCount();
        if (row_count != 0) {
            for (int i = row_count-1; i>=0; i--) {
                modelo1.removeRow(i);
            }
        }
        
        int row_count2 = RealizedHomeworksTable.getRowCount();
        if (row_count2 != 0) {
            for (int i = row_count2-1; i>=0; i--) {
                modelo2.removeRow(i);
            }
        }
        
    }
    
    public void clean_fields_pending() {
        btnOpen.setEnabled(false);
        PendingHomeworksTable.clearSelection();
    }
    
    public void clean_fields_realized() {
        btnOpen2.setEnabled(false);
        RealizedHomeworksTable.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PendingHomeworksTable;
    private javax.swing.JTable RealizedHomeworksTable;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnClean2;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnOpen2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel txtStudentName;
    // End of variables declaration//GEN-END:variables
}
