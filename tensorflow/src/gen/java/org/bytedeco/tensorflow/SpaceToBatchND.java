// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** SpaceToBatch for N-D tensors of type T.
 * 
 *  This operation divides "spatial" dimensions {@code [1, ..., M]} of the input into a
 *  grid of blocks of shape {@code block_shape}, and interleaves these blocks with the
 *  "batch" dimension (0) such that in the output, the spatial dimensions
 *  {@code [1, ..., M]} correspond to the position within the grid, and the batch
 *  dimension combines both the position within a spatial block and the original
 *  batch position.  Prior to division into blocks, the spatial dimensions of the
 *  input are optionally zero padded according to {@code paddings}.  See below for a
 *  precise description.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * input: N-D with shape {@code input_shape = [batch] + spatial_shape + remaining_shape},
 *  where spatial_shape has {@code M} dimensions.
 *  * block_shape: 1-D with shape {@code [M]}, all values must be >= 1.
 *  * paddings: 2-D with shape {@code [M, 2]}, all values must be >= 0.
 *    {@code paddings[i] = [pad_start, pad_end]} specifies the padding for input dimension
 *    {@code i + 1}, which corresponds to spatial dimension {@code i}.  It is required that
 *    {@code block_shape[i]} divides {@code input_shape[i + 1] + pad_start + pad_end}.
 * 
 *  This operation is equivalent to the following steps:
 * 
 *  1. Zero-pad the start and end of dimensions {@code [1, ..., M]} of the
 *     input according to {@code paddings} to produce {@code padded} of shape {@code padded_shape}.
 * 
 *  2. Reshape {@code padded} to {@code reshaped_padded} of shape:
 * 
 *       [batch] +
 *       [padded_shape[1] / block_shape[0],
 *         block_shape[0],
 *        ...,
 *        padded_shape[M] / block_shape[M-1],
 *        block_shape[M-1]] +
 *       remaining_shape
 * 
 *  3. Permute dimensions of {@code reshaped_padded} to produce
 *     {@code permuted_reshaped_padded} of shape:
 * 
 *       block_shape +
 *       [batch] +
 *       [padded_shape[1] / block_shape[0],
 *        ...,
 *        padded_shape[M] / block_shape[M-1]] +
 *       remaining_shape
 * 
 *  4. Reshape {@code permuted_reshaped_padded} to flatten {@code block_shape} into the batch
 *     dimension, producing an output tensor of shape:
 * 
 *       [batch * prod(block_shape)] +
 *       [padded_shape[1] / block_shape[0],
 *        ...,
 *        padded_shape[M] / block_shape[M-1]] +
 *       remaining_shape
 * 
 *  Some examples:
 * 
 *  (1) For the following input of shape {@code [1, 2, 2, 1]}, {@code block_shape = [2, 2]}, and
 *      {@code paddings = [[0, 0], [0, 0]]}:
 * 
 *  <pre>{@code
 *  x = [[[[1], [2]], [[3], [4]]]]
 *  }</pre>
 * 
 *  The output tensor has shape {@code [4, 1, 1, 1]} and value:
 * 
 *  <pre>{@code
 *  [[[[1]]], [[[2]]], [[[3]]], [[[4]]]]
 *  }</pre>
 * 
 *  (2) For the following input of shape {@code [1, 2, 2, 3]}, {@code block_shape = [2, 2]}, and
 *      {@code paddings = [[0, 0], [0, 0]]}:
 * 
 *  <pre>{@code
 *  x = [[[[1, 2, 3], [4, 5, 6]],
 *        [[7, 8, 9], [10, 11, 12]]]]
 *  }</pre>
 * 
 *  The output tensor has shape {@code [4, 1, 1, 3]} and value:
 * 
 *  <pre>{@code
 *  [[[[1, 2, 3]]], [[[4, 5, 6]]], [[[7, 8, 9]]], [[[10, 11, 12]]]]
 *  }</pre>
 * 
 *  (3) For the following input of shape {@code [1, 4, 4, 1]}, {@code block_shape = [2, 2]}, and
 *      {@code paddings = [[0, 0], [0, 0]]}:
 * 
 *  <pre>{@code
 *  x = [[[[1],   [2],  [3],  [4]],
 *        [[5],   [6],  [7],  [8]],
 *        [[9],  [10], [11],  [12]],
 *        [[13], [14], [15],  [16]]]]
 *  }</pre>
 * 
 *  The output tensor has shape {@code [4, 2, 2, 1]} and value:
 * 
 *  <pre>{@code
 *  x = [[[[1], [3]], [[9], [11]]],
 *       [[[2], [4]], [[10], [12]]],
 *       [[[5], [7]], [[13], [15]]],
 *       [[[6], [8]], [[14], [16]]]]
 *  }</pre>
 * 
 *  (4) For the following input of shape {@code [2, 2, 4, 1]}, block_shape = {@code [2, 2]}, and
 *      paddings = {@code [[0, 0], [2, 0]]}:
 * 
 *  <pre>{@code
 *  x = [[[[1],   [2],  [3],  [4]],
 *        [[5],   [6],  [7],  [8]]],
 *       [[[9],  [10], [11],  [12]],
 *        [[13], [14], [15],  [16]]]]
 *  }</pre>
 * 
 *  The output tensor has shape {@code [8, 1, 3, 1]} and value:
 * 
 *  <pre>{@code
 *  x = [[[[0], [1], [3]]], [[[0], [9], [11]]],
 *       [[[0], [2], [4]]], [[[0], [10], [12]]],
 *       [[[0], [5], [7]]], [[[0], [13], [15]]],
 *       [[[0], [6], [8]]], [[[0], [14], [16]]]]
 *  }</pre>
 * 
 *  Among others, this operation is useful for reducing atrous convolution into
 *  regular convolution.
 * 
 *  Returns:
 *  * {@code Output}: The output tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class SpaceToBatchND extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SpaceToBatchND(Pointer p) { super(p); }

  public SpaceToBatchND(@Const @ByRef Scope scope, @ByVal Input input,
                 @ByVal Input block_shape, @ByVal Input paddings) { super((Pointer)null); allocate(scope, input, block_shape, paddings); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input input,
                 @ByVal Input block_shape, @ByVal Input paddings);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public native @ByRef Operation operation(); public native SpaceToBatchND operation(Operation setter);
  public native @ByRef Output output(); public native SpaceToBatchND output(Output setter);
}
