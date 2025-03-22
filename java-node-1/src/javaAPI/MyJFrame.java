package javaAPI;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class MyJFrame extends JFrame implements ActionListener {
    
    JButton button = new JButton("帅爆了");
    JButton button1 = new JButton("一般");
    JButton button2 = new JButton("丑死了");
    JButton button3 = new JButton("饶了我吧");
    boolean flag = false;

    public MyJFrame () {
        this.initJFrame();
        this.initView();
        this.setVisible(true);
    }
    public void initJFrame() {
        this.setSize(500, 600);
        this.setTitle("恶搞");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
    }
    public void initView() {
        this.getContentPane().removeAll();
        if (flag == true) {
            button3.setBounds(50, 20, 100, 30);
            button3.addActionListener(this);
            this.getContentPane().add(button3);
        }

        JLabel text = new JLabel("你觉得自己帅吗");
        text.setBounds(135, 150, 300, 50);
        text.setFont(new Font("微软雅黑", 0, 30));

        button.setBounds(200, 250, 100, 30);
        button1.setBounds(200, 325, 100, 30);
        button2.setBounds(160, 400, 180, 30);

        button.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);

        this.getContentPane().add(text);
        this.getContentPane().add(button);
        this.getContentPane().add(button1);
        this.getContentPane().add(button2);

        this.getContentPane().repaint();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == button) {
            show("你太自信了");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 3600");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            flag = true;
            initView();
        } 
        else if (obj == button1) {
            show("你太自信了");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 3600");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            flag = true;
            initView();
        }
        else if (obj == button2) {
            Runtime.getRuntime().exit(0);
        }
        else if (obj == button3) {
            show("好吧，饶了你");
            try {
                Runtime.getRuntime().exec("shutdown -a");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            initView();
        }
        
    }
    public void show(String content) {
        JDialog jd = new JDialog();
        jd.setSize(300, 200);
        jd.setAlwaysOnTop(true);
        jd.setLocationRelativeTo(null);
        jd.setModal(true);
        jd.setLayout(null);

        JLabel label = new JLabel(content);
        label.setBounds(100, 50, 200, 30);
        label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        
        JButton closeButton = new JButton("关闭");
        closeButton.setBounds(100, 100, 100, 30);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jd.dispose();
            }
        });
    
        jd.add(label);
        jd.add(closeButton);
    
        jd.setVisible(true);
    }

}
