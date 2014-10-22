import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		/*ImplServer stub = new ImplServer();
		IServer iserv = (IServer) stub;
		
		Naming.rebind("test", iserv);*/
		ImplServer stub = new ImplServer(); 
		//register with RMIReg
		LocateRegistry.createRegistry(4321);
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 4321);
		reg.rebind("SpeedRacer", (IServer) stub);

		System.out.println("Server ready");
		 
		System.out.println("Premiere etape fonctionne");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
