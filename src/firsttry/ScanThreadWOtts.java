package firsttry;

import java.awt.Color;

import javax.swing.JLabel;

import firsttry.TEACHER.UISettings;

public class ScanThreadWOtts extends Thread{
	JLabel jl[];
	UIStatus status;
	public static Color WinBGColor = Color.WHITE;
	 public static Color TextColor = Color.BLACK;
	 public static Color HighlightBGColor = Color.BLUE;
	 public static Color HighlightTextColor = Color.WHITE;
	 public static long scanSpeed = UISettings.scanSpeed;
	 
	public ScanThreadWOtts(JLabel[] jl, UIStatus status)
	{
		this.jl=jl;
		this.status=status;
      
	}
	
	@Override
	public void run()
	{  
		
	   
	   try{
        while(status.Visible)
        {
        	for(int i = 0; i < jl.length; i++)
        	{ 
        		jl[i].setBackground(UISettings.HighlightBGColor);
        		jl[i].setForeground(UISettings.HighlightTextColor);
        		//jl[i].setBackground(HighlightBGColor);
        	//	jl[i].setForeground(HighlightTextColor);
        		status.focused=i;
        		String labelName=jl[i].getText().toString();
        		//ttsobj.sound(labelName);
        		Thread.sleep(scanSpeed);
        		if(!status.Visible)
        			break;
        		jl[i].setBackground(UISettings.WinBGColor);
        		jl[i].setForeground(UISettings.TextColor);
        		
        	}
        }
	   }catch(Exception e)
	   {}
        return;
	}

}
