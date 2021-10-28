package student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLDocument.Iterator;

import DataInfo.DataInfo;
import firsttry.Main;
import firsttry.ScanThread;
import firsttry.UIStatus;
import firsttry.TEACHER.UISettings;
import sun.security.util.IOUtils;
import firsttry.ScanThreadPicWIthCaption;
import student.FileCheck;


public class StoryHome extends JFrame implements MouseListener{
	private static final long serialVersionUID = 1L;
	public StoryHome HomeScreen;
	   JLabel falseTopic,ScreenTitle;
	   JLabel pic[];
	   JLabel caption[];
	   JLabel ans;
	   JLabel attemptLabel;
	   ScanThreadPicWIthCaption st;
	   UIStatus status;
	   BufferedImage img;
	   ArrayList<Integer> RandomPicIndex;	  
	   int ansOrder;
	   int clickOrder;
	   public  static int ansIndex;
	   String tstr[];
	   int [] array;
	   int noOfFalseAttempt;
	   //int  Noques;
	   
	   static int noOfGif;
	   
	   public StoryHome() throws IOException
	   {
		   		setUndecorated(true);
		      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		      setBounds(0,0,screenSize.width, screenSize.height);   
		      Toolkit tk = Toolkit.getDefaultToolkit();  
		      int x = ((int) tk.getScreenSize().getWidth());
		      JLabel jl = new JLabel();
			   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize + 1);
			   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
			   
			   String localDir=DataInfo.STORY_DIR;
			 
			   noOfGif=0;
			   int xpos=80;
			   String str="";
			   pic=new JLabel[4];
			   caption=new JLabel[4];
			   ansOrder=0;
			   clickOrder=0;
			   Random rand = new Random();
			   int temp;
			   int i;
			  
			   ansIndex=0;
			   noOfFalseAttempt=0;
			 
			   RandomPicIndex=new  ArrayList<Integer>(4);
			   
			   while(RandomPicIndex.size()<4)
			   {
				   temp=rand.nextInt(100);
				   if(temp>0)
				   {
					   temp=temp%4;
					   if(!RandomPicIndex.contains(temp))
					   {
						   RandomPicIndex.add(temp);
					   }
				   }
			   }
				   System.out.print(RandomPicIndex);
			
			   temp= studentHome.QueOrder.get(studentHome.screenQue);
			 
			   // READ CAPTION OF THE STORY
			   String tempCaption="";
			   File file = new File(localDir+"//q"+Integer.toString(temp)+"//title.txt");		   
			   BufferedReader br = new BufferedReader(new FileReader(file));
			   String line;
			   while ((line = br.readLine()) != null)
				   tempCaption=tempCaption.concat(line);
			  
			   //SET CAPTION OF THE STORY
			   ScreenTitle = new JLabel(tempCaption);
			   tempCaption="";
			  // line=
			   ScreenTitle.setBounds((x/2)-(800/2), 50, 800, 50);
			   //ScreenTitle.setBackground(Color.BLACK);
			//   ScreenTitle.setOpaque(true);
			   //ScreenTitle.setForeground(Color.GRAY);
			   ScreenTitle.setFont(ft);
			   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
			   add(ScreenTitle);
			   System.out.println(temp);
			   String tstr[]={"","","",""};
			 //  InputStream inputStream= FileCheck.class.getResourceAsStream("/story/q"+Integer.toString(temp)+"/caption12.txt");
			   int captionTemp=0;
				
				for( i=0;i<4;i++)
				{
					captionTemp=RandomPicIndex.get(i);
					 //inputStream= FileCheck.class.getResourceAsStream("/story/q"+Integer.toString(temp)+"/caption"+Integer.toString(temp)+Integer.toString(i+1)+".txt");
					 
					  file = new File(localDir+"//q"+Integer.toString(temp)+"/caption"+Integer.toString(temp)+Integer.toString(i+1)+".txt");
					   
					    br = new BufferedReader(new FileReader(file));
					  line="";
					   
					   while ((line = br.readLine()) != null)
						   tempCaption=tempCaption.concat(line);				
					System.out.println(tempCaption);
					tstr[i]=tempCaption;
					tempCaption="";
					
				}
				
			   for(i=0;i<4;i++)
			   {
				   
				   pic[i]=new JLabel();
				   int index=RandomPicIndex.get(i);
				   caption[i]=new JLabel(tstr[index]);
				   caption[i].setBounds(xpos, 300, 300, 100);
				   //caption[i].setName(tstr[index]);
				   caption[i].setBackground(UISettings.WinBGColor);
				   caption[i].setOpaque(true);
				   caption[i].setForeground(UISettings.TextColor);
				   caption[i].setFont(fc);
				   caption[i].setHorizontalAlignment(SwingConstants.CENTER);
				   add(caption[i]);
				   
				   ImageIcon icon1 = new ImageIcon(localDir+"//q"+Integer.toString(temp)+"/story"+Integer.toString(temp)+Integer.toString(index+1)+".jpeg");

				   pic[i].setIcon(icon1);
				   pic[i].setBounds(xpos, 450, 300, 250);
				   pic[i].setHorizontalAlignment(SwingConstants.CENTER);
				   pic[i].setBackground(UISettings.WinBGColor);
				   pic[i].setOpaque(true);
				   pic[i].setForeground(UISettings.TextColor);
				   xpos+=340;
				   add(pic[i]);
			   }
			   ans=new JLabel("PICK "+Integer.toString((ansOrder+1))+" ORDER");
			   ans.setBounds(420, 170, 645, 75);
			   ans.setHorizontalAlignment(SwingConstants.CENTER);
			   ans.setBackground(Color.orange);
			   ans.setOpaque(true);
			   ans.setForeground(UISettings.TextColor);
			   ans.setFont(ft);
			   add(ans);
			   attemptLabel=new JLabel("NUMBER OF FALSE ATTEMPT : "+Integer.toString((noOfFalseAttempt)));
			   attemptLabel.setBounds(420, 750, 645, 75);
			   attemptLabel.setHorizontalAlignment(SwingConstants.CENTER);
			   
			   attemptLabel.setBackground(Color.orange);
			   attemptLabel.setOpaque(true);
			   attemptLabel.setForeground(UISettings.TextColor);
			   attemptLabel.setFont(ft);
			   add(attemptLabel);
			   add(jl);
			   status = new UIStatus();
		   	   status.Visible=true;
		   	   status.focused=0;
		   	   this.addMouseListener(this);
		   	   st= new ScanThreadPicWIthCaption(pic,caption, status);
		   	   //st= new ScanThread(caption,status);
		   	   st.start();
			   
		   	  
		   	   
		   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   
	   }
	   
		   
		   	  
	   
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		switch(status.focused)
		   {
		   case 0 :
			  
			   if(RandomPicIndex.get(0)==ansIndex) {
				   ansIndex++;
				   ansOrder++;
				   ans.setText("PICK "+Integer.toString((ansOrder+1))+" ORDER");
				   if(ansIndex<4) {
				   Timer timer = new Timer();
					try {
						FileCheck o=new FileCheck();
						o.setVisible(true);
						timer.schedule(new TimerTask() {
							public void run() {
								o.setVisible(false);
							}
						}, 3000);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				   }
			   }
			   else
			   {
				   noOfFalseAttempt++;
				   attemptLabel.setText("NUMBER OF FALSE ATTEMPT : "+Integer.toString((noOfFalseAttempt))); 
				   Timer timer = new Timer();
					try {
						wrongAns o=new wrongAns();
						o.setVisible(true);
						
						timer.schedule(new TimerTask() {
							public void run() {
								o.setVisible(false);
							}
						}, 3000);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			   }
			   if(ansIndex==4) {
				   	try {
				   		studentHome.screenQue++;
						new QuePicker().setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    status.Visible=false;
					   setVisible(false);
			   }
			   
			   break;
		   case 1 :   
			   if(RandomPicIndex.get(1)==ansIndex) {
				   ansIndex++;
				   ansOrder++;
				   ans.setText("PICK "+Integer.toString((ansOrder+1))+" ORDER");
				   if(ansIndex<4)
				   {
					   Timer timer = new Timer();
					   try {
						   FileCheck o=new FileCheck();
						   o.setVisible(true);
						   timer.schedule(new TimerTask() {
							public void run() {
								o.setVisible(false);
							}
						   }, 3000);
					   } catch (Exception e1) {
						// TODO Auto-generated catch block
						   e1.printStackTrace();
					   }
				   }
			   }
			   else
			   {
				   noOfFalseAttempt++;
				   attemptLabel.setText("NUMBER OF FALSE ATTEMPT : "+Integer.toString((noOfFalseAttempt))); 
				   Timer timer = new Timer();
					try {
						wrongAns o=new wrongAns();
						o.setVisible(true);
						timer.schedule(new TimerTask() {
							public void run() {
								o.setVisible(false);
							}
						}, 3000);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			   }
			   if(ansIndex==4) {
				   	try {
				   		studentHome.screenQue++;
						new QuePicker().setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    status.Visible=false;
					   setVisible(false);
			   }
			   System.out.println("Click 2 pic" );
			   break;
		  
		   case 2 :
			   if(RandomPicIndex.get(2)==ansIndex) {
				   ansIndex++;
				   ansOrder++;
				   ans.setText("PICK "+Integer.toString((ansOrder+1))+" ORDER");
				   if(ansIndex<4) {
					   Timer timer = new Timer();
					   try {
						   FileCheck o=new FileCheck();
						   o.setVisible(true);
						   timer.schedule(new TimerTask() {
							   public void run() {
								   o.setVisible(false);
							   }
						   }, 3000);
					   
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				   }
			   }
			   else
			   {
				   noOfFalseAttempt++;
				   attemptLabel.setText("NUMBER OF FALSE ATTEMPT : "+Integer.toString((noOfFalseAttempt))); 
				   Timer timer = new Timer();
					try {
						wrongAns o=new wrongAns();
						o.setVisible(true);
						timer.schedule(new TimerTask() {
							public void run() {
								o.setVisible(false);
							}
						}, 3000);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			   }
			   if(ansIndex==4) {
					try {
						studentHome.screenQue++;
						new QuePicker().setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    status.Visible=false;
					   setVisible(false);
					   }
			 
			   break;
		   case 3:	
			   if(RandomPicIndex.get(3)==ansIndex) {
				   ansIndex++;
				   ansOrder++;
				   ans.setText("PICK "+Integer.toString((ansOrder+1))+" ORDER");
				   if(ansIndex<4) {
				   Timer timer = new Timer();
					try {
						FileCheck o=new FileCheck();
						o.setVisible(true);
						timer.schedule(new TimerTask() {
							public void run() {
								o.setVisible(false);
							}
						}, 3000);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				   }
			   }
			   else
			   {
				   noOfFalseAttempt++;
				   attemptLabel.setText("NUMBER OF FALSE ATTEMPT : "+Integer.toString((noOfFalseAttempt))); 
				   Timer timer = new Timer();
					try {
						wrongAns o=new wrongAns();
						o.setVisible(true);
						timer.schedule(new TimerTask() {
							public void run() {
								o.setVisible(false);
							}
						}, 3000);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			   }
			   if(ansIndex==4) {
					try {
						studentHome.screenQue++;
						new QuePicker().setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    status.Visible=false;
					   setVisible(false);
					   }
			   break;
		   }
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override 
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}


