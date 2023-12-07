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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.BorderLayout;

public class LogInErrorMessage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void errorMessage() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LogInErrorMessage frame = new LogInErrorMessage();
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
	public LogInErrorMessage() {
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInErrorMessage.class.getResource("/source/LOGO.png")));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 315, 152);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("USERNAME/PASSWORD INCORRECT");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Alte DIN 1451 Mittelschrift", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(70, 48, 170, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel(" LOGIN FAILED!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		lblNewLabel_1.setBounds(70, 29, 170, 34);
		panel.add(lblNewLabel_1);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 117, 305, 35);
		panel.add(buttonPane);
		
		JButton okButton = new JButton("RETRY");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogIn ad = new AdminLogIn();
				ad.setVisible(true);
				ad.setLocationRelativeTo(null);
				dispose();
			}
		});
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		okButton.setFocusable(false);
		okButton.setBackground(Color.WHITE);
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LogInErrorMessage.class.getResource("/source/Cover2.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 305, 117);
		panel.add(lblNewLabel);
	}
}
