package eg.edu.alexu.csd.oop.draw;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

public class MyTests {

	@Test
	public void test1() {
		Shape a = new Circle();
		Shape b = new Rectangle();
		
		Assert.assertEquals(a instanceof Shape, true);
		Assert.assertEquals(b instanceof Shape, true);
	}
	
	/*
	 * from 2 to 4 testing clone function
	 */
	
	@Test
	public void test2() throws CloneNotSupportedException {
		Shape a = new Circle();
		Shape b = (Shape) a.clone();
		
		Assert.assertEquals(b != a, true);
		Assert.assertEquals(a.getPosition() != b.getPosition(), true);
		Assert.assertEquals(a.getProperties() != b.getProperties(), true);
		Assert.assertEquals(a.getColor() != b.getColor(), true);
		Assert.assertEquals(a.getClass() == b.getClass(), true);
		Assert.assertEquals(a.getFillColor() != b.getFillColor(), true);
		
		Assert.assertEquals(a.getPosition().equals(b.getPosition()), true);
		Assert.assertEquals(a.getProperties().equals(b.getProperties()), true);
		Assert.assertEquals(a.getColor().equals(b.getColor()), true);
		Assert.assertEquals(a.getFillColor().equals(b.getFillColor()), true);
	}
	
	@Test
	public void test3() throws CloneNotSupportedException {
		Shape a = new Rectangle();
		Shape b = (Shape) a.clone();
		
		Assert.assertEquals(b != a, true);
		Assert.assertEquals(a.getPosition() != b.getPosition(), true);
		Assert.assertEquals(a.getProperties() != b.getProperties(), true);
		Assert.assertEquals(a.getColor() != b.getColor(), true);
		Assert.assertEquals(a.getClass() == b.getClass(), true);
		Assert.assertEquals(a.getFillColor() != b.getFillColor(), true);
		
		Assert.assertEquals(a.getPosition().equals(b.getPosition()), true);
		Assert.assertEquals(a.getProperties().equals(b.getProperties()), true);
		Assert.assertEquals(a.getColor().equals(b.getColor()), true);
		Assert.assertEquals(a.getFillColor().equals(b.getFillColor()), true);
	}
	
	@Test
	public void test4() throws CloneNotSupportedException {
		Shape a = new Ellipse();
		Shape b = (Shape) a.clone();
		
		Assert.assertEquals(b != a, true);
		Assert.assertEquals(a.getPosition() != b.getPosition(), true);
		Assert.assertEquals(a.getProperties() != b.getProperties(), true);
		Assert.assertEquals(a.getColor() != b.getColor(), true);
		Assert.assertEquals(a.getClass() == b.getClass(), true);
		Assert.assertEquals(a.getFillColor() != b.getFillColor(), true);
		
		Assert.assertEquals(a.getPosition().equals(b.getPosition()), true);
		Assert.assertEquals(a.getProperties().equals(b.getProperties()), true);
		Assert.assertEquals(a.getColor().equals(b.getColor()), true);
		Assert.assertEquals(a.getFillColor().equals(b.getFillColor()), true);
	}
	
	
	
	
	@Test
	public void test5() {
		Shape a = new Circle();
		a.setPosition(new Point(10, 10));
		Assert.assertEquals(a.getPosition().equals(new Point(10, 10)), true);
		
		Map<String, Double> map = new HashMap<>();
		map.put("Radius", 100.0);
		
		a.setProperties(map);
		Assert.assertEquals(a.getProperties() == map, false);
		Assert.assertEquals(a.getProperties().equals(map), true);
		Assert.assertEquals(a.getProperties().get("Radius"), 100.0);
		
	}
	
	@Test
	public void test6() {
		Shape a = new Rectangle();
		try {
			a.setPosition(null);
		} catch (RuntimeException e) {
			Assert.assertEquals(e.getMessage(), "No Given Position");
		}	
	}
	
	

}
