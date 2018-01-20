package de.tub.ise.chat.client;

public abstract class ChatClient implements ChatInterface{
    protected final String host;
    protected final int port;
    protected final String username ;
    protected IChatController controller;

    protected boolean isConnected = false;

    public ChatClient(String username,String host,int port)  {
        this.username = username;
        this.host = host;
        this.port = port;
    }


    @Override
    public void registerController(IChatController controller) {
        this.controller = controller;
    }

    protected void notifyDisconnect() {
        isConnected = false;
        if (controller != null) {
        	controller.onDisconnected();
        }
    }

    protected void notifyConnect() {
        isConnected = true;
        if (controller != null) {
        	controller.onConnected();
        }
    }
    
    public void onGetHistory(){
    	//do nothing
    }
}
