/**
 * 
 */
package de.tub.ise.midi;

import de.tub.ise.midi.devices.MidiOutput;
import de.tub.ise.midi.instruments.Instrument;

/**
 * @author Dave
 *
 */
public abstract class MidiScheduler {

	/** output device that is used */
	 final MidiOutput midioutput;

	/**
	 * @param midioutput
	 */
	public MidiScheduler(MidiOutput midioutput) {
		super();
		this.midioutput = midioutput;
	}

	/**
	 * terminates playback
	 */
	public void terminate() {
		unschedule(System.currentTimeMillis());
		stop();
		getMidioutput().terminate();
	}

	protected abstract void stop();

	/**
	 * plays the specified note
	 * 
	 * @param startTimestamp
	 *            when to play the note
	 * @param note
	 *            will be played
	 * 
	 */
	protected abstract void scheduleTone(long startTimestamp, MidiSoundEvent event);

	/**
	 * changes the sound of the specified channel to the specified instrument
	 * 
	 * @param instrument
	 * @param channel
	 */
	public void changeInstrument(Instrument instrument, int channel) {
		getMidioutput().setInstrument(channel, instrument);
	}

	protected abstract void unschedule(long after);

	public MidiOutput getMidioutput() {
		return midioutput;
	}

	
}
