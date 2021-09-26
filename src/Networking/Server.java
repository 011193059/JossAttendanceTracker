package Networking;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class Server {

    private ServerSocket ServSock;
    private int nConnectedClient;
    public Hashtable<Integer, Socket> clients = new Hashtable<>();



    public static void main(String args[]) throws IOException {
        System.out.println("Waiting for Client");
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("Client is Connected");


        OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
        BufferedWriter writer = new BufferedWriter(o);

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader reader = new BufferedReader(isr);
        String pReader = reader.readLine();
        System.out.println(pReader);

        writer.write(pReader);
        writer.newLine();
        writer.flush();
        writer.close();
    }

}
