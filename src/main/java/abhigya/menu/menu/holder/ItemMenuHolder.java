package abhigya.menu.menu.holder;

import abhigya.menu.menu.ItemMenu;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class ItemMenuHolder implements InventoryHolder {

    private final ItemMenu menu;
    private final Inventory inventory;

    public ItemMenuHolder(ItemMenu menu, Inventory inventory) {
        this.menu = menu;
        this.inventory = inventory;
    }

    public ItemMenu getItemMenu() {
        return menu;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

}
