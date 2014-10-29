import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server extends UnicastRemoteObject implements IServer{

    public Server() throws Exception{
            super();

            //register with RMIReg
            startRegistry(1099);
            java.rmi.Naming.rebind("//localhost/LAGameServer", (IServer) this);

            System.out.println("Server ready");

            //prep the engine
            //engine = new ServerGameEngine(25);
    }

    private static void startRegistry(int RMIPortNum) throws RemoteException {
        try {
            Registry registry =
                    LocateRegistry.getRegistry(RMIPortNum);
            registry.list();
            // This call will throw an exception
            // if the registry does not already exist
        } catch (RemoteException e) {
            // No valid registry at that port.
            Registry registry =
                    LocateRegistry.createRegistry(RMIPortNum);
        }
    }

	public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            System.out.println("Fatal: " + e);
            e.printStackTrace();
            System.exit(1);
        }
    }
}
