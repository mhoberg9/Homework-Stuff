package de.tub.ise.utils;

import de.tub.ise.midi.instruments.Instruments;
import de.tub.ise.midi.music.Chord;
import de.tub.ise.midi.music.MidiNoteSequenceBuilder;
import de.tub.ise.midi.music.NoteValue;

public class StudentNoteSequenceReader extends MidiNoteSequenceReader {
	
	/**
	 * This method is used to read notes and add them to a MidiNoteSeqeuenceBuilder.
	 */
	@Override
	protected void readNoteAndAddToBuilder(String line, MidiNoteSequenceBuilder builder) throws MusicException {
		try {
			if (line.startsWith("N")) {
				String[] line2 = line.split(";");
				// System.out.println(line2.length);
				// for (String i : line2){
				// System.out.println(i);
				// }
				
				if (line2.length == 3) {
					builder.appendNote(line2[1], NoteValue.valueOf(line2[2]));
				}

				if (line2.length == 4) {
					builder.appendNote(line2[1], NoteValue.valueOf(line2[2]), Integer.parseInt(line2[3]));
				}
			}
		} catch (UnsupportedOperationException e) {
			System.out.println("Wrong format");
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to read chords and add them to a MidiNoteSequenceBuilder.
	 */
	@Override
	protected void readChordAndAddToBuilder(String line, MidiNoteSequenceBuilder builder) throws MusicException {
		try {
			if (line.startsWith("C")) {
				String[] line2 = line.split(";");
				try {
					builder.appendChord(new Chord(line2[1]), NoteValue.valueOf(line2[2]));
				} catch (Exception e) {
					builder.appendChord(line2[1], Double.parseDouble(line2[2]));
				}
			}
		} catch (UnsupportedOperationException e) {
			System.out.println("Wrong format");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to read the header and add it to a MidiNoteSequenceBuilder.
	 */
	@Override
	protected MidiNoteSequenceBuilder readHeader(String header) throws MusicException {

		MidiNoteSequenceBuilder builder = null;

		if (header.startsWith("!")) {
			String[] header2 = header.split(";");
			builder = new MidiNoteSequenceBuilder(Integer.parseInt(header2[0].replace("!", "")),
					Integer.parseInt(header2[1]));
			try {
				builder.setInstrument(Instruments.parseInstrument(header2[2]));
			} catch (ClassNotFoundException e) {
				builder.setInstrument(Instruments.MelodicDrums.Steel_Drums);
				e.printStackTrace();
			}
		}
		return builder;
	}
}
