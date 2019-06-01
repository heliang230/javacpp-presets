// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// Builder class passed to the REGISTER_KERNEL_BUILDER() macro.
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class KernelDefBuilder extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public KernelDefBuilder(Pointer p) { super(p); }

  // Starts with just the name field set.
  // Caller MUST call Build() and take ownership of the result.
  public KernelDefBuilder(@Cast("const char*") BytePointer op_name) { super((Pointer)null); allocate(op_name); }
  private native void allocate(@Cast("const char*") BytePointer op_name);
  public KernelDefBuilder(String op_name) { super((Pointer)null); allocate(op_name); }
  private native void allocate(String op_name);

  // Required: specify the type of device this kernel supports.
  // Returns *this.
  public native @ByRef KernelDefBuilder Device(@Cast("const char*") BytePointer device_type);
  public native @ByRef KernelDefBuilder Device(String device_type);
  //  KernelDefBuilder& Device(DeviceType device_type);

  // Specify that this kernel supports a limited set of values for a
  // particular type or list(type) attr (a further restriction than
  // what the Op allows).
  // Returns *this.

  // Like AttrConstraint above but supports just a single value.

  // Specify that this kernel supports a limited set of values for a
  // particular type or list(type) attr (a further restriction than
  // what the Op allows).
  // Returns *this.
  public native @ByRef KernelDefBuilder TypeConstraint(@Cast("const char*") BytePointer attr_name,
                                     @Cast("tensorflow::DataType*") @ArraySlice IntPointer allowed);
  public native @ByRef KernelDefBuilder TypeConstraint(String attr_name,
                                     @Cast("tensorflow::DataType*") @ArraySlice IntPointer allowed);

  // Like TypeConstraint but supports just a single type.
  public native @ByRef KernelDefBuilder TypeConstraint(@Cast("const char*") BytePointer attr_name, @Cast("tensorflow::DataType") int allowed);
  public native @ByRef KernelDefBuilder TypeConstraint(String attr_name, @Cast("tensorflow::DataType") int allowed);

  // Like TypeConstraint, but (a) gets the type from a template parameter
  // and (b) only supports a constraint to a single type.
  // TODO(josh11b): Support other types of attr constraints as needed.

  // Specify that this kernel requires/provides an input/output arg
  // in host memory (instead of the default, device memory).
  // Returns *this.
  public native @ByRef KernelDefBuilder HostMemory(@Cast("const char*") BytePointer arg_name);
  public native @ByRef KernelDefBuilder HostMemory(String arg_name);

  // Specify that this kernel requires a particular value for the
  // "_kernel" attr.  May only be specified once.  Returns *this.
  public native @ByRef KernelDefBuilder Label(@Cast("const char*") BytePointer label);
  public native @ByRef KernelDefBuilder Label(String label);

  // Specify a priority number for this kernel.
  public native @ByRef KernelDefBuilder Priority(int priority);

  // Returns a pointer to a KernelDef with fields set based on the
  // above calls to this instance.
  // Caller takes ownership of the result.
  public native @Const KernelDef Build();
}
