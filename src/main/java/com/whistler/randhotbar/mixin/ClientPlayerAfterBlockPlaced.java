package com.whistler.randhotbar.mixin;

import com.whistler.randhotbar.event.AfterBlockPlacedCallback;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerAfterBlockPlaced {
    @Final
    @Shadow
    private ClientPlayNetworkHandler networkHandler;

    @Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getStackInHand(Lnet/minecraft/util/Hand;)Lnet/minecraft/item/ItemStack;", ordinal = 0), method = "interactBlock", cancellable = true)
    public void afterBlockPlaced(ClientPlayerEntity player, ClientWorld world, Hand hand, BlockHitResult blockHitResult, CallbackInfoReturnable<ActionResult> info) {
        if (!player.getMainHandStack().isEmpty() || !player.getOffHandStack().isEmpty()) {
            ActionResult result = AfterBlockPlacedCallback.EVENT.invoker().interact(player, world, hand, blockHitResult);

            if (result != ActionResult.PASS) {
                if (result == ActionResult.SUCCESS) {
                    this.networkHandler.sendPacket(new PlayerInteractBlockC2SPacket(hand, blockHitResult));
                }

                info.setReturnValue(result);
            }
        }
    }
}
