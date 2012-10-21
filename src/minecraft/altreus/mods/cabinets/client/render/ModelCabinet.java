package altreus.mods.cabinets.client.render;

import org.lwjgl.opengl.GL11;

import altreus.mods.cabinets.Cabinets;
import altreus.mods.cabinets.tile.TileEntityCabinet;

import java.util.Random;
import net.minecraft.src.*;
import net.minecraftforge.client.ForgeHooksClient;

class ModelCabinet extends ModelBase {
    private ModelRenderer cabinetBack, cabinetLeftDoor, cabinetRightDoor;
    private float scale;
    private int facing;
    
    public ModelCabinet(float scale) {
        this.textureHeight = 64;
        this.textureWidth = 64;

        ModelRenderer cabinetBack = new ModelRenderer(this,0,0);
        cabinetBack.addBox(0F,0F,-1F,8,8,6);
        this.cabinetBack = cabinetBack;
    }

    public void render(TileEntityCabinet tileEntity, double x, double y, double z) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glTranslated(x, y, z);
        ForgeHooksClient.bindTexture("/gui/container.png", 0);

        render(scale);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    public void render(float newScale) {
        this.cabinetBack.render(newScale);
    }
}
