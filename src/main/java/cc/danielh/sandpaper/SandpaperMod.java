package cc.danielh.sandpaper;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

public class SandpaperMod implements IFMLLoadingPlugin {

    public static final String MOD_ID = "sandpaper";

    public static final String MOD_NAME = "Sandpaper";

    public SandpaperMod() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.sandpaper.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}