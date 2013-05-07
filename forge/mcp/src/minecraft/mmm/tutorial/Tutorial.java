package mmm.tutorial;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Tutorial.modid, name = "MMM Mod", version = "1.5.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Tutorial
{
       public static final String modid = "MMM_MMMMod";
      
       @Init
       public void load(FMLInitializationEvent event)
       {
        
       }
}