package gregtech.loaders.postload.recipes;

import static gregtech.api.recipe.RecipeMaps.transcendentPlasmaMixerRecipes;

import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTRecipeBuilder;
import gregtech.api.util.GTRecipeConstants;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialsElements;

public class TranscendentPlasmaMixerRecipes implements Runnable {

    private static final int CRUDE_EU_PER_L = 14_514_983;
    private static final int PROSAIC_EU_PER_L = 66_768_460;
    private static final int RESPLENDENT_EU_PER_L = 269_326_451;
    private static final int EXOTIC_EU_PER_L = 1_073_007_393;
    private static final int STELLAR_EU_PER_HALF_L = 2_138_383_760;

    private static final int PRIMORDIAL_MATTER = 2_000_000_000;

    @Override
    public void run() {

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(1))
            .fluidInputs(
                Materials.Helium.getPlasma(1_000),
                Materials.Iron.getPlasma(1_000),
                Materials.Calcium.getPlasma(1_000),
                Materials.Niobium.getPlasma(1_000))
            .fluidOutputs(MaterialsUEVplus.ExcitedDTCC.getFluid(1_000))
            .duration(100)
            .eut(CRUDE_EU_PER_L)
            .addTo(transcendentPlasmaMixerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                Materials.Helium.getPlasma(1_000),
                Materials.Iron.getPlasma(1_000),
                Materials.Calcium.getPlasma(1_000),
                Materials.Niobium.getPlasma(1_000),
                Materials.Radon.getPlasma(1_000),
                Materials.Nickel.getPlasma(1_000),
                Materials.Boron.getPlasma(1_000),
                Materials.Sulfur.getPlasma(1_000))
            .fluidOutputs(MaterialsUEVplus.ExcitedDTPC.getFluid(1_000))
            .duration(100)
            .eut(PROSAIC_EU_PER_L)
            .addTo(transcendentPlasmaMixerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(3))
            .fluidInputs(
                Materials.Helium.getPlasma(1_000),
                Materials.Iron.getPlasma(1_000),
                Materials.Calcium.getPlasma(1_000),
                Materials.Niobium.getPlasma(1_000),
                Materials.Radon.getPlasma(1_000),
                Materials.Nickel.getPlasma(1_000),
                Materials.Boron.getPlasma(1_000),
                Materials.Sulfur.getPlasma(1_000),
                Materials.Nitrogen.getPlasma(1_000),
                Materials.Zinc.getPlasma(1_000),
                Materials.Silver.getPlasma(1_000),
                Materials.Titanium.getPlasma(1_000))
            .fluidOutputs(MaterialsUEVplus.ExcitedDTRC.getFluid(1_000))
            .duration(100)
            .eut(RESPLENDENT_EU_PER_L)
            .addTo(transcendentPlasmaMixerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                Materials.Helium.getPlasma(1_000),
                Materials.Iron.getPlasma(1_000),
                Materials.Calcium.getPlasma(1_000),
                Materials.Niobium.getPlasma(1_000),
                Materials.Radon.getPlasma(1_000),
                Materials.Nickel.getPlasma(1_000),
                Materials.Boron.getPlasma(1_000),
                Materials.Sulfur.getPlasma(1_000),
                Materials.Nitrogen.getPlasma(1_000),
                Materials.Zinc.getPlasma(1_000),
                Materials.Silver.getPlasma(1_000),
                Materials.Titanium.getPlasma(1_000),
                Materials.Americium.getPlasma(1_000),
                Materials.Bismuth.getPlasma(1_000),
                Materials.Oxygen.getPlasma(1_000),
                Materials.Tin.getPlasma(1_000))
            .fluidOutputs(MaterialsUEVplus.ExcitedDTEC.getFluid(1_000))
            .duration(100)
            .eut(EXOTIC_EU_PER_L)
            .addTo(transcendentPlasmaMixerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                Materials.Helium.getPlasma(1_000),
                Materials.Iron.getPlasma(1_000),
                Materials.Calcium.getPlasma(1_000),
                Materials.Niobium.getPlasma(1_000),
                Materials.Radon.getPlasma(1_000),
                Materials.Nickel.getPlasma(1_000),
                Materials.Boron.getPlasma(1_000),
                Materials.Sulfur.getPlasma(1_000),
                Materials.Nitrogen.getPlasma(1_000),
                Materials.Zinc.getPlasma(1_000),
                Materials.Silver.getPlasma(1_000),
                Materials.Titanium.getPlasma(1_000),
                Materials.Americium.getPlasma(1_000),
                Materials.Bismuth.getPlasma(1_000),
                Materials.Oxygen.getPlasma(1_000),
                Materials.Tin.getPlasma(1_000),
                Materials.Lead.getPlasma(1_000),
                Materials.Thorium.getPlasma(1_000),
                Materials.Naquadria.getPlasma(100L),
                MaterialsUEVplus.RawStarMatter.getFluid(25L))
            .fluidOutputs(MaterialsUEVplus.ExcitedDTSC.getFluid(1_000))
            .duration(100)
            .eut(STELLAR_EU_PER_HALF_L)
            .metadata(GTRecipeConstants.EU_MULTIPLIER, 20)
            .addTo(transcendentPlasmaMixerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(24))
            .fluidInputs(
                MaterialsUEVplus.RawStarMatter.getFluid(1_000),
                MaterialsUEVplus.SpaceTime.getMolten(1_000),
                MaterialsUEVplus.Space.getMolten(1_000),
                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1_000))
            .fluidOutputs(MaterialsUEVplus.PrimordialMatter.getFluid(1_000))
            .duration(100)
            .eut(PRIMORDIAL_MATTER)
            .addTo(transcendentPlasmaMixerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(24))
            .fluidInputs(
                new FluidStack(MaterialsElements.getInstance().FERMIUM.getPlasma(), 1_000),
                Materials.Thorium.getPlasma(1_000),
                new FluidStack(MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getPlasma(), 1_000),
                Materials.Calcium.getPlasma(1_000),
                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1_000))
            .fluidOutputs(MaterialsUEVplus.Creon.getPlasma(5_000))
            .duration(100)
            .eut(TierEU.RECIPE_UMV)
            .addTo(transcendentPlasmaMixerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(24))
            .fluidInputs(
                Materials.Infinity.getPlasma(1_000),
                Materials.Neutronium.getPlasma(1_000),
                Materials.Flerovium.getPlasma(1_000),
                new FluidStack(MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getPlasma(), 1_000),
                new FluidStack(MaterialsElements.STANDALONE.HYPOGEN.getPlasma(), 1_000),
                Materials.Ichorium.getPlasma(1_000),
                MaterialsUEVplus.SixPhasedCopper.getPlasma(1_000),
                Materials.DraconiumAwakened.getPlasma(1_000),
                new FluidStack(MaterialsElements.STANDALONE.DRAGON_METAL.getPlasma(), 1_000),
                new FluidStack(MaterialsElements.STANDALONE.RHUGNOR.getPlasma(), 1_000),
                Materials.Draconium.getPlasma(1_000),
                MaterialsUEVplus.Creon.getPlasma(1_000),
                Materials.Tritanium.getPlasma(1_000),
                Materials.CosmicNeutronium.getPlasma(1_000),
                Materials.Bedrockium.getPlasma(1_000),
                MaterialsUEVplus.ExcitedDTCC.getFluid(1_000),
                MaterialsUEVplus.ExcitedDTPC.getFluid(1_000),
                MaterialsUEVplus.ExcitedDTRC.getFluid(1_000),
                MaterialsUEVplus.ExcitedDTEC.getFluid(1_000),
                MaterialsUEVplus.ExcitedDTSC.getFluid(1_000))
            .fluidOutputs(MaterialsUEVplus.StargateCrystalSlurry.getFluid(1_000))
            .duration(100 * GTRecipeBuilder.TICKS)
            // 1 Trillion EU/t
            .metadata(GTRecipeConstants.EU_MULTIPLIER, 1000)
            .eut(1_000_000_000L)
            .addTo(transcendentPlasmaMixerRecipes);
    }
}
