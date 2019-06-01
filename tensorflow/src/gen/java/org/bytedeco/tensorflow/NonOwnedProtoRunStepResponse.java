// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// Proto-based message wrapper for use on the server side of the RunStep RPC.
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class NonOwnedProtoRunStepResponse extends MutableRunStepResponseWrapper {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NonOwnedProtoRunStepResponse(Pointer p) { super(p); }

  public NonOwnedProtoRunStepResponse(RunStepResponse response) { super((Pointer)null); allocate(response); }
  private native void allocate(RunStepResponse response);

  // MutableRunStepResponseWrapper methods.
  public native @Cast("size_t") long num_tensors();
  public native @StdString BytePointer tensor_name(@Cast("size_t") long i);
  public native @ByVal Status TensorValue(@Cast("size_t") long i, Tensor out_tensor);
  public native @ByVal Status AddTensorFromRunGraphResponse(
        @StdString BytePointer name, MutableRunGraphResponseWrapper run_graph_response,
        @Cast("size_t") long i);
  public native @ByVal Status AddTensorFromRunGraphResponse(
        @StdString String name, MutableRunGraphResponseWrapper run_graph_response,
        @Cast("size_t") long i);
  public native @Const @ByRef RunMetadata metadata();
  public native RunMetadata mutable_metadata();
  public native @Cast("tensorflow::errors::Code") int status_code();
  public native @StdString BytePointer status_error_message();
  public native void set_status(@Const @ByRef Status status);
}
