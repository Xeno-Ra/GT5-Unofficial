package gtPlusPlus.xmod.gregtech.common.tileentities.generators;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.render.TextureFactory;

public class MTEAdvancedBoilerMV extends MTEAdvancedBoilerBase {

    public MTEAdvancedBoilerMV(int aID, String aNameRegional, int aBoilerTier) {
        super(aID, aNameRegional, aBoilerTier);
    }

    public MTEAdvancedBoilerMV(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEAdvancedBoilerMV(this.mName, 2, this.mDescriptionArray, this.mTextures);
    }

    @Override
    protected ITexture getCasingTexture() {
        return TextureFactory.of(Textures.BlockIcons.MACHINE_MV_SIDE);
    }

    @Override
    public ITexture[] getFront(final byte aColor) {
        return new ITexture[] { super.getFront(aColor)[0], this.getCasingTexture(),
            TextureFactory.of(Textures.BlockIcons.BOILER_FRONT) };
    }

    @Override
    public ITexture[] getTop(final byte aColor) {
        return new ITexture[] { super.getTop(aColor)[0], this.getCasingTexture(),
            TextureFactory.of(Textures.BlockIcons.MACHINE_MV_TOP) };
    }

    @Override
    public ITexture[] getFrontActive(final byte aColor) {
        return new ITexture[] { super.getFrontActive(aColor)[0], this.getCasingTexture(),
            TextureFactory.of(Textures.BlockIcons.BOILER_FRONT_ACTIVE) };
    }

    @Override
    public ITexture[] getTopActive(final byte aColor) {
        return getTop(aColor);
    }
}
