import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MoveWindow extends JFrame {


	static MoveWindow w = new MoveWindow();
	// PATHS
	String current="";
	String this_dir = System.getProperty("user.dir");
//	// Source
//	private String pS = this_dir + "\\source.txt";
	
	// Source
	private String pS = "";
	// Keywords
	private String pK1 = "";
	private String pK2 = "";
	private String pK3 = "";
	private String pK4 = "";
	private String pK5 = "";
	// Destinations
	private String pD1 = "";
	private String pD2 = "";
	private String pD3 = "";
	private String pD4 = "";
	private String pD5 = "";
	// color
	private String colortxt = current + "\\color.txt";
	// Keywords
//		private String pK1 = current + "\\key1.txt";
//		private String pK2 = current + "\\key2.txt";
//		private String pK3 = current + "\\key3.txt";
//		private String pK4 = current + "\\key4.txt";
//		private String pK5 = current + "\\key5.txt";
//		// Destinations
//		private String pD1 = current + "\\destination1.txt";
//		private String pD2 = current + "\\destination2.txt";
//		private String pD3 = current + "\\destination3.txt";
//		private String pD4 = current + "\\destination4.txt";
//		private String pD5 = current + "\\destination5.txt";
//		// color
//		private String colortxt = current + "\\color.txt";
		
		private MoveFiles mv1;
		private MoveFiles mv2;
		private MoveFiles mv3;
		private MoveFiles mv4;
		private MoveFiles mv5;
//	// Keywords
//	private String pK1 = this_dir + "\\key1.txt";
//	private String pK2 = this_dir + "\\key2.txt";
//	private String pK3 = this_dir + "\\key3.txt";
//	private String pK4 = this_dir + "\\key4.txt";
//	private String pK5 = this_dir + "\\key5.txt";
//	// Destinations
//	private String pD1 = this_dir + "\\destination1.txt";
//	private String pD2 = this_dir + "\\destination2.txt";
//	private String pD3 = this_dir + "\\destination3.txt";
//	private String pD4 = this_dir + "\\destination4.txt";
//	private String pD5 = this_dir + "\\destination5.txt";
//	// color
//	private String colortxt = this_dir + "\\color.txt";

	// MOVE FILES
//	private MoveFiles mv1 = new MoveFiles(pS, pK1, pD1);
//	private MoveFiles mv2 = new MoveFiles(pS, pK2, pD2);
//	private MoveFiles mv3 = new MoveFiles(pS, pK3, pD3);
//	private MoveFiles mv4 = new MoveFiles(pS, pK4, pD4);
//	private MoveFiles mv5 = new MoveFiles(pS, pK5, pD5);

	// LISTENER
	Listener listener = new Listener();
	MenuListener menuListener = new MenuListener();

	// SOURCE
	private JLabel source;
	private JTextField sourceTextField;
	private JButton resetSource;

	// TEXT
	private String pathButtonText = "Select path...";
	private String chooseDestText1 = "Add destination folder";
	private String chooseDestText2 = "Change destination folder";

	// KEYWORDS
	private JLabel keySample;
	// keyword 1
	private JLabel key1;
	private JLabel currentKey1;
	private JTextField keyTextField1;
	private JButton resetKey1;

	// keyword 2
	private JLabel key2;
	private JLabel currentKey2;
	private JTextField keyTextField2;
	private JButton resetKey2;

	// keyword 3
	private JLabel key3;
	private JLabel currentKey3;
	private JTextField keyTextField3;
	private JButton resetKey3;

	// keyword 4
	private JLabel key4;
	private JLabel currentKey4;
	private JTextField keyTextField4;
	private JButton resetKey4;

	// keyword 5
	private JLabel key5;
	private JLabel currentKey5;
	private JTextField keyTextField5;
	private JButton resetKey5;
	
	// DESTINATIONS
	private JLabel destinationSample;
	// destination 1
	private JTextField destTextField1;
	private JButton pathButtonD1 = new JButton();
	private JButton resetDest1;
	private JLabel destination1;

	// destination 2
	private JTextField destTextField2;
	private JButton pathButtonD2;
	private JButton resetDest2;
	private JLabel destination2;

	// destination 3
	private JTextField destTextField3;
	private JButton pathButtonD3;
	private JButton resetDest3;
	private JLabel destination3;

	// destination 4
	private JTextField destTextField4;
	private JButton pathButtonD4;
	private JButton resetDest4;
	private JLabel destination4;

	// destination 5
	private JTextField destTextField5;
	private JButton pathButtonD5;
	private JButton resetDest5;
	private JLabel destination5;

	// Single Buttons
	//Move Files
	private JButton pathButtonSource;
	private JButton go = new JButton("Move files");
	//Reset all
	private JButton resetAll;
	
	//JMenubar
	JMenuBar menuBar;
	//JMenu
	JMenu mainMenu;
	JMenu helpMenu;
	JMenu color;
	//JMenuItem options
	Color greyDefault;
	JMenuItem pink;
	JMenuItem yellow;
	JMenuItem red;
	JMenuItem black;
	JMenuItem green;
	JMenuItem defaultColor;
	//JMenuItem help
	JMenuItem infoItem;
	JMenuItem update;
	

	// BOOLEANS
	boolean sourceAdded = false;
	boolean dest1Added = false;
	boolean dest2Added = false;
	boolean dest3Added = false;
	boolean dest4Added = false;
	boolean dest5Added = false;
	boolean colorP = false;

	// main method to open the window
	public static void main(String[] args) {

	}

	// constructor
	MoveWindow() {
		super("SortFiles Version 1.0");
		try {
			String current = new java.io.File( "." ).getCanonicalPath();
			System.out.println(current);
			this.current=current;
			pS = current + "\\source.txt";
			pK1 = current + "\\key1.txt";
			pK2 = current + "\\key2.txt";
		    pK3 = current + "\\key3.txt";
			pK4 = current + "\\key4.txt";
			pK5 = current + "\\key5.txt";
			// Destinations
			pD1 = current + "\\destination1.txt";
			pD2 = current + "\\destination2.txt";
			pD3 = current + "\\destination3.txt";
			pD4 = current + "\\destination4.txt";
			pD5 = current + "\\destination5.txt";
			// color
			colortxt = current + "\\color.txt";
			mv1 = new MoveFiles(pS, pK1, pD1);
			mv2 = new MoveFiles(pS, pK2, pD2);
			mv3 = new MoveFiles(pS, pK3, pD3);
			mv4 = new MoveFiles(pS, pK4, pD4);
			mv5 = new MoveFiles(pS, pK5, pD5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		if(readColor()!=null&&readColor()!=""){
			Color dc = this.getContentPane().getBackground();
			this.greyDefault = dc;
		if(readColor().equals("PINK")){
			getContentPane().setBackground(Color.PINK);
		}
		if(readColor().equals("YELLOW")){
			getContentPane().setBackground(Color.YELLOW);
		}
		if(readColor().equals("GREEN")){
			getContentPane().setBackground(Color.GREEN);
		}
		if(readColor().equals("RED")){
			getContentPane().setBackground(Color.RED);
		}
		if(readColor().equals("BLACK")){
			getContentPane().setBackground(Color.BLACK);
		}
		if(readColor().equals("DEFAULT")){
			getContentPane().setBackground(greyDefault);
		}
		}
		else{
			getContentPane().setBackground(greyDefault);
		}

		
		
		
		// reset the layout
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(null);
//		getContentPane().setBackground( Color.YELLOW );

		addSource();
		addItem(1);
		addItem(2);
		addItem(3);
		addItem(4);
		addItem(5);
		addResetAll();
		addMoveButton();
		addMenuBar();

		// obligatory JFrame methods
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 500);
		setVisible(true);

	}

	
	/**
	 * 
	 * @return Returns the text of the document "color.txt"
	 */
	public String readColor(){
		try{
		BufferedReader br = new BufferedReader(new FileReader(colortxt));
		String ret = br.readLine();
		br.close();
		return ret;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * The JButton to move the files
	 */
	public void addMoveButton() {
		go.setBounds(790, 350, 110, 70);
		go.addActionListener(listener);
		add(go);
	}
	
	public void addResetAll(){
		resetAll = new JButton("Reset All");
		Dimension r = resetAll.getPreferredSize();
		resetAll.setBounds(950+110, 30, r.width, 20);
		resetAll.addActionListener(listener);
		add(resetAll);
	}

	/**
	 * adds a JLabel, JTextField and JButton for the source path
	 */
	public void addSource() {

		// JTextField
		sourceTextField = new JTextField();
		sourceTextField.setText(mv1.readSource());
		sourceTextField.setBounds(160, 40, 190, 20);
		sourceTextField.addActionListener(listener);
		add(sourceTextField);
		if (!(sourceTextField.getText().isEmpty())) {
			sourceAdded = true;
		}

		// JLabel
		if (!sourceAdded) {
			source = new JLabel("Add source folder");
			Dimension sizeSource = source.getPreferredSize();
			source.setBounds(10, 40, sizeSource.width, sizeSource.height);
			add(source);
		} else {
			source = new JLabel("Change source folder");
			Dimension sizeSource2 = source.getPreferredSize();
			source.setBounds(10, 40, sizeSource2.width, sizeSource2.height);
			add(source);
		}
		
		if(readColor().equals("BLACK")){
		    source.setForeground(Color.WHITE);
		}

		// JButton Select
		pathButtonSource = new JButton(pathButtonText);
		pathButtonSource.setBounds(360, 40, 110, 20);
		pathButtonSource.addActionListener(listener);
		add(pathButtonSource);

		// JButton reset
		resetSource = new JButton("Reset");
		Dimension rS = resetSource.getPreferredSize();
		resetSource.setBounds(470, 40, rS.width, 20);
		resetSource.addActionListener(listener);
		add(resetSource);
	}
	
	public void addMenuBar(){
	
		//JMenuBar
		menuBar = new JMenuBar();
		//JMenu
		mainMenu = new JMenu("Options");
		helpMenu = new JMenu("Help");
		color = new JMenu("Change Background Color!");
		mainMenu.add(color);
//		helpMenu.setMnemonic(KeyEvent.VK_F);
		//JMenuItem
		infoItem = new JMenuItem("How to use?");
		infoItem.addActionListener(menuListener);
		update = new JMenuItem("Updates?");
		update.addActionListener(menuListener);
		
		pink = new JMenuItem("pink");
		pink.addActionListener(menuListener);
		yellow = new JMenuItem("yellow");
		yellow.addActionListener(menuListener);
		black = new JMenuItem("black");
		black.addActionListener(menuListener);
		red = new JMenuItem("red");
		red.addActionListener(menuListener);
		green = new JMenuItem("green");
		green.addActionListener(menuListener);
		defaultColor = new JMenuItem("Reset");
		defaultColor.addActionListener(menuListener);
	
		
		//add to Menu
		helpMenu.add(infoItem);
		helpMenu.add(update);
		color.add(pink);
		color.add(yellow);
		color.add(black);
		color.add(green);
		color.add(red);
		color.add(defaultColor);
		//add to MenuBar
		menuBar.add(mainMenu);
		menuBar.add(helpMenu);
		//
		setJMenuBar(menuBar);
		
	
		
		
	}
	

	
	/**
	 * Add JLabel displaying the current keyword Add a JLabel and JTextField for
	 * your keyword iput. Add a JLabel, JTextField and JButton for your
	 * destination. Add a reset JButton.
	 * 
	 * @param n
	 *            Determines the positioning in the JFrame and the the number of
	 *            the keyword.
	 */
	public void addItem(int n) {
		keySample = new JLabel("Add/change your " + n + ". keyword");
		Dimension sizeKey = keySample.getPreferredSize();
		destinationSample = new JLabel("Enter the destination folder");
		Dimension sizeDes = destinationSample.getPreferredSize();

		// common x values case 1,2,3
		// JLabel
		int xL = 10;
		// JTextField
		int xT = 200;
		// JButton
		int xB = 360;

		// common x values case 4,5
		// JLabel
		int xL2 = 600;
		// JTextField
		int xT2 = 790;
		// JButton
		int xB2 = 950;

		// common y values
		// case 1
		// Show Keyword JLabel
		int yCur1 = 100;
		// Keyword JLabel JTextField
		int y1a = 130;
		// Destination JLabel, JTextField, JButton
		int y1b = 160;

		// case 2
		// Show Keyword JLabel
		int yCur2 = 220;
		// Keyword JLabel JTextField
		int y2a = 250;
		// Destination JLabel, JTextField, JButton
		int y2b = 280;

		// case 3
		// Show Keyword JLabel
		int yCur3 = 340;
		// Keyword JLabel JTextField
		int y3a = 370;
		// Destination JLabel, JTextField, JButton
		int y3b = 400;

		switch (n) {
		case 1:
			// KEYWORD
			// JLabel "Your current keyword"
			if(mv1.readKey()==null||mv1.readKey().equals("")){
				mv1.setNewKeyWord("...");
				mv1.saveKeyword();
			}
			currentKey1 = new JLabel("Your current " + n + ". keyword:                 " + mv1.readKey());
			Dimension cK1 = currentKey1.getPreferredSize();
			currentKey1.setBounds(xL, yCur1, cK1.width, cK1.height);
			if(readColor().equals("BLACK")){
			    currentKey1.setForeground(Color.WHITE);
			}
			add(currentKey1);

			// JLabel "Add/change your " + n + ". keyword"
			String check = mv1.readKey();
			if(check==null||check.isEmpty()||check.equals("...")){
			key1 = new JLabel("Add your " + n + ". keyword");
			key1.setBounds(xL, y1a, sizeKey.width, sizeKey.height);
			add(key1);
			}
			else{
				key1 = new JLabel("Change your " + n + ". keyword");
				key1.setBounds(xL, y1a, sizeKey.width, sizeKey.height);
				add(key1);
			}
			if(readColor().equals("BLACK")){
			    key1.setForeground(Color.WHITE);
			}
			
			//JButton reset key
			resetKey1 = new JButton("Reset");
			Dimension rD1 = resetKey1.getPreferredSize();
			resetKey1.setBounds(470, y1a, rD1.width, 20);
			resetKey1.addActionListener(listener);
			add(resetKey1);

			// JTextField
			keyTextField1 = new JTextField();
			keyTextField1.setBounds(xT, y1a, 150, 20);
			keyTextField1.addActionListener(listener);
			// mv1.setNewKeyWord(mv1Key);
			add(keyTextField1);

			// DESTINATION

			// JTextField
			destTextField1 = new JTextField();
			destTextField1.setBounds(xT, y1b, 150, 20);
			destTextField1.setText(mv1.readDestination());
			add(destTextField1);

			// JLabel "Enter the destination folder"
			if (destTextField1.getText().isEmpty()) {
				destination1 = new JLabel(chooseDestText1);
				sizeDes = destination1.getPreferredSize();
				destination1.setBounds(xL, y1b, sizeDes.width, sizeDes.height);
				// mv1.setDestination(mv1Dest);
				add(destination1);
			} else {
				destination1 = new JLabel(chooseDestText2);
				sizeDes = destination1.getPreferredSize();
				destination1.setBounds(xL, y1b, sizeDes.width, sizeDes.height);
				// mv1.setDestination(mv1Dest);
				add(destination1);
			}
			if(readColor().equals("BLACK")){
			    destination1.setForeground(Color.WHITE);
			}

			
			// JButton Select
			pathButtonD1 = new JButton(pathButtonText);
			pathButtonD1.setBounds(xB, y1b, 110, 20);
			pathButtonD1.addActionListener(listener);
			add(pathButtonD1);

			// JButton reset
			resetDest1 = new JButton("Reset");
			resetDest1.setBounds(470, y1b, rD1.width, 20);
			resetDest1.addActionListener(listener);
			add(resetDest1);

			break;
		case 2:
			// KEYWORD
			// JLabel "Your current keyword"
			if(mv2.readKey()==null||mv2.readKey().equals("")){
				mv2.setNewKeyWord("...");
				mv2.saveKeyword();
			}
			currentKey2 = new JLabel("Your current " + n + ". keyword:                 " + mv2.readKey());
			Dimension cK2 = currentKey1.getPreferredSize();
			currentKey2.setBounds(xL, yCur2, cK2.width, cK2.height);
			if(readColor().equals("BLACK")){
			    currentKey2.setForeground(Color.WHITE);
			}
			add(currentKey2);

			// JLabel "Add/change your " + n + ". keyword"
			String check2 = mv2.readKey();
			if(check2==null||check2.isEmpty()||check2.equals("...")){
			key2 = new JLabel("Add your " + n + ". keyword");
			key2.setBounds(xL, y2a, sizeKey.width, sizeKey.height);
			add(key2);
			}
			else{
				key2 = new JLabel("Change your " + n + ". keyword");
				key2.setBounds(xL, y2a, sizeKey.width, sizeKey.height);
				add(key2);
			}
			if(readColor().equals("BLACK")){
			    key2.setForeground(Color.WHITE);
			}

			// JTextField
			keyTextField2 = new JTextField();
			keyTextField2.setBounds(xT, y2a, 150, 20);
			keyTextField2.addActionListener(listener);
			add(keyTextField2);
			
			//JButton reset key
			resetKey2 = new JButton("Reset");
			Dimension rD2 = resetKey1.getPreferredSize();
			resetKey2.setBounds(470, y2a, rD2.width, 20);
			resetKey2.addActionListener(listener);
			add(resetKey2);

			// DESTINATION
			// JTextField
			destTextField2 = new JTextField();
			destTextField2.setBounds(xT, y2b, 150, 20);
			destTextField2.setText(mv2.readDestination());
			add(destTextField2);

			// JLabel "Enter the destination folder"
			if (destTextField2.getText().isEmpty()) {
				destination2 = new JLabel(chooseDestText1);
				sizeDes = destination2.getPreferredSize();
				destination2.setBounds(xL, y2b, sizeDes.width, sizeDes.height);
				// mv2.setDestination(mv1Dest);
				add(destination2);
			} else {
				destination2 = new JLabel(chooseDestText2);
				sizeDes = destination2.getPreferredSize();
				destination2.setBounds(xL, y2b, sizeDes.width, sizeDes.height);
				// mv2.setDestination(mv1Dest);
				add(destination2);
			}
			if(readColor().equals("BLACK")){
			    destination2.setForeground(Color.WHITE);
			}

			// JButton Select
			pathButtonD2 = new JButton(pathButtonText);
			pathButtonD2.setBounds(xB, y2b, 110, 20);
			pathButtonD2.addActionListener(listener);
			add(pathButtonD2);

			// JButton reset
			resetDest2 = new JButton("Reset");
			resetDest2.setBounds(470, y2b, rD2.width, 20);
			resetDest2.addActionListener(listener);
			add(resetDest2);

			break;

		case 3:
			// KEYWORD
			// JLabel "Your current keyword"
			if(mv3.readKey()==null||mv3.readKey().equals("")){
				mv3.setNewKeyWord("...");
				mv3.saveKeyword();
			}
			currentKey3 = new JLabel("Your current " + n + ". keyword:                 " + mv3.readKey());
			Dimension cK3 = currentKey1.getPreferredSize();
			currentKey3.setBounds(xL, yCur3, cK3.width, cK3.height);
			if(readColor().equals("BLACK")){
			    currentKey3.setForeground(Color.WHITE);
			}
			add(currentKey3);

			// JLabel "Add/change your " + n + ". keyword"
			String check3 = mv3.readKey();
			if(check3==null||check3.isEmpty()||check3.equals("...")){
			key3 = new JLabel("Add your " + n + ". keyword");
			key3.setBounds(xL, y3a, sizeKey.width, sizeKey.height);
			add(key3);
			}
			else{
				key3 = new JLabel("Change your " + n + ". keyword");
				key3.setBounds(xL, y3a, sizeKey.width, sizeKey.height);
				add(key3);
			}
			if(readColor().equals("BLACK")){
			    key3.setForeground(Color.WHITE);
			}

			// JTextField
			keyTextField3 = new JTextField();
			keyTextField3.setBounds(xT, y3a, 150, 20);
			keyTextField3.addActionListener(listener);
			add(keyTextField3);
			
			//JButton reset key
			resetKey3 = new JButton("Reset");
			Dimension rD3 = resetKey3.getPreferredSize();
			resetKey3.setBounds(470, y3a, rD3.width, 20);
			resetKey3.addActionListener(listener);
			add(resetKey3);

			// DESTINATION
			// JTextField
			destTextField3 = new JTextField();
			destTextField3.setBounds(xT, y3b, 150, 20);
			destTextField3.setText(mv2.readDestination());
			add(destTextField3);

			// JLabel "Enter the destination folder"
			if (destTextField3.getText().isEmpty()) {
				destination3 = new JLabel(chooseDestText1);
				sizeDes = destination3.getPreferredSize();
				destination3.setBounds(xL, y3b, sizeDes.width, sizeDes.height);
				// mv3.setDestination(mv1Dest);
				add(destination3);
			} else {
				destination3 = new JLabel(chooseDestText2);
				sizeDes = destination3.getPreferredSize();
				destination3.setBounds(xL, y3b, sizeDes.width, sizeDes.height);
				// mv3.setDestination(mv1Dest);
				add(destination3);
			}
			if(readColor().equals("BLACK")){
			    destination3.setForeground(Color.WHITE);
			}

			// JButton Select
			pathButtonD3 = new JButton(pathButtonText);
			pathButtonD3.setBounds(xB, y3b, 110, 20);
			pathButtonD3.addActionListener(listener);
			add(pathButtonD3);

			// JButton reset
			resetDest3 = new JButton("Reset");
			resetDest3.setBounds(470, y3b, rD3.width, 20);
			resetDest3.addActionListener(listener);
			add(resetDest3);
			break;

		case 4:
			// KEYWORD
			// JLabel "Your current keyword"
			if(mv4.readKey()==null||mv4.readKey().equals("")){
				mv4.setNewKeyWord("...");
				mv4.saveKeyword();
			}
			currentKey4 = new JLabel("Your current " + n + ". keyword:                 " + mv4.readKey());
			Dimension cK4 = currentKey4.getPreferredSize();
			currentKey4.setBounds(xL2, yCur1, cK4.width, cK4.height);
			if(readColor().equals("BLACK")){
			    currentKey4.setForeground(Color.WHITE);
			}
			add(currentKey4);

			// JLabel "Add/change your " + n + ". keyword"
			String check4 = mv4.readKey();
			if(check4==null||check4.isEmpty()||check4.equals("...")){
			key4 = new JLabel("Add your " + n + ". keyword");
			key4.setBounds(xL2, y1a, sizeKey.width, sizeKey.height);
			add(key4);
			}
			else{
				key4 = new JLabel("Change your " + n + ". keyword");
				key4.setBounds(xL2, y1a, sizeKey.width, sizeKey.height);
				add(key4);
			}
			if(readColor().equals("BLACK")){
			    key4.setForeground(Color.WHITE);
			}

			// JTextField
			keyTextField4 = new JTextField();
			keyTextField4.setBounds(xT2, y1a, 150, 20);
			keyTextField4.addActionListener(listener);
			add(keyTextField4);
			
			//JButton reset key
			resetKey4 = new JButton("Reset");
			Dimension rD4 = resetKey4.getPreferredSize();
			resetKey4.setBounds(xB2 + 110, y1a, rD4.width, 20);
			resetKey4.addActionListener(listener);
			add(resetKey4);
			
			

			// DESTINATION
			// JTextField
			destTextField4 = new JTextField();
			destTextField4.setBounds(xT2, y1b, 150, 20);
			destTextField4.setText(mv4.readDestination());
			add(destTextField4);

			// JLabel "Enter the destination folder"
			if (destTextField4.getText().isEmpty()) {
				destination4 = new JLabel(chooseDestText1);
				sizeDes = destination4.getPreferredSize();
				destination4.setBounds(xL2, y1b, sizeDes.width, sizeDes.height);
				// mv3.setDestination(mv1Dest);
				add(destination4);
			} else {
				destination4 = new JLabel(chooseDestText2);
				sizeDes = destination4.getPreferredSize();
				destination4.setBounds(xL2, y1b, sizeDes.width, sizeDes.height);
				// mv3.setDestination(mv1Dest);
				add(destination4);

			}
			if(readColor().equals("BLACK")){
			    destination4.setForeground(Color.WHITE);
			}

			// JButton Select
			pathButtonD4 = new JButton(pathButtonText);
			pathButtonD4.setBounds(xB2, y1b, 110, 20);
			pathButtonD4.addActionListener(listener);
			add(pathButtonD4);

			// JButton reset x+110 zu JButton SelectPath
			resetDest4 = new JButton("Reset");
			resetDest4.setBounds(xB2 + 110, y1b, rD4.width, 20);
			resetDest4.addActionListener(listener);
			add(resetDest4);
			break;

		case 5:
			// KEYWORD
			// JLabel "Your current keyword"
			if(mv5.readKey()==null||mv5.readKey().equals("")){
				mv5.setNewKeyWord("...");
				mv5.saveKeyword();
			}
			currentKey5 = new JLabel("Your current " + n + ". keyword:                 " + mv5.readKey());
			Dimension cK5 = currentKey5.getPreferredSize();
			currentKey5.setBounds(xL2, yCur2, cK5.width, cK5.height);
			if(readColor().equals("BLACK")){
			    currentKey5.setForeground(Color.WHITE);
			}
			add(currentKey5);

			// JLabel "Add/change your " + n + ". keyword"
			String check5 = mv5.readKey();
			if(check5==null||check5.isEmpty()||check5.equals("...")){
			key5 = new JLabel("Add your " + n + ". keyword");
			key5.setBounds(xL2, y2a, sizeKey.width, sizeKey.height);
			add(key5);
			}
			else{
				key5 = new JLabel("Change your " + n + ". keyword");
				key5.setBounds(xL2, y2a, sizeKey.width, sizeKey.height);
				add(key5);
			}
			if(readColor().equals("BLACK")){
			    key5.setForeground(Color.WHITE);
			}

			// JTextField
			keyTextField5 = new JTextField();
			keyTextField5.setBounds(xT2, y2a, 150, 20);
			keyTextField5.addActionListener(listener);
			add(keyTextField5);
			
			//JButton reset key
			resetKey5 = new JButton("Reset");
			Dimension rD5 = resetKey5.getPreferredSize();
			resetKey5.setBounds(xB2 + 110, y2a, rD5.width, 20);
			resetKey5.addActionListener(listener);
			add(resetKey5);

			// DESTINATION
			// JTextField
			destTextField5 = new JTextField();
			destTextField5.setBounds(xT2, y2b, 150, 20);
			destTextField5.setText(mv5.readDestination());
			add(destTextField5);

			// JLabel "Enter the destination folder"
			if (destTextField5.getText().isEmpty()) {
				destination5 = new JLabel(chooseDestText1);
				sizeDes = destination5.getPreferredSize();
				destination5.setBounds(xL2, y2b, sizeDes.width, sizeDes.height);
				// mv3.setDestination(mv1Dest);
				add(destination5);
			} else {
				destination5 = new JLabel(chooseDestText2);
				sizeDes = destination5.getPreferredSize();
				destination5.setBounds(xL2, y2b, sizeDes.width, sizeDes.height);
				// mv3.setDestination(mv1Dest);
				add(destination5);
			}
			if(readColor().equals("BLACK")){
			    destination5.setForeground(Color.WHITE);
			}

			// JButton Select
			pathButtonD5 = new JButton(pathButtonText);
			pathButtonD5.setBounds(xB2, y2b, 110, 20);
			pathButtonD5.addActionListener(listener);
			add(pathButtonD5);

			// JButton reset, x+110 to JButton SelectPath
			resetDest5 = new JButton("Reset");
			resetDest5.setBounds(xB2 + 110, y2b, rD5.width, 20);
			resetDest5.addActionListener(listener);
			add(resetDest5);

			break;

		}
	}
	
	
	

	private class Listener implements ActionListener {

		
		// common x values case 1,2,3
				// JLabel
				int xL = 10;
				// JTextField
				int xT = 200;
				// JButton
				int xB = 360;

				// common x values case 4,5
				// JLabel
				int xL2 = 600;
				// JTextField
				int xT2 = 790;
				// JButton
				int xB2 = 950;

		// common y values
		// case 1
		// Show Keyword JLabel
		int yCur1 = 100;
		// Keyword JLabel JTextField
		int y1a = 130;
		// Destination JLabel, JTextField, JButton
		int y1b = 160;

		// case 2
		// Show Keyword JLabel
		int yCur2 = 220;
		// Keyword JLabel JTextField
		int y2a = 250;
		// Destination JLabel, JTextField, JButton
		int y2b = 280;

		// case 3
		// Show Keyword JLabel
		int yCur3 = 340;
		// Keyword JLabel JTextField
		int y3a = 370;
		// Destination JLabel, JTextField, JButton
		int y3b = 400;

		// Invoked when an action occurs.
		public void actionPerformed(ActionEvent e) {
			
			// Source
			if (e.getSource() == pathButtonSource) {
				try {
					// Create JFileChooser
					JFileChooser c = new JFileChooser();
					c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					c.showSaveDialog(null);
					File f = c.getSelectedFile();
					// setText in JTextField
					sourceTextField.setText(f.getAbsolutePath());
					// set and save source path in mv1
					mv1.setSource(f.getAbsolutePath());
					mv1.saveSource(f.getAbsolutePath());
					source.setText("Change source folder");
					Dimension d = source.getPreferredSize();
					source.setBounds(xL, 40, d.width, d.height);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

			// Reset Source
			if (e.getSource() == resetSource) {
				sourceTextField.setText("");
				mv1.setSource("");
				mv1.saveSource();
				sourceAdded = false;
				source.setText("Add source folder");
			}

			// component 1
			// Keyword 1
			if (e.getSource() == keyTextField1) {
				try {
					// set and save keyword in mv1
					mv1.setNewKeyWord(e.getActionCommand());
					mv1.saveKey(e.getActionCommand());

					// Change the current keyword JLabel
					currentKey1.setText("Your current 1. keyword:                 " + mv1.readKey());
					Dimension cK1 = currentKey1.getPreferredSize();
					currentKey1.setBounds(10, yCur1, cK1.width, cK1.height);
					
					//if input is null/empty
					if(e.getActionCommand()!=null&&!(e.getActionCommand().isEmpty())){
					key1.setText("Change your 1. keyword");
					}
					if(mv1.readKey()==null||mv1.readKey().isEmpty()){
						key1.setText("Add your 1. keyword");
						mv1.setNewKeyWord("...");
						mv1.saveKey("...");
						currentKey1.setText("Your current 1. keyword:                 " + mv1.readKey());
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
			
			if(e.getSource()==resetKey1){
				mv1.setNewKeyWord("...");
				mv1.saveKeyword();
				key1.setText("Add your 1. keyword");
				keyTextField1.setText("");
				currentKey1.setText("Your current 1. keyword:                 " + mv1.readKey());
				
				
			}

			// Destination 1
			if (e.getSource() == pathButtonD1) {
				try {
					// Create JFileChooser
					JFileChooser c = new JFileChooser();
					c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					c.showSaveDialog(null);
					File f = c.getSelectedFile();

					// Add path to JTextField
					destTextField1.setText(f.getAbsolutePath());

					// set and save destination path in mv1
					mv1.setDestination(f.getAbsolutePath());
					mv1.saveDestination(f.getAbsolutePath());

					// Change JLabel
//					dest1Added = false;
					destination1.setText(chooseDestText2);
					Dimension d1 = destination1.getPreferredSize();
					destination1.setBounds(xL, y1b, d1.width, d1.height);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			// Reset destination 1
			if (e.getSource() == resetDest1) {
				destTextField1.setText("");
				mv1.setDestination("");
				mv1.saveDestination();
				destination1.setText(chooseDestText1);
			}

			// component 2
			// Keyword 2
			if (e.getSource() == keyTextField2) {
				try {
					// set and save keyword in mv1
					mv2.setNewKeyWord(e.getActionCommand());
					mv2.saveKey(e.getActionCommand());

					// Change the current keyword JLabel
					currentKey2.setText("Your current 2. keyword:                 " + mv2.readKey());
					Dimension cK2 = currentKey2.getPreferredSize();
					currentKey2.setBounds(10, yCur2, cK2.width, cK2.height);

					//if input is null/empty
					if(e.getActionCommand()!=null&&!(e.getActionCommand().isEmpty())){
					key2.setText("Change your 2. keyword");
					}
					if(mv2.readKey()==null||mv2.readKey().isEmpty()){
						key2.setText("Add your 2. keyword");
						mv2.setNewKeyWord("...");
						mv2.saveKey("...");
						currentKey2.setText("Your current 2. keyword:                 " + mv2.readKey());
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
			
			if(e.getSource()==resetKey2){
				mv2.setNewKeyWord("...");
				mv2.saveKeyword();
				key2.setText("Add your 2. keyword");
				keyTextField2.setText("");
				currentKey2.setText("Your current 2. keyword:                 " + mv2.readKey());
				
				
			}

			// Destination 2
			if (e.getSource() == pathButtonD2) {
				try {
					// Create JFileChooser
					JFileChooser c = new JFileChooser();
					c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					c.showSaveDialog(null);
					File f = c.getSelectedFile();

					// Add path to JTextField
					destTextField2.setText(f.getAbsolutePath());

					// set and save destination path in mv2
					mv2.setDestination(f.getAbsolutePath());
					mv2.saveDestination(f.getAbsolutePath());
					
					// Change JLabel
//					dest2Added = false;
					destination2.setText(chooseDestText2);
					Dimension d2 = destination2.getPreferredSize();
					destination2.setBounds(xL, y2b, d2.width, d2.height);
					
				

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			

			}
			// Reset destination 2
			if (e.getSource() == resetDest2) {
				destTextField2.setText("");
				mv2.setDestination("");
				mv2.saveDestination();
//				dest2Added = false;
				destination2.setText(chooseDestText1);
			}

			// component 3
			// Keyword 3
			if (e.getSource() == keyTextField3) {
				try {
					// set and save keyword in mv1
					mv3.setNewKeyWord(e.getActionCommand());
					mv3.saveKey(e.getActionCommand());

					// Change the current keyword JLabel
					currentKey3.setText("Your current 3. keyword:                 " + mv3.readKey());
					Dimension cK3 = currentKey3.getPreferredSize();
					currentKey3.setBounds(10, yCur3, cK3.width, cK3.height);
					
					//if input is null/empty
					if(e.getActionCommand()!=null&&!(e.getActionCommand().isEmpty())){
					key3.setText("Change your 3. keyword");
					}
					if(mv3.readKey()==null||mv3.readKey().isEmpty()){
						key3.setText("Add your 3. keyword");
						mv3.setNewKeyWord("...");
						mv3.saveKey("...");
						currentKey3.setText("Your current 3. keyword:                 " + mv3.readKey());
					}
				}
				 catch (Exception ex) {
					ex.printStackTrace();
				}

			}
			
			if(e.getSource()==resetKey3){
				mv3.setNewKeyWord("...");
				mv3.saveKeyword();
				key3.setText("Add your 3. keyword");
				keyTextField3.setText("");
				currentKey3.setText("Your current 3. keyword:                 " + mv3.readKey());
				
				
			}

			// Destination 3
			if (e.getSource() == pathButtonD3) {
				try {
					// Create JFileChooser
					JFileChooser c = new JFileChooser();
					c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					c.showSaveDialog(null);
					File f = c.getSelectedFile();

					// Add path to JTextField
					destTextField3.setText(f.getAbsolutePath());

					// set and save destination path in mv3
					mv3.setDestination(f.getAbsolutePath());
					mv3.saveDestination(f.getAbsolutePath());
					
					// Change JLabel
//					dest3Added = false;
					destination3.setText(chooseDestText2);
					Dimension d3 = destination3.getPreferredSize();
					destination3.setBounds(xL, y3b, d3.width, d3.height);
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
			// Reset destination 3
			if (e.getSource() == resetDest3) {
				destTextField3.setText("");
				mv3.setDestination("");
				mv3.saveDestination();
				dest3Added = false;
				destination3.setText(chooseDestText1);
			}

			// component 4
			// Keyword 4
			if (e.getSource() == keyTextField4) {
				try {
					// set and save keyword in mv4
					mv4.setNewKeyWord(e.getActionCommand());
					mv4.saveKey(e.getActionCommand());

					// Change the current keyword JLabel
					currentKey4.setText("Your current 4. keyword:                 " + mv4.readKey());
					Dimension cK4 = currentKey4.getPreferredSize();
					currentKey4.setBounds(xL2, yCur1, cK4.width, cK4.height);
					
					//if input is null/empty
					if(e.getActionCommand()!=null&&!(e.getActionCommand().isEmpty())){
					key4.setText("Change your 4. keyword");
					}
					if(mv4.readKey()==null||mv4.readKey().isEmpty()){
						key4.setText("Add your 4. keyword");
						mv4.setNewKeyWord("...");
						mv4.saveKey("...");
						currentKey4.setText("Your current 4. keyword:                 " + mv4.readKey());
					}
				
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
			
			if(e.getSource()==resetKey4){
				mv4.setNewKeyWord("...");
				mv4.saveKeyword();
				key4.setText("Add your 4. keyword");
				keyTextField4.setText("");
				currentKey4.setText("Your current 4. keyword:                 " + mv4.readKey());
				
				
			}

			// Destination 4
			if (e.getSource() == pathButtonD4) {
				try {
					// Create JFileChooser
					JFileChooser c = new JFileChooser();
					c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					c.showSaveDialog(null);
					File f = c.getSelectedFile();

					// Add path to JTextField
					destTextField4.setText(f.getAbsolutePath());

					// set and save destination path in mv3
					mv4.setDestination(f.getAbsolutePath());
					mv4.saveDestination(f.getAbsolutePath());
					
					// Change JLabel
//					dest4Added = false;
					destination4.setText(chooseDestText2);
					Dimension d4 = destination4.getPreferredSize();
					destination4.setBounds(xL2, y1b, d4.width, d4.height);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

			// Reset destination 4
			if (e.getSource() == resetDest4) {
				destTextField4.setText("");
				mv4.setDestination("");
				mv4.saveDestination();
//				dest4Added = false;
				destination4.setText(chooseDestText1);
			}

			// component 5
			// Keyword 5
			if (e.getSource() == keyTextField5) {
				try {
					// set and save keyword in mv4
					mv5.setNewKeyWord(e.getActionCommand());
					mv5.saveKey(e.getActionCommand());

					// Change the current keyword JLabel
					currentKey5.setText("Your current 5. keyword:                 " + mv5.readKey());
					Dimension cK5 = currentKey5.getPreferredSize();
					currentKey5.setBounds(xL2, yCur2, cK5.width, cK5.height);
					
					//if input is null/empty
					if(e.getActionCommand()!=null&&!(e.getActionCommand().isEmpty())){
					key5.setText("Change your 5. keyword");
					}
					if(mv5.readKey()==null||mv5.readKey().isEmpty()){
						key5.setText("Add your 5. keyword");
						mv5.setNewKeyWord("...");
						mv5.saveKey("...");
						currentKey5.setText("Your current 5. keyword:                 " + mv5.readKey());
					}
				
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
			
			if(e.getSource()==resetKey5){
				mv5.setNewKeyWord("...");
				mv5.saveKeyword();
				key5.setText("Add your 5. keyword");
				keyTextField5.setText("");
				currentKey5.setText("Your current 5. keyword:                 " + mv5.readKey());
				
				
			}

			// Destination 5
			if (e.getSource() == pathButtonD5) {
				try {
					// Create JFileChooser
					JFileChooser c = new JFileChooser();
					c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					c.showSaveDialog(null);
					File f = c.getSelectedFile();

					// Add path to JTextField
					destTextField5.setText(f.getAbsolutePath());

					// set and save destination path in mv3
					mv5.setDestination(f.getAbsolutePath());
					mv5.saveDestination(f.getAbsolutePath());
					
					// Change JLabel
//					dest5Added = false;
					destination5.setText(chooseDestText2);
					Dimension d5 = destination5.getPreferredSize();
					destination5.setBounds(xL2, y2b, d5.width, d5.height);
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
			
			// Reset destination 5
			if (e.getSource() == resetDest5) {
				destTextField5.setText("");
				mv5.setDestination("");
				mv5.saveDestination();
				dest5Added = false;
				destination5.setText(chooseDestText1);
			}

			// Move Files Button
			if (e.getSource() == go) {
				try {
					// mv1
					mv1.setSource(mv1.readSource());
					mv1.setDestination(mv1.readDestination());
					mv1.setNewKeyWord(mv1.readKey());
					mv1.move();

					// mv2
					mv2.setSource(mv2.readSource());
					mv2.setDestination(mv2.readDestination());
					mv2.setNewKeyWord(mv2.readKey());
					mv2.move();

					// mv3
					mv3.setSource(mv3.readSource());
					mv3.setDestination(mv3.readDestination());
					mv3.setNewKeyWord(mv3.readKey());
					mv3.move();

					// mv4
					mv4.setSource(mv4.readSource());
					mv4.setDestination(mv4.readDestination());
					mv4.setNewKeyWord(mv4.readKey());
					mv4.move();

					// mv5
					mv5.setSource(mv5.readSource());
					mv5.setDestination(mv5.readDestination());
					mv5.setNewKeyWord(mv5.readKey());
					mv5.move();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			if(e.getSource()==resetAll){
				//source
				int option = JOptionPane.showConfirmDialog(null, "Do you really want to reset everything?", "Are you sure?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if(option == 0){
				sourceTextField.setText("");
				mv1.setSource("");
				mv1.saveSource();
				sourceAdded = false;
				source.setText("Add source folder");
				
				//Item 1
				mv1.setNewKeyWord("...");
				mv1.saveKeyword();
				key1.setText("Add your 1. keyword");
				keyTextField1.setText("");
				currentKey1.setText("Your current 1. keyword:                 " + mv1.readKey());
				
				destTextField1.setText("");
				mv1.setDestination("");
				mv1.saveDestination();
				destination1.setText(chooseDestText1);
				
				//Item 2
				mv2.setNewKeyWord("...");
				mv2.saveKeyword();
				key2.setText("Add your 2. keyword");
				keyTextField2.setText("");
				currentKey2.setText("Your current 2. keyword:                 " + mv2.readKey());
				
				destTextField2.setText("");
				mv2.setDestination("");
				mv2.saveDestination();
				destination2.setText(chooseDestText1);
				
				//Item 3
				mv3.setNewKeyWord("...");
				mv3.saveKeyword();
				key3.setText("Add your 3. keyword");
				keyTextField3.setText("");
				currentKey3.setText("Your current 3. keyword:                 " + mv3.readKey());
				
				destTextField3.setText("");
				mv3.setDestination("");
				mv3.saveDestination();
				destination3.setText(chooseDestText1);
				
				//Item 4
				mv4.setNewKeyWord("...");
				mv4.saveKeyword();
				key4.setText("Add your 4. keyword");
				keyTextField4.setText("");
				currentKey4.setText("Your current 4. keyword:                 " + mv4.readKey());
				
				destTextField4.setText("");
				mv4.setDestination("");
				mv4.saveDestination();
				destination4.setText(chooseDestText1);
				
				//Item 5
				mv5.setNewKeyWord("...");
				mv5.saveKeyword();
				key5.setText("Add your 5. keyword");
				keyTextField5.setText("");
				currentKey5.setText("Your current 5. keyword:                 " + mv5.readKey());
				
				destTextField5.setText("");
				mv5.setDestination("");
				mv5.saveDestination();
				destination5.setText(chooseDestText1);
				}
			}
		}
		
		

			
		}
	
	private class MenuListener implements ActionListener {

		String info = "The purpose of this program is to make it easier to sort files in the folders they belong to,\n"
				+ "without having to move each file manually and individually.\n"
				+ "You just have to save all your files in one single folder.\n"
				+ "Then you can choose certain keywords which will determine to which folders the files will be moved to.\n"
				+ "Name your files according to your keywords\n"
				+ "Choose your folder where you save all your files under \"source\"\n"
				+ "Choose the folder to which you want to move your files with the according keyword under \"destination\"\n\n"
				+ "Example:\n"
				+ "Step 1: Select your source folder. (for example: C:\\Users\\Desktop\\sourcefolder)\n"
				+ "Step 2: Select your destination folder. (for example: C:\\Users\\Desktop\\MyNotes)\n"
				+ "Step 3: Select a keyword. (for example \"NOTES_\")\n"
	           	+ "Step 4: Rename the files which belong to your destination folder \"MyNotes \"(C:\\Users\\Desktop\\MyNotes)\n"
	           	+ "Example: Rename the file \"schoolNotes\" to \"NOTES_schoolNotes\"\n"
	           	+ "Step 5: Press \"Move Files\" and your files will automatically be moved\n"
	           	+ "from the source folder (C:\\Users\\Desktop\\sourcefolder)\n"
	           	+ "to the selected destination folder (C:\\Users\\Desktop\\MyNotes)"
	           	+ "\n"
	           	+ "\n"
	           	+ "The keywords will be saved so you can name each file according to their keyword when creating them.\n"
	           	+ "You can save 5 seperate keywords and destination folders.\n\n"
	           	+ "Additional information:\n"
	           	+ "-Select a source or destionation with the \"Select Path...\" Button\n"
	           	+ "-Select a keyword: Type in the keyword and press ENTER";
		
		
		String warning = "ATTENTION: So far this program has only been tested for TEXTDOCUMENTS. So avoid other files before they haven't been properly tested.\n"
	           	+ "Furthermore i recommend to always keep a copy of your source folder in order to avoid any loss of data.\n"
	           	+ "So far such losses haven't been occuring but this is still a beta version hence i recommend being cautious.\n";
	           	
		String updateS = "What is planned?\n\n"
				+ "1. More keywords/destinations\n"
				+ "2. A option to select the number of keywords/destinations you need\n"
				+ "3. ...More!";
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==infoItem){
				JOptionPane.showMessageDialog(null, info, "How to use?", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, warning, "Caution", JOptionPane.WARNING_MESSAGE);
			}
			
			if (e.getSource()==update){
				JOptionPane.showMessageDialog(null, updateS, "Updates?", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(e.getSource()==pink){
				w.getContentPane().setBackground(Color.PINK);
				source.setForeground(Color.BLACK);
				key1.setForeground(Color.BLACK);
				currentKey1.setForeground(Color.BLACK);
				destination1.setForeground(Color.BLACK);
				key2.setForeground(Color.BLACK);
				currentKey2.setForeground(Color.BLACK);
				destination2.setForeground(Color.BLACK);
				key3.setForeground(Color.BLACK);
				currentKey3.setForeground(Color.BLACK);
				destination3.setForeground(Color.BLACK);
				key4.setForeground(Color.BLACK);
				currentKey4.setForeground(Color.BLACK);
				destination4.setForeground(Color.BLACK);
				key5.setForeground(Color.BLACK);
				currentKey5.setForeground(Color.BLACK);
				destination5.setForeground(Color.BLACK);
				JOptionPane.showMessageDialog(null, "Good choice!", "Awesome", JOptionPane.PLAIN_MESSAGE);
				try {
					FileWriter fw = new FileWriter(colortxt);
					fw.write("PINK");
					fw.flush();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(e.getSource()==yellow){
				w.getContentPane().setBackground(Color.YELLOW);
				source.setForeground(Color.BLACK);
				key1.setForeground(Color.BLACK);
				currentKey1.setForeground(Color.BLACK);
				destination1.setForeground(Color.BLACK);
				key2.setForeground(Color.BLACK);
				currentKey2.setForeground(Color.BLACK);
				destination2.setForeground(Color.BLACK);
				key3.setForeground(Color.BLACK);
				currentKey3.setForeground(Color.BLACK);
				destination3.setForeground(Color.BLACK);
				key4.setForeground(Color.BLACK);
				currentKey4.setForeground(Color.BLACK);
				destination4.setForeground(Color.BLACK);
				key5.setForeground(Color.BLACK);
				currentKey5.setForeground(Color.BLACK);
				destination5.setForeground(Color.BLACK);
				try {
					FileWriter fw = new FileWriter(colortxt);
					fw.write("YELLOW");
					fw.flush();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(e.getSource()==defaultColor){
				w.getContentPane().setBackground(greyDefault);
				source.setForeground(Color.BLACK);
				key1.setForeground(Color.BLACK);
				currentKey1.setForeground(Color.BLACK);
				destination1.setForeground(Color.BLACK);
				key2.setForeground(Color.BLACK);
				currentKey2.setForeground(Color.BLACK);
				destination2.setForeground(Color.BLACK);
				key3.setForeground(Color.BLACK);
				currentKey3.setForeground(Color.BLACK);
				destination3.setForeground(Color.BLACK);
				key4.setForeground(Color.BLACK);
				currentKey4.setForeground(Color.BLACK);
				destination4.setForeground(Color.BLACK);
				key5.setForeground(Color.BLACK);
				currentKey5.setForeground(Color.BLACK);
				destination5.setForeground(Color.BLACK);
				try {
					FileWriter fw = new FileWriter(colortxt);
					fw.write("DEFAULT");
					fw.flush();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(e.getSource()==red){
				w.getContentPane().setBackground(Color.RED);
				source.setForeground(Color.BLACK);
				key1.setForeground(Color.BLACK);
				currentKey1.setForeground(Color.BLACK);
				destination1.setForeground(Color.BLACK);
				key2.setForeground(Color.BLACK);
				currentKey2.setForeground(Color.BLACK);
				destination2.setForeground(Color.BLACK);
				key3.setForeground(Color.BLACK);
				currentKey3.setForeground(Color.BLACK);
				destination3.setForeground(Color.BLACK);
				key4.setForeground(Color.BLACK);
				currentKey4.setForeground(Color.BLACK);
				destination4.setForeground(Color.BLACK);
				key5.setForeground(Color.BLACK);
				currentKey5.setForeground(Color.BLACK);
				destination5.setForeground(Color.BLACK);
				try {
					FileWriter fw = new FileWriter(colortxt);
					fw.write("RED");
					fw.flush();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getSource()==green){
				w.getContentPane().setBackground(Color.GREEN);
				source.setForeground(Color.BLACK);
				key1.setForeground(Color.BLACK);
				currentKey1.setForeground(Color.BLACK);
				destination1.setForeground(Color.BLACK);
				key2.setForeground(Color.BLACK);
				currentKey2.setForeground(Color.BLACK);
				destination2.setForeground(Color.BLACK);
				key3.setForeground(Color.BLACK);
				currentKey3.setForeground(Color.BLACK);
				destination3.setForeground(Color.BLACK);
				key4.setForeground(Color.BLACK);
				currentKey4.setForeground(Color.BLACK);
				destination4.setForeground(Color.BLACK);
				key5.setForeground(Color.BLACK);
				currentKey5.setForeground(Color.BLACK);
				destination5.setForeground(Color.BLACK);
				try {
					FileWriter fw = new FileWriter(colortxt);
					fw.write("GREEN");
					fw.flush();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(e.getSource()==black){
				w.getContentPane().setBackground(Color.BLACK);
				source.setForeground(Color.WHITE);
				key1.setForeground(Color.WHITE);
				currentKey1.setForeground(Color.WHITE);
				destination1.setForeground(Color.WHITE);
				key2.setForeground(Color.WHITE);
				currentKey2.setForeground(Color.WHITE);
				destination2.setForeground(Color.WHITE);
				key3.setForeground(Color.WHITE);
				currentKey3.setForeground(Color.WHITE);
				destination3.setForeground(Color.WHITE);
				key4.setForeground(Color.WHITE);
				currentKey4.setForeground(Color.WHITE);
				destination4.setForeground(Color.WHITE);
				key5.setForeground(Color.WHITE);
				currentKey5.setForeground(Color.WHITE);
				destination5.setForeground(Color.WHITE);
				try {
					FileWriter fw = new FileWriter(colortxt);
					fw.write("BLACK");
					fw.flush();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
		
	}
	

	}


