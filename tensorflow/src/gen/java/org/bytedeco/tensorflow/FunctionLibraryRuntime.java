// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

// Forward declare. Defined in common_runtime/device_mgr.h

@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class FunctionLibraryRuntime extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FunctionLibraryRuntime(Pointer p) { super(p); }


  // Instantiate a function with the given "attrs".
  //
  // Returns OK and fills in "handle" if the instantiation succeeds.
  // Otherwise returns an error and "handle" is undefined.
  public static class InstantiateOptions extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public InstantiateOptions() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public InstantiateOptions(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public InstantiateOptions(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public InstantiateOptions position(long position) {
          return (InstantiateOptions)super.position(position);
      }
  
    // The canonical device name of the device on which the function
    // should be instantiated. If empty, the function will be
    // instantiated on the local device.
    public native @StdString BytePointer target(); public native InstantiateOptions target(BytePointer setter);

    // Should the function be instantiated as a multi-device function?
    public native @Cast("bool") boolean is_multi_device_function(); public native InstantiateOptions is_multi_device_function(boolean setter);

    // For multi-device functions, a vector of canonical device names for
    // function's inputs. The device of resource inputs must be the device
    // backing the resource, not the CPU device backing the resource handle.
    // Must have the same length as number of inputs to the function.
    public native @ByRef StringVector input_devices(); public native InstantiateOptions input_devices(StringVector setter);

    // For multi-device functions, a vector of canonical device names for
    // function's outputs. The device of resource outputs should be the CPU
    // device, not the device backing the resource.
    // If specified, must have the same length as the number of function
    // outputs.
    // If not specified, output devices are picked automatically. If operations
    // producing the output tensors have explicit device specification, they
    // will be respected. These device specifications must identify a unique
    // device, i.e.  a general specification like "job:foo" matching multiple
    // devices will result in an error.
    public native @ByRef StringVector output_devices(); public native InstantiateOptions output_devices(StringVector setter);

    // This interface is EXPERIMENTAL and subject to change.
    //
    // For multi-device functions, a mapping from _Arg node index to input
    // tensor shape.
    // REQUIRES: if input_tensor_shapes.count(i) > 0 then i-th argument type
    // must not be DT_RESOURCE.
    public native @ByRef IntTensorShapeMap input_tensor_shapes(); public native InstantiateOptions input_tensor_shapes(IntTensorShapeMap setter);

    // This interface is EXPERIMENTAL and subject to change.
    //
    // For multi-device functions, a mapping from _Arg node index to type and
    // shape for input resources.
    // REQUIRES: if input_resource_dtypes_and_shapes.count(i) > 0 then i-th
    // argument type must be DT_RESOURCE.
    public native @ByRef IntDataTypeTensorShapePairMap input_resource_dtypes_and_shapes(); public native InstantiateOptions input_resource_dtypes_and_shapes(IntDataTypeTensorShapePairMap setter);

    // This interface is EXPERIMENTAL and subject to change.
    //
    // If non-null, the runtime will use `lib_def` to resolve function(s) named
    // in `function_name` and `attrs`. Otherwise, the runtime will use its
    // internal library.
    //
    // NOTE(mrry): If provided, all functions defined in `lib_def` must be
    // self-contained, and cannot refer to functions defined in other libraries.
    public native @Const FunctionLibraryDefinition lib_def(); public native InstantiateOptions lib_def(FunctionLibraryDefinition setter);

    // This interface is EXPERIMENTAL and subject to change.
    //
    // If non-empty, the runtime will use `state_handle` to identify
    // cached state related the instantiated function. Two functions
    // of the same name and attrs, instantiated with the same
    // `state_handle` will have the same handle and share the same
    // state (in stateful kernels); and two functions with different
    // values for `state_handle` will have independent state.
    public native @StdString BytePointer state_handle(); public native InstantiateOptions state_handle(BytePointer setter);

    // This interface is EXPERIMENTAL and subject to change.
    //
    // Instantiates the function using an executor of the given type. If empty,
    // the default TensorFlow executor will be used.
    public native @StdString BytePointer executor_type(); public native InstantiateOptions executor_type(BytePointer setter);

    // If true, the runtime will attempt to create kernels for the function at
    // instantiation time, rather than on the first run. This can be used to
    // surface errors earlier.
    public native @Cast("bool") boolean create_kernels_eagerly(); public native InstantiateOptions create_kernels_eagerly(boolean setter);

    // This interface is EXPERIMENTAL and subject to change.
    //
    // Instantiates the function with the provided config_proto.
    public native @ByRef ConfigProto config_proto(); public native InstantiateOptions config_proto(ConfigProto setter);

    // If provided, this optimization function will be invoked before
    // the placer for multi-device functions.
    @MemberSetter public native InstantiateOptions optimize_graph_fn(@ByVal OptimizeGraphFn optimize_graph_fn);

    // If set, partitioned functions will be added to `graph_collector`.
    // `graph_collector` must be alive during the call to Instantiate.
    public native GraphCollector graph_collector(); public native InstantiateOptions graph_collector(GraphCollector setter);
  }
  public native @ByVal Status Instantiate(@StdString BytePointer function_name, @ByVal AttrSlice attrs,
                               @Const @ByRef InstantiateOptions options,
                               @Cast("tensorflow::FunctionLibraryRuntime::Handle*") LongPointer handle);
  public native @ByVal Status Instantiate(@StdString String function_name, @ByVal AttrSlice attrs,
                               @Const @ByRef InstantiateOptions options,
                               @Cast("tensorflow::FunctionLibraryRuntime::Handle*") LongBuffer handle);
  public native @ByVal Status Instantiate(@StdString BytePointer function_name, @ByVal AttrSlice attrs,
                               @Const @ByRef InstantiateOptions options,
                               @Cast("tensorflow::FunctionLibraryRuntime::Handle*") long... handle);
  public native @ByVal Status Instantiate(@StdString String function_name, @ByVal AttrSlice attrs,
                               @Const @ByRef InstantiateOptions options,
                               @Cast("tensorflow::FunctionLibraryRuntime::Handle*") LongPointer handle);
  public native @ByVal Status Instantiate(@StdString BytePointer function_name, @ByVal AttrSlice attrs,
                               @Const @ByRef InstantiateOptions options,
                               @Cast("tensorflow::FunctionLibraryRuntime::Handle*") LongBuffer handle);
  public native @ByVal Status Instantiate(@StdString String function_name, @ByVal AttrSlice attrs,
                               @Const @ByRef InstantiateOptions options,
                               @Cast("tensorflow::FunctionLibraryRuntime::Handle*") long... handle);
  public native @ByVal Status Instantiate(@StdString BytePointer function_name, @ByVal AttrSlice attrs,
                       @Cast("tensorflow::FunctionLibraryRuntime::Handle*") LongPointer handle);
  public native @ByVal Status Instantiate(@StdString String function_name, @ByVal AttrSlice attrs,
                       @Cast("tensorflow::FunctionLibraryRuntime::Handle*") LongBuffer handle);
  public native @ByVal Status Instantiate(@StdString BytePointer function_name, @ByVal AttrSlice attrs,
                       @Cast("tensorflow::FunctionLibraryRuntime::Handle*") long... handle);
  public native @ByVal Status Instantiate(@StdString String function_name, @ByVal AttrSlice attrs,
                       @Cast("tensorflow::FunctionLibraryRuntime::Handle*") LongPointer handle);
  public native @ByVal Status Instantiate(@StdString BytePointer function_name, @ByVal AttrSlice attrs,
                       @Cast("tensorflow::FunctionLibraryRuntime::Handle*") LongBuffer handle);
  public native @ByVal Status Instantiate(@StdString String function_name, @ByVal AttrSlice attrs,
                       @Cast("tensorflow::FunctionLibraryRuntime::Handle*") long... handle);

  // Releases state associated with the handle.
  public native @ByVal Status ReleaseHandle(@Cast("tensorflow::FunctionLibraryRuntime::Handle") long handle);

  // Returns the function body for the instantiated function given its
  // handle 'h'. Returns nullptr if "h" is not found.
  //
  // *this keeps the ownership of the returned object, which remains alive
  // as long as *this.
  public native @Const FunctionBody GetFunctionBody(@Cast("tensorflow::FunctionLibraryRuntime::Handle") long h);

  // Returns the return types for the function identified by handle `h`.
  public native @ByVal Status GetRetTypes(@Cast("tensorflow::FunctionLibraryRuntime::Handle") long h, DataTypeVector ret_types);

  // Asynchronously invokes the instantiated function identified by
  // "handle".
  //
  // If function execution succeeds, "done" is called with OK and
  // "*rets" is filled with the function's return values. Otheriwse,
  // "done" is called with an error status.
  //
  // Does not take ownership of "rets".
  // In the cross-process scenario, runner isn't used for making the Async
  // RPC calls.
  public static class Options extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public Options() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Options(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Options(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public Options position(long position) {
          return (Options)super.position(position);
      }
  
    // Choose a step ID that is guaranteed not to clash with any
    // Session-generated step ID. DirectSession only generates
    // non-negative step IDs (contiguous, starting from 0), and
    // MasterSession generates 56-bit random step IDs whose MSB is
    // always 0, so a negative random step ID should suffice.
    @MemberGetter public native @Cast("const tensorflow::int64") long step_id();

    public native Rendezvous rendezvous(); public native Options rendezvous(Rendezvous setter);
    public native CancellationManager cancellation_manager(); public native Options cancellation_manager(CancellationManager setter);
    public native CollectiveExecutor collective_executor(); public native Options collective_executor(CollectiveExecutor setter);
    public native ScopedStepContainer step_container(); public native Options step_container(ScopedStepContainer setter);
    public native StepStatsCollectorInterface stats_collector(); public native Options stats_collector(StepStatsCollectorInterface setter);

    public native @Cast("std::function<void(std::function<void()>)>*") Pointer runner(); public native Options runner(Pointer setter);

    // Parameters for remote function execution.
    public native @Cast("bool") boolean remote_execution(); public native Options remote_execution(boolean setter);
    public native @StdString BytePointer source_device(); public native Options source_device(BytePointer setter);  // Fully specified device name.

    // Allocator attributes specifying where the args are / rets should be put.
    // These should either be {} or match the length of args / retvals. If {},
    // the default allocator attributes will be assumed for all args / retvals.
    public native @StdVector AllocatorAttributes args_alloc_attrs(); public native Options args_alloc_attrs(AllocatorAttributes setter);
    public native @StdVector AllocatorAttributes rets_alloc_attrs(); public native Options rets_alloc_attrs(AllocatorAttributes setter);

    // If true, we create a new IntraProcessRendezvous, else use the existing
    // one.
    public native @Cast("bool") boolean create_rendezvous(); public native Options create_rendezvous(boolean setter);

    // If True, allow returning dead tensors.
    public native @Cast("bool") boolean allow_dead_tensors(); public native Options allow_dead_tensors(boolean setter);

    // Returns a human readable representation of this.
    public native @StdString BytePointer DebugString();
  }
  public native void Run(@Const @ByRef Options opts, @Cast("tensorflow::FunctionLibraryRuntime::Handle") long handle,
                     @ByVal TensorVector args, TensorVector rets,
                     @ByVal @Cast("tensorflow::FunctionLibraryRuntime::DoneCallback*") Pointer done);
  public native void Run(@Const @ByRef Options opts, @Cast("tensorflow::FunctionLibraryRuntime::Handle") long handle,
                     CallFrameInterface call_frame, @ByVal @Cast("tensorflow::FunctionLibraryRuntime::DoneCallback*") Pointer done);

  // Creates a "kernel" for the given node def "ndef".
  //
  // If succeeds, returns OK and the caller takes the ownership of the
  // returned "*kernel". Otherwise, returns an error.
  public native @ByVal Status CreateKernel(@Const @ByRef NodeDef ndef, @Cast("tensorflow::OpKernel**") PointerPointer kernel);
  public native @ByVal Status CreateKernel(@Const @ByRef NodeDef ndef, @ByPtrPtr OpKernel kernel);

  // Returns true iff the function named `function_name` is stateful.
  //
  // NOTE(mrry): This method assumes that the runtime is associated with a
  // default function library, and looks up `function_name` in that library.
  // It does not support overriding the function library.
  public native @Cast("bool") boolean IsStateful(@StdString BytePointer function_name);
  public native @Cast("bool") boolean IsStateful(@StdString String function_name);

  // Returns the device on which the function executes.
  public native Device device();

  // Returns the default runner in which the ops should be launched. If the
  // device on which the function executes has a private thread pool, return
  // runner on the device local thread pool.
  public native @Cast("std::function<void(std::function<void()>)>*") Pointer runner();

  // Get the DeviceMgr from which the device was obtained.
  public native @Const DeviceMgr device_mgr();

  // Returns the function library definition that backs this runtime.
  //
  // NOTE(mrry): The returned library definition is the default function library
  // for this runtime. The caller may override the function library used by the
  // runtime to instantiate functions, which will not be reflected in the return
  // value of this function.
  public native @Const FunctionLibraryDefinition GetFunctionLibraryDefinition();

  // Returns the environment on which the function executes.
  public native Env env();

  // Returns a debug string showing the definition of the function of
  // 'handle'.
  public native @StdString BytePointer DebugString(@Cast("tensorflow::FunctionLibraryRuntime::Handle") long handle);

  // Returns the graph version number.
  public native int graph_def_version();

  // Creates a copy of ProcessFunctionLibraryRuntime (transferring ownership to
  // the caller), FunctionLibraryRuntime (owned by the returned
  // ProcessFunctionLibraryRuntime), FunctionLibraryDefinition (transferring
  // ownership to the caller). Note that both the ProcessFunctionLibraryRuntime
  // and FunctionLibraryRuntime borrow a pointer to the
  // FunctionLibraryDefinition and so the FunctionLibraryDefinition should
  // outlive both.
  //
  // The `skip_flib_def` argument controls whether the method should clone the
  // FunctionLibraryDefinition (default behavior) or return an empty function
  // library. The latter is used by tf.data, which manages
  // FunctionLibraryDefinitions for its functions independently (and passes
  // these into the FunctionLibraryRuntime through an overlay), to avoid linear
  // runtime w.r.t. to number of functions in the current function library.
  public native @ByVal Status Clone(@UniquePtr FunctionLibraryDefinition out_lib_def,
                         @UniquePtr ProcessFunctionLibraryRuntime out_pflr,
                         @Cast("tensorflow::FunctionLibraryRuntime**") PointerPointer out_flr,
                         @Cast("bool") boolean skip_flib_def/*=false*/);
  public native @ByVal Status Clone(@UniquePtr FunctionLibraryDefinition out_lib_def,
                         @UniquePtr ProcessFunctionLibraryRuntime out_pflr,
                         @ByPtrPtr FunctionLibraryRuntime out_flr);
  public native @ByVal Status Clone(@UniquePtr FunctionLibraryDefinition out_lib_def,
                         @UniquePtr ProcessFunctionLibraryRuntime out_pflr,
                         @ByPtrPtr FunctionLibraryRuntime out_flr,
                         @Cast("bool") boolean skip_flib_def/*=false*/);

  // Returns the name of the executor class (in the sense of
  // `ExecutorFactory::GetFactory()`) that will be used based on the given
  // dynamic `options` and static `attrs`. If none is specified, this method
  // will return an empty string, which leaves the decision up to the runtime.
  public static native @StdString BytePointer ExecutorType(@Const @ByRef InstantiateOptions options,
                               @ByVal AttrSlice attrs);
}
