import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import com.toedter.calendar.JCalendar;

public class MCalendarPanel extends JPanel {
	
	private JPanel calendarPanel, buttonPanel;
	private JLabel label;
	private JButton deleteButton, confirmButton;
	
    public MCalendarPanel() {

    	setSize(350, 350);
        setLayout(new BorderLayout());

        createBtn();
        createLayout();
        
    }
    
    public void createLayout() {
    	
    	 calendarPanel = new JPanel(new BorderLayout());
         label = new JLabel("Menstrual Calendar", JLabel.CENTER);
         label.setFont(new Font("Serif", Font.BOLD, 20));
         Border margin = BorderFactory.createEmptyBorder(0, 0, 25, 0); // Top, Left, Bottom, Right
         label.setBorder(margin);
         
         calendarPanel.add(label, BorderLayout.NORTH);
         calendarPanel.add(new JCalendar(), BorderLayout.CENTER);
         
         buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         buttonPanel.add(deleteButton);
         buttonPanel.add(confirmButton);

         add(calendarPanel, BorderLayout.CENTER);
         add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void createBtn() {
    	
    	deleteButton = new JButton("Delete");
        confirmButton = new JButton("Confirm");
    }

    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MCalendarPanel panel = new MCalendarPanel();
            panel.setVisible(true);
        });
    }
}
