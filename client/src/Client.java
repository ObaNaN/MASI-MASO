import java.rmi.RemoteException;

public class Client implements IGameEngine, IGui{

    private Gui gui;
    private IServer server;

    public Client(String serverAddress) throws java.rmi.RemoteException {
        super();

        connectToServer(serverAddress);
    }

    public void connectToServer(String address) {
        //look up the server and store a reference to the returned object in a class variable
        try {
            server = (IServer) java.rmi.Naming.lookup(address);

            //give the server a remote reference to myself with which it can call me back
            server.registerClient((IGui) java.rmi.server.RemoteObject.toStub(this));
        } catch (Exception e) {
            System.out.println("Help! " + e);
        }
    }

    @Override
    public void setGUI(Gui gui) {
        this.gui = gui;
    }

    public int getScore(){

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

        Gui gui = new Gui();
        client.setGUI(gui);

    }

    @Override
    public void update() throws RemoteException {

    }

    @Override
    public void normalDisplayMode() throws RemoteException {

    }

    @Override
    public void noMarkedDisplayMode() throws RemoteException {

    }

    @Override
    public void markedAsOriginalDisplayMode() throws RemoteException {

    }
}
