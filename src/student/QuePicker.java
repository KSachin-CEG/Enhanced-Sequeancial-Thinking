package student;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import DataInfo.DataInfo;
import firsttry.Main;
import firsttry.ScanThread;
import firsttry.UIStatus;
import firsttry.TEACHER.UISettings;

public class QuePicker extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	public StoryHome HomeScreen;
	   JLabel falseTopic,ScreenTitle;
	   JLabel pic[];
	   JLabel caption[];
	   JLabel ans;
	   JLabel attemptLabel;
	   ScanThread st;
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
	   JLabel Topic[];
	   
	   static int noOfGif;
	   
	   public QuePicker() throws IOException
	   {
		   		setUndecorated(true);
		      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		      setBounds(0,0,screenSize.width, screenSize.height);   
		      Toolkit tk = Toolkit.getDefaultToolkit();  
		      int x = ((int) tk.getScreenSize().getWidth());
		      JLabel jl = new JLabel();
			   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize + 1);
			   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
			   Font headsize= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize - 3);
			   
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
			   //temp=1;
			   // READ CAPTION OF THE STORY
			   String tempCaption="";
			   File file = new File(localDir+"//q"+Integer.toString(temp)+"//title.txt");		   
			   BufferedReader br = new BufferedReader(new FileReader(file));
			   String line;
			   while ((line = br.readLine()) != null)
				   tempCaption=tempCaption.concat(line);
			  
			   String title=tempCaption.toUpperCase();
			   String tstr1[]={"HOME",title,"SKIP"};
			   int xpos4head=90;
			   Topic = new JLabel[tstr1.length];
			   for( i=0;i<3;i++)
			   {
			   Topic[i] = new JLabel(tstr1[i]);
			   if(i!=1) 
			   {
				   Topic[i].setBounds(xpos4head, 100, 250, 50);
				   xpos4head+=325;
			   }
			   else
			   {
				   Topic[i].setBounds(xpos4head, 100, 650, 50);
				   xpos4head+=725;
			   }
			   Topic[i].setHorizontalAlignment(SwingConstants.CENTER);
			 
			   Topic[i].setBackground(UISettings.WinBGColor);
			   Topic[i].setOpaque(true);
			   Topic[i].setForeground(UISettings.TextColor);
			   Topic[i].setFont(headsize);
			   add(Topic[i]);
			   }
			   //SET CAPTION OF THE STORY
			   //ScreenTitle = new JLabel(tempCaption);
			   tempCaption="";
			  // line=
			//   ScreenTitle.setBounds((x/2)-(800/2), 50, 800, 50);
			   //ScreenTitle.setBackground(Color.BLACK);
			//   ScreenTitle.setOpaque(true);
			   //ScreenTitle.setForeground(Color.GRAY);
			  // ScreenTitle.setFont(ft);
			//   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
			//   add(ScreenTitle);
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
			  
			 
			   add(jl);
			   status = new UIStatus();
		   	   status.Visible=true;
		   	   status.focused=0;
		   	   this.addMouseListener(this);
		   	  // st= new ScanThreadPicWIthCaption(pic,caption, status);
		   	   //st= new ScanThread(caption,status);
		   	   st= new ScanThread(Topic, status);
		   	   st.start();
		   	   
		   	 
			   
		   	  
		   	   
		   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   
	   }
	   
		   
		   	  
	   
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		switch(status.focused)
		   {
		   case 0 :
			   new Main().setVisible(true);
			   status.Visible=false;
			   setVisible(false);
			   break;
		   case 1 :
			  
			   StoryHome.ansIndex=0;
			   System.out.println("Ques Order");
			  
			   try {
				   
				new StoryHome().setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   status.Visible=false;
			   setVisible(false);
			   break;
		  /* case 2 :
			   
			   break; */
		   case 2 :
			   studentHome.screenQue++;
			   try {
				new QuePicker().setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   status.Visible=false;
			   setVisible(false);
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
