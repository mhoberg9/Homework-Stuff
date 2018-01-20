/**
 * 
 */
package de.tuberlin.ise.prog1.midi.music;

/**
 * @author Dave
 *
 */
public enum TonePitch {

	C, Db, D, Eb, E, F, Gb, G, Ab, A, Bb, B;

	/**
	 * 
	 * @return the midi number for this {@link TonePitch} in the default octave (60
	 *         for C).
	 */
	public int value() {
		return this.ordinal() + 60;
	}

	
}
