package com.oren.components;


import com.oren.componentslib.core.Component;

public class Location extends Component implements ILocation {

	private int x;
	private int y;
	
	public Location() {
		
		x=0;
		y=0;
	}

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.Ilocation#getX()
	 */
	@Override
	public int getX() {
		return x;
	}

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.Ilocation#setX(int)
	 */
	@Override
	public Location setX(int x) {
		this.x = x;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.Ilocation#getY()
	 */
	@Override
	public int getY() {
		return y;
	}

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.Ilocation#setY(int)
	 */
	@Override
	public Location setY(int y) {
		this.y = y;
		return this;
	}

	
	
	
	

}
