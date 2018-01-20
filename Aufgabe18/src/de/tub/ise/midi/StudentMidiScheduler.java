package de.tub.ise.midi;

import java.util.ArrayList;

import de.tub.ise.midi.devices.MidiOutput;

public class StudentMidiScheduler extends MidiScheduler {

	long s = 0;

	public StudentMidiScheduler(MidiOutput midioutput) {

		super(midioutput);

	}

	/**
	 * cleanup, stop all threads if any where used delete all pending events
	 */
	@Override
	protected void stop() {
		for (Note note : schedule) {
			note.getThread().interrupt();
		}

	}

	/**
	 * plays the specified note
	 * 
	 * @param startTimestamp
	 *            when to play the note
	 * @param note
	 *            will be played
	 * 
	 */
	ArrayList<Note> schedule = new ArrayList<Note>();

	@Override
	protected void scheduleTone(long startTimestamp, MidiSoundEvent event) {

		Thread t = new Thread() {
			public void run() {

				try {
					this.sleep(startTimestamp - System.currentTimeMillis() + 100);
					midioutput.startNote(event.channel, event.tone, event.volume);

					this.sleep(event.durationInMs);
					midioutput.stopNote(event.channel, event.tone);
					this.interrupt();

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		};
		schedule.add(new Note(startTimestamp, event, t));
		t.start();
		
		for (Note n : schedule){
			System.out.println(n.getStamp() - System.currentTimeMillis());
		}

		// this should propb. happen in differnt threads
		// shedule to wait until startTime
		// midioutput.startNote(event.channel, event.tone,event.volume);
		//
		// shedule to wait until startTime+event.durationInMs
		// midioutput.stopNote(event.channel, event.tone);

	}

	@Override
	protected void unschedule(long after) {
		for (Note note : schedule) {
			if (note.getStamp() > after) {
				note.getThread().interrupt();
				schedule.remove(note);
			}
		}
	}

}
