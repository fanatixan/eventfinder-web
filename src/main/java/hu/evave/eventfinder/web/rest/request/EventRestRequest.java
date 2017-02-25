package hu.evave.eventfinder.web.rest.request;

import java.util.ArrayList;
import java.util.List;

import hu.evave.eventfinder.web.model.type.EventType;

public class EventRestRequest {

	private String eventTypes;
	private String keyword;
	private String country;

	public String getEventType() {
		return eventTypes;
	}

	public void setEventType(String eventTypes) {
		this.eventTypes = eventTypes;
	}

	public List<EventType> getTypes() {
		List<EventType> result = new ArrayList<>();
		if (eventTypes != null && !eventTypes.isEmpty()) {
			String[] types = eventTypes.split(",");
			for (String type : types) {
				result.add(EventType.valueOf(type));
			}
		}

		return result;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
