package io.github.dimluar.dimluars_unbreaking.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.dimluar.dimluars_unbreaking.DimluarSUnbreaking;
import net.fabricmc.fabric.api.item.v1.ItemComponentTooltipProviderRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public class ModComponents {
    public static final Codec<SimpleSmithingTooltipComponent> SIMPLE_CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.STRING.fieldOf("base").forGetter(SimpleSmithingTooltipComponent::base),
            Codec.STRING.fieldOf("material").forGetter(SimpleSmithingTooltipComponent::material)
    ).apply(builder, SimpleSmithingTooltipComponent::new));

    public static final DataComponentType<SimpleSmithingTooltipComponent> SIMPLE_SMITHING_TOOLTIP_COMPONENT = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(DimluarSUnbreaking.MOD_ID, "simple_smithing_tooltip"),
            DataComponentType.<SimpleSmithingTooltipComponent>builder().persistent(ModComponents.SIMPLE_CODEC).build()
    );
    public record SimpleSmithingTooltipComponent(String base, String material) implements TooltipProvider {
        @Override
        public void addToTooltip(Item.@NonNull TooltipContext context, Consumer<Component> tooltip, @NonNull TooltipFlag flag, @NonNull DataComponentGetter components) {
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + ".template.tooltip").withStyle(ChatFormatting.GRAY));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + ".empty.tooltip" ));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + ".apply.tooltip" ).withStyle(ChatFormatting.GRAY));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + "." + base + ".tooltip").withStyle(ChatFormatting.BLUE));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + ".ingredient.tooltip" ).withStyle(ChatFormatting.GRAY));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + "." + material + ".tooltip").withStyle(ChatFormatting.BLUE));
        }
    }

    public static final Codec<SmithingTooltipComponent> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.STRING.fieldOf("base1").forGetter(SmithingTooltipComponent::base1),
            Codec.STRING.fieldOf("base2").forGetter(SmithingTooltipComponent::base2),
            Codec.STRING.fieldOf("material").forGetter(SmithingTooltipComponent::material)
    ).apply(builder, SmithingTooltipComponent::new));

    public static final DataComponentType<SmithingTooltipComponent> SMITHING_TOOLTIP_COMPONENT = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(DimluarSUnbreaking.MOD_ID, "smithing_tooltip"),
            DataComponentType.<SmithingTooltipComponent>builder().persistent(ModComponents.CODEC).build()
    );
    public record SmithingTooltipComponent(String base1, String base2, String material) implements TooltipProvider {
        @Override
        public void addToTooltip(Item.@NonNull TooltipContext context, Consumer<Component> tooltip, @NonNull TooltipFlag flag, @NonNull DataComponentGetter components) {
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + ".template.tooltip").withStyle(ChatFormatting.GRAY));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + ".empty.tooltip" ));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + ".apply.tooltip" ).withStyle(ChatFormatting.GRAY));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + "." + base1 + ".tooltip").withStyle(ChatFormatting.BLUE));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + "." + base2 + ".tooltip").withStyle(ChatFormatting.BLUE));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + ".ingredient.tooltip" ).withStyle(ChatFormatting.GRAY));
            tooltip.accept(Component.translatable("item." + DimluarSUnbreaking.MOD_ID + "." + material + ".tooltip").withStyle(ChatFormatting.BLUE));
        }
    }

    public static void registerModComponents() {
        DimluarSUnbreaking.LOGGER.info("[" + DimluarSUnbreaking.MOD_ID + "] Registering Mod Components");

        ItemComponentTooltipProviderRegistry.addFirst(ModComponents.SIMPLE_SMITHING_TOOLTIP_COMPONENT);
        ItemComponentTooltipProviderRegistry.addFirst(ModComponents.SMITHING_TOOLTIP_COMPONENT);
    }
}
