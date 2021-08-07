package lotto.model;

import lotto.message.ErrorMessage;

public class Money {

	private static final int MONEY_UNIT = 1000;
	public static final int ZERO_POINT = 0;
	private final int money;

	public Money(int money) {
		checkThousandUnit(money);
		checkPositive(money);
		this.money = money;
	}

	public int getPurchaseMoney() {
		return money;
	}

	public int getLottoCount() {
		return money / MONEY_UNIT;
	}

	private static void checkThousandUnit(int money) {
		if (money % MONEY_UNIT != ZERO_POINT) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_THOUSAND_UNIT_MESSAGE);
		}
	}

	private static void checkPositive(int money) {
		if (money < 0) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_POSITIVE_MESSAGE);
		}
	}
}
