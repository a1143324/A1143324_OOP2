import javax.swing.*;

public class FixedLogin extends JFrame {
    
    public FixedLogin() {
        setTitle("登入");
        setSize(300, 200);
        // 新增：設定關閉視窗時結束程式，否則程式會在背景繼續執行
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null); 

        JLabel l1 = new JLabel("帳號:");
        JTextField t1 = new JTextField();
        JLabel l2 = new JLabel("密碼:");
        // 修正：將密碼輸入框改為 JPasswordField，輸入時會顯示為隱藏字元(如星號或圓點)
        JPasswordField t2 = new JPasswordField(); 
        JButton btn = new JButton("登入");

        // 修正：因為使用了 setLayout(null) 絕對佈局，必須設定每個元件的 x, y 座標與寬、高，否則元件長寬預設為 0 會無法顯示
        l1.setBounds(50, 30, 50, 25);
        t1.setBounds(100, 30, 120, 25);
        l2.setBounds(50, 70, 50, 25);
        t2.setBounds(100, 70, 120, 25);
        btn.setBounds(100, 110, 80, 25);

        add(l1); 
        add(t1); 
        add(l2); 
        add(t2); 
        add(btn);

        btn.addActionListener(e -> {
            // 取得帳號與密碼
            String username = t1.getText();
            String password = new String(t2.getPassword()); // JPasswordField 建議使用 getPassword()
            
            // 修正：補齊缺失的引號與括號。
            // 修正：Java 中比較字串內容必須使用 .equals()，不能使用 ==
            // 這裡假設正確密碼為 "1234"
            if ("admin".equals(username) && "1234".equals(password)) {
                System.out.println("登入成功");
                // 額外補充：實務上通常會跳出對話框提示
                JOptionPane.showMessageDialog(this, "登入成功！");
            } else {
                System.out.println("登入失敗");
                JOptionPane.showMessageDialog(this, "帳號或密碼錯誤！", "登入失敗", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 修正：將 setVisible(true) 移到建構子的最後一行，確保所有元件都已載入完畢才顯示視窗
        setVisible(true);
    }

    public static void main(String[] args) {
        // 額外補充：標準做法是將 GUI 的建立交由事件分派執行緒 (EDT) 處理，避免潛在的畫面不同步問題
        SwingUtilities.invokeLater(() -> {
            new FixedLogin();
        });
    }
}