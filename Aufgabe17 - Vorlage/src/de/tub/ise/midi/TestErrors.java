package de.tub.ise.midi;

import java.io.IOException;

import de.tub.ise.midi.music.MidiMelody;
import de.tub.ise.utils.MidiMelodyReader;
import de.tub.ise.utils.MusicException;

public class TestErrors {
	public static void main(String[] args) {
		MidiMelodyReader reader = new MidiMelodyReader();
		readAndPrint("songs/error",reader);
		readAndPrint("songs/error1",reader);
		readAndPrint("songs/error2",reader);
		readAndPrint("songs/error3",reader);
		
		
	}
	
	private static void readAndPrint(String folder, MidiMelodyReader reader){
		MidiMelody melody;
		try {
			System.out.println("reading "+folder);
			melody = reader.readMelody(folder);
			System.out.println(melody);
		} catch (IOException | MusicException e) {
			System.out.println("got checked exception:");
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.out.println("got runtime exception");
			e.printStackTrace();
		}
	}
}
