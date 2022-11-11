package com.milon.nav;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
/*import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;*/

public class LoadDetailsFragment extends Fragment  {




    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_load_details, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Load");

        return view;
    }

}