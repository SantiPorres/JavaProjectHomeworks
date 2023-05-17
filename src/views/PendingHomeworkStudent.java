/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PendingHomeworkStudent extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    String homework_code;
    String tittle;
    String description;
    Date deadline;
    String resource;
    String created_at;
    String student_id;
    String student_fullname;
    String course_id;
    Date date_now;
    
    public PendingHomeworkStudent() {
        initComponents();
        setLocationRelativeTo(null);
        DateFormat dateFormat = new SimpleDateFormat("MMM d, y");
        try {
            date_now = dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException ex) {
            Logger.getLogger(PendingHomeworkStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void set_student_id(String main_student_id) {
        student_id = main_student_id;
    }
    
    public void set_student_fullname(String login_student_fullname) {
        student_fullname = login_student_fullname;
        txtStudentName.setText(student_fullname);
    }
    
    public void set_course_id(String login_course_id) {
        course_id = login_course_id;
    }
    
    public void set_homework_code(String main_homework_code) {
        homework_code = main_homework_code;
    }
    
    public void get_homework_fields() {
        String SQL = "SELECT tittle, description, deadline, resource, created_at FROM homeworks WHERE code='"+homework_code+"'";
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(SQL);
            
            if (rs.next()) {
                tittle = rs.getString("tittle");
                description = rs.getString("description");
                deadline = rs.getDate("deadline");
                resource = rs.getString("resource");
                created_at = rs.getString("created_at");
                
                set_homework_fields(tittle, description, deadline, resource, created_at);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public void set_homework_fields(String tittle, String description, Date deadline, String resource, String created_at) {
        txtCode.setText(homework_code);
        txtTittle.setText(tittle);
        txtDescription.setText(description);
        txtResource.setText(resource);
        txtDeadline.setText(String.valueOf(deadline));
        txtCreated_At.setText(created_at);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtTittle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JLabel();
        txtDescription = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCreated_At = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDeadline = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtResource = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSolution = new javax.swing.JTextArea();
        btnReply = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTittle.setText("titulo de la tarea");

        jLabel1.setText("Título:");

        jLabel2.setText("Código:");

        txtCode.setText("codigo de la tarea");

        txtDescription.setText("descripcion de la tarea");

        jLabel3.setText("Descripción:");

        txtCreated_At.setText("created_at de la tarea");

        jLabel4.setText("Fecha de creación:");

        txtDeadline.setText("deadline de la tarea");

        jLabel5.setText("Fecha limite:");

        txtResource.setText("recursos de la tarea");

        jLabel6.setText("Recursos:");

        btnClose.setText("CERRAR");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel7.setText("Aqui tu respuesta a la tarea");

        txtSolution.setColumns(20);
        txtSolution.setLineWrap(true);
        txtSolution.setRows(5);
        jScrollPane1.setViewportView(txtSolution);

        btnReply.setText("RESPONDER");
        btnReply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplyActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel8.setText("Estudiante:");

        txtStudentName.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        txtStudentName.setText("Nombre del estudiante");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReply, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtDeadline))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtCreated_At))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtCode))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtTittle))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtResource))
                                    .addComponent(jLabel7)
                                    .addComponent(btnClose)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 33, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStudentName)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtStudentName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCode)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTittle)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResource)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreated_At)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeadline)
                    .addComponent(jLabel5))
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReply)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        MainStudent form = new MainStudent();
        form.set_student_id(student_id);
        form.set_student_fullname(student_fullname);
        form.set_course_id(course_id);
        form.setVisible(true);
        form.f_list();
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnReplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplyActionPerformed
        String homework_solution = txtSolution.getText();
        
        if (homework_solution.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar el campo");
        } else {
            verify_homework_deadline(homework_solution);
        }
    }//GEN-LAST:event_btnReplyActionPerformed

    
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
            java.util.logging.Logger.getLogger(PendingHomeworkStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PendingHomeworkStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PendingHomeworkStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PendingHomeworkStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PendingHomeworkStudent().setVisible(true);
            }
        });
    }
    
    public void verify_homework_deadline(String homework_solution) {
        
        if (date_now.after(deadline)) {
            JOptionPane.showMessageDialog(null, "La fecha límite de la tarea ya pasó");
        } else {
            verify_homework_solution(homework_solution);
        }
    }
    
    public void verify_homework_solution(String homework_solution) {
        String SQL = "SELECT homework_solution FROM grade WHERE homework_code='"+homework_code+"' AND student_id='"+student_id+"'";
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(SQL);
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "La tarea ya fue respondida");
            } else {
                reply_homework(homework_solution);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void reply_homework(String homework_solution) {
        String SQL = "INSERT INTO grade (homework_code, student_id, homework_solution) "
                + "VALUES('"+homework_code+"', '"+student_id+"', '"+homework_solution+"')";
        
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            int rows_affected = st.executeUpdate(SQL);
            
            if (rows_affected > 0) {
                JOptionPane.showMessageDialog(null, "Tarea respondida satisfactoriamente");
                MainStudent form = new MainStudent();
                form.set_student_id(student_id);
                form.set_student_fullname(student_fullname);
                form.set_course_id(course_id);
                form.setVisible(true);
                form.f_list();
                this.dispose();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel txtCode;
    private javax.swing.JLabel txtCreated_At;
    private javax.swing.JLabel txtDeadline;
    private javax.swing.JLabel txtDescription;
    private javax.swing.JLabel txtResource;
    private javax.swing.JTextArea txtSolution;
    private javax.swing.JLabel txtStudentName;
    private javax.swing.JLabel txtTittle;
    // End of variables declaration//GEN-END:variables
}
