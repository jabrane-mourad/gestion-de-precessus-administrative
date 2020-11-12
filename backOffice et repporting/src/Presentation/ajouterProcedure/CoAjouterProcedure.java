package Presentation.ajouterProcedure;

import Metier.Gestionnaires.GestionnaireProcedure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CoAjouterProcedure {
    private VuAjouterProcedure vuAjouterProcedure;
    private MoAjouterProcedure moAjouterProcedure;
    private GestionnaireProcedure gestionnaireProcedure = new GestionnaireProcedure();

    public CoAjouterProcedure(VuAjouterProcedure vuAjouterProcedure, MoAjouterProcedure moAjouterProcedure) {
        this.vuAjouterProcedure = vuAjouterProcedure;
        this.moAjouterProcedure = moAjouterProcedure;

        this.vuAjouterProcedure.addButtonAjouterListener(new bntAjouterListener());
        this.vuAjouterProcedure.addButtonAnnulerListener(new bntAnnulerListener());

        this.vuAjouterProcedure.IdProcedureRE1(new idProcedureRE1Listner());
        this.vuAjouterProcedure.nomRE2(new nomRE2Listner());
        this.vuAjouterProcedure.DescriptionRE3(new descriptionRE3Listner());
        this.vuAjouterProcedure.nbrEtapesRE4(new nbrEtapesRE4Listner());
        this.vuAjouterProcedure.nbrDocumentsRE5(new nbrDocumentRE5Listner());

    }

    class bntAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                vuAjouterProcedure.setInfo();
                gestionnaireProcedure.ajouterProcedure(moAjouterProcedure.getProcedure());
                vuAjouterProcedure.dsiplayErorMessage("bien ajouter");
                vuAjouterProcedure.dispose();

            } catch (Exception exception) {
                System.out.println(exception);
                vuAjouterProcedure.dsiplayErorMessage("erreur ajouter");
            }

        }
    }
    class bntAnnulerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuAjouterProcedure.dispose();

        }
    }


    class idProcedureRE1Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int i = vuAjouterProcedure.getIdProcedure();
                vuAjouterProcedure.resetLabel(1);

            } catch (Exception exception) {
                vuAjouterProcedure.afficherErreur(1);

            }

        }

    }
    class nomRE2Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                String nom = vuAjouterProcedure.getdNom();
                if (nom.length() < 20) {
                    vuAjouterProcedure.resetLabel(2);
                } else {
                    vuAjouterProcedure.afficherErreur(2);
                }

            } catch (Exception exception) {
                vuAjouterProcedure.afficherErreur(2);

            }

        }

    }
    class descriptionRE3Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                String description = vuAjouterProcedure.getDescription();
                if (description.length() < 140) {
                    vuAjouterProcedure.resetLabel(3);
                } else {
                    vuAjouterProcedure.afficherErreur(3);
                }

            } catch (Exception exception) {
                vuAjouterProcedure.afficherErreur(3);

            }

        }

    }
    class nbrEtapesRE4Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int i = vuAjouterProcedure.getNombre_etapes();
                vuAjouterProcedure.resetLabel(4);

            } catch (Exception exception) {
                vuAjouterProcedure.afficherErreur(4);

            }

        }

    }
    class nbrDocumentRE5Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int i = vuAjouterProcedure.getNombreDocument();
                vuAjouterProcedure.resetLabel(5);

            } catch (Exception exception) {
                vuAjouterProcedure.afficherErreur(5);

            }

        }

    }


}
