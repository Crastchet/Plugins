package menu;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PluginFinderObservableTest {
	File source, dest;
	PluginFinderObservable pluginFinder;
	
	
	@Before
	public void setUp() throws Exception {
		source = new File("bin/plugins/ToUpperCase.class");
		dest = new File("dropins/plugins/ToUpperCase.class");
		pluginFinder = new PluginFinderObservable("dropins/plugins");
		pluginFinder.init();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testAddPlugin() {
		assertEquals(0,pluginFinder.getPlugins().size());
		
	// We add a plugin in the folder
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(dest);
			fis = new FileInputStream(source);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		byte buffer[] = new byte[512 * 1024];
		int nbLecture;
		
		try {
			while((nbLecture = fis.read(buffer)) != -1)
				fos.write(buffer,0,nbLecture);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	// We test if PluginFinderObservable added the plugin to the application
		assertEquals(1,pluginFinder.getPlugins().size());			
	}
	
	@Test
	public void removePlugin() {
		assertEquals(1,pluginFinder.getPlugins().size());
		File tmp = new File("dropins/plugins/ToUpperCase.class");
		tmp.delete();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0,pluginFinder.getPlugins().size());
	}

}
