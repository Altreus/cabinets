package altreus.mods.cabinets;

import altreus.mods.cabinets.client.gui.GuiCabinet;
import altreus.mods.cabinets.container.ContainerCabinet;
import altreus.mods.cabinets.tile.TileEntityCabinet;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class CommonProxy implements IGuiHandler {
    public static String ITEMS_PNG = "/altreus/mods/cabinets/items.png";
    public static String BLOCK_PNG = "/altreus/mods/cabinets/block.png";

    // Client stuff
    public void registerRenderers () {
        // Nothing here as this is the server side proxy
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityCabinet){
            return new ContainerCabinet(player.inventory, (TileEntityCabinet) tileEntity);
        }
        return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityCabinet){
            return new GuiCabinet(player.inventory, (TileEntityCabinet) tileEntity);
        }
        return null;
    }

	public void initTileEntities() {
		GameRegistry.registerTileEntity(TileEntityCabinet.class, "tileEntityCabinet");
	}

	public void initRenderingAndTextures() {}
}
