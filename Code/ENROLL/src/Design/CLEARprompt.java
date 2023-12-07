package Design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CLEARprompt extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void confirm() {
		try {
			CLEARprompt dialog = new CLEARprompt();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CLEARprompt() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CLEARprompt.class.getResource("/source/LOGO.png")));
		setTitle("CONFIRM");
		setBounds(100, 100, 328, 188);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 312, 148);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("ARE YOU SURE?");
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
				lblNewLabel_1.setBounds(70, 44, 166, 34);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(CLEARprompt.class.getResource("/source/Cover2.png")));
				lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(0, 0, 312, 120);
				panel.add(lblNewLabel);
			}
			{
				JButton okButton = new JButton("YES");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Enroll.textField_Fname.setText("");
						Enroll.textField_1_Lname.setText("");
						Enroll.textField_2_email.setText("");
						Enroll.textField_3_phone.setText("");
						Enroll.textField_5_address.setText("");
						Enroll.ComboSchool.setSelectedIndex(0);
						Enroll.ComboSex.setSelectedIndex(0);
					
						dispose();
					}
				});
				okButton.setFocusable(false);
				okButton.setBorder(null);
				okButton.setBackground(Color.WHITE);
				okButton.setBounds(63, 122, 87, 23);
				panel.add(okButton);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnNo = new JButton("NO");
				btnNo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnNo.setFocusable(false);
				btnNo.setBorder(null);
				btnNo.setBackground(Color.WHITE);
				btnNo.setActionCommand("CANCEL");
				btnNo.setBounds(160, 122, 87, 23);
				panel.add(btnNo);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
		}
	}

}
