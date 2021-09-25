# Menu-Manager
A Menu Manager for spigot plugins

[![](https://jitpack.io/v/AbhigyaKrishna/Menu-Manager.svg)](https://jitpack.io/#AbhigyaKrishna/Menu-Manager)

## Including in project:
### Maven
```xml
<project>
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.AbhigyaKrishna</groupId>
            <artifactId>Menu-Manager</artifactId>
            <version>1.0.2</version>
        </dependency>
    </dependencies>
</project>
```

### Gradle
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
        implementation 'com.github.AbhigyaKrishna:Menu-Manager:1.0.2'
}
```

# Usage:
```java
package me.abhigya.examplemenu;

import abhigya.menu.StringUtils;
import abhigya.menu.material.XMaterial;
import abhigya.menu.menu.ItemMenu;
import abhigya.menu.menu.action.ItemClickAction;
import abhigya.menu.menu.item.action.ActionItem;
import abhigya.menu.menu.item.action.ItemAction;
import abhigya.menu.menu.item.action.ItemActionPriority;
import abhigya.menu.menu.size.ItemMenuSize;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class ExampleMenu extends JavaPlugin {

    private ItemMenu menu;

    @Override

    public void onEnable() {
        this.menu = new ItemMenu("My Menu", ItemMenuSize.SIX_LINE, null);
        this.menu.registerListener(this);

        ActionItem stone = new ActionItem(StringUtils.translateAlternateColorCodes("&aStone"),
                XMaterial.STONE.parseItem(),
                StringUtils.translateAlternateColorCodes("&eClick to get 64 stone!"));
        stone.addAction(new ItemAction() {
            @Override
            public ItemActionPriority getPriority() {
                return ItemActionPriority.NORMAL;
            }

            @Override
            public void onClick(ItemClickAction action) {
                action.getPlayer().getInventory().addItem(new ItemStack(XMaterial.STONE.parseMaterial(), 64));
            }
        });

        this.menu.addItem(stone);

        this.getCommand("testmenu").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
                if (!(sender instanceof Player))
                    return false;

                Player player = (Player) sender;
                ExampleMenu.this.menu.open(player);
            }
        });
    }
}
```