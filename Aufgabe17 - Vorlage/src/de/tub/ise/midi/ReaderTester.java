package de.tub.ise.midi;

import java.io.IOException;

import de.tub.ise.midi.music.MidiMelody;
import de.tub.ise.utils.MidiMelodyReader;
import de.tub.ise.utils.MusicException;

public class ReaderTester {
	public static void main(String[] args) {
		MidiMelodyReader reader = new MidiMelodyReader();
		MidiMelody melody;
		
		try {
			melody = reader.readMelody("songs/test");
			System.out.println(melody);
		} catch (IOException | MusicException e) {
			e.printStackTrace();
		}	
	}
}
