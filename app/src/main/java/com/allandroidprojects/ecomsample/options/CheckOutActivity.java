package com.allandroidprojects.ecomsample.options;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.entites.Address;
import com.allandroidprojects.ecomsample.payment.PaymentActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {
    private static Context mContext;
    TextView newAddressBtn;
    RecyclerView recyclerView;
    ArrayList<Address> addresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        mContext = CheckOutActivity.this;
        Address newAddress = new Address();
        addresses = newAddress.getAddressList();
        init();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_address);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(new CheckOutActivity.AddressRecyclerViewAdapter(recyclerView, addresses));
        newAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, NewAddressActivity.class));
            }
        });


    }

    public void init(){
        newAddressBtn = findViewById(R.id.text_action_continue);

    }


    public class AddressRecyclerViewAdapter extends RecyclerView.Adapter<CheckOutActivity.AddressRecyclerViewAdapter.ViewHolder> {

        private ArrayList<Address> mAddresslist;
        private RecyclerView mRecyclerView;

        String[] add = {"4th Floor, Venkateshwara Heritage, Kudlu Hosa Road, Opp Sai Purna Premium Apartment, Sai Meadows, Kudlu, Bengaluru, Karnataka 560068",
                "HYVA Primus, #45/155, 5th Main, Road Next to IBM Bannerghatta Main, Bengaluru, Karnataka 560029"};



        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            TextView addresstxt;
            LinearLayout deliveryAction;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                addresstxt =  view.findViewById(R.id.address_text);
                deliveryAction =  view.findViewById(R.id.delivery_action);
            }
        }

        public AddressRecyclerViewAdapter(RecyclerView recyclerView, ArrayList<Address> addresses) {
            mRecyclerView = recyclerView;
            mAddresslist = addresses;
        }

        @NonNull
        @Override
        public CheckOutActivity.AddressRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_address_list, parent, false);
            return new CheckOutActivity.AddressRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
//            Address address = mAddresslist.get(position);
//            holder.addresstxt.setText(address.getBuyerName()+"\n"+address.getStreet()+"\n"+address.getCity()+", "+address.getState()+" "+address.getPincode()+"\n"+address.getMobile());
            holder.addresstxt.setText(add[position]);
            holder.deliveryAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(mContext, PaymentActivity.class).putExtra("address", holder.addresstxt.getText().toString()));

                }
            });

        }

        @Override
        public void onViewRecycled(CheckOutActivity.AddressRecyclerViewAdapter.ViewHolder holder) {

        }

        @Override
        public int getItemCount() {
            return add.length;
        }
    }
}
