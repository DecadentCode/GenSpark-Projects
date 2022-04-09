import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    Hangman game;

    @BeforeEach
    void setUp(){
        game = new Hangman();
    }

    @DisplayName("letterTracker: Guessed the word")
    @Test
    void correctWord() {
        game.word = "yes";
        assertTrue(game.letterTracker("yes"));
    }

    @DisplayName("letterTracker: Not enough correct guesses")
    @Test
    void incorrectWord() {
        game.word = "morning";
        assertFalse(game.letterTracker("asdf"));
    }

    @DisplayName("printGallows: no fails")
    @Test
    void validGuess() {
        game.printGallows(0);
        assertEquals( System.out.println("""
                    |---------|
                    |
                    |
                    |
                    |
                    |
                    |============|
                    """), game.printGallows(-1));
    }
}