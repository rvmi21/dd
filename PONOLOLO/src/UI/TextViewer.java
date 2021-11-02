package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextViewer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void barad(String txt) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextViewer frame = new TextViewer(txt);
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
	public TextViewer(String txt) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 10, 587, 575);
		textArea.setText(txt);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(255, 592, 89, 23);
		contentPane.add(btnNewButton);
	}
}
