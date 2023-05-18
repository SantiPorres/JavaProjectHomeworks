
package views;

import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HomeworkTeacher extends javax.swing.JFrame {
    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    String student_id;
    String fullname;
    String homework_solution;
    String homework_code;
    String tittle;
    String description;
    String deadline;
    String resource;
    String created_at;
    DefaultTableModel modelo;
    int selected_row;    
    
    public HomeworkTeacher() {
        initComponents();
        setLocationRelativeTo(null);
        btnQualify.setEnabled(false);
        txtScore.setEditable(false);
        btnOpen.setEnabled(false);
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
                deadline = rs.getString("deadline");
                resource = rs.getString("resource");
                created_at = rs.getString("created_at");
                
                set_homework_fields(tittle, description, deadline, resource, created_at);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public void set_homework_fields(String tittle, String description, String deadline, String resource, String created_at) {
        txtCode.setText(homework_code);
        txtTittle.setText(tittle);
        txtDescription.setText(description);
        txtResource.setText(resource);
        txtDeadline.setText(deadline);
        txtCreated_At.setText(created_at);
    }
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        RepliedHomeworksTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtScore = new javax.swing.JTextField();
        btnQualify = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        txtCode = new javax.swing.JTextField();
        txtTittle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtCreated_At = new javax.swing.JTextField();
        txtDeadline = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResource = new javax.swing.JTextArea();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Título:");

        jLabel2.setText("Código:");

        jLabel3.setText("Descripción:");

        jLabel4.setText("Fecha de creación:");

        jLabel5.setText("Fecha limite:");

        jLabel6.setText("Recursos:");

        btnClose.setText("CERRAR");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tareas enviadas:"));

        RepliedHomeworksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estudiante", "Respuesta", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RepliedHomeworksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RepliedHomeworksTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(RepliedHomeworksTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setText("Nota:");

        txtScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScoreActionPerformed(evt);
            }
        });

        btnQualify.setText("CALIFICAR");
        btnQualify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQualifyActionPerformed(evt);
            }
        });

        btnClean.setText("LIMPIAR");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnOpen.setText("ABRIR RESPUESTA");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        txtCode.setEditable(false);
        txtCode.setText("codigo de la tarea");

        txtTittle.setEditable(false);
        txtTittle.setText("titulo de la tarea");

        txtDescription.setEditable(false);
        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        txtCreated_At.setEditable(false);
        txtCreated_At.setText("created_at");

        txtDeadline.setEditable(false);
        txtDeadline.setText("fecha limite");

        txtResource.setEditable(false);
        txtResource.setColumns(20);
        txtResource.setLineWrap(true);
        txtResource.setRows(5);
        jScrollPane2.setViewportView(txtResource);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClose)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnQualify, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnClean)
                                            .addGap(94, 94, 94)
                                            .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCreated_At, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClean)
                    .addComponent(btnOpen))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQualify))
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void RepliedHomeworksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RepliedHomeworksTableMouseClicked
        btnOpen.setEnabled(true);
        btnQualify.setEnabled(true);
        txtScore.setEditable(true);
        selected_row = RepliedHomeworksTable.getSelectedRow();
        if (selected_row == -1) {
            JOptionPane.showMessageDialog(null, "Tarea no seleccionada");
        } else {
            student_id = (String)RepliedHomeworksTable.getValueAt(selected_row, 0);
            fullname = (String)RepliedHomeworksTable.getValueAt(selected_row, 1);
            homework_solution = (String)RepliedHomeworksTable.getValueAt(selected_row, 2);
        }
    }//GEN-LAST:event_RepliedHomeworksTableMouseClicked

    private void txtScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScoreActionPerformed

    private void btnQualifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQualifyActionPerformed
        String score = txtScore.getText();
        if (score.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar el campo");
        } else {
            update_score(score);
            f_list();
            clean_fields();
        }
    }//GEN-LAST:event_btnQualifyActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clean_fields();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        HomeworkSolution form = new HomeworkSolution();
        form.set_student_fullname(fullname);
        form.set_homework_solution(homework_solution);
        form.set_text_fields();
        form.setVisible(true);
    }//GEN-LAST:event_btnOpenActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeworkTeacher().setVisible(true);
            }
        });
    }
    
    public void update_score(String string_score) {
        float score = Float.valueOf(string_score);
        String SQL = "UPDATE grade g SET g.score='"+score+"', g.status='qualified' "
                + "WHERE student_id='"+student_id+"' "
                + "AND homework_code='"+homework_code+"'";
        
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            int rows_affected = st.executeUpdate(SQL);
            
            if (rows_affected > 0) {
                JOptionPane.showMessageDialog(null, "Tarea calificada satisfactoriamente");
            } else {
                JOptionPane.showMessageDialog(null, "La tarea no se pudo calificar");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void f_list() {
        
        String SQL = "SELECT g.student_id, g.score, g.status, g.homework_solution, s.fullname "
             + "FROM grade g "
             + "INNER JOIN students s ON g.student_id = s.id "
             + "WHERE g.homework_code = '" + homework_code + "'";
        
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(SQL);
            clean_table();
            
            Object[]homework=new Object[4];
            modelo=(DefaultTableModel)RepliedHomeworksTable.getModel();
            modelo.setRowCount(0);
            
            while (rs.next()) {
                homework[0]=rs.getString("student_id");
                homework[1]=rs.getString("fullname");
                homework[2]=rs.getString("homework_solution");
                if (rs.getString("status").equals("pending")) {
                    homework[3]="Pendiente";
                } else {
                    homework[3]=rs.getFloat("score");
                }
                
                modelo.addRow(homework);
            }            
            RepliedHomeworksTable.setModel(modelo);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void clean_table() {
        int row_count = RepliedHomeworksTable.getRowCount();
        if (row_count != 0) {
            for (int i = row_count-1; i>=0; i--) {
                modelo.removeRow(i);
            }
        }        
    }
    
    public void clean_fields() {
        txtScore.setText("");
        RepliedHomeworksTable.clearSelection();
        btnQualify.setEnabled(false);
        txtScore.setEditable(false);
        btnOpen.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RepliedHomeworksTable;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnQualify;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCreated_At;
    private javax.swing.JTextField txtDeadline;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextArea txtResource;
    private javax.swing.JTextField txtScore;
    private javax.swing.JTextField txtTittle;
    // End of variables declaration//GEN-END:variables
}
