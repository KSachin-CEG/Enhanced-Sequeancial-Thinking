package student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import firsttry.Main;
import firsttry.ScanThread;
import firsttry.UIStatus;
import firsttry.TEACHER.UISettings;
import sun.security.util.IOUtils;
import firsttry.ScanThreadPicWIthCaption;


public class MathsHome  extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 	MathsHome HomeScreen;
	   JLabel Topic[],ScreenTitle;
	   ScanThread st;
	   public UIStatus status;
	   JButton fac;
	   int hitCount = 0;
	   JFrame login;
	   public Boolean isFacultyOpen = false;
	   public MathsHome()
	   {
		      setUndecorated(true);
		      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		      setBounds(0,0,screenSize.width, screenSize.height);
		      Toolkit tk = Toolkit.getDefaultToolkit();  
		      int x = ((int) tk.getScreenSize().getWidth());
		   JLabel jl = new JLabel();
		   
		   UISettings.loadSettings();
		   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
		   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
		   fac = new JButton("Faculty");
		   JPanel south = new JPanel(new GridLayout(1,5));
		   south.addMouseListener(this);
		   fac.addMouseListener(this);
		   for(int i = 0; i < 4; i++)
		   {
			   south.add(new JLabel("  "));
		   }
		   south.add(fac);
		   ScreenTitle = new JLabel("MATHS ");
		   ScreenTitle.setBounds((x/2)-(800/2), 50, 800, 50);
		   //ScreenTitle.setBackground(Color.BLACK);
		   ScreenTitle.setOpaque(true);
		   //ScreenTitle.setForeground(Color.GRAY);
		   ScreenTitle.setFont(ft);
		   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
		   add(ScreenTitle);
		   
		   //Tipics
		   String tstr[]={"SERIES","MULTIPLICATION","LARGEST NUMBER","SMALLEST NUMBER","PICK ODD ONE","HOME"};
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
		   
		   	   add(jl);
		   	   status = new UIStatus();
		   	   status.Visible=true;
		   	   status.focused=0;
		   	   this.addMouseListener(this);
		   	   st= new ScanThread(Topic, status);
		   	   st.start();
		   	   add(south,BorderLayout.SOUTH);
		   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 switch(status.focused)
		   {
		   case 0 :
			 //  new MathsHome().setVisible(true);
			   status.Visible=false;
			   setVisible(false);
			   break;
		   case 1 :
			  // new StoryHome().setVisible(true);
			   status.Visible=false;
			   setVisible(false);
			   break;
		  /* case 2 :
			   
			   break; */
		   case 2 :
			 //  new Main().setVisible(true);
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
