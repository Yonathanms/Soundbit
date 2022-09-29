package views;

import com.mycompany.reproductor.Reproductor;

public class Inicio extends javax.swing.JFrame {
    /**
     * clase de inicio, solo es un menu con opciones para registrar, iniciar sesion o salir
    */
    public Inicio() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicioBtn = new javax.swing.JButton();
        registraBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inicioBtn.setText("Iniciar sesión");
        inicioBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioBtnMouseClicked(evt);
            }
        });

        registraBtn.setText("Registrarse");
        registraBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registraBtnMouseClicked(evt);
            }
        });

        salirBtn.setText("Salir");
        salirBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inicioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registraBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(inicioBtn)
                .addGap(54, 54, 54)
                .addComponent(registraBtn)
                .addGap(50, 50, 50)
                .addComponent(salirBtn)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_salirBtnMouseClicked

    private void registraBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registraBtnMouseClicked
        this.setVisible(false);
        Reproductor.registro.setVisible(true);
    }//GEN-LAST:event_registraBtnMouseClicked

    private void inicioBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioBtnMouseClicked
        this.setVisible(false);
        Reproductor.inicioSesion.setVisible(true);
    }//GEN-LAST:event_inicioBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inicioBtn;
    private javax.swing.JButton registraBtn;
    private javax.swing.JButton salirBtn;
    // End of variables declaration//GEN-END:variables
}
