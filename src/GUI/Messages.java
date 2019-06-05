package GUI;

import javax.swing.*;

public class Messages extends JScrollPane {
    public static int WIDTH = 600;
    public static int HEIGHT = 400;

    private Message[] messages;

    public Messages() {
        super();
        setVisible(true);
        setSize(WIDTH, HEIGHT);
    }

    public void addMessage(Message message) {
        add(message);
    }
}
