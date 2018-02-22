/**
 * 
 */
package com.something.anyting;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * @author mjaved
 *
 */
public class PlayWithSet {

	/**
	 * Additionally, an addAll --> acts as a union of the set with the provided
	 * collection (preserving unique values);
	 * removeAll --> acts a difference of the set with the provided collection;
	 * retainAll -->  acts as an intersection of the set with the provided collections. 
	 * Likewise, the constructors of the Set class also ensure that the elements of the supplied Collection
	 * are added only if there does not exist a duplicate value already present
	 * in the Set.
	 */
	public PlayWithSet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Set<String> playSet=new HashSet<String>(); 

		SortedSet<String> play=new TreeSet<String>(); 

		Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
				"AMC Gremlin", "Triumph Stag", "Ford Pinto").forEach(name -> {
					play.add(name);
				});
		play.forEach(System.out::println);
		//System.out.println("head element: "+play.headSet("Maruti"));
		//System.out.println("first element: "+play.first());
		
		Stream.of("Ferrari", "Jaguar", "Porsche", "Yugo GV","Maruti").forEach(name -> {
					playSet.add(name);
				});
		
		System.out.println("Before addAll");
		playSet.forEach(System.out::println);
		System.out.println("\nsize"+playSet.size());
		playSet.addAll(play);
		System.out.println("\nAfter addAll");
		System.out.println("\nsize"+playSet.size());
		playSet.forEach(System.out::println);
	}

}
