package com.oren.components;


public class Location3D extends Location implements ILocation3D {

	private int z;
	
	public Location3D() {
		this.z=0;
	}

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.Ilocation3D#getZ()
	 */
	@Override
	public int getZ() {
		return z;
	}

	/* (non-Javadoc)
	 * @see com.oren.componentslib.components.Ilocation3D#setZ(int)
	 */
	@Override
	public Location3D setZ(int z) {
		this.z = z;
		return this;
	}

	@Override
	public Location3D setX(int x) {
		// TODO Auto-generated method stub
		super.setX(x);
		return this;
	}

	@Override
	public Location3D setY(int y) {
		super.setY(y);
		return this;
	}
	
	

}
