package com.in28minutes.microservices.currencyexchangeservice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in28minutes.microservices.currencyexchangeservice.domain.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	@Query("select u from ExchangeValue u Where u.from= :from and u.to= :to")
	public ExchangeValue getExchaValue(@Param("from") String from, @Param("to")String to);

}
