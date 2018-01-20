package de.tub.ise.midi;

public class Note {
private long stamp;
private MidiSoundEvent event;
private Thread thread;

public Note (long stamp, MidiSoundEvent event,Thread thread){
	this.stamp = stamp;
	this.event = event;
	
}
public Thread getThread(){
	return thread;
}
public long getStamp() {
	return stamp;
}

public MidiSoundEvent getEvent() {
	return event;
}
}
