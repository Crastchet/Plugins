package view;

import javax.swing.JFrame;

public class PluginFrame extends JFrame {

	
	/**
	 * This class is the basic frame of a plugin finder
	 * 
	 * @author Coillaux Thibault
	 * @author Deleplanque Dylan
	 * @author Lanschoot Ludovic
	 * @author Saab Mathieu
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for the frame
	 * @param title the title of the window
	 */
	public PluginFrame(String title) {
		super(title);
	}
	
	public void initFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addComponents();
	}
	
	public void addComponents() {
		
	}
}
