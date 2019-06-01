// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Solves systems of linear equations with upper or lower triangular matrices by backsubstitution.
 * 
 * 
 *  {@code matrix} is a tensor of shape {@code [..., M, M]} whose inner-most 2 dimensions form
 *  square matrices. If {@code lower} is {@code True} then the strictly upper triangular part
 *  of each inner-most matrix is assumed to be zero and not accessed.
 *  If {@code lower} is False then the strictly lower triangular part of each inner-most
 *  matrix is assumed to be zero and not accessed.
 *  {@code rhs} is a tensor of shape {@code [..., M, K]}.
 * 
 *  The output is a tensor of shape {@code [..., M, K]}. If {@code adjoint} is
 *  {@code True} then the innermost matrices in {@code output} satisfy matrix equations
 *  {@code matrix[..., :, :] * output[..., :, :] = rhs[..., :, :]}.
 *  If {@code adjoint} is {@code False} then the strictly then the  innermost matrices in
 *  {@code output} satisfy matrix equations
 *  {@code adjoint(matrix[..., i, k]) * output[..., k, j] = rhs[..., i, j]}.
 * 
 *  Example:
 *  <pre>{@code python
 * 
 *  a = tf.constant([[3,  0,  0,  0],
 *                   [2,  1,  0,  0],
 *                   [1,  0,  1,  0],
 *                   [1,  1,  1,  1]], dtype=tf.float32)
 * 
 *  b = tf.constant([[4],
 *                   [2],
 *                   [4],
 *                   [2]], dtype=tf.float32)
 * 
 *  x = tf.linalg.triangular_solve(a, b, lower=True)
 *  x
 *  # <tf.Tensor: id=257, shape=(4, 1), dtype=float32, numpy=
 *  # array([[ 1.3333334 ],
 *  #        [-0.66666675],
 *  #        [ 2.6666665 ],
 *  #        [-1.3333331 ]], dtype=float32)>
 * 
 *  # in python3 one can use `a@x`
 *  tf.matmul(a, x)
 *  # <tf.Tensor: id=263, shape=(4, 1), dtype=float32, numpy=
 *  # array([[4.       ],
 *  #        [2.       ],
 *  #        [4.       ],
 *  #        [1.9999999]], dtype=float32)>
 *  }</pre>
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * matrix: Shape is {@code [..., M, M]}.
 *  * rhs: Shape is {@code [..., M, K]}.
 * 
 *  Optional attributes (see {@code Attrs}):
 *  * lower: Boolean indicating whether the innermost matrices in {@code matrix} are
 *  lower or upper triangular.
 *  * adjoint: Boolean indicating whether to solve with {@code matrix} or its (block-wise)
 *           adjoint.
 * 
 *  \compatibility(numpy)
 *  Equivalent to scipy.linalg.solve_triangular
 *  \end_compatibility
 * 
 *  Returns:
 *  * {@code Output}: Shape is {@code [..., M, K]}. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class MatrixTriangularSolve extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MatrixTriangularSolve(Pointer p) { super(p); }

  /** Optional attribute setters for MatrixTriangularSolve */
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
  
    /** Boolean indicating whether the innermost matrices in {@code matrix} are
     *  lower or upper triangular.
     * 
     *  Defaults to true */
    
    ///
    ///
    public native @ByVal Attrs Lower(@Cast("bool") boolean x);

    /** Boolean indicating whether to solve with {@code matrix} or its (block-wise)
     *           adjoint.
     * 
     *  \compatibility(numpy)
     *  Equivalent to scipy.linalg.solve_triangular
     *  \end_compatibility
     * 
     *  Defaults to false */
    public native @ByVal Attrs Adjoint(@Cast("bool") boolean x);

    public native @Cast("bool") boolean lower_(); public native Attrs lower_(boolean setter);
    public native @Cast("bool") boolean adjoint_(); public native Attrs adjoint_(boolean setter);
  }
  public MatrixTriangularSolve(@Const @ByRef Scope scope, @ByVal Input matrix, @ByVal Input rhs) { super((Pointer)null); allocate(scope, matrix, rhs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input matrix, @ByVal Input rhs);
  public MatrixTriangularSolve(@Const @ByRef Scope scope, @ByVal Input matrix, @ByVal Input rhs, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, matrix, rhs, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input matrix, @ByVal Input rhs, @Const @ByRef Attrs attrs);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public static native @ByVal Attrs Lower(@Cast("bool") boolean x);
  public static native @ByVal Attrs Adjoint(@Cast("bool") boolean x);

  public native @ByRef Operation operation(); public native MatrixTriangularSolve operation(Operation setter);
  public native @ByRef Output output(); public native MatrixTriangularSolve output(Output setter);
}
