package student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.media.sound.AudioFloatInputStream;
import java.util.*;
import DataInfo.DataInfo;

public class playMusic {
	 
	 playMusic()
	 {
		 
	 }
	 public static void main(String argc[]) throws Exception
	 {

		
		 String localDir;
		 localDir=DataInfo.DATA_DIR;
		 File f=new File(localDir+"//mario.wav");
		 AudioInputStream audio=AudioSystem.getAudioInputStream(f);
		 Clip clip = AudioSystem.getClip();
		 clip.open(audio);
		
		 clip.start();
		 while(true)
		 	System.out.print("Sachin");
		 
	 }
	
}
