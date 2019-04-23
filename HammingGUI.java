import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class HammingGUI extends JFrame
{
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JSlider slider;
	
	public HammingGUI()
	{
		this.setSize(600, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gl = new GridLayout(0, 2);
		
		
		setSlider();
		panel1.add(slider);
		
		this.setLayout(gl);
		this.add(panel1);
		this.add(panel2);
		this.setVisible(true);
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
