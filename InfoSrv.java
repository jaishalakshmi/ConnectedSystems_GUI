package Infrastructure;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stula
 */
public class InfoSrv {
    public String name;
    public String ip;
    public int portNumber;
    
    public InfoSrv(String name, String ip, int portNumber){
        this.name = name;
        this.ip = ip;
        this.portNumber = portNumber;
    }
    
}
