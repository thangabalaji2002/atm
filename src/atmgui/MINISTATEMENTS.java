package atmgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MINISTATEMENTS {

	JFrame ministm;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MINISTATEMENTS window = new MINISTATEMENTS();
					window.ministm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MINISTATEMENTS() {
		initialize();
		
	}
	int accno=0;
	public MINISTATEMENTS(int a) {
		initialize();
		accno=a;
		Connection con1 =null;
		PreparedStatement pst1 =null;
		ResultSet rs =null;
		Statement st= null;
		String query="select * from transactiontbl" ;
		
		try {
			con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
			Statement st1 =con1.createStatement();
			ResultSet rs1 =st1.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs1));
			
	
			
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1);
		}
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ministm = new JFrame();
		ministm.setBounds(100, 100, 810, 438);
		ministm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ministm.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 785, 399);
		ministm.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 785, 106);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("CHINNASALEM BANK");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(306, 33, 228, 37);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("X");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1_1_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(751, 6, 24, 50);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("MINI STATEMENT");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		lblNewLabel_1.setBounds(313, 117, 203, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CHINNASALEM BANK");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(297, 357, 316, 42);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("BACK");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmmain a =new atmmain();
				a.atmmain.setVisible(true);
				ministm.dispose();
			}
		});
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(345, 312, 63, 50);
		panel.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 166, 743, 155);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
