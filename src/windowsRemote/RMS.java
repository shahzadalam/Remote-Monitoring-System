package windowsRemote;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.DropMode;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;

public class RMS {

	private JFrame frame;
	private JTextField txtListOfIp =new JTextField();
	private JTextArea txtrIpAddress =new JTextArea();
	private JComboBox comboBox =new JComboBox<String>();
	JButton btnShowLog = new JButton("Show Log");
	private final JLabel lblNewLabel = new JLabel("                                    IP Address            Hostname               Status     ");

	/**
	 * Launch the application.
	 */
	public static void GetIP() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RMS window = new RMS();
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
	public RMS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 776, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton ShowIp = new JButton("Show IP");
		ShowIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ping p1=new ping();
				ArrayList<String> ip;
				//btnShowLog.setVisible(true);
				try {
					ip = p1.getIP();
					for(int i=0;i<ip.size();i++)
					{
						comboBox.addItem(ip.get(i+1));
					    txtrIpAddress.append("\t\t"+ip.get(i).substring(1)+"\t|                "+ip.get(i+1)+"\t| Connected\n");
					    i++;
					}
					btnShowLog.setVisible(true);
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		ShowIp.setBounds(347, 57, 89, 23);
		frame.getContentPane().add(ShowIp);
		
		JLabel lblRemoteMonitoringSystem = new JLabel("Remote Monitoring System");
		lblRemoteMonitoringSystem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRemoteMonitoringSystem.setBounds(304, 13, 222, 20);
		frame.getContentPane().add(lblRemoteMonitoringSystem);
		txtrIpAddress.setForeground(new Color(0, 0, 139));
		txtrIpAddress.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		txtrIpAddress.setBackground(Color.WHITE);
		
		//JTextArea textArea = new JTextArea();
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(txtrIpAddress);
		//frame.add(pane);
		
		pane.setBounds(12, 93, 734, 225);
		frame.getContentPane().add(pane);
		lblNewLabel.setBackground(new Color(204, 153, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLUE);
		
		pane.setColumnHeaderView(lblNewLabel);
		
		//JComboBox comboBox = new JComboBox();
		comboBox.setBounds(183, 352, 207, 22);
		comboBox.setVisible(true);
		btnShowLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LogPage lpg =new LogPage();
				lpg.logPage(comboBox.getSelectedItem().toString());
				//System.out.println("-----"+comboBox.getSelectedItem().toString());
				
			}
		});
		btnShowLog.setVisible(false);
		btnShowLog.setVisible(false);
		btnShowLog.setBounds(476, 351, 97, 25);
		frame.getContentPane().add(btnShowLog);
		frame.getContentPane().add(comboBox);
	}
}
