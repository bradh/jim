package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.TRE_TAG;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.SerialisableTaggedRecordExtension;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class SENSRB extends TaggedRecordExtension implements SerialisableTaggedRecordExtension {

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
    private List<PointSet> module11 = new ArrayList<>();
    private List<Uncertainty> module14 = new ArrayList<>();

    public SENSRB() {
        super(TRE_TAG);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }

    @Override
    public byte[] toBytes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Module1 getModule1() {
        return new Module1(module1);
    }

    public void setModule1(Module1 module1) {
        this.module1 = new Module1(module1);
    }

    public Module2 getModule2() {
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

    public List<Uncertainty> getModule14() {
        return new ArrayList<>(module14);
    }

    public void addUncertainty(Uncertainty uncertainty) {
        this.module14.add(uncertainty);
    }
}
