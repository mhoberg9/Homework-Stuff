package de.tub.ise.utils;

import java.io.IOException;
import java.util.Iterator;

import de.tub.ise.midi.instruments.Instruments;
import de.tub.ise.midi.io.FileReader;
import de.tub.ise.midi.io.FileUtil;
import de.tub.ise.midi.music.Chord;
import de.tub.ise.midi.music.MidiNoteSequence;
import de.tub.ise.midi.music.MidiNoteSequenceBuilder;
import de.tub.ise.midi.music.NoteValue;

public abstract class MidiNoteSequenceReader  {
	
	/**
	 * reads a given .sequence file and tries to convert it to a MidiNoteSequence</br>
	 * 
	 * @param filename of the file to be read
	 * @return a MidiNoteSequence
	 * @throws IOException if any errors occur during file operations
	 * @throws MusicException if the file contains misinformed midi commands
	 * @throws IllegalArgumentException if any part of the file or files contents 
	 * do not match expectations
	 */
	public MidiNoteSequence readFromFile(String filename) 
			throws IOException, MusicException{
		
		FileReader reader;
		try{
			reader = FileUtil.getReader(filename);
		} catch (IOException e) {
			throw new IOException("could not read "+filename,e);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(filename+" is missing or could not be opened",e);
		}
		
		//read the header of the file
		MidiNoteSequenceBuilder builder = readHeader(reader.getLine(0));
		
		//read all other commands but the header
		for (Iterator<String> iterator = reader.iterator(1); iterator.hasNext();) {
			readAndAddToBuilder(iterator.next(),builder);
		}
		
		return builder.build();

	}
	
	/**
	 * helper method that checks if a note or chord needs to be processed next</br>
	 * @param line
	 * @param builder
	 * @throws MusicException
	 */
	private void readAndAddToBuilder(String line, MidiNoteSequenceBuilder builder) throws MusicException {
		if(line.startsWith("C")){
			readChordAndAddToBuilder(line,builder);
		} else if(line.startsWith("N")){
			readNoteAndAddToBuilder(line,builder);
		} else {
			throw new IllegalArgumentException("A line must be Note or Cord to be added to the sequence");
		}
	}

	/**
	 * Reads a Note from the provided line and adds it to the builder.</br>
	 * 
	 * A note line must have one of the following formats:</br>
	 *  1. <code>N;String;String</code></br>
	 *  2. <code>N;String;String;Number</code></br>
	 *  </br>
	 *  The N; must always be present,</br>
	 *  the first String contains the actual note e.g. C#5,</br>
	 *  the second String always contains a NoteValue String @see {@link NoteValue}.</br>
	 *  the Number after the NoteValue is optional and denotes the the number of dots behind the note value.</br>
	 * 
	 * Also have a look at {@link MidiNoteSequenceBuilder#appendNote(String, NoteValue)} ,
	 * {@link MidiNoteSequenceBuilder#appendNote(String, NoteValue, int)}</br>
	 * 
	 * To convert a String to a NoteValue the {@link NoteValue#valueOf(String)} function can be used.</br>
	 * 
	 * @param line a NoteSequenceline
	 * @param builder
	 * @throws MusicException
	 */
	protected abstract void readNoteAndAddToBuilder(String line, MidiNoteSequenceBuilder builder) throws MusicException;

	/**
	 * Reads a Chord from the provided line and adds it to the builder.</br>
	 * 
	 * A Chord line must have one of the following formats:</br>
	 * 	1. <code>C;String;String</code></br>
	 *  2. <code>C;String;Number</code></br>
	 *  
	 * The C; must always be present, the first String always
	 * contains one ore more Notes that make up a Chord @see {@link Chord#Chord(String)}.</br>
	 * 
	 * The second String of the 1. format contains a NoteValue String  @see {@link NoteValue}.
	 * The number of the 2. format contains a value denoting the length of the tone
	 * as a fraction of a whole (@see Double).</br>
	 * 
	 * Also have a look at {@link MidiNoteSequenceBuilder#appendChord(Chord, NoteValue)} and
	 * {@link MidiNoteSequenceBuilder#appendChord(String, double)}.</br>
	 * 
	 * 
	 * 
	 * @param line
	 * @param builder
	 * @throws MusicException
	 */
	protected abstract void readChordAndAddToBuilder(String line, MidiNoteSequenceBuilder builder) throws MusicException;

	/**
	 * This method reads the header of the provided file (the first line of the 
	 * .sequence file) and creates a MidiNoteSequenceBuilder from it.</br>
	 * 
	 * This line must meet the following format:</br>
	 *  <code>!Number;Number;String</code></br>
	 * 
	 * The first number of the header line contains the Channel ID, the second the volume.</br>
	 * The String of the header line represents the Instrument. @see {@link Instruments}.</br>
	 * 
	 * The Instrument String can be processed using the 
	 * {@link Instruments#parseInstrument(String)} Methode. </br>
	 * 
	 * This method throws a MusicException if volume or channel do not meet the following requirements:</br>
	 *  - chanel and volume must be positive</br>
	 *  - volume can only be in the interval of [0,127]</br>
	 *  - channel can only be between 0 and 15</br>
	 *  
	 * This method should use the {@link Instruments.Guitars#Acoustic_Guitar_nylon, 
	 * if the Instrument can not be parsed corrently.</br>
	 * 
	 * 
	 * @param string the first line of the .sequence file
	 * @return
	 * @throws MusicException
	 */
	protected abstract MidiNoteSequenceBuilder readHeader(String string) throws MusicException;
	
	
	
}
