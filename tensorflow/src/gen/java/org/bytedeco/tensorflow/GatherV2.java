// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Gather slices from {@code params} axis {@code axis} according to {@code indices}.
 * 
 *  {@code indices} must be an integer tensor of any dimension (usually 0-D or 1-D).
 *  Produces an output tensor with shape {@code params.shape[:axis] + indices.shape +
 *  params.shape[axis + 1:]} where:
 * 
 *  <pre>{@code python
 *      # Scalar indices (output is rank(params) - 1).
 *      output[a_0, ..., a_n, b_0, ..., b_n] =
 *        params[a_0, ..., a_n, indices, b_0, ..., b_n]
 * 
 *      # Vector indices (output is rank(params)).
 *      output[a_0, ..., a_n, i, b_0, ..., b_n] =
 *        params[a_0, ..., a_n, indices[i], b_0, ..., b_n]
 * 
 *      # Higher rank indices (output is rank(params) + rank(indices) - 1).
 *      output[a_0, ..., a_n, i, ..., j, b_0, ... b_n] =
 *        params[a_0, ..., a_n, indices[i, ..., j], b_0, ..., b_n]
 *  }</pre>
 * 
 *  <div style="width:70%; margin:auto; margin-bottom:10px; margin-top:20px;">
 *  <img style="width:100%" src="https://www.tensorflow.org/images/Gather.png" alt>
 *  </div>
 * 
 *  Note that on CPU, if an out of bound index is found, an error is returned.
 *  On GPU, if an out of bound index is found, a 0 is stored in the
 *  corresponding output value.
 * 
 *  See also {@code tf.batch_gather} and {@code tf.gather_nd}.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * params: The tensor from which to gather values. Must be at least rank
 *  {@code axis + 1}.
 *  * indices: Index tensor. Must be in range {@code [0, params.shape[axis])}.
 *  * axis: The axis in {@code params} to gather {@code indices} from. Defaults to the first
 *  dimension. Supports negative indexes.
 * 
 *  Returns:
 *  * {@code Output}: Values from {@code params} gathered from indices given by {@code indices}, with
 *  shape {@code params.shape[:axis] + indices.shape + params.shape[axis + 1:]}. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class GatherV2 extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public GatherV2(Pointer p) { super(p); }

  /** Optional attribute setters for GatherV2 */
  public static class Attrs extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public Attrs() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Attrs(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Attrs(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public Attrs position(long position) {
          return (Attrs)super.position(position);
      }
  
    /** Defaults to 0 */
    public native @ByVal Attrs BatchDims(@Cast("tensorflow::int64") long x);

    public native @Cast("tensorflow::int64") long batch_dims_(); public native Attrs batch_dims_(long setter);
  }
  public GatherV2(@Const @ByRef Scope scope, @ByVal Input params,
           @ByVal Input indices, @ByVal Input axis) { super((Pointer)null); allocate(scope, params, indices, axis); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input params,
           @ByVal Input indices, @ByVal Input axis);
  public GatherV2(@Const @ByRef Scope scope, @ByVal Input params,
           @ByVal Input indices, @ByVal Input axis, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, params, indices, axis, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input params,
           @ByVal Input indices, @ByVal Input axis, @Const @ByRef Attrs attrs);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public static native @ByVal Attrs BatchDims(@Cast("tensorflow::int64") long x);

  public native @ByRef Operation operation(); public native GatherV2 operation(Operation setter);
  public native @ByRef Output output(); public native GatherV2 output(Output setter);
}
