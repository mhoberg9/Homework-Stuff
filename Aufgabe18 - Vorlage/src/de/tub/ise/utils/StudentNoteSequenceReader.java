package de.tub.ise.utils;

import de.tub.ise.midi.instruments.Instrument;
import de.tub.ise.midi.instruments.Instruments;
import de.tub.ise.midi.music.Chord;
import de.tub.ise.midi.music.MidiNoteSequenceBuilder;
import de.tub.ise.midi.music.NoteValue;

public class StudentNoteSequenceReader extends MidiNoteSequenceReader {
	
	@Override
	protected void readNoteAndAddToBuilder(String line, MidiNoteSequenceBuilder builder) throws MusicException {
		line = line.substring(2);
		
		String[] fields = line.split(";");
		if(fields.length == 2){
			String pitch = fields[0];
			NoteValue noteValue =NoteValue.valueOf(fields[1]);
			builder.appendNote(pitch, noteValue);
		} else if(fields.length == 3){
			String pitch = fields[0];
			NoteValue noteValue =NoteValue.valueOf(fields[1]);
			int noOfDots = Integer.parseInt(fields[2]);
			builder.appendNote(pitch, noteValue, noOfDots);
		} else {
			throw new MusicException("Note did not match format");
		}
	}

	@Override
	protected void readChordAndAddToBuilder(String line, MidiNoteSequenceBuilder builder) throws MusicException {
		line = line.substring(2);
		String[] fields = line.split(";");
		if(fields.length == 2){
			Chord chord = new Chord(fields[0]);
			try{
				double fractionOfAWholeNote = Double.parseDouble(fields[1]);	
				builder.appendChord(chord, fractionOfAWholeNote);
			} catch (NumberFormatException e) {
				NoteValue noteValue = NoteValue.valueOf(fields[1]);
				builder.appendChord(chord, noteValue);
			}
		} else {
			throw new MusicException("Chord did not match format");
		}
	}

	@Override
	protected MidiNoteSequenceBuilder readHeader(String header) 
			throws MusicException{
		
		if(!header.startsWith("!")){
			throw new IllegalArgumentException("Header Starts with wrong symbol");
		}
		String[] fields = header.substring(1).split(";");
		
		int volume 	= Integer.parseInt(fields[1]);
		
		if(volume < 0 || volume > 127){
			throw new IllegalArgumentException("volume not within [0,127]");
		}
		
		int channel = Integer.parseInt(fields[0]);
		
		if(channel < 0 || channel > 16){
			throw new IllegalArgumentException("channel not within [0,15]");
		}
		
		MidiNoteSequenceBuilder builder = 
				new MidiNoteSequenceBuilder(channel, volume);
		try {
			Instrument instrument = Instruments.parseInstrument(fields[2]);
			builder.setInstrument(instrument);
		} catch (ClassNotFoundException e) {
			builder.setInstrument(Instruments.MelodicDrums.Steel_Drums);
		}
		
		return builder;
	}
}
