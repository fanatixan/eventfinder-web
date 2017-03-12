package hu.evave.eventfinder.web.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
