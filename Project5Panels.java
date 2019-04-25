import java.awt.Component;
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

public class Project5Panels
{

	private JPanel panel1;
	private JPanel panel2;
	protected HammingDist base = new HammingDist();
	
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
	
	private JButton calculate;
	private JLabel title; 
	private JLabel ciLabel;
	private JLabel fLabel;
	private JLabel aLabel;
	private JLabel lLabel;
	private JTextField ceiling;
	private JTextField floor;
	private JTextField average;
	private JTextField letter;
	
	public Project5Panels()
	{
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		GridBagLayout gbl1 = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		panel1.setLayout(gbl1);
		
		GridBagLayout gbl2 = new GridBagLayout();
		panel2.setLayout(gbl2);
		
		setSlider();
		setLabels();
		setTextFields();
		setButtons();
		setDropDownBox();
		
		addComponentsPanel1(gbc);
		addComponentsPanel2(gbc);
	}
	
	private void addComponentsPanel2(GridBagConstraints gbc) 
	{
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.gridwidth = 2;
		panel2.add(title, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridy = 1;
		panel2.add(cLabel, gbc);
		gbc.gridy = 2;
		panel2.add(fLabel, gbc);
		gbc.gridy = 3;
		panel2.add(aLabel, gbc);
		gbc.gridy = 4;
		panel2.add(lLabel, gbc);
		gbc.gridy = 5;
		panel2.add(calculate, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel2.add(ceiling, gbc);
		gbc.gridy = 2;
		panel2.add(floor, gbc);
		gbc.gridy = 3;
		panel2.add(average, gbc);
		gbc.gridy = 4;
		panel2.add(letter, gbc);
	}

	private void setDropDownBox()
	{
		city = new JComboBox(base.getCities().toArray());
        city.setSelectedItem("NRMN");
	}

	private void setButtons()
	{
		show = new JButton("Show Station");
		calc = new JButton("Calculate HD");
		add = new JButton("Add Station");
		
		show.addActionListener((e) -> {
    		String list = "";
    		for(String id : base.findGivenHammingDist(city.getSelectedItem().toString(), slider.getValue()))
    		{
    			list += id + "\n";
    		}
    		stations.setText(list);
    	});
		
		calc.addActionListener((e) -> {
    		int[] val = base.compareHammingDist(city.getSelectedItem().toString());
    		dist0.setText(" " + val[0]);
    		dist1.setText(" " + val[1]);
    		dist2.setText(" " + val[2]);
    		dist3.setText(" " + val[3]);
    		dist4.setText(" " + val[4]);
    	});
		
		add.addActionListener((e) -> {
    		base.addCity(newCity.getText());
    		city.removeAll();
    		for(Object id : base.getCities().toArray())
    		{
    			city.addItem(id);
    		}
    	});
		
		calculate = new JButton("Calulate ASCII");
		
		calculate.addActionListener((e) -> {
    		int[] avg = base.calAverage("");
    		
    	});
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
		
		ceiling = new JTextField();
		ceiling.setEditable(false);
		
		floor = new JTextField();
		floor.setEditable(false);
		
		average = new JTextField();
		average.setEditable(false);
		
		letter = new JTextField();
		letter.setEditable(false);
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
		
		title = new JLabel("ASCII average:");
		ciLabel = new JLabel("ceiling value:"); 
		fLabel = new JLabel("floor value:");
		aLabel = new JLabel("rounded value:");
		lLabel = new JLabel("character representation: ");
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

	public JPanel getPanel1() 
	{
		return panel1;
	}

	public JPanel getPanel2() 
	{
		return panel2;
	}
}
