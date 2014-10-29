import java.rmi.Remote;

public interface IGui extends Remote {
    public void update() throws java.rmi.RemoteException;

    public void normalDisplayMode() throws java.rmi.RemoteException;

    public void noMarkedDisplayMode() throws java.rmi.RemoteException;

    public void markedAsOriginalDisplayMode() throws java.rmi.RemoteException;

}
