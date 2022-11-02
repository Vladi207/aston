package org.github.grashchenko.designePatterns.builder;

public final class Character {

    private final String name;
    private final CharacterType characterType;
    private final HairType hairType;
    private final HairColor hairColor;
    private final Weapon weapon;
    private final Armor armor;

    public Character(CharacterBuilder characterBuilder) {
        this.name = characterBuilder.getName();
        this.characterType = characterBuilder.getCharacterType();
        this.hairType = characterBuilder.getHairType();
        this.hairColor = characterBuilder.getHairColor();
        this.weapon = characterBuilder.getWeapon();
        this.armor = characterBuilder.getArmor();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This is a ")
                .append(characterType)
                .append(" named ")
                .append(name);
        if (hairColor != null || hairType != null) {
            sb.append(" with ");
            if (hairColor != null) {
                sb.append(hairColor).append(' ');
            }
            if (hairType != null) {
                sb.append(hairType).append(' ');
            }
            sb.append(hairType != HairType.BALD ? "hair" : "head");
        }
        if (armor != null) {
            sb.append(" wearing ").append(armor);
        }
        if (weapon != null) {
            sb.append(" and wielding a ").append(weapon);
        }
        sb.append('.');
        return sb.toString();
    }

}
