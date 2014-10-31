import java.rmi.RemoteException;

public interface IGameEngine {
    public void setGUI(Gui gui);
    public void registerClient(IGui clientGUI) throws RemoteException;
    public int getScore();
    public boolean isGameInProgress();
    public void createGame();
    public void close();
    public void setLeftPressed(boolean pressed);
    public void setRightPressed(boolean pressed);
    public void setUpPressed(boolean pressed);
    public void setDownPressed(boolean pressed);
}
