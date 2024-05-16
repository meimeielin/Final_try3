import javax.swing.*;
import java.awt.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SharePanel extends JPanel {

    private JPanel infoPanel, helpPanel, Panel;
    private JLabel placeLabel, floorLabel, itemLabel, infoLabel, quantityLabel;
    private JComboBox<String> placeCombo, floorCombo, itemCombo, quantityCombo;
    private JButton offerBtn, takeBtn, needBtn;
    private JTextArea AreaA, AreaB;
    private JPanel choosePanel;

    // constructor
    public SharePanel() {


        Panel = new JPanel();
        Panel.setPreferredSize(new Dimension(730, 350));

        AreaA = new JTextArea(20, 12);
        AreaA.setBounds(224, 33, 194, 210);
        AreaA.setEditable(false);
        AreaA.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null)); // 添加一个空边框

        AreaB = new JTextArea(20, 12);
        AreaB.setBounds(445, 33, 194, 210);
        AreaB.setEditable(false);
        AreaB.setBorder(new LineBorder(new Color(17, 15, 16))); // 添加一个空边框


        // Instantiate components
        placeLabel = new JLabel("Place:");
        floorLabel = new JLabel("Floor:");
        itemLabel = new JLabel("item:");
        infoLabel = new JLabel("Info:");
        quantityLabel = new JLabel("Quantity:");
        
        offerBtn = new JButton("Offer");
        takeBtn = new JButton("Take");
        needBtn = new JButton("Need");
        
        createCom();
        createLayout();
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        add(Panel);
        
    }
    
    

    private void createLayout() {

    	choosePanel = new JPanel();
        choosePanel.setBounds(30, 6, 667, 46);
        choosePanel.add(placeLabel);
		choosePanel.add(placeCombo);
		choosePanel.add(floorLabel);
		choosePanel.add(floorCombo);
        Panel.add(choosePanel);
    	
        // Show item information
        infoPanel = new JPanel();
        infoPanel.setBounds(30, 53, 667, 247);
        infoPanel.setLayout(null);
        infoPanel.add(AreaA);
        infoPanel.add(AreaB);
		Panel.add(infoPanel);
        
        JPanel labelPanel = new JPanel();
        labelPanel.setBounds(0, 6, 667, 26);
        infoPanel.add(labelPanel);
        labelPanel.setLayout(new GridLayout(0, 3, 0, 0));
        labelPanel.add(infoLabel);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(new JLabel("Left:"));
        labelPanel.add(new JLabel("Need:"));
        
        // Choose item, quantity, and action
        helpPanel = new JPanel();
        helpPanel.setBorder(new CompoundBorder());
        helpPanel.setBounds(71, 303, 626, 46);
        helpPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        helpPanel.add(itemLabel);
        helpPanel.add(itemCombo);
        helpPanel.add(quantityLabel);
        helpPanel.add(quantityCombo);
        helpPanel.add(offerBtn);
        helpPanel.add(takeBtn);
        helpPanel.add(needBtn);
        Panel.setLayout(null);
        Panel.add(helpPanel);
    }

    
    private void createCom() {

		placeCombo = new JComboBox<>(new String[] { "綜院", "商院", "總圖", "達賢" }); // 到時候用Class的object寫 （利用accesser）
		floorCombo = new JComboBox<>(new String[] { "1", "2", "3", "4" }); // 到時候用Class的object寫（利用accesser）
		itemCombo = new JComboBox<>(new String[] { "日用型衛生棉", "夜用型衛生棉", "護墊", "暖暖包", "止痛藥" });
		quantityCombo = new JComboBox<>(new String[] { "1", "2", "3" });
    	
    }
}
