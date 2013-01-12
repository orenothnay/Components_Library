package com.oren.test;

import com.oren.componentslib.core.Component;

public class UpdateableComponent2 extends Component implements Updatable {

	public UpdateableComponent2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Update() {
		
		System.out.println("updateable 2 reporting");
		
	}

}
