import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class Client extends UnicastRemoteObject implements IGameEngine, IGui{

    private Gui gui;
    private IServer server;
    private String serverAddress;

    public Client(String serverAddress) throws java.rmi.RemoteException {
        super();

       this.serverAddress = serverAddress;
    }

    public void connectToServer() {
        //look up the server and store a reference to the returned object in a class variable
        try {
            server = (IServer) java.rmi.Naming.lookup(this.serverAddress);
            //give the server a remote reference to myself with which it can call me back
            server.registerClient((IGui) java.rmi.server.RemoteObject.toStub(this));

        } catch (Exception e) {
            //System.out.println("Help! " + e);
            e.printStackTrace();
        }
    }

    @Override
    public void setGUI(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void registerClient(IGui clientGUI){
        try {
            server.registerClient(clientGUI);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getScore(){
        try {
            return server.getScore();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean isGameInProgress() {
        try {
            return server.isGameInProgress();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void createGame() {
        try {
            server.createGame();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            server.close(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setLeftPressed(boolean pressed) {
        try {
            server.setLeftPressed(pressed);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRightPressed(boolean pressed) {
        try {
            server.setRightPressed(pressed);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setUpPressed(boolean pressed) {
        try {
            server.setUpPressed(pressed);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDownPressed(boolean pressed) {
        try {
            server.setDownPressed(pressed);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(final Vector<Rectangle> vDisplayRoad, final Vector<Rectangle> vDisplayObstacles, final Vector<Rectangle> vDisplayCars, final Car myCar, final int pos, final int nbParticipants, final boolean bGameOver, final String sPosition) throws RemoteException {
        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    gui.update(vDisplayRoad, vDisplayObstacles, vDisplayCars, myCar, pos, nbParticipants, bGameOver, sPosition);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPlayButtonEnabled(boolean enabled) throws RemoteException {
        gui.jButton1.setEnabled(enabled);
    }

    @Override
    public void normalDisplayMode() throws RemoteException {
        //TODO
    }

    @Override
    public void noMarkedDisplayMode() throws RemoteException {
        //TODO

    }

    @Override
    public void markedAsOriginalDisplayMode() throws RemoteException {
        //TODO
    }

    public static void main(String[] args) {

        IGameEngine client = null;
        try {
            client = new Client("//localhost/SRGameServer");
        } catch (Exception e) {
            System.out.println("Fatal exception on startup: " + e);
            System.exit(1);
        }

        String playerName = "Quidam";

        if (args.length == 1)
            if (args[0].length() > 15)
                playerName = args[0].substring(0, 15);
            else
                playerName = args[0];
        //client.setPlayer(new PlayerInfo(playerName));

        Gui gui = new Gui(client);
        gui.setVisible(true);
        client.setGUI(gui);

        ((Client)client).connectToServer();


    }
}
