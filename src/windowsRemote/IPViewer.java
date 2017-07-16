package windowsRemote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.TableColumn;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;

public class IPViewer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IPViewer window = new IPViewer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws BadLocationException 
	 */
	public IPViewer() throws BadLocationException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws BadLocationException 
	 */
	private void initialize() throws BadLocationException {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnAbcxyz = new JTextPane();
		txtpnAbcxyz.setText("abc\r\n<b>xyz</b>");
		//txtpnAbcxyz.getHighlighter().addHighlight(0, 3, DefaultHighlighter.DefaultHighlightPainter(Color.red));
		txtpnAbcxyz.setBounds(40, 87, 588, 219);
		frame.getContentPane().add(txtpnAbcxyz);
		TableColumn c = new TableColumn();
		c.setHeaderValue("IP");;
	}
}
