import java.awt.GridLayout;

import javax.swing.JFrame;

public class HammingGUI extends JFrame
{
	/**
	 * object to get the desired panels created in the Project5Panels class.
	 */
	private Project5Panels pPanels = new Project5Panels();
	
	/**
	 * Constructor for the class, creates and configures the frame and adds the two panels
	 */
	public HammingGUI()
	{
		this.setSize(600, 740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gl = new GridLayout(0, 2);
		this.setLayout(gl);
		this.add(pPanels.getPanel1());
		this.add(pPanels.getPanel2());
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new HammingGUI();

	}

}
