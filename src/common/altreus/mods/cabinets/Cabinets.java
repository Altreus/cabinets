package altreus.mods.cabinets;

import altreus.mods.cabinets.block.BlockCabinet;
import altreus.mods.cabinets.client.render.RenderCabinet;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;


import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

@Mod(modid="Altreus_Cabinets", name="Cabinets", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class Cabinets {

    public static final Block cabinet = (new BlockCabinet(500))
        .setHardness(2.5F)
        .setStepSound(Block.soundWoodFootstep)
        .setBlockName("cabinet");
        //.setRequiresSelfNotify();

    // The instance of your mod that Forge uses.
	@Instance("Altreus_Cabinets")
	public static Cabinets instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="altreus.mods.cabinets.client.ClientProxy", serverSide="altreus.mods.cabinets.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();

        // TODO: Extract this stuff into its own class
        LanguageRegistry.addName(cabinet, "Cabinet");
        MinecraftForge.setBlockHarvestLevel(cabinet, "axe", 0);
        GameRegistry.registerBlock(cabinet);
        GameRegistry.addRecipe(new ItemStack(cabinet),
            "XXX",
            "XYX",
            "XXX",
            'X', new ItemStack(Block.planks),
            'Y', new ItemStack(Item.doorWood)
        );

        NetworkRegistry.instance().registerGuiHandler(this, proxy);
        
        RenderCabinet.renderId = RenderingRegistry.getNextAvailableRenderId();
        proxy.initTileEntities();
        proxy.initRenderingAndTextures();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}

