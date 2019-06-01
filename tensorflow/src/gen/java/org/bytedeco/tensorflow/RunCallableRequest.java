// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

// -------------------------------------------------------------------

@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class RunCallableRequest extends MessageLite {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RunCallableRequest(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public RunCallableRequest(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public RunCallableRequest position(long position) {
        return (RunCallableRequest)super.position(position);
    }

  public RunCallableRequest() { super((Pointer)null); allocate(); }
  private native void allocate();

  public RunCallableRequest(@Const @ByRef RunCallableRequest from) { super((Pointer)null); allocate(from); }
  private native void allocate(@Const @ByRef RunCallableRequest from);

  public native @ByRef @Name("operator =") RunCallableRequest put(@Const @ByRef RunCallableRequest from);
//   #if LANG_CXX11
//   #endif
  public native Arena GetArena();
  public native Pointer GetMaybeArenaPointer();
  public static native @Cast("const google::protobuf::Descriptor*") Pointer descriptor();
  public static native @Const @ByRef RunCallableRequest default_instance();

  public static native void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  public static native @Const RunCallableRequest internal_default_instance();
  @MemberGetter public static native int kIndexInFileMessages();
  public static final int kIndexInFileMessages = kIndexInFileMessages();

  public native void UnsafeArenaSwap(RunCallableRequest other);
  public native void Swap(RunCallableRequest other);
  

  // implements Message ----------------------------------------------

  public native RunCallableRequest New();

  public native RunCallableRequest New(Arena arena);
  public native void CopyFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void MergeFrom(@Cast("const google::protobuf::Message*") @ByRef MessageLite from);
  public native void CopyFrom(@Const @ByRef RunCallableRequest from);
  public native void MergeFrom(@Const @ByRef RunCallableRequest from);
  public native void Clear();
  public native @Cast("bool") boolean IsInitialized();

  public native @Cast("size_t") long ByteSizeLong();
//   #if GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER
//   #else
  public native @Cast("bool") boolean MergePartialFromCodedStream(
        CodedInputStream input);
//   #endif  // GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER
  public native void SerializeWithCachedSizes(
        CodedOutputStream output);
  public native @Cast("google::protobuf::uint8*") BytePointer InternalSerializeWithCachedSizesToArray(
        @Cast("google::protobuf::uint8*") BytePointer target);
  public native @Cast("google::protobuf::uint8*") ByteBuffer InternalSerializeWithCachedSizesToArray(
        @Cast("google::protobuf::uint8*") ByteBuffer target);
  public native @Cast("google::protobuf::uint8*") byte[] InternalSerializeWithCachedSizesToArray(
        @Cast("google::protobuf::uint8*") byte[] target);
  public native int GetCachedSize();

  public native @ByVal @Cast("google::protobuf::Metadata*") Pointer GetMetadata();

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // repeated .tensorflow.TensorProto feed = 3;
  public native int feed_size();
  public native void clear_feed();
  @MemberGetter public static native int kFeedFieldNumber();
  public static final int kFeedFieldNumber = kFeedFieldNumber();
  public native TensorProto mutable_feed(int index);
  public native @Const @ByRef TensorProto feed(int index);
  public native TensorProto add_feed();

  // string session_handle = 1;
  public native void clear_session_handle();
  @MemberGetter public static native int kSessionHandleFieldNumber();
  public static final int kSessionHandleFieldNumber = kSessionHandleFieldNumber();
  public native @StdString BytePointer session_handle();
  public native void set_session_handle(@StdString BytePointer value);
  public native void set_session_handle(@StdString String value);
//   #if LANG_CXX11
//   #endif
  public native void set_session_handle(@Cast("const char*") BytePointer value, @Cast("size_t") long size);
  public native void set_session_handle(String value, @Cast("size_t") long size);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer mutable_session_handle();
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer release_session_handle();
  public native void set_allocated_session_handle(@StdString @Cast({"char*", "std::string*"}) BytePointer session_handle);
  public native @StdString @Cast({"char*", "std::string*"}) BytePointer unsafe_arena_release_session_handle();
  public native void unsafe_arena_set_allocated_session_handle(
        @StdString @Cast({"char*", "std::string*"}) BytePointer session_handle);

  // int64 handle = 2;
  public native void clear_handle();
  @MemberGetter public static native int kHandleFieldNumber();
  public static final int kHandleFieldNumber = kHandleFieldNumber();
  public native @Cast("google::protobuf::int64") long handle();
  public native void set_handle(@Cast("google::protobuf::int64") long value);

  // int64 request_id = 4;
  public native void clear_request_id();
  @MemberGetter public static native int kRequestIdFieldNumber();
  public static final int kRequestIdFieldNumber = kRequestIdFieldNumber();
  public native @Cast("google::protobuf::int64") long request_id();
  public native void set_request_id(@Cast("google::protobuf::int64") long value);
}
