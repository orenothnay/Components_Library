package com.oren.components;

import com.oren.componentslib.core.ComponentException;
import com.oren.componentslib.core.IComponent;

public interface IGravity extends IComponent {

	public void invoke() throws ComponentException;

	public int getGravity();

	public IGravity setGravity(int gravity);

}