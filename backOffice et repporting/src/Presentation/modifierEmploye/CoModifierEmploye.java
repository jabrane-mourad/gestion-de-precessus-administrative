package Presentation.modifierEmploye;

import Metier.BeansMetier.Employe;
import Metier.Gestionnaires.GestionnaireEmploye;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CoModifierEmploye {
    private VuModifierEmploye vuModifierEmploye;
    private MoModifierEmploye moModifierEmploye;
    GestionnaireEmploye gestionnaireEmploye=new GestionnaireEmploye();

    public CoModifierEmploye(VuModifierEmploye vuModifierEmploye, MoModifierEmploye moModifierEmploye) {
        this.vuModifierEmploye = vuModifierEmploye;
        this.moModifierEmploye = moModifierEmploye;
        setInfoI(moModifierEmploye.getMatricule());

        this.vuModifierEmploye.addboxEtatEmployeListener(new boxEtatEmployeListener());
        this.vuModifierEmploye.addButtonAjouterListener(new bntAjouterListener());
        this.vuModifierEmploye.addButtonAnnulerListener(new bntAnnulerListener());
        this.vuModifierEmploye.nomRE1(new nomRE1ListenerListener());
        this.vuModifierEmploye.prenomRE2(new prenomRE2Listener());
        this.vuModifierEmploye.cinRE3(new cinRE3Listener());
        this.vuModifierEmploye.teleRE4(new teleRE4Listener());
        this.vuModifierEmploye.adresseRE5(new adresseRE5Listener());
        this.vuModifierEmploye.postRE7(new postRE7Listener());
        this.vuModifierEmploye.gradeRE8(new gradeRE8Listener());
        this.vuModifierEmploye.salaireRE9(new salaireRE9Listener());
        this.vuModifierEmploye.passRE10(new passRE10Listener());
    }

    private void setInfoI(String matricule) {
        Employe employe=gestionnaireEmploye.getEmployeByMatricule(matricule);
        vuModifierEmploye.setTextFieldNom(employe.getNom());
        vuModifierEmploye.setTextFieldPrenom(employe.getPrenom());
        vuModifierEmploye.setTextFieldCIN(employe.getCin());
        vuModifierEmploye.setTextFieldTele(employe.getTel());
        vuModifierEmploye.setTextFieldAdresse(employe.getAdresse());
        vuModifierEmploye.setTextFieldPoste(employe.getPoste());
        vuModifierEmploye.setTextFieldGrade(employe.getGrade());
        vuModifierEmploye.setTextFieldSalaire(String.valueOf(employe.getSalaire()));
        vuModifierEmploye.setTextFieldMotPasse(employe.getMotDePasse());
        vuModifierEmploye.setEtatEmploye(String.valueOf(employe.isArchive()));
    }

    class nomRE1ListenerListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuModifierEmploye.getTextFieldNom().getText().length() < 14) {
                vuModifierEmploye.resetLabel(1);
            } else {
                vuModifierEmploye.afficherErreur(1);

            }

        }

    }

    class prenomRE2Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuModifierEmploye.getTextFieldPrenom().getText().length() < 14) {
                vuModifierEmploye.resetLabel(2);
            } else {
                vuModifierEmploye.afficherErreur(2);

            }

        }

    }

    class cinRE3Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuModifierEmploye.getTextFieldCIN().getText().length() < 14) {
                vuModifierEmploye.resetLabel(3);
            } else {
                vuModifierEmploye.afficherErreur(3);

            }

        }

    }

    class teleRE4Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int i = Integer.parseInt(vuModifierEmploye.getTextFieldTele().getText());
                if (vuModifierEmploye.getTextFieldTele().getText().length() < 10) {
                    vuModifierEmploye.resetLabel(4);
                } else {
                    vuModifierEmploye.afficherErreur(4);
                }
            } catch (Exception exception) {
                vuModifierEmploye.afficherErreur(4);

            }

        }

    }

    class adresseRE5Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuModifierEmploye.getTextFieldAdresse().getText().length() < 35) {
                vuModifierEmploye.resetLabel(5);
            } else {
                vuModifierEmploye.afficherErreur(5);

            }

        }

    }


    class postRE7Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuModifierEmploye.getTextFieldPoste().getText().length() < 7) {
                vuModifierEmploye.resetLabel(7);
            } else {
                vuModifierEmploye.afficherErreur(7);

            }

        }

    }

    class gradeRE8Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuModifierEmploye.getTextFieldGrade().getText().length() < 10) {
                vuModifierEmploye.resetLabel(8);
            } else {
                vuModifierEmploye.afficherErreur(8);

            }

        }

    }

    class salaireRE9Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int i = Integer.parseInt(vuModifierEmploye.getTextFieldSalaire().getText());
                vuModifierEmploye.resetLabel(9);
            } catch (Exception exception) {
                vuModifierEmploye.afficherErreur(9);

            }

        }

    }

    class passRE10Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (vuModifierEmploye.getTextFieldMotPasse().getText().length() < 14 &&
                    vuModifierEmploye.getTextFieldMotPasse().getText().length() > 7) {
                vuModifierEmploye.resetLabel(10);
            } else {
                vuModifierEmploye.afficherErreur(10);

            }
        }

    }

    class bntAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuModifierEmploye.setInfo();
            moModifierEmploye.getMatricule();
            gestionnaireEmploye.creationEmploye(
                    moModifierEmploye.getMatricule(),
                    moModifierEmploye.getCin(),
                    moModifierEmploye.getNom(),
                    moModifierEmploye.getPrenom(),
                    moModifierEmploye.getTele(),
                    moModifierEmploye.getAdresse(),
                    moModifierEmploye.getPoste(),
                    moModifierEmploye.getGrade(),
                    moModifierEmploye.getSalaire(),
                    moModifierEmploye.getMotDePasse(),
                    moModifierEmploye.getArchive()
            );
            try {
                gestionnaireEmploye.miseAjour();
                vuModifierEmploye.dsiplayErorMessage("bien mise à jour");
                vuModifierEmploye.dispose();
            } catch (Exception exception) {
                vuModifierEmploye.dsiplayErorMessage("erreur de mise à jour");
            }

        }
    }

    class bntAnnulerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuModifierEmploye.dispose();

        }
    }
    class boxEtatEmployeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String type = (String) cb.getSelectedItem();
            switch (type) {
                case "Active":
                    moModifierEmploye.setArchive(false);
                    break;
                case "Archive":
                    moModifierEmploye.setArchive(true);
                    break;
            }


        }

    }
}
