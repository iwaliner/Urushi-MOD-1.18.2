package com.iwaliner.urushi;

import com.iwaliner.urushi.block.IronIngotBlock;
import com.iwaliner.urushi.util.UrushiUtils;
import com.iwaliner.urushi.world.feature.PlacementFeatures;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mod("urushi")
public class ModCoreUrushi {
    public static final String ModID = "urushi";
    public static File dataDirectory;
    public static File dataInBuildDirectory;
    public static File assetsDirectory;
    public static File assetsInBuildDirectory;

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

    public static boolean isDebug=FMLPaths.GAMEDIR.get().toString().contains("イワライナー(メインドライブ)")&&FMLPaths.GAMEDIR.get().toString().contains("run");
    public static Logger logger = LogManager.getLogger("urushi");
  //  public static final ResourceKey<Biome> SAKURA_FOREST = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModCoreUrushi.ModID,"sakura_forest"));
    public static final CreativeModeTab UrushiTab = new CreativeModeTab("urushi") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemAndBlockRegister.kasuga_lantern.get());
        }
    };

    public static final CreativeModeTab UrushiWoodTab = new CreativeModeTab("urushi_wood") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemAndBlockRegister.big_sakura_sapling.get());
        }
    };
    public static final CreativeModeTab UrushiFoodTab = new CreativeModeTab("urushi_food") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemAndBlockRegister.color_dango.get());
        }
    };
    public ModCoreUrushi() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        /**コンフィグを登録*/
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON,ConfigUrushi.spec,"urushi.toml");

        /**アイテムとブロックを登録*/
        ItemAndBlockRegister.register(modEventBus);

        /**ブロックエンティティ(旧タイルエンティティ)を登録*/
        BlockEntityRegister.register(modEventBus);

        /**エンティティを登録*/
        EntityRegister.register(modEventBus);

        /**流体を登録*/
        FluidRegister.register(modEventBus);

        /**バイオームを登録*/
        BiomeRegister.register(modEventBus);

        /**レシピタイプを登録*/
        RecipeTypeRegister.register(modEventBus);

        /**メニュー(旧コンテナ)を登録*/
        MenuRegister.register(modEventBus);

        /**ディメンションを登録*/
        DimensionRegister.register();


        FeatureRegister.register(modEventBus);

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
            List<Holder<PlacedFeature>> topBase=event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION);
            topBase.add(PlacementFeatures.KAKURIYO_PORTAL);
        }
        if(biome.equals(Biomes.FOREST)){

            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.BAMBOO_PLACE);
        }
        if(biome==Biomes.TAIGA){

            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.CYPRESS_PLACE);
            base.add(PlacementFeatures.CEDAR_PLACE);
        }

        if(type.contains(BiomeDictionary.Type.MOUNTAIN)&&biome!=Biomes.MEADOW&&biome!=Biomes.GROVE){

                List<Holder<PlacedFeature>> lakeBase = event.getGeneration().getFeatures(GenerationStep.Decoration.LAKES);
            lakeBase.add(PlacementFeatures.HOT_SPRING_PLACE);
            List<Holder<PlacedFeature>> topBase=event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION);
            topBase.add(PlacementFeatures.KAKURIYO_PORTAL);
        }

        if(type.contains(BiomeDictionary.Type.SANDY)||type.contains(BiomeDictionary.Type.MESA)){

        }else{
            oreGenBase.add(PlacementFeatures.ORE_IRONSAND_PLACE);
        }
        if(BiomeRegister.KakuriyoList.contains(biome)){
            oreGenBase.add(PlacementFeatures.ORE_JADEITE_PLACE);
            oreGenBase.add(PlacementFeatures.ORE_IRON_PLACE);
            oreGenBase.add(PlacementFeatures.ORE_COPPER_PLACE);
            oreGenBase.add(PlacementFeatures.ORE_GOLD_PLACE);
            List<Holder<PlacedFeature>> undergroundBase=event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION);
            undergroundBase.add(PlacementFeatures.LANTERN_PLANT);
            undergroundBase.add(PlacementFeatures.QUARTZ_CLUSTER);
            undergroundBase.add(PlacementFeatures.YOMI_VINE_PLACE);
        }
        if(biome.equals(BiomeRegister.SakuraForest)){
            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.LYCORIS_FLOWERS);
            base.add(PlacementFeatures.SAKURA_FOREST_SAKURA_PLACE);
            base.add(PlacementFeatures.FALLEN_SAKURA_LEAVES);
        }
        if(biome.equals(BiomeRegister.CedarForest)){
            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.LYCORIS_FLOWERS);
            base.add(PlacementFeatures.CEDAR_FOREST_CEDAR_PLACE);
        }
        if(biome.equals(BiomeRegister.AutumnForest)){
            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.AUTUMN_HILLS_RED_PLACE);
            base.add(PlacementFeatures.AUTUMN_HILLS_ORANGE_PLACE);
            base.add(PlacementFeatures.AUTUMN_HILLS_YELLOW_PLACE);
            base.add(PlacementFeatures.SHIITKE);
            base.add(PlacementFeatures.WALL_SHIITKE_N);
            base.add(PlacementFeatures.WALL_SHIITKE_S);
            base.add(PlacementFeatures.WALL_SHIITKE_E);
            base.add(PlacementFeatures.WALL_SHIITKE_W);
            base.add(PlacementFeatures.FALLEN_RED_LEAVES);
            base.add(PlacementFeatures.FALLEN_ORANGE_LEAVES);
            base.add(PlacementFeatures.FALLEN_YELLOW_LEAVES);

        }
        if(biome.equals(BiomeRegister.EulaliaPlains)){
            List<Holder<PlacedFeature>> base=event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(PlacementFeatures.EULALIA);
            base.add(PlacementFeatures.TALL_EULALIA);
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
    @SubscribeEvent
    public void PlayerSpeedEvent(EntityEvent.EnteringSection event) {
        if(ConfigUrushi.TurnOnSpeedUp.get()) {
            if (event.getEntity() instanceof Player) {
                Player entityPlayer = (Player) event.getEntity();
                entityPlayer.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.116D);
                entityPlayer.getAttributes().save();
            }
        }
    }

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

    /**葉の上に落下したとき落下ダメージを受けないように*/
    @SubscribeEvent
    public void LeavesDamageEvent(LivingHurtEvent event) {
        if(event.getSource()== DamageSource.FALL){
            if(event.getEntityLiving().level.getBlockState(event.getEntityLiving().blockPosition().below()).getBlock() instanceof LeavesBlock){
                event.setCanceled(true);
            }
        }
    }

    /**砂が海岸や海系のバイオーム内で水に接すると塩を含んだ砂になる*/
    @SubscribeEvent
    public void SaltEvent(BlockEvent.NeighborNotifyEvent event) {
        ResourceKey<Biome> biome=ResourceKey.create(Registry.BIOME_REGISTRY,event.getWorld().getBiome(event.getPos()).value().getRegistryName());
        Set<BiomeDictionary.Type> type=BiomeDictionary.getTypes(biome);

        if (type.contains(BiomeDictionary.Type.BEACH)|| type.contains(BiomeDictionary.Type.OCEAN)) {
            if (event.getState().getMaterial() == Material.WATER) {
                for (int i = 0; i < 6; i++) {
                    if (event.getWorld().getBlockState(event.getPos().relative(UrushiUtils.getDirectionFromInt(i))).getBlock() == Blocks.SAND) {
                        event.getWorld().setBlock(event.getPos().relative(UrushiUtils.getDirectionFromInt(i)), ItemAndBlockRegister.salt_and_sand.get().defaultBlockState(), 2);
                        event.getWorld().playSound((Player) null, event.getPos().relative(UrushiUtils.getDirectionFromInt(i)), SoundEvents.SAND_BREAK, SoundSource.BLOCKS, 1.0F, 1F);
                    }
                }

            } else if (event.getState().getBlock() == Blocks.SAND) {
                UrushiUtils.BlockChangeNeighborMaterialSurvey((Level) event.getWorld(),event.getPos(),Material.WATER,ItemAndBlockRegister.salt_and_sand.get().defaultBlockState(), SoundEvents.SAND_BREAK);
            }
        }
    }

    /**油揚げを狐が食べると狐火に*/
    @SubscribeEvent
    public void FoxEvent(LivingEquipmentChangeEvent event) {
        if (event.getEntityLiving() instanceof Fox &&event.getFrom().getItem()== ItemAndBlockRegister.aburaage.get()) {
            event.getEntityLiving().setItemSlot(EquipmentSlot.MAINHAND,new ItemStack(ItemAndBlockRegister.kitsunebiItem.get()));
        }
    }

}
