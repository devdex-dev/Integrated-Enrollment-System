package Design;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AdminLogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField_UserName;
	private JPasswordField textField_1_Password;

	/**
	 * Launch the application.
	 */
	public static void admin() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AdminLogIn frame = new AdminLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogIn() {
		setUndecorated(true);
		setTitle("Admin LogIn");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogIn.class.getResource("/source/LOGO.png")));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 450, 378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Enroll bk = new Enroll();
				bk.setVisible(true);
				bk.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		JLabel lblNewLabel_2_2 = new JLabel("ADMIN LOGIN");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 34));
		lblNewLabel_2_2.setBounds(26, 21, 398, 36);
		panel.add(lblNewLabel_2_2);
		btnBack.setName("");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
		btnBack.setFocusable(false);
		btnBack.setBorder(null);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(29, 330, 63, 24);
		panel.add(btnBack);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EXITprompt nw = new EXITprompt();
				nw.setVisible(true);
				nw.setLocationRelativeTo(null);
			}
		});
		btnExit.setName("");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
		btnExit.setFocusable(false);
		btnExit.setBorder(null);
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(361, 330, 63, 24);
		panel.add(btnExit);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String user = textField_UserName.getText();
				String pass = textField_1_Password.getText();
				if (user.equals("admin")&&pass.equals("admin123")) {
					AdminPage page = new AdminPage();
					page.setVisible(true);
					page.setLocationRelativeTo(null);
					dispose();
				}
				else {
					LogInErrorMessage err =  new LogInErrorMessage();
					err.setVisible(true);
					err.setLocationRelativeTo(null);
					dispose();
					
					}
				
			}
		});
		btnLogin.setName("");
		btnLogin.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		btnLogin.setFocusable(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(160, 255, 117, 36);
		panel.add(btnLogin);
		
		textField_1_Password = new JPasswordField();
		textField_1_Password.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField_1_Password.setColumns(10);
		textField_1_Password.setBorder(new LineBorder(Color.WHITE, 3, true));
		textField_1_Password.setBounds(107, 180, 220, 36);
		panel.add(textField_1_Password);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 145, 414, 36);
		panel.add(lblNewLabel_2_1);
		
		textField_UserName = new JTextField();
		textField_UserName.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField_UserName.setColumns(10);
		textField_UserName.setBorder(new LineBorder(Color.WHITE, 3, true));
		textField_UserName.setBounds(107, 103, 220, 36);
		panel.add(textField_UserName);
		
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 68, 414, 36);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminLogIn.class.getResource("/source/Cover4.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 450, 356);
		panel.add(lblNewLabel);
	}
}
