// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;
  // namespace internal

// Interface to light weight protocol messages.
//
// This interface is implemented by all protocol message objects.  Non-lite
// messages additionally implement the Message interface, which is a
// subclass of MessageLite.  Use MessageLite instead when you only need
// the subset of features which it supports -- namely, nothing that uses
// descriptors or reflection.  You can instruct the protocol compiler
// to generate classes which implement only MessageLite, not the full
// Message interface, by adding the following line to the .proto file:
//
//   option optimize_for = LITE_RUNTIME;
//
// This is particularly useful on resource-constrained systems where
// the full protocol buffers runtime library is too big.
//
// Note that on non-constrained systems (e.g. servers) when you need
// to link in lots of protocol definitions, a better way to reduce
// total code footprint is to use optimize_for = CODE_SIZE.  This
// will make the generated code smaller while still supporting all the
// same features (at the expense of speed).  optimize_for = LITE_RUNTIME
// is best when you only have a small number of message types linked
// into your binary, in which case the size of the protocol buffers
// runtime itself is the biggest problem.
@Namespace("google::protobuf") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class MessageLite extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MessageLite(Pointer p) { super(p); }


  // Basic Operations ------------------------------------------------

  // Get the name of this message type, e.g. "foo.bar.BazProto".
  public native @StdString BytePointer GetTypeName();

  // Construct a new instance of the same type.  Ownership is passed to the
  // caller.
  public native MessageLite New();

  // Construct a new instance on the arena. Ownership is passed to the caller
  // if arena is a NULL. Default implementation for backwards compatibility.
  public native MessageLite New(Arena arena);

  // Get the arena, if any, associated with this message. Virtual method
  // required for generic operations but most arena-related operations should
  // use the GetArenaNoVirtual() generated-code method. Default implementation
  // to reduce code size by avoiding the need for per-type implementations
  // when types do not implement arena support.
  public native Arena GetArena();

  // Get a pointer that may be equal to this message's arena, or may not be.
  // If the value returned by this method is equal to some arena pointer, then
  // this message is on that arena; however, if this message is on some arena,
  // this method may or may not return that arena's pointer. As a tradeoff,
  // this method may be more efficient than GetArena(). The intent is to allow
  // underlying representations that use e.g. tagged pointers to sometimes
  // store the arena pointer directly, and sometimes in a more indirect way,
  // and allow a fastpath comparison against the arena pointer when it's easy
  // to obtain.
  public native Pointer GetMaybeArenaPointer();

  // Clear all fields of the message and set them to their default values.
  // Clear() avoids freeing memory, assuming that any memory allocated
  // to hold parts of the message will be needed again to hold the next
  // message.  If you actually want to free the memory used by a Message,
  // you must delete it.
  public native void Clear();

  // Quickly check if all required fields have values set.
  public native @Cast("bool") boolean IsInitialized();

  // This is not implemented for Lite messages -- it just returns "(cannot
  // determine missing fields for lite message)".  However, it is implemented
  // for full messages.  See message.h.
  public native @StdString BytePointer InitializationErrorString();

  // If |other| is the exact same class as this, calls MergeFrom(). Otherwise,
  // results are undefined (probably crash).
  public native void CheckTypeAndMergeFrom(@Const @ByRef MessageLite other);

  // Parsing ---------------------------------------------------------
  // Methods for parsing in protocol buffer format.  Most of these are
  // just simple wrappers around MergeFromCodedStream().  Clear() will be
  // called before merging the input.

  // Fill the message with a protocol buffer parsed from the given input
  // stream. Returns false on a read error or if the input is in the wrong
  // format.  A successful return does not indicate the entire input is
  // consumed, ensure you call ConsumedEntireMessage() to check that if
  // applicable.
  public native @Cast("bool") boolean ParseFromCodedStream(CodedInputStream input);
  // Like ParseFromCodedStream(), but accepts messages that are missing
  // required fields.
  public native @Cast("bool") boolean ParsePartialFromCodedStream(CodedInputStream input);
  // Read a protocol buffer from the given zero-copy input stream.  If
  // successful, the entire input will be consumed.
  public native @Cast("bool") boolean ParseFromZeroCopyStream(ZeroCopyInputStream input);
  // Like ParseFromZeroCopyStream(), but accepts messages that are missing
  // required fields.
  public native @Cast("bool") boolean ParsePartialFromZeroCopyStream(ZeroCopyInputStream input);
  // Read a protocol buffer from the given zero-copy input stream, expecting
  // the message to be exactly "size" bytes long.  If successful, exactly
  // this many bytes will have been consumed from the input.
  public native @Cast("bool") boolean MergePartialFromBoundedZeroCopyStream(ZeroCopyInputStream input, int size);
  // Like ParseFromBoundedZeroCopyStream(), but accepts messages that are
  // missing required fields.
  public native @Cast("bool") boolean MergeFromBoundedZeroCopyStream(ZeroCopyInputStream input,
                                               int size);
  public native @Cast("bool") boolean ParseFromBoundedZeroCopyStream(ZeroCopyInputStream input, int size);
  // Like ParseFromBoundedZeroCopyStream(), but accepts messages that are
  // missing required fields.
  public native @Cast("bool") boolean ParsePartialFromBoundedZeroCopyStream(ZeroCopyInputStream input,
                                               int size);
  // Parses a protocol buffer contained in a string. Returns true on success.
  // This function takes a string in the (non-human-readable) binary wire
  // format, matching the encoding output by MessageLite::SerializeToString().
  // If you'd like to convert a human-readable string into a protocol buffer
  // object, see google::protobuf::TextFormat::ParseFromString().
  public native @Cast("bool") boolean ParseFromString(@StdString BytePointer data);
  public native @Cast("bool") boolean ParseFromString(@StdString String data);
  // Like ParseFromString(), but accepts messages that are missing
  // required fields.
  public native @Cast("bool") boolean ParsePartialFromString(@StdString BytePointer data);
  public native @Cast("bool") boolean ParsePartialFromString(@StdString String data);
  // Parse a protocol buffer contained in an array of bytes.
  public native @Cast("bool") boolean ParseFromArray(@Const Pointer data, int size);
  // Like ParseFromArray(), but accepts messages that are missing
  // required fields.
  public native @Cast("bool") boolean ParsePartialFromArray(@Const Pointer data, int size);


  // Reads a protocol buffer from the stream and merges it into this
  // Message.  Singular fields read from the what is
  // already in the Message and repeated fields are appended to those
  // already present.
  //
  // It is the responsibility of the caller to call input->LastTagWas()
  // (for groups) or input->ConsumedEntireMessage() (for non-groups) after
  // this returns to verify that the message's end was delimited correctly.
  //
  // ParsefromCodedStream() is implemented as Clear() followed by
  // MergeFromCodedStream().
  public native @Cast("bool") boolean MergeFromCodedStream(CodedInputStream input);

  // Like MergeFromCodedStream(), but succeeds even if required fields are
  // missing in the input.
  //
  // MergeFromCodedStream() is just implemented as MergePartialFromCodedStream()
  // followed by IsInitialized().
// #if GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER
// #else
  public native @Cast("bool") boolean MergePartialFromCodedStream(CodedInputStream input);
// #endif  // GOOGLE_PROTOBUF_ENABLE_EXPERIMENTAL_PARSER

  // Merge a protocol buffer contained in a string.
  public native @Cast("bool") boolean MergeFromString(@StdString BytePointer data);
  public native @Cast("bool") boolean MergeFromString(@StdString String data);


  // Serialization ---------------------------------------------------
  // Methods for serializing in protocol buffer format.  Most of these
  // are just simple wrappers around ByteSize() and SerializeWithCachedSizes().

  // Write a protocol buffer of this message to the given output.  Returns
  // false on a write error.  If the message is missing required fields,
  // this may GOOGLE_CHECK-fail.
  public native @Cast("bool") boolean SerializeToCodedStream(CodedOutputStream output);
  // Like SerializeToCodedStream(), but allows missing required fields.
  public native @Cast("bool") boolean SerializePartialToCodedStream(CodedOutputStream output);
  // Write the message to the given zero-copy output stream.  All required
  // fields must be set.
  public native @Cast("bool") boolean SerializeToZeroCopyStream(ZeroCopyOutputStream output);
  // Like SerializeToZeroCopyStream(), but allows missing required fields.
  public native @Cast("bool") boolean SerializePartialToZeroCopyStream(ZeroCopyOutputStream output);
  // Serialize the message and store it in the given string.  All required
  // fields must be set.
  public native @Cast("bool") boolean SerializeToString(@StdString @Cast({"char*", "std::string*"}) BytePointer output);
  // Like SerializeToString(), but allows missing required fields.
  public native @Cast("bool") boolean SerializePartialToString(@StdString @Cast({"char*", "std::string*"}) BytePointer output);
  // Serialize the message and store it in the given byte array.  All required
  // fields must be set.
  public native @Cast("bool") boolean SerializeToArray(Pointer data, int size);
  // Like SerializeToArray(), but allows missing required fields.
  public native @Cast("bool") boolean SerializePartialToArray(Pointer data, int size);

  // Make a string encoding the message. Is equivalent to calling
  // SerializeToString() on a string and using that.  Returns the empty
  // string if SerializeToString() would have returned an error.
  // Note: If you intend to generate many such strings, you may
  // reduce heap fragmentation by instead re-using the same string
  // object with calls to SerializeToString().
  public native @StdString BytePointer SerializeAsString();
  // Like SerializeAsString(), but allows missing required fields.
  public native @StdString BytePointer SerializePartialAsString();

  // Like SerializeToString(), but appends to the data to the string's existing
  // contents.  All required fields must be set.
  public native @Cast("bool") boolean AppendToString(@StdString @Cast({"char*", "std::string*"}) BytePointer output);
  // Like AppendToString(), but allows missing required fields.
  public native @Cast("bool") boolean AppendPartialToString(@StdString @Cast({"char*", "std::string*"}) BytePointer output);

  // Computes the serialized size of the message.  This recursively calls
  // ByteSizeLong() on all embedded messages.
  //
  // ByteSizeLong() is generally linear in the number of fields defined for the
  // proto.
  public native @Cast("size_t") long ByteSizeLong();

  // Legacy ByteSize() API.
  public native int ByteSize();

  // Serializes the message without recomputing the size.  The message must not
  // have changed since the last call to ByteSize(), and the value returned by
  // ByteSize must be non-negative.  Otherwise the results are undefined.
  public native void SerializeWithCachedSizes(
        CodedOutputStream output);

  // Functions below here are not part of the public interface.  It isn't
  // enforced, but they should be treated as private, and will be private
  // at some future time.  Unfortunately the implementation of the "friend"
  // keyword in GCC is broken at the moment, but we expect it will be fixed.

  // Like SerializeWithCachedSizes, but writes directly to *target, returning
  // a pointer to the byte immediately after the last byte written.  "target"
  // must point at a byte array of at least ByteSize() bytes.  Whether to use
  // deterministic serialization, e.g., maps in sorted order, is determined by
  // CodedOutputStream::IsDefaultSerializationDeterministic().
  public native @Cast("google::protobuf::uint8*") BytePointer SerializeWithCachedSizesToArray(@Cast("google::protobuf::uint8*") BytePointer target);
  public native @Cast("google::protobuf::uint8*") ByteBuffer SerializeWithCachedSizesToArray(@Cast("google::protobuf::uint8*") ByteBuffer target);
  public native @Cast("google::protobuf::uint8*") byte[] SerializeWithCachedSizesToArray(@Cast("google::protobuf::uint8*") byte[] target);

  // Returns the result of the last call to ByteSize().  An embedded message's
  // size is needed both to serialize it (because embedded messages are
  // length-delimited) and to compute the outer message's size.  Caching
  // the size avoids computing it multiple times.
  //
  // ByteSize() does not automatically use the cached size when available
  // because this would require invalidating it every time the message was
  // modified, which would be too hard and expensive.  (E.g. if a deeply-nested
  // sub-message is changed, all of its parents' cached sizes would need to be
  // invalidated, which is too much work for an otherwise inlined setter
  // method.)
  public native int GetCachedSize();
  /** enum google::protobuf::MessageLite::ParseFlags */
  public static final int
    kMerge = 0,
    kParse = 1,
    kMergePartial = 2,
    kParsePartial = 3,
    kMergeWithAliasing = 4,
    kParseWithAliasing = 5,
    kMergePartialWithAliasing = 6,
    kParsePartialWithAliasing = 7;
  // TODO(gerbens) make this a pure abstract function
  public native @Cast("google::protobuf::uint8*") BytePointer InternalSerializeWithCachedSizesToArray(@Cast("google::protobuf::uint8*") BytePointer target);
  public native @Cast("google::protobuf::uint8*") ByteBuffer InternalSerializeWithCachedSizesToArray(@Cast("google::protobuf::uint8*") ByteBuffer target);
  public native @Cast("google::protobuf::uint8*") byte[] InternalSerializeWithCachedSizesToArray(@Cast("google::protobuf::uint8*") byte[] target);
}
