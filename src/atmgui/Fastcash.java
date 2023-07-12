package atmgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fastcash {

	JFrame fastcash;
	private JTextField fastbalance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fastcash window = new Fastcash();
					window.fastcash.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	int acno = 0;
	int oldbalance = 0;

	public Fastcash() {
		initialize();
	}

	public Fastcash(int b) {

		initialize();
		acno = b;
		getbalance();
		fastbalance.setText(String.valueOf(oldbalance));
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void getbalance() {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st = null;
		String query = "select balance from atmtbl where accnum = " + acno + "";

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/atmdb", "root", "");
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(query);
			if (rs1.next()) {
				oldbalance = rs1.getInt(1);

			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
	}

	private void initialize() {
		fastcash = new JFrame();
		fastcash.setBounds(100, 100, 833, 444);
		fastcash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fastcash.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 785, 391);
		fastcash.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 775, 106);
		panel.add(panel_1);

		JLabel lblNewLabel = new JLabel("CHINNASALEM BANK");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(286, 11, 228, 37);
		panel_1.add(lblNewLabel);

		JLabel lblSelec = new JLabel("Select Your Transaction Please");
		lblSelec.setForeground(new Color(240, 248, 255));
		lblSelec.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSelec.setBounds(235, 58, 316, 37);
		panel_1.add(lblSelec);

		JLabel lblNewLabel_1_1_1 = new JLabel("X");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmmain main =new atmmain();
				main.atmmain.setVisible(true);
				
				fastcash.dispose();
			}
		});
		lblNewLabel_1_1_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(751, 6, 24, 50);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1 = new JLabel("FAST CASH");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		lblNewLabel_1.setBounds(315, 134, 203, 50);
		panel.add(lblNewLabel_1);

		JButton btnRs100 = new JButton("RS 100");
		btnRs100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (oldbalance>100) {
				Connection con1 = null;
				PreparedStatement pst1 = null;
				ResultSet rs = null;
				Statement st = null;
				String query = "update atmtbl set balance =? where accnum=?";
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb", "root", "");
					PreparedStatement pst11 = con1.prepareStatement(query);
					pst11.setInt(1, oldbalance - 100);
					pst11.setInt(2, acno);
					int n = pst11.executeUpdate();
					if (n == 1) {
						JOptionPane.showMessageDialog(null, "amount withdrawn");
						System.exit(1);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}

				} else {
					JOptionPane.showMessageDialog(null, "insufficient balance");
				}
				}
		});
		btnRs100.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRs100.setBounds(63, 199, 152, 23);
		panel.add(btnRs100);

		JButton btnRs_500 = new JButton("RS 500");
		btnRs_500.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(oldbalance>500) {
				Connection con1 = null;
				PreparedStatement pst1 = null;
				ResultSet rs = null;
				Statement st = null;
				String query = "update atmtbl set balance =? where accnum=?";
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb", "root", "");
					PreparedStatement pst11 = con1.prepareStatement(query);
					pst11.setInt(1, oldbalance - 500);
					pst11.setInt(2, acno);
					int n = pst11.executeUpdate();
					if (n == 1) {
						JOptionPane.showMessageDialog(null, "amount withdrawn");
						System.exit(1);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
				else {
						JOptionPane.showMessageDialog(null, "insufficient balance");
					}}
		});
		btnRs_500.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRs_500.setBounds(564, 199, 138, 23);
		panel.add(btnRs_500);

		JButton btnRs_2000 = new JButton("RS 2000");
		btnRs_2000.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(oldbalance>2000) {
				Connection con1 = null;
				PreparedStatement pst1 = null;
				ResultSet rs = null;
				Statement st = null;
				String query = "update atmtbl set balance =? where accnum=?";
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb", "root", "");
					PreparedStatement pst11 = con1.prepareStatement(query);
					pst11.setInt(1, oldbalance - 2000);
					pst11.setInt(2, acno);
					int n = pst11.executeUpdate();
					if (n == 1) {
						JOptionPane.showMessageDialog(null, "amount withdrawn");
						System.exit(1);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
				 else {
						JOptionPane.showMessageDialog(null, "insufficient balance");
					}}
		});
		btnRs_2000.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRs_2000.setBounds(564, 268, 138, 23);
		panel.add(btnRs_2000);

		JButton btnRs_1000 = new JButton("RS 1000");
		btnRs_1000.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (oldbalance>1000) {
				Connection con1 = null;
				PreparedStatement pst1 = null;
				ResultSet rs = null;
				Statement st = null;
				String query = "update atmtbl set balance =? where accnum=?";
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb", "root", "");
					PreparedStatement pst11 = con1.prepareStatement(query);
					pst11.setInt(1, oldbalance - 1000);
					pst11.setInt(2, acno);
					int n = pst11.executeUpdate();
					if (n == 1) {
						JOptionPane.showMessageDialog(null, "amount withdrawn");
						System.exit(1);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			} else {
				JOptionPane.showMessageDialog(null, "insufficient balance");
			}}
		});
		btnRs_1000.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRs_1000.setBounds(63, 268, 152, 23);
		panel.add(btnRs_1000);

		JButton btnRs_5000 = new JButton("RS 5000");
		btnRs_5000.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(oldbalance>5000) {
				Connection con1 = null;
				PreparedStatement pst1 = null;
				ResultSet rs = null;
				Statement st = null;
				String query = "update atmtbl set balance =? where accnum=?";
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb", "root", "");
					PreparedStatement pst11 = con1.prepareStatement(query);
					pst11.setInt(1, oldbalance - 5000);
					pst11.setInt(2, acno);
					int n = pst11.executeUpdate();
					if (n == 1) {
						JOptionPane.showMessageDialog(null, "amount withdrawn");
						System.exit(1);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
				 else {
						JOptionPane.showMessageDialog(null, "insufficient balance");
					}}

		});
		btnRs_5000.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRs_5000.setBounds(63, 328, 152, 23);
		panel.add(btnRs_5000);

		JButton btnRs_10000 = new JButton("RS 10000");
		btnRs_10000.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (oldbalance > 10000) {
					Connection con1 = null;
					PreparedStatement pst1 = null;
					ResultSet rs = null;
					Statement st = null;
					String query = "update atmtbl set balance =? where accnum=?";
					try {
						con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb", "root", "");
						PreparedStatement pst11 = con1.prepareStatement(query);
						pst11.setInt(1, oldbalance - 10000);
						pst11.setInt(2, acno);
						int n = pst11.executeUpdate();
						if (n == 1) {
							JOptionPane.showMessageDialog(null, "amount withdrawn");
							System.exit(1);
						}

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1);
					}
				} else {
					JOptionPane.showMessageDialog(null, "insufficient balance");
				}
			}

		});
		btnRs_10000.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRs_10000.setBounds(564, 328, 138, 23);
		panel.add(btnRs_10000);

		JLabel lblNewLabel_2 = new JLabel("CHINNASALEM BANK");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(297, 349, 316, 42);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("LOG OUT");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmmain a =new atmmain();
				a.atmmain.setVisible(true);
				fastcash.dispose();
			}
		});
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(351, 312, 203, 50);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("balance");
		lblNewLabel_1_2.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(335, 195, 203, 50);
		panel.add(lblNewLabel_1_2);

		fastbalance = new JTextField();
		fastbalance.setBounds(330, 255, 86, 20);
		panel.add(fastbalance);
		fastbalance.setColumns(10);
	}
}
