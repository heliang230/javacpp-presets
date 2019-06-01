// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

@Name("tensorflow::monitoring::GaugeCell<tensorflow::int64>") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class IntGaugeCell extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IntGaugeCell(Pointer p) { super(p); }

  public IntGaugeCell(@Cast("const tensorflow::int64") long value) { super((Pointer)null); allocate(value); }
  private native void allocate(@Cast("const tensorflow::int64") long value);

  // Atomically sets the value.
  public native void Set(@Cast("const tensorflow::int64") long value);

  // Retrieves the current value.
  public native @Cast("tensorflow::int64") long value();
}
