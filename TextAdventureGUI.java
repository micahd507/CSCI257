package game;

import javax.swing.*;
import java.awt.*;

public class TextAdventureGUI extends JFrame {

    private final JTextArea outputArea;
    private final JTextField inputField;

    private static final Color BACKGROUND =
            new Color(23, 22, 20);
    private static final Color BOX_BACKGROUND =
            new Color(14, 13, 11);
    private static final Color PARCHMENT =
            new Color(215, 204, 181);
    private static final Color ANTIQUE_GOLD =
            new Color(143, 117, 66);

    public TextAdventureGUI() {
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(BACKGROUND);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Serif", Font.PLAIN, 18));
        outputArea.setForeground(new Color(215, 204, 181));
        outputArea.setBackground(BOX_BACKGROUND);
        outputArea.setCaretColor(PARCHMENT);
        outputArea.setMargin(new Insets(16, 16, 16, 16));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(
                BorderFactory.createLineBorder(ANTIQUE_GOLD));

        inputField = new JTextField();
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 16));
        inputField.setForeground(new Color(201, 177, 128));
        inputField.setBackground(BOX_BACKGROUND);
        inputField.setCaretColor(PARCHMENT);
        inputField.setMargin(new Insets(8, 10, 8, 10));
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(ANTIQUE_GOLD),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        inputField.addActionListener(e -> {
            String command = inputField.getText().trim();

            if (!command.isEmpty()) {
                appendOutput("> " + command);
                inputField.setText("");

                boolean keepPlaying = Game.executeCommand(command);

                if (!keepPlaying) {
                    inputField.setEnabled(false);
                }
            }
        });

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputField, BorderLayout.SOUTH);
        add(mainPanel);
    }

    public void appendOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(
                outputArea.getDocument().getLength());
    }

    public void start() {
        setVisible(true);
        inputField.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextAdventureGUI gui = new TextAdventureGUI();

            Game.destoMap();
            Game.setOutput(gui::appendOutput);

            gui.start();
            Game.startGame();
        });
    }
}