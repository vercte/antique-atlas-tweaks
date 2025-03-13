package net.vercte.antiqueatlastweaks.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import folk.sisby.antique_atlas.AntiqueAtlasKeybindings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.vercte.antiqueatlastweaks.AntiqueAtlasTweaks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AntiqueAtlasKeybindings.class)
public class MapKeybindMixin {
    @ModifyExpressionValue(method = "onClientTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/KeyMapping;consumeClick()Z"))
    private static boolean onlyOpenIfAntiqueAtlasIsPresent(boolean original, Minecraft client) {
        LocalPlayer player = client.player;
        if(player == null) {
            return original;
        }

        return original && player.getInventory().hasAnyMatching(item -> item.is(AntiqueAtlasTweaks.ANTIQUE_ATLAS));
    }
}
