package com.iwaliner.urushi;

import com.iwaliner.urushi.block.IronIngotBlock;
import com.iwaliner.urushi.world.tree.PlacementFeatures;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

@Mod("urushi")
public class ModCoreUrushi {
    public static final String ModID = "urushi";
    public static File dataDirectory;
    public static File dataInBuildDirectory;
    public static int password=88659;
    public static List<String> pickaxeList=new ArrayList<>();
    public static List<String> axeList=new ArrayList<>();
    public static List<String> shovelList=new ArrayList<>();
    public static List<String> hoeList=new ArrayList<>();
    public static List<String> woodenToolList=new ArrayList<>();
    public static List<String> stoneToolList=new ArrayList<>();
    public static List<String> ironToolList=new ArrayList<>();
    public static List<String> goldenToolList=new ArrayList<>();
    public static List<String> diamondToolList=new ArrayList<>();
    public static List<String> netheriteToolList=new ArrayList<>();
    public static Logger logger = LogManager.getLogger("urushi");

    public static final CreativeModeTab UrushiTab = new CreativeModeTab("urushi") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemAndBlockRegister.big_sakura_sapling.get());
        }
    };
    public ModCoreUrushi() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
       ItemAndBlockRegister.register(modEventBus);
       BlockEntityRegister.register(modEventBus);
       MinecraftForge.EVENT_BUS.register(this);

    }
    /**構造物を自然生成*/
    @SubscribeEvent
    public void FeatureGenEvent(BiomeLoadingEvent event) {
        ResourceKey<Biome> biome=ResourceKey.create(Registry.BIOME_REGISTRY,event.getName());
        Set<BiomeDictionary.Type> type=BiomeDictionary.getTypes(biome);
        List<Holder<PlacedFeature>> oreGenBase=event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        if(biome.equals(Biomes.FOREST)){
            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.APRICOT_PLACE);
        }
        if(biome.equals(Biomes.FOREST)){

            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.SAKURA_PLACE);
        }
        if(type.contains(BiomeDictionary.Type.FOREST)){

            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.LACQUER_PLACE);
        }
        if(biome.equals(Biomes.FOREST)){

            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.BAMBOO_PLACE);
        }
        if(biome==Biomes.TAIGA){

            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.CYPRESS_PLACE);
        }

        if(type.contains(BiomeDictionary.Type.SANDY)||type.contains(BiomeDictionary.Type.MESA)){

        }else{
            oreGenBase.add(PlacementFeatures.ORE_IRONSAND_PLACE);
        }

    }

    /**燃料を登録*/
    @SubscribeEvent
    public void FuelEvent(FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().getItem()==ItemAndBlockRegister.bamboo_charcoal.get()) {
            event.setBurnTime(1600);
        }else if(event.getItemStack().getItem()==ItemAndBlockRegister.japanese_apricot_bark.get()) {
            event.setBurnTime(200);
        }else if(event.getItemStack().getItem()==ItemAndBlockRegister.sakura_bark.get()) {
            event.setBurnTime(200);
        }else if(event.getItemStack().getItem()==ItemAndBlockRegister.cypress_bark.get()) {
            event.setBurnTime(200);
        }else if(event.getItemStack().getItem()== Item.byBlock(ItemAndBlockRegister.bamboo_charcoal_block.get())) {
            event.setBurnTime(16000);
        }
    }

    /**プレイヤーの移動速度を上昇*/
  /*  @SubscribeEvent
    public void PlayerSpeedEvent(EntityEvent.EnteringChunk event) {
        if(ConfigUrushi.TurnOnSpeedUp.get()) {
            if (event.getEntity() instanceof PlayerEntity) {
                PlayerEntity entityPlayer = (PlayerEntity) event.getEntity();
                entityPlayer.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.116D);
                entityPlayer.getAttributes().save();
            }
        }
    }*/
    /**草を壊して種が出るように*/
    @SubscribeEvent
    public void GrassDropEvent(BlockEvent.BreakEvent event) {
        if (!event.getPlayer().isCreative() && (event.getWorld().getBlockState(event.getPos()).getBlock()==Blocks.FERN || event.getWorld().getBlockState(event.getPos()).getBlock()==Blocks.TALL_GRASS || event.getWorld().getBlockState(event.getPos()).getBlock()==Blocks.GRASS) ) {
            if (( event.getWorld()).getRandom().nextFloat() < 0.075F) {
                ItemEntity entity = new ItemEntity((Level) event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ItemAndBlockRegister.rice_crop.get()));
                event.getWorld().addFreshEntity(entity);
            }
            else if (( event.getWorld()).getRandom().nextFloat() < 0.075F) {
                ItemEntity entity = new ItemEntity((Level) event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ItemAndBlockRegister.soy_crop.get()));
                event.getWorld().addFreshEntity(entity);
            } else if (( event.getWorld()).getRandom().nextFloat() < 0.075F) {
                ItemEntity entity = new ItemEntity((Level) event.getWorld(), (double) event.getPos().getX(), (double) event.getPos().getY(), (double) event.getPos().getZ(), new ItemStack(ItemAndBlockRegister.azuki_crop.get()));
                event.getWorld().addFreshEntity(entity);
            }
        }
    }

    /**玉鋼作るときに右クリックおしっぱだとブロックがドロップして壊れる*/
    @SubscribeEvent
    public void HammerCancelEvent(PlayerInteractEvent.RightClickBlock event) {
        if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof IronIngotBlock){
            {
                if(event.getEntity() instanceof Player) {
                    if( event.getPlayer().getCooldowns().isOnCooldown(ItemAndBlockRegister.hammer.get())) {
                        event.getWorld().destroyBlock(event.getPos(),true);
                        event.setCanceled(true);
                    }
                }
            }
        }
    }
}
