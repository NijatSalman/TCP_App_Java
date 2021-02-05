package tcpClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import util.FileUtility;

public class TCP_Client {

	public static void main(String[] args) throws Exception{
		sendAsBytes();
	}
	
	public static void sendAsString() throws  IOException{
		Socket socket = new Socket("localhost", 6788);

		OutputStream outPutStream = socket.getOutputStream();
		DataOutputStream dataOutPutStream = new DataOutputStream(outPutStream);
		dataOutPutStream.write("Hi Server,I am coming".getBytes());
		socket.close();	
	}
	
	public static void sendAsBytes() throws Exception{
		Socket socket = new Socket("localhost", 6788);
		OutputStream outPutStream = socket.getOutputStream();
		DataOutputStream dataOutPutStream = new DataOutputStream(outPutStream);
		
		byte[] bytes=FileUtility.readBytes("C:/Users/User/Desktop/NicatSalmanov.jpg");
		dataOutPutStream.writeInt(bytes.length);
		dataOutPutStream.write(bytes);
		outPutStream.write("Hi Server,I am coming".getBytes());
		socket.close();	
	}
}
