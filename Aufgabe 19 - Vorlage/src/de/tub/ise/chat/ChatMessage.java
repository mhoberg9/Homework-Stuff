package de.tub.ise.chat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatMessage implements Comparable<ChatMessage>{
	String ip;
	final String user;
	final String body;
	final String command;
	Calendar arrivalTime;

    public ChatMessage(String user, String body) {
        this(null,user,body,null,null);
    }
    
    public ChatMessage(String user, String body,String command) {
        this(null,user,body,command);
    }
    public ChatMessage(String user, String body,String command,Calendar time) {
    	this(null,user,body,command,time);
    }

    public ChatMessage(String ip, String user, String body,String command){
    	this(ip,user,body,command,null);
    }
    
	public ChatMessage(String ip, String user, String body,String command,Calendar time) {
		if(user == null || user.isEmpty()) throw new IllegalArgumentException("user must be set");
		
		if(body == null && command == null) throw new IllegalArgumentException("body must contain a message or command");
		
		if(body != null || command != null){
			String content = ((body != null)?body:"")+((command != null)?command:"");
			if(content.isEmpty()){
				throw new IllegalArgumentException("body must contain a message or command");
			}
		}
		
		this.ip = ip;
		this.user = user;
		this.body = body;
		this.command = command;
		
		if(time == null){
			 time = Calendar.getInstance();
		}
		this.arrivalTime = time;
	}
	
	public void setTime(Calendar instance) {
		this.arrivalTime = instance;
		
	}
	public String getIp() {
		return ip;
	}

	public String getUser() {
		return user;
	}

	public String getBody() {
		return body;
	}

	public Calendar getArrivalTime() {
		return arrivalTime;
	}
	
	

	public String getCommand() {
		return command;
	}

	public static String serialize(ChatMessage message){
		return String.format("{\"user\"=\"%32s\",\"body\"=\"%256s\",\"command\"=\"%s\",\"time\"=\"%s\"}",
				cleanMessage(message.user),
				cleanMessage(message.body),
				cleanMessage(message.command),
				cleanMessage(serializeTime(message.arrivalTime)));
	}

	private static Pattern fieldSelector = Pattern.compile("\"([a-z]*)\"=\"(.*?)\"",Pattern.DOTALL|Pattern.MULTILINE|Pattern.CASE_INSENSITIVE);

	public static ChatMessage deserialize(String line){
		if(line == null) throw new IllegalArgumentException("line must have content!");
		line = line.trim();

		if(line.startsWith("{") && line.endsWith("}")){
            String user = null,body = null,command = null,time = null;
			line = line.substring(1,line.length()-1);
            Matcher matcher = fieldSelector.matcher(line);
            for (int i = 0; i < 4; i++) {
                if(matcher.find()){
                    switch (matcher.group(1)){
                        case "user":
                            user = matcher.group(2).trim();
                            break;
                        case "body":
                            body = matcher.group(2).trim();
                            break;
                        case "command":
                        	command = matcher.group(2).trim();
                        	break;
                        case "time":
                        	time  = matcher.group(2).trim();
                        	break;
                        default:
                            throw new IllegalArgumentException("unknown key "+matcher.group(1));
                    }
                } else {
                    throw new IllegalArgumentException("Exceeded a key");
                }
            }
            
            return new ChatMessage(user,body,command,deserializeTime(time));
        }
        throw new IllegalArgumentException("Message format wrong");
	}
	
	static SimpleDateFormat df = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss");
	
	//time to stirng ignoring timezones and stuff
	private static String serializeTime(Calendar time) {
		if(time != null){
			return df.format(time.getTime());
		} else {
			return "01.01.2017 00:00:00";
		}
	}

	//string to time ignoring timezones and stuff
	private static Calendar deserializeTime(String time) {
		if(time != null && !time.isEmpty()){
			Calendar date = Calendar.getInstance();
			try {
				date.setTime(df.parse(time));
			} catch (ParseException ignoreingThis) {}
			return date;
		}
		return null;
	}

	private static String cleanMessage(String line) {
		return line != null ? line.trim().replaceAll("\"","'"):"";
	}

	@Override
	public int compareTo(ChatMessage o) {
		return arrivalTime.compareTo(o.arrivalTime);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ChatMessage){
			ChatMessage msg = (ChatMessage) obj;
			if(!msg.body.equals(body)) return false;
			return msg.user.equals(user);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return user.hashCode()*31+body.hashCode();
	}

	public void setIP(String IP) {
		this.ip = IP;
	}

    @Override
    public String toString() {
        return '{' +
                "\"user\"=\"" + user + '"' +
                ",\"body\"=\"" + body + '"' +
                ",\"command\"=\""+ command + '"' +
                ",\"time\"=\""+ df.format(this.arrivalTime.getTime()) + '"'
                +'}';
    }

	
}
