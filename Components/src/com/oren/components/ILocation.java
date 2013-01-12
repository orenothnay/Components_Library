package com.oren.components;

import com.oren.componentslib.core.IComponent;

public interface ILocation extends IComponent {

	public int getX();

	public ILocation setX(int x);

	public int getY();

	public ILocation setY(int y);

}