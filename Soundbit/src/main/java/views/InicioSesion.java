package views;

import com.mycompany.reproductor.Reproductor;
import com.mycompany.reproductor.models.Usuario;

public class InicioSesion extends javax.swing.JFrame {
    /**
     * interfaz para el inicio de sesion, valida los credenciales del usuario
     */
    public InicioSesion() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        correo = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        iniciarSesionBtn = new javax.swing.JButton();
        AtrasBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iniciarSesionBtn.setText("Iniciar sesión");
        iniciarSesionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionBtnActionPerformed(evt);
            }
        });

        AtrasBtn.setText("Atrás");
        AtrasBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AtrasBtnMouseClicked(evt);
            }
        });

        jLabel2.setText("Correo electrónico:");

        jLabel4.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AtrasBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iniciarSesionBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(correo, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(pass))))
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniciarSesionBtn)
                    .addComponent(AtrasBtn))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBtnMouseClicked
        this.setVisible(false);
        Reproductor.inicio.setVisible(true);
    }//GEN-LAST:event_AtrasBtnMouseClicked

    private void iniciarSesionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionBtnActionPerformed
        /**
         * toma los valores ingresados y busca en la lista simple si este se encuentra en la lista
         * o no 
         */
        String mail = correo.getText();
        String contra = pass.getText();
        Usuario usuario = Reproductor.usuario.primero;
        while(usuario != null){
            if(usuario.getCorreoElectronico().equals(mail) && usuario.getContrasena().equals(contra)){
                Reproductor.activo = usuario;
                Reproductor.cargarBibliotecas();
                Reproductor.menuBiblioteca = new BibliotecaMenu();
                Reproductor.menuBiblioteca.setVisible(true);
                this.setVisible(false);
                break;
            }
            else{
                usuario = usuario.siguiente;
            }
        }
    }//GEN-LAST:event_iniciarSesionBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasBtn;
    private javax.swing.JTextField correo;
    private javax.swing.JButton iniciarSesionBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField pass;
    // End of variables declaration//GEN-END:variables
}
