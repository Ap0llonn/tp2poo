package com.battleroyal.modals.player;

import java.util.ArrayList;
import java.util.List;

import com.battleroyal.modals.items.Consumable;
import com.battleroyal.modals.items.ConsumableEnum;
import com.battleroyal.modals.items.ItemFactory;
import com.battleroyal.modals.items.Weapon;
import com.battleroyal.modals.items.WeaponEnum;
import com.battleroyal.utils.Console;
import com.battleroyal.modals.items.ItemManager;
import com.battleroyal.modals.items.UpgradeItems;

public class Inventory {

    private Weapon weapon;
    private List<Consumable> consumables;
    private List<UpgradeItems> upgradeItems;
    private ItemManager itemManager;

    public Inventory() {
        itemManager = new ItemManager();
        weapon = null;
        consumables = new ArrayList<>();
        upgradeItems = new ArrayList<>();
        weapon = itemManager.getRandomWeapon();

        initConsumable();
    }

    public void addFood(Consumable consumable) {
        consumables.add(consumable);
    }

    public void addRandomItem() {
        Consumable consumable = itemManager.getRandomConsumable();
        consumables.add(consumable);
        System.out.println("Vous avez trouvée " + consumable.getName());
    }

    public void addRandomUpgradeItems() {
        UpgradeItems upgrade = itemManager.getRandoUpgradeItems();
        upgradeItems.add(upgrade);
        System.out.println("Vous avez trouvée " + upgrade.getName());
    }

    public void changeWeapon(Weapon newWeapon, Player user) {
        user.updateStats(newWeapon, this.weapon);
        this.weapon = newWeapon;

    }

    public void giveFuturisticGun(Player player) {
        Weapon weapon = itemManager.getRandomFuturisticWeapon();
        player.updateStats(weapon, this.weapon);
        this.weapon = weapon;
    }

    public void giveConsumable(ConsumableEnum type) {
        consumables.add(ItemFactory.createConsumable(type));
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public List<UpgradeItems> getUpgradeItems() {
        return upgradeItems;
    }

    public List<Consumable> getConsumables() {
        return consumables;
    }

    public boolean consumableIsEmpty() {
        if (consumables.isEmpty()) {
            System.out.println("Vous n'avez pas de consommable");
            return false;
        }

        return true;
    }

    public boolean upgradeIsEmpty(){
        if (upgradeItems.isEmpty()) {
            System.out.println("Vous n'avez pas d'amélioration");
            return false;
        }

        return true;
    }

    private void initConsumable() {
        int randomNb = Console.randomNumber(0, 3);
        for (int i = 0; i < randomNb; i++) {
            consumables.add(itemManager.getRandomConsumable());
        }
    }

    public void displayInventory() {
        int index = 0;
        System.out.println("-----Inventaire-----");

        displayConsumables();
        displayUpgrades();
        System.out.println(weapon.toString());
    }

    public void displayConsumables() {
        int index = 0;
        System.out.println("-----Consomable-----");
        for (Consumable consumable : consumables) {
            System.out.println(index + " " + consumable.toString());
            index++;
        }
    }

    public void displayUpgrades() {
        int index = 0;
        System.out.println("-----Amélioration-----");
        for (UpgradeItems upgradeItem : upgradeItems) {
            System.out.println(index + " " + upgradeItem.toString());
            index++;
        }
    }

}
