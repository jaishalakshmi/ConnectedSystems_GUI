package Infrastructure;


import java.net.ServerSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stula
 */
public class ServerPolice {
    public ServerPolice(InfoSrv server, InfoSrv ca) {
        this.connect(server, ca);
    }

    public void connect(InfoSrv server, InfoSrv ca) {
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(server.portNumber)) {
            while (listening) {
                System.out.println(server.name + " server is running");
                new ServerPoliceThread(serverSocket.accept(), server.name, ca).start();
            }
        } catch (Exception e) {
            System.out.println("Could not listen on port " + server.portNumber);
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        InfoSrv server = new InfoSrv("ServerPolice",null, 10042);
        InfoSrv ca = new InfoSrv("CA1","127.0.0.1", 10040);
        ServerPolice policeServer = new ServerPolice(server, ca);
    }
}
