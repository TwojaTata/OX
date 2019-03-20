import com.patryk.app.controllers.MainController;

/**
 * @author Patryk Kucharski
 */
public class Starter {
    public static void main(String[] args) {

        MainController mainController = new MainController();

        mainController.createMainLoop();

    }
}
