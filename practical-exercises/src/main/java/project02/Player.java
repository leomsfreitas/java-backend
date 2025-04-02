package project02;

import project02.deck.Card;

public class Player {
    private String name;
    private Card[] cards;
    private int points;
    private int currentCardIndex;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.cards = new Card[3];
        this.currentCardIndex = 0;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
        this.currentCardIndex = 0;
    }

    public Card chooseCard() {
        if (currentCardIndex < cards.length) {
            return cards[currentCardIndex++];
        }
        return null;
    }

    public void addPoint() {
        points++;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}