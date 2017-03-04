package hu.evave.eventfinder.web.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import hu.evave.eventfinder.web.model.Event;
import hu.evave.eventfinder.web.model.Event_;
import hu.evave.eventfinder.web.model.Location;
import hu.evave.eventfinder.web.model.Location_;
import hu.evave.eventfinder.web.model.type.EventType;
import hu.evave.eventfinder.web.model.type.EventTypeMapping;
import hu.evave.eventfinder.web.model.type.EventTypeMapping_;

public class EventRepositoryImpl implements EventRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Event> findByTypeLocationKeyword(List<EventType> types, Location location, String phrase) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Event> cq = cb.createQuery(Event.class);
		Root<Event> event = cq.from(Event.class);
		ListJoin<Event, EventTypeMapping> mapping = event.join(Event_.typeMappings);

		List<Predicate> predicates = new ArrayList<>();

//		if (phrase != null && !phrase.isEmpty()) {
//			String phraseExpression = "%" + phrase + "%";
//			predicates.add(cb.like(event.get(Event_.name), phraseExpression));
//		}
//		if (phrase != null && !phrase.isEmpty()) {
//			String phraseExpression = phrase;
//			predicates.add(cb.like(event.get(Event_.name), phraseExpression));
//		}

		//predicates.add(cb.greaterThanOrEqualTo(event.get(Event_.startsAt), new Date()));

		if (location != null) {
			String country = location.getCountry();
			if (country != null) {
				predicates.add(cb.equal(event.get(Event_.location).get(Location_.country), location.getCountry()));
			}
		}

		if (types != null && !types.isEmpty()) {
			predicates.add(mapping.get(EventTypeMapping_.type).in(types));
		}

		cq.distinct(true);
		cq.where(cb.and(predicates.toArray(new Predicate[] {})));

		return em.createQuery(cq).getResultList();
	}

}
