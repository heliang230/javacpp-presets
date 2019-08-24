// Targeted by JavaCPP version 1.5.2-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nvml;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.nvml.*;


/**
 * Detailed ECC error counts for a device.
 *
 * @deprecated  Different GPU families can have different memory error counters
 *              See \ref nvmlDeviceGetMemoryErrorCounter
 */
@Properties(inherit = org.bytedeco.cuda.presets.nvml.class)
public class nvmlEccErrorCounts_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public nvmlEccErrorCounts_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public nvmlEccErrorCounts_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public nvmlEccErrorCounts_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public nvmlEccErrorCounts_t position(long position) {
        return (nvmlEccErrorCounts_t)super.position(position);
    }

    /** L1 cache errors */
    public native @Cast("unsigned long long") long l1Cache(); public native nvmlEccErrorCounts_t l1Cache(long setter);
    /** L2 cache errors */
    public native @Cast("unsigned long long") long l2Cache(); public native nvmlEccErrorCounts_t l2Cache(long setter);
    /** Device memory errors */
    public native @Cast("unsigned long long") long deviceMemory(); public native nvmlEccErrorCounts_t deviceMemory(long setter);
    /** Register file errors */
    public native @Cast("unsigned long long") long registerFile(); public native nvmlEccErrorCounts_t registerFile(long setter);
}
