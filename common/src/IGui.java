import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface IGui extends Remote {
    public void update(Vector<Rectangle> vDisplayRoad, Vector<Rectangle> vDisplayObstacles, Vector<Rectangle> vDisplayCars, Car myCar, int pos, int nbParticipants, boolean bGameOver, String sPosition) throws java.rmi.RemoteException;

    public void setPlayButtonEnabled(boolean enabled) throws RemoteException;

    public void normalDisplayMode() throws java.rmi.RemoteException;

    public void noMarkedDisplayMode() throws java.rmi.RemoteException;

    public void markedAsOriginalDisplayMode() throws java.rmi.RemoteException;

}
