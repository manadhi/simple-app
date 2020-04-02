package com.udhipe.simpleapplication.main.transaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.udhipe.simpleapplication.R;
import com.udhipe.simpleapplication.model.TransactionModel;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionHolder> {

    private ArrayList<TransactionModel> transactionList;
    private static int TYPE_HEADER = 1;
    private static int TYPE_DATA = 2;

    public TransactionAdapter(ArrayList<TransactionModel> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;

        } else {
            return TYPE_DATA;
        }
    }

    @NonNull
    @Override
    public TransactionAdapter.TransactionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new TransactionHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.TransactionHolder holder, int position) {
        if (getItemViewType(position) == TYPE_DATA) {
            TransactionModel transactionModel = transactionList.get(position);
            holder.tvNumber.setText(transactionModel.getmNumber());
            holder.tvTransactionDate.setText(transactionModel.getmTransactionDate().toString());
            holder.tvMember.setText(transactionModel.getmMember());
            holder.tvPartner.setText(transactionModel.getmPartner());
            holder.tvProductType.setText(transactionModel.getmProductType());
            holder.tvSize.setText(transactionModel.getmSize());
            holder.tvProductPrice.setText(transactionModel.getmProductPrice());
            holder.tvDiscountPrice.setText(transactionModel.getmDiscountPrice());
            holder.tvTotalPrice.setText(transactionModel.getmTotalPrice());
        }
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public class TransactionHolder extends RecyclerView.ViewHolder {

        MaterialTextView tvNumber;
        MaterialTextView tvTransactionDate;
        MaterialTextView tvMember;
        MaterialTextView tvPartner;
        MaterialTextView tvProductType;
        MaterialTextView tvSize;
        MaterialTextView tvProductPrice;
        MaterialTextView tvDiscountPrice;
        MaterialTextView tvTotalPrice;

        public TransactionHolder(@NonNull View itemView) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            tvTransactionDate = itemView.findViewById(R.id.tvTransactionDate);
            tvMember = itemView.findViewById(R.id.tvMember);
            tvPartner = itemView.findViewById(R.id.tvPartner);
            tvProductType = itemView.findViewById(R.id.tvProductType);
            tvSize = itemView.findViewById(R.id.tvSize);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            tvDiscountPrice = itemView.findViewById(R.id.tvDiscountPrice);
            tvTotalPrice = itemView.findViewById(R.id.tvTotalPrice);
        }
    }
}
