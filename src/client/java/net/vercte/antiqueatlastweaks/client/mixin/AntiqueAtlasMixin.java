package net.vercte.antiqueatlastweaks.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import folk.sisby.antique_atlas.AntiqueAtlas;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.ItemStack;
import net.vercte.antiqueatlastweaks.AntiqueAtlasTweaks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AntiqueAtlas.class)
public class AntiqueAtlasMixin<T> {
    @Inject(method = "isHandheldAtlas", at = @At("HEAD"), cancellable = true)
    private static void myItemOnly(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(stack.is(AntiqueAtlasTweaks.ANTIQUE_ATLAS));
    }

    @WrapOperation(method = "onInitializeClient", at = @At(value = "INVOKE", target = "Lnet/fabricmc/fabric/api/event/Event;register(Ljava/lang/Object;)V", ordinal = 4), remap = false)
    public void cancelOriginalItem(Event instance, T t, Operation<Void> original) {
        instance.register((ItemGroupEvents.ModifyEntries)(e) -> {});
    }
}
