package student;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataInfo.DataInfo;
public class wrongAns extends JFrame{
	
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
	wrongAns() throws Exception 
	{
		setUndecorated(true);
		 dim = Toolkit.getDefaultToolkit().getScreenSize();
		 me = this;
		 this.setResizable(false);
		 this.setSize(dim.width/2, dim.height/3);
		// this.setBackground(Color.black);
		 this.getContentPane().setLayout(new GridLayout(1,5));
		 JLabel jl = new JLabel();
		 Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+5);
		 Font fm= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+20);
		  String localDir=DataInfo.DATA_DIR;
		  jl=new JLabel();
		  ImageIcon icon1 = new ImageIcon(localDir+"no.GIF");
		  jl.setBounds(500, 400, 300, 400);
		 jl.setIcon(icon1);
		// jl.setBounds(200,200 , 700, 1100);
		  
		 JLabel msg1;
		 add(jl);
		// msg1.setForeground(Color.white);
		 msg1 = new JLabel("CHOOSE CORRECT PIC");
		
		// msg2 = new JLabel("opened unintentionaly");
		 msg1.setFont(fm);
	
		 add(msg1);
		 File f=new File(localDir+"//mario.wav");
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
