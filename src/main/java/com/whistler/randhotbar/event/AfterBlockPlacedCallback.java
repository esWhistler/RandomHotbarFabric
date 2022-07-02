package com.whistler.randhotbar.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

/**
 * Callback for right-clicking ("placing") with a block in hand.
 * Upon return:
 * SUCCESS cancels further processing and, on the client, sends a packet to the server.
 * PASS falls back to further processing.
 * FAIL cancels further processing and does not send a packet to the server.
 */

public interface AfterBlockPlacedCallback {
    Event<AfterBlockPlacedCallback> EVENT = EventFactory.createArrayBacked(AfterBlockPlacedCallback.class,
            (listeners) -> (player, world, hand, hitResult) -> {
                for (AfterBlockPlacedCallback event : listeners) {
                    ActionResult result = event.interact(player, world, hand, hitResult);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            }
    );

    ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult);
}
