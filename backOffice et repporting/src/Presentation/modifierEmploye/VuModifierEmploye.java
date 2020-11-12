package Presentation.modifierEmploye;

import Presentation.modifierEmploye.MoModifierEmploye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class VuModifierEmploye extends JFrame {
    private JFrame frame;
    private JLabel LabeForme;
    private JLabel LabelNom;
    private JTextField textFieldNom;
    private JLabel lbLabelPrenom;
    private JTextField textFieldPrenom;
    private JLabel LabelCIN;
    private JTextField textFieldCIN;
    private JLabel LabelTele;
    private JTextField textFieldTele;
    private JLabel LabelAdresse;
    private JTextField textFieldAdresse;
    private JLabel LabelPoste;
    private JTextField textFieldPoste;
    private JLabel LabelGrade;
    private JTextField textFieldGrade;
    private JLabel LabelSalaire;
    private JTextField textFieldSalaire;
    private JLabel LabelMotPasse;
    private JTextField textFieldMotPasse;
    private JButton ButtonAnnuler;
    private JButton ButtonAjouter;
    private JLabel le1, le2, le3, le4, le5, le7, le8, le9, le10;
    private JLabel ImageLabel_13;
    private MoModifierEmploye moModifierEmploye;
    private  JComboBox boxEtatEmploye;

    public VuModifierEmploye(MoModifierEmploye moModifier) {
        super("ajouter un employe");
        this.setSize(590, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.moModifierEmploye = moModifier;
        this.initialiser();
        this.dessiner();
    }


    private void initialiser() {
        frame = new JFrame();
        this.LabeForme = new JLabel("Veuillez remplire les informations suivantes :");
        this.LabelNom = new JLabel("Nom :");
        this.textFieldNom = new JTextField();
        this.lbLabelPrenom = new JLabel("Pr\u00E9nom :");
        this.textFieldPrenom = new JTextField();
        this.LabelCIN = new JLabel("CIN :");
        this.textFieldCIN = new JTextField();
        this.LabelTele = new JLabel("T\u00E9l\u00E9 :");
        this.textFieldTele = new JTextField();
        this.LabelAdresse = new JLabel("Adresse :");
        this.textFieldAdresse = new JTextField();
        this.LabelPoste = new JLabel("Poste :");
        this.textFieldPoste = new JTextField();

        this.LabelGrade = new JLabel("Grade :");
        this.textFieldGrade = new JTextField();
        this.LabelSalaire = new JLabel("Salaire :");
        this.textFieldSalaire = new JTextField();
        this.LabelMotPasse = new JLabel("mot de passe :");
        this.textFieldMotPasse = new JTextField();
        le1 = new JLabel(" ");
        le2 = new JLabel(" ");
        le3 = new JLabel(" ");
        le4 = new JLabel(" ");
        le5 = new JLabel(" ");
        //le6 = new JLabel(" ");
        le7 = new JLabel(" ");
        le8 = new JLabel(" ");
        le9 = new JLabel(" ");
        le10 = new JLabel(" ");

        String[] message={"Active","Archive"};
        boxEtatEmploye =new JComboBox(message);


        this.ButtonAnnuler = new JButton("Retour");
        this.ButtonAjouter = new JButton("Mise à jour");
        this.ImageLabel_13 = new JLabel("");
    }

    private void dessiner() {
//----------------------------------------------------------------------------------
        this.LabeForme.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 18));
        this.LabeForme.setBounds(20, 30, 500, 16);
        this.frame.getContentPane().add(this.LabeForme);
//----------------------------------------------------------------------------------
        this.LabelNom.setBounds(115, 115, 100, 20);
        this.frame.getContentPane().add(this.LabelNom);

        this.textFieldNom.setBounds(237, 115, 220, 26);
        this.frame.getContentPane().add(this.textFieldNom);
        le1.setBounds(460, 115, 100, 20);
        le1.setForeground(Color.red);
        this.frame.getContentPane().add(this.le1);

//----------------------------------------------------------------------------------
        this.lbLabelPrenom.setBounds(115, 150, 100, 20);
        this.frame.getContentPane().add(this.lbLabelPrenom);

        this.textFieldPrenom.setBounds(237, 150, 220, 26);
        frame.getContentPane().add(this.textFieldPrenom);

        le2.setBounds(460, 150, 100, 20);
        le2.setForeground(Color.red);
        this.frame.getContentPane().add(this.le2);
//----------------------------------------------------------------------------------
        this.LabelCIN.setBounds(115, 185, 100, 20);
        this.frame.getContentPane().add(this.LabelCIN);

        this.textFieldCIN.setBounds(237, 185, 220, 26);
        this.frame.getContentPane().add(this.textFieldCIN);

        le3.setBounds(460, 185, 100, 20);
        le3.setForeground(Color.red);
        this.frame.getContentPane().add(this.le3);
//----------------------------------------------------------------------------------
        this.LabelTele.setBounds(115, 220, 100, 20);
        this.frame.getContentPane().add(this.LabelTele);

        this.textFieldTele.setBounds(237, 220, 220, 26);
        this.frame.getContentPane().add(this.textFieldTele);

        le4.setBounds(460, 220, 100, 20);
        le4.setForeground(Color.red);
        this.frame.getContentPane().add(this.le4);
//----------------------------------------------------------------------------------
        this.LabelAdresse.setBounds(115, 255, 100, 20);
        frame.getContentPane().add(this.LabelAdresse);

        this.textFieldAdresse.setBounds(237, 255, 220, 22);
        this.frame.getContentPane().add(this.textFieldAdresse);

        le5.setBounds(460, 255, 100, 20);
        le5.setForeground(Color.red);
        this.frame.getContentPane().add(this.le5);
//----------------------------------------------------------------------------------
        this.LabelPoste.setBounds(115, 290, 100, 20);
        this.frame.getContentPane().add(this.LabelPoste);

        this.textFieldPoste.setBounds(237, 290, 220, 26);
        this.frame.getContentPane().add(this.textFieldPoste);

        le7.setBounds(460, 290, 100, 20);
        le7.setForeground(Color.red);
        this.frame.getContentPane().add(this.le7);
//----------------------------------------------------------------------------------
        this.LabelGrade.setBounds(115, 325, 100, 20);
        this.frame.getContentPane().add(this.LabelGrade);

        this.textFieldGrade.setBounds(237, 325, 220, 26);
        this.frame.getContentPane().add(this.textFieldGrade);

        le8.setBounds(460, 325, 100, 20);
        le8.setForeground(Color.red);
        this.frame.getContentPane().add(this.le8);
//----------------------------------------------------------------------------------
        this.LabelSalaire.setBounds(115, 360, 100, 20);
        this.frame.getContentPane().add(this.LabelSalaire);

        this.textFieldSalaire.setBounds(237, 360, 220, 26);
        this.frame.getContentPane().add(this.textFieldSalaire);

        le9.setBounds(460, 360, 100, 20);
        le9.setForeground(Color.red);
        this.frame.getContentPane().add(this.le9);
//----------------------------------------------------------------------------------
        this.LabelMotPasse.setBounds(115, 395, 120, 20);
        this.frame.getContentPane().add(this.LabelMotPasse);

        this.textFieldMotPasse.setBounds(237, 395, 220, 26);
        this.frame.getContentPane().add(this.textFieldMotPasse);

        le10.setBounds(460, 395, 100, 20);
        le10.setForeground(Color.red);
        this.frame.getContentPane().add(this.le10);
//----------------------------------------------------------------------------------
        boxEtatEmploye.setBounds(237,430,200,30);
        this.frame.getContentPane().add(this.boxEtatEmploye);
//----------------------------------------------------------------------------------
        this.ButtonAnnuler.setBackground(Color.red);
        this.ButtonAnnuler.setBounds(150, 520, 100, 30);
        this.frame.getContentPane().add(this.ButtonAnnuler);

        this.ButtonAjouter.setBackground(Color.green);
        this.ButtonAjouter.setBounds(410, 520, 100, 30);
        this.frame.getContentPane().add(this.ButtonAjouter);

        this.ImageLabel_13.setIcon(new ImageIcon("img/ajout.png"));
        this.ImageLabel_13.setBounds(0, 0, 958, 653);
        this.frame.getContentPane().add(this.ImageLabel_13);
        this.add(this.frame.getContentPane());


    }

    public void addButtonAjouterListener(ActionListener actionListener) {
        this.ButtonAjouter.addActionListener(actionListener);
    }

    public void addButtonAnnulerListener(ActionListener actionListener) {
        this.ButtonAnnuler.addActionListener(actionListener);
    }
    public void nomRE1(KeyAdapter keyAdapter) {
        textFieldNom.addKeyListener(keyAdapter);
    }
    public void prenomRE2(KeyAdapter keyAdapter) {
        textFieldPrenom.addKeyListener(keyAdapter);
    }
    public void cinRE3(KeyAdapter keyAdapter) {
        textFieldCIN.addKeyListener(keyAdapter);
    }
    public void teleRE4(KeyAdapter keyAdapter) {
        textFieldTele.addKeyListener(keyAdapter);
    }
    public void adresseRE5(KeyAdapter keyAdapter) {
        textFieldAdresse.addKeyListener(keyAdapter);
    }
    public void postRE7(KeyAdapter keyAdapter) {
        textFieldPoste.addKeyListener(keyAdapter);
    }
    public void gradeRE8(KeyAdapter keyAdapter) {
        textFieldGrade.addKeyListener(keyAdapter);
    }
    public void salaireRE9(KeyAdapter keyAdapter) {
        textFieldSalaire.addKeyListener(keyAdapter);
    }
    public void passRE10(KeyAdapter keyAdapter) {
        textFieldMotPasse.addKeyListener(keyAdapter);
    }

    public void dsiplayErorMessage(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

    public void setInfo() {
        moModifierEmploye.setNom(textFieldNom.getText());
        moModifierEmploye.setPrenom(textFieldPrenom.getText());
        moModifierEmploye.setCin(textFieldCIN.getText());
        moModifierEmploye.setTele(textFieldTele.getText());
        moModifierEmploye.setAdresse(textFieldAdresse.getText());
        moModifierEmploye.setPoste(textFieldPoste.getText());
        moModifierEmploye.setGrade(textFieldGrade.getText());
        moModifierEmploye.setSalaire(Integer.parseInt(textFieldSalaire.getText()));
        moModifierEmploye.setMotDePasse(textFieldMotPasse.getText());
    }


    public JTextField getTextFieldNom() {
        return textFieldNom;
    }

    public JTextField getTextFieldPrenom() {
        return textFieldPrenom;
    }

    public JTextField getTextFieldCIN() {
        return textFieldCIN;
    }

    public JTextField getTextFieldTele() {
        return textFieldTele;
    }

    public JTextField getTextFieldAdresse() {
        return textFieldAdresse;
    }

    public JTextField getTextFieldPoste() {
        return textFieldPoste;
    }

    public JTextField getTextFieldGrade() {
        return textFieldGrade;
    }

    public JTextField getTextFieldSalaire() {
        return textFieldSalaire;
    }

    public JTextField getTextFieldMotPasse() {
        return textFieldMotPasse;
    }

    public void afficherErreur(int i) {
        switch (i) {
            case 1:
                le1.setText("invalid");
                break;
            case 2:
                le2.setText("invalid");
                break;
            case 3:
                le3.setText("invalid");
                break;
            case 4:
                le4.setText("invalid");
                break;
            case 5:
                le5.setText("invalid");
                break;
            case 7:
                le7.setText("invalid");
                break;
            case 8:
                le8.setText("invalid");
                break;
            case 9:
                le9.setText("invalid");
                break;
            case 10:
                le10.setText("invalid");
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
            case 3:
                le3.setText(" ");
                break;
            case 4:
                le4.setText(" ");
                break;
            case 5:
                le5.setText(" ");
                break;
            case 7:
                le7.setText(" ");
                break;
            case 8:
                le8.setText(" ");
                break;
            case 9:
                le9.setText(" ");
                break;
            case 10:
                le10.setText(" ");
                break;

        }

    }
    public void addboxEtatEmployeListener(ActionListener actionListener){
        boxEtatEmploye.addActionListener(actionListener);
    }


    public void setTextFieldNom(String nom) {
        this.textFieldNom.setText(nom);
    }

    public void setTextFieldPrenom(String prenom) {
        this.textFieldPrenom.setText(prenom);
    }

    public void setTextFieldCIN(String cin) {
        this.textFieldCIN.setText(cin);
    }

    public void setTextFieldTele(String tele) {
        this.textFieldTele.setText(tele);
    }

    public void setTextFieldAdresse(String adr) {
        this.textFieldAdresse.setText(adr);
    }

    public void setTextFieldPoste(String poste) {
        this.textFieldPoste.setText(poste);
    }

    public void setTextFieldGrade(String grade) {
        this.textFieldGrade.setText(grade);
    }

    public void setTextFieldSalaire(String salaire) {
        this.textFieldSalaire.setText(salaire);
    }

    public void setTextFieldMotPasse(String motPasse) {
        this.textFieldMotPasse.setText(motPasse);
    }

    public void setEtatEmploye(String type) {
        switch (type){
            case "false":
                boxEtatEmploye.setSelectedIndex(0);

                break;
            case "true":
                boxEtatEmploye.setSelectedIndex(1);
                break;
        }
    }




}
