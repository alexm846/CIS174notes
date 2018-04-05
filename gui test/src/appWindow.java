import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class appWindow {

	private JFrame frame;
	private JTextField textField;
	private SlackService slackService = new SlackService();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appWindow window = new appWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public appWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("What do you want to say?");
		textArea.setBounds(23, 11, 376, 103);
		frame.getContentPane().add(textArea);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				slackService.submitTextToSlack(textArea.getText());
			}
		});
		btnSubmit.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		});
		
		textField.setText("");
		textField.setBounds(33, 125, 367, 62);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
