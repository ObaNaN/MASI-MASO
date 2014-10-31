import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IServer extends Remote{

    public void setGUI(IGui gui) throws RemoteException;
    public void registerClient(IGui clientGUI) throws RemoteException;
    public int getScore() throws RemoteException;
    public boolean isGameInProgress() throws RemoteException;

    public void createGame() throws RemoteException;

    public void close(IGui gui) throws RemoteException;

    public void setLeftPressed(boolean pressed) throws RemoteException;
    public void setRightPressed(boolean pressed) throws RemoteException;
    public void setUpPressed(boolean pressed) throws RemoteException;
    public void setDownPressed(boolean pressed) throws RemoteException;
}
