package frontOfficeP1.Presentation.EsChef;

import frontOfficeP1.Metier.BeansMetier.Procedure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VuEsChef extends JFrame {
    private JFrame frame;
    private JLabel lblInfo;
    private JTextField textFieldrecherche;
    private JTable table;

    private JComboBox boxPrcedure;
    private JComboBox boxEtatDemande;


    private JScrollPane scrollPane;
    private JButton btnRecherche;
    private JButton btnArchiver;
    private JButton btnNvDemande;
    private JButton btnDeconnexion;

    private JLabel lblImg;
    DefaultTableModel model;
    private MoEsChef moEsChef;


    public VuEsChef(MoEsChef moChef) {

        super("Gestion des demandes");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.moEsChef = moChef;
        this.initialiser();
        this.dessiner();
    }

    private void initialiser() {
        this.frame = new JFrame();
        this.lblInfo = new JLabel("Espace Chef ");
        String[] listProcedure = listProcedureBox();
        String[] etatDemande = {"active","archive"};
        this.boxPrcedure = new JComboBox(listProcedure);
        this.boxEtatDemande = new JComboBox(etatDemande);

        this.textFieldrecherche = new JTextField();
        this.scrollPane = new JScrollPane();
        this.lblImg = new JLabel("");
        table = new JTable();
        this.btnRecherche = new JButton("recherche");
        this.btnArchiver = new JButton("Archiver");
        this.btnNvDemande = new JButton("");
        this.btnDeconnexion = new JButton("Deconnexion");

    }

    private String[] listProcedureBox() {
        ArrayList<String> valuesProcedure = new ArrayList<>();
        for (Procedure procedure : moEsChef.getProcedures()) {
            valuesProcedure.add(procedure.getNom());
        }
        Object[] obj = valuesProcedure.toArray();
        String[] listValues = new String[obj.length];
        for (int i = 0; i < listValues.length; i++) listValues[i] = (String) obj[i];
        return listValues;
    }

    private void dessiner() {
        this.lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 28));
        this.lblInfo.setBounds(400, 13, 500, 61);
        this.frame.getContentPane().add(this.lblInfo);


        boxPrcedure.setBounds(10, 70, 200, 30);
        this.frame.getContentPane().add(this.boxPrcedure);

        this.boxEtatDemande.setBounds(250, 70, 200, 30);
        this.frame.getContentPane().add(this.boxEtatDemande);

        this.textFieldrecherche.setBounds(875, 70, 200, 30);
        this.frame.getContentPane().add(this.textFieldrecherche);
        this.textFieldrecherche.setColumns(10);
        this.btnRecherche.setBounds(1085, 70, 105, 30);
        frame.getContentPane().add(this.btnRecherche);
        
        this.btnNvDemande.setIcon(new ImageIcon("img/nvDemande.png"));
        this.btnNvDemande.setBounds(1100, 10, 50, 50);
        frame.getContentPane().add(this.btnNvDemande);

        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(2, 110, 1199, 500);
        frame.getContentPane().add(scrollPane);


        this.table.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "jeton","cin","nom", "etat", "date_depo", "date_acceptation", "avancement"
                }
        ));
        scrollPane.setViewportView(table);

        Canvas canvas = new Canvas();
        scrollPane.setRowHeaderView(canvas);
        this.model = (DefaultTableModel) this.table.getModel();


        this.btnArchiver.setBackground(Color.RED);
        this.btnArchiver.setBounds(500, 620, 125, 35);
        frame.getContentPane().add(this.btnArchiver);




        this.btnDeconnexion.setBounds(1070, 620, 150, 30);
        frame.getContentPane().add(this.btnDeconnexion);

        this.lblImg.setIcon(new ImageIcon("img/vuesadmin.png"));
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

    public void addboxProcedureListener(ActionListener actionListener) {
        boxPrcedure.addActionListener(actionListener);
    }

    public void addboxEtatDemandeListener(ActionListener actionListener) {
        boxEtatDemande.addActionListener(actionListener);
    }

    public void addBtnRecherchListener(ActionListener actionListener) {
        this.btnRecherche.addActionListener(actionListener);
    }

    public void addBtnbtnArchiverListener(ActionListener actionListener) {
        this.btnArchiver.addActionListener(actionListener);
    }

    public void addBtnNvDemanderListener(ActionListener actionListener) {
        this.btnNvDemande.addActionListener(actionListener);
    }

    public void addBtnDeconnexionListener(ActionListener actionListener) {
        this.btnDeconnexion.addActionListener(actionListener);
    }

    public JTextField getTextFieldrecherche() {
        return this.textFieldrecherche;
    }

    public void dsiplayErorMessage(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

    public String getjeton() {
        return (String) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(), 0);
    }

    public String getCin() {
        return textFieldrecherche.getText();
    }
    public String getAvnc() {
        return (String) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(), 6);
    }
}
