package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class CustomizeGamePanel extends JPanel{

	private JSlider soundManager;
	private JButton playMusic;
	private JButton stopMusic;
	public static Clip clip;
	private static FloatControl fc;
	private static  float curVol= 0;
	private JButton backButton;
	private JComboBox backgroundColors;
	private JButton goToGame;
	private JLabel sound;
	private JLabel backColor;


	public Clip getClip() {
		return clip;
	}
	public void setClip(Clip clip) {
		this.clip = clip;
	}
	public JButton getPlayMusic() {
		return playMusic;
	}
	public void setPlayMusic(JButton playMusic) {
		this.playMusic = playMusic;
	}
	public JButton getStopMusic() {
		return stopMusic;
	}
	public void setStopMusic(JButton stopMusic) {
		this.stopMusic = stopMusic;
	}



	public JLabel getSound() {
		return sound;
	}
	public void setSound(JLabel sound) {
		this.sound = sound;
	}


	public CustomizeGamePanel() {
		super();
		soundManager= new JSlider(-80,6);
		soundManager.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				curVol= soundManager.getValue();
				fc.setValue(curVol);
			}

		});

		sound= new JLabel();
		backColor= new JLabel();
		String[] colors = {"Blue", "Dark Gray","Red","Green","Yellow","Pink","Orange","Cyan","Light Gray","Black"};
		backgroundColors = new JComboBox(colors);


		backButton= new JButton();
		goToGame= new JButton();
		playMusic= new JButton();
		stopMusic= new JButton();



		stopMusic.setText("Stop Music");
		goToGame.setText("Go To Game");
		playMusic.setText("Play Music");

		sound.setText("Sound Level:");
		backColor.setText("Background Color:");
		backButton.setText("Back");

		sound.setBounds(MainFrame.middleX-MainFrame.widthButton,MainFrame.middleY-2*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		soundManager.setBounds(MainFrame.middleX,MainFrame.middleY-2*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		playMusic.setBounds(MainFrame.middleX-MainFrame.widthButton,MainFrame.middleY-MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		stopMusic.setBounds(MainFrame.middleX,MainFrame.middleY-MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		backColor.setBounds(MainFrame.middleX-MainFrame.widthButton,MainFrame.middleY+MainFrame.heightButton/2,MainFrame.widthButton,MainFrame.heightButton);
		backgroundColors.setBounds(MainFrame.middleX,MainFrame.middleY+MainFrame.heightButton/2,MainFrame.widthButton,MainFrame.heightButton);
		backButton.setBounds(MainFrame.middleX-MainFrame.widthButton,MainFrame.middleY+2*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		goToGame.setBounds(MainFrame.middleX,MainFrame.middleY+2*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);

		soundManager.setPaintTrack(true);
		soundManager.setPaintLabels(true);
		soundManager.setPaintTicks(true);





		this.add(backButton);
		this.add(soundManager);
		this.add(backgroundColors); 
		this.add(goToGame);
		this.add(sound);
		this.add(backColor);
		this.add(playMusic);
		this.add(stopMusic);


		this.setBackground(Color.GREEN);
		this.setLayout(null);
	}

	public FloatControl getFc() {
		return fc;
	}
	public void setFc(FloatControl fc) {
		this.fc=fc;
	}

	public float getCurrentVolume() {
		return curVol;
	}
	public void setCurrentVolume(float currentVolume) {
		this.curVol = currentVolume;
	}

	public JSlider getSoundManager() {
		return soundManager;
	}
	public void setSoundManager(JSlider soundManager) {
		this.soundManager = soundManager;
	}
	public JButton getGoToGame() {
		return goToGame;
	}

	public void setGoToGame(JButton goToGame) {
		this.goToGame = goToGame;
	}


	public static void playThemeSong(String fileLocation) {
		try {
			File file= new File(fileLocation);
			if(file.exists()) {
				AudioInputStream audioInp= AudioSystem.getAudioInputStream(file);
				clip= AudioSystem.getClip();
				clip.open(audioInp);
				fc= (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
				clip.start();
			} else {
				System.out.println("File not found!!!");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public JButton getBackButton() {
		return backButton;
	}

	public static void stop() {
		clip.stop();
	}

	public JComboBox getBackgroundColors() {
		return backgroundColors;
	}

	public void setBackgroundColors(JComboBox backgroundColors) {
		this.backgroundColors = backgroundColors;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}



}
