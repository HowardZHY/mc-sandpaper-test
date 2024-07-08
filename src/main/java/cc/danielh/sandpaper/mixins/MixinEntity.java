package cc.danielh.sandpaper.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class MixinEntity {

    @Shadow
    public World worldObj;

    @Inject(method = {"isEntityInsideOpaqueBlock"}, at = {@At("HEAD")}, cancellable = true)
    public void isEntityInsideOpaqueBlock(CallbackInfoReturnable<Boolean> cir) {
        if (this.worldObj.isRemote) {
            cir.setReturnValue(Boolean.valueOf(false));
            cir.cancel();
        }
    }
}
