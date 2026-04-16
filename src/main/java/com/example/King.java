package com.example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
// pre: have class piece
// post: extends piece so that you can get the color and image of your specific piece
public class King extends Piece {


    public King(boolean isWhite, String img_file) {
        super(isWhite,img_file);

        
    }
    //overrides to String
    //pre:must have toString
    //post: returns color type of piece
public String toString1(){
    return "A color type of piece";
}  
   
     //delete  public String toString() {
      //  if (color)
     //       return "white";
     //   else
    //        return "black";
 //   }



    // TO BE IMPLEMENTED!
    // return a list of every square that is "controlled" by this piece. A square is
    // controlled
    // if the piece capture into it legally.
    // precondition: board and pieces are initialized
    // postconditon: returns array list of squares controlled by the bishop
    @Override
public String toString() {
    // TODO Auto-generated method stub
    return super.toString1();
}

    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        ArrayList<Square> controlled = new ArrayList<Square>();
        if ((((start.getCol() + 1) < 8) && ((start.getRow() + 1) < 8))) {
            controlled.add(board[start.getRow() + 1][start.getCol() + 1]);
        }
        if ((((start.getCol() + 1) < 8) && ((start.getRow() - 1) >= 0))) {
            controlled.add(board[start.getRow() - 1][start.getCol() + 1]);
        }
        if ((((start.getCol() - 1) >= 0) && ((start.getRow() + 1) < 8))) {
            controlled.add(board[start.getRow() - 1][start.getCol() + 1]);
        }
        if ((((start.getCol() - 1) >= 0) && ((start.getRow() - 1) >= 0))) {
            controlled.add(board[start.getRow() - 1][start.getCol() - 1]);
        }
        return controlled;
    }

    // TO BE IMPLEMENTED!
    // implement the move function here
    // it's up to you how the piece moves, but at the very least the rules should be
    // logical and it should never move off the board!
    // returns an arraylist of squares which are legal to move to
    // please note that your piece must have some sort of logic. Just being able to
    // move to every square on the board is not
    // going to score any points.
    // precondition: board and pieces are initialized
    // postcondition: retur
    public ArrayList<Square> getLegalMoves(Board b, Square start) {
        // the baord
        Square[][] board = b.getSquareArray();
        ArrayList<Square> moves = new ArrayList<Square>();
        if (((start.getCol() + 2) < 8) && ((start.getRow() + 1) < 8)) {
            if (b.getSquareArray()[start.getRow() + 1][start.getCol() + 1].getOccupyingPiece() == null
                    || b.getSquareArray()[start.getRow() + 1][start.getCol() + 1].getOccupyingPiece()
                            .getColor() != color) {
                moves.add(b.getSquareArray()[start.getRow() + 1][start.getCol() + 1]);
            }
        }
        if ((((start.getCol() + 1) < 8) && ((start.getRow() - 1) > 0))) {
            if (b.getSquareArray()[start.getRow() - 1][start.getCol() + 1].getOccupyingPiece() == null
                    || b.getSquareArray()[start.getRow() - 1][start.getCol() + 1].getOccupyingPiece()
                            .getColor() != color) {
                moves.add(b.getSquareArray()[start.getRow() - 1][start.getCol() + 1]);
            }
        }
        if ((((start.getCol() - 1) > 0) && ((start.getRow() + 1) < 8))) {
            if (b.getSquareArray()[start.getRow() + 1][start.getCol() - 1].getOccupyingPiece() == null
                    || b.getSquareArray()[start.getRow() + 1][start.getCol() - 1].getOccupyingPiece()
                            .getColor() != color) {
                moves.add(b.getSquareArray()[start.getRow() + 1][start.getCol() - 1]);
            }
        }
        if ((((start.getCol() - 1) > 0) && ((start.getRow() - 1) > 0))) {
            if (b.getSquareArray()[start.getRow() - 1][start.getCol() - 1].getOccupyingPiece() == null
                    || b.getSquareArray()[start.getRow() - 1][start.getCol() - 1].getOccupyingPiece()
                            .getColor() != color) {
                moves.add(b.getSquareArray()[start.getRow() - 1][start.getCol() - 1]);
            }
        }
        return moves;

        // we are at location board[start.getRow()][start.getCol()+1]

        // make four different loops one for each diagonal direction (so topleft,
        // topright, bottomleft, bottomright)
        // inside each try to go to the next square if it's in bounds >=0 <8, ask that
        // square are you occupied. s.isOccupied().
        // If it's not, you can go there. If it is ask is the enemy there?
        // s.getOccupyingPiece().getColor() != color then i can go there as well

    }
}