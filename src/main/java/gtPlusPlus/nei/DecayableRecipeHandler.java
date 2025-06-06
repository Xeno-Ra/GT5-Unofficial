package gtPlusPlus.nei;

import static gregtech.api.enums.Mods.GTPlusPlus;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.handler.Recipes.DecayableRecipe;
import gtPlusPlus.core.item.base.dusts.BaseItemDustUnique;
import gtPlusPlus.core.item.materials.DustDecayable;
import gtPlusPlus.core.lib.VanillaColours;
import gtPlusPlus.nei.handlers.NeiTextureHandler;

public class DecayableRecipeHandler extends TemplateRecipeHandler {

    public static final String mNEIName = "Decayables";

    @Override
    public String getRecipeName() {
        return StatCollector.translateToLocal("GTPP.container.decaychest.name");
    }

    @Override
    public String getGuiTexture() {
        return GTPlusPlus.ID + ":textures/gui/nei/decayables.png";
    }

    @Override
    public String getOverlayIdentifier() {
        return "GTPP_Decayables";
    }

    @Override
    public int recipiesPerPage() {
        return 1;
    }

    @Override
    public void loadTransferRects() {
        this.transferRects.add(new RecipeTransferRect(new Rectangle(6, 3, 16, 16), getOverlayIdentifier()));
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        if (result == null
            || (!(result.getItem() instanceof DustDecayable) && !(result.getItem() instanceof BaseItemDustUnique))) {
            return;
        }
        final List<DecayableRecipe> recipes = DecayableRecipe.mRecipes;
        for (final DecayableRecipe recipe : recipes) {
            if (recipe.isValid()) {
                final ItemStack input = recipe.mInput.copy();
                final ItemStack output = recipe.mOutput.copy();
                if (!GTUtility.areStacksEqual(result, output, true)) {
                    continue;
                }
                // Logger.INFO("Showing Usage result for "+ItemUtils.getItemName(result));
                final DecayableRecipeNEI rec = new DecayableRecipeNEI(input, output, recipe.mTime);
                this.arecipes.add(rec);
                sort();
            }
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals(getOverlayIdentifier()) && this.getClass() == DecayableRecipeHandler.class) {
            final List<DecayableRecipe> recipes = DecayableRecipe.mRecipes;
            for (final DecayableRecipe recipe : recipes) {
                if (recipe.isValid()) {
                    final ItemStack input = recipe.mInput.copy();
                    final ItemStack output = recipe.mOutput.copy();
                    final DecayableRecipeNEI rec = new DecayableRecipeNEI(input, output, recipe.mTime);
                    this.arecipes.add(rec);
                    sort();
                }
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        final List<DecayableRecipe> recipes = DecayableRecipe.mRecipes;

        for (final DecayableRecipe recipe : recipes) {
            if (recipe.isValid()) {
                final ItemStack input = recipe.mInput.copy();
                final ItemStack output = recipe.mOutput.copy();
                if (!GTUtility.areStacksEqual(ingredient, input, true)) {
                    continue;
                }
                // Logger.INFO("Showing up Usage results for "+ItemUtils.getItemName(ingredient));
                final DecayableRecipeNEI rec = new DecayableRecipeNEI(input, output, recipe.mTime);
                // rec.setIngredientPermutation((Collection) rec.input, ingredient);
                this.arecipes.add(rec);
                sort();
            }
        }
    }

    private void sort() {
        List<DecayableRecipeNEI> g = new ArrayList<>();
        for (CachedRecipe u : arecipes) {
            g.add((DecayableRecipeNEI) u);
        }
        if (!g.isEmpty()) {
            Collections.sort(g);
        }
    }

    @Override
    public void drawExtras(int recipeIndex) {
        DecayableRecipeNEI recipe = (DecayableRecipeNEI) this.arecipes.get(recipeIndex);

        // GuiDraw.drawStringC(I18n.format("GTPP.container.decaychest.result", new Object[]{}), 43, 10, 8421504, false);

        int cost = recipe.time;
        if (cost > 0) {

            // NEI Strings
            String s = I18n.format("GTPP.nei.info", cost);
            String s0 = I18n.format("GTPP.nei.timetaken", cost);

            // Time Strings
            String s1 = I18n.format("GTPP.time.ticks", cost);
            String s2 = I18n.format("GTPP.time.seconds", cost);
            String s3 = I18n.format("GTPP.time.minutes", cost);
            String s4 = I18n.format("GTPP.time.hours", cost);
            String s5 = I18n.format("GTPP.time.days", cost);
            String s6 = I18n.format("GTPP.time.months", cost);
            int y = 20;

            int secs = cost / 20;
            int mins = secs / 60;
            int hours = mins / 60;
            int days = hours / 24;
            int months = days / 30;

            String suffix;
            int formattedTime;
            if (cost <= 20) {
                suffix = s1;
                formattedTime = cost;
            } else if (cost <= (20 * 60)) {
                suffix = s2;
                formattedTime = secs;
            } else if (cost <= (20 * 60 * 60)) {
                suffix = s3;
                formattedTime = mins;
            } else if (cost <= (20 * 60 * 60 * 24)) {
                suffix = s4;
                formattedTime = hours;
            } else if (cost < (20 * 60 * 60 * 24 * 30)) {
                suffix = s5;
                formattedTime = days;
            } else if (cost <= (20 * 60 * 60 * 24 * 30)) {
                suffix = s6;
                formattedTime = months;
            } else {
                suffix = s1;
                formattedTime = cost;
            }

            int x = 5;
            GuiDraw.drawString(s, x, 25, VanillaColours.DYE_BLACK.getAsInt(), false);
            GuiDraw.drawString(s0, x, 40, VanillaColours.DYE_BLACK.getAsInt(), false);

            GuiDraw.drawString(suffix, x + 16, y + 30, VanillaColours.DYE_BLACK.getAsInt(), false);

            // Values
            GuiDraw.drawString(("" + formattedTime), x, y + 30, VanillaColours.DYE_GREEN.getAsInt(), false);

            if (hours > 1) {
                int aLeftoverMinutes = (cost - (hours * (20 * 60 * 60)));
                if (aLeftoverMinutes > 0) {
                    int secs2 = aLeftoverMinutes / 20;
                    int mins2 = secs2 / 60;
                    GuiDraw.drawString(s3, x + 16, y + 42, VanillaColours.DYE_BLACK.getAsInt(), false);
                    GuiDraw.drawString(("" + mins2), x, y + 42, VanillaColours.DYE_GREEN.getAsInt(), false);
                }
            }
        }

        NeiTextureHandler.RECIPE_BUTTON.renderIcon(6.0D, 3.0D, 16.0D, 16.0D, 0.0D, true);
    }

    public class DecayableRecipeNEI extends TemplateRecipeHandler.CachedRecipe implements Comparable<CachedRecipe> {

        private final PositionedStack input;
        private final PositionedStack output;
        public int time;

        @Override
        public PositionedStack getIngredient() {
            return this.input;
        }

        @Override
        public PositionedStack getResult() {
            return this.output;
        }

        public DecayableRecipeNEI(final ItemStack input, final ItemStack result, final int time) {
            super();
            this.input = new PositionedStack(input, 93, 24);
            this.output = new PositionedStack(result, 142, 42);
            this.time = time;
        }

        @Override
        public int compareTo(CachedRecipe o) {
            if (o instanceof DecayableRecipeNEI p) {
                return Integer.compare(p.time, this.time);
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj != null) {
                if (obj instanceof DecayableRecipeNEI p) {
                    // Time check first to keep it simple and not unbox the Recipes.
                    if (p.time == this.time) {
                        ItemStack aInput = p.input.item;
                        ItemStack aOutput = p.output.item;
                        if (GTUtility.areStacksEqual(aInput, this.input.item, true)) {
                            return GTUtility.areStacksEqual(aOutput, this.output.item, true);
                        }
                    }
                }
            }
            return false;
        }
    }
}
