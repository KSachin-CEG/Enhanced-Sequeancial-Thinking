package firsttry.TEACHER;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import DataInfo.DataInfo;
import firsttry.ScanThread;
import firsttry.UIStatus;
import firsttry.ScanThreadWOtts;

public class StudentUISettings extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Dimension dim;
	JMenu back;
	JPanel preview,pewviewScan,settingComponents,left,leftGrid,scanGrid;
	JLabel normText,scanText[],compl[];
	JComboBox compList[];
	String compStr[] = {"    Window BG Color"      ,"    Text Color",
			         //   "    Workbook BG Color"    ,"    Workbook Text Color",
			           // "    Workbook Cursor Color",
			            "    Highlighted BG Color",
			            "    Highlighted Text Color"  ,"    Font Size Level",
			            "    Scan Delay (ms)"};
	Font fc;
	ScanThreadWOtts sctr;
	UIStatus status;
	JTextPane workbook;
	JButton save,cancel;
	StudentUISettings()
	{
		super("Student UI Settings");
		dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim);
		this.getContentPane().setLayout(new GridLayout(1,2));
		JLabel jl = new JLabel();
		Font fp= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+15);
		Font fs= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+10);
		left = new JPanel(new BorderLayout());
		//left.setOpaque(true);
		leftGrid = new JPanel(new GridLayout(2,1));
		preview = new JPanel(new GridLayout(2,1));
		JLabel tit = new JLabel("Preview");
		//tit.setOpaque(true);
		//tit.setBackground(Color.WHITE);
		tit.setForeground(Color.BLACK);
		tit.setFont(fp);
		tit.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		normText = new JLabel("Normal Text");
		normText.setOpaque(true);
		normText.setHorizontalAlignment(SwingConstants.HORIZONTAL);
	    workbook = new JTextPane(); // creates an empty text pane
	    workbook.setContentType("text/html");                   
	    workbook.setEditable(false);
	    workbook.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
		preview.setOpaque(true);
		preview.add(normText);
		//preview.add(workbook);
		leftGrid.setOpaque(true);
		leftGrid.add(preview);
		left.add(tit, BorderLayout.NORTH);
		left.add(leftGrid, BorderLayout.CENTER);
		scanGrid = new JPanel(new GridLayout(3,1));
		scanText = new JLabel[4];
		 String localDir=DataInfo.STORY_DIR;
		for(int i = 0; i< 4; i++)
		{
			scanText[i] = new JLabel();
			scanText[i].setOpaque(true);
			scanText[i].setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon1 = new ImageIcon(localDir+"//q"+Integer.toString(1)+"/story"+Integer.toString(1)+Integer.toString(i+1)+".jpeg");
			scanText[i].setIcon(icon1);
			scanGrid.add(scanText[i]);
		}
		leftGrid.add(scanGrid);
		
		settingComponents = new JPanel(new GridLayout(21,2));
		compl = new JLabel[6];
		compList = new JComboBox[6];
		save = new JButton("Save");
		save.setFont(fs);
		cancel = new JButton("Cancel");
		cancel.setFont(fs);
		for(int i = 0; i < 6 ; i++ )
		{
			compl[i] = new JLabel(compStr[i]); 
			compl[i].setFont(fs);
			if(i == 4)
			compList[i] = new JComboBox(UISettings.fontLevel);
			else if(i == 5)
			compList[i] = new JComboBox(UISettings.scanSpeeds);
			else
			compList[i] = new JComboBox(UISettings.colorNames);
			compList[i].setFont(fs);
			compList[i].addActionListener(this);
			settingComponents.add(compl[i]);
			settingComponents.add(compList[i]);
			settingComponents.add(new JLabel(" "));
			settingComponents.add(new JLabel(" "));
		}
		JPanel savePane = new JPanel(new BorderLayout());
		savePane.add(new JLabel("    "),BorderLayout.EAST);
		savePane.add(new JLabel("    "),BorderLayout.WEST);
		savePane.add(save,BorderLayout.CENTER);
		JPanel cancelPane = new JPanel(new BorderLayout());
		cancelPane.add(new JLabel("    "),BorderLayout.EAST);
		cancelPane.add(new JLabel("    "),BorderLayout.WEST);
		cancelPane.add(cancel,BorderLayout.CENTER);
		settingComponents.add(savePane);
		settingComponents.add(cancelPane);
		cancel.addActionListener(this);
		save.addActionListener(this);
		add(left);
		add(settingComponents);
		status = new UIStatus();
		status.Visible = true;
		status.focused = 0;
		back = new JMenu("Back");
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(back);
		back.addMouseListener(this);
		sctr = new ScanThreadWOtts(scanText, status);
		sctr.start();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		renderPreview();
	}
	private void renderPreview()
	{
		JLabel jl = new JLabel();
		fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
		preview.setBackground(UISettings.WinBGColor);
		//left.setBackground(UISettings.WinBGColor);
		leftGrid.setBackground(UISettings.WinBGColor);
		normText.setBackground(UISettings.WinBGColor);
		normText.setForeground(UISettings.TextColor);
		normText.setFont(fc);
		
		for(int i = 0; i<scanText.length; i++)
		{
			scanText[i].setBackground(UISettings.WinBGColor);
			scanText[i].setForeground(UISettings.TextColor);
			scanText[i].setFont(fc);
		}
		workbook.setText("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fc.getSize())+"; font-weight:bold;font-family:"+fc.getName()+";\"><center><b>Work Book<b><table><tr><td>A = B + C </td><td style=\"font-size: "+(fc.getSize())+"pt; color:"+UISettings.WorkCurColor+"; font-family:'Lucida Sans Unicode', 'Lucida Grande', sans-serif \" >I</td></tr></tabel></body>"); 
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub	
		Object obj = event.getSource();
		if(obj.equals(compList[0]))
			UISettings.WinBGColor = UISettings.getColorObject(compList[0].getSelectedIndex()+1);
		else if(obj.equals(compList[1]))
			UISettings.TextColor = UISettings.getColorObject(compList[1].getSelectedIndex()+1);
		//else if(obj.equals(compList[2]))
		//	UISettings.WorkBKBGColor = compList[2].getSelectedItem().toString();
		//else if(obj.equals(compList[3]))
		//	UISettings.WorkTextColor = compList[3].getSelectedItem().toString();
		//else if(obj.equals(compList[4]))
		//	UISettings.WorkCurColor = compList[4].getSelectedItem().toString();
		else if(obj.equals(compList[2]))
			UISettings.HighlightBGColor = UISettings.getColorObject(compList[2].getSelectedIndex()+1);
		else if(obj.equals(compList[3]))
			UISettings.HighlightTextColor = UISettings.getColorObject(compList[3].getSelectedIndex()+1);
		else if(obj.equals(compList[4]))
			UISettings.adFontSize = Integer.parseInt(compList[4].getSelectedItem().toString());
		else if(obj.equals(compList[5]))  {
			UISettings.scanSpeed = Integer.parseInt(compList[5].getSelectedItem().toString());
			System.out.print(UISettings.scanSpeed);
		}
		else if(obj.equals(cancel))
			UISettings.loadSettings();
		else if(obj.equals(save))
		{
			UISettings.setSettings(compList[0].getSelectedIndex()+1, compList[1].getSelectedIndex()+1,
					//compList[2].getSelectedIndex()+1, compList[3].getSelectedIndex()+1, 
					//compList[4].getSelectedIndex()+1, 
					compList[2].getSelectedIndex()+1,
					compList[3].getSelectedIndex()+1,compList[4].getSelectedItem().toString(),
					compList[5].getSelectedItem().toString());
			        UISettings.loadSettings();
		}
		renderPreview();
	}
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(back))
		{
			new FacultyHome().setVisible(true);
			status.Visible = false;
			dispose();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}

}
