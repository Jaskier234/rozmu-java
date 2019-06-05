package GUI;

import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.*;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class MainWindow extends JFrame{
    private JPanel mainPanel;
    private JButton send;
    private JTextField input;
    private JPanel messagePane;
    private JScrollPane scroll;
    private GridBagConstraints c;
    private int messageCounter;

    public MainWindow()
    {
        super("rozmu-rozmu");

        scroll.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(messagePane);

//        messagePane.setLayout(new BoxLayout(messagePane, BoxLayout.Y_AXIS));
        c = new GridBagConstraints();

        messagePane.setLayout(new GridBagLayout());

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        messageCounter = 0;
    }

    public void pushMessage(Message m)
    {
//        messagePane.setLayout(new GridLayout(messageCounter + 1, 1));
//        m.setBounds(0, messageCounter * Message.HEIGHT,
//                Message.WIDTH, Message.HEIGHT);
//        System.out.println(m.getMinimumSize());
        messagePane.setSize(Message.WIDTH, Message.HEIGHT * messageCounter);
        c.gridx = 0;
        c.anchor = NORTH;
//        c.gridy = 0;
        messagePane.add(m, c);
//        System.out.println(m.getSize());
        scroll.setViewportView(messagePane);
        messageCounter++;
//        scroll.getVerticalScrollBar().setVisible(true);
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
    }

    public JTextField getInput() {
        return input;
    }

    public JButton getSend() {
        return send;
    }

}

