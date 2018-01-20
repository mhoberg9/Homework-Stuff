package de.tub.ise.chat.client;

public interface IChatController {
    /**
     * is called if a connection was made succsessfully
     */
    void onConnected();

    /**
     * is called if a connection has been closed ether by the server or the client
     */
    void onDisconnected();
}
