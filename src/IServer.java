import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IServer extends Remote{
	
	public void test() throws RemoteException;
	

}
