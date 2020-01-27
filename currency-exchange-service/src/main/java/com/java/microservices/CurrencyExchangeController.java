/**
 * 
 */
package com.java.microservices;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author VENEET
 *
 */
@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository valueRepository;

	// Port is 8001 for this method set in VM argument. => -Dserver.port=8001
	@GetMapping("currency-exchange-HardCodeValue/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue1(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = valueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}", exchangeValue);
		return exchangeValue;
	}

}
