package de.tub.ise.chat.client;

import de.tub.ise.chat.ChatMessage;

public class ChatClientUtil {
	
	//Default User
    private static String username = "Rick";
    //ISE Server : "54.93.201.222"
    private static String ip = "35.156.99.12";

    public static void setIp(String ip) {
        ChatClientUtil.ip = ip;
    }

    public static void setUsername(String name){
        ChatClientUtil.username = name;
    }
    
	public static String getUsername() {
		return username;
	}

    /**
     * creates a new instance of the ChatInterface class with your custom parameter.
     */
    public static ChatInterface build(){
        return new StudentChatClient(username,ip,8080);
    }

    /**
     * This message turns a ChatMessage into a Printable Sting that is used to display the content of this message on a user interface.
     * @param message
     */
    public static String formatMessage(ChatMessage message) {

        if(username.equalsIgnoreCase(message.getUser())){
            return String.format("you: %s %n",message.getBody());
        } else {
            return String.format("[%s] %s %n",message.getUser(),message.getBody());
        }

    }


    /**
     * used to check if config dialog options should be displayed at the start
     * @return
     */
    public static boolean doConfig() {
        return true;
    }

}
