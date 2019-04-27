import java.util.ArrayList;
import java.util.List;

class DataWrapper {

    private int val;

    private List<DataObserver> list = new ArrayList<>();

    DataWrapper(int val) {
        this.val = val;
    }

    void setVal(int val) {
        this.val = val;
        updateObservers();
    }

    void addObserver(DataObserver a) {
        list.add(a);
    }

    private void updateObservers() {
        for (DataObserver observer : list) {
            observer.onValueChanged(val);
        }
    }
}
