package Presentation.ajouterEmoloye;

import Metier.Gestionnaires.GestionnaireEmploye;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CoAjoutEmploye {
    private VuAjoutEmploye vuAjoutEmploye;
    private MoAjoutEmploye moAjoutEmploye;
    private GestionnaireEmploye gestionnaireEmploye = new GestionnaireEmploye();

    public CoAjoutEmploye(VuAjoutEmploye vuAjoutEmploye, MoAjoutEmploye moAjoutEmploye) {
        this.vuAjoutEmploye = vuAjoutEmploye;
        this.moAjoutEmploye = moAjoutEmploye;
        this.vuAjoutEmploye.addButtonAjouterListener(new bntAjouterListener());
        this.vuAjoutEmploye.addButtonAnnulerListener(new bntAnnulerListener());
        this.vuAjoutEmploye.nomRE1(new nomRE1ListenerListener());
        this.vuAjoutEmploye.prenomRE2(new prenomRE2Listener());
        this.vuAjoutEmploye.cinRE3(new cinRE3Listener());
        this.vuAjoutEmploye.teleRE4(new teleRE4Listener());
        this.vuAjoutEmploye.adresseRE5(new adresseRE5Listener());
        this.vuAjoutEmploye.matriculeRE6(new matriculeRE6Listener());
        this.vuAjoutEmploye.postRE7(new postRE7Listener());
        this.vuAjoutEmploye.gradeRE8(new gradeRE8Listener());
        this.vuAjoutEmploye.salaireRE9(new salaireRE9Listener());
        this.vuAjoutEmploye.passRE10(new passRE10Listener());
    }

    class nomRE1ListenerListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuAjoutEmploye.getTextFieldNom().getText().length() < 14) {
                vuAjoutEmploye.resetLabel(1);
            } else {
                vuAjoutEmploye.afficherErreur(1);

            }

        }

    }

    class prenomRE2Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuAjoutEmploye.getTextFieldPrenom().getText().length() < 14) {
                vuAjoutEmploye.resetLabel(2);
            } else {
                vuAjoutEmploye.afficherErreur(2);

            }

        }

    }

    class cinRE3Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuAjoutEmploye.getTextFieldCIN().getText().length() < 14) {
                vuAjoutEmploye.resetLabel(3);
            } else {
                vuAjoutEmploye.afficherErreur(3);

            }

        }

    }

    class teleRE4Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int i = Integer.parseInt(vuAjoutEmploye.getTextFieldTele().getText());
                if (vuAjoutEmploye.getTextFieldTele().getText().length() < 10) {
                    vuAjoutEmploye.resetLabel(4);
                } else {
                    vuAjoutEmploye.afficherErreur(4);
                }
            } catch (Exception exception) {
                vuAjoutEmploye.afficherErreur(4);

            }

        }

    }

    class adresseRE5Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuAjoutEmploye.getTextFieldAdresse().getText().length() < 35) {
                vuAjoutEmploye.resetLabel(5);
            } else {
                vuAjoutEmploye.afficherErreur(5);

            }

        }

    }

    class matriculeRE6Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuAjoutEmploye.getTextFieldMatricule().getText().length() < 10) {
                vuAjoutEmploye.resetLabel(6);
            } else {
                vuAjoutEmploye.afficherErreur(6);

            }

        }

    }

    class postRE7Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuAjoutEmploye.getTextFieldPoste().getText().length() < 7) {
                vuAjoutEmploye.resetLabel(7);
            } else {
                vuAjoutEmploye.afficherErreur(7);

            }

        }

    }

    class gradeRE8Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuAjoutEmploye.getTextFieldGrade().getText().length() < 10) {
                vuAjoutEmploye.resetLabel(8);
            } else {
                vuAjoutEmploye.afficherErreur(8);

            }

        }

    }

    class salaireRE9Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int i = Integer.parseInt(vuAjoutEmploye.getTextFieldSalaire().getText());
                vuAjoutEmploye.resetLabel(9);
            } catch (Exception exception) {
                vuAjoutEmploye.afficherErreur(9);

            }

        }

    }

    class passRE10Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuAjoutEmploye.getTextFieldMotPasse().getText().length() < 14 &&
                    vuAjoutEmploye.getTextFieldMotPasse().getText().length() > 7) {
                vuAjoutEmploye.resetLabel(10);
            } else {
                vuAjoutEmploye.afficherErreur(10);

            }
        }

    }

    class bntAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuAjoutEmploye.setInfo();
            System.out.println(moAjoutEmploye.getMatricule());
            gestionnaireEmploye.creationEmploye(
                    moAjoutEmploye.getMatricule(),
                    moAjoutEmploye.getCin(),
                    moAjoutEmploye.getNom(),
                    moAjoutEmploye.getPrenom(),
                    moAjoutEmploye.getTele(),
                    moAjoutEmploye.getAdresse(),
                    moAjoutEmploye.getPoste(),
                    moAjoutEmploye.getGrade(),
                    moAjoutEmploye.getSalaire(),
                    moAjoutEmploye.getMotDePasse(),false
            );
            try {
                gestionnaireEmploye.ajouter();
                vuAjoutEmploye.dsiplayErorMessage("bien ajouter");
                vuAjoutEmploye.dispose();
            } catch (Exception exception) {
                vuAjoutEmploye.dsiplayErorMessage("erreur ajouter");
            }

        }
    }

    class bntAnnulerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuAjoutEmploye.dispose();

        }
    }

}
