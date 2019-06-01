// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// A class that devices can subclass to pass around
// Device-specific context to OpKernels.
@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class DeviceContext extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public DeviceContext() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DeviceContext(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DeviceContext(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public DeviceContext position(long position) {
        return (DeviceContext)super.position(position);
    }

  public native Stream stream();
  public native void MaintainLifetimeOnStream(@Const Tensor t,
                                          Stream stream);

  // "cpu_tensor" is a tensor on a CPU. Copies "cpu_tensor" into
  // "device_tensor" which is on a non-CPU device "device". "device_tensor"
  // must be allocated to be of the same size as "cpu_tensor".
  public native void CopyCPUTensorToDevice(@Const Tensor cpu_tensor, Device device,
                                       Tensor device_tensor, @ByVal @Cast("tensorflow::StatusCallback*") Pointer done,
                                       @Cast("bool") boolean sync_dst_compute/*=true*/);
  public native void CopyCPUTensorToDevice(@Const Tensor cpu_tensor, Device device,
                                       Tensor device_tensor, @ByVal @Cast("tensorflow::StatusCallback*") Pointer done);

  // Copies a tensor in this device.
  public native void CopyTensorInSameDevice(@Const Tensor input_tensor,
                                        Device device, Tensor output_tensor,
                                        @ByVal @Cast("tensorflow::StatusCallback*") Pointer done);

  // "device_tensor" is a tensor on a non-CPU device.  Copies
  // device_tensor into "cpu_tensor".  "cpu_tensor" must be allocated
  // to be of the same size as "device_tensor".
  public native void CopyDeviceTensorToCPU(@Const Tensor device_tensor,
                                       @StringPiece BytePointer tensor_name, Device device,
                                       Tensor cpu_tensor, @ByVal @Cast("tensorflow::StatusCallback*") Pointer done);
  public native void CopyDeviceTensorToCPU(@Const Tensor device_tensor,
                                       @StringPiece String tensor_name, Device device,
                                       Tensor cpu_tensor, @ByVal @Cast("tensorflow::StatusCallback*") Pointer done);

  // If possible, wait for all events on *stream to complete then execute func.
  // A non-OK Status is returned otherwise.  The stream argument should be the
  // one provided by GpuDeviceInfo.  This function is not applicable to devices
  // that don't provide such a value.
  public native @ByVal Status ThenExecute(Device device, Stream stream,
                               @ByVal Fn func);
}
