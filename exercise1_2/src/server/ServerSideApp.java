package server;
import exercise1_2.ItemProduct;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class ServerSideApp {
	
	public static void main(String[] args) {
		
		ItemProduct item = new ItemProduct();
		int portNo = 2939;
		System.out.println("> Waiting for connection....");
		
		
		
		try {
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			
			while(true) {
				Socket socket = serverSocket.accept();
				
				System.out.println("\n> New connetion has established");
				
				
				ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
				
				item = (ItemProduct)objectIS.readObject();
				
				item.setItemProductID(1);
				
				System.out.println("\n> ID is generated");
				
				ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
				objectOS.writeObject(item);
				
				System.out.println("\n> Object is sent back to client successfully");
				
				objectIS.close();
				objectOS.close();
				System.out.println("\n> Connection has ended.");
				System.out.println("\n========================================");
				System.out.println("\n> Waiting for connection....");
							
			}
		}catch(IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	
		
	}

}
