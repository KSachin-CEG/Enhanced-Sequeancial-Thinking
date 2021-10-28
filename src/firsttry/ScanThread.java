package firsttry;
import java.awt.Color;

import javax.swing.*;

//import org.anna.mathass.ui.UISettings;

import firsttry.TEACHER.UISettings;
public class ScanThread extends Thread {
	JLabel jl[];
	UIStatus status;
	public static Color WinBGColor = Color.WHITE;
	 public static Color TextColor = Color.BLACK;
	 public static Color HighlightBGColor = Color.BLUE;
	 public static Color HighlightTextColor = Color.WHITE;
	 public static long scanSpeed = UISettings.scanSpeed;
	 
	public ScanThread(JLabel[] jl, UIStatus status)
	{
		this.jl=jl;
		this.status=status;
      
	}
	

	@Override
	public void run()
	{  
		//TTS ttsobj=new TTS();
	   
	   try{
        while(status.Visible)
        {
        	for(int i = 0; i < jl.length; i++)
        	{ 
        		//jl[i].setBackground(HighlightBGColor);
        	//	jl[i].setForeground(HighlightTextColor);
        		jl[i].setBackground(UISettings.HighlightBGColor);
        		jl[i].setForeground(UISettings.HighlightTextColor);
        		status.focused=i;
        		String labelName=jl[i].getText().toString();
        		//ttsobj.sound(labelName);
        		Thread.sleep(scanSpeed);
        		if(!status.Visible)
        			break;
        		//jl[i].setBackground(WinBGColor);
        	//	jl[i].setForeground(TextColor);
        		jl[i].setBackground(UISettings.WinBGColor);
        		jl[i].setForeground(UISettings.TextColor);
        		
        	}
        }
	   }catch(Exception e)
	   {}
        return;
	}

}

