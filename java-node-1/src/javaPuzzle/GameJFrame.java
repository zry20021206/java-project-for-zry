package javaPuzzle;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
    
public class GameJFrame extends JFrame implements KeyListener,ActionListener {
    
    int data[][] = new int[4][4];//引用数据类型，方法中更改的值会保留
    
    int win[][] = new int[][] {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 0}
    };//判断胜利用的二维数组
    
    int step = 0;//统计步数

    String path = "D:\\javava\\java-node-1\\image\\girl\\girl1\\";
    
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem women = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");

    Random rm = new Random();

    public GameJFrame() {
        //每个方法通过 this 修改的是GameJFrame对象的状态（比如窗口的属性、菜单栏、图像等），这些修改会影响整个对象，而不仅仅是当前方法的作用域。换句话说，每个方法都在操作同一个对象的属性，方法执行完后，这些属性值会被保留。
        this.initJFrame();
        this.initJMenuBar();
        this.initData();
        this.initImage();
        this.setVisible(true);
    }
    
    public void initJFrame() { 
        this.setSize(603, 680);
        this.setTitle("拼图游戏");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口来结束程序
        this.setLayout(null);
        this.addKeyListener(this);//监听键盘，这个监听会一直存在，直到我关闭窗口,第一个this可以用JFrame对象代替，第二个this可以用KeyListener对象代替
    }
    
    public void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
    
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");
        JMenu changeItem = new JMenu("更换图片");
        
        //给菜单绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        women.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
    
        functionMenu.add(changeItem);
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);
        
        
        changeItem.add(women);
        changeItem.add(animal);
        changeItem.add(sport);
    
        aboutMenu.add(accountItem);
    
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);
    
        this.setJMenuBar(jMenuBar);
    }

    int x = 0, y = 0;//记录空白方块在拼图上的位置
    public void initData() {
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int array1[] = ArrayChange.change(array);
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = array1[i];
        }
    }
    
    public void initImage() {
        this.getContentPane().removeAll();//清空已经出现的所有图片

        if (victory()) {
            ImageIcon win = new ImageIcon("D:\\javava\\java-node-1\\image\\win.png");
            JLabel label = new JLabel(win);
            label.setBounds(203, 283, 197, 73);
            this.getContentPane().add(label);
        }//添加成功显示

        JLabel stepcount = new JLabel("步数：" + step);
        stepcount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepcount);//添加步数标签
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon icon = new ImageIcon(path + data[i][j] + ".jpg");
                JLabel label = new JLabel(icon);
                label.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                label.setBorder(new BevelBorder(BevelBorder.LOWERED)); // 使用常量名提高可读性
                this.getContentPane().add(label); 
            }
        }

        ImageIcon bg = new ImageIcon("D:\\javava\\java-node-1\\image\\background.png");
        JLabel labelbg = new JLabel(bg);
        labelbg.setBounds(40, 40, 508, 560);
        this.getContentPane().add(labelbg);//添加背景图片
        this.getContentPane().repaint();//刷新图片
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
            
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));//展示完整图片
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            ImageIcon bg = new ImageIcon("D:\\javava\\java-node-1\\image\\background.png");
            JLabel labelbg = new JLabel(bg);
            labelbg.setBounds(40, 40, 508, 560);
            this.getContentPane().add(labelbg);
            this.getContentPane().repaint();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }
        //对上下左右进行判断
        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            this.initImage();
        }
        else if (code == 38) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            this.initImage();
        }
        else if (code == 39) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            this.initImage();
        }
        else if (code == 40) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            this.initImage();
        }
        else if (code == 65) {
            this.initImage();
        }
        else if (code == 87) {
            data = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
            };
            this.initImage();
        }
    }

    public boolean victory() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            step = 0;
            this.initData();
            this.initImage();
        }
        else if (obj == reLoginItem) {
            this.setVisible(false);
            new LoginJFrame();
        }
        else if (obj == closeItem) {
            System.exit(0);
        }
        else if (obj == accountItem) {
        }
        else if (obj == women) {
            int i = rm.nextInt(13);
            path = "D:\\javava\\java-node-1\\image\\girl\\girl" + i + "\\";
            this.initData();
            this.initImage();
        }
        else if (obj == animal) {
            int i = rm.nextInt(8);
            path = "D:\\javava\\java-node-1\\image\\animal\\animal" + i + "\\";
            this.initData();
            this.initImage();
        }
        else if (obj == sport) {
            int i = rm.nextInt(10);
            path = "D:\\javava\\java-node-1\\image\\sport\\sport" + i + "\\";
            this.initData();
            this.initImage();
        }
    }
}
