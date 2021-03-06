package com.tenjava.entries._22vortex22.t3.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

import com.tenjava.entries._22vortex22.t3.TenJava;

public class CraterCreator implements Listener
{
	public TenJava plugin;
	public CraterCreator(TenJava instance)
	{	
		plugin = instance;
	}
	
	/**
	 * 
	 * This class creates craters when explosions go off.
	 */
	
	@EventHandler
    public void onEntityExplode(EntityExplodeEvent e){
        e.setCancelled(true);
        for(Block block : e.blockList())
        {
            blockfly(block);
        }
    }

    @SuppressWarnings("deprecation")
	public void blockfly(Block block)
    {
        if(block == null || block.getType().equals(Material.TNT)) return;
        
        FallingBlock fb = block.getWorld().spawnFallingBlock(block.getLocation(), block.getType(), block.getData());
        block.setType(Material.AIR);
        
        float x = (float) -1.1 + (float) (Math.random() * ((1.1 - -1.1) + 1));
        double y = .8;
        float z = (float) -0.2 + (float)(Math.random() * ((0.2 - -0.2) + 1));
        
        fb.setVelocity(new Vector(x, y, z));
    }
	
}
