/**
 * 
 */
package de.tuberlin.ise.prog1.midi;

import java.util.ArrayList;
import java.util.Collections;

import de.tuberlin.*;
import de.tuberlin.ise.prog1.midi.devices.MidiOutput;
import de.tuberlin.ise.prog1.midi.instruments.Instrument;
import de.tuberlin.ise.prog1.midi.music.Chord;

/**
 * @author Dave
 *
 */
public class MidiScheduler {

	/** output device that is used */
	private final MidiOutput midioutput;

	/**
	 * @param midioutput
	 */
	public MidiScheduler(MidiOutput midioutput) {
		super();
		this.midioutput = midioutput;
		// ...
	}

	/**
	 * terminates playback
	 */
	public void terminate() {

		midioutput.terminate();

	}

	/**
	 * plays the specified note
	 * 
	 * @param startTimestamp
	 *            when to play the note
	 * @param note
	 *            will be played
	 * @throws InterruptedException
	 * @author maltehoberg
	 */

	public void play(long startTimestamp, MidiSoundEvent event) throws InterruptedException {
		// Neuer Thread wird erstellt
		Playtone t = new Playtone(midioutput, startTimestamp, event);
		// Thread wird gestartet
		t.start();

	}

	/**
	 * changes the sound of the specified channel to the specified instrument
	 * 
	 * @param instrument
	 * @param channel
	 */
	public void changeInstrument(Instrument instrument, int channel) {
		midioutput.setInstrument(channel, instrument);
	}

}
