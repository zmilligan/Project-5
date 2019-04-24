import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HammingGUI extends JFrame
{
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
		
		addComponentsPanel1(gbc);
		
		
		this.add(panel1);
		this.add(panel2);
		this.setVisible(true);
	}
	
	private void setButtons()
	{
		show = new JButton("Show Station");
	}

	private void addComponentsPanel1(GridBagConstraints gbc) 
	{
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0; gbc.gridy = 0;
        panel1.add(sLabel, gbc);
 
        gbc.gridx = 1; gbc.gridy = 0;
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
        
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.ipady = 0;
        panel1.add(dist0, gbc);
		
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
	}

	private void setLabels() 
	{
		sLabel = new JLabel("Enter Hamming Dist: ");
	}

	private void setSlider()
	{
		slider = new JSlider(0, 1, 4, 1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		
	}

	public static void main(String[] args)
	{
		new HammingGUI();
	}
}
