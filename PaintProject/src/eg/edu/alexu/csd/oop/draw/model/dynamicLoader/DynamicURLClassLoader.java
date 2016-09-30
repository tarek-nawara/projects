package eg.edu.alexu.csd.oop.draw;

import java.net.URL;
import java.net.URLClassLoader;

public class DynamicURLClassLoader extends URLClassLoader {

	public DynamicURLClassLoader(URLClassLoader classLoader) {
		super(classLoader.getURLs(), classLoader);

	}

	@Override
	public void addURL(URL url) {
		super.addURL(url);
	}

}
