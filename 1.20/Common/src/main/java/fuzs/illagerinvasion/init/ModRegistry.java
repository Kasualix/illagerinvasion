package fuzs.illagerinvasion.init;

import fuzs.illagerinvasion.IllagerInvasion;
import fuzs.illagerinvasion.core.CommonAbstractions;
import fuzs.illagerinvasion.world.entity.monster.*;
import fuzs.illagerinvasion.world.entity.projectile.FlyingMagma;
import fuzs.illagerinvasion.world.entity.projectile.Hatchet;
import fuzs.illagerinvasion.world.entity.projectile.SkullBolt;
import fuzs.illagerinvasion.world.inventory.ImbuingMenu;
import fuzs.illagerinvasion.world.item.*;
import fuzs.illagerinvasion.world.level.block.ImbuingTableBlock;
import fuzs.illagerinvasion.world.level.block.MagicFireBlock;
import fuzs.puzzleslib.api.init.v2.RegistryManager;
import fuzs.puzzleslib.api.init.v2.RegistryReference;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public class ModRegistry {
    static final RegistryManager REGISTRY = RegistryManager.instant(IllagerInvasion.MOD_ID);
    public static final RegistryReference<Block> IMBUING_TABLE_BLOCK = REGISTRY.registerBlock("imbuing_table", () -> new ImbuingTableBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryReference<Block> MAGIC_FIRE_BLOCK = REGISTRY.registerBlock("magic_fire", () -> new MagicFireBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_FIRE).mapColor(MapColor.COLOR_PURPLE).randomTicks()));
    public static final RegistryReference<Item> IMBUIING_TABLE_ITEM = REGISTRY.registerBlockItem(ModRegistry.IMBUING_TABLE_BLOCK);
    public static final RegistryReference<Item> UNUSUAL_DUST_ITEM = REGISTRY.registerItem("unusual_dust", () -> new Item(new Item.Properties()));
    public static final RegistryReference<Item> MAGICAL_FIRE_CHARGE_ITEM = REGISTRY.registerItem("magical_fire_charge", () -> new MagicalFireChargeItem(new Item.Properties()));
    public static final RegistryReference<Item> ILLUSIONARY_DUST_ITEM = REGISTRY.registerItem("illusionary_dust", () -> new IllusionaryDustItem(new Item.Properties()));
    public static final RegistryReference<Item> LOST_CANDLE_ITEM = REGISTRY.registerItem("lost_candle", () -> new LostCandleItem(new Item.Properties()));
    public static final RegistryReference<Item> HORN_OF_SIGHT_ITEM = REGISTRY.registerItem("horn_of_sight", () -> new HornOfSightItem(new Item.Properties().stacksTo(1), ModRegistry.HORN_OF_SIGHT_INSTRUMENT_TAG));
    public static final RegistryReference<Item> HALLOWED_GEM_ITEM = REGISTRY.registerItem("hallowed_gem", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryReference<Item> PRIMAL_ESSENCE_ITEM = REGISTRY.registerItem("primal_essence", () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryReference<Item> PLATINUM_CHUNK_ITEM = REGISTRY.registerItem("platinum_chunk", () -> new Item(new Item.Properties()));
    public static final RegistryReference<Item> PLATINUM_SHEET_ITEM = REGISTRY.registerItem("platinum_sheet", () -> new Item(new Item.Properties()));
    public static final RegistryReference<Item> PLATINUM_INFUSED_HATCHET_ITEM = REGISTRY.registerItem("platinum_infused_hatchet", () -> new HatchetItem(new Item.Properties().durability(327)));
    public static final RegistryReference<EntityType<Provoker>> PROVOKER_ENTITY_TYPE = REGISTRY.registerEntityType("provoker", () -> EntityType.Builder.of(Provoker::new, MobCategory.MONSTER).sized(0.5F, 1.92F));
    public static final RegistryReference<EntityType<Invoker>> INVOKER_ENTITY_TYPE = REGISTRY.registerEntityType("invoker", () -> EntityType.Builder.of(Invoker::new, MobCategory.MONSTER).sized(0.5f, 1.92f).fireImmune());
    public static final RegistryReference<EntityType<Necromancer>> NECROMANCER_ENTITY_TYPE = REGISTRY.registerEntityType("necromancer", () -> EntityType.Builder.of(Necromancer::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final RegistryReference<EntityType<Basher>> BASHER_ENTITY_TYPE = REGISTRY.registerEntityType("basher", () -> EntityType.Builder.of(Basher::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final RegistryReference<EntityType<Sorcerer>> SORCERER_ENTITY_TYPE = REGISTRY.registerEntityType("sorcerer", () -> EntityType.Builder.of(Sorcerer::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final RegistryReference<EntityType<Archivist>> ARCHIVIST_ENTITY_TYPE = REGISTRY.registerEntityType("archivist", () -> EntityType.Builder.of(Archivist::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final RegistryReference<EntityType<Inquisitor>> INQUISITOR_ENTITY_TYPE = REGISTRY.registerEntityType("inquisitor", () -> EntityType.Builder.of(Inquisitor::new, MobCategory.MONSTER).sized(0.5f, 2.48f));
    public static final RegistryReference<EntityType<Marauder>> MARAUDER_ENTITY_TYPE = REGISTRY.registerEntityType("marauder", () -> EntityType.Builder.of(Marauder::new, MobCategory.MONSTER).sized(0.5f, 1.92f).canSpawnFarFromPlayer());
    public static final RegistryReference<EntityType<Alchemist>> ALCHEMIST_ENTITY_TYPE = REGISTRY.registerEntityType("alchemist", () -> EntityType.Builder.of(Alchemist::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final RegistryReference<EntityType<Firecaller>> FIRECALLER_ENTITY_TYPE = REGISTRY.registerEntityType("firecaller", () -> EntityType.Builder.of(Firecaller::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final RegistryReference<EntityType<Surrendered>> SURRENDERED_ENTITY_TYPE = REGISTRY.registerEntityType("surrendered", () -> EntityType.Builder.of(Surrendered::new, MobCategory.MONSTER).fireImmune().sized(0.5f, 1.42f));
    public static final RegistryReference<EntityType<SkullBolt>> SKULL_BOLT_ENTITY_TYPE = REGISTRY.placeholder(Registries.ENTITY_TYPE, "skull_bolt");
    public static final RegistryReference<EntityType<Hatchet>> HATCHET_ENTITY_TYPE = REGISTRY.placeholder(Registries.ENTITY_TYPE, "hatchet");
    public static final RegistryReference<EntityType<InvokerFangs>> INVOKER_FANGS_ENTITY_TYPE = REGISTRY.registerEntityType("invoker_fangs", () -> EntityType.Builder.<InvokerFangs>of(InvokerFangs::new, MobCategory.MISC).sized(0.65f, 1.05f));
    public static final RegistryReference<EntityType<FlyingMagma>> FLYING_MAGMA_ENTITY_TYPE = REGISTRY.registerEntityType("flying_magma", () -> EntityType.Builder.<FlyingMagma>of(FlyingMagma::new, MobCategory.MISC).sized(0.95f, 1.05f));
    public static final RegistryReference<Item> PROVOKER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(PROVOKER_ENTITY_TYPE, 9541270, 9399876);
    public static final RegistryReference<Item> BASHER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(BASHER_ENTITY_TYPE, 9541270, 5985087);
    public static final RegistryReference<Item> SORCERER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(SORCERER_ENTITY_TYPE, 9541270, 10899592);
    public static final RegistryReference<Item> ARCHIVIST_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(ARCHIVIST_ENTITY_TYPE, 9541270, 13251893);
    public static final RegistryReference<Item> INQUISITOR_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(INQUISITOR_ENTITY_TYPE, 9541270, 4934471);
    public static final RegistryReference<Item> MARAUDER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(MARAUDER_ENTITY_TYPE, 9541270, 5441030);
    public static final RegistryReference<Item> INVOKER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(INVOKER_ENTITY_TYPE, 9541270, 0xCEC987);
    public static final RegistryReference<Item> ALCHEMIST_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(ALCHEMIST_ENTITY_TYPE, 9541270, 7550099);
    public static final RegistryReference<Item> FIRECALLER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(FIRECALLER_ENTITY_TYPE, 9541270, 14185784);
    public static final RegistryReference<Item> NECROMANCER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(NECROMANCER_ENTITY_TYPE, 9541270, 9585210);
    public static final RegistryReference<Item> SURRENDERED_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(SURRENDERED_ENTITY_TYPE, 11260369, 11858160);
    public static final RegistryReference<Item> ILLUSIONER_SPAWN_EGG_ITEM = REGISTRY.registerItem("illusioner_spawn_egg", () -> new SpawnEggItem(EntityType.ILLUSIONER, 0x135893, 9541270, new Item.Properties()));
    public static final RegistryReference<Potion> BERSERKING_POTION = REGISTRY.registerPotion("berserking", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1)));
    public static final RegistryReference<Potion> LONG_BERSERKING_POTION = REGISTRY.registerPotion("long_berserking", () -> new Potion("berserking", new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0)));
    public static final RegistryReference<Potion> STRONG_BERSERKING_POTION = REGISTRY.registerPotion("strong_berserking", () -> new Potion("berserking", new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 2), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 2)));
    public static final RegistryReference<MenuType<ImbuingMenu>> IMBUING_MENU_TYPE = REGISTRY.registerMenuType("imbuing", () -> ImbuingMenu::new);
    public static final RegistryReference<SimpleParticleType> MAGIC_FLAME_PARTICLE_TYPE = REGISTRY.register(Registries.PARTICLE_TYPE, "magic_flame", () -> new SimpleParticleType(false));
    public static final RegistryReference<SimpleParticleType> NECROMANCER_BUFF_PARTICLE_TYPE = REGISTRY.register(Registries.PARTICLE_TYPE, "necromancer_buff", () -> new SimpleParticleType(false));
    public static final RegistryReference<SoundEvent> HORN_OF_SIGHT_SOUND_EVENT = REGISTRY.registerSoundEvent("item.horn_of_sight.blow");
    public static final RegistryReference<SoundEvent> LOST_CANDLE_DIAMOND_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.diamond");
    public static final RegistryReference<SoundEvent> LOST_CANDLE_IRON_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.iron");
    public static final RegistryReference<SoundEvent> LOST_CANDLE_COAL_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.coal");
    public static final RegistryReference<SoundEvent> LOST_CANDLE_COPPER_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.copper");
    public static final RegistryReference<SoundEvent> LOST_CANDLE_GOLD_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.gold");
    public static final RegistryReference<SoundEvent> SURRENDERED_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.surrendered.ambient");
    public static final RegistryReference<SoundEvent> SURRENDERED_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.surrendered.hurt");
    public static final RegistryReference<SoundEvent> SURRENDERED_CHARGE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.surrendered.charge");
    public static final RegistryReference<SoundEvent> SURRENDERED_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.surrendered.death");
    public static final RegistryReference<SoundEvent> NECROMANCER_SUMMON_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.necromancer.summon");
    public static final RegistryReference<SoundEvent> ARCHIVIST_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.archivist.ambient");
    public static final RegistryReference<SoundEvent> ARCHIVIST_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.archivist.hurt");
    public static final RegistryReference<SoundEvent> ARCHIVIST_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.archivist.death");
    public static final RegistryReference<SoundEvent> INVOKER_FANGS_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.fangs");
    public static final RegistryReference<SoundEvent> INVOKER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.hurt");
    public static final RegistryReference<SoundEvent> INVOKER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.death");
    public static final RegistryReference<SoundEvent> INVOKER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.ambient");
    public static final RegistryReference<SoundEvent> INVOKER_COMPLETE_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.completecast");
    public static final RegistryReference<SoundEvent> INVOKER_TELEPORT_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.teleport_cast");
    public static final RegistryReference<SoundEvent> INVOKER_FANGS_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.fangs_cast");
    public static final RegistryReference<SoundEvent> INVOKER_BIG_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.big_cast");
    public static final RegistryReference<SoundEvent> INVOKER_SUMMON_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.summon_cast");
    public static final RegistryReference<SoundEvent> INVOKER_SHIELD_BREAK_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.shield_break");
    public static final RegistryReference<SoundEvent> INVOKER_SHIELD_CREATE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.shield_create");
    public static final RegistryReference<SoundEvent> ILLAGER_BRUTE_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.illager_brute.ambient");
    public static final RegistryReference<SoundEvent> ILLAGER_BRUTE_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.illager_brute.hurt");
    public static final RegistryReference<SoundEvent> ILLAGER_BRUTE_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.illager_brute.death");
    public static final RegistryReference<SoundEvent> PROVOKER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.provoker.idle");
    public static final RegistryReference<SoundEvent> PROVOKER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.provoker.hurt");
    public static final RegistryReference<SoundEvent> PROVOKER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.provoker.death");
    public static final RegistryReference<SoundEvent> PROVOKER_CELEBRATE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.provoker.celebrate");
    public static final RegistryReference<SoundEvent> BASHER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.basher.idle");
    public static final RegistryReference<SoundEvent> BASHER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.basher.hurt");
    public static final RegistryReference<SoundEvent> BASHER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.basher.death");
    public static final RegistryReference<SoundEvent> BASHER_CELEBRATE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.basher.celebrate");
    public static final RegistryReference<SoundEvent> FIRECALLER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.firecaller.idle");
    public static final RegistryReference<SoundEvent> FIRECALLER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.firecaller.hurt");
    public static final RegistryReference<SoundEvent> FIRECALLER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.firecaller.death");
    public static final RegistryReference<SoundEvent> FIRECALLER_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.firecaller.cast");
    public static final RegistryReference<SoundEvent> SORCERER_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.cast");
    public static final RegistryReference<SoundEvent> SORCERER_COMPLETE_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.complete_cast");
    public static final RegistryReference<SoundEvent> SORCERER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.hurt");
    public static final RegistryReference<SoundEvent> SORCERER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.death");
    public static final RegistryReference<SoundEvent> SORCERER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.idle");
    public static final RegistryReference<SoundEvent> SORCERER_CELEBRATE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.celebrate");
    public static final RegistryReference<Instrument> REVEAL_INSTRUMENT = REGISTRY.register(Registries.INSTRUMENT, "reveal", () -> new Instrument(ModRegistry.HORN_OF_SIGHT_SOUND_EVENT.holder(), 120, 48.0F));

    public static final TagKey<Enchantment> IMBUING_ENCHANTMENT_TAG = REGISTRY.registerEnchantmentTag("imbuing");
    public static final TagKey<Instrument> HORN_OF_SIGHT_INSTRUMENT_TAG = REGISTRY.registerTag(Registries.INSTRUMENT, "horn_of_sight");
    public static final TagKey<Biome> HAS_FIRECALLER_HUT_BIOME_TAG = REGISTRY.registerTag(Registries.BIOME, "has_structure/firecaller_hut");
    public static final TagKey<Biome> HAS_ILLAGER_FORT_BIOME_TAG = REGISTRY.registerTag(Registries.BIOME, "has_structure/illager_fort");
    public static final TagKey<Biome> HAS_ILLUSIONER_TOWER_BIOME_TAG = REGISTRY.registerTag(Registries.BIOME, "has_structure/illusioner_tower");
    public static final TagKey<Biome> HAS_SORCERER_HUT_BIOME_TAG = REGISTRY.registerTag(Registries.BIOME, "has_structure/sorcerer_hut");
    public static final TagKey<Biome> HAS_LABYRINTH_BIOME_TAG = REGISTRY.registerTag(Registries.BIOME, "has_structure/labyrinth");

    public static final ResourceKey<TrimMaterial> PLATINUM_TRIM_MATERIAL = REGISTRY.registerResourceKey(Registries.TRIM_MATERIAL, "platinum");

    public static final ResourceLocation ILLAGER_FORT_TOWER_LOOT_TABLE = REGISTRY.makeKey("chests/illager_fort_tower");
    public static final ResourceLocation ILLAGER_FORT_GROUND_LOOT_TABLE = REGISTRY.makeKey("chests/illager_fort_ground");
    public static final ResourceLocation ILLUSIONER_TOWER_ENTRANCE_LOOT_TABLE = REGISTRY.makeKey("chests/illusioner_tower_entrance");
    public static final ResourceLocation ILLUSIONER_TOWER_STAIRS_LOOT_TABLE = REGISTRY.makeKey("chests/illusioner_tower_stairs");
    public static final ResourceLocation LABYRINTH_LOOT_TABLE = REGISTRY.makeKey("chests/labyrinth");
    public static final ResourceLocation LABYRINTH_MAP_LOOT_TABLE = REGISTRY.makeKey("chests/labyrinth_map");
    public static final ResourceLocation SORCERER_HUT_LOOT_TABLE = REGISTRY.makeKey("chests/sorcerer_hut");
    public static final ResourceLocation ILLUSIONER_INJECT_LOOT_TABLE = REGISTRY.makeKey("entities/inject/illusioner");
    public static final ResourceLocation PILLAGER_INJECT_LOOT_TABLE = REGISTRY.makeKey("entities/inject/pillager");
    public static final ResourceLocation RAVAGER_INJECT_LOOT_TABLE = REGISTRY.makeKey("entities/inject/ravager");

    public static final Object ENCHANT_ILLAGER_SPELL;
    public static final Object CONJURE_FLAMES_ILLAGER_SPELL;
    public static final Object CONJURE_TELEPORT_ILLAGER_SPELL;
    public static final Object NECRO_RAISE_ILLAGER_SPELL;
    public static final Object CONJURE_SKULL_BOLT_ILLAGER_SPELL;
    public static final Object PROVOKE_ILLAGER_SPELL;

    static {
        String s = IllagerInvasion.MOD_ID.toUpperCase(Locale.ROOT) + "$";
        ENCHANT_ILLAGER_SPELL = CommonAbstractions.INSTANCE.registerIllagerSpell(s + "ENCHANT", 121.0 / 255.0, 161.0 / 255.0, 161.0 / 255.0);
        CONJURE_FLAMES_ILLAGER_SPELL = CommonAbstractions.INSTANCE.registerIllagerSpell(s + "CONJURE_FLAMES", 194.0 / 255.0, 41.0 / 255.0, 36.0 / 255.0);
        CONJURE_TELEPORT_ILLAGER_SPELL = CommonAbstractions.INSTANCE.registerIllagerSpell(s + "CONJURE_TELEPORT", 64.0 / 255.0, 35.0 / 255.0, 81.0 / 255.0);
        NECRO_RAISE_ILLAGER_SPELL = CommonAbstractions.INSTANCE.registerIllagerSpell(s + "NECRO_RAISE", 78.0 / 255.0, 73.0 / 255.0, 52.0 / 255.0);
        CONJURE_SKULL_BOLT_ILLAGER_SPELL = CommonAbstractions.INSTANCE.registerIllagerSpell(s + "CONJURE_SKULL_BOLT", 44.0 / 255.0, 53.0 / 255.0, 26.0 / 255.0);
        PROVOKE_ILLAGER_SPELL = CommonAbstractions.INSTANCE.registerIllagerSpell(s + "PROVOKE", 235.0 / 255.0, 123.0 / 255.0, 109.0 / 255.0);
    }

    public static void touch() {

    }
}
