package Presentation.gstProcedures;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class VuGstProcedure extends JFrame {
    private JFrame frame;
    private JLabel lblInfo;
    private  JComboBox boxEtatEmploye;
    private JButton btnGstEtapes;
    private JTextField textFieldrecherche;
    private JButton btnRecherche;
    private JTable table;
    JScrollPane scrollPane;
    private JButton btnArchiver;
    private JButton btnModifier;
    private JButton btnAjouter;
    private JButton btnAnnuler;
    private JLabel lblImg;
    DefaultTableModel model;



    public VuGstProcedure() {

        super("Gestion Des Procedures");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.initialiser();
        this.dessiner();
    }

    private void initialiser() {
        this.frame = new JFrame();
        this.lblInfo= new JLabel("GESTION DES PROCEDURES ");
        String[] message={"Tous","Active","Archive"};
        boxEtatEmploye =new JComboBox(message);
        this.textFieldrecherche =new JTextField();
        this.btnRecherche = new JButton("recherche");
        this.btnGstEtapes = new JButton("Gestion de etapes");
        this.scrollPane = new JScrollPane();
        this.lblImg= new JLabel("");
        table = new JTable();
        this.btnAjouter = new JButton("Ajouter");
        this.btnArchiver = new JButton("Archiver");
        this.btnModifier = new JButton("Modifier");
        this.btnAnnuler = new JButton("Retour");

    }
    private void dessiner() {
        this.lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 28));
        this.lblInfo.setBounds(400, 13, 500, 61);
        this.frame.getContentPane().add(this.lblInfo);


        boxEtatEmploye.setBounds(10,70,200,30);
        this.frame.getContentPane().add(this.boxEtatEmploye);

        this.textFieldrecherche.setBounds(875, 70, 200, 30);
        this.frame.getContentPane().add(this.textFieldrecherche);
        this.textFieldrecherche.setColumns(10);
        this.btnRecherche.setBounds(1085, 70, 105, 30);
        frame.getContentPane().add(this.btnRecherche);

        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(2, 110, 1199, 500);
        frame.getContentPane().add(scrollPane);


        this.table.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Id", "Nom", "Description", "Nombre Etapes","Nombre Document","matricule"
                }
        ));
        scrollPane.setViewportView(table);


        Canvas canvas = new Canvas();
        scrollPane.setRowHeaderView(canvas);
        this.model = (DefaultTableModel) this.table.getModel();


        this.btnGstEtapes.setBackground(Color.LIGHT_GRAY);
        this.btnGstEtapes.setBounds(90, 620, 150, 35);
        frame.getContentPane().add(this.btnGstEtapes);



        this.btnArchiver.setBackground(Color.RED);
        this.btnArchiver.setBounds(750, 620, 125, 35);
        frame.getContentPane().add(this.btnArchiver);

        this.btnModifier.setBackground(Color.CYAN);
        this.btnModifier.setBounds(550, 620, 125, 35);
        frame.getContentPane().add(this.btnModifier);

        this.btnAjouter.setBackground(Color.green);
        this.btnAjouter.setBounds(350, 620, 125, 35);
        frame.getContentPane().add(this.btnAjouter);

        this.btnAnnuler.setBounds(1085, 620, 105, 30);
        frame.getContentPane().add(this.btnAnnuler);

        this.lblImg.setIcon(new ImageIcon("img/vuesadmin.png"));
        this.lblImg.setBounds(0, 0, 1200, 700);
        frame.getContentPane().add(this.lblImg);
        this.add(frame.getContentPane());

    }


    public JTable getTable() {
        return table;
    }
    public void setModel(DefaultTableModel mdl){
        this.table.setModel(mdl);
    }

    public void addboxEtatEmployeListener(ActionListener actionListener){
        boxEtatEmploye.addActionListener(actionListener);
    }
    public void addBtnRecherchListener(ActionListener actionListener){
        this.btnRecherche.addActionListener(actionListener);
    }
    public void addBtnbtnArchiverListener(ActionListener actionListener){
        this.btnArchiver.addActionListener(actionListener);
    }
    public void addBtnModifierListener(ActionListener actionListener){
        this.btnModifier.addActionListener(actionListener);
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

    public int getIdProcedure(){
        return (Integer) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(),0);
    }
    public void addBtnGstEtapesListener(ActionListener actionListener){
        this.btnGstEtapes.addActionListener(actionListener);
    }
}
