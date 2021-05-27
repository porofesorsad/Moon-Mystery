package moonMystery;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Final Project "Moon Mystery" written by Yasmin Torres 12/2020
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MoonMystery 
{
//I used this to help me find the center and place the buttons better
	Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
	Dimension frameSize = new Dimension (500, 300);	
	JFrame window;
	//Creates the window
    Container con;
	JLabel titleNameLabel, hpLabel, hpNumber, itemLabel, itemName;
	//Creates the labels
	
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
   //Creates panels
	
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	//Sets Times New Roman as the normal font
	JButton startButton, choice1, choice2, choice3, choice4;
   //Creates buttons for the starts and choices 
	
	JTextArea mainTextArea;
	//Creates the area of text
   int playerHP;
   String item, position;
   
   TitleScreenHandler tsHandler = new TitleScreenHandler();
   ChoiceHandler cHandler = new ChoiceHandler();

	public MoonMystery()
	{	
		window = new JFrame();
      //creates the window
		window.setSize(800, 800);
      //Creates window size, width of 800 pixels and height of 600 pixels
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Creates the function to close, such as an x button on the top right
		window.getContentPane().setBackground(Color.black);
      //Sets the color of the window to be black
		window.setLayout(null);
      //Disable the default layout of the window
		window.setVisible(true);
      //Makes the window visible
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(ss.width/2 - frameSize.width/2, 
                ss.height/2-frameSize.height/2,
                frameSize.width, frameSize.height );
      //Creates space for the title
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("MOON MYSTERY");
      //Creates title
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
      //Color of the text and the font	
		
		startButtonPanel = new JPanel();
		///startButtonPanel.setBounds(550, 400, 200, 500);
		startButtonPanel.setBounds(ss.width/2 - frameSize.width/2, 
                ss.height/2-frameSize.height/2 + 200,
                frameSize.width, frameSize.height );
		startButtonPanel.setBackground(Color.black);
		//Creates panel for start button and sets color and size
      
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
      //Creates button and sets color for text and background for the button
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
      //When the start button is clicked, it will called tsHandler, enabling an action
		startButton.setFocusPainted(false);
		//Gets rid of an outline of a box inside of the box clicked
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		//Adds the button to the space created for it
      
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	}
//***********************************************************************************************************************************************************************************************************************************		
	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		//Disables the panels so that when the actions is performed it will not be 
		//in sight
      
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(400, 200, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(ss.width/2 - frameSize.width/2, 
                ss.height/2-frameSize.height/2,
                frameSize.width, frameSize.height);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
      //Creates the area for text, color, and size
		mainTextArea.setLineWrap(true);
      //If a lot of text is inputed, the text will be wrapped
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(500, 400, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
      //Creates the layout for the buttons and creates the space for the buttons
		con.add(choiceButtonPanel);
      
		
		choice1 = new JButton("1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
      //Creates the box for choice1 and adds it onto the panel
      
		choice2 = new JButton("2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
      
		choice3 = new JButton("3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
      
		choice4 = new JButton("4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(300, 15, 500, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,3));
		con.add(playerPanel);
      
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
      //Creates how "HP" is going to look and adds it to the panel
      
		hpNumber = new JLabel();
		hpNumber.setFont(normalFont);
		hpNumber.setForeground(Color.white);
		playerPanel.add(hpNumber);
      //Creates how the hp number is going look like
		itemLabel = new JLabel("Item:");
		itemLabel.setFont(normalFont);
		itemLabel.setForeground(Color.white);
		playerPanel.add(itemLabel);
      //Creates how the item label will look like
		itemName = new JLabel();
		itemName.setFont(normalFont);
		itemName.setForeground(Color.white);
		playerPanel.add(itemName);
      //Creates how the name for the item will look like

		playerSetup();
	}
//***********************************************************************************************************************************************************************************************************************************    
	public void playerSetup()
	{
	  playerHP = 100;
      item = "";
      itemName.setText(item);
      hpNumber.setText("" + playerHP);
      //setText can only display text so there needs to be double quotation
		
		sRoom();
	}
//****************************************************************************************************************************************************************************************************************************************************************** 
   public void sRoom()
     {
     position = "sRoom";
     mainTextArea.setText("You wake up and look around to find       you're in an empty room. What will you do?");
     choice1.setText("Open the door across");
     choice2.setText("Go back to sleep");
     choice3.setText("Pack bag");
     choice4.setText("Panic");  
     } 
//****************************************************************************************************************************************************************************************************************************************************************** 
//What happens when you select the option 1a to leave 
    public void talkMarvin()
    {
    position = "talkMarvin";
	 if(item.equals("Key"))
	 mainTextArea.setText("You stick in the key and find that the door was already unlocked. You found the key to my comic collection! Been looking for that for ages.  Thanks mate.\"");
	 else 
    mainTextArea.setText("You open the door to see a small robot. \n\"Oh.You're awake. Great.\"");  
	   
    choice1.setText("\"Who are you?\"");  
    choice2.setText("\"Who am I?\"");
    choice3.setText("\"Where am I?\"");  
    choice4.setText("\"How did I get here?\"");  
    }
//****************************************************************************************************************************************************************************************************************************************************************** 
//What happens when you select the option 2a to sleep   
    public void sleep()
    {
    position = "sleep";
    mainTextArea.setText("You go back to sleep and dream about    unicorns and wake up to feeling energized and better than ever!");    
    choice1.setText("Continue");  
    choice2.setText("");
    choice3.setText(""); 
    choice4.setText("");   
    }   
//******************************************************************************************************************************************************************************************************************************************************************   
//Result for option 3a        
    public void packBag()
    {
    position = "packBag";
    mainTextArea.setText("What bag? Have you gone mad?\n You did find a key though. You also       somehow pricked your hand on the sharp part of it");  
	 item = "Key";  
	 itemName.setText(item);
	 playerHP -=5;
	hpNumber.setText("" + playerHP);
    choice1.setText("Continue");  
    choice2.setText("");
    choice3.setText(""); 
    choice4.setText("");   
    }
//************************************************************************************************************************************************************************************************************************************************************* 
//Result for option 4a
   public void panic()
   {
    position = "panic";
    mainTextArea.setText("Where the am I? WHO am I? How did I      even get here? You panic so hard that you pass out. \nFive minutes later you awake and you're   as calm as day.");    
    choice1.setText("Continue");  
    choice2.setText("");
    choice3.setText(""); 
    choice4.setText("");
   }    
//**********************************************************************************************************************************************************************************************************************************************************    
//Result for option 1b
   public void who()
   {
   position = "who";
    mainTextArea.setText("\"I'm Marvin.\"");
    choice1.setText("Continue");  
    choice2.setText("");
    choice3.setText(""); 
    choice4.setText("");
    
    } 
//**********************************************************************************************************************************************************************************************************************************************************   
//Result for option 2b
   public void me()
      {
     position = "me";
    mainTextArea.setText("\"You tell me.\"");
    choice1.setText("Continue");  
    choice2.setText("");
    choice3.setText(""); 
    choice4.setText("");
    
    } 
//**********************************************************************************************************************************************************************************************************************************************************       
//Result for option 3b
  public void where()
    {
    position = "why";
    mainTextArea.setText("\"The Moon.\"");
    choice1.setText("Continue");  
    choice2.setText("");
    choice3.setText(""); 
    choice4.setText(""); 
    }
//**********************************************************************************************************************************************************************************************************************************************************       	    
//Result for option 4b
 public void how()
  {
  position = "how"; 
    mainTextArea.setText("\"You came here on a school field trip but seperated from the group and fell and hit your head. You were found and taken to  the nursing room and have been here for a few hours.\""); 
    choice1.setText("Continue");  
    choice2.setText("");
    choice3.setText(""); 
    choice4.setText("");
    }
  
//**********************************************************************************************************************************************************************************************************************************************************       	
//Result for 5a
  public void back()
   {
   position = "back";
   mainTextArea.setText("\"Would you like to go back now?\"");
   choice1.setText("Yes");  
   choice2.setText("No");
   choice3.setText(""); 
   choice4.setText("");
	choice3.setVisible(false);
	choice4.setVisible(false);
    
    }
//**********************************************************************************************************************************************************************************************************************************************************       	
//Result for option 6a and 6b
  public void dontMatter()
   {
   position = "dontMatter";
   mainTextArea.setText("\"Doesn't really matter what you want I'm required to bring you back anyway.\"");
    choice1.setText("Okay :c");  
    choice2.setText("");
    choice3.setText(""); 
    choice4.setText("");
    choice2.setVisible(false);
	 choice3.setVisible(false);
	 choice4.setVisible(false);
    
    }
//**********************************************************************************************************************************************************************************************************************************************************       	
//Result for option 7a
   public void end()
   {
   position = "end";
   mainTextArea.setText("Marvin takes you back to your group and teleports everyone back to Earth. \n<THE END>");
      choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}     

//**********************************************************************************************************************************************************************************************************************************************************       	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
//******************************************************************************************************************************************   
	public class ChoiceHandler implements ActionListener
     {
		
		public void actionPerformed(ActionEvent event)
        {
			
			String yourChoice = event.getActionCommand();			
			
         switch(position)
         {
         case "sRoom":
            switch(yourChoice)
             {
             case "c1": talkMarvin(); break;
             case "c2": sleep(); break;
             case "c3": packBag(); break;
             case "c4": panic(); break;
             }
             break;
             
         case "talkMarvin":
             switch(yourChoice)
             {
               case "c1": who(); break;
               case "c2": me(); break;
               case "c3":where(); break;
               case "c4": how(); break;
             }
             break;
             
         case "sleep":
            switch(yourChoice)
            { 
            case "c1": sRoom(); break;
            }
            break;
            
         case "packBag":
         switch(yourChoice)
            {
            case "c1": sRoom(); break; 
            }
           break;
           
         case "panic":
         switch(yourChoice)
            {
            case "c1": sRoom(); break;
	         }
            break;
            
         case "who":
         switch(yourChoice)
            {
            case "c1": talkMarvin(); break;
            }
            break;
            
         case "me":
         switch(yourChoice)
            {
            case "c1": talkMarvin(); break;
            } 
            break;
            
         case "why":
         switch (yourChoice)
            {
            case "c1":talkMarvin(); break;
            }
            break;
            
         case "how":
         switch (yourChoice)
            {
            case "c1": back(); break;
            }
            break; 
            
         case "back":
         switch (yourChoice)
            {
            case "c1": dontMatter(); break;
            case "c2": dontMatter(); break;          
			   }
			   break;
          case "dontMatter":
          switch (yourChoice)
            {
            case "c1":end();break;
            }
            break;
			
         }
	   }
   }
}
   