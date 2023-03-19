package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import utils.exceptions.CardNotFoundException;

class CardListTest {
    private static final String UUID_1 = "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454";
    private static final String UUID_2 = "00000000-0000-0000-0000-000000000001";
    Card card1 = new Card("is akhil a dirty commie", "yes", UUID_1);
    Card card2 = new Card("why do other groups keep attackin ian", "he is not a dirty commie", UUID_2);

    @Test
    void findCardFromUUID() {
        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(card1, card2));
        CardList cardList = new CardList(cards);
        try {
            assertEquals(card1, cardList.findCardFromUUID(new CardUUID(UUID.fromString(UUID_1))));
            assertEquals(card2, cardList.findCardFromUUID(new CardUUID(UUID.fromString(UUID_2))));
        } catch (CardNotFoundException e) {
            assertEquals("Card cannot be found", e.getMessage());
        }
    }
}
