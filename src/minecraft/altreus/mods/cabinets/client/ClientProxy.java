package altreus.mods.cabinets.client;

import net.minecraftforge.client.MinecraftForgeClient;
import altreus.mods.cabinets.CommonProxy;
import altreus.mods.cabinets.tile.TileEntityCabinet;
import altreus.mods.cabinets.client.render.RenderCabinet;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);
	}

    @Override
    public void initTileEntities() {
        super.initTileEntities();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCabinet.class, new RenderCabinet());
    }
}
