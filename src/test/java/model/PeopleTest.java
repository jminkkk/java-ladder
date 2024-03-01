package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PeopleTest {

    @Test
    @DisplayName("사람은 최소 2명 참가해야한다.")
    void createPersonGroup() {
        List<String> names = List.of("moly", "loky");
        assertThatCode(() -> People.from(names));
    }

    @Test
    @DisplayName("사람은 최소 2명 참가해야한다.")
    void createPersonGroupThrowException() {
        List<String> names = List.of("loky");
        assertThatThrownBy(() -> People.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원은 최소 2여야 합니다.");
    }
}
