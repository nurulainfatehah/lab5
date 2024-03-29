package client;

import exercise1_2.ItemProduct;
import java.util.Scanner;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;



public class ClientSideApp {
	
	public static void main(String[] args) {
		
		ItemProduct item = new ItemProduct();
		
		int portNo = 2939;
		
		System.out.println("\n> This system will receive the product's name and request for its ID from the server.");
				
		System.out.println("\n> Please enter the name of the product:");
		
		Scanner in = new Scanner(System.in);
		
		String name = in.nextLine();
		
		item.setName(name);
		
		try {
			
			Socket socket = new Socket(InetAddress.getLocalHost(), portNo);
			
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
			
			objectOS.writeObject(item);
			
			System.out.println("\n> Object of itemProduct is sent to the server @" + item);
			
			ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
			
			item = (ItemProduct)objectIS.readObject();
			
			System.out.println("\n> Server has returned the ID for " + item.getName());
			System.out.println("\n=================================");
			
			System.out.println("Item's ID: " + item.getItemProductID() + "\nItem's Name: " + item.getName() + "\n=================================\n");
			
			
			objectOS.close();
			objectIS.close();
			socket.close();
			
			
			
			
			
			
		}catch(IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
	}

}
