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
    
    String teacher_fullname;
    String student_id;
    String fullname;
    String homework_solution;
    String homework_code;
    String title;
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
        txtComment.setEditable(false);
        btnOpen.setEnabled(false);
        setResizable(false);
    }

    public void set_homework_code(String main_homework_code) {
        homework_code = main_homework_code;
    }
    
    public void set_teacher_fullname(String main_teacher_fullname) {
        teacher_fullname = main_teacher_fullname;
        txtTeacherName.setText(teacher_fullname);
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
                deadline = rs.getString("deadline");
                resource = rs.getString("resource");
                created_at = rs.getString("created_at");
                
                set_homework_fields(title, description, deadline, resource, created_at);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public void set_homework_fields(String title, String description, String deadline, String resource, String created_at) {
        txtCode.setText(homework_code);
        txtTitle.setText(title);
        txtDescription.setText(description);
        txtResource.setText(resource);
        txtDeadline.setText(deadline);
        txtCreated_At.setText(created_at);
    }
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
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
        txtTitle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtCreated_At = new javax.swing.JTextField();
        txtDeadline = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResource = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtTeacherName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComment = new javax.swing.JTextArea();

        jButton1.setText("jButton1");

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);

        jLabel1.setText("Título:");

        jLabel2.setText("Código:");

        jLabel3.setText("Descripción:");

        jLabel4.setText("Fecha de creación:");

        jLabel5.setText("Fecha limite:");

        jLabel6.setText("Recursos:");

        btnClose.setBackground(new java.awt.Color(0, 50, 77));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("CERRAR");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Nota:");

        txtScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScoreActionPerformed(evt);
            }
        });
        txtScore.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtScoreKeyTyped(evt);
            }
        });

        btnQualify.setBackground(new java.awt.Color(57, 169, 0));
        btnQualify.setForeground(new java.awt.Color(255, 255, 255));
        btnQualify.setText("CALIFICAR");
        btnQualify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQualifyActionPerformed(evt);
            }
        });

        btnClean.setBackground(new java.awt.Color(0, 50, 77));
        btnClean.setForeground(new java.awt.Color(255, 255, 255));
        btnClean.setText("LIMPIAR");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnOpen.setBackground(new java.awt.Color(57, 169, 0));
        btnOpen.setForeground(new java.awt.Color(255, 255, 255));
        btnOpen.setText("ABRIR RESPUESTA");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        txtCode.setEditable(false);
        txtCode.setBackground(new java.awt.Color(255, 255, 255));
        txtCode.setText("codigo de la tarea");

        txtTitle.setEditable(false);
        txtTitle.setBackground(new java.awt.Color(255, 255, 255));
        txtTitle.setText("titulo de la tarea");

        txtDescription.setEditable(false);
        txtDescription.setBackground(new java.awt.Color(255, 255, 255));
        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        txtCreated_At.setEditable(false);
        txtCreated_At.setBackground(new java.awt.Color(255, 255, 255));
        txtCreated_At.setText("created_at");

        txtDeadline.setEditable(false);
        txtDeadline.setBackground(new java.awt.Color(255, 255, 255));
        txtDeadline.setText("fecha limite");

        txtResource.setEditable(false);
        txtResource.setBackground(new java.awt.Color(255, 255, 255));
        txtResource.setColumns(20);
        txtResource.setLineWrap(true);
        txtResource.setRows(5);
        jScrollPane2.setViewportView(txtResource);

        jLabel8.setText("Comentario:");

        txtTeacherName.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        txtTeacherName.setForeground(new java.awt.Color(0, 50, 77));
        txtTeacherName.setText("Nombre del docente");

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 50, 77));
        jLabel9.setText("Docente:");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Campos obligatorios: *");

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("0.0 a 5.0");

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Max: 255");

        txtComment.setColumns(20);
        txtComment.setRows(5);
        txtComment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCommentKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtComment);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCreated_At))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDeadline))
                                .addComponent(jLabel6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnClose))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnQualify, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane3)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14))
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(3, 3, 3)
                                            .addComponent(jLabel13)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnClean)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(39, 39, 39))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTeacherName)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTeacherName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClean)
                            .addComponent(btnOpen))))
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCreated_At, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClose)
                            .addComponent(btnQualify))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        txtComment.setEditable(true);
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
        String appreciation = txtComment.getText();
        if (score.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar el campo");
        } else if ((Float.valueOf(score)) < 0 || (Float.valueOf(score)) > 5){
            JOptionPane.showMessageDialog(null, "Debe ingresar una nota valida");
            txtScore.setText("");
        } else {
            update_grade(score, appreciation);
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

    private void txtScoreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtScoreKeyTyped
        if (txtScore.getText().length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtScoreKeyTyped

    private void txtCommentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCommentKeyTyped
        if (txtComment.getText().length() >= 255) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCommentKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeworkTeacher().setVisible(true);
            }
        });
    }
    
    public void update_grade(String string_score, String appreciation) {
        float score = Float.valueOf(string_score);
        String SQL = "UPDATE grade g SET g.score='"+score+"', g.appreciation='"+appreciation+"', "
                + "g.status='qualified' "
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
        txtComment.setText("");
        RepliedHomeworksTable.clearSelection();
        btnQualify.setEnabled(false);
        txtScore.setEditable(false);
        txtComment.setEditable(false);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextArea txtComment;
    private javax.swing.JTextField txtCreated_At;
    private javax.swing.JTextField txtDeadline;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextArea txtResource;
    private javax.swing.JTextField txtScore;
    private javax.swing.JLabel txtTeacherName;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
