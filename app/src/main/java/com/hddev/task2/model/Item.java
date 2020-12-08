package com.hddev.task2.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private String item1;
    private String item2;
    private boolean checked;
    public Item(){}


    protected Item(Parcel in) {
        item1 = in.readString();
        item2 = in.readString();
        checked = in.readByte() != 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(item1);
        dest.writeString(item2);
        dest.writeByte((byte) (checked ? 1 : 0));
    }
}
