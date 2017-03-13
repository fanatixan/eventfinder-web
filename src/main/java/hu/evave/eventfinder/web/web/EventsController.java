package hu.evave.eventfinder.web.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.evave.eventfinder.web.model.Event;
import hu.evave.eventfinder.web.repository.EventRepository;

@Controller
public class EventsController {

	@Autowired
	EventRepository eventRepository;

	@RequestMapping("/events")
	public String home(Map<String, Object> model) {
		model.put("events", eventRepository.findAll());
		return "/events";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("eventId") long id) {
		Event event = eventRepository.findOne(id);
		
		//valójában nem töröljük ki az adatbázisból
		event.setStartsAt(null);
		eventRepository.save(event);
		return "redirect:/events";

	}

}
