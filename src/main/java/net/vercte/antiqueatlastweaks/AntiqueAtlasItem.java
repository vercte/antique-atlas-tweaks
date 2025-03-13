package net.vercte.antiqueatlastweaks;

import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class AntiqueAtlasItem extends Item {
    public AntiqueAtlasItem() {
        super(new Properties().stacksTo(1));
    }

    public @NotNull String getDescriptionId() {
        return "item.antique_atlas.atlas";
    }
}
