package Design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalityType;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnrollSuccess extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void notice() {
		try {
			EnrollSuccess dialog = new EnrollSuccess();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EnrollSuccess() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EnrollSuccess.class.getResource("/source/LOGO.png")));
		setBounds(100, 100, 328, 189);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 312, 117);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("OFFICIALLY ENROLLED.");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Alte DIN 1451 Mittelschrift", Font.BOLD, 10));
		lblNewLabel_1_1_1.setBounds(97, 67, 125, 34);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("WE'LL CONTACT YOU WHEN YOU ARE");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Alte DIN 1451 Mittelschrift", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(65, 49, 177, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("APPLICATION SENT!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		lblNewLabel_1.setBounds(48, 22, 229, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EnrollSuccess.class.getResource("/source/Cover2.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 312, 117);
		panel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFocusable(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
