package hu.evave.eventfinder.web.repository;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hu.evave.eventfinder.web.model.Event;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryIT {

	@Autowired
	EventRepository eventRepository;

	@Before
	@Transactional
	public void setUp() {
		Event event = new Event();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		event.setStartsAt(calendar.getTime());
		event.setName("Példa név");
		eventRepository.save(event);
	}

	@Test
	public void testFindByKeyword() {
		List<Event> events = eventRepository.findByTypeLocationKeyword(null, null, "Példa név");
		Assert.assertFalse(events.isEmpty());
		// Assert.assertEquals(events.get(0).getId(), event.getId());
	}

}
