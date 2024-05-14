import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RoPaSc extends JFrame implements ActionListener {
    int computerScore = 0;
    int playerScore = 0;

    JLabel computerLabel, playerLabel, computerScoreLabel, playerScoreLabel;
    JButton r, p, s;
    ImageIcon ri = new ImageIcon("rock.png");
    ImageIcon pi = new ImageIcon(getClass().getResource("paper.png"));
    ImageIcon si = new ImageIcon(getClass().getResource("scissors.png"));

    RoPaSc() {
        setTitle("Rock Paper Scissors");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        

        Image rockImage = ri.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image paperImage = pi.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image scissorImage = si.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 

        ImageIcon resizedRockIcon = new ImageIcon(rockImage);
        ImageIcon resizedPaperIcon = new ImageIcon(paperImage);
        ImageIcon resizedScissorIcon = new ImageIcon(scissorImage);

        computerLabel = new JLabel("Computer: ");
        playerLabel = new JLabel("Player: ");
        computerScoreLabel = new JLabel("" + computerScore);
        playerScoreLabel = new JLabel("" + playerScore);
        
        r = new JButton(resizedRockIcon);
        p = new JButton(resizedPaperIcon);
        s = new JButton(resizedScissorIcon);

        JPanel textFieldPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        textFieldPanel.add(computerLabel);
        textFieldPanel.add(playerLabel);
        textFieldPanel.add(computerScoreLabel);
        textFieldPanel.add(playerScoreLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        buttonPanel.add(r);
        buttonPanel.add(p);
        buttonPanel.add(s);

        add(textFieldPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        r.addActionListener(this);
        s.addActionListener(this);
        p.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        String computerChoice = generateComputerChoice();
        String playerChoice="";
        
        if (a.getSource() == r)
            {
                playerChoice = "Rock";
            }
        else if (a.getSource() == p)
            {
                playerChoice = "Paper";
            }
        else if (a.getSource() == s)
            {
                playerChoice = "Scissors";
            }

        if (playerChoice.equals(computerChoice)) {
            JOptionPane.showMessageDialog(this, "It's a tie!");
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                   (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                   (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            playerScore++;
            playerScoreLabel.setText("" + playerScore);
            JOptionPane.showMessageDialog(this, "You win!");
        } else {
            computerScore++;
            computerScoreLabel.setText("" + computerScore);
            JOptionPane.showMessageDialog(this, "Computer wins!");
        }
    }

    private String generateComputerChoice() {
        int choice = (int)(Math.random() * 3);
        switch (choice) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            default:
                return "Scissors";
        }
    }
}

public class rps {
    public static void main(String[] args) {
        new RoPaSc();
    }
}
