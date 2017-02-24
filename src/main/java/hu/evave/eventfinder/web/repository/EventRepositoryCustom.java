package hu.evave.eventfinder.web.repository;

import java.util.List;

import hu.evave.eventfinder.web.model.Event;
import hu.evave.eventfinder.web.model.Location;
import hu.evave.eventfinder.web.model.type.EventType;

public interface EventRepositoryCustom {

	List<Event> findByTypeLocationKeyword(List<EventType> types, Location location, String phrase);

}
