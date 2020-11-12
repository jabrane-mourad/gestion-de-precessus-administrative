package Presentation.espaceAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VuEsAdmin extends JFrame {
    private JFrame frmEspaceAdministrateur;
    JButton gestionDesChefs;
    JButton gestionDesEmploes;
    JButton gestionDesProcedures;
    JButton statistiques;
    JButton deconnexion;
    JLabel lblNomAdmin;
    JLabel lblImg;


    public VuEsAdmin() {
        super("Espace administrateur");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.initialiser();
        this.dessiner();
    }

    private void initialiser() {
        this.lblImg = new JLabel("");
        frmEspaceAdministrateur = new JFrame();
        this.gestionDesChefs = new JButton("Gestion des chefs");
        this.gestionDesEmploes = new JButton("Gestion des emploes ");

        this.gestionDesProcedures = new JButton("Gestion Des Procedures ");

        this.statistiques = new JButton("Statistiques");
        this.deconnexion = new JButton("Déconnexion");
        this.lblNomAdmin = new JLabel("nom_Admine");

    }

    private void dessiner() {


        frmEspaceAdministrateur.setFont(new Font("Dialog", Font.BOLD, 9));
        frmEspaceAdministrateur.setTitle("Espace Administrateur");
        frmEspaceAdministrateur.getContentPane().setLayout(null);


        this.gestionDesChefs.setFont(new Font("Arial Black", Font.BOLD, 15));
        this.gestionDesChefs.setBounds(350, 100, 455, 52);
        frmEspaceAdministrateur.getContentPane().add(this.gestionDesChefs);


        this.gestionDesEmploes.setFont(new Font("Arial Black", Font.BOLD, 15));
        this.gestionDesEmploes.setBounds(350, 200, 455, 52);
        frmEspaceAdministrateur.getContentPane().add(this.gestionDesEmploes);

///////////////////////////////////////////////////////////////////////////////////////////////////

        this.gestionDesProcedures.setFont(new Font("Arial Black", Font.BOLD, 15));
        this.gestionDesProcedures.setBounds(350, 300, 455, 52);
        frmEspaceAdministrateur.getContentPane().add(this.gestionDesProcedures);


        this.statistiques.setFont(new Font("Arial Black", Font.BOLD, 15));
        this.statistiques.setBounds(350, 500, 455, 52);
        frmEspaceAdministrateur.getContentPane().add(this.statistiques);

        this.lblNomAdmin.setForeground(Color.WHITE);
        this.lblNomAdmin.setBackground(Color.BLACK);
        this.lblNomAdmin.setFont(new Font("Arial Black", Font.BOLD, 15));
        this.lblNomAdmin.setBounds(900, 610, 138, 25);
        frmEspaceAdministrateur.getContentPane().add(this.lblNomAdmin);

        this.deconnexion.setBounds(1050, 610, 149, 25);
        frmEspaceAdministrateur.getContentPane().add(this.deconnexion);


        this.lblImg.setLabelFor(frmEspaceAdministrateur);
        this.lblImg.setDisplayedMnemonic('1');
        this.lblImg.setBackground(Color.BLACK);
        this.lblImg.setIcon(new ImageIcon("img/vuesadmin.png"));
        this.lblImg.setBounds(0, 0, 1200, 700);
        frmEspaceAdministrateur.getContentPane().add(this.lblImg);
        this.add(frmEspaceAdministrateur.getContentPane());
    }


    public void addGestionDesChefsListener(ActionListener actionListener) {
        gestionDesChefs.addActionListener(actionListener);
    }
    public void addGestionDesProceduresListener(ActionListener actionListener) {
        gestionDesProcedures.addActionListener(actionListener);
    }

    public void addGestionDesEmploesListener(ActionListener actionListener) {
        gestionDesEmploes.addActionListener(actionListener);
    }

    public void addStatistiquesListener(ActionListener actionListener) {
        statistiques.addActionListener(actionListener);
    }

    public void adddeconnexionListener(ActionListener actionListener) {
        deconnexion.addActionListener(actionListener);
    }

    public void setLblNomAdmin(String nomAdmin) {
        this.lblNomAdmin.setText(nomAdmin);
    }

    public void dsiplayErorMessage(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

}
