package com.home.primeseller;

public enum ItemEnum {

    Sandwich(5), Coffee(3), Cereal(3), Pizza(40);

    private int prepTime;

    private ItemEnum(int prepTime) {
        this.prepTime = prepTime;
    }

    public static String getItemEnum(int itemId) {
        for (ItemEnum itemEnum : ItemEnum.values()) {
            if ((itemEnum.ordinal()+1) == itemId) {
                return itemEnum.name();
            }
        }
        return null;
    }

    public static Integer getItemCookingTime(int itemId) {
        for (ItemEnum itemEnum : ItemEnum.values()) {
            if ((itemEnum.ordinal()+1) == itemId) {
                return itemEnum.prepTime;
            }
        }
        return null;
    }

}
