import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Snake"); // заголовок
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // прекращении программы при закрытии окна
        setSize(320, 345); // размер окна
        setLocation(400, 400);
        add(new GameField());
        setVisible(true);

    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }
}
