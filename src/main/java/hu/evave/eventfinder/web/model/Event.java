package hu.evave.eventfinder.web.model;

import java.util.Date;
import java.util.List;

import hu.evave.eventfinder.web.model.price.Price;
import hu.evave.eventfinder.web.model.type.EventTypeMapping;

public class Event {

	private Long id;
	private String name;
	private List<EventTypeMapping> types;
	private Location location;
	private Date startsAt;
	private Date endsAt;
	private List<Price> prices;
	private String summary;
	private String description;
	private String webUrl;
	private String fbUrl;

	public Event() {
	}

	public Event(String name, List<EventTypeMapping> types, Location location, Date startsAt, Date endsAt,
			List<Price> prices, String summary, String description, String webUrl, String fbUrl) {
		this.name = name;
		this.types = types;
		this.location = location;
		this.startsAt = startsAt;
		this.endsAt = endsAt;
		this.prices = prices;
		this.summary = summary;
		this.description = description;
		this.webUrl = webUrl;
		this.fbUrl = fbUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EventTypeMapping> getTypes() {
		return types;
	}

	public void setTypes(List<EventTypeMapping> types) {
		this.types = types;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(Date startsAt) {
		this.startsAt = startsAt;
	}

	public Date getEndsAt() {
		return endsAt;
	}

	public void setEndsAt(Date endsAt) {
		this.endsAt = endsAt;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getFbUrl() {
		return fbUrl;
	}

	public void setFbUrl(String fbUrl) {
		this.fbUrl = fbUrl;
	}

	public Long getId() {
		return id;
	}

}
