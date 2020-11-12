package frontOfficeP1.Presentation.EsEmploye;

import frontOfficeP1.Metier.BeansMetier.Etape;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class VuEsEmploye extends JFrame {
    private MoEsEmploye moEsEmploye;

    private JFrame frame;
    private JTable table;
    private JComboBox boxEtape;
    private JScrollPane scrollPane;
    private JButton btnTraiter;
    private JButton btnDeconnexion;
    private JButton btnAccepter;
    private JButton btnMiseAjour;
    private JButton btnRefuser;
    private JButton btnRejeter;
    private JLabel lblImg;
    DefaultTableModel model;
    private JTextArea textFieldRapport;
    //////////////////////////////////////////////////////////////////////
    private JLabel lblInfo;
    private JLabel lblJeton;
    private JLabel lblJetonx;

    private JLabel lblCin;
    private JLabel lblCinx;
    private JLabel lblRapport;
    /////////////////////////////////////////////////////////////////////////

    public VuEsEmploye(MoEsEmploye moEsEmployee) {

        super("Gestion des demandes");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.moEsEmploye=moEsEmployee;
        this.initialiser();
        this.dessiner();
    }

    private void initialiser() {
        this.frame = new JFrame();
        this.lblInfo = new JLabel("espace employee");
        this.lblJeton = new JLabel("jeton:");
        this.lblJetonx = new JLabel("");
        this.lblCin = new JLabel("cin:");
        this.lblCinx = new JLabel("");
        this.lblRapport = new JLabel("Rapport :");
        String[] listEtape = listEtapeBox();
        this.boxEtape = new JComboBox(listEtape);

        this.scrollPane = new JScrollPane();
        this.lblImg = new JLabel("");
        table = new JTable();

        this.btnTraiter = new JButton("Traiter");
        this.btnDeconnexion = new JButton("Deconnexion");
        this.btnAccepter = new JButton("Accepter");
        this.btnMiseAjour = new JButton("Mise a jour");
        this.btnRefuser = new JButton("Refuser");
        this.btnRejeter = new JButton("Rejeter");
        /////////////////////////////////////////////
        String date= String.valueOf(new Date());
        date+="\n Rapport:";
        date+="\n \n Decision:";
        date+="\n \n justification:";
        this.textFieldRapport=new JTextArea(date);

    }


    private void dessiner() {
        this.lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        this.lblInfo.setBounds(500, 7, 500, 61);
        this.frame.getContentPane().add(this.lblInfo);

        this.lblJeton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.lblJeton.setBounds(600, 250, 100, 61);
        this.frame.getContentPane().add(this.lblJeton);
        this.lblJetonx.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.lblJetonx.setBounds(700, 250, 100, 61);
        this.frame.getContentPane().add(this.lblJetonx);

        this.lblCin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.lblCin.setBounds(600, 300, 100, 61);
        this.frame.getContentPane().add(this.lblCin);
        this.lblCinx.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.lblCinx.setBounds(700, 300, 100, 61);
        this.frame.getContentPane().add(this.lblCinx);

        this.lblRapport.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.lblRapport.setBounds(600, 350, 100, 61);
        this.frame.getContentPane().add(this.lblRapport);





        boxEtape.setBounds(10, 70, 180, 30);
        this.frame.getContentPane().add(this.boxEtape);




        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(2, 110, 500, 500);
        frame.getContentPane().add(scrollPane);


        this.table.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "jeton","cin","nom","date_acceptation"
                }
        ));
        scrollPane.setViewportView(table);

        Canvas canvas = new Canvas();
        scrollPane.setRowHeaderView(canvas);
        this.model = (DefaultTableModel) this.table.getModel();


        this.btnTraiter.setBackground(Color.green);
        this.btnTraiter.setBounds(195, 620, 125, 35);
        frame.getContentPane().add(this.btnTraiter);

        this.btnDeconnexion.setBounds(1000, 600, 200, 30);
        frame.getContentPane().add(this.btnDeconnexion);


        this.btnAccepter.setBounds(560, 550, 150, 30);
        frame.getContentPane().add(this.btnAccepter);

        this.btnMiseAjour.setBounds(720, 550, 150, 30);
        frame.getContentPane().add(this.btnMiseAjour);

        this.btnRefuser.setBounds(880, 550, 150, 30);
        frame.getContentPane().add(this.btnRefuser);

        this.btnRejeter.setBounds(1040, 550, 150, 30);
        frame.getContentPane().add(this.btnRejeter);

        this.textFieldRapport.setBounds(600, 400, 550, 120);
        this.frame.getContentPane().add(this.textFieldRapport);

        this.lblImg.setIcon(new ImageIcon("img/bg1.jpg"));
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

    public void addboxEtapereListener(ActionListener actionListener) {
        boxEtape.addActionListener(actionListener);
    }




    public void addBtnTraiterListener(ActionListener actionListener) {
        this.btnTraiter.addActionListener(actionListener);
    }

    public void addBtnDeconnexionListener(ActionListener actionListener) {
        this.btnDeconnexion.addActionListener(actionListener);
    }
    public void addBtnAccepterListener(ActionListener actionListener) {
        this.btnAccepter.addActionListener(actionListener);
    }
    public void addBtnMiseAjourListener(ActionListener actionListener) {
        this.btnMiseAjour.addActionListener(actionListener);
    }
    public void addBtnRefuserListener(ActionListener actionListener) {
        this.btnRefuser.addActionListener(actionListener);
    }
    public void addBtnRejeterListener(ActionListener actionListener) {
        this.btnRejeter.addActionListener(actionListener);
    }


    public void dsiplayErorMessage(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

    public String getjeton() {
        return (String) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(), 0);
    }

    private String[] listEtapeBox() {
        ArrayList<String> valuesEtapes = new ArrayList<>();
        for (Etape e : moEsEmploye.getEtapes()) {
            valuesEtapes.add(e.getNom());
        }
        Object[] obj = valuesEtapes.toArray();
        String[] listValues = new String[obj.length];
        for (int i = 0; i < listValues.length; i++) listValues[i] = (String) obj[i];
        return listValues;
    }

    public void setLblJetonx(String jeton) {
        this.lblJetonx.setText(jeton);
    }

    public void setLblCinx(String cinx) {
        this.lblCinx.setText(cinx);
    }

    public String getCin() {
        return (String) this.getTable().getModel().getValueAt(this.getTable().getSelectedRow(), 1);
    }

    public String getRapport() {
        String rapport="Cin:    ";
        String cin=lblCinx.getText();
        rapport+="\n \n"+cin;
        rapport+="\n \n"+textFieldRapport.getText();
        return rapport;
    }
}
