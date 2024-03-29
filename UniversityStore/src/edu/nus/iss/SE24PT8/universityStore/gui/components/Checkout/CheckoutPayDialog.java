package edu.nus.iss.SE24PT8.universityStore.gui.components.Checkout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import edu.nus.iss.SE24PT8.universityStore.gui.framework.SubjectManager;
import edu.nus.iss.SE24PT8.universityStore.gui.mainWindow.MainWindow;

/**
* CheckoutPayDialog for final payment gui
* 
* @author Zehua
*/
public class CheckoutPayDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTotal;
	private JFormattedTextField textFieldPayment;
	private JTextField textFieldBalance;
	private JButton btnOkay;

	private double totalAmount, payAmount, balanceAmount;
	
	public void reset() {
		setVisible(false);
		totalAmount = 0;
		payAmount = 0;
		balanceAmount = 0;
	}
	public void show(double total) {
		totalAmount = total;
		textFieldTotal.setText(formatDecimal(totalAmount));
		textFieldPayment.setText(formatDecimal(totalAmount));
		setLocationRelativeTo(MainWindow.getInstance());
		setVisible(true);
	}
	
	private void UpdateBalance(double pay) {
		payAmount = pay;
		balanceAmount = totalAmount - payAmount;
		if (balanceAmount > -0.01f && balanceAmount < 0.01f) balanceAmount= 0.00f;
		if (textFieldBalance != null) textFieldBalance.setText(formatDecimal(balanceAmount));
		if (btnOkay != null) btnOkay.setEnabled(balanceAmount <= 0.01f);
	}
	private String formatDecimal(double value) {
		DecimalFormat df = new DecimalFormat("##0.00"); 
		return df.format(value); 
	}
	/**
	 * Create the frame.
	 */
	public CheckoutPayDialog() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Payment");
		setBounds(100, 100, 396, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Total:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		textFieldTotal = new JTextField();
		textFieldTotal.setText("0");
		textFieldTotal.setEditable(false);
		textFieldTotal.setFont(new Font("Tahoma", Font.BOLD, 26));
		textFieldTotal.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Payment: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		NumberFormat format2 = NumberFormat.getNumberInstance();
		NumberFormatter formater2 = new NumberFormatter(format2);
		textFieldPayment = new JFormattedTextField(formater2);
		textFieldPayment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String payment = textFieldPayment.getText();
				if (payment == null || payment.isEmpty()) return;
				double pay = Double.valueOf(payment);
				UpdateBalance(pay);		
			}
		});
		textFieldPayment.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				String payment = textFieldPayment.getText();
				if (payment == null || payment.isEmpty()) return;
				double pay = Double.valueOf(payment);
				UpdateBalance(pay);				
			}
		});
		textFieldPayment.setText("0");
		textFieldPayment.setFont(new Font("Tahoma", Font.BOLD, 26));
		textFieldPayment.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Balance:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		textFieldBalance = new JTextField();
		textFieldBalance.setText("0");
		textFieldBalance.setEditable(false);
		textFieldBalance.setFont(new Font("Tahoma", Font.BOLD, 26));
		textFieldBalance.setColumns(10);
		
		btnOkay = new JButton("Confirm");
		btnOkay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectManager.getInstance().Update("CheckOutPanel", "Payment", "Done");
			}
		});
		btnOkay.setEnabled(false);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectManager.getInstance().Update("CheckOutPanel", "Payment", "Cancel");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldBalance, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
								.addComponent(textFieldPayment, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
								.addComponent(textFieldTotal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(btnOkay)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textFieldPayment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldBalance, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, Alignment.TRAILING))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOkay))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
