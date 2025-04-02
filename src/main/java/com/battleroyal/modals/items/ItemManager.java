package com.battleroyal.modals.items;

import java.util.ArrayList;
import java.util.List;

import com.battleroyal.utils.Console;

public class ItemManager {

    private List<Weapon> weapons;
    private List<Weapon> futuristicWeapons;
    private List<Consumable> consumables;
    private List<UpgradeItems> upgradeItems;

    public ItemManager() {
        this.weapons = new ArrayList<>();
        this.consumables = new ArrayList<>();
        this.futuristicWeapons = new ArrayList<>();
        this.upgradeItems = new ArrayList<>();
        initWeaponList();
        initConsumableList();
        initUpgradeItemList();
    }

    public Weapon getRandomWeapon() {
        return weapons.get(Console.randomNumber(0, weapons.size() - 1));
    }

    public Weapon getRandomFuturisticWeapon() {
        return futuristicWeapons.get(Console.randomNumber(0, futuristicWeapons.size() - 1));
    }

    public UpgradeItems getRandoUpgradeItems() {
        boolean isValid = false;
        UpgradeItems upgradeItem;
        do {
            isValid = false;
            upgradeItem = upgradeItems.get(Console.randomNumber(0, upgradeItems.size() - 1));
            if (upgradeItem.isFuturistic()) {
                if (Console.randomNumber(0, 100) < 50) {
                   isValid = true;
                }
            } else {
               isValid = true; 
            }
        } while (!isValid); 

        return upgradeItem;
    }
    public Consumable getRandomConsumable() {
        return consumables.get(Console.randomNumber(0, consumables.size() - 1));
    }

    private void initWeaponList() {
        for (WeaponEnum weapon : WeaponEnum.values()) {
            if (weapon.getDamage() >= 50) {
                futuristicWeapons.add(ItemFactory.createWeapon(weapon));
            } else {
                weapons.add(ItemFactory.createWeapon(weapon));
            }
        }
    }

    private void initUpgradeItemList() {
        for (UpgradeItemEnum upgradeItem : UpgradeItemEnum.values()) {
            upgradeItems.add(ItemFactory.createUpgradeItem(upgradeItem));
        }
    }

    private void initConsumableList() {
        for (ConsumableEnum consumable : ConsumableEnum.values()) {
            consumables.add(ItemFactory.createConsumable(consumable));
        }
    }
}
