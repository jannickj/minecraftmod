package mmm.esm.monsters;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.EntityList;

@Mod(modid = Monsters.modid, name = "esm", version = "1.5.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class Monsters
{
       public static final String modid = "Monsters";
       
       
       @Init
       public void load(FMLInitializationEvent event)
       {
    	 EntityList.addMapping(ZombieIndi.class,"Zombie",54, 44975, 7969893);
       }
}