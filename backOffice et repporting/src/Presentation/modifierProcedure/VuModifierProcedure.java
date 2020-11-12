package Presentation.modifierProcedure;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class VuModifierProcedure extends JFrame {
    JScrollPane texteAsc;
    private JFrame frame;
    private JLabel LabeForme;


    private JLabel lbLabelNom;
    private JTextField textFieldNom;

    private JLabel Labeldescription;
    private JTextArea textFieldDescription;

    private JLabel Labelnombre_etapes;
    private JTextField textFieldNombre_etapes;

    private JLabel LabelnombreDocuments;
    private JTextField textFieldNombreDocument;

    private JButton ButtonAnnuler;
    private JButton ButtonAjouter;

    private JLabel le2, le3, le4,le5;
    private JLabel ImageLabel_13;

    private MoModifierProcedure moModifierProcedure;

    public VuModifierProcedure(MoModifierProcedure moModifierProcedure) {
        super("Modifier procedure");
        this.setSize(600, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.moModifierProcedure = moModifierProcedure;
        this.initialiser();
        this.dessiner();
    }


    private void initialiser() {
        frame = new JFrame();
        this.LabeForme = new JLabel("Veuillez remplire les informations suivantes :");

        this.lbLabelNom = new JLabel("Nom :");
        this.textFieldNom = new JTextField();

        this.Labeldescription = new JLabel("Description :");
        this.textFieldDescription = new JTextArea();
        texteAsc = new JScrollPane(textFieldDescription);

        this.Labelnombre_etapes = new JLabel("Nbr Etapes :");
        this.textFieldNombre_etapes = new JTextField();

        this.LabelnombreDocuments = new JLabel("Nbr Documents :");
        this.textFieldNombreDocument = new JTextField();


        le2 = new JLabel(" ");
        le3 = new JLabel(" ");
        le4 = new JLabel(" ");
        le5 = new JLabel(" ");


        this.ButtonAnnuler = new JButton("Retour");
        this.ButtonAjouter = new JButton("Enregistrer");
        this.ImageLabel_13 = new JLabel("");


    }

    private void dessiner() {
//----------------------------------------------------------------------------------
        this.LabeForme.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 18));
        this.LabeForme.setBounds(20, 30, 500, 16);
        this.frame.getContentPane().add(this.LabeForme);

//----------------------------------------------------------------------------------
        this.lbLabelNom.setFont(new Font("Microsoft YaHei", Font.TYPE1_FONT, 15));
        this.lbLabelNom.setBounds(70, 110, 200, 20);
        this.frame.getContentPane().add(this.lbLabelNom);

        this.textFieldNom.setBounds(237, 105, 220, 35);
        frame.getContentPane().add(this.textFieldNom);

        le2.setBounds(460, 105, 100, 20);
        le2.setForeground(Color.red);
        this.frame.getContentPane().add(this.le2);
//----------------------------------------------------------------------------------
        this.Labeldescription.setFont(new Font("Microsoft YaHei", Font.TYPE1_FONT, 15));
        this.Labeldescription.setBounds(70, 180, 200, 20);
        this.frame.getContentPane().add(this.Labeldescription);

        this.textFieldDescription.setBounds(237, 175, 220, 90);
        this.frame.getContentPane().add(this.textFieldDescription);

        le3.setBounds(460, 175, 100, 20);
        le3.setForeground(Color.red);
        this.frame.getContentPane().add(this.le3);
//----------------------------------------------------------------------------------
        this.Labelnombre_etapes.setFont(new Font("Microsoft YaHei", Font.TYPE1_FONT, 15));
        this.Labelnombre_etapes.setBounds(70, 290, 200, 20);
        this.frame.getContentPane().add(this.Labelnombre_etapes);

        this.textFieldNombre_etapes.setBounds(237, 285, 220, 35);
        this.frame.getContentPane().add(this.textFieldNombre_etapes);

        le4.setBounds(460, 285, 100, 20);
        le4.setForeground(Color.red);
        this.frame.getContentPane().add(this.le4);
//----------------------------------------------------------------------------------
        this.LabelnombreDocuments.setFont(new Font("Microsoft YaHei", Font.TYPE1_FONT, 15));
        this.LabelnombreDocuments.setBounds(70, 350, 200, 20);
        this.frame.getContentPane().add(this.LabelnombreDocuments);

        this.textFieldNombreDocument.setBounds(237, 345, 220, 35);
        this.frame.getContentPane().add(this.textFieldNombreDocument);

        le5.setBounds(460, 345, 100, 20);
        le5.setForeground(Color.red);
        this.frame.getContentPane().add(this.le5);
//----------------------------------------------------------------------------------
        this.ButtonAjouter.setBackground(Color.green);
        this.ButtonAjouter.setBounds(140, 465, 100, 28);
        this.frame.getContentPane().add(this.ButtonAjouter);

        this.ButtonAnnuler.setBackground(Color.red);
        this.ButtonAnnuler.setBounds(350, 465, 100, 28);
        this.frame.getContentPane().add(this.ButtonAnnuler);


        this.ImageLabel_13.setIcon(new ImageIcon("img/ajout.png"));
        this.ImageLabel_13.setBounds(0, 0, 500, 550);
        this.frame.getContentPane().add(this.ImageLabel_13);
        this.add(this.frame.getContentPane());

    }

    public void addButtonAjouterListener(ActionListener actionListener) {
        this.ButtonAjouter.addActionListener(actionListener);
    }

    public void addButtonAnnulerListener(ActionListener actionListener) {
        this.ButtonAnnuler.addActionListener(actionListener);
    }


    public void nomRE2(KeyAdapter keyAdapter) {
        textFieldNom.addKeyListener(keyAdapter);
    }

    public void DescriptionRE3(KeyAdapter keyAdapter) {
        textFieldDescription.addKeyListener(keyAdapter);
    }

    public void nbrEtapesRE4(KeyAdapter keyAdapter) {
        textFieldNombre_etapes.addKeyListener(keyAdapter);
    }
    public void nbrDocumentRE5(KeyAdapter keyAdapter) {
        textFieldNombreDocument.addKeyListener(keyAdapter);
    }


    public void dsiplayErorMessage(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

    public void setInfo() {
        moModifierProcedure.setNom(textFieldNom.getText());
        moModifierProcedure.setDescription(textFieldDescription.getText());
        moModifierProcedure.setNombreEtapes(Integer.parseInt(textFieldNombre_etapes.getText()));
        moModifierProcedure.setNbrDocument(Integer.parseInt(textFieldNombreDocument.getText()));
        moModifierProcedure.setArchive(false);
        moModifierProcedure.setMatricule(null);
    }

    public void afficherErreur(int i) {
        switch (i) {
            case 1:
                le2.setText("Non valide");
                break;
            case 2:
                le3.setText("Non valide");
                break;
            case 3:
                le4.setText("Non valide");
                break;
            case 4:
                le5.setText("Non valide");
                break;
        }

    }

    public void resetLabel(int i) {
        switch (i) {
            case 1:
                le2.setText(" ");
                break;
            case 2:
                le3.setText(" ");
                break;
            case 3:
                le4.setText(" ");
                break;
            case 4:
                le5.setText(" ");
                break;
        }

    }


    public String getdNom() {
        return textFieldNom.getText();
    }

    public String getDescription() {
        return textFieldDescription.getText();
    }

    public int getNombre_etapes() {
        return Integer.parseInt(textFieldNombre_etapes.getText());
    }
    public int getNombreDocument() {
        return Integer.parseInt(textFieldNombreDocument.getText());
    }
    public void setInfoFormulaire(){
        textFieldNom.setText(moModifierProcedure.getNom());
        textFieldDescription.setText(moModifierProcedure.getDescription());
        textFieldNombre_etapes.setText(String.valueOf(moModifierProcedure.getNombreEtapes()));
        textFieldNombreDocument.setText(String.valueOf(moModifierProcedure.getNbrDocument()));

    }

}
