package de.tub.ise.midi;

import de.tub.ise.midi.devices.MidiOutput;

/**
 * This class executes all started threads. It contains a constructor and a run
 * - method.
 * 
 * @author maltehoberg
 *
 */
public class PlaySoundThread extends Thread {

	/**
	 * Attributes
	 */

	public long startTimeStamp;
	public MidiSoundEvent event;
	public MidiOutput midioutput;
	final long s = System.currentTimeMillis();

	/**
	 * Constructor
	 * 
	 * @param startTimestamp
	 * @param event
	 * @param midioutput
	 */

	public PlaySoundThread(long startTimestamp, MidiSoundEvent event, MidiOutput midioutput) {
		this.startTimeStamp = startTimestamp;
		this.event = event;
		this.midioutput = midioutput;
	}

	/**
	 * Run-Method
	 */
	public void run() {

		try {
			Thread.currentThread();
			Thread.sleep(startTimeStamp - s);
			midioutput.startNote(event.channel, event.tone, event.volume);
			System.out.println("Play: " + "\t" + "Channel: " + event.channel + "\t" + "Volume: " + event.volume + "\t"
					+ "Tone: " + event.tone);
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
		try {
			Thread.currentThread();
			Thread.sleep(event.durationInMs);
			midioutput.stopNote(event.channel, event.tone);
			Thread.interrupted();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
