package Services;

import DAO.MoveDAO;
import Pokemon.Move;

import java.util.HashMap;

public class MoveService {
    private HashMap<String, Move> moveHashMap;
    private HashMap<Integer, Move> moveByIDHashMap;

    public MoveService(String fileName){
        this.moveHashMap = MoveDAO.moveInitialize(fileName);
        this.moveByIDHashMap = buildMoveByID();
    }

    public Move getMove(String move){
        return moveHashMap.get(move);
    }

    public Move getMove(int moveID) { return moveByIDHashMap.get(moveID);}

    // Helper method
    private HashMap<Integer, Move> buildMoveByID(){
        HashMap<Integer, Move> moveByIDHashMap = new HashMap<>();
        for (Move move :
                moveHashMap.values()) {
            moveByIDHashMap.put(move.getID(), move);
        }

        return moveByIDHashMap;
    }

}
