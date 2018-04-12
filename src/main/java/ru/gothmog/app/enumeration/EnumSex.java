package ru.gothmog.app.enumeration;

public enum EnumSex {

    ALL(""),
    MAN("Мужчина"),
    WOMAN("Женщина");

    private String description;

    EnumSex(String description) {
        this.description = description;
    }

    public static EnumSex fromValue(final String description) {
        for (final EnumSex enumSex : EnumSex.values()) {
            if (enumSex.getDescription().equals(description)) {
                return enumSex;
            }
        }
        throw new IllegalArgumentException("error converter EnumSex");
    }

    public String getDescription() {
        return description;
    }
}
