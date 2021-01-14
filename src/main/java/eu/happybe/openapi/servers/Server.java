package eu.happybe.openapi.servers;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.TransferPacket;
import lombok.Getter;

public class Server {

    @Getter
    public String serverName;
    @Getter
    public String serverAlias;
    @Getter
    public String serverAddress;
    @Getter
    public int serverPort;
    @Getter
    public int onlinePlayers;
    @Getter
    public boolean isOnline;
    @Getter
    public boolean isWhitelisted;

    public Server(String serverName, String serverAlias, String serverAddress, int serverPort) {
        this(serverName, serverAlias, serverAddress, serverPort, 0);
    }
    
    public Server(String serverName, String serverAlias, String serverAddress, int serverPort, int onlinePlayers) {
        this(serverName, serverAlias, serverAddress, serverPort, onlinePlayers, false);
    }

    public Server(String serverName, String serverAlias, String serverAddress, int serverPort, int onlinePlayers, boolean isOnline) {
        this(serverName, serverAlias, serverAddress, serverPort, onlinePlayers, isOnline, false);
    }

    public Server(String serverName, String serverAlias, String serverAddress, int serverPort, int onlinePlayers, boolean isOnline, boolean isWhitelisted) {
        this.update(serverName, serverAlias, serverAddress, serverPort, onlinePlayers, isOnline, isWhitelisted);
    }

    public void update(String serverName, String serverAlias, String serverAddress, int serverPort) {
        this.update(serverName, serverAlias, serverAddress, serverPort, 0);
    }

    public void update(String serverName, String serverAlias, String serverAddress, int serverPort, int onlinePlayers) {
        this.update(serverName, serverAlias, serverAddress, serverPort, onlinePlayers, false);
    }
    
    public void update(String serverName, String serverAlias, String serverAddress, int serverPort, int onlinePlayers, boolean isOnline) {
        this.update(serverName, serverAlias, serverAddress, serverPort, onlinePlayers, isOnline, false);
    }
    
    public void update(String serverName, String serverAlias, String serverAddress, int serverPort, int onlinePlayers, boolean isOnline, boolean isWhitelisted) {
        this.serverName = serverName;
        this.serverAlias = serverAlias;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.onlinePlayers = onlinePlayers;
        this.isOnline = isOnline;
        this.isWhitelisted = isWhitelisted;
    }
    
    public void transferPlayerHere(Player player) {
        TransferPacket pk = new TransferPacket();
        pk.address = this.getServerAddress();
        pk.port = this.getServerPort();

        player.dataPacket(pk);
    }
}
