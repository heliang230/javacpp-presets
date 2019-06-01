// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Performs max pooling on the input and outputs both max values and indices.
 * 
 *  The indices in {@code argmax} are flattened, so that a maximum value at position
 *  {@code [b, y, x, c]} becomes flattened index:
 *  {@code (y * width + x) * channels + c} if {@code include_batch_in_index} is False;
 *  {@code ((b * height + y) * width + x) * channels + c} if {@code include_batch_in_index} is True.
 * 
 *  The indices returned are always in {@code [0, height) x [0, width)} before flattening,
 *  even if padding is involved and the mathematically correct answer is outside
 *  (either negative or too large).  This is a bug, but fixing it is difficult to do
 *  in a safe backwards compatible way, especially due to flattening.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * input: 4-D with shape {@code [batch, height, width, channels]}.  Input to pool over.
 *  * ksize: The size of the window for each dimension of the input tensor.
 *  * strides: The stride of the sliding window for each dimension of the
 *  input tensor.
 *  * padding: The type of padding algorithm to use.
 * 
 *  Optional attributes (see {@code Attrs}):
 *  * include_batch_in_index: Whether to include batch dimension in flattened index of {@code argmax}.
 * 
 *  Returns:
 *  * {@code Output} output: The max pooled output tensor.
 *  * {@code Output} argmax: 4-D.  The flattened indices of the max values chosen for each output. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class MaxPoolWithArgmax extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MaxPoolWithArgmax(Pointer p) { super(p); }

  /** Optional attribute setters for MaxPoolWithArgmax */
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
  
    /** Defaults to DT_INT64 */
    
    ///
    public native @ByVal Attrs Targmax(@Cast("tensorflow::DataType") int x);

    /** Whether to include batch dimension in flattened index of {@code argmax}.
     * 
     *  Defaults to false */
    public native @ByVal Attrs IncludeBatchInIndex(@Cast("bool") boolean x);

    public native @Cast("tensorflow::DataType") int Targmax_(); public native Attrs Targmax_(int setter);
    public native @Cast("bool") boolean include_batch_in_index_(); public native Attrs include_batch_in_index_(boolean setter);
  }
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides, @StringPiece BytePointer padding) { super((Pointer)null); allocate(scope, input, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides, @StringPiece BytePointer padding);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides, @StringPiece String padding) { super((Pointer)null); allocate(scope, input, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides, @StringPiece String padding);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice int[] ksize, @ArraySlice int[] strides, @StringPiece BytePointer padding) { super((Pointer)null); allocate(scope, input, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice int[] ksize, @ArraySlice int[] strides, @StringPiece BytePointer padding);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides, @StringPiece String padding) { super((Pointer)null); allocate(scope, input, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides, @StringPiece String padding);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides, @StringPiece BytePointer padding) { super((Pointer)null); allocate(scope, input, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides, @StringPiece BytePointer padding);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice int[] ksize, @ArraySlice int[] strides, @StringPiece String padding) { super((Pointer)null); allocate(scope, input, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice int[] ksize, @ArraySlice int[] strides, @StringPiece String padding);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides, @StringPiece BytePointer padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, input, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides, @StringPiece BytePointer padding, @Const @ByRef Attrs attrs);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides, @StringPiece String padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, input, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides, @StringPiece String padding, @Const @ByRef Attrs attrs);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice int[] ksize, @ArraySlice int[] strides, @StringPiece BytePointer padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, input, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice int[] ksize, @ArraySlice int[] strides, @StringPiece BytePointer padding, @Const @ByRef Attrs attrs);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides, @StringPiece String padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, input, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides, @StringPiece String padding, @Const @ByRef Attrs attrs);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides, @StringPiece BytePointer padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, input, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides, @StringPiece BytePointer padding, @Const @ByRef Attrs attrs);
  public MaxPoolWithArgmax(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice int[] ksize, @ArraySlice int[] strides, @StringPiece String padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, input, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                    @ArraySlice int[] ksize, @ArraySlice int[] strides, @StringPiece String padding, @Const @ByRef Attrs attrs);

  public static native @ByVal Attrs Targmax(@Cast("tensorflow::DataType") int x);
  public static native @ByVal Attrs IncludeBatchInIndex(@Cast("bool") boolean x);

  public native @ByRef Operation operation(); public native MaxPoolWithArgmax operation(Operation setter);
  public native @ByRef Output output(); public native MaxPoolWithArgmax output(Output setter);
  public native @ByRef Output argmax(); public native MaxPoolWithArgmax argmax(Output setter);
}
