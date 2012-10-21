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
        this.textureHeight = 16;
        this.textureWidth = 16;

        // origins X, Y and Z seem to be from the corner of the box.
        // The scale is used so we can use integers to draw the boxes and then shrink it to fit a metre.
        // Hence, a metre cube is 16 units to a side since we usually set the scale to 1/16
        this.scale = scale;
        ModelRenderer cabinetBack = new ModelRenderer(this,0,0);
        cabinetBack.addBox(1F,0F,1F,12,16,14,scale);
        ModelRenderer cabinetFront = new ModelRenderer(this,0,0);
        cabinetFront.addBox(13F,1F,2F, 2, 14, 12, scale);
        this.cabinetLeftDoor = cabinetFront;
        this.cabinetBack = cabinetBack;
    }

    public void render(TileEntityCabinet tileEntity, double x, double y, double z) {
    	ForgeHooksClient.bindTexture("/gui/background.png", 0);
      	GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glTranslated(x, y, z);

        render(scale);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    public void render(float newScale) {
        this.cabinetBack.render(newScale);
        this.cabinetLeftDoor.render(newScale);
    }
}
