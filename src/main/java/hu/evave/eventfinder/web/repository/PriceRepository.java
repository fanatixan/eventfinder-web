package hu.evave.eventfinder.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.evave.eventfinder.web.model.price.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
