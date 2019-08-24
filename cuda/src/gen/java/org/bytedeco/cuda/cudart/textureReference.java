// Targeted by JavaCPP version 1.5.2-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.cuda.global.cudart.*;


/**
 * CUDA texture reference
 */
@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class textureReference extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public textureReference() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public textureReference(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public textureReference(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public textureReference position(long position) {
        return (textureReference)super.position(position);
    }

    /**
     * Indicates whether texture reads are normalized or not
     */
    public native int normalized(); public native textureReference normalized(int setter);
    /**
     * Texture filter mode
     */
    public native @Cast("cudaTextureFilterMode") int filterMode(); public native textureReference filterMode(int setter);
    /**
     * Texture address mode for up to 3 dimensions
     */
    public native @Cast("cudaTextureAddressMode") int addressMode(int i); public native textureReference addressMode(int i, int setter);
    @MemberGetter public native @Cast("cudaTextureAddressMode*") IntPointer addressMode();
    /**
     * Channel descriptor for the texture reference
     */
    public native @ByRef cudaChannelFormatDesc channelDesc(); public native textureReference channelDesc(cudaChannelFormatDesc setter);
    /**
     * Perform sRGB->linear conversion during texture read
     */
    public native int sRGB(); public native textureReference sRGB(int setter);
    /**
     * Limit to the anisotropy ratio
     */
    public native @Cast("unsigned int") int maxAnisotropy(); public native textureReference maxAnisotropy(int setter);
    /**
     * Mipmap filter mode
     */
    public native @Cast("cudaTextureFilterMode") int mipmapFilterMode(); public native textureReference mipmapFilterMode(int setter);
    /**
     * Offset applied to the supplied mipmap level
     */
    public native float mipmapLevelBias(); public native textureReference mipmapLevelBias(float setter);
    /**
     * Lower end of the mipmap level range to clamp access to
     */
    public native float minMipmapLevelClamp(); public native textureReference minMipmapLevelClamp(float setter);
    /**
     * Upper end of the mipmap level range to clamp access to
     */
    public native float maxMipmapLevelClamp(); public native textureReference maxMipmapLevelClamp(float setter);
    public native int __cudaReserved(int i); public native textureReference __cudaReserved(int i, int setter);
    @MemberGetter public native IntPointer __cudaReserved();
}
