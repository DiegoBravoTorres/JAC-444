
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import javax.swing.JLabel;

public class DeserialGUI extends JFrame 
{

   private static final long serialVersionUID = 1L;
   
   // Define Fields
   private final JButton showButton;  
   private final JTextArea infoText; 

   // Constructor
   public DeserialGUI() 
   {
	  // Define box Header from the super class 
      super("Display Student Info"); 
      
      // Create Box
      Box box = Box.createHorizontalBox(); 
  
      // Create and define box text
      showButton = new JButton("Show Student Info"); 
      box.add(showButton); 
      
      // Define action for when the button is pressed 
      showButton.addActionListener(
         new ActionListener() // anonymous inner class
         {   
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
            	// Define block to handle errors gracefully
            	try {
            		
						//Create file input stream object using the "student.obj" as parameter
						FileInputStream fis = new FileInputStream("student.obj");
			
						//Create an Object Input Stream using the file input as parameter
						ObjectInputStream ois = new ObjectInputStream(fis);
			
						// Read objects from the file and store them into our temporary object
						Student student = (Student)ois.readObject();
						
						// Create and populate label based on the student object
						JLabel infoLabel = new JLabel(""
								+ "    Student Information"
								+ "    ID: " + student.getStdID()
								+ "    First Name: " + student.getFirstName()
								+ "    Last Name: " + student.getLastName()
								+ "    Classes:"
								);	
			
						
						for (String course : student.getCourses()) {
							infoLabel.setText( infoLabel.getText() + course + " " );
						}
						
						// Set JTextArea using the information from the label
						infoText.setText(infoLabel.getText());
						
						
						// Close both stream objects
						ois.close();
						fis.close();
			
					} catch (Throwable e) {
						System.err.println(e);
					}
            	
        
               
            } 
         } 
      );

      infoText = new JTextArea(10, 15);
      infoText.setEditable(false); 
      box.add(new JScrollPane(infoText)); 

      add(box);
   } 
   
   
   
   public static void main(String[] args)
   { 
	  // Create DeserialGui object to fetch all the information from the student.obj file
	  DeserialGUI textAreaFrame = new DeserialGUI(); 
      textAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textAreaFrame.setSize(1000, 80); 
      textAreaFrame.setVisible(true); 
   } 
   
} 
