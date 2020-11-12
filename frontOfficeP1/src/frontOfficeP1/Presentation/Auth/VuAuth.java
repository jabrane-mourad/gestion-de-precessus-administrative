package frontOfficeP1.Presentation.Auth;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VuAuth extends JFrame {
    private JFrame frame;
    JLabel lblImg;
    JLabel lblAuth;
    private JLabel labelMatricule;
    private JLabel labelMotPasse;
    private JTextField matricule;
    private JPasswordField motPasse;
    private JButton connexion;
    private MoAuth moAuth;
    private JCheckBox checkBox;


    public VuAuth(MoAuth moauth){
        super("Authentication");
        this.setSize(1200,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.moAuth=moauth;

        this.initialiser();
        this.dessiner();
    }


    private void initialiser() {
        this.frame = new JFrame();
        this.lblAuth= new JLabel("veuillez s'autentifiez ");
        this.lblImg = new JLabel("");
        this.lblImg.setIcon(new ImageIcon("img/unnamed.jpg"));
        this.labelMatricule= new JLabel("Matricule : ");
        this.labelMotPasse= new JLabel("Mot de passe :");
        this.matricule = new JTextField();
        this.motPasse = new JPasswordField();
        this.connexion= new JButton("Connexion");
        this.checkBox=new JCheckBox();
        this.checkBox.setText("connectez-vous en tant que chef");
    }

    private void dessiner(){

        this.frame.getContentPane().setBackground(Color.WHITE);
        this.frame.getContentPane().setLayout(null);


        this.lblAuth.setFont(new Font("Tahoma", Font.PLAIN, 34));
        this.lblAuth.setForeground(new Color(0, 0, 0));
        this.lblAuth.setBounds(400, 13, 361, 61);
        this.frame.getContentPane().add(this.lblAuth);



        this.lblImg.setBounds(350, 25, 992, 240);
        this.frame.getContentPane().add(this.lblImg);


        this.labelMatricule.setFont(new Font("Tahoma", Font.BOLD, 15));
        this.labelMatricule.setBounds(350, 243, 130, 46);
        this.frame.getContentPane().add(this.labelMatricule);


        this.labelMotPasse.setFont(new Font("Tahoma", Font.BOLD, 14));
        this.labelMotPasse.setBounds(350, 317, 130, 17);
        this.frame.getContentPane().add(this.labelMotPasse);


        this.matricule.setBounds(500, 244, 258, 46);
        this.frame.getContentPane().add(this.matricule);
        this.matricule.setColumns(10);


        this.motPasse.setBounds(500, 303, 258, 46);
        this.frame.getContentPane().add(motPasse);

        this.checkBox.setBounds(500,355,450,40);
        this.frame.getContentPane().add(this.checkBox);




        this.connexion.setFont(new Font("Times New Roman", Font.BOLD, 16));
        this.connexion.setBounds(550, 400, 150, 36);
        this.frame.getContentPane().add(this.connexion);
        this.add(frame.getContentPane());

    }
    public String getMatricule(){
        return matricule.getText();
    }
    public String getMotPass(){

        return  String.copyValueOf(motPasse.getPassword());
    }

    public void addConnexionListener(ActionListener listenforConnexionButton){
        connexion.addActionListener(listenforConnexionButton);
    }
    public void dsiplayErorMessage(String error){
        JOptionPane.showMessageDialog(this,error);
    }

    public void setInfo() {
        moAuth.setMatricule(getMatricule());
        moAuth.setMotPasse(getMotPass());
    }
    public Boolean isChecked(){
        return this.checkBox.isSelected();
    }
}

