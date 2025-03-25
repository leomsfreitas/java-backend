package project_0;

import java.time.LocalDate;

public class Post {
    private String quote;
    private LocalDate localDate;
    private int claps;
    private int boss;
    private UserAccount account;

    public Post(UserAccount account, String quote) {
        this.account = account;
        this.quote = quote;
        this.localDate = LocalDate.now();
        this.claps = 0;
        this.boss = 0;
    }

    public String show() {
        return String.format("""
                \tQuote: %s
                \tLocal Date: %s
                \tClaps: %d
                \tBoss: %d
                """, quote, localDate, claps, boss);
    }

    public void clap() {
        claps++;
    }

    public void boo() {
        boss++;
    }
}