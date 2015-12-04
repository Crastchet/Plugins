package view;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

import menu.Observer;
import menu.PluginFinderObservable;
import menu.ToolsMenu;

public class PluginFrame extends JFrame {
	/**
	 * This class is the basic frame of a plugin finder
	 * 
	 * @author Coilliaux Thibault
	 * @author Deleplanque Dylan
	 * @author Lanschoot Ludovic
	 * @author Saab Mathieu
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	ToolsMenu menu_tools;
	JMenu menu_file, menu_help;
	JTextArea textArea;
	
	private PluginFinderObservable pluginFinder = new PluginFinderObservable("droppins");
	
	/**
	 * Constructor for the frame
	 * @param title the title of the window
	 */
	public PluginFrame(String title) {
		super(title);
		initFrame();
		pluginFinder.addObserver(menu_tools); //ajouter les observers avant d'init l'observable
		pluginFinder.init();
	}
	
	/**
	 * A method which initialize the frame, it will add a menu and a text editor
	 */
	public void initFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addComponents();
		
		this.setSize(500, 500);
		
		this.setVisible(true);
	}
	
	/**
	 * A method which add components like the menu to the frame
	 */
	public void addComponents() {
		//Add the menu
		initMenu();
		//Add the text editor
		initTextEditor();
	}
	
	/**
	 * A method which will create the menu and send it so it can be added to the main frame
	 * @return the menu of the frame
	 */
	public void  initMenu() {		
		menu_file = new JMenu("File");
		menu_tools= new ToolsMenu(this);
		menu_help = new JMenu("Help");
		
		menuBar = new JMenuBar();
		menuBar.add(menu_file);
		menuBar.add(menu_tools);
		menuBar.add(menu_help);
		this.add(menuBar, BorderLayout.PAGE_START);
	}
	
	public void initTextEditor() {
		
		textArea = new JTextArea("A text we want to modify");
		this.add(textArea, BorderLayout.CENTER);
	}
	
	
	
	public JTextArea getTextArea() {
		return this.textArea;
	}
	public void setTextArea(String txt) {
		if(this.textArea.getSelectedText() != null)
			this.textArea.replaceSelection(txt);
		else
			this.textArea.setText(txt);
	}
}
