package student;

import javax.swing.*;
import student.StoryHome;

import firsttry.Main;
import firsttry.ScanThread;
import firsttry.UIStatus;
import firsttry.TEACHER.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class studentHome extends JFrame implements MouseListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public studentHome HomeScreen;
   JLabel Topic[],ScreenTitle;
   ScanThread st;
   UIStatus status;
   public static ArrayList<Integer> QueOrder;
  
   static int screenQue;
   Random rand;
   
   public studentHome()
   {
	   setUndecorated(true);
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      Toolkit tk = Toolkit.getDefaultToolkit();  
	      int x = ((int) tk.getScreenSize().getWidth());
	   //Font purpos
	   JLabel jl = new JLabel();
	   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
	   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
	   screenQue=0;
	   //NoOfQues=5;
	   QueOrder=new ArrayList<Integer>(100);
	   ScreenTitle = new JLabel("STUDENT HOME");
	   ScreenTitle.setBounds((x/2)-(800/2), 50, 800, 50);
	   //ScreenTitle.setBackground(Color.BLACK);
	   ScreenTitle.setOpaque(true);
	   //ScreenTitle.setForeground(Color.GRAY);
	   ScreenTitle.setFont(ft);
	   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
	   add(ScreenTitle);
	   
	   //Tipics
	   String tstr[]={"MATHS","STORY BASED",/*"EVALUATE",*/"HOME"};
	   Topic = new JLabel[tstr.length];
	   int ypos=150;
	   for(int i=0;i<Topic.length;i++)
	   {
	   Topic[i] = new JLabel(tstr[i]);
	   Topic[i].setBounds((x/2)-(700/2), ypos, 700, 50);
	   ypos+=100;
	   Topic[i].setBackground(UISettings.WinBGColor);
	   Topic[i].setOpaque(true);
	   Topic[i].setForeground(UISettings.TextColor);
	   Topic[i].setFont(fc);
	   add(Topic[i]);
	   }
	   
	   //Question Order
	   rand = new Random();
	   int temp;
	   while(QueOrder.size()<Main.NoOfQues)
	   {
		   temp=rand.nextInt(100);
		   if(temp>0)
		   {
			   temp=temp % (Main.NoOfQues);
			   if(!QueOrder.contains(temp+1))
			   {
				   QueOrder.add(temp+1);
			   }
		   }
	   }
	   temp=0;
	   while(temp<QueOrder.size()) {
		   System.out.println(QueOrder.get(temp));
		   temp++;
	   }
	  
	   
	   	   add(jl);
	   	   status = new UIStatus();
	   	   status.Visible=true;
	   	   status.focused=0;
	   	   this.addMouseListener(this);
	   	   st= new ScanThread(Topic, status);
	   	   st.start(); 
	   	   
		    
		  
		 
		   studentHome.screenQue=0;
	   	   
	   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

@Override
public void mouseClicked(MouseEvent arg0) {
	 switch(status.focused)
	   {
	   case 0 :
		   new MathsHome().setVisible(true);
		   status.Visible=false;
		   setVisible(false);
		   break;
	   case 1 :
		   StoryHome.ansIndex=0;
		   System.out.println("Ques Order");
		   for(int i=0;i<Main.NoOfQues;i++)
			   System.out.print(QueOrder.get(i));
		   try {
			   
			new QuePicker().setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   status.Visible=false;
		   setVisible(false);
		   break;
	  /* case 2 :
		   
		   break; */
	   case 2 :
		   new Main().setVisible(true);
		   status.Visible=false;
		   setVisible(false);
		   break;
		   
	   }
	
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

}