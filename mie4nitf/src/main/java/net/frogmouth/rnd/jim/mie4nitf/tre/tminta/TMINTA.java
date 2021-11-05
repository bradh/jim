package net.frogmouth.rnd.jim.mie4nitf.tre.tminta;

import net.frogmouth.rnd.jim.nitf.tre.TRE;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import java.util.ArrayList;
import java.util.List;

public class TMINTA extends TRE {

    private static final String TRE_TAG = "TMINTA";
    private final List<TimeInterval> timeIntervals = new ArrayList<>();

    public TMINTA() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREGroup()
    public List<TimeInterval> getTimeIntervals() {
        return new ArrayList<>(timeIntervals);
    }

    public void addTimeInterval(TimeInterval timeInterval) {
        timeIntervals.add(timeInterval);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
