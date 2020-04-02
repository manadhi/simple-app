package com.udhipe.simpleapplication.model;

import java.util.Date;

public class TransactionModel {
    private String mNumber;
    private String mTransactionDate;
    private String mMember;
    private String mPartner;
    private String mProductType;
    private String mSize;
    private String mProductPrice;
    private String mDiscountPrice;
    private String mTotalPrice;

    public TransactionModel(String mNumber, String mTransactionDate, String mMember, String mPartner, String mProductType, String mSize, String mProductPrice, String mDiscountPrice, String mTotalPrice) {
        this.mNumber = mNumber;
        this.mTransactionDate = mTransactionDate;
        this.mMember = mMember;
        this.mPartner = mPartner;
        this.mProductType = mProductType;
        this.mSize = mSize;
        this.mProductPrice = mProductPrice;
        this.mDiscountPrice = mDiscountPrice;
        this.mTotalPrice = mTotalPrice;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getmTransactionDate() {
        return mTransactionDate;
    }

    public void setmTransactionDate(String mTransactionDate) {
        this.mTransactionDate = mTransactionDate;
    }

    public String getmMember() {
        return mMember;
    }

    public void setmMember(String mMember) {
        this.mMember = mMember;
    }

    public String getmPartner() {
        return mPartner;
    }

    public void setmPartner(String mPartner) {
        this.mPartner = mPartner;
    }

    public String getmProductType() {
        return mProductType;
    }

    public void setmProductType(String mProductType) {
        this.mProductType = mProductType;
    }

    public String getmSize() {
        return mSize;
    }

    public void setmSize(String mSize) {
        this.mSize = mSize;
    }

    public String getmProductPrice() {
        return mProductPrice;
    }

    public void setmProductPrice(String mProductPrice) {
        this.mProductPrice = mProductPrice;
    }

    public String getmDiscountPrice() {
        return mDiscountPrice;
    }

    public void setmDiscountPrice(String mDiscountPrice) {
        this.mDiscountPrice = mDiscountPrice;
    }

    public String getmTotalPrice() {
        return mTotalPrice;
    }

    public void setmTotalPrice(String mTotalPrice) {
        this.mTotalPrice = mTotalPrice;
    }
}
