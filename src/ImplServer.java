import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ImplServer extends UnicastRemoteObject implements IServer{

	protected ImplServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void test() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("etape 2 fonctionne");
	} 
	
	

	
	
	
	
	
}
