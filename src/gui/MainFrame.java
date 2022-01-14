package gui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import domain.game.Game;
import domain.game.NeedForSpearGame;
import domain.player.Player;
//import domain.txtUsernamePassword.DatabaseConnection;

public class MainFrame{

	//public boolean is_username_matching;
	public static JFrame frame= new JFrame();
	//private static JLabel imagePhantasm= runningGame.getImagePhantasm();
	static private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static public int width=screenSize.width;
	static public int height=screenSize.height;
	static public int widthButton=MainFrame.width/10;
	static public int heightButton=MainFrame.height/20;
	static public int middleX=(MainFrame.width-widthButton)/2;
	static public int middleY=(MainFrame.height-heightButton)/2;
	static int pauseReply;
	public static RegisterPanel registerPanel ;
	public static OpeningPanel openingPanel;
	public static LogInPanel logInPanel;
	public static CreateOrLoadOrCustomizePanel createOrLoadOrCustomizePanel;
	public static CustomizeGamePanel customizeGamePanel;
	public static CreateWorldPanel createWorldPanel;
	public static RunningGamePanel runningGamePanel;
	public static int simpleObstacleNumber;
	public static int firmObstacleNumber;
	public static int giftObstacleNumber;
	public static int explosiveObstacleNumber;
	private static int locX;
	private static int locY;
	private static JLabel numHits;
	private static int hitNum;
	public static int getHitNum() {
		return hitNum;
	}


	public static void setHitNum(int hitNum) {
		MainFrame.hitNum = hitNum;
	}


	public static ArrayList<JLabel>numHitsArrayList= new ArrayList<JLabel>();

	private static int locXa;
	private static int locYa;
	static boolean isCreateButtonPressed=false;
	private static NeedForSpearGame controller = new NeedForSpearGame();
	private static int myArray[][]=new int [39][15];

	static ImageIcon simpleIcon1= new ImageIcon("simple_obstacle_cropped.png");
	static Image simpleIm = simpleIcon1.getImage().getScaledInstance(MainFrame.width/50,20,Image.SCALE_SMOOTH);
	static ImageIcon simpleIcon = new ImageIcon(simpleIm);

	static ImageIcon firmIcon1= new ImageIcon("firm_obstacle_cropped.png");
	static Image firmIm = firmIcon1.getImage().getScaledInstance(MainFrame.width/50,20,Image.SCALE_SMOOTH);
	static ImageIcon firmIcon = new ImageIcon(firmIm);

	static ImageIcon giftIcon1= new ImageIcon("gift_obstacle_cropped.png");
	static Image giftIm = giftIcon1.getImage().getScaledInstance(MainFrame.width/50,20,Image.SCALE_SMOOTH);
	static ImageIcon giftIcon = new ImageIcon(giftIm);

	static ImageIcon explosiveIcon1= new ImageIcon("explosive_obstacle_cropped.png");
	static Image explosiveIm = explosiveIcon1.getImage().getScaledInstance(MainFrame.width/50,20,Image.SCALE_SMOOTH);
	static ImageIcon explosiveIcon = new ImageIcon(explosiveIm);

	static ArrayList<JLabel> obstacles=new ArrayList<JLabel>();

	static boolean isPaused=true;

	public static void main(String[] args) throws IOException {

		//create frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);      

		frame.setLayout(null);
		// GridBagConstraints gbc = new GridBagConstraints();
		//  gbc.gridwidth = GridBagConstraints.REMAINDER;
		//  gbc.fill = GridBagConstraints.VERTICAL;

		//add panels
		openingPanel = new OpeningPanel();
		openingPanel.setVisible(true);
		openingPanel.setSize(width, height);
		frame.add(openingPanel);

		registerPanel = new RegisterPanel();
		registerPanel.setVisible(false);
		registerPanel.setSize(width, height);
		frame.add(registerPanel);

		logInPanel = new LogInPanel();
		logInPanel.setVisible(false);
		logInPanel.setSize(width, height);
		frame.add(logInPanel);

		createOrLoadOrCustomizePanel= new CreateOrLoadOrCustomizePanel();
		createOrLoadOrCustomizePanel.setVisible(false);
		createOrLoadOrCustomizePanel.setSize(width, height);
		frame.add(createOrLoadOrCustomizePanel);

		customizeGamePanel= new CustomizeGamePanel();
		customizeGamePanel.setSize(width, height);
		customizeGamePanel.setVisible(false);
		frame.add(customizeGamePanel);

		createWorldPanel= new CreateWorldPanel();
		createWorldPanel.setVisible(false);
		createWorldPanel.setSize(width,  height);
		frame.add(createWorldPanel);

		runningGamePanel= new RunningGamePanel();
		runningGamePanel.setVisible(false);
		runningGamePanel.setSize(width, height);
		frame.add(runningGamePanel);

		frame.setVisible(true);


		/*BufferedImage bf1 = null;
		try {
			bf1 = ImageIO.read(
					new File("phantasm-rotated.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//BufferedImage bf2= rotate1(bf1);

		ImageIcon my_icon= new ImageIcon(bf1);

		Image image = my_icon.getImage().getScaledInstance(MainFrame.width/10,20,Image.SCALE_SMOOTH);

		//my_icon = new ImageIcon(image);
		ImageIcon noblePhantasm = new ImageIcon(image);
		JLabel imagePhantasm = new JLabel(noblePhantasm);
		imagePhantasm.setBounds(19*MainFrame.width/40-MainFrame.width/100,8*MainFrame.height/10,MainFrame.width/10,20);
		imagePhantasm.setIcon(noblePhantasm);

		//NoblePhantasm imagePhantasm = runningGamePanel.getImagePhantasm();
		imagePhantasm.setVisible(true);
		imagePhantasm.setFocusable(true);

		runningGamePanel.requestFocus();
		runningGamePanel.addKeyListener(new KeyAdapter() 
		{

			public void keyPressed(KeyEvent k)
			{
				if(k.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					if(imagePhantasm.getX()<width-width/10) {
						try {
							imagePhantasm.setLocation(imagePhantasm.getX()+width/20, imagePhantasm.getY());
							Thread.sleep(1);
							imagePhantasm.repaint();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else if(k.getKeyCode()==KeyEvent.VK_LEFT) {

					if(imagePhantasm.getX()>0) {
						try {
							imagePhantasm.setLocation(imagePhantasm.getX()-width/20, imagePhantasm.getY());
							Thread.sleep(1);
							imagePhantasm.repaint();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}}
		});

		runningGamePanel.add(imagePhantasm);

		//END OF MOVING THE NOBLE PHANTASM	*/


		/////////////////// OPENING PANEL ///////////////////
		openingPanel.getLogInButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openingPanel.setVisible(false);
				logInPanel.setVisible(true);
			}
		});
		openingPanel.getRegisterButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openingPanel.setVisible(false);
				registerPanel.setVisible(true);
			}
		});
		openingPanel.getGuideButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea textArea = new JTextArea(45, 115);
				textArea.setText(openingPanel.getGuideMessage().getToolTipText());
				textArea.setEditable(false);
				JScrollPane sPane = new JScrollPane(textArea);
				JOptionPane.showMessageDialog(frame, sPane, "Guide", JOptionPane.PLAIN_MESSAGE);
			}
		});


		/////////////////// REGISTER PANEL ///////////////////
		registerPanel.getRegisterSubmitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String username= registerPanel.getUserNameTextField().getText();
				String password= registerPanel.getPasswordTextField().getText();
				if(username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(registerPanel ,"Please provide username and password to register to the game.");
				}
				else if(controller.usernameExist(username) == false) {
					controller.addUser(username, password);
					controller.setCurrentPlayer(controller.createPlayer(username));
					JOptionPane.showMessageDialog(registerPanel ,"You have successfully registered"); 
					registerPanel.setVisible(false);
					createOrLoadOrCustomizePanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(registerPanel ,"Username already taken. Please enter another username.");
				}

			}
		});

		registerPanel.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerPanel.setVisible(false);
				openingPanel.setVisible(true);
			}
		});

		/////////////////// LOGIN PANEL ///////////////////

		logInPanel.getLogInSubmitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username= logInPanel.getUserNameTextField().getText();
				String password= logInPanel.getPasswordTextField().getText();
				if(username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(logInPanel ,"Please provide username and password to login to the game.");
				} else if(controller.userExist(username, password)==true) {
					controller.setCurrentPlayer(controller.createPlayer(username));
					JOptionPane.showMessageDialog(logInPanel ,"You have successfully logged in."); 
					logInPanel.setVisible(false);
					createOrLoadOrCustomizePanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(logInPanel ,"Wrong username or password.\nIf you have not registered yet, please register first.");
				}
			}
		});

		logInPanel.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logInPanel.setVisible(false);
				openingPanel.setVisible(true);
			}
		});


		/////////////////// CREATE OR LOAD OR CUSTOMIZE PANEL ///////////////////

		createOrLoadOrCustomizePanel.getCustomizeButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOrLoadOrCustomizePanel.setVisible(false);
				customizeGamePanel.setVisible(true);
			}
		});

		createOrLoadOrCustomizePanel.getCreateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOrLoadOrCustomizePanel.setVisible(false);
				createWorldPanel.setVisible(true);
			}
		});

		createOrLoadOrCustomizePanel.getLogOutButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOrLoadOrCustomizePanel.setVisible(false);
				openingPanel.setVisible(true);
				Game.currentPlayerUsername=null;

			}
		});

		createOrLoadOrCustomizePanel.getLoadButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<ArrayList> gamesList=controller.loadGame();
					int gameCount=gamesList.size();
					if(gamesList.get(0).size()==0) {
						JOptionPane.showMessageDialog(createOrLoadOrCustomizePanel, "You do not have any saved game.");
					} else {
						String gameNames="Your saved games: Please enter the number of game you want to load:\n";
						for(int i=0; i<gameCount; i++) {
							gameNames+=(i+1);
							gameNames+=": " +gamesList.get(i).get(2);
							gameNames+="\n";
						}

						String choosedGame=JOptionPane.showInputDialog(gameNames);
						//RunningGamePanel newpanel=
						loadSavedGame(controller.getCurrentPlayer().getUsername(), gamesList.get(Integer.parseInt(choosedGame)-1));
						createOrLoadOrCustomizePanel.setVisible(false);
						runningGamePanel.setVisible(true);
						//frame.add(newpanel);
						//newpanel.setVisible(true);
					}


				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}
		});


		/////////////////// CREATE WORLD PANEL ///////////////////

		createWorldPanel.getCreateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isCreateButtonPressed==false) {
					simpleObstacleNumber= Integer.parseInt(createWorldPanel.getNumOfSimpleObstacle().getText());
					firmObstacleNumber= Integer.parseInt(createWorldPanel.getNumOfFirmObstacle().getText());
					explosiveObstacleNumber= Integer.parseInt(createWorldPanel.getNumOfExplosiveObstacle().getText());
					giftObstacleNumber= Integer.parseInt(createWorldPanel.getNumOfGiftObstacle().getText());
					if(simpleObstacleNumber<75 || firmObstacleNumber<10 || explosiveObstacleNumber<5 || giftObstacleNumber<10) {
						JOptionPane.showMessageDialog(createWorldPanel, "To create a world,"
								+ "There must be at least:\n"
								+ "75 simple obstacles\n"
								+ "5 explosive obstacles\n"
								+ "10 gift obstacles\n"
								+ "10 firm obstacles.");
					}  else if(simpleObstacleNumber+firmObstacleNumber+explosiveObstacleNumber+giftObstacleNumber>585) {
						JOptionPane.showMessageDialog(createWorldPanel, "You can't put more than 585 obstacles.");
					}
					else if(simpleObstacleNumber>=75 && firmObstacleNumber>=10 && explosiveObstacleNumber>=5 && giftObstacleNumber>=10) {
						createWorld(simpleObstacleNumber,firmObstacleNumber,explosiveObstacleNumber,giftObstacleNumber);
						isCreateButtonPressed=true;
					} 
				} else {
					JOptionPane.showMessageDialog(createWorldPanel, "You already created random world. To add more obstacles, "
							+ "click on image and press wherever you want to add.");
				}
			}
		});

		createWorldPanel.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createWorldPanel.setVisible(false);
				createOrLoadOrCustomizePanel.setVisible(true);
			}
		});

		createWorldPanel.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				if(e.getX()<MainFrame.width-MainFrame.widthButton/2-255-MainFrame.width/50 - 8*MainFrame.width/100 + 1 + 8*MainFrame.width/100
						&& heightButton<e.getY()&& e.getY()<300+heightButton) {


					if(createWorldPanel.getSelectedObs().equals("simpleObstacle")) {
						boolean collisionOccurs = false;
						JLabel simpleObstacle=new JLabel(simpleIcon);
						simpleObstacle.setBounds(e.getX(),e.getY(),width/50,20);	
						for (JLabel obs : obstacles){

							if(obsCollision(obs, simpleObstacle)){
								collisionOccurs = true;
							}	

						}
						//boolean checkCollision = false;
						if(collisionOccurs == false) {
							JLabel simpleObstacleToAdd=new JLabel(simpleIcon);
							controller.createObstacle("SimpleObstacle", e.getX(),e.getY());
							obstacles.add(simpleObstacleToAdd);
							createWorldPanel.add(simpleObstacleToAdd);
							simpleObstacleToAdd.setBounds(e.getX(),e.getY(),width/50,20);

							simpleObstacleToAdd.addMouseListener(new MouseAdapter() { @Override 
								public void mouseClicked(MouseEvent e) {
								if(createWorldPanel.isVisible()) {
									simpleObstacleToAdd.setIcon(null);
									obstacles.remove(simpleObstacleToAdd);
									controller.removeObstacle(simpleObstacleToAdd.getX(), simpleObstacleToAdd.getY());
								}
							}

							});

						}
						else {
							JOptionPane.showMessageDialog(createWorldPanel, "You can't put an obstacle here, there is an obstacle");	
						}
					}
					else if(createWorldPanel.getSelectedObs().equals("giftObstacle")) {
						boolean collisionOccurs = false;
						JLabel giftObstacle=new JLabel(giftIcon);
						giftObstacle.setBounds(e.getX(),e.getY(),width/50,20);	
						for (JLabel obs : obstacles){

							if(obsCollision(obs, giftObstacle)){
								collisionOccurs = true;
							}	

						}
						//boolean checkCollision = false;
						if(collisionOccurs == false) {
							JLabel giftObstacleToAdd=new JLabel(giftIcon);
							controller.createObstacle("giftObstacle", e.getX(),e.getY());
							obstacles.add(giftObstacleToAdd);
							createWorldPanel.add(giftObstacleToAdd);
							giftObstacleToAdd.setBounds(e.getX(),e.getY(),width/50,20);	
							giftObstacleToAdd.addMouseListener(new MouseAdapter() { @Override 
								public void mouseClicked(MouseEvent e) {
								if(createWorldPanel.isVisible()) {
									giftObstacleToAdd.setIcon(null);
									obstacles.remove(giftObstacleToAdd);
									controller.removeObstacle(giftObstacleToAdd.getX(), giftObstacleToAdd.getY());
								}
							}

							});


						}
						else {
							JOptionPane.showMessageDialog(createWorldPanel, "You can't put an obstacle here, there is an obstacle");	
						}
					}
					else if(createWorldPanel.getSelectedObs().equals("explosiveObstacle")) {

						boolean collisionOccurs = false;
						JLabel explosiveObstacle=new JLabel(explosiveIcon);
						explosiveObstacle.setBounds(e.getX(),e.getY(),width/50,20);	
						for (JLabel obs : obstacles){

							if(obsCollision(obs, explosiveObstacle)){
								collisionOccurs = true;
							}	

						}
						//boolean checkCollision = false;
						if(collisionOccurs == false) {
							JLabel explosiveObstacleToAdd=new JLabel(explosiveIcon);
							controller.createObstacle("ExplosiveObstacle", e.getX(),e.getY());
							obstacles.add(explosiveObstacleToAdd);
							createWorldPanel.add(explosiveObstacleToAdd);
							explosiveObstacleToAdd.setBounds(e.getX(),e.getY(),width/50,20);	
							explosiveObstacleToAdd.addMouseListener(new MouseAdapter() { @Override 
								public void mouseClicked(MouseEvent e) {
								if(createWorldPanel.isVisible()) {
									explosiveObstacleToAdd.setIcon(null);
									obstacles.remove(explosiveObstacleToAdd);
									controller.removeObstacle(explosiveObstacleToAdd.getX(), explosiveObstacleToAdd.getY());
								}
							}

							});


						}
						else {
							JOptionPane.showMessageDialog(createWorldPanel, "You can't put an obstacle here, there is an obstacle");	
						}

						//id++;
					}
					else if(createWorldPanel.getSelectedObs().equals("firmObstacle")) {

						boolean collisionOccurs = false;
						JLabel firmObstacle=new JLabel(firmIcon);
						firmObstacle.setBounds(e.getX(),e.getY(),width/50,20);	
						for (JLabel obs : obstacles){

							if(obsCollision(obs, firmObstacle)){
								collisionOccurs = true;
							}	

						}
						//boolean checkCollision = false;
						if(collisionOccurs == false) {
							JLabel firmObstacleToAdd=new JLabel(firmIcon);
							JLabel numHits= new JLabel();
							Random random= new Random();
							int a= random.nextInt(8)+2;
							numHits.setText(""+a);
							numHits.setLocation(e.getX()+10,e.getY()-2);
							numHits.setVisible(true);
							numHits.setSize(20,20);

							createWorldPanel.add(numHits);
							numHitsArrayList.add(numHits);
							//numHits.add(firmObstacleToAdd);
							createWorldPanel.add(firmObstacleToAdd);
							firmObstacleToAdd.setBounds(e.getX(),e.getY(),width/50,20);

							controller.createObstacle("FirmObstacle", e.getX(),e.getY());
							obstacles.add(firmObstacleToAdd);


							firmObstacleToAdd.addMouseListener(new MouseAdapter() { @Override 
								public void mouseClicked(MouseEvent e) {
								if(createWorldPanel.isVisible()) {
									firmObstacleToAdd.setIcon(null);
									numHits.setVisible(false);
									obstacles.remove(firmObstacleToAdd);
									controller.removeObstacle(firmObstacleToAdd.getX(), firmObstacleToAdd.getY());
								}
							}

							});


						}
						else {
							JOptionPane.showMessageDialog(createWorldPanel, "You can't put an obstacle here, there is an obstacle");	
						}

						//id++;
					} else {
						JOptionPane.showMessageDialog(MainFrame.createWorldPanel, "You should click an obstacle image from right first.");
					}
				} 

				else {
					JOptionPane.showMessageDialog(MainFrame.createWorldPanel, "You can't put obstacle here.");
				}



			}
		});

		createWorldPanel.getGoToGameButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				for(JLabel a: numHitsArrayList) {
					runningGamePanel.add(a);
				}

				for(JLabel j:obstacles) {
					runningGamePanel.add(j);
				}

				controller.createEnchantedSphere(19*MainFrame.width/40,15*MainFrame.height/20);
				createWorldPanel.setVisible(false);
				runningGamePanel.setVisible(true);
				runningGamePanel.requestFocus();
			}

		});


		/////////////////// CUSTOMIZE GAME PANEL ///////////////////

		customizeGamePanel.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customizeGamePanel.setVisible(false);
				createOrLoadOrCustomizePanel.setVisible(true);
			}
		});

		customizeGamePanel.getBackgroundColors().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == customizeGamePanel.getBackgroundColors()) {
					String selected = (String) customizeGamePanel.getBackgroundColors().getSelectedItem();
					logInPanel.getUserLabel().setForeground(Color.BLACK);
					logInPanel.getPasswordLabel().setForeground(Color.BLACK);
					createWorldPanel.getSimpleObsLabel().setForeground(Color.BLACK);
					createWorldPanel.getGiftObsLabel().setForeground(Color.BLACK);
					createWorldPanel.getExplObsLabel().setForeground(Color.BLACK);
					createWorldPanel.getFirmObsLabel().setForeground(Color.BLACK);
					registerPanel.getUserLabel().setForeground(Color.BLACK);
					registerPanel.getPasswordLabel().setForeground(Color.BLACK);
					openingPanel.getWelcome().setForeground(Color.BLACK);
					runningGamePanel.getScoreLabel().setForeground(Color.BLACK);
					runningGamePanel.getLivesLabel().setForeground(Color.BLACK);
					if(selected.equals("Blue")) {
						openingPanel.setBackground(Color.blue);
						logInPanel.setBackground(Color.blue);
						createWorldPanel.setBackground(Color.blue);
						registerPanel.setBackground(Color.blue);
						customizeGamePanel.setBackground(Color.blue);
						runningGamePanel.setBackground(Color.blue);
						createOrLoadOrCustomizePanel.setBackground(Color.blue);
					}
					if(selected.equals("Red")) {
						openingPanel.setBackground(Color.red);
						logInPanel.setBackground(Color.red);
						createWorldPanel.setBackground(Color.red);
						registerPanel.setBackground(Color.red);
						customizeGamePanel.setBackground(Color.red);
						runningGamePanel.setBackground(Color.red);
						createOrLoadOrCustomizePanel.setBackground(Color.red);
					}
					if(selected.equals("Dark Gray")) {
						openingPanel.setBackground( Color.DARK_GRAY);
						logInPanel.setBackground( Color.DARK_GRAY );
						createWorldPanel.setBackground( Color.DARK_GRAY );
						registerPanel.setBackground( Color.DARK_GRAY );
						customizeGamePanel.setBackground( Color.DARK_GRAY );
						runningGamePanel.setBackground( Color.DARK_GRAY  );
						createOrLoadOrCustomizePanel.setBackground( Color.DARK_GRAY);

					}
					if(selected.equals("Green")) {
						openingPanel.setBackground(Color.green);
						logInPanel.setBackground(Color.green);
						createWorldPanel.setBackground(Color.green);
						registerPanel.setBackground(Color.green);
						customizeGamePanel.setBackground(Color.green);
						runningGamePanel.setBackground(Color.green);	
						createOrLoadOrCustomizePanel.setBackground(Color.green);
					}
					if(selected.equals("Yellow")) {
						openingPanel.setBackground(Color.yellow);
						logInPanel.setBackground(Color.yellow);
						createWorldPanel.setBackground(Color.yellow);
						registerPanel.setBackground(Color.yellow);
						customizeGamePanel.setBackground(Color.yellow);
						runningGamePanel.setBackground(Color.yellow);
						createOrLoadOrCustomizePanel.setBackground(Color.yellow);
					}
					if(selected.equals("Pink")) {
						openingPanel.setBackground(Color.pink);
						logInPanel.setBackground(Color.pink);
						createWorldPanel.setBackground(Color.pink);
						registerPanel.setBackground(Color.pink);
						customizeGamePanel.setBackground(Color.pink);
						runningGamePanel.setBackground(Color.pink);
						createOrLoadOrCustomizePanel.setBackground(Color.pink);
					} 
					if(selected.equals("Orange")) {
						openingPanel.setBackground(Color.ORANGE);
						logInPanel.setBackground(Color.ORANGE);
						createWorldPanel.setBackground(Color.ORANGE);
						registerPanel.setBackground(Color.ORANGE);
						customizeGamePanel.setBackground(Color.ORANGE);
						runningGamePanel.setBackground(Color.ORANGE);
						createOrLoadOrCustomizePanel.setBackground(Color.ORANGE);
					} 
					if(selected.equals("Cyan")) {
						openingPanel.setBackground(Color.CYAN);
						logInPanel.setBackground(Color.CYAN);
						createWorldPanel.setBackground(Color.CYAN);
						registerPanel.setBackground(Color.CYAN);
						customizeGamePanel.setBackground(Color.CYAN);
						runningGamePanel.setBackground(Color.CYAN);
						createOrLoadOrCustomizePanel.setBackground(Color.CYAN);
					}
					if(selected.equals("Light Gray")) {
						openingPanel.setBackground(Color.LIGHT_GRAY);
						logInPanel.setBackground(Color.LIGHT_GRAY);
						createWorldPanel.setBackground(Color.LIGHT_GRAY);
						registerPanel.setBackground(Color.LIGHT_GRAY);
						customizeGamePanel.setBackground(Color.LIGHT_GRAY);
						runningGamePanel.setBackground(Color.LIGHT_GRAY);
						createOrLoadOrCustomizePanel.setBackground(Color.LIGHT_GRAY);
					}
					if(selected.equals("Black")) {
						openingPanel.setBackground(Color.BLACK);
						logInPanel.setBackground(Color.BLACK);
						createWorldPanel.setBackground(Color.BLACK);
						registerPanel.setBackground(Color.BLACK);
						customizeGamePanel.setBackground(Color.BLACK);
						runningGamePanel.setBackground(Color.BLACK);
						createOrLoadOrCustomizePanel.setBackground(Color.BLACK);
						logInPanel.getUserLabel().setForeground(Color.WHITE);
						logInPanel.getPasswordLabel().setForeground(Color.WHITE);
						createWorldPanel.getSimpleObsLabel().setForeground(Color.WHITE);
						createWorldPanel.getGiftObsLabel().setForeground(Color.WHITE);
						createWorldPanel.getExplObsLabel().setForeground(Color.WHITE);
						createWorldPanel.getFirmObsLabel().setForeground(Color.WHITE);
						registerPanel.getUserLabel().setForeground(Color.WHITE);
						registerPanel.getPasswordLabel().setForeground(Color.WHITE);
						openingPanel.getWelcome().setForeground(Color.WHITE);
						runningGamePanel.getScoreLabel().setForeground(Color.WHITE);
						runningGamePanel.getLivesLabel().setForeground(Color.WHITE);
						customizeGamePanel.getSound().setForeground(Color.WHITE);
					}
				}
			}
		});

		customizeGamePanel.getGoToGame().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				customizeGamePanel.setVisible(false);
				runningGamePanel.setVisible(true);
			}

		});


		customizeGamePanel.getPlayMusic().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playMusic();
			}

		});

		customizeGamePanel.getStopMusic().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CustomizeGamePanel.stop();
			}
		});



		/////////////////// RUNNING GAME PANEL ///////////////////

		runningGamePanel.getCustomizeButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runningGamePanel.setVisible(false);
				customizeGamePanel.setVisible(true);
			}
		});


		runningGamePanel.getQuitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply= JOptionPane.showConfirmDialog(runningGamePanel, "Do you want to save the game before quiting?","Confirm",JOptionPane.YES_NO_OPTION);
				if(reply==JOptionPane.NO_OPTION) {
					controller.resetObstacles();
					for (JLabel j: obstacles) {
						j.setVisible(false);
					}
					obstacles.removeAll(obstacles);
					runningGamePanel.setVisible(false);
					openingPanel.setVisible(true);
				} else if(reply==JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(runningGamePanel, "Please pause game and press save button to save the game.");
					runningGamePanel.requestFocus();
				}


			}
		});

		runningGamePanel.getSaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isPaused) {
					
						String gameName=JOptionPane.showInputDialog("Please give a name to saved game.");
						if(gameName==null) {
							JOptionPane.showMessageDialog(runningGamePanel ,"Cancelled.");
							runningGamePanel.requestFocus();
						} else if (gameName.equals("")) {
							JOptionPane.showMessageDialog(runningGamePanel ,"You cannot leave name empty!");
							runningGamePanel.requestFocus();
						} else {
							controller.saveGame(gameName);
							JOptionPane.showMessageDialog(runningGamePanel ,"Game is saved successfully!");
						}

				} else {
					JOptionPane.showMessageDialog(runningGamePanel ,"You must pause first.");
				}

			}
		});

		runningGamePanel.getLoadButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<ArrayList> gamesList=controller.loadGame();
					int gameCount=gamesList.size();
					if(gamesList.get(0).size()==0) {
						JOptionPane.showMessageDialog(runningGamePanel, "You do not have any saved game.");
					} else {
						String gameNames="Your saved games: Please enter the number of game you want to load:\n";
						for(int i=0; i<gameCount; i++) {
							gameNames+=(i+1);
							gameNames+=": " +gamesList.get(i).get(2);
							gameNames+="\n";
						}

						String choosedGame=JOptionPane.showInputDialog(gameNames);
						loadSavedGame(controller.getCurrentPlayer().getUsername(), gamesList.get(Integer.parseInt(choosedGame)-1));
						
					}


				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});

	}


	//// HELPER METHODS
	public static void createWorld(int simpleObstacleNumber,int firmObstacleNumber,int explosiveObstacleNumber,int giftObstacleNumber) {


		Random random= new Random();

		for(int i=0;i<simpleObstacleNumber;i++) {

			locXa= random.nextInt(39);
			locYa= random.nextInt(15);
			while(myArray[locXa][locYa]==1) {
				locXa= random.nextInt(39);
				locYa= random.nextInt(15);
			}

			myArray[locXa][locYa]=1;
			locX=locXa*width/50;
			locY=locYa*20+heightButton;

			JLabel simpleObstacle=new JLabel(simpleIcon);


			controller.createObstacle("SimpleObstacle", locX, locY);
			obstacles.add(simpleObstacle);
			simpleObstacle.addMouseListener(new MouseAdapter() { @Override 
				public void mouseClicked(MouseEvent e) {
				if(createWorldPanel.isVisible()) {
					simpleObstacle.setIcon(null);
					obstacles.remove(simpleObstacle);
					controller.removeObstacle(simpleObstacle.getX(), simpleObstacle.getY());
				}
			}
			});

			createWorldPanel.add(simpleObstacle);
			simpleObstacle.setIcon(simpleIcon);
			simpleObstacle.setBounds(locX,locY,width/50,20);

		}

		for(int j=0;j<firmObstacleNumber;j++) {


			locXa= random.nextInt(39);
			locYa= random.nextInt(15);
			while(myArray[locXa][locYa]==1) {
				locXa= random.nextInt(39);
				locYa= random.nextInt(15);
			}
			myArray[locXa][locYa]=1;
			locX=locXa*width/50;
			locY=locYa*20+heightButton;


			JLabel firmObstacle=new JLabel(firmIcon);
			JLabel numHits= new JLabel();
			Random randomNum= new Random();
			int a= randomNum.nextInt(8)+2;
			numHits.setText(""+a);

			numHits.setLocation(locX+10,locY-2);
			numHits.setVisible(true);
			numHits.setSize(20,20);

			createWorldPanel.add(numHits);
			numHits.add(firmObstacle);

			firmObstacle.setBounds(locX,locY,width/50,20);
			createWorldPanel.add(firmObstacle);


			numHitsArrayList.add(numHits);


			controller.createObstacle("FirmObstacle", locX,locY);
			obstacles.add(firmObstacle);


			firmObstacle.addMouseListener(new MouseAdapter() { @Override 
				public void mouseClicked(MouseEvent e) {
				if(createWorldPanel.isVisible()) {
					firmObstacle.setIcon(null);
					obstacles.remove(firmObstacle);
					controller.removeObstacle(firmObstacle.getX(), firmObstacle.getY());
					numHits.setVisible(false);
				}

				controller.removeObstacle(locX,locY);
			}

			});









			//id++;
			//locX+=9*(MainFrame.width/50);

		}

		for(int k=0;k<explosiveObstacleNumber;k++) {


			locXa= random.nextInt(39);
			locYa= random.nextInt(15);
			while(myArray[locXa][locYa]==1) {
				locXa= random.nextInt(39);
				locYa= random.nextInt(15);

			}
			myArray[locXa][locYa]=1;
			locX=locXa*width/50;
			locY=locYa*20+heightButton;

			JLabel explosiveObstacle=new JLabel(explosiveIcon); 
			controller.createObstacle("ExplosiveObstacle", locX, locY);
			obstacles.add(explosiveObstacle);
			explosiveObstacle.addMouseListener(new MouseAdapter() { @Override 
				public void mouseClicked(MouseEvent e) {
				if(createWorldPanel.isVisible()) {
					explosiveObstacle.setIcon(null);
					obstacles.remove(explosiveObstacle);
					controller.removeObstacle(explosiveObstacle.getX(), explosiveObstacle.getY());
				}
			}

			});


			createWorldPanel.add(explosiveObstacle);
			explosiveObstacle.setIcon(explosiveIcon);
			explosiveObstacle.setBounds(locX,locY,width/50,20);


		}

		for(int t=0;t<giftObstacleNumber;t++) {

			locXa= random.nextInt(39);
			locYa= random.nextInt(15);
			while(myArray[locXa][locYa]==1) {
				locXa= random.nextInt(39);
				locYa= random.nextInt(15);

			}
			myArray[locXa][locYa]=1;
			locX=locXa*width/50;
			locY=locYa*20+heightButton;


			JLabel giftObstacle=new JLabel(giftIcon); 
			controller.createObstacle("GiftObstacle", locX, locY);
			obstacles.add(giftObstacle);
			giftObstacle.addMouseListener(new MouseAdapter() { @Override 
				public void mouseClicked(MouseEvent e) {
				if(createWorldPanel.isVisible()) {
					giftObstacle.setIcon(null);
					obstacles.remove(giftObstacle);
					controller.removeObstacle(giftObstacle.getX(), giftObstacle.getY());
				}
			}

			});
			createWorldPanel.add(giftObstacle);
			giftObstacle.setIcon(giftIcon);
			giftObstacle.setBounds(locX,locY,width/50,20);


		}


	}
	public static void playMusic() {
		CustomizeGamePanel.playThemeSong("theme.wav");
	}

	public static void loadSavedGame(String username, ArrayList<String> gameInfo) {
		controller.resetObstacles();
		for (JLabel j: obstacles) {
			j.setVisible(false);
		}
		obstacles.removeAll(obstacles);

		//update player
		Player p=new Player(username, Double.parseDouble(gameInfo.get(0)),Integer.parseInt(gameInfo.get(1)));
		controller.setCurrentPlayer(p);

		//update sphere location
		runningGamePanel.sphere.setLocation(Integer.parseInt(gameInfo.get(3)),Integer.parseInt(gameInfo.get(4)));

		for(int i=5; i<gameInfo.size()-3; i+=3) {

			if(gameInfo.get(i).equals("SimpleObstacle")) {
				JLabel simpleObstacle=new JLabel(simpleIcon);
				controller.createObstacle("SimpleObstacle", Integer.parseInt(gameInfo.get(i+1)),Integer.parseInt(gameInfo.get(i+2)));
				obstacles.add(simpleObstacle);
				simpleObstacle.setIcon(simpleIcon);
				simpleObstacle.setBounds(Integer.parseInt(gameInfo.get(i+1)),Integer.parseInt(gameInfo.get(i+2)),width/50,20);
				runningGamePanel.add(simpleObstacle);
			}else if(gameInfo.get(i).equals("FirmObstacle")) {
				JLabel firmObstacle=new JLabel (firmIcon); 
				controller.createObstacle("FirmObstacle", Integer.parseInt(gameInfo.get(i+1)),Integer.parseInt(gameInfo.get(i+2)));
				obstacles.add(firmObstacle);
				firmObstacle.setIcon(firmIcon);
				//firmObstacle.setText(Integer.toString(o.getNumOfHitsRequired()));
				firmObstacle.setBounds(Integer.parseInt(gameInfo.get(i+1)),Integer.parseInt(gameInfo.get(i+2)),width/50,20);
				runningGamePanel.add(firmObstacle);
			}else if(gameInfo.get(i).equals("GiftObstacle")) {
				JLabel giftObstacle=new JLabel(giftIcon);
				controller.createObstacle("GiftObstacle", Integer.parseInt(gameInfo.get(i+1)),Integer.parseInt(gameInfo.get(i+2)));
				obstacles.add(giftObstacle);
				giftObstacle.setIcon(giftIcon);
				giftObstacle.setBounds(Integer.parseInt(gameInfo.get(i+1)),Integer.parseInt(gameInfo.get(i+2)),width/50,20);
				runningGamePanel.add(giftObstacle);
			}else if(gameInfo.get(i).equals("ExplosiveObstacle")) {
				JLabel explosiveObstacle=new JLabel(explosiveIcon);
				controller.createObstacle("ExplosiveObstacle", Integer.parseInt(gameInfo.get(i+1)),Integer.parseInt(gameInfo.get(i+2)));
				obstacles.add(explosiveObstacle);
				explosiveObstacle.setIcon(explosiveIcon);
				explosiveObstacle.setBounds(Integer.parseInt(gameInfo.get(i+1)),Integer.parseInt(gameInfo.get(i+2)),width/50,20);
				runningGamePanel.add(explosiveObstacle);
			}

		}



	}


	public static Boolean obsLeftUpCornerCollision(JLabel o, JLabel obs2) {
		if( (o.getX()>=obs2.getX()&&o.getX()<=obs2.getX()+MainFrame.width/50) &&
				(o.getY()>= obs2.getY() && o.getY()<=obs2.getY()+20)) {
			return true;
		}	
		return false;
	}

	public static Boolean obsRightUpCornerCollision(JLabel o, JLabel obs2) {
		if( (o.getX()+ MainFrame.width/50  >=obs2.getX()&&o.getX()+MainFrame.width/50<=obs2.getX()+MainFrame.width/50) &&
				(o.getY()>= obs2.getY() && o.getY()<=obs2.getY()+20)) {
			return true;
		}	
		return false;
	}

	//obs is the new created obstacle, obs2 is already created before.
	public static Boolean obsLeftDownCornerCollision(JLabel o, JLabel obs2) {
		if( (o.getX()>=obs2.getX()&&o.getX()<=obs2.getX()+MainFrame.width/50) &&
				(o.getY()+20>= obs2.getY() && o.getY()+20<=obs2.getY()+20)) {
			return true;
		}	
		return false;
	}
	//obs is the new created obstacle, obs2 is already created before.
	public static Boolean obsRightDownCornerCollision(JLabel o, JLabel obs2) {
		if( (o.getX()+ MainFrame.width/50  >=obs2.getX()&&o.getX()+MainFrame.width/50<=obs2.getX()+MainFrame.width/50) &&
				(o.getY()+20>= obs2.getY() && o.getY()+20<=obs2.getY()+20)) {
			return true;
		}	
		return false;
	}

	public static Boolean obsCollision(JLabel o, JLabel obs2) {
		return obsRightDownCornerCollision( o,  obs2) 
				|| obsLeftDownCornerCollision( o,  obs2)
				|| obsRightUpCornerCollision( o,  obs2) 
				|| obsLeftUpCornerCollision( o,  obs2);
	}


	public static void disappear(JLabel j) {
		// TODO Auto-generated method stub
		for(JLabel j1: obstacles) {
			if(j1.getX()==j.getX() && j1.getY()==j.getY()){
				j1.setVisible(false);
				obstacles.remove(j);
				break;
			}
		}

	}

}

