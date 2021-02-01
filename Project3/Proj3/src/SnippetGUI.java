import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class SnippetGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnippetGUI window = new SnippetGUI();
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
	public SnippetGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		frame.setBounds(100, 100, 753, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		DefaultListModel<String> model = new DefaultListModel();
		JList list = new JList(model);
		list.setBounds(10, 10, 733, 483);
		frame.getContentPane().add(list);
		model.clear();

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(216, 191, 216));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.setFrame();
				frame.hide();
			}
		});

		for (String s : GUI.getSnips()) {
			model.addElement(s);
		}
		;

		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		btnNewButton.setBounds(221, 525, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear Snippets");
		btnClear.setBackground(new Color(216, 191, 216));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.clear();
				GUI.snipsToShow.clear();
			}
		});
		btnClear.setBounds(352, 525, 129, 21);
		frame.getContentPane().add(btnClear);
	}
}
