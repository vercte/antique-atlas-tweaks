package net.vercte.antiqueatlastweaks.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.vercte.antiqueatlastweaks.AntiqueAtlasTweaks;

public class AntiqueAtlasTweaksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(e ->
                e.addAfter(Items.MAP, AntiqueAtlasTweaks.ANTIQUE_ATLAS));
    }
}
