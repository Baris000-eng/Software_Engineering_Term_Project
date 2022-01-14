package gui;

import java.awt.Color;
import java.awt.*;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegisterPanel extends JPanel{

	private JButton registerSubmitButton;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JButton backButton;

	public RegisterPanel() {
		super();
		registerSubmitButton= new JButton();
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

		registerSubmitButton.setBounds(MainFrame.middleX+MainFrame.widthButton*1/2,MainFrame.middleY,MainFrame.widthButton,MainFrame.heightButton);
		registerSubmitButton.setText("Register");
		
		this.add(userLabel);
		this.add(userNameTextField);
		this.add(passwordLabel);
		this.add(passwordTextField);
		this.add(registerSubmitButton);
		this.add(backButton);

		this.setLayout(null);
		//this.setBackground(Color.BLUE);

	}


	public JButton getBackButton() {
		return backButton;
	}


	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}


	public void setRegisterSubmitButton(JButton registerSubmitButton) {
		this.registerSubmitButton = registerSubmitButton;
	}


	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}


	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}


	public void setUserNameTextField(JTextField userNameTextField) {
		this.userNameTextField = userNameTextField;
	}


	public void setPasswordTextField(JPasswordField passwordTextField) {
		this.passwordTextField = passwordTextField;
	}


	public JButton getRegisterSubmitButton() {
		return registerSubmitButton;
	}


	public JLabel getUserLabel() {
		return userLabel;
	}


	public  JLabel getPasswordLabel() {
		return passwordLabel;
	}


	public  JTextField getUserNameTextField() {
		return userNameTextField;
	}


	public  JPasswordField getPasswordTextField() {
		return passwordTextField;
	}



}