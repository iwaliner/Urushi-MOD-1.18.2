package com.iwaliner.urushi;

import com.iwaliner.urushi.entiity.CushionEntity;
import com.iwaliner.urushi.entiity.GhostEntity;
import com.iwaliner.urushi.entiity.KitsunebiEntity;
import com.iwaliner.urushi.entiity.RedOniEntity;
import com.iwaliner.urushi.entiity.food.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegister {
    public static final DeferredRegister<EntityType<?>> Entities = DeferredRegister.create(ForgeRegistries.ENTITIES, ModCoreUrushi.ModID);
    public static final RegistryObject<EntityType<RiceFoodEntity>> RiceFoodEntity=Entities.register("rice_food", () -> EntityType.Builder.<RiceFoodEntity>of(RiceFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"rice_food").toString()));
    public static final RegistryObject<EntityType<com.iwaliner.urushi.entiity.food.TKGFoodEntity>> TKGFoodEntity=Entities.register("tkg_food", () -> EntityType.Builder.<TKGFoodEntity>of(TKGFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"tkg_food").toString()));
    public static final RegistryObject<EntityType<SekihanFoodEntity>> SekihanFoodEntity=Entities.register("sekihan_food", () -> EntityType.Builder.<SekihanFoodEntity>of(SekihanFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"sekihan_food").toString()));
    public static final RegistryObject<EntityType<GyudonFoodEntity>> GyudonFoodEntity=Entities.register("gyudon_food", () -> EntityType.Builder.<GyudonFoodEntity>of(GyudonFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"gyudon_food").toString()));
    public static final RegistryObject<EntityType<ButadonFoodEntity>> ButadonFoodEntity=Entities.register("butadon_food", () -> EntityType.Builder.<ButadonFoodEntity>of(ButadonFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"butadon_food").toString()));
    public static final RegistryObject<EntityType<KitsuneUdonFoodEntity>> KitsuneUdonFoodEntity=Entities.register("kitsune_udon_food", () -> EntityType.Builder.<KitsuneUdonFoodEntity>of(KitsuneUdonFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"kitsune_udon_food").toString()));
    public static final RegistryObject<EntityType<KaraageFoodEntity>> KaraageFoodEntity=Entities.register("karaage_food", () -> EntityType.Builder.<KaraageFoodEntity>of(KaraageFoodEntity::new, MobCategory.MISC).sized(0.6F, 0.6F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"karaage_food").toString()));
    public static final RegistryObject<EntityType<TofuFoodEntity>> TofuFoodEntity=Entities.register("tofu_food", () -> EntityType.Builder.<TofuFoodEntity>of(TofuFoodEntity::new, MobCategory.MISC).sized(0.3F, 0.3F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"tofu_food").toString()));
    public static final RegistryObject<EntityType<RiceCakeFoodEntity>> RiceCakeFoodEntity=Entities.register("rice_cake_food", () -> EntityType.Builder.<RiceCakeFoodEntity>of(RiceCakeFoodEntity::new, MobCategory.MISC).sized(0.2F, 0.15F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"rice_cake_food").toString()));
    public static final RegistryObject<EntityType<RoastedRiceCakeFoodEntity>> RoastedRiceCakeFoodEntity=Entities.register("roasted_rice_cake_food", () -> EntityType.Builder.<RoastedRiceCakeFoodEntity>of(RoastedRiceCakeFoodEntity::new, MobCategory.MISC).sized(0.2F, 0.2F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"roasted_rice_cake_food").toString()));
    public static final RegistryObject<EntityType<AburaageFoodEntity>> AburaageFoodEntity=Entities.register("abura_age_food", () -> EntityType.Builder.<AburaageFoodEntity>of(AburaageFoodEntity::new, MobCategory.MISC).sized(0.3F, 0.3F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"abura_age_food").toString()));
    public static final RegistryObject<EntityType<KusaDangoFoodEntity>> KusaDangoFoodEntity=Entities.register("kusa_dango_food", () -> EntityType.Builder.<KusaDangoFoodEntity>of(KusaDangoFoodEntity::new, MobCategory.MISC).sized(0.25F, 0.7F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"kusa_dango_food").toString()));
    public static final RegistryObject<EntityType<ColorDangoFoodEntity>> ColorDangoFoodEntity=Entities.register("color_dango_food", () -> EntityType.Builder.<ColorDangoFoodEntity>of(ColorDangoFoodEntity::new, MobCategory.MISC).sized(0.25F, 0.7F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"color_dango_food").toString()));
    public static final RegistryObject<EntityType<MitarashiDangoFoodEntity>> MitarashiDangoFoodEntity=Entities.register("mitarashi_dango_food", () -> EntityType.Builder.<MitarashiDangoFoodEntity>of(MitarashiDangoFoodEntity::new, MobCategory.MISC).sized(0.25F, 0.7F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"mitarashi_dango_food").toString()));
    public static final RegistryObject<EntityType<KitsunebiEntity>> KitsunebiEntity=Entities.register("kitsunebi", () -> EntityType.Builder.<KitsunebiEntity>of(KitsunebiEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ModCoreUrushi.ModID,"kitsunebi").toString()));
    public static final RegistryObject<EntityType<GhostEntity>> Ghost=Entities.register("ghost", () -> EntityType.Builder.<GhostEntity>of(GhostEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"ghost").toString()));
    public static final RegistryObject<EntityType<CushionEntity>> Cushion=Entities.register("cushion", () -> EntityType.Builder.<CushionEntity>of(CushionEntity::new, MobCategory.MISC).sized(0.7F, 0.2F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"butadon_food").toString()));
   // public static final RegistryObject<EntityType<RedOniEntity>> RedOni=Entities.register("red_oni", () -> EntityType.Builder.<RedOniEntity>of(RedOniEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"red_oni").toString()));

    public static void register(IEventBus eventBus) {
        Entities.register(eventBus);
    }

}
