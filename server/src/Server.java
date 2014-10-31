import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server extends UnicastRemoteObject implements IServer{

    private Core core;

    public Server() throws Exception{
            super();

            //register with RMIReg
            startRegistry(1099);
            java.rmi.Naming.rebind("//localhost/SRGameServer", (IServer) this);

            System.out.println("Server ready");

            //prep the engine
            core = new Core();
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

    @Override
    public void setGUI(IGui gui) throws RemoteException {
        core.setGUI(gui);
    }

    @Override
    public void registerClient(IGui clientGUI) throws RemoteException {
        core.setGUI(clientGUI);
        core.runGame();
    }

    @Override
    public int getScore() throws RemoteException {
        return Core.score;
    }

    @Override
    public boolean isGameInProgress() throws RemoteException {
        return Core.bGameInProgress;
    }

    @Override
    public void createGame() throws RemoteException {
        core.createGame();
    }

    @Override
    public void close(IGui gui) throws RemoteException {
        Core.bGameQuit = false;
    }

    @Override
    public void setLeftPressed(boolean pressed) throws RemoteException {
        Core.LE_P = pressed;
    }

    @Override
    public void setRightPressed(boolean pressed) throws RemoteException {
        Core.RI_P = pressed;
    }

    @Override
    public void setUpPressed(boolean pressed) throws RemoteException {
        Core.UP_P = pressed;
    }

    @Override
    public void setDownPressed(boolean pressed) throws RemoteException {
        Core.DO_P = pressed;
    }
}
