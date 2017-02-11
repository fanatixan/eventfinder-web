package hu.evave.eventfinder.web.model.price;

import java.math.BigDecimal;

public class Price {

	private Long id;
	private Currency currency;
	private BigDecimal amount;
	private PriceType type;

	public Price() {
	}

	public Price(Currency currency, BigDecimal amount, PriceType type) {
		this.currency = currency;
		this.amount = amount;
		this.type = type;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PriceType getType() {
		return type;
	}

	public void setType(PriceType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

}
