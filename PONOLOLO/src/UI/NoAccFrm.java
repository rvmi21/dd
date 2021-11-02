package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class NoAccFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void ain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoAccFrm frame = new NoAccFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NoAccFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 143);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Access denied !");
		lblNewLabel.setBounds(129, 33, 127, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setBounds(105, 70, 127, 23);
		contentPane.add(btnNewButton_1);
	}
}
