package de.tub.ise.midi;

public class Starter {
	public static void main(String[] args) {
		try {
			MidiPlayer.play("songs/complex");
		} catch (Exception e) {}
	}
}
