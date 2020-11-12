package Presentation.modifierProcedure;

import Metier.Gestionnaires.GestionnaireProcedure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CoModifierProcedure {
    private MoModifierProcedure moModifierProcedure;
    private VuModifierProcedure vuModifierProcedure;
    private GestionnaireProcedure gestionnaireProcedure = new GestionnaireProcedure();

    public CoModifierProcedure(MoModifierProcedure moModifierProcedure, VuModifierProcedure vuModifierProcedure) {
        this.moModifierProcedure = moModifierProcedure;
        this.vuModifierProcedure = vuModifierProcedure;
        this.vuModifierProcedure.setInfoFormulaire();


        this.vuModifierProcedure.addButtonAjouterListener(new bntAjouterListener());
        this.vuModifierProcedure.addButtonAnnulerListener(new bntAnnulerListener());

        this.vuModifierProcedure.nomRE2(new nomRE2Listner());
        this.vuModifierProcedure.DescriptionRE3(new descriptionRE3Listner());
        this.vuModifierProcedure.nbrEtapesRE4(new nbrEtapesRE4Listner());
        this.vuModifierProcedure.nbrDocumentRE5(new nbrDocumentRE5Listner());

    }

    class bntAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                vuModifierProcedure.setInfo();
                if (gestionnaireProcedure.modifier(moModifierProcedure.getProcedure())) {
                    vuModifierProcedure.dsiplayErorMessage("bien mise a jour");
                    vuModifierProcedure.dispose();
                }

            } catch (Exception exception) {
                System.out.println(exception);
                vuModifierProcedure.dsiplayErorMessage("erreur");
            }

        }
    }

    class bntAnnulerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuModifierProcedure.dispose();

        }
    }

    class nomRE2Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                String nom = vuModifierProcedure.getdNom();
                if (nom.length() < 20) {
                    vuModifierProcedure.resetLabel(1);
                } else {
                    vuModifierProcedure.afficherErreur(1);
                }

            } catch (Exception exception) {
                vuModifierProcedure.afficherErreur(1);

            }

        }

    }

    class descriptionRE3Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                String description = vuModifierProcedure.getDescription();
                if (description.length() < 140) {
                    vuModifierProcedure.resetLabel(2);
                } else {
                    vuModifierProcedure.afficherErreur(2);
                }

            } catch (Exception exception) {
                vuModifierProcedure.afficherErreur(2);

            }

        }

    }

    class nbrEtapesRE4Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int i = vuModifierProcedure.getNombre_etapes();
                vuModifierProcedure.resetLabel(3);

            } catch (Exception exception) {
                vuModifierProcedure.afficherErreur(3);

            }

        }

    }

    class nbrDocumentRE5Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("xx");
            try {
                int i = vuModifierProcedure.getNombreDocument();
                vuModifierProcedure.resetLabel(4);

            } catch (Exception exception) {
                vuModifierProcedure.afficherErreur(4);
            }

        }

    }

}
