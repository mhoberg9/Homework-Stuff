package de.tuberlin.snet.prog2.ue06.streams;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class StreamArrayList<T> extends ArrayList<T> {

	/**
	 * This class represents a StreamArrayList with certain functions.
	 * @author Malte
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an empty list with an initial capacity of ten (check
	 * constructor of super class)
	 */
	public StreamArrayList() {
		super();
	}

	/**
	 * Constructs a list containing the elements of the specified dataset
	 *
	 * @param dataset
	 *            which elements are placed into this list
	 * @throws NullPointerException
	 *             if the specified collection is null
	 */
	public StreamArrayList(ArrayList<T> dataset) {
		super(dataset);
	}

	/**
	 * filters the StreamArrayList according to the Predicate
	 * 
	 * @param functional
	 *            interface: predicate
	 * @return new StreamArrayList after filtering
	 */
	public StreamArrayList<T> filter(Predicate<T> p) {
		StreamArrayList<T> list = new StreamArrayList<>();
		for (T helper : this) {
			if (p.test(helper)) {
				list.add(helper);
			}
		}
		return list;
	}

	/**
	 * maps each single element of the StreamArrayList to a double.
	 * StreamArrayList
	 * 
	 * @param dFunct
	 *            functional interface: function
	 * @return new StreamArrayList after mapping
	 */
	public StreamArrayList<Double> mapToDouble(ToDoubleFunction<T> dFunct) {
		/**
		 * TODO
		 */
		StreamArrayList<Double> dlist = new StreamArrayList<>();
		for (T helper : this) {
			dlist.add(dFunct.applyAsDouble(helper));
		}
		return dlist;
	}

	/**
	 * reduces the StremArrayList according to the BinaryOperator bo
	 * 
	 * @param bo
	 *            functional interface: BinaryOperator
	 * @return Optional: null or value with datatype T
	 */
	public Optional<T> reduce(BinaryOperator<T> bo) {

		boolean foundAny = false;
		T result = null;

		for (T helper : this) {
			if (!foundAny) {
				foundAny = true;
				result = helper;
			} else {
				result = bo.apply(result, helper);
			}
		}

		return foundAny ? Optional.of(result) : Optional.empty();
	}

	/**
	 * limits the StreamArrayList
	 * 
	 * @param max
	 * @return shortened StreamArrayList
	 */
	public StreamArrayList<T> limit(long max) {

		StreamArrayList<T> llist = new StreamArrayList<>();

		for (int i = 0; i <= max; i++) {
			llist.add(this.get(i));
		}
		return llist;
	}

	/**
	 * counts the StreamArrayList
	 * 
	 * @return long counter
	 */
	public long count() {

		long count = 0;
		for (@SuppressWarnings("unused") T helper : this) {
			count++;
		}
		return count;
	}

}
