package altreus.mods.cabinets.client.render;

import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import altreus.mods.cabinets.client.render.ModelCabinet;
import altreus.mods.cabinets.tile.TileEntityCabinet;

public class RenderCabinet extends TileEntitySpecialRenderer {
    static final float scale = (float) (1.0/16.0);
    private ModelCabinet model = new ModelCabinet(scale);

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        model.render((TileEntityCabinet)tileEntity, x, y, z);
    }
}
