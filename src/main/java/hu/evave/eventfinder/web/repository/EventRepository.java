package hu.evave.eventfinder.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.evave.eventfinder.web.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
