package com.oren.components;

import com.oren.componentslib.core.Component;
import com.oren.componentslib.core.ComponentException;

public class Moveable extends Component implements IMoveable {

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.IMoveable#move(int, int)
	 */
	@Override
	public void move(int x,int y) throws ComponentException{
		getManager().get(Location.class).setX(x).setY(y);
	}
	
	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.IMoveable#move(int, int, int)
	 */
	@Override
	public void move(int x,int y,int z) throws ComponentException{
		getManager().get(Location3D.class).setX(x).setY(y).setZ(z);
	}

}
