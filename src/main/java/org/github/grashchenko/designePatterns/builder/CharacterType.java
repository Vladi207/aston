package org.github.grashchenko.designePatterns.builder;

public enum CharacterType {

    WARRIOR, THIEF, MAGE, PRIEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
