package hu.evave.eventfinder.web.rest.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.evave.eventfinder.web.model.Event;
import hu.evave.eventfinder.web.model.price.Price;
import hu.evave.eventfinder.web.model.type.EventType;
import hu.evave.eventfinder.web.model.type.EventTypeMapping;

public class EventResource {

	private Long id;

	private String name;

	private List<EventType> types = new ArrayList<>();

	private LocationResource location;

	private Date startsAt;

	private Date endsAt;

	private List<PriceResource> prices = new ArrayList<>();

	private String summary;
	private String description;
	private String webUrl;
	private String fbUrl;

	public EventResource(Event event) {
		id = event.getId();
		name = event.getName();

		for (EventTypeMapping typeMapping : event.getTypes()) {
			types.add(typeMapping.getType());
		}

		location = new LocationResource(event.getLocation());
		startsAt = event.getStartsAt();
		endsAt = event.getEndsAt();

		for (Price price : event.getPrices()) {
			prices.add(new PriceResource(price));
		}

		summary = event.getSummary();
		description = event.getDescription();
		webUrl = event.getWebUrl();
		fbUrl = event.getFbUrl();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<EventType> getTypes() {
		return types;
	}

	public LocationResource getLocation() {
		return location;
	}

	public Date getStartsAt() {
		return startsAt;
	}

	public Date getEndsAt() {
		return endsAt;
	}

	public List<PriceResource> getPrices() {
		return prices;
	}

	public String getSummary() {
		return summary;
	}

	public String getDescription() {
		return description;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public String getFbUrl() {
		return fbUrl;
	}

}
