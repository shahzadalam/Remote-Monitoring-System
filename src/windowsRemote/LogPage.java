package windowsRemote;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;

import com.file.log.fileManagement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class LogPage extends JFrame {

	private JFrame frame;
	private JTextArea textArea;
	private JTextField textField_1;
	private JTextField textField_2;
	private JScrollPane scrollPane;
	public static String hostname;
    public ArrayList<String> log= null;
    private JComboBox comboBox_1 = new JComboBox();
	/**
	 * Launch the application.
	 */
    private void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}
	public  void logPage(String host) {
		this.hostname=host;
		System.out.println(host);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogPage window = new LogPage();
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
	public LogPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserLogs = new JLabel("User logs");
		lblUserLogs.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUserLogs.setBounds(281, 13, 76, 26);
		frame.getContentPane().add(lblUserLogs);
	
		
		JLabel lblDate = new JLabel("Date:-");
		lblDate.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
		lblDate.setBounds(22, 48, 60, 17);
		frame.getContentPane().add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 48, 158, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		textField_1.setText(dateFormat.format(cal.getTime()));
		
		textField_2 = new JTextField();
		textField_2.setText(hostname);
		textField_2.setBounds(457, 46, 158, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		String adr;
		try {
			adr = InetAddress.getLocalHost().getHostName();
			//textField_2.setText(adr);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblPcNumber = new JLabel("Pc Ip Address:-");
		lblPcNumber.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
		lblPcNumber.setBounds(365, 49, 104, 14);
		frame.getContentPane().add(lblPcNumber);
		
		JLabel lblUserName = new JLabel("User Name:-");
		lblUserName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
		lblUserName.setBounds(22, 76, 78, 26);
		frame.getContentPane().add(lblUserName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(103, 77, 115, 22);
		frame.getContentPane().add(comboBox);
		remotecall rc1 =new remotecall();
		comboBox.addItem(rc1.getuser(textField_2.getText()));
		JButton btnShowLog = new JButton("Show Log");
		JTextArea txtrResult = new JTextArea();
		btnShowLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        
				LogConnection con=new LogConnection();
				log = con.getlog(textField_2.getText(),comboBox.getSelectedItem().toString(),comboBox_1.getSelectedItem().toString());
				for(int i=0;i<log.size();i++)
				{
					txtrResult.append("\n"+log.get(i));
					//textArea.append("\nsadsadsadsad");
				}
			}
		});
		btnShowLog.setBounds(302, 98, 97, 25);
		frame.getContentPane().add(btnShowLog);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 136, 668, 479);
		   //40, 174, 442, 265
		frame.getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(txtrResult);
		
		JButton btnSaveLog = new JButton("Save Log");
		btnSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtrResult.getText().equals(""))
				  { 
					msgbox("!!! Please load the log first");
				  }
				else{
				fileManagement fm = new fileManagement();
				//System.out.println(log.get(2));
				fm.storefile(log,comboBox.getSelectedItem().toString());
				msgbox("File Successfully saved");
				}
			}
		});
		btnSaveLog.setBounds(457, 98, 97, 25);
		frame.getContentPane().add(btnSaveLog);
		
		JLabel lblLogFile = new JLabel("Log File  :");
		lblLogFile.setBounds(26, 107, 74, 16);
		frame.getContentPane().add(lblLogFile);
		
		
		comboBox_1.setBounds(103, 104, 115, 22);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addItem("syslog");
		comboBox_1.addItem("auth.log");
		
		
	}
}
