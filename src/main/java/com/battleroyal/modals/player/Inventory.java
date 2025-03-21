package com.battleroyal.modals.player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.battleroyal.modals.items.Food;
import com.battleroyal.modals.items.Weapon;

public class Inventory {
    
    private Weapon weapon;
    private List<Food> foods;

    public Inventory(){
        weapon = null;
        foods = new ArrayList<>();
    }

    public void addFood(Food food){
        foods.add(food);
    }

    public void changeWeapon(Weapon newWeapon){
        this.weapon = newWeapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

}
