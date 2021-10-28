package firsttry;
import DataInfo.DataInfo;
import java.awt.*;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.EventObject;

//import java.awt.event.MouseListener;

import javax.swing.*;

//import org.anna.mathass.res.DataInfo;
import student.studentHome;
import firsttry.TEACHER.UISettings;

import firsttry.TEACHER.Login;
public class Main extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	   Main HomeScreen;
	   JLabel Topic[],ScreenTitle;
	   JButton fac;
	   int hitCount = 0;
	   JFrame login;
	   public Boolean isFacultyOpen = false;
	   public UIStatus status;
	   ScanThread st;
	   public static int NoOfQues; 
	   public Main()
	   {
		   	  setUndecorated(true);
		      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		      setBounds(0,0,screenSize.width, screenSize.height);
		      Toolkit tk = Toolkit.getDefaultToolkit();  
		      int x = ((int) tk.getScreenSize().getWidth());
			   JLabel jl = new JLabel();
			   if(!isDataDirAvailable()) {
				   JOptionPane.showMessageDialog(this, "There is a problem with data directory hirarchy.\n The system may not work properly");
			   }
			
				   
			   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
			   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
			   fac = new JButton(" ");
			   JPanel south = new JPanel(new GridLayout(1,5));
			   //south.setBackground(Color.blue);
			   south.addMouseListener(this);
			   fac.addMouseListener(this);
			   for(int i = 0; i < 3; i++)
			   {
				   south.add(new JLabel("  "));
			   }
			   south.add(fac);
			   ScreenTitle = new JLabel("SEQUENTIAL  THINKING");
			   ScreenTitle.setBounds((x/2)-(800/2), 250, 800, 50);
			  // ScreenTitle.setBackground(Color.BLACK);
			   ScreenTitle.setOpaque(true);
			   //ScreenTitle.setForeground(Color.GRAY);
			   ScreenTitle.setFont(ft);
			   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
			   add(ScreenTitle);
			   
			   String tstr[]={"STUDENT","TEACHER","EXIT"};
			   Topic = new JLabel[tstr.length];
			   int ypos=350;
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
			   
			   add(jl);
			   String localDir=DataInfo.STORY_DIR;
			   File directory=new File(localDir);
			   Main.NoOfQues=directory.list().length;
			  // System.out.println(NoOfQues);
			   status = new UIStatus();
		   	   status.Visible=true;
		   	   status.focused=0;
		   	   this.addMouseListener(this);
		   
		   	   st= new ScanThread(Topic, status);
		   	   st.start();
		   	  // add(south,BorderLayout.SOUTH);
		   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   	System.out.print(UISettings.scanSpeed);
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().setVisible(true);

	}
	private boolean isDataDirAvailable()
	{   
		File f;
		
		if(!(f = new File(DataInfo.GLOBAL_PARA_DIR)).isDirectory())
			if(!f.mkdirs())
				return false;
		if(!(f = new File(DataInfo.STORY_DIR)).isDirectory())
		    if(!f.mkdirs())
			return false;
		return true;
		
	}
	
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	@Override
	public void mouseClicked(MouseEvent event) {
		
		 if(event.getSource().equals(fac))
		   {   
		       if(!isFacultyOpen)
			   {
			   login  = new Login(this);
			   login.setVisible(true);
			   isFacultyOpen = true;
			   }
			   else
				   Toolkit.getDefaultToolkit().beep();

		   }
		   else if(!isFacultyOpen)
		   switch(status.focused)
		   {
		   case 0 :
			   new studentHome().setVisible(true);
			   status.Visible=false;
			   setVisible(false);
			   break;
		   case 1 :
			   new Login(login).setVisible(true);
			   status.Visible=false;
			   setVisible(false); 
			   break;
		   case 2:
			   System.exit(0);
			   break;
		   
			   
		   }
		   
		
	}
	

}
