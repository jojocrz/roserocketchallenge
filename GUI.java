import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GUI implements ActionListener{
	
	//Creating Swing Components and Variables
	private JFrame frame;
	private JPanel panel, bannerpanel;
	private JLabel banner, label, driverlabel;
	private JButton button;
	private JMenu file, help;
	private JMenuItem newdriver, newpickup, newdropoff, deletetask,
						about, tutorial;
	private JComboBox driverlist;
	
	public GUI() {
	
	//Setting up frame
	frame = new JFrame();	
	panel = new JPanel();
	//panel.setLayout(new GridLayout(10,10));		
	frame.setSize(900, 700);
	frame.add(panel,  BorderLayout.CENTER);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Rose Rocket");

	//Rose Rocket Banner
	banner = new JLabel("roserocket");
	bannerpanel = new JPanel();
	bannerpanel.setBackground(Color.BLUE);
	banner.setForeground(Color.WHITE);
	banner.setFont(new Font("Georgia", Font.PLAIN, 48));
	panel.add(bannerpanel, BorderLayout.BEFORE_FIRST_LINE);
	bannerpanel.add(banner,  BorderLayout.BEFORE_FIRST_LINE);
	
	// Setting up the Menu Bar
	JMenuBar menubar = new JMenuBar();
	frame.setJMenuBar(menubar);
	//file menu
	JMenu file = new JMenu("File");
	menubar.add(file);
	newdriver = new JMenuItem("New Driver");
	file.add(newdriver);
	newpickup = new JMenuItem("New Pickup");
	file.add(newpickup);
	newdropoff = new JMenuItem("New DropOff");
	file.add(newdropoff);
	deletetask = new JMenuItem("Delete Task");
	file.add(deletetask);
	//help menu
	JMenu help = new JMenu("Help");
	menubar.add(help);
	about = new JMenuItem("About");
	help.add(about);
	about.addActionListener(this);
	tutorial = new JMenuItem("Tutorial");
	help.add(tutorial);
	
	//Setting up Create button
	button = new JButton("Create + ");
	Dimension size = button.getPreferredSize();
	button.setBounds(10, 10, size.width, size.height);
	panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	button.setFocusable(false);
	button.addActionListener(this);
	panel.add(button, BorderLayout.EAST);
	
	//Adding Driver drop down menu
	driverlabel = new JLabel("Drivers");
	String[] drivers = {"Driver", "Troy Barnes", "Abed Nadir", "Jeff Winger"};
	driverlist = new JComboBox(drivers);
	driverlist.setSelectedIndex(0);
	driverlist.addActionListener(this);
	panel.add(driverlist,  BorderLayout.EAST);
	panel.add(driverlabel);
	
	//Add Calendar
	String[] calDays= {"GMT-04","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	Object[][] calTimes = {
			{"8 AM", null,null,null, null,null,null,null},
			{"9 AM", null,null,null, null,null,null,null},
			{"10 AM", null,"Jeff PickUp \nfrom 1 Dundas East",null, null,null,null,null},
			{"11 AM", null,null,null, null,null,null,null},
			{"12 PM", null,null,null, "Troy DropOff \nat 77 Bloor St West",null,null,null},
			{"1 PM", null,null,null, null,null,null,null},
			{"2 PM", null,null,null, null,null,null,null},
			{"3 PM", null,null,null, "Troy PickUp \nfrom 35 Bathurst St.",null,null,null},
			{"4 PM", null,null,null, null,null,null,null},
			{"5 PM", null,null,null, null,null,null,null},
			{"6 PM", null,null,null, null,null,null,null},
			{"7 PM", null,null,null, null,null,null,null},
			{"8 PM", null,null,null, null,null,null,null},
	};
	
	JTable calendar= new JTable(calTimes, calDays);
	calendar.setPreferredScrollableViewportSize(new Dimension(900,600));
	calendar.setFillsViewportHeight(true);
	calendar.setRowHeight(50);
	
	JScrollPane scrollpane = new JScrollPane(calendar);
	panel.add(scrollpane, BorderLayout.WEST);

	frame.setVisible(true);
	
	}


	public static void main(String[] args) {
		new GUI();

	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			JTextField task, location;
			JComboBox time; 
			String[] taskTime = {"8AM", "9AM", "10AM", "11AM", "12PM",
									"1PM", "2PM", "3PM", "4PM", "5PM", "6PM",
									"7PM", "8PM"};
			
			time= new JComboBox(taskTime);
			task = new JTextField();
			location = new JTextField();
			Object[] message = {
			    "Time:", time,
			    "Task:", task,
			    "Location:", location
			
			};

			int option = JOptionPane.showConfirmDialog(null, message, "Create New Task", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
			    if (location.getText().equals("") && task.getText().equals("")) {
			        System.out.println("Please complete all fields");
			    } else  {
			    	
			        System.out.println("New Task Created");
			    }
			} else {
			    System.out.println("No New Task Created");
			}
		
		}
		else if (e.getSource()==driverlist) {
			driverlist = (JComboBox)e.getSource();
				String schedule = (String)driverlist.getSelectedItem();
				
				switch(schedule) {
				case"Driver": driverlabel.setText("Please Select a Driver");
				break;
				case"Troy Barnes": driverlabel.setText("You are viewing Troy's Schedule");
				break;
				case"Abed Nadir": driverlabel.setText("You are viewing Abes's Schedule");
				break;
				case"Jeff Winger": driverlabel.setText("You are viewing Jeff's Schedule");
				break;
				default: driverlabel.setText("Select a driver");
			}}
		else if (e.getSource()==about){
			JOptionPane.showMessageDialog(null, "About", "About", 0);
			
		}
		
	}

}
