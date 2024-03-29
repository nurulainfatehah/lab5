package udp.client;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class WordCounterClientApp {
	
	
	public static void main(String[] args) {
		
		
		final int portNo = 3993;
		Scanner input = new Scanner(System.in);
		int bufferSize = 700;
		
		try {
			
			System.out.println("\n> This system will return to you number of word from text you entered.");
			System.out.println("> Connection has been successfully made.");
			System.out.println("\n=======================================================");
			DatagramSocket socket = new DatagramSocket();
			
			byte sendingDataBuffer[] = new byte[bufferSize];
			
			System.out.println("\n> Enter a text:");
			String sentence = input.nextLine();
			
			sendingDataBuffer = sentence.getBytes();

			// Creating a UDP packet 
			DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer,
					sendingDataBuffer.length, InetAddress.getByName("localhost"), portNo);

			// Sending UDP packet to the server
			socket.send(sendingPacket);
			System.out.println("\n> Server is calculating the text now...");
			
			System.out.println("=======================================================");
			
			// Create buffer to receive data
			byte receivingDataBuffer [] = new byte[bufferSize];

			// Receive data packet from server
			DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,
					receivingDataBuffer.length);
			
			socket.receive(receivingPacket);

			// Unpack packet
			String noOfWord = new String(receivingPacket.getData());
			System.out.println("\nText: " + sentence);
			System.out.println("\nNo. of word(s): " + noOfWord);
			
			
			
			System.out.println("Closing the connection...");

			// Closing the socket connection with the server
			socket.close();
			
			
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
