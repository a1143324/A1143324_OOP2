import javax.swing.*;
import java.awt.*;

public class GoodLogin extends JFrame {
    
    public GoodLogin() {
        setTitle("登入");
        setSize(300, 200);
        setLocationRelativeTo(null); // 置中視窗
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 【修正 1】取消 setLayout(null)，改用 GridLayout 自動排版成 3列2行
        setLayout(new GridLayout(3, 2, 10, 20));

        // 宣告元件
        JLabel l1 = new JLabel("帳號:", SwingConstants.RIGHT);
        JTextField t1 = new JTextField();
        JLabel l2 = new JLabel("密碼:", SwingConstants.RIGHT);
        
        // 【修正 4】密碼改用 JPasswordField，輸入時會變成隱藏黑點
        JPasswordField t2 = new JPasswordField(); 
        
        JButton btn = new JButton("登入");

        // 加入元件 (左邊留空，右邊放按鈕)
        add(l1); 
        add(t1); 
        add(l2); 
        add(t2); 
        add(new JLabel("")); // 佔位用
        add(btn);

        btn.addActionListener(e -> {
            // 【修正 2】Java 的字串比對必須使用 .equals()
            String account = t1.getText();
            String password = new String(t2.getPassword()); // 安全取得密碼的方式
            
            if ("admin".equals(account) && "admin".equals(password)) { 
                System.out.println("登入成功");
                JOptionPane.showMessageDialog(null, "登入成功！");
            } else {
                System.out.println("登入失敗");
                JOptionPane.showMessageDialog(null, "帳號或密碼錯誤！", "錯誤", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // 【修正 3】setVisible(true) 必須放在所有元件設定完畢的最後一行
        setVisible(true);
    }
    
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(() -> new GoodLogin()); 
    }
}