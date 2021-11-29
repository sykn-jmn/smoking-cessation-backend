package com.example.smokingcessation.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "dailyChallengeSequence")
public class DailyChallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idgen")
    @SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "challengeSeq")
    @Column(nullable = false,updatable = false)
    public Long id;
    @Column(length = 1000)
    public String quote;

    public DailyChallenge(){}

    public DailyChallenge(String quote) {
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
