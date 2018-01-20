package de.tub.ise.chat.client;

import de.tub.ise.chat.ChatMessage;

import java.util.Collection;

public interface ChatInterface {
    /**
     * Establishes a connection to the server and waits for messages.
     *
     * can be called multiple times without causing errors.
     *
     * can be called to reconnect to server als long as close has not been called
     * @throws Exception
     */
    void connect() throws Exception;

    /**
     * closes connection all subsequent calls to connect, send will fail
     */
    void close();

    /**
     * sends a message to the server
     * @param text
     * @throws Exception
     */
    void onSend(String text) throws Exception;
    
    /**
     * requests the server to send recent history to client
     */
    void onGetHistory();

    /**
     * register a set were all incoming messages are stored
     * @param messages
     */
    void registerMessageQueue(Collection<ChatMessage> messages);

    /**
     * interface to indicate the connection status of the client to the view controller
     * @param controller
     */
    void registerController(IChatController controller);

}
