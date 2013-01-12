package com.oren.test;

import com.oren.components.BoxBounded;
import com.oren.components.Gravity;
import com.oren.components.IGravity;
import com.oren.components.ILocation;
import com.oren.components.ILocation3D;
import com.oren.components.IMoveable;
import com.oren.components.Location;
import com.oren.components.Location3D;
import com.oren.components.Moveable;
import com.oren.componentslib.core.Entity;

public class TestEntity extends Entity {

	public final int xval=7,yval=6,zval=5,gravityval=15;
	
	public TestEntity() {
		putComponent(
				 new Location3D().setX(xval).setY(yval).setZ(zval)
				,new Gravity().setGravity(gravityval)
				,new Moveable()
				,new UpdateableComponent()
				,new UpdateableComponent2()		
				);
	}
	
	public void Test(){
		
		testInsertions();
		
		testInitializations();
		
		testInteractions();
		
		testIterations();	
		
		testCrossEntityInteractions();
		
		System.out.println("\ntesting done\n");
		
	}

	public void testInsertions(){
		System.out.println("checking that all components are present...\n");
		// check that we inserted and can get an object implementing the Ilocation3d interface
		assert containsComponent(ILocation3D.class) : "no location3d component";
		// check for the rest of the components that should have been inserted
		assert containsComponent(IGravity.class) : "no gravity component";
		assert containsComponent(IMoveable.class) : "no moveable component";	
		assert containsComponent(UpdateableComponent.class) : "no updateable component";
		assert containsComponent(UpdateableComponent2.class) : "no updateable2 component";
		
		System.out.println("all components present.\n");
		System.out.println("checking that super classes of existing components are present...\n");
		
		// check that we can get a location object even though we did not insert one, as
		// we inserted a subclass of it (location3d)
		assert containsComponent(ILocation.class) : "no location component";

		System.out.println("all super classes present\n");
	}
	
	public void testInitializations(){
		System.out.println("\ntesting component initializations...\n");
		
		System.out.println("testing location3d component...\n");
		
		System.out.println("testing base class (location) initialization...\n");
		// check that x and y values were initialized properly
		assert getComponent(ILocation.class).getX()==xval : "initial x value is wrong";
		assert getComponent(ILocation.class).getY()==yval: "initial y value is wrong";
		System.out.println("location initialized properly\n");
		System.out.println("testing location3d initialization...\n");
		// check that z value was initialized properly, only location3d has a getZ() function
		assert getComponent(ILocation3D.class).getZ()==zval : "initial z value is wrong";
		
		System.out.println("location3d initialized properly\n");
		System.out.println("testing gravity component...\n");
		assert getComponent(IGravity.class).getGravity()==gravityval : "initial gravity value is wrong";
		System.out.println("gravity initialized properly\n");
	}
	
	public void testInteractions(){
		System.out.println("\ntesting component interactions...\n");
		System.out.println("invoking gravity\n");
		// invoking gravity should change the Y value of the location component
		getComponent(IGravity.class).invoke();
		System.out.println("checking value change due to gravity\n");
		// check we did not alter any other fields
		assert getComponent(ILocation.class).getX()==xval: "gravity invokation failed, changed x";
		assert getComponent(ILocation3D.class).getZ()==zval: "gravity invokation failed, changed z";
				
		// we get the current y value and check that it is the initial y value incremented by
		// the gravity value
		assert getComponent(ILocation.class).getY()==yval+gravityval: "gravity invokation failed";
		System.out.println("gravity affected properly\n");
		
		System.out.println("checking value change due to move\n");
		// we move only the x and y so z should remain the same
		getComponent(Moveable.class).move(0, 0);
		assert getComponent(ILocation.class).getX()==0: "move invokation failed for x";
		assert getComponent(ILocation.class).getY()==0: "move invokation failed for y";
		assert getComponent(ILocation3D.class).getZ()==zval: "move invokation failed, changed z";
		System.out.println("move affected properly\n");
	}
	
	public void testIterations(){
		System.out.println("\ncalling update on all components implementing the Updatable interface...\n");
		// here we are getting all the components that implement a certain interface
		assert getComponentsImplementing(Updatable.class).size()==2 : "unexpected number of updateables";
		// this is a demonstration of how one can implement common functions like update and draw
		// on multiple components and handle them easily.
		// note that this implementation DOES NOT guarantee the order in which
		// the classes implementing the interface will be called.
		// one can always call for the components explicitly if a clear order is desired
		for (Updatable updatable : getComponentsImplementing(Updatable.class)) {
			updatable.Update();
		}
	}
		
	public void testCrossEntityInteractions(){
		
		// this is a test and demonstration of simple hit detection in the component environment
		
		System.out.println("\ntesting croos entity interactions\n");
		System.out.println("\ncreating two intersecting entities\n");
		Entity e1 = new Entity();
		e1.putComponent(new Location().setX(10).setY(10));
		e1.putComponent(new BoxBounded().setWidth(10).setHeight(10));
		
		Entity e2 = new Entity();
		e2.putComponent(new Location().setX(15).setY(15));
		e2.putComponent(new BoxBounded().setWidth(10).setHeight(10));
		
		// at this point we should have two entities that intersect each other
		// e1 is at (10,10) and its width and height are 10.
		// e2 is at (15,15) with the same dimensions
		// so they intersect at the square (15,15,5,5)		
		
		System.out.println("testing hit detection\n");
		
		// this is the actual hit detection, in this case the result should be true
		// note the parameter is another entity.
		assert e2.getComponent(BoxBounded.class).intersects(e1) : "hit detection failed";
		
		System.out.println("cross entity interaction test complete\n");
	}
		
				
	
	
}
