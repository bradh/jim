package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.ADDITIONAL_DATA_COUNT_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.PIXEL_REFERENCED_DATA_SET_COUNT_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.POINT_SET_COUNT_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.TIME_STAMPED_DATA_SET_COUNT_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.TRE_TAG;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.UNCERTAINTY_DATA_COUNT_LEN;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.WriterUtils;
import net.frogmouth.rnd.jim.nitf.tre.SerialisableTaggedRecordExtension;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class SENSRB extends TaggedRecordExtension implements SerialisableTaggedRecordExtension {

    private static final int TRETAG_LEN = 6;
    private static final int TREL_LEN = 5;
    private Module1 module1;
    private Module2 module2;
    private Module3 module3;
    private Module4 module4;
    private Module5 module5;
    private Module6 module6;
    private Module7 module7;
    private Module8 module8;
    private Module9 module9;
    private Module10 module10;
    private final List<PointSet> module11 = new ArrayList<>();
    private final List<TimeStampedSet> module12 = new ArrayList<>();
    private final List<PixelReferencedDataSet> module13 = new ArrayList<>();
    private final List<Uncertainty> module14 = new ArrayList<>();
    private final List<AdditionalParameter> module15 = new ArrayList<>();

    public SENSRB() {
        super(TRE_TAG);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }

    @Override
    public byte[] toBytes() {
        byte[] bodyBytes = getBodyBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(WriterUtils.toBCS_A(TRE_TAG, TRETAG_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(bodyBytes.length, TREL_LEN));
        baos.writeBytes(bodyBytes);
        return baos.toByteArray();
    }

    public Module1 getModule1() {
        return new Module1(module1);
    }

    public void setModule1(Module1 module1) {
        this.module1 = new Module1(module1);
    }

    public Module2 getModule2() {
        if (module2 == null) {
            return null;
        }
        return new Module2(module2);
    }

    public void setModule2(Module2 module2) {
        this.module2 = new Module2(module2);
    }

    public Module3 getModule3() {
        if (module3 == null) {
            return null;
        }
        return new Module3(module3);
    }

    public void setModule3(Module3 module3) {
        this.module3 = new Module3(module3);
    }

    public Module4 getModule4() {
        if (module4 == null) {
            return null;
        }
        return new Module4(module4);
    }

    public void setModule4(Module4 module4) {
        this.module4 = new Module4(module4);
    }

    public Module5 getModule5() {
        return new Module5(module5);
    }

    public void setModule5(Module5 module5) {
        this.module5 = new Module5(module5);
    }

    public Module6 getModule6() {
        return new Module6(module6);
    }

    public void setModule6(Module6 module6) {
        this.module6 = new Module6(module6);
    }

    public Module7 getModule7() {
        if (module7 == null) {
            return null;
        }
        return new Module7(module7);
    }

    public void setModule7(Module7 module7) {
        this.module7 = new Module7(module7);
    }

    public Module8 getModule8() {
        if (module8 == null) {
            return null;
        }
        return new Module8(module8);
    }

    public void setModule8(Module8 module8) {

        this.module8 = new Module8(module8);
    }

    public Module9 getModule9() {
        if (module9 == null) {
            return null;
        }
        return new Module9(module9);
    }

    public void setModule9(Module9 module9) {
        this.module9 = new Module9(module9);
    }

    public Module10 getModule10() {
        if (module10 == null) {
            return null;
        }
        return new Module10(module10);
    }

    public void setModule10(Module10 module10) {
        this.module10 = new Module10(module10);
    }

    public List<PointSet> getModule11() {
        return new ArrayList<>(module11);
    }

    public void addPointSet(PointSet pointSet) {
        this.module11.add(pointSet);
    }

    public List<TimeStampedSet> getModule12() {
        return new ArrayList<>(module12);
    }

    public void addTimeStampedSet(TimeStampedSet timeStampedSet) {
        this.module12.add(timeStampedSet);
    }

    public List<PixelReferencedDataSet> getModule13() {
        return new ArrayList<>(module13);
    }

    public void addPixelReferencedDataSet(PixelReferencedDataSet pixelReferencedDataSet) {
        this.module13.add(pixelReferencedDataSet);
    }

    public List<Uncertainty> getModule14() {
        return new ArrayList<>(module14);
    }

    public void addUncertainty(Uncertainty uncertainty) {
        this.module14.add(uncertainty);
    }

    public List<AdditionalParameter> getModule15() {
        return new ArrayList<>(module15);
    }

    public void addAdditionalParameter(AdditionalParameter additionalParameter) {
        this.module15.add(additionalParameter);
    }

    private byte[] getBodyBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (module1 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module1.appendBytes(baos);
        }
        if (module2 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module2.appendBytes(baos);
        }
        if (module3 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module3.appendBytes(baos);
        }
        if (module4 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module4.appendBytes(baos);
        }
        if (module5 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module5.appendBytes(baos);
        }
        if (module6 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module6.appendBytes(baos);
        }
        if (module7 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module7.appendBytes(baos);
        }
        if (module8 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module8.appendBytes(baos);
        }
        if (module9 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module9.appendBytes(baos);
        }
        if (module10 == null) {
            baos.writeBytes(WriterUtils.toBCS_A("N", Constants.FLAG_LEN));
        } else {
            baos.writeBytes(WriterUtils.toBCS_A("Y", Constants.FLAG_LEN));
            module10.appendBytes(baos);
        }
        baos.writeBytes(WriterUtils.toBCS_NPI(module11.size(), POINT_SET_COUNT_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(module12.size(), TIME_STAMPED_DATA_SET_COUNT_LEN));
        baos.writeBytes(
                WriterUtils.toBCS_NPI(module13.size(), PIXEL_REFERENCED_DATA_SET_COUNT_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(module14.size(), UNCERTAINTY_DATA_COUNT_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(module15.size(), ADDITIONAL_DATA_COUNT_LEN));
        return baos.toByteArray();
    }
}
