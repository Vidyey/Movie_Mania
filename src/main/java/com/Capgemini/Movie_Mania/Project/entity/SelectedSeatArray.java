package com.Capgemini.Movie_Mania.Project.entity;

import java.util.Arrays;

public class SelectedSeatArray {
	
	Integer[] seatLocation;

	/**
	 * @return the seatLocation
	 */
	public Integer[] getSeatLocation() {
		return seatLocation;
	}

	/**
	 * @param seatLocation the seatLocation to set
	 */
	public void setSeatLocation(Integer[] seatLocation) {
		this.seatLocation = seatLocation;
	}

	/**
	 * 
	 */
	public SelectedSeatArray() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SelectedSeatArray [seatLocation=" + Arrays.toString(seatLocation) + "]";
	}

}
