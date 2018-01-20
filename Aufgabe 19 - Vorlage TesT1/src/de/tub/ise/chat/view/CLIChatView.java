package de.tub.ise.chat.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Prog1Tools.IOTools;
import de.tub.ise.chat.ChatMessage;
import de.tub.ise.chat.client.ChatClientUtil;
import de.tub.ise.chat.client.ChatInterface;
import de.tub.ise.chat.client.IChatController;

public class CLIChatView implements IChatController {

	
	
	public static void launch(String... args) {
		CLIChatView view = new CLIChatView();
		view.start();
	}

	final int MESSAGE_VIEW_SIZE = 30;
	
	ChatInterface client;
	private PriorityQueue<ChatMessage> messages;

	private String state;
	
	
	@SuppressWarnings("serial")
	public CLIChatView(){
		messages = new PriorityQueue<ChatMessage>(){
			@Override
			public boolean add(ChatMessage e) {
				boolean success = super.add(e);
				onChanged(e);
				return success;
			}
		};
	}
	
	private void start() {
		if(ChatClientUtil.doConfig()){
			String username = IOTools.readLine("Whats your username?:");
			String ip		= IOTools.readLine("What is the IP of the ChatServer?");
			ChatClientUtil.setUsername(username);
			ChatClientUtil.setIp(ip);
		}
		client = ChatClientUtil.build();
		client.registerController(this);
		client.registerMessageQueue(messages);
		

		
		try {
			client.connect();
			render();
		} catch (Exception e) {
			renderError(e);
		}
	}
	
	

	private void renderError(Exception e) {
		System.err.printf("ERROR:%s%n",e);
		e.printStackTrace();
	}
	
	
	
	private void render(){
		//clear screen
		PrintStream out = System.out;
		
		clearScreen(out);
		
		renderMessages(out);
		
		renderInput(out);
	}

	private void clearScreen(PrintStream out) {
		final String operatingSystem = System.getProperty("os.name");
		try {
			if (operatingSystem .contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
			    Runtime.getRuntime().exec("clear");
			}
		} catch (IOException e) {}
		
		out.flush();
	}

	private void renderMessages(PrintStream out) {
		StringBuilder messgeView = new StringBuilder();
		ArrayList<ChatMessage> msg = new ArrayList<>(messages);
		
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.YYYY HH:mm");
		
		messgeView
		.append(String.format("[%s] - %s \t\t\t\t - %s] %n","Messages",state,df.format(new Date())));
		
		renderLine(messgeView);
		//append spaces
		if(msg.size() < MESSAGE_VIEW_SIZE){
			for (int i = 0; i < MESSAGE_VIEW_SIZE-msg.size(); i++) {
				messgeView.append('\n');
			}
		}
		
		for (Iterator<ChatMessage> ittr = msg.listIterator(Math.max(0, msg.size()-MESSAGE_VIEW_SIZE));ittr.hasNext();) {
			ChatMessage mg = ittr.next();
			messgeView.append(ChatClientUtil.formatMessage(mg)).append("\n");
		}
		renderLine(messgeView);
		out.println(messgeView.toString());
	}

	ExecutorService runner = Executors.newFixedThreadPool(2);
	Future<String> input;
	private void renderInput(PrintStream out) {
		out.print(ChatClientUtil.getUsername()+"#");
		input = runner.submit(new ConsolReader());
		runner.submit(new InputResonder());
	}

	private void renderLine(StringBuilder messgeView) {
		for (int i = 0; i < 80; i++) {
			messgeView.append('-');
		}
		messgeView.append('\n');
	}

	@Override
	public void onConnected() {
		state = "connected";
		rerender();
	}

	@Override
	public void onDisconnected() {
		state = "disconnected";
		rerender();
	}

	public void onChanged(ChatMessage change) {
		rerender();
	}

	private void rerender() {
		if(input != null){
			input.cancel(true);
		}
		render();
	}
	
	public class InputResonder implements Runnable{
		
		public void run(){
			try {
				String s = input.get();
				if(s == null) return;
				if(s.startsWith("/")){
					parseCommand(s);
				} else {
					if(!s.trim().isEmpty()){
						client.onSend(s);
						input.cancel(true);
					}
				}
			} catch(Exception e){
				
			}
		}

		private void parseCommand(String s) {
			String command = s.substring(1);
			switch (command) {
			case "reload":
				client.onGetHistory();
				break;
			case "quit":
				System.exit(0);
				break;

			}
			
		}
		
	}

	public class ConsolReader implements Callable<String>{
		boolean isAlive = true;
		@Override
		public String call() throws Exception {
			BufferedReader br = new BufferedReader(
			        new InputStreamReader(System.in));
			    String input;
			    do {
			      try {
			        // wait until we have data to complete a readLine()
			        while (!br.ready()  && isAlive) {
			          Thread.sleep(50);
			        }
			        input = br.readLine();
			        return input;
			      } catch (InterruptedException e) {
			        return null;
			      }
			    } while (!Thread.currentThread().isInterrupted());
		}
	}
}
