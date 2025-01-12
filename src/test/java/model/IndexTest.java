package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexTest {

    @Test
    @DisplayName("인덱스는 음수일 수 없다.")
    void createIndexThrowException() {
        assertThatThrownBy(() -> new Index(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("인덱스는 음수일 수 없습니다.");
    }

    @Test
    @DisplayName("인덱스 값이 시작값이 아닌 경우 참을 반환한다.")
    void isNotStartIndex() {
        Index index = new Index(1);
        assertThat(index.isNotStartIndex()).isTrue();
    }

    @Test
    @DisplayName("인덱스 값이 마지막값이 아닌 경우 참을 반환한다.")
    void isNotLastIndex() {
        Index index = new Index(0);
        assertThat(index.isNotLastIndex(1)).isTrue();
    }
}
