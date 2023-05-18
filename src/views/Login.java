
package views;

import config.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void validate_credentials_teachers() {
        int result = 0;
        String cc = String.valueOf(txtCCTeacher.getText());
        String pass = String.valueOf(txtPwordTeacher.getPassword());
        String SQL = "SELECT id, fullname FROM teacher WHERE cc='"+cc+"' AND password='"+pass+"'";
        
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(SQL);
            if (rs.next()) {
                result = 1;
                
                if (result == 1){
                    String teacher_id= rs.getString("id");
                    String teacher_fullname= rs.getString("fullname");
                    
                    MainTeacher form = new MainTeacher();
                    form.set_teacher_id(teacher_id);
                    form.set_teacher_fullname(teacher_fullname);
                    form.f_list();
                    form.setVisible(true);
                    this.dispose();
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Inicio de sesion incorrecto");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }
    
    public void validate_credentials_students() {
        int result = 0;
        String cc = String.valueOf(txtCCStudent.getText());
        String pass = String.valueOf(txtPwordStudent.getPassword());
        String SQL = "SELECT id, course_id, fullname FROM students WHERE identification_number='"+cc+"' AND password='"+pass+"'";
        
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(SQL);
            
            if (rs.next()) {
                result = 1;
                
                if (result == 1){
                    String student_id= rs.getString("id");
                    String course_id= rs.getString("course_id");
                    String student_fullname= rs.getString("fullname");
                    
                    MainStudent form = new MainStudent();
                    form.set_student_id(student_id);
                    form.set_student_fullname(student_fullname);
                    form.set_course_id(course_id);
                    form.f_list();
                    form.setVisible(true);
                    this.dispose();
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Inicio de sesion incorrecto");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTable = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtCCStudent = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPwordStudent = new javax.swing.JPasswordField();
        btnIngresarStudent = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtCCTeacher = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIngresarTeacher = new javax.swing.JButton();
        txtPwordTeacher = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenid@s al");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setText("SISTEMA ESCOLAR");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCCStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCStudentActionPerformed(evt);
            }
        });

        jLabel7.setText("Nro. de documento");

        jLabel8.setText("Contraseña");

        btnIngresarStudent.setText("Ingresar");
        btnIngresarStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnIngresarStudent)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCCStudent, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPwordStudent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCCStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPwordStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresarStudent)
                .addGap(11, 11, 11))
        );

        JTable.addTab("Estudiante", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCCTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCTeacherActionPerformed(evt);
            }
        });

        jLabel3.setText("Cedula de ciudadania");

        jLabel4.setText("Contraseña");

        btnIngresarTeacher.setText("Ingresar");
        btnIngresarTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarTeacherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnIngresarTeacher)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCCTeacher, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPwordTeacher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCCTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPwordTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresarTeacher)
                .addGap(11, 11, 11))
        );

        JTable.addTab("Docente", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addComponent(JTable, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(JTable, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        //JPanel panelRestriction = new JPanel();
        //panelRestriction.setBounds(0, 0, 200, 200);

        //panelRestriction.setLayout(null);
        //JLabel nombre = new JLabel("Decilo");

        //nombre.setBounds(10, 10, 100, 100);
        //Font fuente = new Font("arial", 12, Font.BOLD);
        //nombre.setFont(fuente);
        //panelRestriction.add(nombre);

        //tabla.addTab("administrador", panelRestriction);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCCTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCTeacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCTeacherActionPerformed

    private void btnIngresarTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarTeacherActionPerformed
        String cc = String.valueOf(txtCCTeacher.getText());
        String pass = String.valueOf(txtPwordTeacher.getPassword());
        
        if (cc.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos");
        } else {
            validate_credentials_teachers();
        }
    }//GEN-LAST:event_btnIngresarTeacherActionPerformed

    private void txtCCStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCStudentActionPerformed

    private void btnIngresarStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarStudentActionPerformed
        String cc = String.valueOf(txtCCStudent.getText());
        String pass = String.valueOf(txtPwordStudent.getPassword());
        
        if (cc.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos");
        } else {
            validate_credentials_students();
        }
    }//GEN-LAST:event_btnIngresarStudentActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTable;
    private javax.swing.JButton btnIngresarStudent;
    private javax.swing.JButton btnIngresarTeacher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCCStudent;
    private javax.swing.JTextField txtCCTeacher;
    private javax.swing.JPasswordField txtPwordStudent;
    private javax.swing.JPasswordField txtPwordTeacher;
    // End of variables declaration//GEN-END:variables
}
