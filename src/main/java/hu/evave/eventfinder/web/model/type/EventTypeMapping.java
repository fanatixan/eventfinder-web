package hu.evave.eventfinder.web.model.type;

import hu.evave.eventfinder.web.model.Event;

public class EventTypeMapping {

	private Long id;
	private Event event;
	private EventType type;

	public EventTypeMapping() {
	}

	public EventTypeMapping(Event event, EventType type) {
		this.event = event;
		this.type = type;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

}
