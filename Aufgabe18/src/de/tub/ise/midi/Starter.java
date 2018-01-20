package de.tub.ise.midi;

public class Starter {
	public static void main(String[] args) {
		try {
			MidiPlayer.play("songs/basic");
		} catch (Exception e) {}
	}
}
