import com.patryk.app.Board;
import com.patryk.app.Marker;

import java.util.Arrays;

/**
 * @author Patryk Kucharski
 */
public class Starter {
    public static void main(String[] args) {
        Board board = new Board(10, 10,3);
        board.fillBoardWithBlanks();
        board.putMarker(5,5, Marker.CROSS);
        board.displayBoard();
    }
}
