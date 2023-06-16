
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
    String title;
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
        setResizable(false);
    }
    
    public void set_student_id(String main_student_id) {
        student_id = main_student_id;
    }
    
    public void set_student_fullname(String login_student_fullname) {
        student_fullname = login_student_fullname;
        txtStudentName.setText(student_fullname);
    }
    
    public void set_course_id(String main_course_id) {
        course_id = main_course_id;
    }
    
    public void set_homework_code(String main_homework_code) {
        homework_code = main_homework_code;
    }
    
    public void get_homework_fields() {
        String SQL = "SELECT title, description, deadline, resource, created_at FROM homeworks WHERE code='"+homework_code+"'";
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(SQL);
            
            if (rs.next()) {
                title = rs.getString("title");
                description = rs.getString("description");
                deadline = rs.getDate("deadline");
                resource = rs.getString("resource");
                created_at = rs.getString("created_at");
                
                set_homework_fields(title, description, deadline, resource, created_at);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public void set_homework_fields(String title, String description, Date deadline, String resource, String created_at) {
        txtCode.setText(homework_code);
        txtTitle.setText(title);
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
        btnClose = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSolution = new javax.swing.JTextArea();
        btnReply = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtResource = new javax.swing.JTextArea();
        txtCreated_At = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDeadline = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnClose.setBackground(new java.awt.Color(0, 50, 77));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
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
        txtSolution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSolutionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtSolution);

        btnReply.setBackground(new java.awt.Color(57, 169, 0));
        btnReply.setForeground(new java.awt.Color(255, 255, 255));
        btnReply.setText("RESPONDER");
        btnReply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplyActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 50, 77));
        jLabel8.setText("Estudiante:");

        txtStudentName.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        txtStudentName.setForeground(new java.awt.Color(0, 50, 77));
        txtStudentName.setText("Nombre del estudiante");

        jLabel2.setText("Código:");

        txtCode.setEditable(false);
        txtCode.setBackground(new java.awt.Color(255, 255, 255));
        txtCode.setText("codigo de la tarea");

        jLabel1.setText("Título:");

        txtTitle.setEditable(false);
        txtTitle.setBackground(new java.awt.Color(255, 255, 255));
        txtTitle.setText("titulo de la tarea");

        jLabel3.setText("Descripción:");

        txtDescription.setEditable(false);
        txtDescription.setBackground(new java.awt.Color(255, 255, 255));
        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        jLabel6.setText("Recursos:");

        txtResource.setEditable(false);
        txtResource.setBackground(new java.awt.Color(255, 255, 255));
        txtResource.setColumns(20);
        txtResource.setLineWrap(true);
        txtResource.setRows(5);
        jScrollPane3.setViewportView(txtResource);

        txtCreated_At.setEditable(false);
        txtCreated_At.setBackground(new java.awt.Color(255, 255, 255));
        txtCreated_At.setText("created_at");

        jLabel4.setText("Fecha de creación:");

        jLabel5.setText("Fecha limite:");

        txtDeadline.setEditable(false);
        txtDeadline.setBackground(new java.awt.Color(255, 255, 255));
        txtDeadline.setText("fecha limite");

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Campos obligatorios: *");

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Max: 1000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCreated_At, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDeadline))
                        .addComponent(jLabel6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClose)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStudentName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReply, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtStudentName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCreated_At, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnReply))
                .addContainerGap(22, Short.MAX_VALUE))
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
        form.f_list();
        form.setVisible(true);
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

    private void txtSolutionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSolutionKeyTyped
        if (txtSolution.getText().length() >= 1000) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSolutionKeyTyped

    
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
            
            cn.close();
            
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCreated_At;
    private javax.swing.JTextField txtDeadline;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextArea txtResource;
    private javax.swing.JTextArea txtSolution;
    private javax.swing.JLabel txtStudentName;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
