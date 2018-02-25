/*
 * Filename: MyRationalGUI.java
 * 
 * Author: Edwin Y. Melendez Lopez #89139
 * 
 * Description: A graphic user interfaces that uses the previous class Rational to do fraction calculations
 * 			    and then display the result on screen of the GUI.
 *  
 * 			History:
 * 			02/12/2018 - Created JFrame for Rational GUI. EML
 *  		02/12/2018 - Started Designing the GUI using the design tab before importing the Rational class created 
 *  					 in a separate project. EML
 * 			02/12/2018 - Added input frames for the user to input the numbers. EML
 * 			02/12/2018 - Added the JLabel's which are used to put a text on the GUI. EML
 * 			02/12/2018 - Added a parseInt method to convert the string entered into separated float's. EML
 * 			02/13/2018 - Imported the Rational Class and changed the methods of add , subtract , 
 * 						 multiply and divide to a Rational Object so it can return a result. EML
 * 						 Original code was NOT altered.
 * 
 * 		    02/13/2018 - Added exceptions. EML
 *          02/15/2018 - Started documentation of the MyRationalGUI class. EML
 * 		    02/15/2018 - Created Program. EML
 */

package edu.pupr.myrationalgui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

// TODO: The methods are not giving the actual results when using an actual calculator. CHECK ON THAT.

public class MyRationalGUI extends JFrame 
{

	private JPanel contentPane;

	private JTextField r1TextField;
	private JTextField r2TextField;
	
	// Labels to describe which text field belongs to what fraction, 1 or the other.
	private JLabel lblRational1 = new JLabel("Rational #1:");
	private JLabel lblRational2 = new JLabel("Rational #2:");
	
	// Radio buttons for the user to select the method of math he wants to use.
	private JRadioButton rdbtnMultiply = new JRadioButton("Multiply");
	private JRadioButton rdbtnDivision = new JRadioButton("Divide");
	private JRadioButton rdbtnAdd = new JRadioButton("Add");
	private JRadioButton rdbtnSubstract = new JRadioButton("Substract");
	
	private JLabel label; // used for the display of the text of the result.
	private ButtonGroup rdgp; // used for a section of the GUI to have all the buttons in that specific area.
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MyRationalGUI frame = new MyRationalGUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				} // end try & catch
			} // end void run()
		}); // end EventQueue
	} // end main()

	/**
	 * Create the frame.
	 */
	public MyRationalGUI() 
	{
		setTitle("Rational GUI"); // Title on the tab of the GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Default exit on close.
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnGetResult = new JButton("Get Result"); // Result message displayed on the GUI
		
		// Here are the visible additions of the buttons on the GUI
		JRadioButton rdbtnMultiply = new JRadioButton("Multiply");
		getContentPane().add(rdbtnMultiply);
		
		JRadioButton rdbtnDivision = new JRadioButton("Division");
		getContentPane().add(rdbtnDivision);
		
		JRadioButton rdbtnAdd = new JRadioButton("Add");
		getContentPane().add(rdbtnAdd);
		
		JRadioButton rdbtnSubstract = new JRadioButton("Substract");
		getContentPane().add(rdbtnSubstract);
		
		// Added buttons
		rdgp = new ButtonGroup();
		rdgp.add(rdbtnSubstract);
		rdgp.add(rdbtnAdd);
		rdgp.add(rdbtnMultiply);
		rdgp.add(rdbtnDivision);
		
		JLabel lblRational1 = new JLabel("Rational #1:"); // Text of Rational #1
		getContentPane().add(lblRational1);
		
		r1TextField = new JTextField();
		r1TextField.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent arg0) // Invoked when a component loses the keyboard focus.
			{
				try 
				{
					String str = verifyInput(r1TextField);
					
				} catch (ArithmeticException ex) 
				{
					JOptionPane.showMessageDialog(MyRationalGUI.this, ex.getMessage());
					r1TextField.requestFocus();
					r1TextField.selectAll();
				} 
			}

			@Override
			public void focusGained(FocusEvent arg0)  // Invoked when a component gains the keyboard focus.  In other words, when click again, all blue to overwrite
			{
				r1TextField.selectAll();
			}
		});
		
		r1TextField.setHorizontalAlignment(SwingConstants.RIGHT);
		r1TextField.setColumns(10);
		getContentPane().add(r1TextField);
		
		
		JLabel lblRational2 = new JLabel("Rational #2:");
		getContentPane().add(lblRational2);
		
		r2TextField = new JTextField();
		r2TextField.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent arg0) // Invoked when a component loses the keyboard focus.
			{
				try 
				{
					String str = verifyInput(r2TextField);
					
				} catch (ArithmeticException ex) {
					JOptionPane.showMessageDialog(MyRationalGUI.this, ex.getMessage());
					r2TextField.requestFocus();
					r2TextField.selectAll();
				} 
			}

			@Override
			public void focusGained(FocusEvent arg0) // Invoked when a component gains the keyboard focus. In other words, when click again, all blue to overwrite
			{
				r2TextField.selectAll();
			}
		});
		
		r2TextField.setHorizontalAlignment(SwingConstants.RIGHT);
		r2TextField.setColumns(10);
		getContentPane().add(r2TextField);
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(225, 150, 100, 100);
		label.setBorder(new LineBorder(new Color(0, 0, 255), 2)); // Line border of the result is set to blue.
		label.setLabelFor(this);
		contentPane.add(label);
		
		//getContentPane().add(label);
		
		btnGetResult.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				String str = r1TextField.getText();
				String str2 = r2TextField.getText();
				
				//------------------------ PARSE -----------------------------
				int slash1 = str.indexOf("/");
				int slash2 = str2.indexOf("/");
				
				// Takes a string of number before a "/" is in the text and converts them into Intergers
				int num1 = Integer.parseInt(str.substring(0, slash1));
				int dem1 = Integer.parseInt(str.substring(slash1 + 1)); // Same but for the numbers after a "/"
				
				int num2= Integer.parseInt(str.substring(0, slash2));
				int dem2 = Integer.parseInt(str.substring(slash2 + 1));
				
				//------------------------ PARSE -----------------------------	
				
				// Instances of Rational Objects used for the GUI Math computations
				Rational rational = new Rational(num1, dem1);
				Rational rational2 = new Rational(num2, dem2);
				Rational rational3 = new Rational();
				
				// Methods call 
				if (rdbtnAdd.isSelected()) // if the button is selected, execute this piece of code
				{
					
					rational3 = rational.Add(rational2);
					label.setText(rational3.toString()); // Displays the text of the result of method Add.
					
				}
				
				if (rdbtnSubstract.isSelected())
				{
					rational3 = rational.Subtract(rational2);
					label.setText(rational3.toString()); // Displays the text of the result of method Subtract.
				}
				
				if (rdbtnMultiply.isSelected())
				{
					rational3 = rational.Multiply(rational2);
					label.setText(rational3.toString()); // Displays the text of the result of method Multiply.
				}
				
				if (rdbtnDivision.isSelected())
				{
					rational3 = rational.Divide(rational2);
					label.setText(rational3.toString()); // Displays the text of the result of method Divide.
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnGetResult, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRational2)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRational1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(r1TextField, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
								.addComponent(r2TextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnSubstract)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnDivision))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnAdd)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(rdbtnMultiply)))))
					.addGap(65))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(r1TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRational1)
						.addComponent(rdbtnAdd)
						.addComponent(rdbtnMultiply))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(r2TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnSubstract)
							.addComponent(rdbtnDivision))
						.addComponent(lblRational2))
					.addGap(29)
					.addComponent(btnGetResult, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	} // end of MyRationalGUI Frame.
	
	
	// TextField Verification
	private String verifyInput(JTextField textField) 
	{
		String str = textField.getText();			
		String[] n1 = str.split("/");
			
		int x = Integer.parseInt(n1[1]);
		if (x == 0)
		{
			JOptionPane.showMessageDialog(this, "Cannot be 0!");
			textField.requestFocus();
			textField.selectAll();
		} // end of if.
		
		return str;
	} // end verifyInput

} // end of mYRationalGUI
