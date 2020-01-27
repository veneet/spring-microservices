/**
 * 
 */
package com.java.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author VENEET
 *
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);

}
