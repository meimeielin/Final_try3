import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanel extends JPanel {

	private JPanel leftPanel, rightPanel, leftDown;
	private JLabel idLabel, takenLabel, providedLabel, pointsLabel;
	private JButton usePointsButton, confirmButton;
	private JTextField pointsTextField;
	private JTextArea historyTextArea;
	private JLabel itemTakenLabel, itemProvidedLabel;
	private int pointsSpent, accumulatedPoints;
	private JPanel histroyPanel;

	public InfoPanel() {

		this.pointsSpent = 0;
		this.accumulatedPoints = 100;
		this.itemTakenLabel = new JLabel("你在____拿了____個____");
		this.itemProvidedLabel = new JLabel("你在____提供了____個____");

		createBtn();
		createLayout();

	}

	public void createLayout() {
		setLayout(new GridLayout(0, 1, 0, 0));

		leftPanel = new JPanel();

		idLabel = new JLabel("   ID: ");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setBounds(0, 16, 300, 40);
		takenLabel = new JLabel("   本次已取: ____ 項用品");
		takenLabel.setBounds(0, 80, 300, 55);
		providedLabel = new JLabel("   總提供: ____ 項用品");
		providedLabel.setBounds(0, 147, 300, 61);
		pointsLabel = new JLabel("   累計點數: 100");
		pointsLabel.setBounds(0, 220, 300, 55);

		pointsTextField = new JTextField(5);
		pointsTextField.setEnabled(false);
		leftPanel.setLayout(null);

		leftPanel.add(idLabel);
		leftPanel.add(idLabel);
		leftPanel.add(takenLabel);
		leftPanel.add(providedLabel);
		leftPanel.add(pointsLabel);

		leftDown = new JPanel(new BorderLayout());
		leftDown.setBounds(10, 284, 272, 40);

		leftDown.add(usePointsButton, BorderLayout.WEST);
		leftDown.add(pointsTextField, BorderLayout.CENTER);
		leftDown.add(confirmButton, BorderLayout.EAST);

		leftPanel.add(leftDown);

		rightPanel = new JPanel();
		rightPanel.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);

		JPanel achivePanel = new JPanel();
		achivePanel.setBounds(6, 6, 288, 159);
		rightPanel.add(achivePanel);
		achivePanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("成就牆");
		lblNewLabel.setBounds(0, 0, 288, 30);
		achivePanel.add(lblNewLabel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 31, 288, 127);
		achivePanel.add(textArea);

		histroyPanel = new JPanel();
		histroyPanel.setBounds(10, 174, 288, 220);
		rightPanel.add(histroyPanel);
		histroyPanel.setLayout(null);

		JLabel label = new JLabel("歷史紀錄:");
		label.setBounds(0, 0, 288, 30);
		histroyPanel.add(label);

		historyTextArea = new JTextArea(5, 8);
		historyTextArea.setBounds(0, 28, 288, 192);
		histroyPanel.add(historyTextArea);
		historyTextArea.setTabSize(7);
		historyTextArea.setEditable(false);

		add(mainPanel);
		setVisible(true);

	}

	public void createBtn() {
		usePointsButton = new JButton("使用點數");
		usePointsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (accumulatedPoints == 0) {

					JOptionPane.showMessageDialog(null, "Error: 你沒點了", "Error", JOptionPane.ERROR_MESSAGE);
					return;

				}

				if (accumulatedPoints > 0) {

					confirmButton.setEnabled(true);
					pointsTextField.setEnabled(true);

				}
			}
		});

		confirmButton = new JButton("確定");
		confirmButton.setEnabled(false);

		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String pointsStr = pointsTextField.getText();

				if (pointsStr.isEmpty()) {

					JOptionPane.showMessageDialog(null, "Error: 點數不能是空的", "Error", JOptionPane.ERROR_MESSAGE);
					return;

				}

				int pointsToAdd = Integer.parseInt(pointsStr);

				if (pointsToAdd == 0) {

					JOptionPane.showMessageDialog(null, "Error: 點數不能是0", "Error", JOptionPane.ERROR_MESSAGE);
					return;

				}

				if (pointsToAdd > accumulatedPoints) {

					JOptionPane.showMessageDialog(null, "Error: 你的點不夠", "Error", JOptionPane.ERROR_MESSAGE);
					return;

				}

				accumulatedPoints -= pointsToAdd;
				pointsLabel.setText("累計點數: " + accumulatedPoints);

				// 更新历史记录

				pointsTextField.setText(null);
				pointsSpent += pointsToAdd;
				historyTextArea.append("你在____拿了____個____\n");
				historyTextArea.append("你在____提供了____個____\n");
				historyTextArea.append("你花了 " + pointsToAdd + " 點購買生理用品\n");

				confirmButton.setEnabled(false);
				pointsTextField.setEnabled(false);

			}
		});

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new InfoPanel();

			}
		});

	}
}
