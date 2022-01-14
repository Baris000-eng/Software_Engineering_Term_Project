package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CreateOrLoadOrCustomizePanel extends JPanel{
	private JButton createButton;
	private JButton loadButton;
	private JButton customizeButton;
	private JButton logOutButton;


	public  CreateOrLoadOrCustomizePanel() {
		super();
		createButton= new JButton();
		loadButton= new JButton();
		customizeButton= new JButton();
		logOutButton= new JButton();

		createButton.setText("Create Game");
		loadButton.setText("Load Game");
		customizeButton.setText("Customize Game");
		logOutButton.setText("Log Out");


		createButton.setBounds(MainFrame.middleX,MainFrame.middleY-2*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		loadButton.setBounds(MainFrame.middleX,MainFrame.middleY-MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		customizeButton.setBounds(MainFrame.middleX,MainFrame.middleY,MainFrame.widthButton,MainFrame.heightButton);
		logOutButton.setBounds(MainFrame.middleX,MainFrame.middleY+MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);


		this.add(createButton);
		this.add(loadButton);
		this.add(customizeButton);
		this.add(logOutButton);

		//this.setSize(900,900);
		this.setBackground(Color.BLUE);
		this.setLayout(null);
	}

	public JButton getLogOutButton() {
		return logOutButton;
	}

	public void setBackButton(JButton logOutButton) {
		this.logOutButton=logOutButton;
	}

	public  JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		this.createButton = createButton;
	}

	public  JButton getLoadButton() {
		return loadButton;
	}

	public void setLoadButton(JButton loadButton) {
		this.loadButton = loadButton;
	}

	public  JButton getCustomizeButton() {
		return customizeButton;
	}

	public void setCustomizeButton(JButton customizeButton) {
		this.customizeButton = customizeButton;
	}

}