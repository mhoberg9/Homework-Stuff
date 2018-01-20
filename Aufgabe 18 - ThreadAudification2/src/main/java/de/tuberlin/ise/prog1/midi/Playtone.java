package de.tuberlin.ise.prog1.midi;

import de.tuberlin.ise.prog1.midi.devices.MidiOutput;

/**
 * This class Playtone is used to start all Threads which play different tones.
 * It contains a constructor and a run method.
 * 
 * @author maltehoberg
 *
 */

public class Playtone extends Thread {

	public final MidiOutput midioutput;
	private MidiSoundEvent event;
	private long startTimestamp;

	/**
	 * Constructor for Thread Playtone
	 * 
	 * @param midioutput
	 * @param startTimestamp
	 * @param event
	 */

	public Playtone(MidiOutput midioutput, long startTimestamp, MidiSoundEvent event) {
		super();
		this.midioutput = midioutput;
		this.event = event;
		this.startTimestamp = startTimestamp;
	}

	/**
	 * The run method contains what the Threads should do. They start at the
	 * same time but sleep for a certain time till they reach their
	 * startTimestamp. All Threads will be interrupted as soon as all notes have
	 * played.
	 */

	public void run() {

		try {
			// Alle Threads starten gleich aber die Töne werden durch den
			// startTimestamp in einer bestimmten Reihenfolge abgespielt.
			// Außerdem werden alle Töen um 10000ms verzögert damit es zu keinen
			// Rucklern durch den negativen Wert kommt.
			Thread.currentThread();
			Thread.sleep(startTimestamp - System.currentTimeMillis() + 10000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Töne werden gestartet
		midioutput.startNote(event.channel, event.tone, event.volume);

		// Threads wird für event duration schlafen gelegt
		try {
			Thread.currentThread();
			Thread.sleep(event.durationInMs);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Der Tone wird gestoppt.
		midioutput.stopNote(event.channel, event.tone);

		// Thread wird unterbrochen
		Thread.currentThread().interrupt();
		// Ausgabe von Channel, Tone , Volume und dazugehörigem Time Stamp.
		
		System.out.println("Channel: " + event.channel + "\t" + "Tone: " + event.tone + "\t" + "Volume: " + event.volume
				+ "\t" + "Time Stamp: " + (startTimestamp-System.currentTimeMillis()));

	}
}
