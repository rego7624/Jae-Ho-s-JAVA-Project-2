import java.net.Socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class LibraryMainClient {
	public static void main (String args[]) {
		int port = 1779;
		try {
			Socket s = new Socket("localhost", port);
	//		DataInputStream data_in = new DataInputStream(s.getInputStream());
			DataOutputStream data_out = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String str = "";
			String str2 = "";
			
			Reader r = new Reader(s);
			r.start();
			
			while (!str.equals("stop")) {
	//			str2 = data_in.readUTF();
	//			System.out.println(str2);
				str = "";
				str = br.readLine();
				data_out.writeUTF(str);
				data_out.flush();
				str2 = "";
			}
			data_out.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Reader extends Thread{
	int port = 1779;
	Socket s = null;
	public Reader(Socket s) {
		this.s=s;
	}
	public void run() {
		try {
			DataInputStream data_in = new DataInputStream(s.getInputStream());
			String str2 = "";
			while(true) {
				str2 = data_in.readUTF();
				System.out.println(str2);
			}
		}catch(Exception e) {
			System.out.println("Socket Close");
			return;
		}
	}
}
