package de.tuberlin.snet.prog2.ue07.chinesecheckers.model;

import java.util.Collection;
import java.util.LinkedList;
import de.tuberlin.snet.prog2.ue07.chinesecheckers.controller.Main;

/**
 * This class represents a JumpTurnsWorkerThread.
 * It contains a constructor, run-method and searchforjumpturn-method.
 * @author Malte
 *
 */
public class JumpTurnsWorker extends Thread {

	private LinkedList<Turn> incompleteJumps;
	private LinkedList<Turn> jumpTurns;

	/**
	 * Constructor
	 * @param incompleteJumps
	 * @param jumpTurns
	 */
	public JumpTurnsWorker(LinkedList<Turn> incompleteJumps, LinkedList<Turn> jumpTurns) {
		this.incompleteJumps = incompleteJumps;
		this.jumpTurns = jumpTurns;
		
	}

	/**
	 * Run-Method.
	 * Takes incomplete jumps out of the list and searches for the best possible.
	 */
	@Override
	public void run() {
		try {
			Turn currentTurn = null;
			while (!isInterrupted()) {
				//synchronized (incompleteJumps) {
					currentTurn = incompleteJumps.poll();
					System.out.println("entnommen");
					// finish, if there are no incomplete jumps
					if (currentTurn == null) {
						System.out.println("null");
						return;
					}
					Collection<Turn> foundJumpTurns = searchForJumpTurns(currentTurn);
					jumpTurns.addAll(foundJumpTurns);
					incompleteJumps.addAll(foundJumpTurns);
					System.out.println("added");
				//}
			}
		} catch (InterruptedException e) {
			Thread.interrupted();
			e.printStackTrace();
		}
	}

	/**
	 * Searches for possible JumpTurns.
	 * @param currentTurn
	 * @return
	 * @throws InterruptedException
	 */
	private Collection<Turn> searchForJumpTurns(Turn currentTurn) throws InterruptedException {
		Collection<Turn> foundJumpTurns = new LinkedList<Turn>();
		Position initialJumpPosition;
		// check, if this is the first jump of this turn
		if (currentTurn.getPiecelist().isEmpty())
			initialJumpPosition = new Position(currentTurn.getPiece());
		else
			initialJumpPosition = GameState.getLastPosition(currentTurn.getPiece(), currentTurn.getPiecelist());

		for (Piece obstacle : Board.getAllPossibleJumpTurns(Main.state, initialJumpPosition)) {
			// only add new obstacles, to avoid forward and backward
			// jumps (although it can be jumped over in another
			// direction)
			if (currentTurn.getPiecelist().contains(obstacle))
				continue;
			Turn foundJumpTurn = currentTurn.clone();
			foundJumpTurn.AddjumpPiece(obstacle);
			foundJumpTurns.add(foundJumpTurn);
		}
		return foundJumpTurns;
	}
}
