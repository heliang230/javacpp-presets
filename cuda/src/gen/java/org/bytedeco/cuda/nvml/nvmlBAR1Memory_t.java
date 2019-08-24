// Targeted by JavaCPP version 1.5.2-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nvml;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.nvml.*;


/**
 * BAR1 Memory allocation Information for a device
 */
@Properties(inherit = org.bytedeco.cuda.presets.nvml.class)
public class nvmlBAR1Memory_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public nvmlBAR1Memory_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public nvmlBAR1Memory_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public nvmlBAR1Memory_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public nvmlBAR1Memory_t position(long position) {
        return (nvmlBAR1Memory_t)super.position(position);
    }

    /** Total BAR1 Memory (in bytes) */
    public native @Cast("unsigned long long") long bar1Total(); public native nvmlBAR1Memory_t bar1Total(long setter);
    /** Unallocated BAR1 Memory (in bytes) */
    public native @Cast("unsigned long long") long bar1Free(); public native nvmlBAR1Memory_t bar1Free(long setter);
    /** Allocated Used Memory (in bytes) */
    public native @Cast("unsigned long long") long bar1Used(); public native nvmlBAR1Memory_t bar1Used(long setter);
}
