package cz.nixii.calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.Color;

public class Main {

	public static JFrame jfr = new JFrame(); // husta vec na GUI v Jave :D
	public static int index = 0;
	private static JTextField textField;
	private static boolean isCharTyped = false;
	private static String lastChar = "";
	private static String version = "1.0.0";
	private static int state = 0;
	
	public static void main(String[] args) {
		
		
		
		jfr.getContentPane().setBackground(Color.RED);
		//jfr.getContentPane().setForeground(Color.GREEN);
		jfr.setResizable(false);
		jfr.setForeground(Color.DARK_GRAY);
		
		jfr.setTitle("Calculator : v" + version);
		jfr.setSize(253, 465);
		jfr.getContentPane().setLayout(null);
		jfr.setVisible(true);
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setCaretColor(Color.BLACK);
		textField.setBackground(Color.DARK_GRAY);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setFont(new Font("Impact", Font.PLAIN, 17));
		textField.setBounds(10, 11, 226, 126);
		jfr.getContentPane().add(textField);
		textField.setColumns(10);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		           @Override
		            public void run() {
		        	   
		        	   //System.out.println("in timer");
		        	   
		        	   int r = jfr.getContentPane().getBackground().getRed();
		        	   int g = jfr.getContentPane().getBackground().getGreen();
		        	   int b = jfr.getContentPane().getBackground().getBlue();
		        	   
		        	   if(state == 0){
		        		    g++;
		        		    if(g == 255)
		        		        state = 1;
		        		}
		        		if(state == 1){
		        		    r--;
		        		    if(r == 0)
		        		        state = 2;
		        		}
		        		if(state == 2){
		        		    b++;
		        		    if(b == 255)
		        		        state = 3;
		        		}
		        		if(state == 3){
		        		    g--;
		        		    if(g == 0)
		        		        state = 4;
		        		}
		        		if(state == 4){
		        		    r++;
		        		    if(r == 255)
		        		        state = 5;
		        		}
		        		if(state == 5){
		        		    b--;
		        		    if(b == 0)
		        		        state = 0;
		        		}
		        		
		        		//System.out.println("R:" + r + " G:" + g + " B:" + b);
		        		
		        		Color c = new Color(r, g, b);
		        	   
		        		jfr.getContentPane().setBackground(c);
		        	   
		            }
		}, 0, 5);
		
		JButton tlacitko = new JButton("0");
		tlacitko.setForeground(Color.WHITE);
		tlacitko.setBackground(Color.DARK_GRAY);
		tlacitko.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "0");
			}
		});
		
		tlacitko.setBounds(10, 378, 108, 47);
		
		jfr.getContentPane().add(tlacitko);
		
		JButton tlacitko_2 = new JButton(",");
		tlacitko_2.setForeground(Color.WHITE);
		tlacitko_2.setBackground(Color.DARK_GRAY);
		tlacitko_2.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + ".");
			}
		});
		tlacitko_2.setBounds(128, 378, 49, 47);
		jfr.getContentPane().add(tlacitko_2);
		
		JButton tlacitko_1_1 = new JButton("<HTML>E<BR>N<BR>T</HTML>");
		tlacitko_1_1.setForeground(Color.WHITE);
		tlacitko_1_1.setBackground(Color.DARK_GRAY);
		tlacitko_1_1.setToolTipText("E\r\nN\r\nT");
		tlacitko_1_1.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField.setText(calculate(textField.getText(), lastChar));
				isCharTyped = false;
				
			}
		});
		tlacitko_1_1.setBounds(187, 322, 49, 103);
		jfr.getContentPane().add(tlacitko_1_1);
		
		JButton tlacitko_3 = new JButton("1");
		tlacitko_3.setForeground(Color.WHITE);
		tlacitko_3.setBackground(Color.DARK_GRAY);
		tlacitko_3.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		tlacitko_3.setBounds(10, 322, 49, 47);
		jfr.getContentPane().add(tlacitko_3);
		
		JButton tlacitko_1_2 = new JButton("2");
		tlacitko_1_2.setForeground(Color.WHITE);
		tlacitko_1_2.setBackground(Color.DARK_GRAY);
		tlacitko_1_2.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});
		tlacitko_1_2.setBounds(69, 320, 49, 47);
		jfr.getContentPane().add(tlacitko_1_2);
		
		JButton tlacitko_2_1 = new JButton("3");
		tlacitko_2_1.setForeground(Color.WHITE);
		tlacitko_2_1.setBackground(Color.DARK_GRAY);
		tlacitko_2_1.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});
		tlacitko_2_1.setBounds(128, 320, 49, 47);
		jfr.getContentPane().add(tlacitko_2_1);
		
		JButton tlacitko_3_1 = new JButton("7");
		tlacitko_3_1.setForeground(Color.WHITE);
		tlacitko_3_1.setBackground(Color.DARK_GRAY);
		tlacitko_3_1.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		tlacitko_3_1.setBounds(10, 206, 49, 47);
		jfr.getContentPane().add(tlacitko_3_1);
		
		JButton tlacitko_1_2_1 = new JButton("8");
		tlacitko_1_2_1.setForeground(Color.WHITE);
		tlacitko_1_2_1.setBackground(Color.DARK_GRAY);
		tlacitko_1_2_1.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		tlacitko_1_2_1.setBounds(69, 206, 49, 47);
		jfr.getContentPane().add(tlacitko_1_2_1);
		
		JButton tlacitko_2_1_1 = new JButton("9");
		tlacitko_2_1_1.setForeground(Color.WHITE);
		tlacitko_2_1_1.setBackground(Color.DARK_GRAY);
		tlacitko_2_1_1.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		tlacitko_2_1_1.setBounds(128, 206, 49, 47);
		jfr.getContentPane().add(tlacitko_2_1_1);
		
		JButton tlacitko_4 = new JButton("4");
		tlacitko_4.setForeground(Color.WHITE);
		tlacitko_4.setBackground(Color.DARK_GRAY);
		tlacitko_4.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});
		tlacitko_4.setBounds(10, 264, 49, 47);
		jfr.getContentPane().add(tlacitko_4);
		
		JButton tlacitko_1_3 = new JButton("5");
		tlacitko_1_3.setForeground(Color.WHITE);
		tlacitko_1_3.setBackground(Color.DARK_GRAY);
		tlacitko_1_3.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		tlacitko_1_3.setBounds(69, 264, 49, 47);
		jfr.getContentPane().add(tlacitko_1_3);
		
		JButton tlacitko_2_2 = new JButton("6");
		tlacitko_2_2.setForeground(Color.WHITE);
		tlacitko_2_2.setBackground(Color.DARK_GRAY);
		tlacitko_2_2.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "6");
			}
		});
		tlacitko_2_2.setBounds(128, 264, 49, 47);
		jfr.getContentPane().add(tlacitko_2_2);
		
		JButton tlacitko_1_1_2 = new JButton("+");
		tlacitko_1_1_2.setForeground(Color.WHITE);
		tlacitko_1_1_2.setBackground(Color.DARK_GRAY);
		tlacitko_1_1_2.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isCharTyped) {
					
					textField.setText(calculate(textField.getText(), lastChar));
					textField.setText(textField.getText() + "+");
					lastChar = "+";
					isCharTyped = true;
					
				}
				else {
					
					textField.setText(textField.getText() + "+");
					lastChar = "+";
					isCharTyped = true;
					
				}
			}
		});
		tlacitko_1_1_2.setBounds(187, 264, 49, 47);
		jfr.getContentPane().add(tlacitko_1_1_2);
		
		JButton tlacitko_1_1_1_1_1 = new JButton("-");
		tlacitko_1_1_1_1_1.setForeground(Color.WHITE);
		tlacitko_1_1_1_1_1.setBackground(Color.DARK_GRAY);
		tlacitko_1_1_1_1_1.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isCharTyped) {
					
					textField.setText(calculate(textField.getText(), lastChar));
					textField.setText(textField.getText() + "-");
					lastChar = "-";
					isCharTyped = true;
					
				}
				else {
					
					textField.setText(textField.getText() + "-");
					lastChar = "-";
					isCharTyped = true;
					
				}
			}
		});
		tlacitko_1_1_1_1_1.setBounds(187, 206, 49, 47);
		jfr.getContentPane().add(tlacitko_1_1_1_1_1);
		
		JButton tlacitko_2_1_1_1 = new JButton("*");
		tlacitko_2_1_1_1.setForeground(Color.WHITE);
		tlacitko_2_1_1_1.setBackground(Color.DARK_GRAY);
		tlacitko_2_1_1_1.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isCharTyped) {
					
					textField.setText(calculate(textField.getText(), lastChar));
					textField.setText(textField.getText() + "*");
					lastChar = "*";
					isCharTyped = true;
					
				}
				else {
					
					textField.setText(textField.getText() + "*");
					lastChar = "*";
					isCharTyped = true;
					
				}
			}
		});
		tlacitko_2_1_1_1.setBounds(187, 148, 49, 47);
		jfr.getContentPane().add(tlacitko_2_1_1_1);
		
		JButton tlacitko_1_2_1_1 = new JButton("/");
		tlacitko_1_2_1_1.setForeground(Color.WHITE);
		tlacitko_1_2_1_1.setBackground(Color.DARK_GRAY);
		tlacitko_1_2_1_1.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isCharTyped) {
					
					textField.setText(calculate(textField.getText(), lastChar));
					textField.setText(textField.getText() + "/");
					lastChar = "/";
					isCharTyped = true;
					
				}
				else {
					
					textField.setText(textField.getText() + "/");
					lastChar = "/";
					isCharTyped = true;
					
				}
			}
		});
		tlacitko_1_2_1_1.setBounds(128, 148, 49, 47);
		jfr.getContentPane().add(tlacitko_1_2_1_1);
		
		JButton tlacitko_3_1_1 = new JButton("CLEAR");
		tlacitko_3_1_1.setForeground(Color.WHITE);
		tlacitko_3_1_1.setBackground(Color.DARK_GRAY);
		tlacitko_3_1_1.setFont(new Font("Impact", Font.PLAIN, 15));
		tlacitko_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				lastChar = "";
				isCharTyped = false;
			}
		});
		tlacitko_3_1_1.setBounds(10, 148, 108, 47);
		jfr.getContentPane().add(tlacitko_3_1_1);
		
		
		
	}
	
	@SuppressWarnings("unused")
	private static String calculate(String display, String lChar) {
		
		Double output = 0.0;
		String[] character = display.split("\\" + lChar);
		Double x = Double.parseDouble(character[0]), y = Double.parseDouble(character[1]);
		
		
		
		switch(lChar) {
		
		case "+":
			output = x + y;
			break;
		case "-":
			output = x - y;
			break;
		case "*":
			output = x * y;
			break;
		case "/":
			output = x / y;
			break;
		
		}
		
		System.out.println(x.toString() + lChar + y.toString() + "=" + output.toString());
		
		lastChar = "";
		
		return output.toString();
		
	}
	
	
	
}
