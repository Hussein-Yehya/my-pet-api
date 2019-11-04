package com.mypet.pi.modal;

import java.util.stream.Stream;

public enum PetRecommendedTo {

	KIDS, DEFICIENT, OLD_MAN, ALL;

	public static Stream<PetRecommendedTo> stream() {
		return Stream.of(PetRecommendedTo.values());
	}
}
