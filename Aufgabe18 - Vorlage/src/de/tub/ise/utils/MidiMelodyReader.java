package de.tub.ise.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import de.tub.ise.midi.io.FileUtil;
import de.tub.ise.midi.music.MidiMelody;
import de.tub.ise.midi.music.Tempo;

public class MidiMelodyReader {
	
	public MidiMelodyReader(){
		
	}
	
	/**
	 * This method is used to read a melody from a folder.</br>
	 * 
	 * A Melody folder must contain a melody.info file and one or more *.sequence files.</br>
	 * 
	 * For creating the MidiMelody and how the melody.info is formatted
	 * @see {@link #readMelodyInfo(File)}.</br>
	 * 
	 * All sequence files are processed using the @see {@link MidiNoteSequenceReader} class.</br>
	 * 
	 * 
	 * @param folder containing the melody
	 * @return a MidiMelody
	 * @throws IOException errors that were due to file errors or missing files
	 * @throws MusicException errors that are due to errors in file contents
	 */
	public MidiMelody readMelody(String folder) throws IOException, MusicException{
		
		
		if(!FileUtil.isFolder(folder)){
			throw new IOException("The File object must point to a valid folder");
		}
		
		MidiMelody melody = readMelodyInfo(folder);
		
		for(String sequneces : FileUtil.listAllFilesInFolder(folder)){
			if(sequneces.endsWith(".sequence")){
				MidiNoteSequenceReader reader = new StudentNoteSequenceReader();
				melody.add(reader.readFromFile(FileUtil.join(folder,sequneces)));
			}
		}
		
		if(melody.getNumOfSequences() <= 0){
			throw new MusicException("No sequences defined");
		}
		
		return melody;
	}

	/**
	 * This method is used to read and process melody.info files.</br>
	 * 
	 * A melody.info file contains key value pairs in the format:</br>
	 * - <code>key=value</code></br>
	 * 
	 * The following keys must be present:</br>
	 *  - temp=Number</br>
	 *  - tact=Number/Number</br>
	 * 
	 * 
	 * @param melodyFolder a folder that should contain a melody.info file
	 * @throws IllegalArgumentException if any of the requirements are not met.
	 */
	private MidiMelody readMelodyInfo(String melodyFolder) throws IOException  {
		ArrayList<String> lines;
		try{
			lines = FileUtil.readLines(melodyFolder,"melody.info");
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("melody.info file is missing in: "+melodyFolder);
		} catch (IOException e) {
			throw new IOException("could not read melody.info file");
		}
		
		int tempo = -1, counter = -1, denominator = -1;
		
		for(String line:lines){
			if(line.startsWith("tempo")){
				tempo = Integer.parseInt(line.substring("tempo=".length()));
			}
			if(line.startsWith("tact")){
				String tact = line.substring("tact=".length());
				String[] tactFraction = tact.split("/");
				counter = Integer.parseInt(tactFraction[0]);
				denominator = Integer.parseInt(tactFraction[1]);
			}
		}
		if(tempo < 0){
			throw new IllegalArgumentException("tempo wrongly not set to "+tempo);
		}
		
		if(counter < 0 || denominator < 0){
			throw new IllegalArgumentException("tact wrongly not set to "+counter+"/"+denominator);
		}
		
		return new MidiMelody(new Tempo(tempo), counter, denominator);
	}

	
}
