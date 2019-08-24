// Targeted by JavaCPP version 1.5.2-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.cuda.global.cudart.*;

@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class ushort4 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public ushort4() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ushort4(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ushort4(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public ushort4 position(long position) {
        return (ushort4)super.position(position);
    }
 
    public native @Cast("unsigned short") short x(); public native ushort4 x(short setter); public native @Cast("unsigned short") short y(); public native ushort4 y(short setter); public native @Cast("unsigned short") short z(); public native ushort4 z(short setter); public native @Cast("unsigned short") short w(); public native ushort4 w(short setter);
}
