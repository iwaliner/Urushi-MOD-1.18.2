package com.iwaliner.urushi;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = ModCoreUrushi.ModID ,value = Dist.CLIENT)
public class BlockRenderTypeRegister {
    @SubscribeEvent
    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
        BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
        ItemColors itemcolors = Minecraft.getInstance().getItemColors();
        blockcolors.register((state, reader, pos, i) -> BiomeColors.getAverageGrassColor(reader, pos),
                ItemAndBlockRegister.grass_block_with_fallen_red_leaves.get(),
                ItemAndBlockRegister.grass_block_with_fallen_orange_leaves.get(),
                ItemAndBlockRegister.grass_block_with_fallen_yellow_leaves.get(),
                ItemAndBlockRegister.grass_block_with_fallen_japanese_apricot_leaves.get(),
                ItemAndBlockRegister.grass_block_with_fallen_sakura_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_red_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_orange_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_yellow_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_japanese_apricot_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_sakura_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block.get());
        itemcolors.register((stack, i) -> {
                    return 12300080;
                },
                ItemAndBlockRegister.grass_block_with_fallen_red_leaves.get(),
                ItemAndBlockRegister.grass_block_with_fallen_orange_leaves.get(),
                ItemAndBlockRegister.grass_block_with_fallen_yellow_leaves.get(),
                ItemAndBlockRegister.grass_block_with_fallen_japanese_apricot_leaves.get(),
                ItemAndBlockRegister.grass_block_with_fallen_sakura_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_red_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_orange_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_yellow_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_japanese_apricot_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_sakura_leaves.get(),
                ItemAndBlockRegister.kakuriyo_grass_block.get());
        itemcolors.register((stack, i) -> {
                    return 13886461;
                },
                ItemAndBlockRegister.onsen_egg.get());

        if(ConfigUrushi.ShojisAreTranslucent.get()){
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.oak_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.spruce_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.birch_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.jungle_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.acacia_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.dark_oak_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.japanese_apricot_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.sakura_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.cypress_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.red_urushi_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.black_urushi_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.oak_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.spruce_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.birch_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.jungle_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.acacia_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.dark_oak_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.japanese_apricot_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.sakura_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.cypress_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.red_urushi_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.black_urushi_shoji_pane.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.japanese_cedar_shoji.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.japanese_cedar_shoji_pane.get(), RenderType.translucent());
    }


        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.mesh_groove.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.connectable_glass.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.connectable_glass_pane.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.metal_framed_glass.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.metal_framed_glass_pane.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.goldfish_bowl.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.japanese_apricot_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.japanese_apricot_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.glowing_japanese_apricot_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.glowing_japanese_apricot_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.sakura_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.sakura_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.big_sakura_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.glowing_sakura_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.glowing_big_sakura_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.glowing_sakura_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.cypress_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.cypress_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.andon.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ariake_andon.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.rice_crop.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.japanese_timber_bamboo.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.azuki_crop.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.soy_crop.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.sliding_glass_door.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.deep_blue_noren.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.red_noren.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.cyan_noren.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.magenta_noren.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.men_onsen_noren.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.women_onsen_noren.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.sushi_noren.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_5.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_6.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_8.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_9.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_10.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_11.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_12.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_13.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakejiku_14.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.lacquer_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.lacquer_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.lycoris.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.senbakoki.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.dirt_furnace.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.HotSpringBlock.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.HotSpringStill.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.HotSpringFlow.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.fryer.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.yomi_vines.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.yomi_vines_plant.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.quartz_cluster.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.eulalia.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.double_eulalia.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.shiitake.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.wall_shiitake.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.red_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.red_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.orange_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.orange_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.yellow_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.yellow_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.japanese_cedar_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.fallen_red_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.fallen_orange_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.fallen_yellow_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.fallen_sakura_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.fallen_japanese_apricot_leaves.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.grass_block_with_fallen_red_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.grass_block_with_fallen_orange_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.grass_block_with_fallen_yellow_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.grass_block_with_fallen_japanese_apricot_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.grass_block_with_fallen_sakura_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.lantern_plant.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.stone_trapdoor.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakuriyo_portal.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ghost_red_kakuriyo_portal_frame.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ghost_kakuriyo_portal_core.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ghost_black_kakuriyo_portal_frame.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.yomi_stone_trapdoor.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ghost_dirt.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ghost_stone.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.lantern_plant_torch.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.wall_lantern_plant_torch.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakuriyo_grass_block.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_red_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_orange_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_yellow_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_japanese_apricot_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.kakuriyo_grass_block_with_fallen_sakura_leaves.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.petrified_log_with_fire_amber.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.petrified_log_with_wood_amber.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.petrified_log_with_earth_amber.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.petrified_log_with_metal_amber.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.petrified_log_with_water_amber.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.sanbo_tier1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.sanbo_tier2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.sanbo_tier3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.wind_bell.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.shichirin.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.wood_element_sacred_rock.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.fire_element_sacred_rock.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.earth_element_sacred_rock.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.metal_element_sacred_rock.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.water_element_sacred_rock.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.fire_element_tank_tier1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.earth_element_tank_tier1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.metal_element_tank_tier1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.water_element_tank_tier1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.wood_element_tank_tier1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ghost_plaster.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ghost_sand_coast.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ghost_wattle_and_daub.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ghost_concrete.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.lantern_plant_block.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.ajisai.get(), RenderType.cutout());




    }
}
