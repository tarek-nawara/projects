package eg.edu.alexu.csd.oop.draw;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

@SuppressWarnings("all")
public class ClassFinder {
	private Set<Class<? extends Shape>> classes = new HashSet<Class<? extends Shape>>(
			100);

	public Set<Class<? extends Shape>> getClasses() {
		// String classpath = "C:/Users/Admin/Desktop/math/CirclePlugin.jar" ;
		String classpath = System.getProperty("java.class.path");
		String pathSeparator = System.getProperty("path.separator");
		String[] temp = classpath.split(pathSeparator);
		String[] allNames = new String[temp.length + 1];
		for (int i = 0; i < temp.length; i++) {
			allNames[i] = temp[i];
		}
		allNames[temp.length] = "C:" + File.separator + "Users" + File.separator + "Tarek Nawara" + File.separator +"Desktop" + File.separator + "Factory.jar";

		for (int i = 0; i < allNames.length; i++) {
			if (allNames[i].endsWith(".jar")) {
				System.out.println(allNames[i]);
				try {
					processJar(allNames[i]);
				} catch (MalformedURLException e) {

				}
			}
		}
		return classes;
	}

	public void processJar(String location) throws MalformedURLException {
		ClassLoader loader = getClass().getClassLoader();
		String path = (new File(location)).getPath();
		try {
			JarInputStream jis = new JarInputStream(new FileInputStream(path));
			JarEntry je = jis.getNextJarEntry();
			while (je != null) {
				if (je.getName().endsWith(".class")) {
					String x = je.getName().replaceAll("/", ".");
					x = x.substring(0, x.indexOf(".class"));
					String className = je.getName().substring(0,
							je.getName().length() - 6);
					// className = className.replace('/', '.');
					//System.out.println(x);
					//System.out.println(className);
					try {
						//System.out.println("b4");
						Class tempClass = Class.forName(x, true, loader);
						//System.out.println("??");
						System.out.println(tempClass.getName());
						if (!tempClass.isInterface()
								&& !Modifier.isAbstract(tempClass
										.getModifiers())
								&& tempClass.newInstance() instanceof Shape) {
							classes.add(((Class<? extends Shape>) tempClass));
							//System.out.println("added");
						}
					} catch (Exception ex) {
						//System.out.println("caught");
					}
				}
				je = jis.getNextJarEntry();
			}
			jis.close();
		} catch (Exception ex) {
		}
	}
}
