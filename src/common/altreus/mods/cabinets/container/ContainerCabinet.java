package altreus.mods.cabinets.container;

import altreus.mods.cabinets.tile.TileEntityCabinet;
import net.minecraft.src.*;

public class ContainerCabinet extends Container {

    protected TileEntityCabinet tileEntity;

    public ContainerCabinet (InventoryPlayer inventoryPlayer, TileEntityCabinet te){
        tileEntity = te;

        //the Slot constructor takes the IInventory and the slot number in that it binds to
        //and the x-y coordinates it resides on-screen
        addSlotToContainer(new Slot(tileEntity, 0, 0, 0));
        addSlotToContainer(new Slot(tileEntity, 0, 50, 50));

        //commonly used vanilla code that adds the player's inventory
        bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(int slot) {
        // TODO
        return null;
    }


    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                            8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }
}

