package mmm.hardcore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraft.entity.monster.EntityZombie;

@Mod(modid = Hardcore.modid, name = "Hardcore", version = "1.5.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Hardcore
{
       public static final String modid = "Hardcore";
       public static int ZombieHP = 100;     
       EntityZombie x;
       
       public void ZombieHP ()
       {
    	  
    	  
       }
       
       @Init
       public void load(FMLInitializationEvent event)
       {
    	 
    	  
       }
}