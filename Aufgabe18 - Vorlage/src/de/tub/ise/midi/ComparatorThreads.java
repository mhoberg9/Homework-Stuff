package de.tub.ise.midi;

import java.util.Comparator;

public class ComparatorThreads implements Comparator <ScheduleThread> {

	@Override
	public int compare(ScheduleThread o1, ScheduleThread o2) {
		// TODO Auto-generated method stub
		return Long.compare(o1.getStartTimestamp(),o2.getStartTimestamp());
	}

}
