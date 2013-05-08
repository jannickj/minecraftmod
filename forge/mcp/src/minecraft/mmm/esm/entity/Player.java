package mmm.esm.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class Player extends EntityPlayer
{
	@Override
	public int getMaxHealth()
	   {
	       return 10;
	   }

	
	public Player(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendChatToPlayer(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canCommandSenderUseCommand(int i, String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChunkCoordinates getPlayerCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}

}
