package com.thisisivan.linesfx.DragNDrop;

import java.io.Serializable;

public class Fruit implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String name = "";

	public Fruit(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
