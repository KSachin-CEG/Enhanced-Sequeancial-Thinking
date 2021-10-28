package student;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.graalvm.compiler.virtual.phases.ea.PartialEscapeBlockState.Final;

import DataInfo.DataInfo;
import firsttry.Main;
import firsttry.TEACHER.UISettings;

import java.nio.file.Files;
import java.nio.file.Path;
class FileCheck extends JFrame{
	
	private static final long serialVersionUID = 1L;
JLabel  ul,pl;
 JTextField uname;
 JPasswordField pwd;
 JButton login,cancel;
 static JFrame parent;
JFrame me;
 Robot r;
 Dimension dim;
 JLabel jl;
	FileCheck() throws IOException, UnsupportedAudioFileException, LineUnavailableException 
	{
		setUndecorated(true);
		 dim = Toolkit.getDefaultToolkit().getScreenSize();
		 me = this;
		 this.setResizable(false);
		 this.setSize(dim.width/2, dim.height/3);
		// this.setBackground(Color.black);
		 this.getContentPane().setLayout(new GridLayout(1,5));
		 this.setBackground(Color.blue);
		 JLabel jl = new JLabel();
		 Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+5);
		 Font fm= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+20);
		  String localDir=DataInfo.DATA_DIR;
		  jl=new JLabel();
		  ImageIcon icon1 = new ImageIcon(localDir+"yes.GIF");
		  jl.setBounds(500, 400, 300, 400);
		 jl.setIcon(icon1);
		// jl.setBounds(200,200 , 700, 1100);
		  
		 JLabel msg1;
		 add(jl);
		 msg1 = new JLabel("CHOOSE NEXT PIC");	
		 msg1.setFont(fm);
		 add(msg1);
		 
		 File f=new File(localDir+"//rightTone.wav");
		 AudioInputStream audio=AudioSystem.getAudioInputStream(f);
		 Clip clip = AudioSystem.getClip();
		 clip.open(audio);
		
		 clip.start();
		
		
		 setLocationRelativeTo(null);
		 this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		    	
		      }
		      
		 });
		 
		 this.addWindowFocusListener(new WindowAdapter() {
			 public void windowLostFocus(WindowEvent e) {
		   	  me.requestFocus();
		     }
		      
		 });
		
		 try {
			r = new Robot();
			r.mouseMove(dim.width - 10,dim.height/2);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
	}
	
	
}