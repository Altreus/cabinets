package altreus.mods.cabinets.client.gui;

import altreus.mods.cabinets.container.ContainerCabinet;
import altreus.mods.cabinets.tile.TileEntityCabinet;
import net.minecraft.src.*;

import org.lwjgl.opengl.GL11;

public class GuiCabinet extends GuiContainer {

    public GuiCabinet (InventoryPlayer inventoryPlayer,
            TileEntityCabinet tileEntity) {
        //the container is instanciated and passed to the superclass for handling
        super(new ContainerCabinet(inventoryPlayer, tileEntity));
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        //draw text and stuff here
        //the parameters for drawString are: string, x, y, color
        fontRenderer.drawString("Cabinet", 8, 6, 4210752);
        //draws "Inventory" or your regional equivalent
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
            int par3) {
        //draw your Gui here, only thing you need to change is the path
        int texture = mc.renderEngine.getTexture("/gui/container.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(texture);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
