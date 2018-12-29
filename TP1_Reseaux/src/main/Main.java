/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Metier.ListeAuth;
import Serveur.ServeurTCP;
import java.net.ServerSocket;

/**
 *
 * @author mamad
 */
public class Main {
     public static void main(String args[]) throws Exception {

        // Création d'un socket serveur générique sur le port 40000
       // ServerSocket ssg = new ServerSocket(28415);
        ListeAuth list= new ListeAuth();
        
        ServeurTCP serveurtcp= new ServeurTCP(new ServerSocket(28415));
        serveurtcp.traitementTCP(new ListeAuth());
        
        
        
        

        
    }
    
    
}
