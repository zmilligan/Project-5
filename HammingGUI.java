import java.awt.GridLayout;

import javax.swing.JFrame;

public class HammingGUI extends JFrame
{
	private Project5Panels pPanels = new Project5Panels();
	
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
