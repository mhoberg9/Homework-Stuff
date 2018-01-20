package de.tub.ise.midi;

import de.tub.ise.midi.devices.MidiOutput;
import java.util.ArrayList;

/**
 * This class is used to schedule, unschedule and stop all threads.
 * @author maltehoberg
 *
 */

public class StudentMidiScheduler extends MidiScheduler {
	ArrayList<ScheduleThread> list = new ArrayList<>();
	ArrayList<ScheduleThread> terminatelist = new ArrayList<>();

	public StudentMidiScheduler(MidiOutput midioutput) {
		super(midioutput);
	}

	/**
	 * cleanup, stop all threads if any where used delete all pending events
	 */

	@Override
	protected void stop() {

		//if (list.size() == 7538) {
			for (ScheduleThread i : list) {
				i.getThread().interrupt();
				System.out.println("Stop: " + i.getThread().getName() + "\t" + "Channel: " + i.getEvent().channel + "\t"
						+ "Volume: " + i.getEvent().volume + "\t" + "Tone: " + i.getEvent().tone);
			}
			midioutput.terminate();
		}
	//}

	/**
	 * plays the specified note
	 * 
	 * @param startTimestamp
	 *            when to play the note
	 * @param note
	 *            will be played
	 * 
	 */
	@Override
	protected void scheduleTone(long startTimestamp, MidiSoundEvent event) {

		PlaySoundThread t = new PlaySoundThread(startTimestamp, event, midioutput);
		list.add(new ScheduleThread(startTimestamp, event, t));
		if (list.size() == 306) {
			list.sort(new ComparatorThreads());
			// unschedule(10000);
			for (ScheduleThread i : list) {
				System.out.println("Start: " + i.getThread().getName() + "\t" + "Channel: " + i.getEvent().channel
						+ "\t" + "Volume: " + i.getEvent().volume + "\t" + "Tone: " + i.getEvent().tone);
				i.getThread().start();
			}
		}

	}
	
	/**
	 * Unschedule all threads after the System.currentTimeMillis();
	 * 
	 */

	@Override
	protected void unschedule(long after) {

		for (ScheduleThread check : list) {
			if ((check.getStartTimestamp() - System.currentTimeMillis()) < after) {
				terminatelist.add(check);
				System.out.println("Unschedule: " + check.getThread().getName() + "\t" + "Channel: "
						+ check.getEvent().channel + "\t" + "Volume: " + check.getEvent().volume + "\t" + "Tone: "
						+ check.getEvent().tone);
			}
		}
		list = terminatelist;
	}

}
