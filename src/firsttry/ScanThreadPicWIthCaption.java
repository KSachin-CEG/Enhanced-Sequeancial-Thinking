package firsttry;

import java.awt.Color;

import javax.swing.JLabel;

import firsttry.TEACHER.UISettings;

public class ScanThreadPicWIthCaption extends Thread  
	{
		JLabel jl1[];
		JLabel jl2[];
		UIStatus status;
		public static Color WinBGColor = Color.WHITE;
		 public static Color TextColor = Color.BLACK;
		 public static Color HighlightBGColor = Color.BLUE;
		 public static Color HighlightTextColor = Color.WHITE;
		 public static long scanSpeed = UISettings.scanSpeed;
		 
		public ScanThreadPicWIthCaption(JLabel[] jl1, JLabel[] jl2, UIStatus status)
		{
			this.jl1=jl1;
			this.jl2=jl2;
			this.status=status;
	      
		}
		
		
		@Override
		public void run()
		{  
			//TTS ttsobj=new TTS();
		   
		   try{
	        while(status.Visible)
	        {
	        	for(int i = 0; i < jl1.length; i++)
	        	{ 
	        		//jl[i].setBackground(HighlightBGColor);
	        	//	jl[i].setForeground(HighlightTextColor);
	        		jl1[i].setBackground(UISettings.HighlightBGColor);
	        		jl1[i].setForeground(UISettings.HighlightTextColor);
	        		jl2[i].setBackground(UISettings.HighlightBGColor);
	        		jl2[i].setForeground(UISettings.HighlightTextColor);
	        		status.focused=i;
	        		//String labelName=jl[i].getText().toString();
	        		//ttsobj.sound(labelName);
	        		Thread.sleep(scanSpeed);
	        		if(!status.Visible)
	        			break;
	        		//jl[i].setBackground(WinBGColor);
	        	//	jl[i].setForeground(TextColor);
	        		jl1[i].setBackground(UISettings.WinBGColor);
	        		jl1[i].setForeground(UISettings.TextColor);
	        		jl2[i].setBackground(UISettings.WinBGColor);
	        		jl2[i].setForeground(UISettings.TextColor);
	        		
	        	}
	        }
		   }catch(Exception e)
		   {}
	        return;
		}


}
