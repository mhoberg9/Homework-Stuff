package de.tuberlin.snet.prog2.ue07.chinesecheckers.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class JumpTurns {

	ArtificialPlayer player;

	public JumpTurns(ArtificialPlayer player) {
		this.player = player;
	}

	/**
	 * Returns the best move turn of all possible move turns.
	 * 
	 * @return move turn with the best progress
	 */
	Turn getBestJumpTurn() {
		Collection<Turn> allJumpTurns = getAllPossibleJumpTurns();

		Turn bestJump = allJumpTurns.stream()
				.sorted((t2, t1) -> Float.compare(player.getTurnBenefit(new Position(t1.getPiece()), t1.getAimposi()),
						player.getTurnBenefit(new Position(t2.getPiece()), t2.getAimposi())))
				.findFirst().get();

		return bestJump;
	}

	/**
	 * Searches and returns all possible jump turns of this player.
	 * 
	 * @return collection of jump consisting of positions
	 */
	Collection<Turn> getAllPossibleJumpTurns() {
		Collection<Piece> jumpables = player.getPieces().stream()
				.filter(e -> (Board.getAllPossibleJumpTurns(player.state, new Position(e)).size() > 0))
				.collect(Collectors.toList());

		LinkedList<Turn> incompleteJumps = new LinkedList<>();
		LinkedList<Turn> jumpTurns = new LinkedList<>();

		try {
			for (Piece jumpable : jumpables) {
				incompleteJumps.add(new Turn(player, jumpable));
			}
			for (int i = 0; i < 30; i++) {
				JumpTurnsWorker jumpTurnsWorker = new JumpTurnsWorker(incompleteJumps, jumpTurns);
				jumpTurnsWorker.start();
				jumpTurnsWorker.join();
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(jumpTurns);
		return jumpTurns;
	}
}
