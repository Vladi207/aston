package org.github.grashchenko.designePatterns.builder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterBuilderTest {

    protected Character character;

    @Before
    public void setUp() {
        character = new CharacterBuilder("warrior", CharacterType.WARRIOR)
                .setWeapon(Weapon.DAGGER)
                .setArmor(Armor.CLOTHES)
                .setHairColor(HairColor.BLACK)
                .setHairType(HairType.BALD)
                .build();
    }

    @Test
    public void testMissingName() {
        assertThrows(IllegalArgumentException.class, () -> new CharacterBuilder(null, CharacterType.WARRIOR));
    }

    @Test
    public void testMissingCharacterType() {
        assertThrows(IllegalArgumentException.class, () -> new CharacterBuilder("name", null));
    }

    @Test
    public void testBuild() {
        assertNotNull(character);
        assertNotNull(character.toString());
        assertEquals(CharacterType.WARRIOR, character.getCharacterType());
        assertEquals("warrior", character.getName());
        assertEquals(Armor.CLOTHES, character.getArmor());
        assertEquals(Weapon.DAGGER, character.getWeapon());
        assertEquals(HairType.BALD, character.getHairType());
        assertEquals(HairColor.BLACK, character.getHairColor());
    }
}