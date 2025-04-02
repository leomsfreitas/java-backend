package project02;

import project02.deck.Card;

public class Player {
    private String name;
    private int score;
    private Card[] cards;
    private int currentCardIndex;

    public Player(String name) {
        setName(name);
        this.score = 0;
        this.cards = new Card[3];
        this.currentCardIndex = 0;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public Card chooseCard() {
        if (currentCardIndex < cards.length) {
            return cards[currentCardIndex++];
        }
        return null;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
