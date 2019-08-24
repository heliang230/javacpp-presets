// Targeted by JavaCPP version 1.5.2-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.cuda.global.cudart.*;


@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class char3 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public char3() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public char3(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public char3(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public char3 position(long position) {
        return (char3)super.position(position);
    }

    public native byte x(); public native char3 x(byte setter);
    public native byte y(); public native char3 y(byte setter);
    public native byte z(); public native char3 z(byte setter);
}
