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
public class Checker implements IServices {

     private String chaine;
    private ListeAuth list;

    public Checker(String str, ListeAuth list) {
        this.chaine = str;
        this.list = list;
    }
    @Override
    
    public String traitment(String chaine) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String reponse =null;
        String[] splitArray = null; //tableau de chaînes
        if (!chaine.isEmpty()) {

            splitArray = chaine.split(" ");
            System.out.println("Type de requetes : " + splitArray[0] + " login :" + splitArray[1] + " password : " + splitArray[2]);
            if (splitArray[0].equals("CHK")) {
                if (list.tester(splitArray[1], splitArray[2]) == true) {
                    reponse = " Reponse :   GOOD !!! ";
                } else {
                    reponse = " Reponse: Authentification non autoriser ";

                }
            }
        }
        return reponse;
    }

    public String getChaine() {
        return chaine;
    }

    public void setChaine(String chaine) {
        this.chaine = chaine;
    }

    public ListeAuth getList() {
        return list;
    }

    public void setList(ListeAuth list) {
        this.list = list;
    }
    
    
}
