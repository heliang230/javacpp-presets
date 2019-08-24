// Targeted by JavaCPP version 1.5.2-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nppicom;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;
import org.bytedeco.cuda.nppc.*;
import static org.bytedeco.cuda.global.nppc.*;

import static org.bytedeco.cuda.global.nppicom.*;
 

/** JPEG scan descriptor */
@Properties(inherit = org.bytedeco.cuda.presets.nppicom.class)
public class NppiJpegScanDescr extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public NppiJpegScanDescr() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public NppiJpegScanDescr(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NppiJpegScanDescr(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public NppiJpegScanDescr position(long position) {
        return (NppiJpegScanDescr)super.position(position);
    }

    /** Number of components present in scan */
    public native @Cast("Npp8u") byte nComponents(); public native NppiJpegScanDescr nComponents(byte setter);
    /** Frame-indexes of components.
            These values will be used to index arrays in \ref NppiJpegFrameDescr */
    public native @Cast("Npp8u") byte aComponentIdx(int i); public native NppiJpegScanDescr aComponentIdx(int i, byte setter);
    @MemberGetter public native @Cast("Npp8u*") BytePointer aComponentIdx();
    /** DC Huffman table selector per component */
    public native @Cast("Npp8u") byte aComponentDcHtSel(int i); public native NppiJpegScanDescr aComponentDcHtSel(int i, byte setter);
    @MemberGetter public native @Cast("Npp8u*") BytePointer aComponentDcHtSel();
    /** AC Huffman table selector per component */
    public native @Cast("Npp8u") byte aComponentAcHtSel(int i); public native NppiJpegScanDescr aComponentAcHtSel(int i, byte setter);
    @MemberGetter public native @Cast("Npp8u*") BytePointer aComponentAcHtSel();
    /** Pointers to DC Huffman table description in the raw format
            (the same format as used in JPEG header).
            This array will be indexed by \ref aComponentDcHtSel. Pointers for
            tables unused in scan may be set to NULL. */
    public native @Cast("const Npp8u*") BytePointer apRawDcHtTable(int i); public native NppiJpegScanDescr apRawDcHtTable(int i, BytePointer setter);
    @MemberGetter public native @Cast("const Npp8u**") PointerPointer apRawDcHtTable();
    /** See \ref apRawDcHtTable */
    public native @Cast("const Npp8u*") BytePointer apRawAcHtTable(int i); public native NppiJpegScanDescr apRawAcHtTable(int i, BytePointer setter);
    @MemberGetter public native @Cast("const Npp8u**") PointerPointer apRawAcHtTable();
    /** Start of spectral selection (index of first coefficient), 0-63 */
    public native @Cast("Npp8u") byte nSs(); public native NppiJpegScanDescr nSs(byte setter);
    /** End of spectral selection (index of first coefficient), 0-63 */
    public native @Cast("Npp8u") byte nSe(); public native NppiJpegScanDescr nSe(byte setter);
    /** Successive approximation bit position high */
    public native @Cast("Npp8u") byte nAh(); public native NppiJpegScanDescr nAh(byte setter);
    /** Successive approximation bit position low */
    public native @Cast("Npp8u") byte nAl(); public native NppiJpegScanDescr nAl(byte setter);
    /** Restart interval in MCUs. Use 0 or -1 when none */
    public native @Cast("Npp32s") int restartInterval(); public native NppiJpegScanDescr restartInterval(int setter);
    /** Length of compressed (encoded) scan data */
    public native @Cast("Npp32s") int length(); public native NppiJpegScanDescr length(int setter);
}
