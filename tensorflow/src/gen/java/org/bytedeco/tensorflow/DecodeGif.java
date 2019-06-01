// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Decode the frame(s) of a GIF-encoded image to a uint8 tensor.
 * 
 *  GIF images with frame or transparency compression are not supported.
 *  On Linux and MacOS systems, convert animated GIFs from compressed to
 *  uncompressed by running:
 * 
 *      convert $src.gif -coalesce $dst.gif
 * 
 *  This op also supports decoding JPEGs and PNGs, though it is cleaner to use
 *  {@code tf.image.decode_image}.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * contents: 0-D.  The GIF-encoded image.
 * 
 *  Returns:
 *  * {@code Output}: 4-D with shape {@code [num_frames, height, width, 3]}. RGB channel order. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class DecodeGif extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DecodeGif(Pointer p) { super(p); }

  public DecodeGif(@Const @ByRef Scope scope, @ByVal Input contents) { super((Pointer)null); allocate(scope, contents); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input contents);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native DecodeGif operation(Operation setter);
  public native @ByRef Output image(); public native DecodeGif image(Output setter);
}
