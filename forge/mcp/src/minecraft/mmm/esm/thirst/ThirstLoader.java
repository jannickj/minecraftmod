package mmm.esm.thirst;

import mmm.esm.thirst.gui.ThirstGuiHandler;
import mmm.esm.thirst.items.FilteredWaterCupItem;
import mmm.esm.thirst.items.UnfilteredWaterCupItem;
import mmm.esm.thirst.items.WoodenCupItem;
import mmm.esm.thirst.items.PureWaterCupItem;
import mmm.esm.thirst.items.BoilingWaterCupItem;
import net.minecraft.item.Item;
//This Import list will grow longer with each additional tutorial.
//It's not pruned between full class postings, unlike other tutorial code.
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
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
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkModHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.ItemData;
import mmm.esm.thirst.items.condensator.*;
import mmm.esm.thirst.network.*;



@Mod(modid="thirstmod", name="Thirst Mod", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false,clientPacketHandlerSpec =
@SidedPacketHandler(channels = {"thirstmod" }, packetHandler = ThirstClientPackageHandler.class),
serverPacketHandlerSpec =
@SidedPacketHandler(channels = {"thirstmod" }, packetHandler = ThirstServerPackageHandler.class))
public class ThirstLoader {
     
     
     @Instance("thirstmod")
     public static ThirstLoader instance = new ThirstLoader();
     
     public final static Item BoilingWaterCup = new BoilingWaterCupItem (4054);
     @SidedProxy(clientSide = "mmm.esm.thirst.ClientProxy", serverSide = "mmm.esm.thirst.CommonProxy")
     public static CommonProxy proxy;
     
     public static ThirstGuiHandler guihandler = new ThirstGuiHandler();
     
     public final static Item PureWaterCup = new PureWaterCupItem(4053);
     
     public final static Item PureWaterCup = new PureWaterCupItem(5000);
     
     public final static Item filteredWaterCup = new FilteredWaterCupItem(4052);
     
     public final static Item unfilteredWaterCup = new UnfilteredWaterCupItem(4051);

     public final static Item woodenCup = new WoodenCupItem(4050);
     
     public final static Block blockCondensator = new BlockCondensator(4055);
    
 
     
     
     @PreInit
     public void preInit(FMLPreInitializationEvent event) {
             // Stub Method
     }
     
     @Init
     public void load(FMLInitializationEvent event) {
             LanguageRegistry.addName(woodenCup, "Wooden Cup");
             LanguageRegistry.addName(unfilteredWaterCup, "Cup of Unfiltered Water");
             LanguageRegistry.addName(PureWaterCup, "Cup of Pure Water");
             LanguageRegistry.addName(filteredWaterCup, "Cup of Filtered Water");
    	NetworkRegistry.instance().registerGuiHandler(this, this.guihandler);
             LanguageRegistry.addName(BoilingWaterCup, "Cup of Boiling Water");

         
        LanguageRegistry.addName(blockCondensator, "Condensator");
         
        ModLoader.registerBlock(blockCondensator);
        ModLoader.registerTileEntity(TileEntityCondensator.class, TileEntityCondensator.Name);
         
         
         
        ItemStack coal = new ItemStack(Item.coal);	
        coal.setItemDamage(1);
         
         
        for(int i = 0; i < 4; i++)
        	GameRegistry.addRecipe(new ItemStack(woodenCup,3), "x x", "x x", " x ", 'x', new ItemStack(Block.planks,1,i));
        GameRegistry.addRecipe(new ItemStack(filteredWaterCup), " x", " y", 'x', coal, 'y', unfilteredWaterCup);
             GameRegistry.addSmelting(filteredWaterCup.itemID,new ItemStack (BoilingWaterCup),0.5F);
             GameRegistry.addSmelting(unfilteredWaterCup.itemID,new ItemStack (BoilingWaterCup),0.2F);
            
             
     }
     
     @PostInit
     public void postInit(FMLPostInitializationEvent event) {
             // Stub Method
     }
}
