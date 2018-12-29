/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

/**
 *
 * @author mamad
 */
import Metier.Checker;
import Metier.ListeAuth;
import Metier.Manager;
import Metier.Metier_AS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.omg.CORBA.MARSHAL;

public class ServeurTCP {

    private ServerSocket ssg;

    public ServeurTCP(ServerSocket ssg) {
        this.ssg = ssg;
    }

    public ServerSocket getSsg() {
        return ssg;
    }

    public void setSsg(ServerSocket ssg) {
        this.ssg = ssg;
    }

    public void traitementTCP(ListeAuth list) throws Exception {
        while (true) {
            // On attend une connexion puis on l'accepte
            Socket sss = ssg.accept();

            // Construction d'un BufferedReader pour lire du texte envoyé à travers la connexion socket
            BufferedReader entreeSocket = new BufferedReader(new InputStreamReader(sss.getInputStream()));
            // Construction d'un PrintStream pour envoyer du texte à travers la connexion socket
            PrintStream sortieSocket = new PrintStream(sss.getOutputStream());

            String chaine = "";
            String resultat;
            while (chaine != null) {
                // lecture d'une chaine envoyée à travers la connexion socket
                chaine = entreeSocket.readLine();
                //System.out.println("Chaine reçue : "+chaine);
                if (chaine == null) {
                    break;
                }
                String[] splitArray = chaine.split(" ");
                if (splitArray[0].equals("CHK")) {
                    Checker checker = new Checker(chaine, list);
                    resultat = checker.traitment(chaine);
                } else {
                    Manager manager = new Manager(chaine, list);
                    resultat = manager.traitment(chaine);
                }

                sortieSocket.println(resultat);

            }

            // on ferme nous aussi la connexion
            sss.close();
        }
    }

}
