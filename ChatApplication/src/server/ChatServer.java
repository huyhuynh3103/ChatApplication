package server;/*..
 * server
 * Created by HuynhBaHuy
 * Date 1/10/2022 5:14 PM
 * Description:...
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    ServerSocket ss;
    static UserController userController;
    static List<ClientThread> clientThreadList = new ArrayList<>();
    public ChatServer(){
        //load user list
        userController = new UserController();
        // start server
        try{
            System.out.println("Server booting ...");
            ss = new ServerSocket(3200);
            do{
                System.out.println("Waiting for client...");
                try {
                    Socket socket = ss.accept();
                    ClientThread clientThread = new ClientThread(socket);
                    clientThreadList.add(clientThread);
                    clientThread.start();
                    System.out.println("Accept client!");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }while(true);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        new ChatServer();
    }
}
