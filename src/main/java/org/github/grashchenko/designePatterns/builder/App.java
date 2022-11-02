package org.github.grashchenko.designePatterns.builder;

public class App {
    public static void main(String[] args) {
        Character mage = new CharacterBuilder("gandalf", CharacterType.MAGE)
                .setHairColor(HairColor.BLACK)
                .setWeapon(Weapon.DAGGER)
                .build();

        System.out.println(mage);

        Character warrior = new CharacterBuilder("warrior", CharacterType.WARRIOR)
                .setHairType(HairType.SHORT)
                .setArmor(Armor.CLOTHES)
                .setWeapon(Weapon.BOW)
                .build();

        System.out.println(warrior);
    }

}
