/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author mamad
 */
public class Manager  extends Checker implements IServices{
    
    public Manager(String str, ListeAuth list) {
        super(str, list);
    }
     public String traitment(String chaine) {
        String reponse = " ";
        String[] splitArray = null; //tableau de chaînes
        if (!chaine.isEmpty()) {

            splitArray = chaine.split(" ");
            System.out.println("Type de requetes : " + splitArray[0] + " login :" + splitArray[1] + " password : " + splitArray[2]);
             if (splitArray[0].equals("ADD")) {
                if (super.getList().creer(splitArray[1], splitArray[2]) == true) {
                    reponse = " Client Manager: DONE !!!";
                } else {
                    reponse = "Reponse:  ERROR, ADD !!! ";
                }

            } else if (splitArray[0].equals("MOD")) {
                if (super.getList().mettreAJour(splitArray[1], splitArray[2]) == true) {
                    reponse = "Client Manager : DONE !!!\n";
                } else {
                    reponse = "Reponse:  ERROR, MOD !!!";
                }

            } else if (splitArray[0].equals("DEL")) {
                if (super.getList().supprimer(splitArray[1], splitArray[2]) == true) {
                    reponse = " Reponse:  DONE !!! \n";
                } else {

                    reponse = " Reponse:  ERROR, DEL !!! \n ";
                }

            }
        }
        else{
            reponse=" Reponse: ERROR , \n [XXX] [Login] [password]  \n";
        }

        return reponse;

    }
     
    
}
