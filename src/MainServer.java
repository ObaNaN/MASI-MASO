import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		ImplServer stub = new ImplServer();
		IServer iserv = (IServer) stub;
		
		Naming.rebind("test", iserv);
		System.out.println("Premiere etape fonctionne");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
