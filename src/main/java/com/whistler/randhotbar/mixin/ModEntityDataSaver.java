package com.whistler.randhotbar.mixin;

import com.whistler.randhotbar.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.whistler.randhotbar.RandHotbar.MOD_ID;

@Mixin(Entity.class)
public abstract class ModEntityDataSaver implements IEntityDataSaver {
    private NbtCompound persistent;
    private final String KEY = "randomizer_data";

    @Override
    public NbtCompound getPersistentData() {
        if(persistent == null){
            persistent = new NbtCompound();
        }
        return persistent;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable info) {
        if(persistent != null) {
            nbt.put( MOD_ID + "." + KEY, persistent);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if(nbt.contains(MOD_ID + "." + KEY, 10)){
            persistent = nbt.getCompound(MOD_ID + "." + KEY);
        }
    }


}
