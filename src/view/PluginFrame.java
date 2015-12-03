package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import plugins.ToUpperCase;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import finder.PluginFinder;

public class PluginFrame extends JFrame implements Observer {

	
	/**
	 * This class is the basic frame of a plugin finder
	 * 
	 * @author Coillaux Thibault
	 * @author Deleplanque Dylan
	 * @author Lanschoot Ludovic
	 * @author Saab Mathieu
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	JMenu menu_tools, menu_file, menu_help;
	JTextArea textEditor;
	
	/**
	 * Constructor for the frame
	 * @param title the title of the window
	 */
	public PluginFrame(String title) {
		super(title);
		initFrame();
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
		menuBar = new JMenuBar();
		
		menu_file = new JMenu("File");
		menu_tools= new JMenu("Tools");
		menu_help = new JMenu("Help");
		menuBar.add(menu_file);
		menuBar.add(menu_tools);
		menuBar.add(menu_help);
		try {
			initToolsMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(menuBar, BorderLayout.PAGE_START);
	}
	
	public void initToolsMenu() throws Exception {
		JMenuItem item = new JMenuItem(new AbstractAction(ToUpperCase.getName()) {

			public void actionPerformed(ActionEvent e) {
				textEditor.setText(ToUpperCase.action(textEditor.getText()));
			}
		});
		menu_tools.add(item);
	}
	
	public void initTextEditor() {
		
		textEditor = new JTextArea("A text we want to modify");
		this.add(textEditor, BorderLayout.CENTER);
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	//private static Class getClassFromFile(String fullClassName) throws Exception {
//	    URLClassLoader loader = new URLClassLoader(new URL[] {
//	            new URL("file:///home/l3miage/saab/COO/plugins/Plugins/droppins")
//	    });
	    
	    //ClassLoader loader = new Class
	    //return loader.loadClass(fullClassName);
	//}
	
//	public void newClassAppeared(Class class) {
//	}
//
//	public void classHasDisappeared(Class class) {
//	}
}
