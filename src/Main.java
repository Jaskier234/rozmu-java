import GUI.MainWindow;
import GUI.Message;
import GUI.Messages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {

//        ServerSocket socket = new ServerSocket(7890);
        Socket client = new Socket("brown09", 7890);

//        client.connect(address);
        DataInputStream inputStream = new DataInputStream(client.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());


        MainWindow window = new MainWindow();


        JButton sendButton = window.getSend();
        JTextField input = window.getInput();

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = input.getText();
                try {
                    for(int i=0; i<message.length(); i++)
                        outputStream.writeChar(message.charAt(i));
                    outputStream.writeChar('\0');
                    outputStream.flush();
                    System.out.println("wysłano: " + message);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Message inputMessage = new Message("A", message);
                window.pushMessage(inputMessage);
            }
        });

        String text = "";

        while(true)
        {
            char messageFrom = inputStream.readChar();
            while(messageFrom != '\0') {
                text += messageFrom;
                messageFrom = inputStream.readChar();
            }
            Message outputMessage = new Message("B", text);
            window.pushMessage(outputMessage);
            text = "";
        }
    }
}