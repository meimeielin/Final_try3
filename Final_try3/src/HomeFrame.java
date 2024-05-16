
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class HomeFrame extends JFrame {
    private JPanel helloPanel, fcnPanel;
    private JLabel lblNewLabel, lblUser;
    
    public HomeFrame() {
        this.setTitle("Home");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(730, 450); // 调整窗口大小以容纳更多内容
        
        createLayout();
        createBtn();
    }
    
    public void createLayout() {
        getContentPane().setLayout(new BorderLayout()); // 使用边界布局管理器
        
        helloPanel = new JPanel();
        helloPanel.setLayout(new BorderLayout()); // 使用边界布局管理器
        getContentPane().add(helloPanel, BorderLayout.CENTER); // 将 helloPanel 放置在中央
        
        lblNewLabel = new JLabel("Welcome to Menstrual Care, ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Libian SC", Font.BOLD, 30));
        helloPanel.add(lblNewLabel, BorderLayout.NORTH); // 将 lblNewLabel 放置在北部
        
        lblUser = new JLabel("User ");
        lblUser.setHorizontalAlignment(SwingConstants.CENTER);
        lblUser.setFont(new Font("Libian SC", Font.BOLD, 25));
        helloPanel.add(lblUser, BorderLayout.CENTER); // 将 lblUser 放置在中央
        
        fcnPanel = new JPanel(new GridLayout(4, 1)); // 使用网格布局管理器，每行一个按钮
        getContentPane().add(fcnPanel, BorderLayout.WEST); // 将 fcnPanel 放置在西部
        
    }
	
	
	
	public void createBtn() {
	    JButton ShareButton = new JButton("共享站");
	    ShareButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            helloPanel.removeAll();
	            SharePanel sharePanel = new SharePanel();
	            sharePanel.setBounds(104, 6, 700, 310);
	            helloPanel.add(sharePanel);
	            helloPanel.revalidate();
	            helloPanel.repaint();
	        }
	    });
	    
	    fcnPanel.add(ShareButton);
	    
	    JButton CalendarButton = new JButton("月經日曆");
	    CalendarButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            helloPanel.removeAll();
	            MCalendarPanel MCalendarPanel = new MCalendarPanel();
	            MCalendarPanel.setBounds(104, 6, 700, 310);
	            helloPanel.add(MCalendarPanel);
	            helloPanel.revalidate();
	            helloPanel.repaint();
	        }
	    });

	    fcnPanel.add(CalendarButton);
	    
	    JButton InfoShareButton = new JButton("資訊分享");
	    InfoShareButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            helloPanel.removeAll();
	            InfoSharePanel infoSharePanel = new InfoSharePanel();
	            infoSharePanel.setBounds(104, 6, 700, 310);
	            helloPanel.add(infoSharePanel);
	            helloPanel.revalidate();
	            helloPanel.repaint();
	        }
	    });
	    fcnPanel.add(InfoShareButton);
	    
	    JButton ProfileButton = new JButton("個人資訊");
	    ProfileButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            helloPanel.removeAll();
	            InfoPanel infoPanel = new InfoPanel();
	            infoPanel.setBounds(104, 6, 700, 310);
	            helloPanel.add(infoPanel);
	            helloPanel.revalidate();
	            helloPanel.repaint();
	        }
	    });
	    fcnPanel.add(ProfileButton);
	}



	
	public void showLabel(String ID) {
		lblUser.setText("User " + ID);
	}
}