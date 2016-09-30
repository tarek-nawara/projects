package eg.edu.alexu.csd.oop.draw;

import java.io.File;

import java.lang.reflect.Method;

import java.net.URL;
import java.net.URLClassLoader;


public class Add {
	public static void addJar(String input) throws Exception {
		File myJar = new File(input);
		URL[] u = {myJar.toURL()};
		URLClassLoader urlLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
		
		DynamicURLClassLoader my = new  DynamicURLClassLoader(urlLoader);
		
		my.addURL(myJar.toURL());
	}

}
