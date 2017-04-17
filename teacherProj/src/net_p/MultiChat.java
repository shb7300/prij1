package net_p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.java_cup.internal.runtime.Scanner;



class TCPSingleGUI extends JFrame
{
	JTextArea ta = new JTextArea();
	JTextField tf = new JTextField();
	
	public TCPSingleGUI(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		setBounds(0, 0, 300, 500);
		
		add(ta,"Center");
		add(tf,"South");
		
		setVisible(true);
		
		
	}
	
}


class MultyChatReciver extends Thread
{
	
	public MultyChatReciver() {
		// TODO Auto-generated constructor stub
		
		
	}
	 
	@Override
	public void run() {
	// TODO Auto-generated method stub
		

	}

}




class MultyChatSender extends Thread
{
	TCPSingleGUI win;
	DatagramPacket ds;
	MulticastSocket ms;
	
	public MultyChatSender(MulticastSocket ms,TCPSingleGUI win,DatagramPacket ds)
	{
		this.ms=ms;
		this.win=win;
		this.ds=ds;
		
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
	        ms = new MulticastSocket();
	        
	        ms.send(ds);
	        ms.close();
	         
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}
}




public class MultiChat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
	         MulticastSocket ms = new MulticastSocket(7777);
	         InetAddress is = InetAddress.getByName("230.0.0.1");
	         String msg="왜나만안되";
	         DatagramPacket ds = new DatagramPacket(
	               msg.getBytes(), 
	               msg.getBytes().length,
	               is,
	               7777
	               );
	         TCPSingleGUI win = new TCPSingleGUI("서버");
	         
	         new MultyChatSender(ms,win,ds).start();
	         
	       
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
		

	}

}
