package de.tub.ise.utils;

import de.tub.ise.midi.io.FileReader;
import de.tub.ise.midi.io.FileUtil;
import de.tub.ise.midi.music.MidiMelody;
import de.tub.ise.midi.music.Tempo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This class is used to read and process the melody.info file.
 * @author maltehoberg
 *
 */

public class MidiMelodyReader {

	public MidiMelodyReader() {
	}

	/**
	 * This method is used to read a melody from a folder.</br>
	 * 
	 * A Melody folder must contain a melody.info file and one or more
	 * *.sequence files.</br>
	 * 
	 * For creating the MidiMelody and how the melody.info is formatted
	 * 
	 * @see {@link #readMelodyInfo(File)}.</br>
	 * 
	 *      All sequence files are processed using the @see
	 *      {@link MidiNoteSequenceReader} class.</br>
	 *
	 * @param folder
	 *            containing the melody
	 * @return a MidiMelody
	 * @throws IOException
	 *             errors that were due to file errors or missing files
	 * @throws MusicException
	 *             errors that are due to errors in file contents
	 */
	public MidiMelody readMelody(String folder) throws IOException, MusicException {

		if (!FileUtil.isFolder(folder)) {
			throw new IOException("The File object must point to a valid folder");
		}
		// try{
		MidiMelody melody = readMelodyInfo(folder);
		String[] list = FileUtil.listAllFilesInFolder(folder);
		StudentNoteSequenceReader reader = new StudentNoteSequenceReader();

		for (int i = 0; i < list.length; i++) {
			if (list[i].endsWith(".sequence")) {
				melody.add(reader.readFromFile(folder + "/" + list[i]));
			}
		}
		if (melody.getNumOfSequences() <= 0) {
			throw new MusicException("No sequences defined");
		}
		return melody;
		// } catch (Exception e){
		// e.printstacktrace;
		// }
	}

	/**
	 * This method is used to read and process melody.info files.</br>
	 * 
	 * A melody.info file contains key value pairs in the format:</br>
	 * - <code>key=value</code></br>
	 * 
	 * The following keys must be present:</br>
	 * - temp=Number</br>
	 * - tact=Number/Number</br>
	 * 
	 * 
	 * @param melodyFolder
	 *            a folder that should contain a melody.info file
	 * @throws IllegalArgumentException
	 *             if any of the requirements are not met.
	 */
	private MidiMelody readMelodyInfo(String melodyFolder) throws IOException {
		if (!FileUtil.isFolder(melodyFolder)) {
			throw new IOException("The File object must point to a valid folder");
		}
		// for (int i = 0; i <
		// FileUtil.listAllFilesInFolder(melodyFolder).length; i++) {
		// if
		// (FileUtil.listAllFilesInFolder(melodyFolder)[i].equals("melody.info"))
		// {
		// try{
		int dom = 0;
		int count = 0;
		Tempo temp = null;
		FileReader rr = new FileReader(new File(melodyFolder + "/" + "melody.info"));

		ArrayList<String> melodylist = rr.getLines();
		// int dom = 0;
		// int count = 0;
		// Tempo temp = null;

		for (String temporary : melodylist) {
			if (temporary.startsWith("tact")) {
				dom = Integer.parseInt(temporary.substring(5, 6));
				count = Integer.parseInt(temporary.substring(7, 8));
				// String[] h = helper.replace("tact=", "").split("/");
				// dom = Integer.parseInt(h[0]);
				// count = Integer.parseInt(h[1]);
			}
			if (temporary.startsWith("tempo")) {
				temp = new Tempo(Integer.parseInt(temporary.replace("tempo=", "")));
			}
			MidiMelody melody = new MidiMelody(temp, count, dom);
			return melody;
		}
		// }}
		// } catch (IllegalArgumentException e){
		// e.printStackTrace();
		// }
		throw new IllegalArgumentException("The File object must point to a File");

	}
}
