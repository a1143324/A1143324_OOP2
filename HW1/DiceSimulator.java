import javax.swing.*;
import java.awt.*;

public class DiceSimulator extends JFrame {
    
    private JLabel resultLabel;
    private JButton rollButton;

    public DiceSimulator() {
        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10)); 

        
        resultLabel = new JLabel("1~6",SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 60));
        
        rollButton = new JButton("擲骰子");
        rollButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
        rollButton.setPreferredSize(new Dimension(0, 50)); 
        add(resultLabel, "Center");
        add(rollButton, "South");
    }

    public static void main(String[] args) {
        new DiceSimulator().setVisible(true);
    }
}