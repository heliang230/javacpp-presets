// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;
  // namespace Eigen

@Namespace("tensorflow::thread") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class ThreadPool extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ThreadPool(Pointer p) { super(p); }

  // Constructs a pool that contains "num_threads" threads with specified
  // "name". env->StartThread() is used to create individual threads with the
  // given ThreadOptions. If "low_latency_hint" is true the thread pool
  // implementation may use it as a hint that lower latency is preferred at the
  // cost of higher CPU usage, e.g. by letting one or more idle threads spin
  // wait. Conversely, if the threadpool is used to schedule high-latency
  // operations like I/O the hint should be set to false.
  //
  // REQUIRES: num_threads > 0
  public ThreadPool(Env env, @Const @ByRef ThreadOptions thread_options, @StdString BytePointer name,
               int num_threads, @Cast("bool") boolean low_latency_hint,
               @Cast("Eigen::Allocator*") Pointer allocator/*=nullptr*/) { super((Pointer)null); allocate(env, thread_options, name, num_threads, low_latency_hint, allocator); }
  private native void allocate(Env env, @Const @ByRef ThreadOptions thread_options, @StdString BytePointer name,
               int num_threads, @Cast("bool") boolean low_latency_hint,
               @Cast("Eigen::Allocator*") Pointer allocator/*=nullptr*/);
  public ThreadPool(Env env, @Const @ByRef ThreadOptions thread_options, @StdString BytePointer name,
               int num_threads, @Cast("bool") boolean low_latency_hint) { super((Pointer)null); allocate(env, thread_options, name, num_threads, low_latency_hint); }
  private native void allocate(Env env, @Const @ByRef ThreadOptions thread_options, @StdString BytePointer name,
               int num_threads, @Cast("bool") boolean low_latency_hint);
  public ThreadPool(Env env, @Const @ByRef ThreadOptions thread_options, @StdString String name,
               int num_threads, @Cast("bool") boolean low_latency_hint,
               @Cast("Eigen::Allocator*") Pointer allocator/*=nullptr*/) { super((Pointer)null); allocate(env, thread_options, name, num_threads, low_latency_hint, allocator); }
  private native void allocate(Env env, @Const @ByRef ThreadOptions thread_options, @StdString String name,
               int num_threads, @Cast("bool") boolean low_latency_hint,
               @Cast("Eigen::Allocator*") Pointer allocator/*=nullptr*/);
  public ThreadPool(Env env, @Const @ByRef ThreadOptions thread_options, @StdString String name,
               int num_threads, @Cast("bool") boolean low_latency_hint) { super((Pointer)null); allocate(env, thread_options, name, num_threads, low_latency_hint); }
  private native void allocate(Env env, @Const @ByRef ThreadOptions thread_options, @StdString String name,
               int num_threads, @Cast("bool") boolean low_latency_hint);

  // Constructs a pool for low-latency ops that contains "num_threads" threads
  // with specified "name". env->StartThread() is used to create individual
  // threads.
  // REQUIRES: num_threads > 0
  public ThreadPool(Env env, @StdString BytePointer name, int num_threads) { super((Pointer)null); allocate(env, name, num_threads); }
  private native void allocate(Env env, @StdString BytePointer name, int num_threads);
  public ThreadPool(Env env, @StdString String name, int num_threads) { super((Pointer)null); allocate(env, name, num_threads); }
  private native void allocate(Env env, @StdString String name, int num_threads);

  // Constructs a pool for low-latency ops that contains "num_threads" threads
  // with specified "name". env->StartThread() is used to create individual
  // threads with the given ThreadOptions.
  // REQUIRES: num_threads > 0
  public ThreadPool(Env env, @Const @ByRef ThreadOptions thread_options, @StdString BytePointer name,
               int num_threads) { super((Pointer)null); allocate(env, thread_options, name, num_threads); }
  private native void allocate(Env env, @Const @ByRef ThreadOptions thread_options, @StdString BytePointer name,
               int num_threads);
  public ThreadPool(Env env, @Const @ByRef ThreadOptions thread_options, @StdString String name,
               int num_threads) { super((Pointer)null); allocate(env, thread_options, name, num_threads); }
  private native void allocate(Env env, @Const @ByRef ThreadOptions thread_options, @StdString String name,
               int num_threads);

  // Waits until all scheduled work has finished and then destroy the
  // set of threads.

  // Schedules fn() for execution in the pool of threads.
  public native void Schedule(@ByVal Fn fn);

  public native void SetStealPartitions(
        @Const @ByRef IntIntPairVector partitions);

  public native void ScheduleWithHint(@ByVal Fn fn, int start, int limit);
  // Requires 0 < block_size <= total.
  // Spawns k threads and calls fn(i*block_size, (i+1)*block_size) from the
  // ith thread (i>=0). When (i+1)*block_size > total, fn(i*block_size, total)
  // is called instead. k = NumShardsUsedByTransformRangeConcurrently(...).
  // Note that when there aren't enough threads in the pool to achieve full
  // parallelism, function calls will be automatically queued.
  public native void TransformRangeConcurrently(@Cast("const tensorflow::int64") long block_size, @Cast("const tensorflow::int64") long total,
                                    @Const @ByRef ForFn fn);

  // Returns the number of threads spawned by calling TransformRangeConcurrently
  // with these parameters.
  public native int NumShardsUsedByTransformRangeConcurrently(@Cast("const tensorflow::int64") long block_size,
                                                  @Cast("const tensorflow::int64") long total);

  // ParallelFor shards the "total" units of work assuming each unit of work
  // having roughly "cost_per_unit" cost, in cycles. Each unit of work is
  // indexed 0, 1, ..., total - 1. Each shard contains 1 or more units of work
  // and the total cost of each shard is roughly the same.
  //
  // "cost_per_unit" is an estimate of the number of CPU cycles (or nanoseconds
  // if not CPU-bound) to complete a unit of work. Overestimating creates too
  // many shards and CPU time will be dominated by per-shard overhead, such as
  // Context creation. Underestimating may not fully make use of the specified
  // parallelism.
  public native void ParallelFor(@Cast("tensorflow::int64") long total, @Cast("tensorflow::int64") long cost_per_unit,
                     @ByVal ForFn fn);

  // Shards the "total" units of work. For more details, see "ParallelFor".
  //
  // The function is passed a thread_id between 0 and NumThreads() *inclusive*.
  // This is because some work can happen on the caller thread while the threads
  // in the pool are also being used.
  //
  // The caller can allocate NumThreads() + 1 separate buffers for each thread.
  // Each thread can safely write to the buffer given by its id without
  // synchronization. However, the worker fn may be called multiple times
  // sequentially with the same id.
  //
  // At most NumThreads() unique ids will actually be used, and only a few may
  // be used for small workloads. If each buffer is expensive, the buffers
  // should be stored in an array initially filled with null, and a buffer
  // should be allocated by fn the first time that the id is used.
  public native void ParallelForWithWorkerId(
        @Cast("tensorflow::int64") long total, @Cast("tensorflow::int64") long cost_per_unit,
        @Const @ByRef ParallelForFn fn);

  // Returns the number of threads in the pool.
  public native int NumThreads();

  // Returns current thread id between 0 and NumThreads() - 1, if called from a
  // thread in the pool. Returns -1 otherwise.
  public native int CurrentThreadId();

  // If ThreadPool implementation is compatible with Eigen::ThreadPoolInterface,
  // returns a non-null pointer. The caller does not own the object the returned
  // pointer points to, and should not attempt to delete.
  public native ThreadPoolInterface AsEigenThreadPool();

  @Opaque public static class Impl extends Pointer {
      /** Empty constructor. Calls {@code super((Pointer)null)}. */
      public Impl() { super((Pointer)null); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Impl(Pointer p) { super(p); }
  }
}
