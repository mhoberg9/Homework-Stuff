package de.tuberlin.snet.prog2.ue07.chinesecheckers.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MoveTurns {

	ArtificialPlayer player;

	public MoveTurns(ArtificialPlayer player) {
		this.player = player;
	}

	/**
	 * Returns a random move turn. First element of the list is the piece that
	 * should be moved, the second element is the target position.
	 * 
	 * @return list with piece and target position for a random move
	 */
	Turn getSimpleMoveTurn() {
		List<Position> myMove = new ArrayList<>();

		Collection<Piece> moveables = player.getPieces().stream()
				.filter(e -> (Board.getAllMoveTurns(player.state, new Position(e)).size() > 0))
				.collect(Collectors.toList());
		Position selectedPiece = new Position(ArtificialPlayer.getRandomElement(moveables));
		myMove.add(selectedPiece);

		Collection<Position> moves = Board.getAllMoveTurns(player.state, selectedPiece);
		Position toPos = moves.stream().skip((int) (moves.size() * Math.random())).findFirst().get();
		myMove.add(toPos);

		Piece temp = new Piece((player.getColor()));
		temp.position = selectedPiece;

		return new Turn(player, temp, toPos);
	}

	/**
	 * Returns the best move turn of all possible move turns.
	 * 
	 * @return move turn with the best progress
	 */
	Turn getBestMoveTurn() {

		Turn bestMove;
		Collection<Turn> allMoveTurns = getAllPossibleMoveTurns();

		bestMove = allMoveTurns.stream().sorted((t2, t1) -> Float.compare(t1.getRating(), t2.getRating())).findFirst()
				.get();

		return bestMove;
	}

	/**
	 * Searches and returns all possible move turns of this player.
	 * 
	 * @return collection of moves consisting of positions
	 */
	Collection<Turn> getAllPossibleMoveTurns() {

		Collection<Piece> moveables = player.getPieces().stream()
				.filter(e -> (Board.getAllMoveTurns(player.state, new Position(e)).size() > 0))
				.collect(Collectors.toList());

		

		Collection<Turn> allMoveTurns = new ArrayList<>();
		for (Piece piece : moveables) {
			for (Position movePosition : Board.getAllMoveTurns(player.state, new Position(piece))) {
				//List<Position> move = new ArrayList<>();
//				move.add(new Position(piece));
//				move.add(movePosition);
//				allMoveTurns.add(move);
				allMoveTurns.add(new Turn(player, piece, movePosition));
				
			}
		}

		return allMoveTurns;
	}
}
