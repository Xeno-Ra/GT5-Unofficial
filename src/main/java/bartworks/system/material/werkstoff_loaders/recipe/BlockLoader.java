/*
 * Copyright (c) 2018-2020 bartimaeusnek Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions: The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software. THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package bartworks.system.material.werkstoff_loaders.recipe;

import static gregtech.api.enums.OrePrefixes.block;
import static gregtech.api.enums.OrePrefixes.cellMolten;
import static gregtech.api.enums.OrePrefixes.ingot;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalArcFurnace;

import bartworks.system.material.Werkstoff;
import bartworks.system.material.werkstoff_loaders.IWerkstoffRunnable;
import gregtech.api.enums.GTValues;
import gregtech.api.recipe.RecipeCategories;
import gregtech.api.util.GTRecipeConstants;

public class BlockLoader implements IWerkstoffRunnable {

    @Override
    public void run(Werkstoff werkstoff) {
        if (!werkstoff.hasItemType(block)) return;
        if (werkstoff.hasItemType(ingot)) {
            GTValues.RA.stdBuilder()
                .itemInputs(werkstoff.get(block))
                .itemOutputs(werkstoff.get(ingot, 9))
                .duration(16 * TICKS)
                .eut(90)
                .metadata(GTRecipeConstants.RECYCLE, true)
                .addTo(UniversalArcFurnace);
        }
        if (werkstoff.hasItemType(cellMolten)) {

            GTValues.RA.stdBuilder()
                .itemInputs(werkstoff.get(block))
                .fluidOutputs(werkstoff.getMolten(9 * INGOTS))
                .recipeCategory(RecipeCategories.fluidExtractorRecycling)
                .duration(14 * SECONDS + 8 * TICKS)
                .eut(8)
                .addTo(fluidExtractionRecipes);

        }
    }
}
