/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;
import ClasesGenerales.Consultorio;
import ClasesGenerales.Proveedor;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Net
 */
public class aggProveedor extends javax.swing.JPanel {

    /**
     * Creates new form aggProveedor
     */
    public aggProveedor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtEmpesa = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        txtFechaentrega = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Adñadir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtEmpesa.setBackground(new java.awt.Color(153, 255, 255));
        TxtEmpesa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(TxtEmpesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 92, 380, 30));

        txtProducto.setBackground(new java.awt.Color(153, 255, 255));
        txtProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 162, 380, 30));

        txtFechaentrega.setBackground(new java.awt.Color(153, 255, 255));
        txtFechaentrega.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtFechaentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 380, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Fecha de entrega :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        Adñadir.setBackground(new java.awt.Color(102, 102, 255));
        Adñadir.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Adñadir.setForeground(new java.awt.Color(255, 255, 255));
        Adñadir.setText("añadir");
        Adñadir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Adñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdñadirActionPerformed(evt);
            }
        });
        jPanel1.add(Adñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 90, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Empresa :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AdñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdñadirActionPerformed
        ArrayList<String> inputs = new ArrayList<>();

        Component[] textFields = {TxtEmpesa,txtProducto, txtFechaentrega};
        // Obtenemos los datos de cada JTextField
        for (Component textField : textFields) {
            JTextField field = (JTextField) textField;
            inputs.add(field.getText());
        }

        if (inputs.contains("")) {
            // Alguno de los inputs está vacío
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            Proveedor proveedor = new Proveedor(TxtEmpesa.getText(),txtFechaentrega.getText(), txtProducto.getText());
            Consultorio.instance.agregarProveedor(proveedor);

            TxtEmpesa.setText("");
            txtProducto.setText("");
            txtFechaentrega.setText("");

            JOptionPane.showMessageDialog(this, "Proveedor Agregado", "Importante", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_AdñadirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adñadir;
    private javax.swing.JTextField TxtEmpesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFechaentrega;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
