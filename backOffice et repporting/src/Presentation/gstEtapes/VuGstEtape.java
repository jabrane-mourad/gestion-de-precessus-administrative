package Presentation.gstEtapes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class VuGstEtape extends JFrame {
    private MoGstEtape moGstEtape;
    private JFrame frame;
    private JLabel lblInfo;

    private JTextField textFieldrecherche;
    private JButton btnRecherche;
    private JTable table;
    private JScrollPane scrollPane;

    private JButton btnSupprimer;
    private JButton btnAjouter;
    private JButton btnModifier;

    private JButton btnAnnuler;

    private JLabel lblImg;
    private DefaultTableModel model;

    private JButton up;
    //////////////////////////partie2///////////////////////////////////

    private JLabel LabelIdEtape;
    private JTextField textFieldIdEtape;

    private JLabel lbLabelNom;
    private JTextField textFieldNom;

    private JLabel le1, le2;
    //////////////////////////partie2///////////////////////////////////


    public VuGstEtape(MoGstEtape moGstEtape) {


        super("Gestion Des Etapes");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.moGstEtape=moGstEtape;
        this.initialiser();
        this.dessiner();
    }

    private void initialiser() {
        this.frame = new JFrame();
        this.lblInfo = new JLabel("Espace administrateur ");
        this.textFieldrecherche = new JTextField();
        this.btnRecherche = new JButton("recherche");
        this.scrollPane = new JScrollPane();
        this.lblImg = new JLabel("");
        table = new JTable();
        this.btnSupprimer = new JButton("Supprimer");
        this.btnAjouter = new JButton("enregistrer");
        this.btnModifier = new JButton("Modifier");
        this.btnAnnuler = new JButton("Retour");

        this.up = new JButton("");
        /////////////////////
        this.LabelIdEtape = new JLabel("Id Etape :");
        this.textFieldIdEtape = new JTextField();
        this.le1=new JLabel(" ");

        this.lbLabelNom = new JLabel("nom :");
        this.textFieldNom = new JTextField();
        this.le2=new JLabel(" ");
        /////////////////////

    }

    private void dessiner() {
        frame.setBounds(100, 100, 1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        this.lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 32));
        this.lblInfo.setBounds(400, 13, 400, 61);
        this.frame.getContentPane().add(this.lblInfo);


        this.textFieldrecherche.setBounds(117, 70, 200, 30);
        this.frame.getContentPane().add(this.textFieldrecherche);
        this.textFieldrecherche.setColumns(10);
        this.btnRecherche.setBounds(332, 70, 105, 30);
        frame.getContentPane().add(this.btnRecherche);

        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(2, 110, 550, 500);
        frame.getContentPane().add(scrollPane);


        this.table.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "id_etape","nom", "ordre"
                }
        ));
        scrollPane.setViewportView(table);


        Canvas canvas = new Canvas();
        scrollPane.setRowHeaderView(canvas);
        this.model = (DefaultTableModel) this.table.getModel();


        this.btnSupprimer.setBackground(Color.red);
        this.btnSupprimer.setBounds(350, 620, 150, 35);
        frame.getContentPane().add(this.btnSupprimer);

        this.btnAjouter.setBackground(Color.green);
        this.btnAjouter.setBounds(910, 450, 150, 35);
        frame.getContentPane().add(this.btnAjouter);

        this.btnModifier.setBackground(Color.CYAN);
        this.btnModifier.setBounds(10, 620, 150, 35);
        frame.getContentPane().add(this.btnModifier);

        this.btnAnnuler.setBounds(1085, 620, 105, 30);
        frame.getContentPane().add(this.btnAnnuler);




        this.up.setIcon(new ImageIcon("img/up.jpg"));
        this.up.setBounds(570, 300, 40, 40);
        frame.getContentPane().add(this.up);
        ///////////////////////////////////////////
        this.LabelIdEtape.setFont(new Font("Microsoft YaHei", Font.TYPE1_FONT, 15));
        this.LabelIdEtape.setBounds(750, 305, 200, 20);
        this.frame.getContentPane().add(this.LabelIdEtape);

        this.textFieldIdEtape.setBounds(880, 300, 220, 35);
        this.frame.getContentPane().add(this.textFieldIdEtape);
        le1.setBounds(1100, 305, 100, 20);
        le1.setForeground(Color.red);
        this.frame.getContentPane().add(this.le1);

        this.lbLabelNom.setFont(new Font("Microsoft YaHei", Font.TYPE1_FONT, 15));
        this.lbLabelNom.setBounds(750, 380, 200, 20);
        this.frame.getContentPane().add(this.lbLabelNom);

        this.textFieldNom.setBounds(880, 375, 220, 35);
        this.frame.getContentPane().add(this.textFieldNom);
        le2.setBounds(1100, 380, 100, 20);
        le2.setForeground(Color.red);
        this.frame.getContentPane().add(this.le2);

        ///////////////////////////////////////////

        this.lblImg.setIcon(new ImageIcon("img/gstProcedure.png"));
        this.lblImg.setBounds(0, 0, 1200, 700);
        frame.getContentPane().add(this.lblImg);
        this.add(frame.getContentPane());

    }


    public JTable getTable() {
        return table;
    }

    public void setModel(DefaultTableModel mdl) {
        this.table.setModel(mdl);
    }


    public void addBtnRecherchListener(ActionListener actionListener) {
        this.btnRecherche.addActionListener(actionListener);
    }


    public void addBtnSupprimerListener(ActionListener actionListener) {
        this.btnSupprimer.addActionListener(actionListener);
    }

    public void addBtnAjouterListener(ActionListener actionListener) {
        this.btnAjouter.addActionListener(actionListener);
    }

    public void addBtnModifierListener(ActionListener actionListener) {
        this.btnModifier.addActionListener(actionListener);
    }

    public void addBtnAnnulerListener(ActionListener actionListener) {
        this.btnAnnuler.addActionListener(actionListener);
    }

    public JTextField getTextFieldrecherche() {
        return this.textFieldrecherche;
    }

    public void dsiplayErorMessage(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

    public String getMatricule() {
        return (String) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(), 0);
    }


    public void addBtnUpliserListener(ActionListener actionListener){
        this.up.addActionListener(actionListener);
    }

    public int getEtape() {
        return (Integer) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(),0);
    }

    public void IdEtapeRE1(KeyAdapter keyAdapter) {
        textFieldIdEtape.addKeyListener(keyAdapter);
    }
    public void IdnomRE2(KeyAdapter keyAdapter) {
        textFieldNom.addKeyListener(keyAdapter);
    }

    public void setInfo() {
        this.moGstEtape.setNom(textFieldNom.getText());
    }
    public void setInfo2() {
        this.moGstEtape.setNom(textFieldNom.getText());
        this.moGstEtape.setId_etape(Integer.parseInt(textFieldIdEtape.getText()));
    }
    public int getidEtape() {
        return Integer.parseInt(textFieldIdEtape.getText());
    }

    public void afficherErreur(int i) {
        switch (i) {
            case 1:
                le1.setText("Non valide");
                break;
            case 2:
                le2.setText("Non valide");
                break;
        }

    }
    public void resetLabel(int i) {
        switch (i) {
            case 1:
                le1.setText(" ");
                break;
            case 2:
                le2.setText(" ");
                break;
        }

    }

    public String getdNom() {
        return textFieldNom.getText();
    }

    public void setInfoFormulaire() {
        textFieldIdEtape.setText(String.valueOf(getEtape()));
        textFieldNom.setText((String) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(), 1));
    }

    public void setZero() {
        textFieldIdEtape.setText("");
        textFieldNom.setText("");
    }

    public int getOrder() {
        return (Integer) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(), 2);
    }
}
