// Targeted by JavaCPP version 1.5.2-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.cuda.global.cudart.*;


/**
 * GPU kernel node parameters
 */
@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class CUDA_KERNEL_NODE_PARAMS extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CUDA_KERNEL_NODE_PARAMS() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CUDA_KERNEL_NODE_PARAMS(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CUDA_KERNEL_NODE_PARAMS(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CUDA_KERNEL_NODE_PARAMS position(long position) {
        return (CUDA_KERNEL_NODE_PARAMS)super.position(position);
    }

    /** Kernel to launch */
    public native CUfunc_st func(); public native CUDA_KERNEL_NODE_PARAMS func(CUfunc_st setter);
    /** Width of grid in blocks */
    public native @Cast("unsigned int") int gridDimX(); public native CUDA_KERNEL_NODE_PARAMS gridDimX(int setter);
    /** Height of grid in blocks */
    public native @Cast("unsigned int") int gridDimY(); public native CUDA_KERNEL_NODE_PARAMS gridDimY(int setter);
    /** Depth of grid in blocks */
    public native @Cast("unsigned int") int gridDimZ(); public native CUDA_KERNEL_NODE_PARAMS gridDimZ(int setter);
    /** X dimension of each thread block */
    public native @Cast("unsigned int") int blockDimX(); public native CUDA_KERNEL_NODE_PARAMS blockDimX(int setter);
    /** Y dimension of each thread block */
    public native @Cast("unsigned int") int blockDimY(); public native CUDA_KERNEL_NODE_PARAMS blockDimY(int setter);
    /** Z dimension of each thread block */
    public native @Cast("unsigned int") int blockDimZ(); public native CUDA_KERNEL_NODE_PARAMS blockDimZ(int setter);
    /** Dynamic shared-memory size per thread block in bytes */
    public native @Cast("unsigned int") int sharedMemBytes(); public native CUDA_KERNEL_NODE_PARAMS sharedMemBytes(int setter);
    /** Array of pointers to kernel parameters */
    public native Pointer kernelParams(int i); public native CUDA_KERNEL_NODE_PARAMS kernelParams(int i, Pointer setter);
    public native @Cast("void**") PointerPointer kernelParams(); public native CUDA_KERNEL_NODE_PARAMS kernelParams(PointerPointer setter);
    /** Extra options */
    public native Pointer extra(int i); public native CUDA_KERNEL_NODE_PARAMS extra(int i, Pointer setter);
    public native @Cast("void**") PointerPointer extra(); public native CUDA_KERNEL_NODE_PARAMS extra(PointerPointer setter);
}
