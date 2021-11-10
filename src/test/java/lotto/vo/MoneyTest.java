package lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("숫자 이외의 값이 오면 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"a", "한", "-", "/"})
    void notNumberTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.create(input));
    }

    @DisplayName("null or empty 값이 오면 IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    void notEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.create(input));
    }

    @DisplayName("1000원 보다 적으면 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"999"})
    void NumberRangeTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.create(input));
    }
}