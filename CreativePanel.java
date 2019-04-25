import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreativePanel extends ProjectPanel
{	
	private JLabel tLabel; 
	private JLabel cLabel;
	private JLabel fLabel;
	private JLabel aLabel;
	private JLabel lLabel;
	private JTextField ceiling;
	private JTextField floor;
	private JTextField average;
	private JTextField letter;

	public CreativePanel()
	{
		setButtons();
		setLabels();
		setTextFields();
		
	}

	private void setTextFields()
	{
		
	}

	private void setLabels() 
	{
		tLabel = new JLabel("ASCII average:");
		cLabel = new JLabel("ceiling value:"); 
		fLabel = new JLabel("floor value:");
		aLabel = new JLabel("rounded value:");
		lLabel = new JLabel("character representation: ");
	}

	private void setButtons() 
	{
		
	}
	
	
}
