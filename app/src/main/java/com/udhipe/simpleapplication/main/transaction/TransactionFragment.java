package com.udhipe.simpleapplication.main.transaction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udhipe.simpleapplication.R;
import com.udhipe.simpleapplication.model.TransactionModel;
import com.udhipe.simpleapplication.utility.RandomDateTime;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionFragment extends Fragment {

    private RecyclerView mRvTransaction;
    private TransactionAdapter mTransactionAdapter;
    private ArrayList<TransactionModel> mTransactionList = new ArrayList<>();

    public TransactionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        mRvTransaction = view.findViewById(R.id.rvTransaction);
        mTransactionAdapter = new TransactionAdapter(mTransactionList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRvTransaction.setLayoutManager(mLayoutManager);
        mRvTransaction.setItemAnimator(new DefaultItemAnimator());
        mRvTransaction.setAdapter(mTransactionAdapter);
        prepareDummyData();

        return view;
    }

    private void prepareDummyData() {
        int dummySize = 30;
        TransactionModel transactionModel;

        transactionModel = new TransactionModel("", "", "", "", "", "", "", "", "");
        mTransactionList.add(transactionModel);

        for (int i = 1; i <= dummySize; i++) {
            transactionModel = new TransactionModel(String.valueOf(i), "01-04-2020", "1234", "Retail", "Fahd", "S", "Rp260.000", "Rp250.000", "Rp250.000");
            mTransactionList.add(transactionModel);
            i++;
            transactionModel = new TransactionModel(String.valueOf(i), "02-04-2020", "-", "Reseller", "Badr", "M", "Rp250.000", "-", "Rp250.000");
            mTransactionList.add(transactionModel);
            i++;
            transactionModel = new TransactionModel(String.valueOf(i), "03-04-2020", "4325", "Retail", "Kaif", "L", "Rp270.000", "Rp260.000", "Rp260.000");
            mTransactionList.add(transactionModel);
        }

        mTransactionAdapter.notifyDataSetChanged();
    }
}
