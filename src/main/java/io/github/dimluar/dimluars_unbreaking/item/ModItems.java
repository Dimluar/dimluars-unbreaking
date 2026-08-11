package io.github.dimluar.dimluars_unbreaking.item;

import io.github.dimluar.dimluars_unbreaking.DimluarSUnbreaking;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item STONE_UPGRADE_SMITHING_TEMPLATE = registerItem("stone_upgrade_smithing_template", Item::new);
    public static final Item COPPER_UPGRADE_SMITHING_TEMPLATE = registerItem("copper_upgrade_smithing_template", Item::new);
    public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = registerItem("iron_upgrade_smithing_template", Item::new);
    public static final Item GOLD_UPGRADE_SMITHING_TEMPLATE = registerItem("gold_upgrade_smithing_template", Item::new);
    public static final Item DIAMOND_UPGRADE_SMITHING_TEMPLATE = registerItem("diamond_upgrade_smithing_template", Item::new);



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(DimluarSUnbreaking.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DimluarSUnbreaking.MOD_ID ,name)))));
    };

    public static void registerModItems() {
        DimluarSUnbreaking.LOGGER.info("[" + DimluarSUnbreaking.MOD_ID + "] Registering Mod Items");

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(DIAMOND_UPGRADE_SMITHING_TEMPLATE);
            output.accept(GOLD_UPGRADE_SMITHING_TEMPLATE);
            output.accept(IRON_UPGRADE_SMITHING_TEMPLATE);
            output.accept(COPPER_UPGRADE_SMITHING_TEMPLATE);
            output.accept(STONE_UPGRADE_SMITHING_TEMPLATE);
        });
    }
}
