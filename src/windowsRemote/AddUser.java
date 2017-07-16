package windowsRemote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;

import org.xbill.DNS.TXTRecord;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	private void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}
	public void adduserWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser window = new AddUser();
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
	public AddUser() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(128, 71, 113, 20);
		frame.getContentPane().add(comboBox);
		remotecall usr =new remotecall();
		ArrayList<String> user = usr.getUser();
		for(int i=0;i<user.size();i++)
		comboBox.addItem(user.get(i));
		JLabel lblHostName = new JLabel("Host Name:");
		lblHostName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
		lblHostName.setBounds(39, 66, 95, 31);
		frame.getContentPane().add(lblHostName);
		
		JLabel lblUsername = new JLabel("UserName:-");
		lblUsername.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
		lblUsername.setBounds(39, 113, 113, 31);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(128, 118, 173, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:-");
		lblPassword.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
		lblPassword.setBounds(39, 149, 85, 31);
		frame.getContentPane().add(lblPassword);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String passText1 = new String(passwordField.getPassword());
				if(textField.getText().equals("")&&passText1.equals(""))
				  { 
					msgbox("Enter user id and password first");
				  }
				else{
					
					remotecall rc =new remotecall();
				      String passText = new String(passwordField.getPassword());
				     rc.addUser(comboBox.getSelectedItem().toString(),textField.getText(),passText);
					  msgbox(textField.getText()+" Added in database");
					  textField.setText("");
				}
			}
		});
		btnAdd.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
		btnAdd.setBounds(125, 185, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblAddUser = new JLabel("Add User");
		lblAddUser.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddUser.setBounds(158, 13, 83, 31);
		frame.getContentPane().add(lblAddUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 152, 173, 22);
		frame.getContentPane().add(passwordField);
	}
}
