package com.Capgemini.Movie_Mania.Project.entity;

import java.util.Arrays;

public class SelectedSeatArray {
	
	int[] seatLocation;

	/**
	 * @return the seatLocation
	 */
	public int[] getSeatLocation() {
		return seatLocation;
	}

	/**
	 * @param seatLocation the seatLocation to set
	 */
	public void setSeatLocation(int[] seatLocation) {
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
