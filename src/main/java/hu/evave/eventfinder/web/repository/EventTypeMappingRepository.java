package hu.evave.eventfinder.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.evave.eventfinder.web.model.type.EventTypeMapping;

public interface EventTypeMappingRepository extends JpaRepository<EventTypeMapping, Long>{

}
