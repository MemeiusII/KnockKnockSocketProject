package me.EthanBilbrey.KnockKnockSocketProject.ServerSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KnockKnockServer 
{
	public static void main(String[] args) throws IOException 
	{
		int portNumber = 4444;
			
		try
		(
			//binds server to the specified port
			ServerSocket serverSocket = new ServerSocket(portNumber);
			//Waits for client to connect and then creates a new socket for them
			Socket clientSocket = serverSocket.accept();
			
			//Sets up IO
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		) 
		{
			String outputLine, inputLine;
			
			//Start conversation with client
			//KnockKnockProtocol kkp = new KnockKnockProtocol();
			//outputLine = kkp.processInput(null);
			//System.out.println(outputLine);
			//out.println(outputLine);
			System.out.println("[Server] Type something!");
			out.println("Type something!");
			
			//We initialize inputLine in the while loop so that we can use it throughout the loop, if you were to just use in.readLine(), your code would stop and wait for input at every instance of its use
			while((inputLine = in.readLine()) != null) 
			{
				//String fromUser = in.readLine();
				out.println("[Server] You typed: " + inputLine);
				System.out.println("[Client] " + inputLine);
				System.out.println("[Server] You typed: " + inputLine);
				break;
			}
			
		} 
	}
}
