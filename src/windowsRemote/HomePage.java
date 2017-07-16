package windowsRemote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HomePage {
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHomePage = new JLabel("Remote Monitoring System");
		lblHomePage.setForeground(Color.BLUE);
		lblHomePage.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblHomePage.setBounds(186, 48, 292, 45);
		frame.getContentPane().add(lblHomePage);
		
		JButton btnShowIp = new JButton("Show All Connected System");
		btnShowIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RMS rms=new RMS();
				rms.GetIP();
				
			}
		});
		btnShowIp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnShowIp.setBounds(314, 149, 211, 35);
		frame.getContentPane().add(btnShowIp);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser ad=new AddUser();
				ad.adduserWindow();
				frame.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(362, 234, 116, 35);
		frame.getContentPane().add(btnNewButton);
		//frame.getContentPane().add(new JLabel(new ImageIcon("images/image.jpg")));
		ImageIcon img = new ImageIcon("images/image.jpg");
		JButton btnAbtUs = new JButton("View Past log");
		btnAbtUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HistoryLog hl=new HistoryLog("History Log");
				hl.viewLog();
			}
		});
		btnAbtUs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAbtUs.setBounds(362, 335, 116, 35);
		frame.getContentPane().add(btnAbtUs);
		
		JLabel lblNewLabel = new JLabel(img);
		lblNewLabel.setBounds(24, 154, 278, 261);
		frame.getContentPane().add(lblNewLabel);
	}
}

