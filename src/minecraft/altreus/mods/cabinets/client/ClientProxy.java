package altreus.mods.cabinets.client;

import net.minecraftforge.client.MinecraftForgeClient;
import altreus.mods.cabinets.CommonProxy;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);
	}
}
