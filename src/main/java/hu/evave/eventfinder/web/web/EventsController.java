package hu.evave.eventfinder.web.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.evave.eventfinder.web.model.Event;
import hu.evave.eventfinder.web.model.Location;
import hu.evave.eventfinder.web.model.price.Currency;
import hu.evave.eventfinder.web.model.type.EventType;
import hu.evave.eventfinder.web.repository.EventRepository;

@Controller
public class EventsController {

	@Autowired
	EventRepository eventRepository;

	@RequestMapping("/events")
	public String home(Map<String, Object> model) {
		model.put("events", eventRepository.findAll());
		return "events";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("eventId") long id) {
		Event event = eventRepository.findOne(id);
		
		//valójában nem töröljük ki az adatbázisból
		event.setStartsAt(null);
		eventRepository.save(event);
		return "redirect:/events";

	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Map<String, Object> model) {	
		
		Event event = new Event();
		event.setId(-1L);
		event.setLocation(new Location());
		model.put("event", event);
		model.put("types", EventType.values());
		model.put("currencies", Currency.values());
		return "edit";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("event") Event event) {
		if(event.getId() != null && event.getId() < 0) {
			event.setId(null);
		}
		System.out.println(event);
		eventRepository.save(event);
		return "redirect:/events";

	}
	
	@RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
	public String edit(@PathVariable("eventId") long id, Map<String, Object> model) {	
		
		model.put("event", eventRepository.findOne(id));
		model.put("types", EventType.values());
		model.put("currencies", Currency.values());
		return "edit";

	}
	
	@RequestMapping(value = "/edit/{eventId}", method = RequestMethod.POST)
	public String edit(@PathVariable("eventId") long id, @ModelAttribute("event") Event event) {
		eventRepository.save(event);
		return "redirect:/events";

	}

}
