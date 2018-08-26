package its_meow.betteranimalsplus.registry;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.entity.EntityBear;
import its_meow.betteranimalsplus.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.entity.render.RenderBlackBear;
import its_meow.betteranimalsplus.entity.render.RenderBrownBear;
import its_meow.betteranimalsplus.entity.render.RenderKermodeBear;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class MobRegistry {
	public static int modEntities;
	
	
	
	public static void init(){
		//regCre(Entity.class, "name", 0xFF052E (egg base), 0x14FFFC (egg spot), 25 (percent spawn), 1 (min amt), 3 (max amt), Biomes.PLAINS);
		regMob(EntityBear.class, "Brown Bear", 0x4F2900, 0x8E500E, 8, 1, 1, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.MUTATED_ROOFED_FOREST, Biomes.ROOFED_FOREST);
		regMob(EntityBearNeutral.class, "Black Bear", 0x000000, 0x333333, 6, 1, 1, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.MUTATED_ROOFED_FOREST, Biomes.ROOFED_FOREST);
		regMob(EntityBearNeutralKermode.class, "Kermode Bear", 0xe8e8e8, 0xf7dabe, 2, 1, 1, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.MUTATED_ROOFED_FOREST, Biomes.ROOFED_FOREST);
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		registerRender(EntityBear.class, RenderBrownBear.FACTORY);
		registerRender(EntityBearNeutral.class, RenderBlackBear.FACTORY);
		registerRender(EntityBearNeutralKermode.class, RenderKermodeBear.FACTORY);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModel(Class EntityClass, IRenderFactory FACTORY){
		registerRender(EntityClass, FACTORY);
	}
	
	
	//#################################################################################
	
	public static void regCre(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob, int min, int max, Biome... biomes){
		register(EntityClass, entityNameIn, solidColorIn, spotColorIn);
		registerCreatureSpawn(EntityClass, prob, min, max, biomes);
		//initModel(EntityClass, FACTORY);
	}
	
	public static void regMob(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob, int min, int max, Biome... biomes){
		register(EntityClass, entityNameIn, solidColorIn, spotColorIn);
		registerMobSpawn(EntityClass, prob, min, max, biomes);
		//initModel(EntityClass, FACTORY);
	}
	
	public static void register(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn){
		EntityRegistry.registerModEntity(new ResourceLocation(Ref.MOD_ID + ":" + entityNameIn + "loc"), EntityClass, entityNameIn, ++modEntities, BetterAnimalsPlusMod.mod, 64, 1, true, solidColorIn, spotColorIn);
    }
	
	public static void registerCreatureSpawn(Class EntityClass, int prob, int min, int max, Biome... biomes) {
		EntityRegistry.addSpawn(EntityClass, prob, min, max, EnumCreatureType.CREATURE, biomes);
	}
	
	public static void registerMobSpawn(Class EntityClass, int prob, int min, int max, Biome... biomes) {
		EntityRegistry.addSpawn(EntityClass, prob, min, max, EnumCreatureType.MONSTER, biomes);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRender(Class EntityClass, IRenderFactory RenderFactory){
		RenderingRegistry.registerEntityRenderingHandler(EntityClass, RenderFactory);
	}
	
	//####################################################################################
	

	
	
}