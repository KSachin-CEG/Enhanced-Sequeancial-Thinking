package firsttry.TEACHER;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import DataInfo.DataInfo;
import firsttry.Main;

import student.studentHome;


public class AddQuestion extends JFrame implements ActionListener {
	JLabel label;
	static String from;
	JButton b1,b2,b3,b4;
	JTextField jb1,jb2,jb3,jb4,TitleBox;
	JTextField cp1,cp2,cp3,cp4;
	JButton cb1,cb2,cb3,cb4,tb;
	int noq,nop;
	JFrame jf;
	JLabel ScreenTitle;
	JButton homeButton;
	  String localDir;
	JLabel pic1,pic2,pic3,pic4;
	public AddQuestion() throws IOException
	{
		 setUndecorated(true);
		 JLabel jl=new JLabel();
		
		  Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
		  Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
		  Font fo = new Font(jl.getFont().getFontName(), Font.BOLD, 18);
		//  Font fo = new Font("Serif", Font.BOLD, 20);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      ScreenTitle = new JLabel("ENTER  STORY  TITLE , PICTURE  AND  THEIR CAPTION");
	      
		   ScreenTitle.setBounds(0, 50, screenSize.width, 50);
		   ScreenTitle.setOpaque(true);
		   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
		   ScreenTitle.setFont(ft);
		   add(ScreenTitle);
		homeButton=new JButton("HOME");
		jf=new JFrame("ADD QUE");
		b1=new JButton("PIC1");
		b2=new JButton("PIC2");
		b3=new JButton("PIC3");
		b4=new JButton("PIC4");
		cb1=new JButton("CAPTION 1");
		cb2=new JButton("CAPTION 2");
		cb3=new JButton("CAPTION 3");
		cb4=new JButton("CAPTION 4");
		tb=new JButton("TITLE");
		
		TitleBox = new JTextField("");
		TitleBox.setFont(ft);
		
		add(TitleBox);
		
		
		
		jb1=new JTextField();
		jb2=new JTextField();
		jb3=new JTextField();
		jb4=new JTextField();
		
		cp1=new JTextField();
		cp2=new JTextField();
		cp3=new JTextField();
		cp4=new JTextField();
		
		pic1=new JLabel();
		pic2=new JLabel();
		pic3=new JLabel();
		pic4=new JLabel();
		
		
		
		
		cp1.setFont(fo);
		cp2.setFont(fo);
		cp3.setFont(fo);
		cp4.setFont(fo);
		homeButton.setFont(fo);
		tb.setFont(fo);
		
		cb1.setFont(fo);
		cb2.setFont(fo);
		cb3.setFont(fo);
		cb4.setFont(fo);
		TitleBox.setFont(fo);
		b1.setFont(fo);
		b2.setFont(fo);
		b3.setFont(fo);
		b4.setFont(fo);
	
		
		
		
		TitleBox.setBounds(450, 150, 350, 30);
		tb.setBounds(820, 150, 100, 30);
		homeButton.setBounds(500, 750, 530, 30);
		
		add(homeButton);
		add(jb1);
		add(tb);
		
		cp1.setBounds(200,300,230, 30);
		cp2.setBounds(500,300,230,30);
		cp3.setBounds(800, 300, 230, 30);
		cp4.setBounds(1100, 300, 230, 30);
		
		cb1.setBounds(200,375,230, 20);
		cb2.setBounds(500,375,230,20);
		cb3.setBounds(800,375,230, 20);
		cb4.setBounds(1100,375,230, 20);
		
		pic1.setBounds(200,425,230,225);
		pic2.setBounds(500,425,230,225);
		pic3.setBounds(800,425,230,225);
		pic4.setBounds(1100,425,230,225);
		
		b1.setBounds(200,700,230, 20);
		b2.setBounds(500,700,230,20);
		b3.setBounds(800, 700, 230, 20);
		b4.setBounds(1100, 700, 230, 20);
		
		add(cp1);
		add(cp2);
		add(cp3);
		add(cp4);
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		add(pic1);
		add(pic2);
		add(pic3);
		add(pic4);
		
		homeButton.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		cb3.addActionListener(this);
		cb4.addActionListener(this);
		tb.addActionListener(this);
		localDir=DataInfo.STORY_DIR;
		File directory=new File(localDir);
         noq=directory.list().length;
         File lastDirec=new File(localDir+ "\\q"+Integer.toString(noq));
         nop=lastDirec.list().length;
         System.out.print("Ques number " + noq + "No. of pic "+ nop);
        if(nop==9) {
        	 String newDir=localDir+"\\q"+Integer.toString(noq + 1);
        	  File file = new File(newDir);
        	 // file
              boolean bool = file.mkdir();
              if(bool){
                 System.out.println("Directory created successfully");
              }else{
                 System.out.println("Sorry couldn’t create specified directory");
              }
         }
         else
        	 noq=noq-1;
         //{
        	// 
         //}
        	 
        
      
		
		   /*JFileChooser chooser = new JFileChooser();
	        FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                "JPG & GIF Images", "jpg", "gif");
	        chooser.setFileFilter(filter);
	        int returnVal = chooser.showOpenDialog(null);
	        
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            System.out.println("You chose to open this file: " +
	                    chooser.getSelectedFile().getName());
	             from=chooser.getSelectedFile().getAbsolutePath();
	            System.out.println(from);
	           /* Path src = Paths.get(from);
	            String to="C:\\Users\\KR. ARMAAN\\eclipse-workspace\\firsttry\\res\\";
	            Path dest = Paths.get(to);
	            try {
	            	 System.out.println("yo Bby");
	            	Files.copy(src,to);
	            	 System.out.println("no Bby");
	            }
	            catch(Exception e)
	            {
	            	System.out.println("In catch");
	            }
*/
				this.setLayout(null);
	           setVisible(true);
	          // setSize(1220,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        }
	    
		
		
		
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b1)
		{
			System.out.println("You chose to open this file: "  );
             System.out.println(noq);
			JFileChooser chooser = new JFileChooser();
	        FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                "JPG & GIF Images", "jpg", "jpeg");
	        chooser.setFileFilter(filter);
	        int returnVal = chooser.showOpenDialog(null);
	        
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            System.out.println("You chose to open this file: " +
	                    chooser.getSelectedFile().getName());
	             from=chooser.getSelectedFile().getAbsolutePath();
	        
	            System.out.println(from);
	            FileInputStream source = null;
				try {
					source = new FileInputStream(from);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	            
	            
	            System.out.println("NOQ " + noq);
	            String destLocation=localDir+"\\q"+Integer.toString(noq + 1) +"\\story"+Integer.toString(noq + 1)+"1.jpeg";
						
	            FileOutputStream dest = null;
				try {
					dest = new FileOutputStream(destLocation);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            BufferedInputStream bin= new BufferedInputStream(source);
	            BufferedOutputStream bout=new BufferedOutputStream(dest);
	           // jb1.setText(from);
	           int b=0;
	           while(b!=-1)
	           {
	        	   try {
					b=bin.read();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	   try {
					bout.write(b);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	   
	           }
	           try {
				bin.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	           try {
				bout.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        }
	        ImageIcon icon1 = new ImageIcon(from);

			   pic1.setIcon(icon1);
	        
	        
		}
		else if(e.getSource()==b2)
		{
			System.out.println("You chose to open this file: "  );
            
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                "JPG & GIF Images", "jpg", "jpeg");
	        chooser.setFileFilter(filter);
	        int returnVal = chooser.showOpenDialog(null);
	        
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            System.out.println("You chose to open this file: " +
	                    chooser.getSelectedFile().getName());
	             from=chooser.getSelectedFile().getAbsolutePath();
	        
	            System.out.println(from);
	            FileInputStream source = null;
				try {
					source = new FileInputStream(from);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	            
	            
	            System.out.println("NOQ " + noq);
	            String destLocation=localDir+"\\q"+Integer.toString(noq + 1) +"\\story"+Integer.toString(noq + 1)+"2.jpeg";
						
	            FileOutputStream dest = null;
				try {
					dest = new FileOutputStream(destLocation);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            BufferedInputStream bin= new BufferedInputStream(source);
	            BufferedOutputStream bout=new BufferedOutputStream(dest);
	            jb1.setText(from);
	           int b=0;
	           while(b!=-1)
	           {
	        	   try {
					b=bin.read();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	   try {
					bout.write(b);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	   
	           }
	           try {
				bin.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	           try {
				bout.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        }
	        ImageIcon icon1 = new ImageIcon(from);

			   pic2.setIcon(icon1);
		}
		else if(e.getSource()==b3)
		{
			System.out.println("You chose to open this file: "  );
            
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                "JPG & GIF Images", "jpg", "jpeg");
	        chooser.setFileFilter(filter);
	        int returnVal = chooser.showOpenDialog(null);
	        
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            System.out.println("You chose to open this file: " +
	                    chooser.getSelectedFile().getName());
	             from=chooser.getSelectedFile().getAbsolutePath();
	        
	            System.out.println(from);
	            FileInputStream source = null;
				try {
					source = new FileInputStream(from);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	            
	            
	            System.out.println("NOQ " + noq);
	            String destLocation=localDir+"\\q"+Integer.toString(noq + 1) +"\\story"+Integer.toString(noq + 1)+"3.jpeg";
	            
	            FileOutputStream dest = null;
				try {
					dest = new FileOutputStream(destLocation);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            BufferedInputStream bin= new BufferedInputStream(source);
	            BufferedOutputStream bout=new BufferedOutputStream(dest);
	            jb1.setText(from);
	           int b=0;
	           while(b!=-1)
	           {
	        	   try {
					b=bin.read();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	   try {
					bout.write(b);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	   
	           }
	           try {
				bin.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	           try {
				bout.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        }
	        ImageIcon icon1 = new ImageIcon(from);

			   pic3.setIcon(icon1);
		}
		else if(e.getSource()==b4)
		{
			System.out.println("You chose to open this file: "  );
            
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                "JPG & GIF Images", "jpg", "jpeg");
	        chooser.setFileFilter(filter);
	        int returnVal = chooser.showOpenDialog(null);
	        
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            System.out.println("You chose to open this file: " +
	                    chooser.getSelectedFile().getName());
	             from=chooser.getSelectedFile().getAbsolutePath();
	        
	            System.out.println(from);
	            FileInputStream source = null;
				try {
					source = new FileInputStream(from);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	            
	            
	            System.out.println("NOQ " + noq);
	            String destLocation=localDir+"\\q"+Integer.toString(noq + 1) +"\\story"+Integer.toString(noq + 1)+"4.jpeg";
	            FileOutputStream dest = null;
				try {
					dest = new FileOutputStream(destLocation);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            BufferedInputStream bin= new BufferedInputStream(source);
	            BufferedOutputStream bout=new BufferedOutputStream(dest);
	            jb1.setText(from);
	           int b=0;
	           while(b!=-1)
	           {
	        	   try {
					b=bin.read();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	   try {
					bout.write(b);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	   
	           }
	           try {
				bin.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	           try {
				bout.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        }
	        ImageIcon icon1 = new ImageIcon(from);

			   pic4.setIcon(icon1);
		}
		else if(e.getSource()==cb1)
		{
			String caption= cp1.getText().toString();
			String destLocation=localDir+"\\q"+Integer.toString(noq + 1) +"\\caption"+Integer.toString(noq + 1)+"1.txt";
				
			 BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(destLocation));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			    try {
					writer.write(caption);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
		}
		else if(e.getSource()==cb2)
		{
			String caption= cp2.getText().toString();
			String destLocation=localDir+"\\q"+Integer.toString(noq + 1) +"\\caption"+Integer.toString(noq + 1)+"2.txt";
			
			 BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(destLocation));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			    try {
					writer.write(caption);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
		}
		else if(e.getSource()==cb3)
		{
			String caption= cp3.getText().toString();
			String destLocation=localDir+"\\q"+Integer.toString(noq + 1) +"\\caption"+Integer.toString(noq + 1)+"3.txt";
			
			 BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(destLocation));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			    try {
					writer.write(caption);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
		}
		else if(e.getSource()==cb4)
		{
			String caption= cp4.getText().toString();
			String destLocation=localDir+"\\q"+Integer.toString(noq + 1) +"\\caption"+Integer.toString(noq + 1)+"4.txt";
			
			 BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(destLocation));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			    try {
					writer.write(caption);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
		
		}
		else if(e.getSource()==tb)
		{
			String caption= TitleBox.getText().toString();
			String destLocation=localDir+"\\q"+Integer.toString(noq + 1) +"\\title.txt";
					
			 BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(destLocation));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			    try {
					writer.write(caption);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else if(e.getSource()==homeButton)
		{
			File directory=new File(localDir);
	         noq=directory.list().length;
	         File lastDirec=new File(localDir+ "\\q"+Integer.toString(noq));
	         nop=lastDirec.list().length;
	         if(nop==9)
	        	 Main.NoOfQues= noq;
	         else
	        	lastDirec.delete();
	         System.out.println(nop);
	         
			new Main().setVisible(true);
			this.setVisible(false);
		}
		
	}

}
