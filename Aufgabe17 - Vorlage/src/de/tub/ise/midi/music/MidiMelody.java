package de.tub.ise.midi.music;

import java.util.ArrayList;
import java.util.List;

public class MidiMelody {
	
	private Tempo tempo;
	private int counter;
	private int denominator;
	
	private List<MidiNoteSequence> seequences;
	
	public MidiMelody(Tempo tempo, int counter, int denominator) {
		super();
		this.tempo = tempo;
		this.counter = counter;
		this.denominator = denominator;
		this.seequences = new ArrayList<>();
	}

	public Tempo getTempo() {
		return tempo;
	}

	public void setTempo(Tempo tempo) {
		this.tempo = tempo;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public List<MidiNoteSequence> getSeequences() {
		return seequences;
	}

	public void add(MidiNoteSequence sequence){
		this.seequences.add(sequence);
	}

	public int getNumOfSequences() {
		return this.seequences.size();
	}

	@Override
	public String toString() {
		return "MidiMelody [tempo=" + tempo + ", counter=" + counter + ", denominator=" + denominator + ", seequences="
				+ seequences + "]";
	}
	
	
	
}
