package com.pheonix.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.pheonix.model.Person;
import com.pheonix.repositories.PersonRepository;

public class DrinkingBuddyService implements BuddyService {

	private PersonRepository repository;

	@Autowired
	public DrinkingBuddyService(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public Person findBuddy(Person person) {
		Person buddy = null;

		for (Person p : repository.findAll()) {
			// do not return same person or person without age
			if (p.getId() == person.getId() || p.getAge() == 0) {
				continue;
			}

			// no buddy? Take the first one
			if (buddy == null) {
				buddy = p;
			}

			int buddyDiff = Math.abs(person.getAge() - buddy.getAge());
			int currentDiff = Math.abs(person.getAge() - p.getAge());

			// found someone closer to this person's age
			if (currentDiff < buddyDiff) {
				buddy = p;
			}
		}

		return buddy;
	}

	/**
	 * Finds and returns person with smallest age difference to the input.
	 */


}
