package gui;

import domain.game.Game;
import domain.game.NeedForSpearGame;
import domain.obstacles.FirmObstacle;
import domain.obstacles.Obstacle;

import domain.player.Player;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class RunningGamePanel extends JPanel{


	private ImageIcon noblePhantasmImageIcon;
	Player player= new Player();

	private int delay =5;
	private int dx = 1;
	private int dy = 1;
	private int x = 19*MainFrame.width/40;
	private int y = 15*MainFrame.height/20;
	private int leftMovement = MainFrame.width/50;
	private int rightMovement = MainFrame.width/50;


	private JButton pauseButton;
	private JButton quitButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton resumeButton;
	private Timer timer;
	private JLabel scoreLabel;
	private JLabel livesLabel;
	private JLabel noblePhantasm;
	JLabel sphere;

	private JButton customizeButton;

	public BufferedImage bf1 = null;
	public Image image;
	private NeedForSpearGame controller=new NeedForSpearGame();

	static ImageIcon remainingIcon1= new ImageIcon("remaining.png");
	static Image remainingIm = remainingIcon1.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
	static ImageIcon remainingIcon = new ImageIcon(remainingIm);

	public RunningGamePanel(){
		super();
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		//this.setLayout(new FlowLayout());
		pauseButton= new JButton();
		quitButton= new JButton();
		saveButton= new JButton();
		loadButton= new JButton();
		customizeButton= new JButton();
		resumeButton= new JButton();

		resumeButton.setText("Resume");
		pauseButton.setText("Pause");
		quitButton.setText("Quit");
		saveButton.setText("Save");
		loadButton.setText("Load");
		customizeButton.setText("Customize");

		scoreLabel= new JLabel();

		//scoreLabel.setText("Score:      "+Game.currentPlayer.getScore());  //observer will be applied.
		scoreLabel.setBounds(1280,10,105,75);
		scoreLabel.setVisible(true);

		livesLabel= new JLabel();
		//livesLabel.setText("Lives:      "+Game.currentPlayer.getLives());   //observer will be applied.
		livesLabel.setBounds(1280,60,105,75);
		livesLabel.setVisible(true);

		pauseButton.setBounds(0,0,2*MainFrame.widthButton/3,MainFrame.heightButton);
		quitButton.setBounds(2*MainFrame.widthButton/3,0,2*MainFrame.widthButton/3,MainFrame.heightButton);
		saveButton.setBounds(2*2*MainFrame.widthButton/3,0,2*MainFrame.widthButton/3,MainFrame.heightButton);
		loadButton.setBounds(3*2*MainFrame.widthButton/3,0,2*MainFrame.widthButton/3,MainFrame.heightButton);
		customizeButton.setBounds(4*2*MainFrame.widthButton/3,0,2*MainFrame.widthButton/3,MainFrame.heightButton);
		resumeButton.setBounds(5*2*MainFrame.widthButton/3,0,2*MainFrame.widthButton/3,MainFrame.heightButton);

		this.add(pauseButton);
		this.add(quitButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(resumeButton);
		this.add(scoreLabel);
		this.add(livesLabel);

		//imageSphere= new EnchantedSphere(new ImageIcon("sphere.png"));
		BufferedImage bf3= null;

		try {
			bf3 = ImageIO.read(
					new File("sphere_cropped.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImageIcon my_icon_2= new ImageIcon(bf3);
		Image image_2 = my_icon_2.getImage().getScaledInstance(16,16,Image.SCALE_SMOOTH);

		my_icon_2 = new ImageIcon(image_2, my_icon_2.getDescription());
		sphere= new JLabel(my_icon_2);
		sphere.setBounds(19*MainFrame.width/40,15*MainFrame.height/20,16,16);

		//int w = my_icon_2.getIconWidth(); //Width of enchanted sphere. 
		//int h = my_icon_2.getIconHeight(); //Height of enchanted sphere. 

		try {
			bf1 = ImageIO.read(
					new File("phantasm-rotated.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//BufferedImage bf2= rotate1(bf1);

		ImageIcon my_icon= new ImageIcon(bf1);
		image = my_icon.getImage().getScaledInstance(MainFrame.width/10,20,Image.SCALE_SMOOTH);

		//my_icon = new ImageIcon(image);
		noblePhantasmImageIcon = new ImageIcon(image);
		noblePhantasm = new JLabel(noblePhantasmImageIcon);
		noblePhantasm.setBounds(19*MainFrame.width/40-MainFrame.width/100,8*MainFrame.height/10,MainFrame.width/10,20);
		noblePhantasm.setIcon(noblePhantasmImageIcon);

		noblePhantasm.setFocusable(true);
		noblePhantasm.setFocusTraversalKeysEnabled(false);
		this.add(noblePhantasm);



		ArrayList<JLabel> remainingsDown=new ArrayList<JLabel>();
		ArrayList<JLabel> remainingsRight=new ArrayList<JLabel>();
		ArrayList<JLabel> remainingsLeft=new ArrayList<JLabel>();
		timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent e) // will run when the timer fires
			{

				if(Game.obstacles.isEmpty()) {
					JOptionPane.showMessageDialog(MainFrame.runningGamePanel, 
							"Congratulations! You have broken all obstacles! \n Your Score is "+ controller.getCurrentPlayerScore());
					timer.stop();
					MainFrame.isPaused=true;
				}
				if(controller.getCurrentPlayer().getLives()==0) {
					JOptionPane.showMessageDialog(MainFrame.runningGamePanel, 
							"Game Over! \nYour Score is "+ controller.getCurrentPlayerScore());
					timer.stop();
					MainFrame.isPaused=true;
				}

				livesLabel.setText("Lives:      "+controller.getCurrentPlayerLives());
				scoreLabel.setText("Score:      "+controller.getCurrentPlayerScore());

				if (sphere.getX() < 0)									dx = -dx;
				if (sphere.getX() > (39*MainFrame.width/50  - 16))		dx = -dx;
				if (sphere.getY() < MainFrame.heightButton)				dy = -dy;
				if (sphere.getY() > (MainFrame.height- 16))	            dy = -dy;

				for (Obstacle o: controller.getObstacles()){


					if(dy<0 && controller.collisionSphereFromDown(o , controller.getSphere())) { //collide from down
						if (o.getObstacleName().equals("SimpleObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									
									MainFrame.disappear(j);
									
									break;
								}
							}
							
							controller.removeObs(o);

						}else if (o.getObstacleName().equals("FirmObstacle")){
                            
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									for(JLabel numHits: MainFrame.numHitsArrayList) {
										if(j.getX()+10==numHits.getX() && j.getY()-2 ==numHits.getY() ) {
											int numRemainingHits=Integer.parseInt(numHits.getText());
											if(numRemainingHits!=1) {
												numHits.setText(Integer.toString(numRemainingHits-1));
											}else {
												MainFrame.disappear(j);
												numHits.setVisible(false);
												MainFrame.numHitsArrayList.remove(numHits);
												controller.removeObs(o);
											}	
											break;
										}
									}
									break;
								}
							}

						}else if (o.getObstacleName().equals("GiftObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									
									break;
								}
							}
							controller.removeObs(o);
						}else if (o.getObstacleName().equals("ExplosiveObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									
									break;
								}
							}
							controller.removeObs(o);
							JLabel remainingRight = new JLabel();
							remainingRight.setIcon(remainingIcon);
							remainingRight.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingRight.setVisible(true);
							add(remainingRight);
							remainingsRight.add(remainingRight);

							JLabel remainingLeft = new JLabel();
							remainingLeft.setIcon(remainingIcon);
							remainingLeft.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingLeft.setVisible(true);
							add(remainingLeft);
							remainingsLeft.add(remainingLeft);

							JLabel remainingDown = new JLabel();
							remainingDown.setIcon(remainingIcon);
							remainingDown.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingDown.setVisible(true);
							add(remainingDown);
							remainingsDown.add(remainingDown);
						}

						dy = -dy;
						controller.updateScore();
						break;
					}else if( dy>0 && controller.collisionSphereFromUp(o , controller.getSphere())) {  //collide from up

						if (o.getObstacleName().equals("SimpleObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									//MainFrame.obstacles.remove(j);
									break;
								}
							}
							controller.removeObs(o);
						}else if (o.getObstacleName().equals("FirmObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									for(JLabel numHits: MainFrame.numHitsArrayList) {
										if(j.getX()+10==numHits.getX() && j.getY()-2 ==numHits.getY() ) {
											int numRemainingHits=Integer.parseInt(numHits.getText());
											if(numRemainingHits!=1) {
												numHits.setText(Integer.toString(numRemainingHits-1));
											}else {
												MainFrame.disappear(j);
												numHits.setVisible(false);
												MainFrame.numHitsArrayList.remove(numHits);
												controller.removeObs(o);
											}	
											break;
										}
									}
									break;
								}
							}
							

						}else if (o.getObstacleName().equals("GiftObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									//j.setVisible(false);
									//MainFrame.obstacles.remove(j);
									break;
								}
							}
							controller.removeObs(o);
						}else if (o.getObstacleName().equals("ExplosiveObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									//j.setVisible(false);
									//MainFrame.obstacles.remove(j);
									break;
								}
							}
							controller.removeObs(o);
							JLabel remainingRight = new JLabel();
							remainingRight.setIcon(remainingIcon);
							remainingRight.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingRight.setVisible(true);
							add(remainingRight);
							remainingsRight.add(remainingRight);

							JLabel remainingLeft = new JLabel();
							remainingLeft.setIcon(remainingIcon);
							remainingLeft.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingLeft.setVisible(true);
							add(remainingLeft);
							remainingsLeft.add(remainingLeft);

							JLabel remainingDown = new JLabel();
							remainingDown.setIcon(remainingIcon);
							remainingDown.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingDown.setVisible(true);
							add(remainingDown);
							remainingsDown.add(remainingDown);
						}
						dy = -dy;
						controller.updateScore();
						break;
					}else if( dx<0 && controller.collisionSphereFromRight(o , controller.getSphere())) {  //collide from right
						if (o.getObstacleName().equals("SimpleObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									//j.setVisible(false);
									//MainFrame.obstacles.remove(j);
									break;
								}
							}
							controller.removeObs(o);
						}else if (o.getObstacleName().equals("FirmObstacle")){

							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									for(JLabel numHits: MainFrame.numHitsArrayList) {
										if(j.getX()+10==numHits.getX() && j.getY()-2 ==numHits.getY() ) {
											int numRemainingHits=Integer.parseInt(numHits.getText());
											if(numRemainingHits!=1) {
												numHits.setText(Integer.toString(numRemainingHits-1));
											}else {
												MainFrame.disappear(j);
												numHits.setVisible(false);
												MainFrame.numHitsArrayList.remove(numHits);
												controller.removeObs(o);
											}	
											break;
										}
									}
									break;
								}
							}

						}else if (o.getObstacleName().equals("GiftObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									//j.setVisible(false);
									//MainFrame.obstacles.remove(j);
									break;
								}
							}
							controller.removeObs(o);
						}else if (o.getObstacleName().equals("ExplosiveObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									//j.setVisible(false);
									//MainFrame.obstacles.remove(j);
									break;
								}
							}
							controller.removeObs(o);
							JLabel remainingRight = new JLabel();
							remainingRight.setIcon(remainingIcon);
							remainingRight.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingRight.setVisible(true);
							add(remainingRight);
							remainingsRight.add(remainingRight);

							JLabel remainingLeft = new JLabel();
							remainingLeft.setIcon(remainingIcon);
							remainingLeft.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingLeft.setVisible(true);
							add(remainingLeft);
							remainingsLeft.add(remainingLeft);

							JLabel remainingDown = new JLabel();
							remainingDown.setIcon(remainingIcon);
							remainingDown.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingDown.setVisible(true);
							add(remainingDown);
							remainingsDown.add(remainingDown);
						}

						dx = -dx;
						controller.updateScore();
						break;
					}else if( dx>0 && controller.collisionSphereFromLeft(o , controller.getSphere())) {  //collide from left

						if (o.getObstacleName().equals("SimpleObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									//j.setVisible(false);
									//MainFrame.obstacles.remove(j);
									break;
								}
							}
							controller.removeObs(o);
						}else if (o.getObstacleName().equals("FirmObstacle")){

							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									for(JLabel numHits: MainFrame.numHitsArrayList) {
										if(j.getX()+10==numHits.getX() && j.getY()-2 ==numHits.getY() ) {
											int numRemainingHits=Integer.parseInt(numHits.getText());
											if(numRemainingHits!=1) {
												numHits.setText(Integer.toString(numRemainingHits-1));
											}else {
												MainFrame.disappear(j);
												numHits.setVisible(false);
												MainFrame.numHitsArrayList.remove(numHits);
												controller.removeObs(o);
											}	
											break;
										}
									}
									break;
								}
							}

						}else if (o.getObstacleName().equals("GiftObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									//j.setVisible(false);
									//MainFrame.obstacles.remove(j);
									break;
								}
							}
							controller.removeObs(o);
						}else if (o.getObstacleName().equals("ExplosiveObstacle")){
							for(JLabel j:MainFrame.obstacles) {
								if(o.getxLocation()==j.getX()&&o.getyLocation()==j.getY()) {
									MainFrame.disappear(j);
									//j.setVisible(false);
									//MainFrame.obstacles.remove(j);
									break;
								}
							}
							controller.removeObs(o);
							JLabel remainingRight = new JLabel();
							remainingRight.setIcon(remainingIcon);
							remainingRight.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingRight.setVisible(true);
							add(remainingRight);
							remainingsRight.add(remainingRight);

							JLabel remainingLeft = new JLabel();
							remainingLeft.setIcon(remainingIcon);
							remainingLeft.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingLeft.setVisible(true);
							add(remainingLeft);
							remainingsLeft.add(remainingLeft);

							JLabel remainingDown = new JLabel();
							remainingDown.setIcon(remainingIcon);
							remainingDown.setBounds(o.getxLocation(), o.getyLocation(),15,15);
							remainingDown.setVisible(true);
							add(remainingDown);
							remainingsDown.add(remainingDown);
						}

						dx = -dx;
						controller.updateScore();
						break;
					}

				}


				if(controller.collisionOfEnchantedSphereWithNoblePhantasm(controller.getPhantasm(), controller.getSphere())) {
					dy = -dy;
				}

				for(JLabel rem: remainingsDown) {
					rem.setLocation(rem.getX(), rem.getY()+3);
					
					if(noblePhantasm.getX()-15<rem.getX() && rem.getX()< noblePhantasm.getX()+ MainFrame.width/10 && rem.getY()+20 >= 8*MainFrame.height/10 && rem.getY()<8*MainFrame.width/10+20) {
						remainingsDown.remove(rem);
						controller.decrementLives();
						rem.setVisible(false);
						break;
					} else if (rem.getY()>8*MainFrame.height/10) {
						rem.setVisible(false);
						remainingsDown.remove(rem);
						break;
					}

				}

				for(JLabel rem: remainingsRight) {
					rem.setLocation(rem.getX()+1, rem.getY()+3);
					
					if(noblePhantasm.getX()-15<rem.getX() && rem.getX()< noblePhantasm.getX()+ MainFrame.width/10 && rem.getY()+20 >= 8*MainFrame.height/10 && rem.getY()<8*MainFrame.width/10+20) {
						remainingsRight.remove(rem);
						controller.decrementLives();
						rem.setVisible(false);
						break;
					} else if (rem.getY()>8*MainFrame.height/10) {
						rem.setVisible(false);
						remainingsRight.remove(rem);
						break;
					}

				}

				for(JLabel rem: remainingsLeft) {
					rem.setLocation(rem.getX()-1, rem.getY()+3);
					
					if(noblePhantasm.getX()-15<rem.getX() && rem.getX()< noblePhantasm.getX()+ MainFrame.width/10 && rem.getY()+20 >= 8*MainFrame.height/10 && rem.getY()<8*MainFrame.width/10+20) {
						remainingsLeft.remove(rem);
						controller.decrementLives();
						rem.setVisible(false);
						break;
					} else if (rem.getY()>8*MainFrame.height/10) {
						rem.setVisible(false);
						remainingsLeft.remove(rem);
						break;
					}

				}
				if (controller.getSphere().getyLocation()>9*MainFrame.height/10) {

					sphere.setBounds(19*MainFrame.width/40,13*MainFrame.height/20,16,16);
					controller.updateSphere(19*MainFrame.width/40,13*MainFrame.height/20);
					x=19*MainFrame.width/40;
					y=13*MainFrame.height/20;
					controller.decrementLives();
					timer.stop();

					JOptionPane.showMessageDialog(MainFrame.runningGamePanel, 
							"You have lost 1 life."
									+
									"\nYou have " + controller.getCurrentPlayer().getLives()+ " lives left.");
					timer.restart();
					/*try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					timer.restart();*/
				}

				x += dx;
				y += dy;
				sphere.setBounds(x,y,16,16);
				controller.updateSphere(x,y);
				controller.updatePhantasm(noblePhantasm.getX());

				//System.out.println("x: "+Game.sphere.getxLocation()+" y: "+Game.sphere.getyLocation());
			}	
		});



		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				timer.start();
				MainFrame.isPaused=false;
			}
		});

		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.isPaused=true;
				timer.stop();

				////todo////////////////////////////
				//////  TODO /////////////////////
			}
		});

		resumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.restart();
				requestFocus();
				MainFrame.isPaused=false;
				////todo////////////////////////////
				//////  TODO /////////////////////
			}
		});


		/*imagePhantasm= new NoblePhantasm(my_icon);
		imagePhantasm.setBounds(19*MainFrame.width/40-MainFrame.width/100,8*MainFrame.height/10,MainFrame.width/10,20);
	//	imagePhantasm.addKeyListener(this);
		imagePhantasm.setFocusable(true);
		imagePhantasm.setFocusTraversalKeysEnabled(true);*/
		this.addKeyListener(this.gameListener);


		//this.add(imagePhantasm);
		this.add(sphere);
		this.add(customizeButton);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
	}


	public JButton getCustomizeButton() {
		return customizeButton;
	}

	public void setCustomizeButton(JButton customizeButton) {
		this.customizeButton = customizeButton;
	}

	//public void setImagePhantasm(NoblePhantasm imagePhantasm) {
	//	this.noblePhantasm = imagePhantasm;
	//}



	//public NoblePhantasm getImagePhantasm() {
	//	return noblePhantasm;
	//}





	public JButton getPauseButton() {
		return pauseButton;
	}



	public void setPauseButton(JButton pauseButton) {
		this.pauseButton = pauseButton;
	}



	public JButton getQuitButton() {
		return quitButton;
	}



	public void setQuitButton(JButton quitButton) {
		this.quitButton = quitButton;
	}



	public JButton getSaveButton() {
		return saveButton;
	}



	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}



	public JButton getLoadButton() {
		return loadButton;
	}



	public void setLoadButton(JButton loadButton) {
		this.loadButton = loadButton;
	}



	public JLabel getScoreLabel() {
		return scoreLabel;
	}



	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}



	public JLabel getLivesLabel() {
		return livesLabel;
	}



	public void setLivesLabel(JLabel livesLabel) {
		this.livesLabel = livesLabel;
	}





	public boolean hasLive() {
		if(player.getLives() < 1)
			return false;
		return true;
	}

	public void showGameOver() {
		JLabel gameOver = new JLabel();
		gameOver.setText("Game is over "+player.getUsername() +": Here are your scores.\n" + "Your score is:" + player.getScore() );

	}

	public static BufferedImage rotate1(BufferedImage img)
	{

		int w = img.getWidth();
		int h = img.getHeight();


		BufferedImage newImage = new BufferedImage(
				img.getWidth(), img.getHeight(), img.getType());


		Graphics2D g2 = newImage.createGraphics();

		g2.rotate(Math.toRadians(45), w / 2,
				h / 2);
		g2.drawImage(img, null, 0, 0);

		return newImage;
	}

	public static BufferedImage rotate2(BufferedImage img)
	{

		// Getting Dimensions of image
		int w = img.getWidth();
		int h = img.getHeight();

		// Creating a new buffered image
		BufferedImage newImage = new BufferedImage(
				img.getWidth(), img.getHeight(), img.getType());

		// creating Graphics in buffered image
		Graphics2D g2 = newImage.createGraphics();

		// Rotating image by degrees using toradians()
		// method
		// and setting new dimension t it
		g2.rotate(Math.toRadians(135), w / 2,
				h / 2);
		g2.drawImage(img, null, 0, 0);

		// Return rotated buffer image
		return newImage;
	}



	private KeyListener gameListener = new KeyAdapter() {


		@Override
		public void keyPressed(KeyEvent e) {

			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			switch( keyCode ) {
			case 37: 
				if(noblePhantasm.getX() > 0) {
					noblePhantasm.setLocation(noblePhantasm.getX()-leftMovement,noblePhantasm.getY());
				}
				break;
			case 39: 
				if(noblePhantasm.getX() < ((MainFrame.width*39/50) - MainFrame.width/10)) {
					noblePhantasm.setLocation(noblePhantasm.getX()+rightMovement,noblePhantasm.getY());
				}
				break;
			case 87:
				timer.start();
				MainFrame.isPaused=false;
				break;
			case 40:
				if(leftMovement==MainFrame.width/50) {
					leftMovement= 2*leftMovement;
					rightMovement= 2*rightMovement;
				}

				break;

			case 65: ///A

				/*bf1=rotate2(bf1);
				ImageIcon my_icon= new ImageIcon(bf1);
				image = my_icon.getImage().getScaledInstance(MainFrame.width/10,20,Image.SCALE_SMOOTH);
				noblePhantasmImageIcon = new ImageIcon(image);
				noblePhantasm.setIcon(noblePhantasmImageIcon);
				noblePhantasm.setBounds(19*MainFrame.width/40-MainFrame.width/100,8*MainFrame.height/10,MainFrame.width/10,20);*/

				break;

			case 68: ///D

				break;
			default: 
				//System.out.println("Not a valid key.");
			}
			//	requestFocus();
		}

		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch( keyCode ) {

			case 40:
				leftMovement= leftMovement/2;
				rightMovement= rightMovement/2;
				break;
			default: 
				//System.out.println("Not a valid key.");
			}
		}


	};




	//public void keyTyped(KeyEvent e) {
	//}




}


//@Override
/*public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
		    if(keyCode==KeyEvent.VK_A) {
		    	BufferedImage bf2= rotate1(bf1);

				ImageIcon my_icon= new ImageIcon(bf2);

				image = my_icon.getImage();


				my_icon = new ImageIcon(image, my_icon.getDescription());
			    imagePhantasm= new NoblePhantasm(my_icon);


			    imagePhantasm.repaint();

		    } else if(keyCode==KeyEvent.VK_D) {
                BufferedImage bf2= rotate2(bf1);

				ImageIcon my_icon= new ImageIcon(bf2);

				image = my_icon.getImage();


				my_icon = new ImageIcon(image, my_icon.getDescription());

			    imagePhantasm= new NoblePhantasm(my_icon);


			    imagePhantasm.repaint
		    }
		}


		/*ImageIcon noblePhantasm = new ImageIcon(new ImageIcon("phantasm-rotated.png").getImage().getScaledInstance(MainFrame.width/50,20,Image.SCALE_SMOOTH));
		JLabel noblePhantasmLabel;

		ImageIcon enchantedSphere = new ImageIcon(new ImageIcon("sphere.png").getImage().getScaledInstance(MainFrame.width/50,20,Image.SCALE_SMOOTH));
		JLabel enchantedSphereLabel;

		int leftMovement = noblePhantasm.getIconWidth()/2;
	    int rightMovement = noblePhantasm.getIconWidth()/2;
		boolean isMovingLeft = false;
		boolean isMovingRight = false;*/
//} 

