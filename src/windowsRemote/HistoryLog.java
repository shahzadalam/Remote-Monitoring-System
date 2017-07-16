package windowsRemote;
import com.file.log.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.Scrollable;

public class HistoryLog extends JFrame {
    private JTextArea textArea = new JTextArea();;
	private JFrame frame;
	private JScrollPane scrollpane = new JScrollPane();
	private JPanel panel = new JPanel();
	private JComboBox comboBox_1 = new JComboBox();
	private HomePage mainForm;
	private void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}

	/**
	 * Launch the application.
	 */
	public void viewLog() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryLog window = new HistoryLog("Log History");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param string 
	 */
	public HistoryLog(String string) {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 806, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogHistory = new JLabel("Log History");
		lblLogHistory.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLogHistory.setBounds(332, 13, 138, 32);
		frame.getContentPane().add(lblLogHistory);
		
		JLabel lblUserName = new JLabel("User name :");
		lblUserName.setBounds(232, 70, 87, 23);
		frame.getContentPane().add(lblUserName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(342, 70, 127, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnShowAllLog = new JButton("Show All Log");
		btnShowAllLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				textArea.setText("");
				fileManagement file =new fileManagement();
				List<String> filelist = file.getfile(comboBox.getSelectedItem().toString());
				
				if(filelist.size()<1)
				  { 
					msgbox("No log for user :"+comboBox.getSelectedItem().toString());
				  }
				else{
				for(int i=0;i<filelist.size();i++)
					comboBox_1.addItem(filelist.get(i));
				panel.setVisible(true);
				}
			}
		});
		btnShowAllLog.setBounds(294, 121, 138, 25);
		frame.getContentPane().add(btnShowAllLog);
		panel.setBounds(12, 175, 764, 459);
		frame.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		remotecall rc =new remotecall();
		ArrayList<String> al = rc.getUsername();
		for(int i=0;i<al.size();i++)
			comboBox.addItem(al.get(i));
		
		comboBox_1.setBounds(152, 25, 284, 22);
		panel.add(comboBox_1);
		
		JButton btnViewLog = new JButton("View Log");
		btnViewLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setVisible(true);
				textArea.setText(" ");
				comboBox.removeAll();
				fileManagement fm= new fileManagement();
				ArrayList<String> al = fm.showfile(comboBox_1.getSelectedItem().toString());
				for(int i=0;i<al.size();i++)
					textArea.append(al.get(i)+"\n");
				    textArea.setForeground(Color.blue);
					
			}
		});
		btnViewLog.setBounds(474, 24, 97, 25);
		panel.add(btnViewLog);
		
		scrollpane.setBounds(12, 58, 740, 388);
		scrollpane.setViewportView(textArea);
		scrollpane.setVisible(false);
		panel.add(scrollpane);
	}
}
