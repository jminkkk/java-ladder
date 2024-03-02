package model.items;

import java.util.Collections;
import java.util.List;
import model.people.PersonCount;

public class Items {

    private final List<Item> items;

    private Items(final List<Item> items) {
        this.items = Collections.unmodifiableList(items);
    }

    public static Items of(final List<String> itemNames, final PersonCount personCount) {
        int itemsCount = itemNames.size();
        validateItemsCount(itemsCount, personCount);

        List<Item> items = itemNames.stream()
                .map(Item::new)
                .toList();
        return new Items(items);
    }

    private static void validateItemsCount(final int itemsCount, final PersonCount personCount) {
        if (personCount.isNotEqual(itemsCount)) {
            throw new IllegalArgumentException("참여 인원 수와 결과 목록의 수가 동일하지 않습니다.");
        }
    }

    public Item findBy(int index) {
        return items.get(index);
    }

    public Item get(final int finalPosition) {
        return items.get(finalPosition);
    }

    public List<String> getNames() {
        return items.stream()
                .map(Item::getName)
                .toList();
    }
}