// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::internal") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class DictionaryMemoTable extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DictionaryMemoTable(Pointer p) { super(p); }

  public DictionaryMemoTable(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type) { super((Pointer)null); allocate(type); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type);
  public DictionaryMemoTable(@Const @SharedPtr @ByRef Array dictionary) { super((Pointer)null); allocate(dictionary); }
  private native void allocate(@Const @SharedPtr @ByRef Array dictionary);

  public native int GetOrInsert(@Cast("const bool") boolean value);
  public native int GetOrInsert(byte value);
  public native int GetOrInsert(short value);
  public native int GetOrInsert(int value);
  public native int GetOrInsert(@Cast("const int64_t") long value);
  public native int GetOrInsert(float value);
  public native int GetOrInsert(double value);

  public native @ByVal Status GetArrayData(MemoryPool pool, @Cast("int64_t") long start_offset,
                        @SharedPtr ArrayData out);

  /** \brief Insert new memo values */
  public native @ByVal Status InsertValues(@Const @ByRef Array values);

  public native int size();
}
