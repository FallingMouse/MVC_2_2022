package view;
import java.awt.*;
import javax.swing.*;

public class View {
    // region JFrame and JPanel***
    private JFrame welFrame;
    private JPanel pInput;
    private JPanel pRespond;

    // input in panel
    private JLabel yourTextHere;
    private JTextArea txtYourTextHere;
    private JButton btnSend;
    
    // ChatCSIfElseAnswer in panel
    private JLabel chatCSIfElseAnswer;
    private JTextArea textRespond;

    // endregion JFrame and JPanel***

    // region Constructor ***
    public View() {
        // Welcome Frame
        welFrame = new JFrame("ChatCSIfElse");
        welFrame.setSize(600, 400);
        welFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welFrame.setLocationRelativeTo(null);
        welFrame.setLayout(null);

        // Panel Input
        pInput = new JPanel();
        pInput.setBounds(0, 0, 600, 200);
        pInput.setBackground(new Color(68, 70, 84));
        pInput.setLayout(null);
        welFrame.add(pInput);
        addInputComponent();

        // Panel Respond
        pRespond = new JPanel();
        pRespond.setBounds(0, 200, 600, 200);
        pRespond.setBackground(new Color(124, 125, 138));
        pRespond.setLayout(null);
        welFrame.add(pRespond);
        addRespondComponent();
    }
    // endregion Constructor ***


    // region private method ***
    private void addInputComponent() {
        // Your Text Here
        yourTextHere = new JLabel("Your Text Here:");
        yourTextHere.setBounds(10, 10, 100, 20);
        yourTextHere.setForeground(Color.white);
        pInput.add(yourTextHere);

        // Text Area
        txtYourTextHere = new JTextArea();
        txtYourTextHere.setBounds(10, 30, 565, 100);
        txtYourTextHere.setLineWrap(true);
        txtYourTextHere.setWrapStyleWord(true);
        txtYourTextHere.setFont(new Font("Arial", Font.PLAIN, 16));
        txtYourTextHere.setBackground(Color.white);
        pInput.add(txtYourTextHere);

        // Button Send
        btnSend = new JButton("Send");
        btnSend.setBounds(10, 140, 565, 50);
        btnSend.setBackground(new Color(248, 147, 29));
        btnSend.setForeground(Color.WHITE);
        pInput.add(btnSend);
    }

    private void addRespondComponent() {
        // ChatCSIfElse Answer
        chatCSIfElseAnswer = new JLabel("ChatCSIfElse Answer:");
        chatCSIfElseAnswer.setBounds(10, 10, 200, 20);
        chatCSIfElseAnswer.setForeground(Color.white);
        pRespond.add(chatCSIfElseAnswer);

        // Text Respond Area
        textRespond = new JTextArea();
        textRespond.setBounds(10, 30, 565, 120);
        textRespond.setEditable(false);
        textRespond.setLineWrap(true);
        textRespond.setWrapStyleWord(true);
        textRespond.setFont(new Font("Arial", Font.PLAIN, 16));
        textRespond.setBackground(new Color(48, 53, 115));
        textRespond.setForeground(Color.white);
        pRespond.add(textRespond);
    }
    // endregion private method ***


    // region public method ***
    public void display()
    {
        welFrame.setVisible(true);
    }
    public JTextArea getTxtYourTextHere() {
        return txtYourTextHere;
    }
    public JButton getBtnSend() {
        return btnSend;
    }
    public JTextArea getTextRespond() {
        return textRespond;
    }
    // endregion public method ***
}
