package com.smallworldfs.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.smallworldfs.anagram.Challenge;
import org.junit.jupiter.api.Test;

public class ChallengeTest {

    private final Challenge challenge = new Challenge();

    @Test
    void anagramIsNotTheSameAsEqual() {
        assertEquals(false, Challenge.isAnagrama("hola", "hola"));
    }

    @Test
    void lowerCaseUpperCaseDoesNotImpactInResult() {
        assertEquals(true, Challenge.isAnagrama("hola", "HALO"));
    }

    @Test
    void differentLengthIsNotAnagramForSure() {
        assertEquals(false, Challenge.isAnagrama("hola", "HALOs"));
    }

    @Test
    void testMoreComplexWorlds() {
        assertEquals(true, Challenge.isAnagrama("Imponderable", "imperdonable"));
    }
}
