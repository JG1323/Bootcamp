import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.ArrayList;

public class MemoryGame extends JFrame implements ActionListener {
    private final int rows = 4;
    private final int cols = 4;
    private JPanel[][] panels;
    private CardLayout[][] cardLayouts;
    private String[] names = {
        "León", "Tigre", "Elefante", "Jirafa",
        "Cebra", "Mono", "Canguro", "Panda"
    };
    private String[] shuffledNames;
    private JButton firstButton;
    private JButton secondButton;
    private Timer timer;
    private String playerName;
    private int pairsFound;  // Contador de pares encontrados
    private JLabel statusLabel;
    
    public MemoryGame() {
        playerName = getPlayerName();
        setTitle("MemoryGame - Gamertag: " + playerName);
        setSize(800, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        statusLabel = new JLabel("Pares encontrados: 0");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(statusLabel, BorderLayout.NORTH);
        
        JPanel gamePanel = new JPanel(new GridLayout(rows, cols, 10, 10));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gamePanel.setBackground(new Color(173, 216, 230));
        
        panels = new JPanel[rows][cols];
        cardLayouts = new CardLayout[rows][cols];
        shuffledNames = getShuffledNames();
        initializePanels(gamePanel);
        
        add(gamePanel, BorderLayout.CENTER);
        
        timer = new Timer(1000, e -> {
            flipBack(firstButton);
            flipBack(secondButton);
            firstButton = null;
            secondButton = null;
        });
        timer.setRepeats(false);
        
        pairsFound = 0;
        
        setVisible(true);
    }
    
    private String getPlayerName() {
        return JOptionPane.showInputDialog(this, "Gamertag:", "Gamertag del Player", JOptionPane.PLAIN_MESSAGE);
    }
    
    private String[] getShuffledNames() {
        ArrayList<String> list = new ArrayList<>();
        for (String name : names) {
            list.add(name);
            list.add(name);
        }
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
    
    private void initializePanels(JPanel gamePanel) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cardLayouts[i][j] = new CardLayout();
                panels[i][j] = new JPanel(cardLayouts[i][j]);
                
                JButton button = new JButton("?");
                button.addActionListener(this);
                button.setActionCommand(shuffledNames[i * cols + j]);
                button.setName(i + "," + j);  // Store the position of the button
                button.setFont(new Font("Arial", Font.BOLD, 36));
                button.setBackground(new Color(240, 128, 128));
                button.setForeground(Color.WHITE);
                panels[i][j].add(button, "back");
                
                JLabel label = new JLabel(shuffledNames[i * cols + j], SwingConstants.CENTER);
                label.setFont(new Font("Arial", Font.BOLD, 36));
                panels[i][j].add(label, "front");
                
                gamePanel.add(panels[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String[] position = clickedButton.getName().split(",");
        int row = Integer.parseInt(position[0]);
        int col = Integer.parseInt(position[1]);
        
        flipButton(row, col);
        
        if (firstButton == null) {
            firstButton = clickedButton;
        } else if (secondButton == null && clickedButton != firstButton) {
            secondButton = clickedButton;
            if (!firstButton.getActionCommand().equals(secondButton.getActionCommand())) {
                timer.start();
            } else {
                // Las dos cartas coinciden, dejarlas descubiertas
                firstButton.setEnabled(false);
                secondButton.setEnabled(false);
                firstButton = null;
                secondButton = null;
                pairsFound++;
                statusLabel.setText("Pares encontrados: " + pairsFound);
                if (pairsFound == (rows * cols) / 2) {
                    // Todas las parejas han sido encontradas
                    JOptionPane.showMessageDialog(this, "¡Felicidades " + playerName + "! Has encontrado todas las parejas.");
                }
            }
        }
    }

    private void flipButton(int row, int col) {
        cardLayouts[row][col].next(panels[row][col]);
    }

    private void flipBack(JButton button) {
        String[] position = button.getName().split(",");
        int row = Integer.parseInt(position[0]);
        int col = Integer.parseInt(position[1]);
        cardLayouts[row][col].previous(panels[row][col]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MemoryGame::new);
    }
}
