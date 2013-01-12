package com.oren.components;

import com.oren.componentslib.core.Component;
import com.oren.componentslib.core.ComponentException;

public class Gravity extends Component implements IGravity {

	int gravity;
	public Gravity() {
		this.gravity=0;
	}

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.IGravity#invoke()
	 */
	@Override
	public void invoke() throws ComponentException{
		// getting another behaviors members
		int currenty=getManager().get(Location.class).getY();		
		// setting another behaviors members
		getManager().get(Location.class).setY(currenty + gravity);
	}

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.IGravity#getGravity()
	 */
	@Override
	public int getGravity() {
		return gravity;
	}

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.IGravity#setGravity(int)
	 */
	@Override
	public Gravity setGravity(int gravity) {
		this.gravity = gravity;
		return this;
	}
	
	
	

}
