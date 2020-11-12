package Presentation.espaceChef;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class VuEsChef extends JFrame {
    private JFrame frame;
    private JLabel lblInfo;

    private JTextField textFieldrecherche;
    private JButton btnRecherche;
    private JButton actualiser;
    private JTable table;
    private JScrollPane scrollPane;

    private JButton btnGstTaches;
    private JButton btnAjouter;
    private JButton btnRetirer;

    private JButton btnAnnuler;

    private JLabel lblImg;
    private DefaultTableModel model;



    public VuEsChef() {

        super("Gestion Des chefs");
        this.setSize(1200, 700);
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
        this.actualiser = new JButton("");
        this.scrollPane = new JScrollPane();
        this.lblImg= new JLabel("");
        table = new JTable();
        this.btnGstTaches = new JButton("Gestion de tâches");
        this.btnAjouter = new JButton("Ajouter");
        this.btnRetirer = new JButton("Retirer");
        this.btnAnnuler = new JButton("Retour");

    }
    private void dessiner() {
        frame.setBounds(100, 100, 1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);




        this.lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 32));
        this.lblInfo.setBounds(400, 13, 400, 61);
        this.frame.getContentPane().add(this.lblInfo);



        this.textFieldrecherche.setBounds(875, 70, 200, 30);
        this.frame.getContentPane().add(this.textFieldrecherche);
        this.textFieldrecherche.setColumns(10);
        this.btnRecherche.setBounds(1085, 70, 105, 30);
        frame.getContentPane().add(this.btnRecherche);

        this.actualiser.setBorderPainted( false );
        this.actualiser.setFocusPainted( false );

        this.actualiser.setIcon(new ImageIcon("img/Refresh3.png"));
        this.actualiser.setBounds(10, 70, 35, 35);
        frame.getContentPane().add(this.actualiser);

        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(2, 110, 1199, 500);
        frame.getContentPane().add(scrollPane);


        this.table.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "matricule", "cin", "nom", "prenom","tel","adresse","post","salaire","mot de passe","archivee"
                }
        ));
        scrollPane.setViewportView(table);


        Canvas canvas = new Canvas();
        scrollPane.setRowHeaderView(canvas);
        this.model = (DefaultTableModel) this.table.getModel();


        this.btnGstTaches.setBackground(Color.CYAN);
        this.btnGstTaches.setBounds(350, 620, 150, 35);
        frame.getContentPane().add(this.btnGstTaches);

        this.btnAjouter.setBackground(Color.green);
        this.btnAjouter.setBounds(550, 620, 150, 35);
        frame.getContentPane().add(this.btnAjouter);

        this.btnRetirer.setBackground(Color.red);
        this.btnRetirer.setBounds(750, 620, 150, 35);
        frame.getContentPane().add(this.btnRetirer);

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


    public void addBtnRecherchListener(ActionListener actionListener){
        this.btnRecherche.addActionListener(actionListener);
    }
    public void addBtnActualiserListener(ActionListener actionListener){
        this.actualiser.addActionListener(actionListener);
    }
    public void addBtnGstTachesListener(ActionListener actionListener){
        this.btnGstTaches.addActionListener(actionListener);
    }
    public void addBtnAjouterListener(ActionListener actionListener){
        this.btnAjouter.addActionListener(actionListener);
    }
    public void addBtnRetirerListener(ActionListener actionListener){
        this.btnRetirer.addActionListener(actionListener);
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
