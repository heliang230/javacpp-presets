// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;
  // namespace tensorflow

@NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TFE_TraceContext extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TFE_TraceContext(Pointer p) { super(p); }

  @MemberGetter public native TF_Graph graph();

  public native @Cast("unsigned int") int node_counter(); public native TFE_TraceContext node_counter(int setter);
  // Each tensor handle will have its ref count incremented when it's added as a
  // map key, and decremented when this object is destroyed.
  public native @ByRef TF_OutputTensorHandleMap input_tensor_map(); public native TFE_TraceContext input_tensor_map(TF_OutputTensorHandleMap setter);
  public native TensorHandleTF_OutputPairVector input_tensors(); public native TFE_TraceContext input_tensors(TensorHandleTF_OutputPairVector setter);

  public TFE_TraceContext(TF_Graph graph) { super((Pointer)null); allocate(graph); }
  private native void allocate(TF_Graph graph);
}
