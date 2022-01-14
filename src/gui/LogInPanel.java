package gui;

import java.awt.Color;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LogInPanel extends JPanel{
	private JButton logInSubmitButton;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JButton backButton;

	public LogInPanel() {
		super();
		logInSubmitButton= new JButton();
		backButton= new JButton();
		userLabel= new JLabel();
		passwordLabel= new JLabel();
		userNameTextField= new JTextField(20);
		passwordTextField= new JPasswordField();

		
		backButton.setText("Back");
		userLabel.setText("Username:");
		userLabel.setBounds(MainFrame.middleX-MainFrame.widthButton*1/2,MainFrame.middleY-2*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		userNameTextField.setBounds(MainFrame.middleX+MainFrame.widthButton*1/2,MainFrame.middleY-2*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		backButton.setBounds(MainFrame.middleX-MainFrame.widthButton*1/2,MainFrame.middleY,MainFrame.widthButton,MainFrame.heightButton);

		passwordLabel.setBounds(MainFrame.middleX-MainFrame.widthButton*1/2,MainFrame.middleY-MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		passwordLabel.setText("Password:");
		passwordTextField.setBounds(MainFrame.middleX+MainFrame.widthButton*1/2,MainFrame.middleY-MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);

		logInSubmitButton.setBounds(MainFrame.middleX+MainFrame.widthButton*1/2,MainFrame.middleY,MainFrame.widthButton,MainFrame.heightButton);
		logInSubmitButton.setText("Login");


		this.add(logInSubmitButton);
		this.add(userLabel);
		this.add(passwordLabel);
		this.add(userNameTextField);
		this.add(passwordTextField);
		this.add(backButton);


		//this.setSize(500,400);
		//this.setBackground(Color.CYAN);
		this.setLayout(null);
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JButton getLogInSubmitButton() {
		return logInSubmitButton;
	}

	public void setLogInSubmitButton(JButton logInSubmitButton) {
		this.logInSubmitButton = logInSubmitButton;
	}

	public JLabel getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JTextField getUserNameTextField() {
		return userNameTextField;
	}

	public void setUserNameTextField(JTextField userNameTextField) {
		this.userNameTextField = userNameTextField;
	}

	public JTextField getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(JTextField passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

}