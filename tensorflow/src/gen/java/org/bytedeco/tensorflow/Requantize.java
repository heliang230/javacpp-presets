// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Converts the quantized {@code input} tensor into a lower-precision {@code output}.
 * 
 *  Converts the quantized {@code input} tensor into a lower-precision {@code output}, using the
 *  output range specified with {@code requested_output_min} and {@code requested_output_max}.
 * 
 *  {@code [input_min, input_max]} are scalar floats that specify the range for the float
 *  interpretation of the {@code input} data. For example, if {@code input_min} is -1.0f and
 *  {@code input_max} is 1.0f, and we are dealing with {@code quint16} quantized data, then a 0
 *  value in the 16-bit data should be interpreted as -1.0f, and a 65535 means 1.0f.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * input_min: The float value that the minimum quantized input value represents.
 *  * input_max: The float value that the maximum quantized input value represents.
 *  * requested_output_min: The float value that the minimum quantized output value represents.
 *  * requested_output_max: The float value that the maximum quantized output value represents.
 *  * out_type: The type of the output. Should be a lower bit depth than Tinput.
 * 
 *  Returns:
 *  * {@code Output} output
 *  * {@code Output} output_min: The requested_output_min value is copied into this output.
 *  * {@code Output} output_max: The requested_output_max value is copied into this output. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class Requantize extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Requantize(Pointer p) { super(p); }

  public Requantize(@Const @ByRef Scope scope, @ByVal Input input,
             @ByVal Input input_min, @ByVal Input input_max,
             @ByVal Input requested_output_min, @ByVal Input requested_output_max, @Cast("tensorflow::DataType") int out_type) { super((Pointer)null); allocate(scope, input, input_min, input_max, requested_output_min, requested_output_max, out_type); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
             @ByVal Input input_min, @ByVal Input input_max,
             @ByVal Input requested_output_min, @ByVal Input requested_output_max, @Cast("tensorflow::DataType") int out_type);

  public native @ByRef Operation operation(); public native Requantize operation(Operation setter);
  public native @ByRef Output output(); public native Requantize output(Output setter);
  public native @ByRef Output output_min(); public native Requantize output_min(Output setter);
  public native @ByRef Output output_max(); public native Requantize output_max(Output setter);
}
