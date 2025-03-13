package net.vercte.antiqueatlastweaks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class AntiqueAtlasTweaks implements ModInitializer {
    public static final String ID = "antique_atlas_tweaks";
    public static final Item ANTIQUE_ATLAS = Registry.register(
            BuiltInRegistries.ITEM, at("antique_atlas"),
            new AntiqueAtlasItem());

    @Override
    public void onInitialize() {

    }

    public static ResourceLocation at(String path) {
        return new ResourceLocation(ID, path);
    }
}
