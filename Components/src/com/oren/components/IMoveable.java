package com.oren.components;

import com.oren.componentslib.core.ComponentException;
import com.oren.componentslib.core.IComponent;

public interface IMoveable extends IComponent {

	public void move(int x, int y) throws ComponentException;

	public void move(int x, int y, int z) throws ComponentException;

}