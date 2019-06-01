// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** \brief A file abstraction for sequential writing.
 * 
 *  The implementation must provide buffering since callers may append
 *  small fragments at a time to the file. */
@Namespace("tensorflow") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class WritableFile extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public WritableFile(Pointer p) { super(p); }


  /** \brief Append 'data' to the file. */
  
  ///
  ///
  public native @ByVal Status Append(@StringPiece BytePointer data);
  public native @ByVal Status Append(@StringPiece String data);

  // TODO(ebrevdo): Remove this ifdef when absl is updated.
// #if defined(PLATFORM_GOOGLE)
// #endif

  /** \brief Close the file.
   * 
   *  Flush() and de-allocate resources associated with this file
   * 
   *  Typical return codes (not guaranteed to be exhaustive):
   *   * OK
   *   * Other codes, as returned from Flush() */
  
  ///
  ///
  public native @ByVal Status Close();

  /** \brief Flushes the file and optionally syncs contents to filesystem.
   * 
   *  This should flush any local buffers whose contents have not been
   *  delivered to the filesystem.
   * 
   *  If the process terminates after a successful flush, the contents
   *  may still be persisted, since the underlying filesystem may
   *  eventually flush the contents.  If the OS or machine crashes
   *  after a successful flush, the contents may or may not be
   *  persisted, depending on the implementation. */
  
  ///
  public native @ByVal Status Flush();

  // \brief Returns the name of the file.
  /**
   *  This is an optional operation that may not be implemented by every
   *  filesystem. */
  
  ///
  public native @ByVal Status Name(@StringPiece @Cast({"char*", "StringPiece*"}) BytePointer result);

  /** \brief Syncs contents of file to filesystem.
   * 
   *  This waits for confirmation from the filesystem that the contents
   *  of the file have been persisted to the filesystem; if the OS
   *  or machine crashes after a successful Sync, the contents should
   *  be properly saved. */
  
  ///
  public native @ByVal Status Sync();

  /** \brief Retrieves the current write position in the file, or -1 on
   *  error.
   * 
   *  This is an optional operation, subclasses may choose to return
   *  errors::Unimplemented. */
  public native @ByVal Status Tell(@Cast("tensorflow::int64*") LongPointer position);
  public native @ByVal Status Tell(@Cast("tensorflow::int64*") LongBuffer position);
  public native @ByVal Status Tell(@Cast("tensorflow::int64*") long... position);
}
