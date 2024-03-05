package model.people;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonCountTest {

    @Test
    @DisplayName("참여 인원을 생성한다.")
    void createPersonCount() {
        assertThatCode(() -> new PersonCount(3));
    }

    @ParameterizedTest(name = "참여 인원은 최소 2여야 한다.")
    @ValueSource(ints = {0, -1, 1})
    void createPersonCountThrowException(final int personCount) {
        assertThatThrownBy(() -> new PersonCount(personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원은 최소 2여야 합니다.");
    }

    @ParameterizedTest(name = "사람의 이름은 최소 1글자 최대 5글자다.")
    @ValueSource(strings = {"", "mollly"})
    void createPersonThrowException(String name) {
        assertThatThrownBy(() -> new Person(name))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 1글자 최대 5글자여야 합니다.");
    }
}
