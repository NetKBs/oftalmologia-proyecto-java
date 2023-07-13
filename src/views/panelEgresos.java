/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Inesc28
 */
public class panelEgresos extends javax.swing.JPanel {

    /**
     * Creates new form panelEgresos
     */
    public panelEgresos() {
        initComponents();
        graficar();
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
        jLabel1 = new javax.swing.JLabel();
        input = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Monto Gastado");

        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(359, 359, 359))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(319, 319, 319))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(356, 356, 356))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    public String classifyDate(int day, int month, int year) {

        LocalDate today = LocalDate.now();

        // La fecha dada 
        LocalDate givenDate = LocalDate.of(year, month, day);

        // Calcular la diferencia en días 
        long daysBetween = ChronoUnit.DAYS.between(givenDate, today);

        if (daysBetween == 0) {
            return "Today";
        } else if (daysBetween > 0 && daysBetween <= 7) {
            return "Week";
        } else if (daysBetween > 7 && daysBetween <= 30) {
            return "Month";
        } else {
            return "Older";
        }
    }

    public void graficar() {

        int monto_d = 0;
        int monto_s = 0;
        int monto_m = 0;

        // Accedemos al archivo de ingresos
        String filePath = System.getProperty("user.dir") + File.separator + "src"
                + File.separator + "temp" + File.separator + "egresos.txt";
        File file = new File(filePath);

        if (!file.exists()) {
            // Crea el archivo si no existe
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] split = line.split("\\|");

                if (split[0].isEmpty()) {
                    continue;  // Salta esta línea vacía
                }

                int cantidad = Integer.parseInt(split[0]);
                int dia = Integer.parseInt(split[1]);
                int mes = Integer.parseInt(split[2]);
                int anio = Integer.parseInt(split[3]);
                // Encontramos su ubicacion en el tiempo
                String ref = dia + " " + mes + " " + anio;

                switch (classifyDate(dia, mes, anio)) {
                    case "Today": {
                        //System.out.println("Today: " + ref + " Monto: " + cantidad);
                        monto_d += cantidad;
                        break;
                    }
                    case "Week": {
                        //System.out.println("Week: " + ref + " Monto: " + cantidad);
                        monto_s += cantidad;
                        break;
                    }
                    case "Month": {
                        //System.out.println("Moth: " + ref + " Monto: " + cantidad);
                        monto_m += cantidad;
                        break;
                    }
                    // Older
                    default: {
                        // System.out.println("Older: " + ref + " Monto: " + cantidad);
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(monto_m, "Egresos Mensuales", "Consultorio");
        datos.setValue(monto_s, "Egresos Semanales", "Consultorio");
        datos.setValue(monto_d, "Egresos Diarios", "Consultorio");
        
        JFreeChart barras = ChartFactory.createBarChart3D("Promedio de Egresos", "Egresos", "Cantidad", datos, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel panel = new ChartPanel(barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(785,313));
         
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(panel, BorderLayout.NORTH);
        
        this.revalidate();
        this.repaint();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String gasto_s = input.getText();

        if (!gasto_s.equals("")) {
            int gasto = Integer.parseInt(input.getText());

            LocalDate today = LocalDate.now();

            int day = today.getDayOfMonth();
            int month = today.getMonthValue();
            int year = today.getYear();

            // GUardamos el registro del gasto
            String slice = File.separator;
            String file_path = System.getProperty("user.dir") + slice + "src"
                    + slice + "temp" + slice + "egresos.txt";

            // Primero, revisamos si el archivo existe
            File file = new File(file_path);
            if (file.exists()) {
                // El archivo existe, lo abrimos para agregar contenido
                PrintWriter writer;
                try {
                    writer = new PrintWriter(new FileWriter(file_path, true));
                    writer.append(gasto + "|" + day + "|" + month + "|" + year + "\n");
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(panelEgresos.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                // El archivo no existe, lo creamos y escribimos el contenido
                PrintWriter writer;
                try {
                    writer = new PrintWriter(file_path);
                    writer.append(gasto + "|" + day + "|" + month + "|" + year + "\n");
                    writer.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(panelEgresos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            graficar();
        }
        
        input.setText(""); // limpiamos input
        graficar();

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
