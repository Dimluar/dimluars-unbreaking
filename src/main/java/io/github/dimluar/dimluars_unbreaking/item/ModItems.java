package io.github.dimluar.dimluars_unbreaking.item;

import io.github.dimluar.dimluars_unbreaking.DimluarSUnbreaking;
import io.github.dimluar.dimluars_unbreaking.util.ModComponents;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    public static final Item STONE_UPGRADE_SMITHING_TEMPLATE = registerItem("stone_upgrade_smithing_template", properties ->
            new Item(properties.component(ModComponents.SIMPLE_SMITHING_TOOLTIP_COMPONENT, new ModComponents.SimpleSmithingTooltipComponent("wood_equipment", "stone_material")))
    );
    public static final Item COPPER_UPGRADE_SMITHING_TEMPLATE = registerItem("copper_upgrade_smithing_template", properties ->
            new Item(properties.component(ModComponents.SMITHING_TOOLTIP_COMPONENT, new ModComponents.SmithingTooltipComponent("stone_equipment", "leather_equipment", "copper_material")))
    );
    public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = registerItem("iron_upgrade_smithing_template", properties ->
            new Item(properties.component(ModComponents.SIMPLE_SMITHING_TOOLTIP_COMPONENT, new ModComponents.SimpleSmithingTooltipComponent("copper_equipment", "iron_material")))
    );
    public static final Item GOLD_UPGRADE_SMITHING_TEMPLATE = registerItem("gold_upgrade_smithing_template", properties ->
            new Item(properties.component(ModComponents.SIMPLE_SMITHING_TOOLTIP_COMPONENT, new ModComponents.SimpleSmithingTooltipComponent("iron_equipment", "gold_material")))
    );
    public static final Item DIAMOND_UPGRADE_SMITHING_TEMPLATE = registerItem("diamond_upgrade_smithing_template", properties ->
            new Item(properties.component(ModComponents.SIMPLE_SMITHING_TOOLTIP_COMPONENT, new ModComponents.SimpleSmithingTooltipComponent("gold_equipment", "diamond_material")))
    );

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
