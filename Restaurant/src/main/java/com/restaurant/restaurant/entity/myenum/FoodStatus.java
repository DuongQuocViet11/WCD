package com.restaurant.restaurant.entity.myenum;

public enum FoodStatus {
    DANGBAN(1), DUNGBAN(0), DELETE(-1), UNDEFINE(-2);
    private int value;
    FoodStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FoodStatus of(int value){
        for (FoodStatus status:
                FoodStatus.values()){
            if(status.getValue() == value){
                return status;
            }
        }
        return FoodStatus.UNDEFINE;
    }
}
