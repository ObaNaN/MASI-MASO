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
	
	

	
	/*
	 * 
	 * Server_GameServer gameServer = new Server_GameServer(); // gameserver est un implementation
//register with RMIReg
LocateRegistry.createRegistry(1234);
Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1234);
reg.rebind("LAGameServer", (IGameServer) gameServer);
//java.rmi.Naming.rebind("//localhost/LAGameServer", (IGameServer) this);

System.out.println("Server ready");
	 * 
	 * 
	 * */
	
	
	
}
