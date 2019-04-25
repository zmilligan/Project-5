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

public class RequiredPanel
{
	private HammingDist base = new HammingDist();
	private JPanel panel = new JPanel();
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
	
	public RequiredPanel()
	{
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		panel.setLayout(gbl);
		
		setSlider();
		setLabels();
		setTextFields();
		setButtons();
		setDropDownBox();
		
		addComponentsPanel(gbc);
	}
	
	public JPanel getPanel()
	{
		return panel;
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
	}

	private void addComponentsPanel(GridBagConstraints gbc) 
	{
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0; gbc.gridy = 0;
        panel.add(sLabel, gbc);
 
        gbc.gridx = 1;
        panel.add(sText, gbc);
 
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(slider, gbc);
        
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(show, gbc);
        
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.ipady = 220;
        panel.add(sView, gbc);
        
        gbc.gridy = 6;
        gbc.ipady = 0;
        panel.add(cLabel, gbc);
        
        gbc.gridx = 1;
        city.setSelectedItem("NRMN");
        panel.add(city, gbc);
        
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(calc, gbc);	
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(dLabel0, gbc);
        gbc.gridy = 9;
        panel.add(dLabel1, gbc);
        gbc.gridy = 10;
        panel.add(dLabel2, gbc);
        gbc.gridy = 11;
        panel.add(dLabel3, gbc);
        gbc.gridy = 12;
        panel.add(dLabel4, gbc);
        
        gbc.gridy = 13;
        panel.add(add, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(dist0, gbc);
        gbc.gridy = 9;
        panel.add(dist1, gbc);
        gbc.gridy = 10;
        panel.add(dist2, gbc);
        gbc.gridy = 11;
        panel.add(dist3, gbc);
        gbc.gridy = 12;
        panel.add(dist4, gbc);
        
        gbc.gridy = 13;
        panel.add(newCity, gbc);
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
}
