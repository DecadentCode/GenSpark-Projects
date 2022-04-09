import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonCaveTest {
    DragonCave game;

    @BeforeEach
    void setUp(){
        game = new DragonCave();
    }

    @DisplayName("Cave 1 dies to the dragon")
    @Test
    void dragonCaveFailure() {
        game.dragonCave(1);
        assertFalse(game.success, "Something went wrong.");
    }

    @DisplayName("Cave 2 survives the dragon")
    @Test
    void dragonCaveSurvive() {
        game.dragonCave(2);
        assertTrue(game.success, "Something went wrong.");
    }

    @DisplayName("Invalid choice dies to the dragon")
    @Test
    void dragonCaveInvalid() {
        game.dragonCave(3);
        assertFalse(game.success, "Something went wrong.");
    }

}