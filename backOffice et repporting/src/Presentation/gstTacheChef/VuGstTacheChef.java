package Presentation.gstTacheChef;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class VuGstTacheChef extends JFrame {
    private JFrame frame;
    private JLabel lblInfo;
    private JTextField textFieldrecherche;
    private JButton btnRecherche;

    private JTable table;
    private JTable table2;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;

    private JButton btnRetier;
    private JButton btnAffecter;
    private JButton btnAnnuler;
    private JLabel lblImg;

    DefaultTableModel model;
    DefaultTableModel model2;



    public VuGstTacheChef() {
        super("Gestion Des Taches");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.initialiser();
        this.dessiner();
    }

    private void initialiser() {
        this.frame = new JFrame();
        this.lblInfo= new JLabel("Gestion des Taches ");

        this.textFieldrecherche =new JTextField();
        this.btnRecherche = new JButton("recherche");
        this.lblImg= new JLabel("");

        this.scrollPane = new JScrollPane();
        this.scrollPane2 = new JScrollPane();
        table = new JTable();
        table2 = new JTable();


        this.btnRetier = new JButton("--Retirer-->");
        this.btnAffecter = new JButton("<--Affecter--");
        this.btnAnnuler = new JButton("Retour");

    }
    private void dessiner() {
        this.lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 32));
        this.lblInfo.setBounds(400, 13, 400, 61);
        this.frame.getContentPane().add(this.lblInfo);


        this.textFieldrecherche.setBounds(875, 70, 200, 30);
        this.frame.getContentPane().add(this.textFieldrecherche);
        this.textFieldrecherche.setColumns(10);
        this.btnRecherche.setBounds(1085, 70, 105, 30);
        frame.getContentPane().add(this.btnRecherche);

        scrollPane.setForeground(Color.WHITE);
        scrollPane2.setForeground(Color.WHITE);
        scrollPane.setBounds(10, 110, 500, 500);
        scrollPane2.setBounds(690, 110, 500, 500);
        frame.getContentPane().add(scrollPane);
        frame.getContentPane().add(scrollPane2);


        this.table.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "id_procedure", "nom", "description","nombre_etapes"
                }
        ));
        this.table2.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "id_procedure", "nom", "description","nombre_etapes"
                }
        ));
        scrollPane.setViewportView(table);
        scrollPane2.setViewportView(table2);


        Canvas canvas = new Canvas();
        scrollPane.setRowHeaderView(canvas);
        this.model = (DefaultTableModel) this.table.getModel();

        Canvas canvas2 = new Canvas();
        scrollPane2.setRowHeaderView(canvas2);
        this.model2 = (DefaultTableModel) this.table2.getModel();




        this.btnRetier.setBackground(Color.RED);
        this.btnRetier.setForeground(new Color(0, 0, 0));
        this.btnRetier.setBounds(540, 350, 125, 35);
        frame.getContentPane().add(this.btnRetier);



        this.btnAffecter.setBackground(Color.green);
        this.btnAffecter.setBounds(540, 390, 125, 35);
        frame.getContentPane().add(this.btnAffecter);

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
    public JTable getTable2() {
        return table2;
    }
    public void setModel(DefaultTableModel mdl){
        this.table.setModel(mdl);
    }

    public void setModel2(DefaultTableModel mdl){
        this.table2.setModel(mdl);
    }
    public void addBtnRecherchListener(ActionListener actionListener){
        this.btnRecherche.addActionListener(actionListener);
    }
    public void addBtnSupprimerListener(ActionListener actionListener){
        this.btnRetier.addActionListener(actionListener);
    }
    public void addBtnAjouterListener(ActionListener actionListener){
        this.btnAffecter.addActionListener(actionListener);
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

    public int getIdProcedureAffecter(){
        return (Integer) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(),0);
    }
    public int getIdProcedurelibre(){
        return (Integer) this.getTable2().getModel().getValueAt(this.getTable2().getSelectedRow(),0);
    }
}
