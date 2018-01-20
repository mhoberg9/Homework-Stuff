package de.tuberlin.snet.prog2.ue07.chinesecheckers.model;

import java.util.LinkedList;

/**
 * This class represents a turn.
 * @author Malte
 *
 */

public class Turn {

	ArtificialPlayer ap1;
	Piece piece;
	LinkedList<Piece> piecelist = new LinkedList<>();
	Position aimposi;
	float rating;

	/**
	 * First constructor
	 * @param ap1
	 * @param piece
	 */
	public Turn(ArtificialPlayer ap1, Piece piece) {
		this.ap1 = ap1;
		this.piece = piece;
	}

	/**
	 * Second constructor
	 * @param ap1
	 * @param piece
	 * @param aimposi
	 */
	public Turn(ArtificialPlayer ap1, Piece piece, Position aimposi) {
		this.ap1 = ap1;
		this.piece = piece;
		this.aimposi = aimposi;
	}

	/**
	 * This method is used to add Pieces to the list.
	 * @param piece
	 */
	public void AddjumpPiece(Piece piece) {
		piecelist.add(piece);
	}
	
	/**
	 * This method is used to get the rating for each possible jump.
	 * @param piece
	 * @param aimposi
	 * @return
	 */
	public float getBenefit (Piece piece, Position aimposi){
	
		return ap1.getTurnBenefit(piece.position, aimposi);
	}
	

	/**
	 * This method is used to clone a turn.
	 */
	@Override
	protected Turn clone (){
		Turn clone = new Turn (this.ap1, this.piece, this.aimposi);
		for (Piece helper : piecelist){
			clone.AddjumpPiece(helper);
		}
		return clone;
	}
	
	/**
	 * Getter & Setter
	 * @return
	 */
	public ArtificialPlayer getAp1() {
		return ap1;
	}

	public Piece getPiece() {
		return piece;
	}

	public LinkedList<Piece> getPiecelist() {
		return piecelist;
	}

	/**
	 * This method is used to calculate the target/aim-position
	 * @return
	 */
	public Position getAimposi() {
		if (!piecelist.isEmpty()) {
			return GameState.getLastPosition(piece, piecelist);
		} else {
			return piece.position;
		}
	}

	/**
	 * Setter
	 * @param aimposi
	 */
	public void setAimposi(Position aimposi) {
		this.aimposi = aimposi;
	}

	/**
	 * Getter
	 * @return
	 */
	public float getRating() {
		return rating;
	}
}
