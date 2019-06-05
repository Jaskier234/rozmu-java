package GUI;

import javax.swing.*;
import java.awt.*;

public class Message extends JTextField {
    public static int WIDTH = 600;
    public static int HEIGHT = 50;

    private String author;
    private String message;

    public Message(String author, String message) {
        super(message);
        setVisible(true);
        setEditable(false);
        setSize(WIDTH, HEIGHT);
        this.author = author;
        this.message = message;
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
