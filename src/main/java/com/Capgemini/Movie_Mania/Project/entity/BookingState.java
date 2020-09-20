/**
 * 
 */
package com.Capgemini.Movie_Mania.Project.entity;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum BookingState {
	
	Available("available"),
	
	Blocked("Blocked"),
	
	booked("booked");

	 private static Map<String,  BookingState> FORMAT_MAP = Stream
     .of( BookingState.values())
     .collect(Collectors.toMap(s -> s.formatted, Function.identity()));

 private final String formatted;

 BookingState(String formatted) {
     this.formatted = formatted;
 }

 
}
