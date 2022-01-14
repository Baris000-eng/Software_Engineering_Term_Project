package gui;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class CreateWorldPanel extends JPanel{
	private JTextField numOfSimpleObstacle;
	private JTextField numOfFirmObstacle;
	private JTextField numOfGiftObstacle;
	private JTextField numOfExplosiveObstacle;
	private JButton submitButton;
	private JLabel simpleObsLabel,giftObsLabel,firmObsLabel,explObsLabel;
	private JLabel simpleObsImg;
	private JLabel giftObsImg;
	private JLabel firmObsImg;
	private JLabel explObsImg;
	//private JLabel noblePhantasm;
	private JLabel editingArea;
	private JButton backButton;
	private JButton createButton;
	private JLabel imagePhantasm;
	private JButton goToGameButton;
	private String selectedObs="null";

	public CreateWorldPanel() {
		super();

		
		simpleObsImg= new JLabel(MainFrame.simpleIcon);
		giftObsImg= new JLabel(MainFrame.giftIcon);

		//JLabel numRequiredHits= new JLabel();
		//numRequiredHits.setText(""+FirmObstacle.getNumOfHitsRequiredToBeDestroyed());
		firmObsImg= new JLabel(MainFrame.firmIcon);
		explObsImg= new JLabel(MainFrame.explosiveIcon);

		ImageIcon my_icon= new ImageIcon("phantasm-rotated.png");
		Image image = my_icon.getImage().getScaledInstance(MainFrame.width/10,20,Image.SCALE_SMOOTH);
		my_icon = new ImageIcon(image);
		imagePhantasm= new JLabel(my_icon);

		backButton= new JButton();
		backButton.setText("Back");

		createButton= new JButton();
		createButton.setText("Create");

		goToGameButton= new JButton();
		goToGameButton.setText("Go to Game");

		editingArea= new JLabel();
		editingArea.setText("Editing Area For Player");
		editingArea.setFont(new Font("Verdana", Font.BOLD, 14));

		giftObsLabel= new JLabel();
		giftObsLabel.setText("Number of Gift Obstacles: ");

		simpleObsLabel= new JLabel();
		simpleObsLabel.setText("Number of Simple Obstacles:");

		firmObsLabel= new JLabel();
		firmObsLabel.setText("Number of Firm Obstacles: ");

		explObsLabel= new JLabel();
		explObsLabel.setText("Number of Explosive Obstacles: ");


		numOfSimpleObstacle= new JTextField("75");
		numOfFirmObstacle= new JTextField("10");
		numOfGiftObstacle= new JTextField("10");
		numOfExplosiveObstacle= new JTextField("5");


		simpleObsImg.setBounds(MainFrame.width-MainFrame.widthButton/2-210-MainFrame.width/50,MainFrame.heightButton/2+15,MainFrame.width/50,20);
		giftObsImg.setBounds(MainFrame.width-MainFrame.widthButton/2-210-MainFrame.width/50,3*MainFrame.heightButton/2+15,MainFrame.width/50,20);
		firmObsImg.setBounds(MainFrame.width-MainFrame.widthButton/2-210-MainFrame.width/50,5*MainFrame.heightButton/2+15,MainFrame.width/50,20);
		//numRequiredHits.setBounds(MainFrame.width-MainFrame.widthButton/2-198-MainFrame.width/50,5*MainFrame.heightButton/2+13,MainFrame.width/50,20);
		explObsImg.setBounds(MainFrame.width-MainFrame.widthButton/2-210-MainFrame.width/50,7*MainFrame.heightButton/2+15,MainFrame.width/50,20);

		simpleObsLabel.setBounds(MainFrame.width-MainFrame.widthButton/2-200,  MainFrame.heightButton/2+MainFrame.heightButton/2-15/2,200,15);
		giftObsLabel.setBounds  (MainFrame.width-MainFrame.widthButton/2-200,3*MainFrame.heightButton/2+MainFrame.heightButton/2-15/2,200,15);
		firmObsLabel.setBounds  (MainFrame.width-MainFrame.widthButton/2-200,5*MainFrame.heightButton/2+MainFrame.heightButton/2-15/2,200,15);
		explObsLabel.setBounds  (MainFrame.width-MainFrame.widthButton/2-200,7*MainFrame.heightButton/2+MainFrame.heightButton/2-15/2,200,15);

		numOfSimpleObstacle.setBounds(MainFrame.width-MainFrame.widthButton/2,MainFrame.heightButton/2,MainFrame.widthButton/3,MainFrame.heightButton);
		numOfGiftObstacle.setBounds(MainFrame.width-MainFrame.widthButton/2,3*MainFrame.heightButton/2,MainFrame.widthButton/3,MainFrame.heightButton);
		numOfFirmObstacle.setBounds(MainFrame.width-MainFrame.widthButton/2,5*MainFrame.heightButton/2,MainFrame.widthButton/3,MainFrame.heightButton);
		numOfExplosiveObstacle.setBounds(MainFrame.width-MainFrame.widthButton/2,7*MainFrame.heightButton/2,MainFrame.widthButton/3,MainFrame.heightButton);

		imagePhantasm.setBounds(19*MainFrame.width/40-MainFrame.width/100,8*MainFrame.height/10,MainFrame.width/10,20);

		editingArea.setBounds(500,500,300,300);

		backButton.setBounds(MainFrame.width-3*MainFrame.widthButton/3*2-10,11*MainFrame.heightButton/2,MainFrame.widthButton/3*2,MainFrame.heightButton);
		createButton.setBounds(MainFrame.width-2*MainFrame.widthButton/3*2-10,11*MainFrame.heightButton/2,MainFrame.widthButton/3*2,MainFrame.heightButton);
		goToGameButton.setBounds(MainFrame.width-MainFrame.widthButton/3*2-10,11*MainFrame.heightButton/2,MainFrame.widthButton/3*2,MainFrame.heightButton);

       
		
	
		
		this.add(simpleObsImg);
		this.add(giftObsImg);
		//this.add(numRequiredHits);
		this.add(firmObsImg);
		//firmObsImg.add(numRequiredHits);
		this.add(explObsImg);
       
		
		simpleObsImg.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				selectedObs="simpleObstacle";
			}
		});

		firmObsImg.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				selectedObs="firmObstacle";
			}
		});

		explObsImg.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				selectedObs="explosiveObstacle";
			}
		});

		giftObsImg.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				selectedObs="giftObstacle";
			}
		});

		
		this.add(imagePhantasm);

		this.add(simpleObsLabel);
		this.add(giftObsLabel);
		this.add(firmObsLabel);
		this.add(explObsLabel);

		this.add(numOfSimpleObstacle);
		this.add(numOfFirmObstacle);
		this.add(numOfGiftObstacle);
		this.add(numOfExplosiveObstacle);

		this.add(backButton);
		this.add(createButton);
		this.add(goToGameButton);

		this.add(editingArea);

		//this.setBackground(Color.BLUE);
		this.setLayout(null);

	}
	
	
	
	

	


	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		this.backButton = createButton;
	}

	public JButton getGoToGameButton() {
		return goToGameButton;
	}

	public JTextField getNumOfSimpleObstacle() {
		return numOfSimpleObstacle;
	}

	public void setNumOfSimpleObstacle(JTextField numOfSimpleObstacle) {
		this.numOfSimpleObstacle = numOfSimpleObstacle;
	}

	public  JTextField getNumOfFirmObstacle() {
		return numOfFirmObstacle;
	}

	public void setNumOfFirmObstacle(JTextField numOfFirmObstacle) {
		this.numOfFirmObstacle = numOfFirmObstacle;
	}

	public JTextField getNumOfGiftObstacle() {
		return numOfGiftObstacle;
	}

	public void setNumOfGiftObstacle(JTextField numOfGiftObstacle) {
		this.numOfGiftObstacle = numOfGiftObstacle;
	}

	public JTextField getNumOfExplosiveObstacle() {
		return numOfExplosiveObstacle;
	}

	public void setNumOfExplosiveObstacle(JTextField numOfExplosiveObstacle) {
		this.numOfExplosiveObstacle = numOfExplosiveObstacle;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(JButton submitButton) {
		this.submitButton = submitButton;
	}

	public JLabel getSimpleObsLabel() {
		return simpleObsLabel;
	}

	public void setSimpleObsLabel(JLabel simpleObsLabel) {
		this.simpleObsLabel = simpleObsLabel;
	}

	public JLabel getGiftObsLabel() {
		return giftObsLabel;
	}

	public void setGiftObsLabel(JLabel giftObsLabel) {
		this.giftObsLabel = giftObsLabel;
	}

	public JLabel getFirmObsLabel() {
		return firmObsLabel;
	}

	public void setFirmObsLabel(JLabel firmObsLabel) {
		this.firmObsLabel = firmObsLabel;
	}

	public JLabel getExplObsLabel() {
		return explObsLabel;

	}
	
	public void setExplObsLabel(JLabel explObsLabel) {
		this.explObsLabel = explObsLabel;
	}
	
	public void setGoToGameButton(JButton goToGameButton) {
		this.goToGameButton = goToGameButton;
	}
	public void setSelectedObs(String selectedObs) {
		this.selectedObs = selectedObs;
	}

	public String getSelectedObs() {
		return selectedObs;
	}


}
