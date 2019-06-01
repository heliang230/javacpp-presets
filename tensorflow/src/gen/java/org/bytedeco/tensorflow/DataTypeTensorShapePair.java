// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

@NoOffset @Name("std::pair<tensorflow::DataType,tensorflow::TensorShape>") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class DataTypeTensorShapePair extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DataTypeTensorShapePair(Pointer p) { super(p); }
    public DataTypeTensorShapePair(int firstValue, TensorShape secondValue) { this(); put(firstValue, secondValue); }
    public DataTypeTensorShapePair()       { allocate();  }
    private native void allocate();
    public native @Name("operator=") @ByRef DataTypeTensorShapePair put(@ByRef DataTypeTensorShapePair x);


    @MemberGetter public native @Cast("tensorflow::DataType") int first(); public native DataTypeTensorShapePair first(int first);
    @MemberGetter public native @ByRef TensorShape second();  public native DataTypeTensorShapePair second(TensorShape second);

    public DataTypeTensorShapePair put(int firstValue, TensorShape secondValue) {
        first(firstValue);
        second(secondValue);
        return this;
    }
}

