
package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Data object that encapsulates all data associated with a LineChart.
 * 
 * @author Philipp Jahoda
 */
public class LineData extends BarLineScatterCandleBubbleData<LineDataSet> {

    public LineData() {
        super();
    }

    public LineData(List<String> xVals) {
        super(xVals);
    }

    public LineData(String[] xVals) {
        super(xVals);
    }

    public LineData(List<String> xVals, List<LineDataSet> dataSets) {
        super(xVals, dataSets);
    }

    public LineData(String[] xVals, List<LineDataSet> dataSets) {
        super(xVals, dataSets);
    }

    public LineData(List<String> xVals, LineDataSet dataSet) {
        super(xVals, toList(dataSet));
    }

    public LineData(String[] xVals, LineDataSet dataSet) {
        super(xVals, toList(dataSet));
    }

    private static List<LineDataSet> toList(LineDataSet dataSet) {
        List<LineDataSet> sets = new ArrayList<LineDataSet>();
        sets.add(dataSet);
        return sets;
    }


    // overridden methods

    @Override
    protected void checkLegal() {
        if (mDataSets == null)
            return;

        for (int i = 0; i < mDataSets.size(); i++) {

            List<Entry> yVals = mDataSets.get(i).getYVals();
            Set<Integer> uniqueX = new TreeSet<Integer>();

            for (Entry e : yVals) {
                uniqueX.add(e.getXIndex());
            }

            if (uniqueX.size() > mXVals.size()) {
                throw new IllegalArgumentException(
                        "One or more of the DataSet Entry arrays are longer than the x-values array of this ChartData object.");
            }
        }
    }
}
