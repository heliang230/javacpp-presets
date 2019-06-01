// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// Abstract interface for a mutable RunGraphRequest message.
//
// See `RunGraphRequestWrapper` above for a description of the fields.
@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class MutableRunGraphRequestWrapper extends RunGraphRequestWrapper {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MutableRunGraphRequestWrapper(Pointer p) { super(p); }

  public native void set_session_handle(@StdString BytePointer handle);
  public native void set_session_handle(@StdString String handle);
  public native void set_create_worker_session_called(@Cast("bool") boolean called);
  public native void set_graph_handle(@StdString BytePointer handle);
  public native void set_graph_handle(@StdString String handle);
  public native void set_step_id(@Cast("tensorflow::int64") long step_id);
  public native ExecutorOpts mutable_exec_opts();

  // Stores the i^{th} feed value in `run_step_request` in this
  // request with the given `send_key`.
  public native @ByVal Status AddSendFromRunStepRequest(
        @Const @ByRef RunStepRequestWrapper run_step_request, @Cast("size_t") long i,
        @StdString BytePointer send_key);
  public native @ByVal Status AddSendFromRunStepRequest(
        @Const @ByRef RunStepRequestWrapper run_step_request, @Cast("size_t") long i,
        @StdString String send_key);
  public native @ByVal Status AddSendFromRunCallableRequest(
        @Const @ByRef RunCallableRequest run_callable_request, @Cast("size_t") long i,
        @StdString BytePointer send_key);
  public native @ByVal Status AddSendFromRunCallableRequest(
        @Const @ByRef RunCallableRequest run_callable_request, @Cast("size_t") long i,
        @StdString String send_key);

  public native void add_recv_key(@StdString BytePointer recv_key);
  public native void add_recv_key(@StdString String recv_key);
  public native void set_is_partial(@Cast("bool") boolean is_partial);
  public native void set_is_last_partial_run(@Cast("bool") boolean is_last_partial_run);
  public native void set_store_errors_in_response_body(@Cast("bool") boolean store_errors);
  public native void set_request_id(@Cast("tensorflow::int64") long request_id);
}
