import model.Model;
import view.View;
import controller.Controller;

public class Main {
    // 63050103 แก้วเพชร หนูร่วง
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        new Controller(model, view);

        view.display();
    }
}
