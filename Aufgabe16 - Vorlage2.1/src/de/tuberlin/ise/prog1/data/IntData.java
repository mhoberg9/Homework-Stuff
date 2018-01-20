package de.tuberlin.ise.prog1.data;

public class IntData implements TreeData {

    public static IntData[] makeFromIntArray(int ... array){
        if(array == null) return null;
        IntData[] out = new IntData[array.length];

        for (int i = 0; i < array.length; i++) {
            out[i] = new IntData(array[i]);
        }

        return out;
    }

    private final int value;

    public IntData(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public int getIntValue() {
        return value;
    }
}
