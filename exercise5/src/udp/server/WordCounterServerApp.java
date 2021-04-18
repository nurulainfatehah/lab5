package udp.server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class WordCounterServerApp {
	
	
	public static void main(String[] args) {
		
	final int portNo = 3993;
	int word = 0;
	
	
	try {
		System.out.println("\n> Waiting for connection...");
		
		DatagramSocket serverSocket = new DatagramSocket(portNo);
		
		byte receivingDataBuffer[] = new byte[1024];
		
		DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
		
		serverSocket.receive(inputPacket);
		
		System.out.println("\n> A new request is made");
		System.out.println("\n> Processing the text now");
		
		String sentence = new String(inputPacket.getData());
		
		
		char ch[]= new char[sentence.length()];     
        for(int i=0;i<sentence.length();i++)  
        {  
            ch[i]= sentence.charAt(i);  
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                word++;  
        } 
		
       
        byte sendingDataBuffer[] = String.valueOf(word).getBytes();
        
        System.out.println("\n> Text: " + sentence);
        System.out.println("> No. of word(s): " + word);
        
        InetAddress senderAddress = inputPacket.getAddress();
	    int senderPort = inputPacket.getPort();
	    
	    System.out.println("\n> Preparing packet for client...");
	    
	    // Create new UDP packet with data to send to the client
	    DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, 
	    		sendingDataBuffer.length, senderAddress,senderPort);
	    
	    // Send the created packet to client
	    serverSocket.send(outputPacket);
	    
	    System.out.println("\n> No. of word(s) is sent to client");
	    
	    
	    
	    System.out.println("\n> Client has disconnected");
	    System.out.println("\n> Closing server connection...");
	    serverSocket.close();
		
		
		
	}catch(IOException ex) {
		ex.printStackTrace();
	}
		
		
	}
	
	
	

}
