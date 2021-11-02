package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CP_ABE.AES;
import CP_ABE.Key;
import SQL.SQLManager;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void sain(String[] args, String path, String Owner) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(path, Owner);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param info 
	 */
	public Home(String path , String Owner) {
		System.out.println("home= "+ Owner);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//String data[][] = {{"Owner","Description","Type"},
		//		   {"Deepak","PGDCA","History"},
		//		   {"Ranjan","M.SC.","Biology"},
		//		   {"Radha","BCA","Computer"}};
		
		String data[][] = SQLManager.FileUploader();
		
	    String col[] = {"file name","Description","owner","Type"};
        DefaultTableModel model = new DefaultTableModel(data,col);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(1065, 32, 130, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(194, 32, 861, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Open file");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = data [table.getSelectedRow()][0];
				//String ext = SQLManager.getext(info);
				//System.out.println(ext);
				//switch (ext) {
				//case "txt": {
				//	System.out.println("tada");
				//	System.out.println("ext is = "+ext);
				//	TextViewer frm = new TextViewer("test test");
				//	frm.barad("");
				//	System.out.println("is no text");
					
				//}
				//default:
					//System.out.println("oh no ");
					//SQLManager.readPicture(info);
					//ImgViewer frm = new ImgViewer("D:\\peepeepoopoo\\PFE\\ppnyar.png");
					//frm.Blyat("D:\\peepeepoopoo\\PFE\\ppnyar.png");
					//System.out.println("is tetxt");
				//}
				//if(ext == "txt") {
					//System.out.println("oh no ");
					//SQLManager.readPicture(info);
					//ImgViewer frm = new ImgViewer("D:\\peepeepoopoo\\PFE\\ppnyar.png");
					//frm.Blyat("D:\\peepeepoopoo\\PFE\\ppnyar.png");
					//System.out.println("is tetxt");
				//}
				//else {
					
					//System.out.println("ext is = "+ext);
					//TextViewer frm = new TextViewer("test test");
					//frm.barad("test test");
					//System.out.println("is no text");
				//}
				
				if(SQLManager.isCrybd(info)) {
					Key key = new Key(SQLManager.getQr(Owner));
					String fname = data [table.getSelectedRow()][0];
					Encrybded frm = new Encrybded(SQLManager.getText(info), ""+key.getValue(), Owner, fname);
					frm.poi(SQLManager.getText(info), ""+key.getValue(), Owner, fname);
				}
				else {
					TextViewer frm = new TextViewer(SQLManager.getText(info));
					frm.barad(SQLManager.getText(info));
				}
			}
		});
		btnNewButton_1.setBounds(1065, 600, 130, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add file");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFile frm = new AddFile(Owner, false);
				frm.sain(null, Owner, false);
				
			}
		});
		btnNewButton_2.setBounds(925, 600, 130, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\Asset\\lock (4).png"));
		lblNewLabel.setBounds(26, 65, 130, 128);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2_1 = new JButton("Log off");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogReg frm = new LogReg(null);
				frm.poompe(null);
				dispose();
			}
			
		});
		btnNewButton_2_1.setBounds(26, 551, 130, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Show QR");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QRSave QRsaveFrame = new QRSave(path);
				QRsaveFrame.qro(null, path);
			}
		});
		btnNewButton_2_2.setBounds(26, 517, 130, 23);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Edit infos");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoFrame f = new InfoFrame(null, true);
				f.foo(null, true);
			}
		});
		btnNewButton_2_3.setBounds(26, 483, 130, 23);
		contentPane.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_3_1 = new JButton("Edit attributs");
		btnNewButton_2_3_1.setBounds(26, 449, 130, 23);
		contentPane.add(btnNewButton_2_3_1);
		
		JButton btnNewButton_2_3_1_1 = new JButton("My files");
		btnNewButton_2_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyFiles frm = new MyFiles(path, Owner);
				frm.sain(null, path, Owner);
				dispose();
				
			}
		});
		btnNewButton_2_3_1_1.setBounds(26, 415, 130, 23);
		contentPane.add(btnNewButton_2_3_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 65, 999, 509);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1_1 = new JButton("Refresh");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home frame = new Home(path, Owner);
				frame.sain(null, path, Owner);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(785, 600, 130, 23);
		contentPane.add(btnNewButton_1_1);
	}
}
