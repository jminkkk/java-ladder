package model.items;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    @DisplayName("결과 목록을 생성한다.")
    void createItems() {
        List<String> items = List.of("꽝", "5000", "꽝", "3000");
        int personCount = 4;
        assertThatCode(() -> Items.of(items, personCount));
    }

    @Test
    @DisplayName("참여 인원 수와 결과 목록의 수가 동일해야 한다.")
    void checkItemCountWithPersonCount() {
        List<String> itemNames = List.of("꽝");
        int personCount = 3;
        assertThatThrownBy(() -> Items.of(itemNames, personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원 수와 결과 목록의 수가 동일하지 않습니다.");
    }

    @Test
    @DisplayName("사다리 타기를 완료한 후, 해당 결과의 인덱스에 위치한 사람에게 주어진다.")
    void receiveItemByIndex() {
        List<String> items = List.of("꽝", "5000", "꽝", "3000");
        int personCount = 4;
        Items generatedItems = Items.of(items, personCount);
        Item item = generatedItems.findBy(new Index(0));
        assertThat(item.getName()).isEqualTo("꽝");
    }
}
