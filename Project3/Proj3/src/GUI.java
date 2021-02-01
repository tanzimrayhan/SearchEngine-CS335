import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI {

	private static JFrame frame;
	private JTextField tFldQuery;

	private static HashMap<String, WordDetails> index;
	private static ArrayList<Snippet> snips = new ArrayList<>();
	public static ArrayList<String> snipsToShow = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		index = SearchEngine.invertedIndex;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 712, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 708, 479);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		tFldQuery = new JTextField();
		tFldQuery.setBounds(10, 32, 460, 32);
		panel.add(tFldQuery);
		tFldQuery.setColumns(10);

		JButton btnSearch = new JButton("Search");
		DefaultListModel model = new DefaultListModel<>();

		JList list = new JList(model);
		list.setBackground(SystemColor.inactiveCaption);
		list.setBounds(10, 115, 611, 314);

		JButton btnShowSnippets = new JButton("Show Snippets");
		btnShowSnippets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] argv = {};
				SnippetGUI.main(argv);
				frame.hide();
			}
		});
		btnShowSnippets.setEnabled(false);
		btnShowSnippets.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowSnippets.setBounds(582, 31, 116, 30);
		panel.add(btnShowSnippets);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				System.out.println(tFldQuery.getText());
				Query q = new Query(index, tFldQuery.getText());
				snips = q.getSnippets();

				SearchEngine.GUIHelper(snips);
				snipsToShow = WriteSnippets.snippetsToShow;

				DefaultListModel<String> modelq = q.getListModel();
				System.out.println(modelq.getSize());
				if (modelq.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Word " + tFldQuery.getText() + "Not Found", "InfoBox: ",
							JOptionPane.INFORMATION_MESSAGE);
				}
				for (int i = 0; i < modelq.getSize(); i++) {
					model.addElement(modelq.getElementAt(i));
				}
				if (!modelq.isEmpty()) {
					btnShowSnippets.setEnabled(true);
				}

			}
		});

		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(480, 29, 85, 32);
		panel.add(btnSearch);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Stemming");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(276, 68, 110, 21);
		panel.add(chckbxNewCheckBox);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 95, 688, 334);
		panel.add(scrollPane);

	}

	public static void setFrame() {
		frame.show();
	}

	public static ArrayList<String> getSnips() {
		return snipsToShow;
	}
}
