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

public class EnrollFailed extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void notice() {
		try {
			EnrollFailed dialog = new EnrollFailed();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EnrollFailed() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EnrollFailed.class.getResource("/source/LOGO.png")));
		setBounds(100, 100, 328, 189);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 312, 117);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("PLEASE FILL COMPLETELY TO APPLY FOR ENROLLMENT.");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Alte DIN 1451 Mittelschrift", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(23, 50, 268, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("NO DATA ENTERED");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		lblNewLabel_1.setBounds(48, 22, 215, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EnrollFailed.class.getResource("/source/Cover2.png")));
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
