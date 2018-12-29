/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author mamad
 */
public class Client {
    private Socket sc;
    private BufferedReader entreeSocket;
    private PrintStream sortieSocket;

    public Client(Socket sc) {
        this.sc = sc;
        
    }

    public Socket getSc() {
        return sc;
    }

    public void setSc(Socket sc) {
        this.sc = sc;
    }

    public BufferedReader getEntreeSocket() {
        return entreeSocket;
    }

    public void setEntreeSocket(BufferedReader entreeSocket) {
        this.entreeSocket = entreeSocket;
    }

    
    
    
}
