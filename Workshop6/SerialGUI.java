
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SerialGUI extends Student {

	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		

		// Define frame and initial configuration
		JFrame frame = new JFrame("Student Data Entry");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		
		// Create and add Window
		JPanel window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
		window.setPreferredSize(new Dimension(500, 300));
		frame.add(window);
		
		// Create and add ID label and text field
		JLabel idLabel = new JLabel("Student ID: ");
		JTextField idInput = new JTextField(8);
		window.add(idLabel);
		window.add(idInput);
		
		// Create and add first name label and text field
		JLabel firstNameLabel = new JLabel("Student First Name: ");
		JTextField firstNameInput = new JTextField(10);
		window.add(firstNameLabel);
		window.add(firstNameInput);
		
		// Create and add last name label and text field
		JLabel lastNameLabel = new JLabel("Student Last Name: ");
		JTextField lastNameInput = new JTextField(10);
		window.add(lastNameLabel);
		window.add(lastNameInput);
		
		// Create and add courses name label and text field
		JLabel coursesLabel = new JLabel("Student Classes (Separated by ;): ");
		JTextField coursesInput = new JTextField(30);
		window.add(coursesLabel);
		window.add(coursesInput);
		
		// Create and add button	
		JButton saveBtn = new JButton("Save");
		window.add(saveBtn);
		
		
		 //anonymous inner class for button event handling
		saveBtn.addActionListener(new ActionListener() {
			
			// Override method for when the button is pushed
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("You entered: "+ String.format(firstNameInput.getText()));
				
				//Create student object to be stored
				Student student = new Student();
				
				// Get the ID and Name from the input fields into the student object
				student.setStdID(Integer.parseInt(idInput.getText()));
				student.setFirstName(firstNameInput.getText());
				student.setLastName(lastNameInput.getText());
				
				// Get the courses from the input fields into an array
				String[] coursesI;
				coursesI = coursesInput.getText().split(";");
				ArrayList<String> coursesList = new ArrayList<>(Arrays.asList(coursesI));
				// Then into the student object
				student.setCourses(coursesList);
				
				System.out.println("clases: "+ student.getCourses() );
				
				
				try {
					
					// Open Streams
					FileOutputStream outStream = new FileOutputStream("student.obj");
					ObjectOutputStream objectSteam = new ObjectOutputStream(outStream);
					
					// Save student list object into the file
					objectSteam.writeObject(student);
					
					// Close Streams
					objectSteam.close();
					outStream.close();
					
					// Print final message
					System.out.print("Student Sucesfully Saved");
					
					
					
				} catch (IOException e) {
					// Catch error
					e.printStackTrace();
					
				}
				
			} 
		});
		
		// Set values to the main frame
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
