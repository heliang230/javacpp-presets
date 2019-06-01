// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


////////////////////////////////////////////////////////////////////////////////
//
// Wrapper classes for the `MasterService.RunStep` response message.
//
// The `RunStepResponse` message can contain potentially large tensor
// data as part of its `tensor` submessages. Here we provide specialized
// wrappers that avoid copying the tensor data wherever possible.
//
// See `RunStepResponse` in tensorflow/core/protobuf/master.proto for the
// protocol buffer definition.
//
////////////////////////////////////////////////////////////////////////////////

// Abstract interface for a mutable RunStepResponse message.
//
// Note that there is no corresponding (immutable)
// RunStepResponseWrapper class, because the RunStepResponse object is
// always used as a mutable pointer.
@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class MutableRunStepResponseWrapper extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MutableRunStepResponseWrapper(Pointer p) { super(p); }


  // The values of the tensors whose fetching was requested in the
  // RunStep call.
  //
  // NOTE: The order of the returned tensors may or may not match
  // the fetch order specified in RunStepRequest.
  public native @Cast("size_t") long num_tensors();
  public native @StdString BytePointer tensor_name(@Cast("size_t") long i);
  public native @ByVal Status TensorValue(@Cast("size_t") long i, Tensor out_tensor);

  // Stores the i^{th} recv value in `run_graph_response` in this
  // response with the given `name`.
  public native @ByVal Status AddTensorFromRunGraphResponse(
        @StdString BytePointer name, MutableRunGraphResponseWrapper run_graph_response,
        @Cast("size_t") long i);
  public native @ByVal Status AddTensorFromRunGraphResponse(
        @StdString String name, MutableRunGraphResponseWrapper run_graph_response,
        @Cast("size_t") long i);

  // Returned metadata if requested in the options.
  public native @Const @ByRef RunMetadata metadata();
  public native RunMetadata mutable_metadata();

  // Returned status if requested.
  public native @Cast("tensorflow::errors::Code") int status_code();
  public native @StdString BytePointer status_error_message();
  public native void set_status(@Const @ByRef Status status);
}
