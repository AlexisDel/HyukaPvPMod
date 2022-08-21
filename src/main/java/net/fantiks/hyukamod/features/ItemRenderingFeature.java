package net.fantiks.hyukamod.features;

import net.fantiks.hyukamod.features.context.ItemRenderingFeatureExecutionContext;

/**
 * A item rendering feature is a feature in which alters the way the game renders a item.
 */
public interface ItemRenderingFeature<T extends ItemRenderingFeatureExecutionContext> extends OldAnimationsFeature<T> {
}
