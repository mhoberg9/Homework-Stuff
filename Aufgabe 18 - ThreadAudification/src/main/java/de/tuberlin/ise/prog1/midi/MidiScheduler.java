/**
 * 
 */
package de.tuberlin.ise.prog1.midi;

import de.tuberlin.ise.prog1.midi.devices.MidiOutput;
import de.tuberlin.ise.prog1.midi.instruments.Instrument;

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
		// ...
		midioutput.terminate();
	}

	/**
	 * plays the specified note
	 * 
	 * @param startTimestamp
	 *            when to play the note
	 * @param note
	 *            will be played
	 * 
	 */
	public void play(long startTimestamp, MidiSoundEvent event) {
		// ...
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
