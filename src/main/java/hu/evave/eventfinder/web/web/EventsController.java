package hu.evave.eventfinder.web.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import hu.evave.eventfinder.web.model.Event;
import hu.evave.eventfinder.web.model.Location;
import hu.evave.eventfinder.web.model.price.Currency;
import hu.evave.eventfinder.web.model.type.EventType;
import hu.evave.eventfinder.web.model.user.User;
import hu.evave.eventfinder.web.repository.EventRepository;
import hu.evave.eventfinder.web.repository.UserRepository;

@Controller
public class EventsController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/events")
    public String listEvents(Map<String, Object> model) {
        model.put("events", eventRepository.findAll());
        return "events";

    }

    @RequestMapping(value = "/events/json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String listEventsJson() {
        return new Gson().toJson(eventRepository.findAll());
    }

    @RequestMapping(value = "/myevents/json", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String listMyEventsJson() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByName(auth.getName());
        return new Gson().toJson(eventRepository.findByCreatedBy(user));
    }

    @RequestMapping("/myevents")
    public String listMyEvents(Map<String, Object> model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByName(auth.getName());
        model.put("events", eventRepository.findByCreatedBy(user));
        return "myevents";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody List<Event> delete(@RequestBody Event eventToDelete) {

        // valójában nem töröljük ki az adatbázisból
        Event event = eventRepository.findOne(eventToDelete.getId());
        event.setStartsAt(null);
        eventRepository.save(event);
        return eventRepository.findAll();

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Map<String, Object> model) {

        Event event = new Event();
        event.setId(-1L);
        event.setLocation(new Location());
        event.setTypes(new ArrayList<>());
        model.put("event", event);
        model.put("allTypes", EventType.values());
        model.put("currencies", Currency.values());
        return "edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("event") Event event) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        event.setCreatedBy(userRepository.findByName(auth.getName()));

        if (event.getId() != null && event.getId() < 0) {
            event.setId(null);
        }
        System.out.println(event);
        eventRepository.save(event);
        return "redirect:/myevents";

    }

    @RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
    public String edit(@PathVariable("eventId") long id, Map<String, Object> model) {

        model.put("event", eventRepository.findOne(id));
        model.put("allTypes", EventType.values());
        model.put("currencies", Currency.values());
        return "edit";

    }

    @RequestMapping(value = "/edit/{eventId}", method = RequestMethod.POST)
    public String edit(@PathVariable("eventId") long id, @ModelAttribute("event") Event event) {
        eventRepository.save(event);
        return "redirect:/myevents";

    }

}
