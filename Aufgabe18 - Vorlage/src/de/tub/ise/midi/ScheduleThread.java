package de.tub.ise.midi;

/**
 * This class defines a thread and all its information.
 * @author maltehoberg
 *
 */


public class ScheduleThread {

	
	/**
	 * Attributes
	 */
	
	private long startTimestamp;
	private MidiSoundEvent event;
	private Thread thread;
	
	/**
	 * Constructor
	 * @param startTimestamp
	 * @param event
	 * @param thread
	 */
	
	public ScheduleThread(long startTimestamp, MidiSoundEvent event, Thread thread){
		this.startTimestamp = startTimestamp;
		this.event = event;
		this.thread = thread;
		
		
	}

	/**
	 * Getters
	 * @return
	 */
	public long getStartTimestamp() {
		return startTimestamp;
	}



	public MidiSoundEvent getEvent() {
		return event;
	}



	public Thread getThread() {
		return thread;
	}

}