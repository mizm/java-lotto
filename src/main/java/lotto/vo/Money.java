package lotto.vo;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String ZERO_EXCEPTION_MESSAGE = "입력 값은 영보다 작을 수 없습니다.";
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력 값은 빈 값 일 수 없습니다.";

    private final BigDecimal value;

    private Money(BigDecimal value) {
        this.value = value;
    }

    public static Money create(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }

        BigDecimal value = new BigDecimal(input);

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(ZERO_EXCEPTION_MESSAGE);
        }
        return new Money(value);
    }

    public static Money create(BigDecimal value) {
        return new Money(value);
    }

    public long getNumberToBuy(Money price) {
        return this.value.divideToIntegralValue(price.value).longValue();
    }

    public BigDecimal divide(Money o) {
        if (o.value.compareTo(BigDecimal.ONE) < 0) {
            throw new IllegalArgumentException(ZERO_EXCEPTION_MESSAGE);
        }

        return this.value.divide(o.value);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Money add(Money o) {
        return new Money(this.value.add(o.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return value.equals(money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean lessThan(Money o) {
        return this.value.compareTo(o.value) < 0;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
