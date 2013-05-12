package mmm.esm.entity;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.EntityList;
import net.minecraft.client.Minecraft;

@Mod(modid = MonsterMod.modid, name = "MMM Monster Buff mod", version = "1.5.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MonsterMod 
{
       public static final String modid = "Entity";
       
       
       @Init
       public void load(FMLInitializationEvent event)
       {
    	 EntityList.addMapping(Zombie.class,"Zombie",54, 44975, 7969893);
    	 EntityList.addMapping(Skeleton.class,"Skeleton",51, 12698049, 4802889);
    	 EntityList.addMapping(Spider.class,"Spider",52, 3419431, 11013646);
       }
}