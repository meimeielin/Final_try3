import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InfoSharePanel extends JPanel{

	private JTextField titleField;
	private JButton publishButton, deleteButton;
	private JPanel postPanel, leftPanel, rightPanel, insertPanel, buttonPanel;
	private JLabel postLabel;
	private ArrayList<JButton> postButtons;
	private JTextArea contentArea;
	private JPanel insertpanel;
	
	
	public InfoSharePanel() {
		
		createLayout();
		createBtn();
	}
	
	public void createLayout() {
	    // 左半部分
	    leftPanel = new JPanel();
	    leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    leftPanel.setLayout(null);

	    // 按钮面板
	    buttonPanel = new JPanel(new GridLayout(1, 2));
	    buttonPanel.setBounds(10, 355, 276, 29);
	    publishButton = new JButton("發布");
	    deleteButton = new JButton("刪除");
	    buttonPanel.add(publishButton);
	    buttonPanel.add(deleteButton);

	    leftPanel.add(buttonPanel);

	    // 右半部分
	    insertPanel = new JPanel(new GridLayout(2, 0));
	    rightPanel = new JPanel();
	    rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 添加边界

	    // 贴文墙面板
	    postPanel = new JPanel(new GridLayout(0, 1));
	    postButtons = new ArrayList<>();

	    postLabel = new JLabel("貼文分享區");
	    rightPanel.add(postLabel, BorderLayout.NORTH);
	    rightPanel.add(postPanel, BorderLayout.CENTER);
	    setLayout(new GridLayout(0, 2, 0, 0));

	    add(leftPanel);
	    
	    insertpanel = new JPanel();
	    insertpanel.setBounds(6, 54, 280, 289);
	    leftPanel.add(insertpanel);
	    	    	    insertpanel.setLayout(new BoxLayout(insertpanel, BoxLayout.X_AXIS));
	    	    	    
	    	    	    contentArea = new JTextArea();
	    	    	    insertpanel.add(contentArea);
	    	    	    contentArea.setText("貼文內容");
	    	    	    
	    	    	    	    // 标题输入区
	    	    	    	    titleField = new JTextField("貼文標題");
	    	    	    	    titleField.setBounds(6, 16, 280, 36);
	    	    	    	    leftPanel.add(titleField);
	    	    	    	    titleField.setForeground(new Color(0, 0, 0));
	    	    	    	    titleField.setHorizontalAlignment(SwingConstants.LEFT);
	    add(rightPanel);
	}

	
	
	public void createBtn() {
		// 設置發布按鈕的動作
				publishButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String title = titleField.getText();
						String content = contentArea.getText();
						if (!title.isEmpty() && !content.isEmpty()) {
							
							addButtonToPostPanel(title, content);
							titleField.setText("");

							contentArea.setText("");
						} else {
							JOptionPane.showMessageDialog(InfoSharePanel.this, "標題和內容不能為空", "錯誤", JOptionPane.ERROR_MESSAGE);
						}
					}
				});

				// 設置貼文按鈕的動作
				for (JButton postButton : postButtons) {
					postButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.print("fffff");
							String buttonText = postButton.getText();
							String[] parts = buttonText.split("<br>"); // 分割按鈕文字獲取標題和內容
							if (parts.length >= 2) {
								titleField.setText(parts[0]); // 將標題設置為按鈕中的標題
								contentArea.setText(parts[1]); // 將內容設置為按鈕中的內容
							}
						}
					});
				}
				
	}
	
	// 將標題和內容添加到貼文按鈕面板中
	private void addButtonToPostPanel(String title, String content) {
		JButton postButton = new JButton("<html><center>" + title + "<br>" + content + "</center></html>");
		Dimension size = new Dimension(getWidth() / 2, 50); // 按鈕大小設置為視窗的一半寬度，高度固定為50像素
		postButton.setPreferredSize(size);
		postButton.setToolTipText(title + " - " + content); // 使用工具提示顯示完整的標題和內容
		postButtons.add(postButton);
		postPanel.add(postButton);
		revalidate(); // 刷新視窗以顯示新的按鈕
	}

	
}
	
	

