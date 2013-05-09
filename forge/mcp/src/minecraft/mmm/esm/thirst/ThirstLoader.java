package mmm.esm.thirst;

import mmm.esm.thirst.items.UnfilteredWaterCupItem;
import mmm.esm.thirst.items.WoodenCupItem;
import net.minecraft.item.Item;
//This Import list will grow longer with each additional tutorial.
//It's not pruned between full class postings, unlike other tutorial code.
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

@Mod(modid="thirstmod", name="Thirst Mod", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ThirstLoader {
     
     
     @Instance("ThirstLoader")
     public static ThirstLoader instance;
     
     public final static UnfilteredWaterCupItem unfilteredWaterCup = new UnfilteredWaterCupItem(4051);

     public final static Item woodenCup = new WoodenCupItem(4050);
     
     
     
     @PreInit
     public void preInit(FMLPreInitializationEvent event) {
             // Stub Method
     }
     
     @Init
     public void load(FMLInitializationEvent event) {
             LanguageRegistry.addName(woodenCup, "Wooden Cup");
             LanguageRegistry.addName(unfilteredWaterCup, "Cup With Unfiltered Water");
             
             ItemStack plank = new ItemStack(Block.planks);
             
             GameRegistry.addRecipe(new ItemStack(woodenCup), "x x", "x x", " x ", 'x', plank);
             
     }
     
     @PostInit
     public void postInit(FMLPostInitializationEvent event) {
             // Stub Method
     }
}
