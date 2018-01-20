package de.tuberlin.ise.prog1.model;

import de.tuberlin.ise.prog1.data.TreeData;

public abstract class MarketItem implements TreeData {
    //unique id counter
    private static int nextId = 0x0;

    protected int id;

    MarketItem(){
        this.id = nextId;
        nextId++;
    }

    /**
     * This will update the ID of the MarketItem.
     * But only if the new ID is greater or equal to the current nextID.
     *
     * @return true if the update was successful, false otherwise
     * @param id
     */
    public boolean setID(int id){
        if(id < nextId){
            return false;
        } else {
            this.id = id;
            nextId = id + 1;
            return true;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public int getIntValue() {
        return id;
    }
}
