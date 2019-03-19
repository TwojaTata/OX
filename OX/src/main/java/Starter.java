import com.patryk.app.controllers.MainController;
import com.patryk.app.models.Board;
import com.patryk.app.services.BoardService;
import com.patryk.app.services.SettingsService;

/**
 * @author Patryk Kucharski
 */
public class Starter {
    public static void main(String[] args) {
//        Board board = new Board(10, 10,3);
//        SettingsService settingsService = new SettingsService();
//        int a = settingsService.getDimensionFromUser("rows");
//        System.out.println(a);
//        BoardService boardService = new BoardService();
//        boardService.displayPlayersInfo();
//        board.fillBoardWithBlanks();
//        board.putMarker(5,5, Marker.CROSS);
//        board.displayBoard();

        MainController mainController = new MainController();
        mainController.setUpGame();




    }
}
