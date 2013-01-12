package com.oren.components;

import java.awt.Rectangle;

import com.oren.componentslib.core.Component;
import com.oren.componentslib.core.Entity;

public class BoxBounded extends Component {

	int width;
	int height;
	
	public BoxBounded() {
		this.width = 0;
		this.height = 0;
	}

	public int getWidth() {
		return width;
	}

	public BoxBounded setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public BoxBounded setHeight(int height) {
		this.height = height;
		return this;
	}
	
	public Rectangle BoundingBox(){
		return new Rectangle(getManager().get(Location.class).getX(), 
				getManager().get(Location.class).getY(), width, height);
	}
	
	public boolean contains(Rectangle other){
		
		return BoundingBox().contains(other);
	}
	
	public boolean intersects(Rectangle other){
		
		return BoundingBox().intersects(other);
		
	}
	
	public boolean intersects(Entity other){
		
		
		return BoundingBox().intersects(other.getComponent(BoxBounded.class).BoundingBox());
		
	}
	


}
