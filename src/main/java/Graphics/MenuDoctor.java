/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Graphics;

import Graphics.DoctorSubMenu.AddPaciente;
import Graphics.DoctorSubMenu.AgendarPaciente;
import Graphics.DoctorSubMenu.VerInfo;
import Graphics.DoctorSubMenu.BuscarPaciente;
import Graphics.DoctorSubMenu.TablaCitas;
import Register.Engine;
import Users.Doctor;
import Users.Patient;
import Util.DoctorDate;
import javax.swing.JOptionPane;

/**
 *
 * @author leons
 */
public class MenuDoctor extends javax.swing.JFrame {
    private Engine engine;
    public Doctor user;
    /**
     * Creates new form MenuDoctor
     */
    public MenuDoctor(Engine engine, Doctor user) {
        this.engine = engine;
        this.user = user;
        initComponents();
        
        
    }
    private String nextPatient(){
        return "";
    }
    
    private String nextPatientName(){
        DoctorDate docDate = this.user.datesQueue.peek();
        if(docDate == null){
            return "No hay mas pacientes que atender";
        }else{
            return docDate.getPatient().getName()+" "+docDate.getPatient().getLastName();
        }

    }
    private String nextPatientDate(){
        DoctorDate docDate = this.user.datesQueue.peek();
        if(docDate == null){
            return "";
        }else{
            return docDate.getDate();
        }

    }
    private String nextPatientReason(){
        DoctorDate docDate = this.user.datesQueue.peek();
        if(docDate == null){
            return "";
        }else{
            return docDate.getReason();
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

        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        nameTxtBox = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        reasonTxtBox = new javax.swing.JLabel();
        fechaTxtBox = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        VerInfo = new javax.swing.JButton();
        buscarPacienteButton = new javax.swing.JButton();
        AddPaciente = new javax.swing.JButton();
        agendarButton = new javax.swing.JButton();
        verCitas = new javax.swing.JButton();
        eliminarMasReciente = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();

        jLabel21.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText(nextPatient());

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel9.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        jLabel9.setText("Bienvenido");

        jLabel11.setFont(new java.awt.Font("Swis721 Blk BT", 1, 24)); // NOI18N
        jLabel11.setText(user.getName()+" "+user.getLastName());

        jLabel12.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        jLabel12.setText("(Doctor)");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(Salir))
                .addGap(16, 16, 16))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));

        nameTxtBox.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        nameTxtBox.setForeground(new java.awt.Color(0, 0, 0));
        nameTxtBox.setText(nextPatientName());

        jLabel14.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Fecha:");

        jLabel15.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Razón:");

        jLabel16.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Nombre:");

        reasonTxtBox.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        reasonTxtBox.setForeground(new java.awt.Color(0, 0, 0));
        reasonTxtBox.setText(nextPatientReason());

        fechaTxtBox.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        fechaTxtBox.setForeground(new java.awt.Color(0, 0, 0));
        fechaTxtBox.setText(nextPatientDate());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reasonTxtBox))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTxtBox))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaTxtBox)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxtBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaTxtBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reasonTxtBox))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Swis721 Blk BT", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Próximo paciente a atender:");

        VerInfo.setText("Ver mi información");
        VerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInfoActionPerformed(evt);
            }
        });

        buscarPacienteButton.setText("Buscar un paciente");
        buscarPacienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPacienteButtonActionPerformed(evt);
            }
        });

        AddPaciente.setText("Añadir un paciente");
        AddPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPacienteActionPerformed(evt);
            }
        });

        agendarButton.setText("Agendar una cita");
        agendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendarButtonActionPerformed(evt);
            }
        });

        verCitas.setText("Ver mis citas pendientes");
        verCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCitasActionPerformed(evt);
            }
        });

        eliminarMasReciente.setText("Eliminar el paciente mas reciente");
        eliminarMasReciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarMasRecienteActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(VerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(buscarPacienteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AddPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agendarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eliminarMasReciente)
                                    .addComponent(verCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerInfo)
                    .addComponent(agendarButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarPacienteButton)
                    .addComponent(verCitas))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddPaciente)
                    .addComponent(eliminarMasReciente))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInfoActionPerformed
        // TODO add your handling code here:
        VerInfo verInfo = new VerInfo(user);
        verInfo.setLocationRelativeTo(null);
        verInfo.setVisible(true);
    }//GEN-LAST:event_VerInfoActionPerformed

    private void buscarPacienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPacienteButtonActionPerformed
        // TODO add your handling code here:
        BuscarPaciente verPacientes = new BuscarPaciente(engine,user);
        verPacientes.setLocationRelativeTo(null);
        verPacientes.setVisible(true);
    }//GEN-LAST:event_buscarPacienteButtonActionPerformed

    private void AddPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPacienteActionPerformed
        // TODO add your handling code here:
        AddPaciente addPacientes = new AddPaciente(engine,user);
        addPacientes.setLocationRelativeTo(null);
        addPacientes.setVisible(true);
        
    }//GEN-LAST:event_AddPacienteActionPerformed

    private void agendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarButtonActionPerformed
        // TODO add your handling code here:
        AgendarPaciente agendarPacientes = new AgendarPaciente(engine,user);
        agendarPacientes.setLocationRelativeTo(null);
        agendarPacientes.setVisible(true);
    }//GEN-LAST:event_agendarButtonActionPerformed

    private void verCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCitasActionPerformed
        // TODO add your handling code here:
        TablaCitas tabla = new TablaCitas(engine,user);
        tabla.setLocationRelativeTo(null);
        tabla.setVisible(true);
    }//GEN-LAST:event_verCitasActionPerformed

    private void eliminarMasRecienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarMasRecienteActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, user.removePatientFromSchedule());
        
    }//GEN-LAST:event_eliminarMasRecienteActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
        nameTxtBox.setText(nextPatientName());
        fechaTxtBox.setText(nextPatientDate());
        reasonTxtBox.setText(nextPatientReason());
    }//GEN-LAST:event_ActualizarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton AddPaciente;
    private javax.swing.JButton Salir;
    private javax.swing.JButton VerInfo;
    private javax.swing.JButton agendarButton;
    private javax.swing.JButton buscarPacienteButton;
    private javax.swing.JButton eliminarMasReciente;
    private javax.swing.JLabel fechaTxtBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel nameTxtBox;
    private javax.swing.JLabel reasonTxtBox;
    private javax.swing.JButton verCitas;
    // End of variables declaration//GEN-END:variables
}
