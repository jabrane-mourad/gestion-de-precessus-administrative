package Presentation.ajouterChef;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;


public class VuAjouterChef extends JFrame {
    private JFrame frame;
    private JLabel lblInfo;

    private JTextField textFieldrecherche;
    private JButton btnRecherche;
    private JTable table;
    JScrollPane scrollPane;
    private JButton btnAjouter;
    private JButton btnAnnuler;
    private JLabel lblImg;
    DefaultTableModel model;

    public VuAjouterChef() {
        super("Ajouter chef");
        this.setSize(500, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.initialiser();
        this.dessiner();
    }
    private void initialiser() {
        this.frame = new JFrame();
        this.lblInfo= new JLabel("Espace Administrateur ");
        this.textFieldrecherche =new JTextField();
        this.btnRecherche = new JButton("recherche");
        this.scrollPane = new JScrollPane();
        this.lblImg= new JLabel("");
        table = new JTable();

        this.btnAjouter = new JButton("Ajouter");
        this.btnAnnuler = new JButton("Retour");

    }
    private void dessiner() {
        this.textFieldrecherche.setBounds(155, 45, 200, 30);
        this.frame.getContentPane().add(this.textFieldrecherche);

        this.btnRecherche.setBounds(195, 74, 105, 30);
        frame.getContentPane().add(this.btnRecherche);

        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(2, 110, 498, 500);
        frame.getContentPane().add(scrollPane);


        this.table.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "matricule", "cin", "nom", "prenom"
                }
        ));
        scrollPane.setViewportView(table);


        Canvas canvas = new Canvas();
        scrollPane.setRowHeaderView(canvas);
        this.model = (DefaultTableModel) this.table.getModel();



        this.btnAjouter.setBackground(Color.green);
        this.btnAjouter.setBounds(70, 650, 125, 35);
        frame.getContentPane().add(this.btnAjouter);

        this.btnAnnuler.setBackground(Color.RED);
        this.btnAnnuler.setBounds(300, 650, 125, 35);
        frame.getContentPane().add(this.btnAnnuler);

        this.lblImg.setIcon(new ImageIcon("img/ajout.png"));
        this.lblImg.setBounds(0, 0, 500, 800);
        frame.getContentPane().add(this.lblImg);
        this.add(frame.getContentPane());

    }


    public JTable getTable() {
        return table;
    }
    public void setModel(DefaultTableModel mdl){
        this.table.setModel(mdl);
    }

    public void addBtnRecherchListener(ActionListener actionListener){
        this.btnRecherche.addActionListener(actionListener);
    }

    public void addBtnAjouterListener(ActionListener actionListener){
        this.btnAjouter.addActionListener(actionListener);
    }
    public void addBtnAnnulerListener(ActionListener actionListener){
        this.btnAnnuler.addActionListener(actionListener);
    }

    public JTextField getTextFieldrecherche() {
        return this.textFieldrecherche;
    }

    public void dsiplayErorMessage(String error){
        JOptionPane.showMessageDialog(this,error);
    }

    public String getMatricule(){
        return (String) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(),0);
    }
}
