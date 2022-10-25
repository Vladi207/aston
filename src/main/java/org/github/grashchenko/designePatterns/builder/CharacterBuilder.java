package org.github.grashchenko.designePatterns.builder;

public class CharacterBuilder {

    private final String name;
    private final CharacterType characterType;
    private HairType hairType;
    private HairColor hairColor;
    private Weapon weapon;
    private Armor armor;

    public CharacterBuilder(String name, CharacterType characterType) {
        if (name == null || characterType == null) {
            throw new IllegalArgumentException("Name and Character class can not be null");
        }
        this.name = name;
        this.characterType = characterType;
    }

    public CharacterBuilder setHairType(HairType hairType) {
        this.hairType = hairType;
        return this;
    }

    public CharacterBuilder setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public CharacterBuilder setWeapon(Weapon weapon) {
        this.weapon = weapon;
        return this;
    }

    public CharacterBuilder setArmor(Armor armor) {
        this.armor = armor;
        return this;
    }

    public Character build() {
        return new Character(this);
    }

    public String getName() {
        return name;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public HairType getHairType() {
        return hairType;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }
}
