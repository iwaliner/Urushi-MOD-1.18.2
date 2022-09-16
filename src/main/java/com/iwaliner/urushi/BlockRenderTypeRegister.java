package com.iwaliner.urushi;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = ModCoreUrushi.ModID ,value = Dist.CLIENT)
public class BlockRenderTypeRegister {
    @SubscribeEvent
    public static void onRenderTypeSetup(FMLClientSetupEvent event) {

        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.mesh_groove.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.connectable_glass.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.connectable_glass_pane.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.metal_framed_glass.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.metal_framed_glass_pane.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.goldfish_bowl.get(), RenderType.cutout());
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
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.rope.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.senbakoki.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.dirt_furnace.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.HotSpringBlock.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.HotSpringStill.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.HotSpringFlow.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ItemAndBlockRegister.fryer.get(), RenderType.translucent());

    }
}
