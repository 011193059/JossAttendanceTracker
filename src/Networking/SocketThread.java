package Networking;


import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

public class SocketThread implements Runnable {
    private Thread thr;
    private NetworkUtil nc;

    public SocketThread(NetworkUtil nc, String name) {
        this.nc = nc;
        this.thr = new Thread(this, name);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                String s = (String) nc.read();
                if (s.equals("$EXIT$")) {
                    nc.closeConnection();
                    break;
                };
                String tN = Thread.currentThread().getName();
                System.out.println(tN + " says " +s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        nc.closeConnection();
    }
}



