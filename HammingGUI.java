import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HammingGUI extends JFrame
{
	private HammingDist base = new HammingDist();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JSlider slider;
	private JLabel sLabel;
	private JTextField sText;
	private JTextField dist0;
	private JTextField dist1;
	private JTextField dist2;
	private JTextField dist3;
	private JTextField dist4;
	private JButton show;
	private JTextArea stations;
	private JScrollPane sView;
	private JLabel cLabel;
	private JComboBox city;
	private JButton calc;
	private JLabel dLabel0;
	private JLabel dLabel1;
	private JLabel dLabel2;
	private JLabel dLabel3;
	private JLabel dLabel4;
	private JButton add;
	private JTextField newCity;
	
	public HammingGUI()
	{
		this.setSize(600, 740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gl = new GridLayout(0, 2);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gl);
		panel1.setLayout(gbl);
		
		setSlider();
		setLabels();
		setTextFields();
		setButtons();
		setDropDownBox();
		
		addComponentsPanel1(gbc);
		
		
		this.add(panel1);
		this.add(panel2);
		this.setVisible(true);
	}
	
	private void setDropDownBox()
	{
		city = new JComboBox(base.getCities().toArray());
	}

	private void setButtons()
	{
		show = new JButton("Show Station");
		calc = new JButton("Calculate HD");
		add = new JButton("Add Station");
	}

	private void addComponentsPanel1(GridBagConstraints gbc) 
	{
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0; gbc.gridy = 0;
        panel1.add(sLabel, gbc);
 
        gbc.gridx = 1;
        panel1.add(sText, gbc);
 
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel1.add(slider, gbc);
        
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel1.add(show, gbc);
        
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.ipady = 220;
        panel1.add(sView, gbc);
        
        gbc.gridy = 6;
        gbc.ipady = 0;
        panel1.add(cLabel, gbc);
        
        gbc.gridx = 1;
        city.setSelectedItem("NRMN");
        panel1.add(city, gbc);
        
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel1.add(calc, gbc);	
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel1.add(dLabel0, gbc);
        gbc.gridy = 9;
        panel1.add(dLabel1, gbc);
        gbc.gridy = 10;
        panel1.add(dLabel2, gbc);
        gbc.gridy = 11;
        panel1.add(dLabel3, gbc);
        gbc.gridy = 12;
        panel1.add(dLabel4, gbc);
        
        gbc.gridy = 13;
        panel1.add(add, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        panel1.add(dist0, gbc);
        gbc.gridy = 9;
        panel1.add(dist1, gbc);
        gbc.gridy = 10;
        panel1.add(dist2, gbc);
        gbc.gridy = 11;
        panel1.add(dist3, gbc);
        gbc.gridy = 12;
        panel1.add(dist4, gbc);
        
        gbc.gridy = 13;
        panel1.add(newCity, gbc);
	}

	private void setTextFields() 
	{
		sText = new JTextField();
		sText.setEditable(false);
		sText.setText(" " + slider.getValue());
		
		stations = new JTextArea();
		sView = new JScrollPane(stations);
		
		dist0 = new JTextField();
		dist0.setEditable(false);
		
		dist1 = new JTextField();
		dist1.setEditable(false);
		
		dist2 = new JTextField();
		dist2.setEditable(false);
		
		dist3 = new JTextField();
		dist3.setEditable(false);
		
		dist4 = new JTextField();
		dist4.setEditable(false);
		
		newCity = new JTextField();
	}

	private void setLabels() 
	{
		sLabel = new JLabel("Enter Hamming Dist: ");
		cLabel = new JLabel("Compare with:\t");
		dLabel0 = new JLabel("Distance 0");
		dLabel1 = new JLabel("Distance 1");
		dLabel2 = new JLabel("Distance 2");
		dLabel3 = new JLabel("Distance 3");
		dLabel4 = new JLabel("Distance 4");
	}

	private void setSlider()
	{
		slider = new JSlider(0, 1, 4, 1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		
		slider.addChangeListener((e) -> {
    		sText.setText(" " + slider.getValue());
    	});
	}
	
	

	public static void main(String[] args)
	{
		new HammingGUI();
	}
}
