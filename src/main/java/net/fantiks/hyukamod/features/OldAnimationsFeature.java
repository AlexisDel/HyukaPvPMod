package net.fantiks.hyukamod.features;

import net.fantiks.hyukamod.features.context.FeatureExecutionContext;

/**
 * A feature is a class by which you alter the visual mechanics of the game to port an old animation to new versions.
 * Each resource implements this interface or its derivatives.
 */
public interface OldAnimationsFeature<T extends FeatureExecutionContext> {

    void transform(T context);

}
