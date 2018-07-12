package com.allandroidprojects.ecomsample.options;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.entites.Address;

import java.util.ArrayList;

public class NewAddressActivity extends AppCompatActivity {
    public static Context context;
    EditText city, street, state, pincode, name, moobile;
    TextView cityErr, streetErr, stateErr, pincodeErr, nameErr, moobileErr;
    LinearLayout saveLayoutAction;
//    ArrayList<Address> addressList = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address);
        context = NewAddressActivity.this;

        init();

        saveLayoutAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String streetStr = street.getText().toString().trim();
                String cityStr = city.getText().toString().trim();
                String stateStr = state.getText().toString().trim();
                String pincodeStr = pincode.getText().toString().trim();
                String nameStr = name.getText().toString().trim();
                String mobStr = moobile.getText().toString().trim();

                if (cityStr.isEmpty()){
                    cityErr.setVisibility(View.VISIBLE);
                    cityErr.setText("Please provide the necessary details.");
                } else {
                    cityErr.setVisibility(View.GONE);
                }

                if (stateStr.isEmpty()){
                    streetErr.setVisibility(View.VISIBLE);
                    streetErr.setText("Please provide the necessary details.");
                } else {
                    streetErr.setVisibility(View.GONE);
                }

                if (streetStr.isEmpty()){
                    streetErr.setVisibility(View.VISIBLE);
                    streetErr.setText("Please provide the necessary details.");
                } else {
                    streetErr.setVisibility(View.GONE);
                }

                if (pincodeStr.isEmpty()){
                    pincodeErr.setVisibility(View.VISIBLE);
                    pincodeErr.setText("Please provide the necessary details.");
                } else {
                    pincodeErr.setVisibility(View.GONE);
                }
                if (nameStr.isEmpty()){
                    nameErr.setVisibility(View.VISIBLE);
                    nameErr.setText("Please provide the necessary details.");
                } else {
                    nameErr.setVisibility(View.GONE);
                }
                if (mobStr.isEmpty()){
                    moobileErr.setVisibility(View.VISIBLE);
                    moobileErr.setText("Please provide the necessary details.");
                } else {
                    moobileErr.setVisibility(View.GONE);
                }
                if (cityStr.length()==0){
                    Toast.makeText(getApplicationContext(), "Please provide the necessary details.", Toast.LENGTH_SHORT).show();
                    city.requestFocus();
                    return;
                }
                if (streetStr.length()==0){
                    Toast.makeText(getApplicationContext(), "Please provide the necessary details.", Toast.LENGTH_SHORT).show();
                    street.requestFocus();
                    return;
                }if (pincodeStr.length()==0){
                    Toast.makeText(getApplicationContext(), "Please provide the necessary details.", Toast.LENGTH_SHORT).show();
                    pincode.requestFocus();
                    return;
                }if (stateStr.length()==0){
                    Toast.makeText(getApplicationContext(), "Please provide the necessary details.", Toast.LENGTH_SHORT).show();
                    state.requestFocus();
                    return;
                }if (nameStr.length()==0){
                    Toast.makeText(getApplicationContext(), "Please provide the necessary details.", Toast.LENGTH_SHORT).show();
                    name.requestFocus();
                    return;
                }if (mobStr.length()==0){
                    Toast.makeText(getApplicationContext(), "Please provide the necessary details.", Toast.LENGTH_SHORT).show();
                    moobile.requestFocus();
                    return;
                }

                Address address = new Address();
                address.setCity(cityStr);
                address.setStreet(streetStr);
                address.setPincode(pincodeStr);
                address.setState(stateStr);
                address.setBuyerName(nameStr);
                address.setMobile(mobStr);

                address.addAddressList(address);
                Toast.makeText(getApplicationContext(), "Saved" +address.getAddressList().size(), Toast.LENGTH_SHORT).show();
                finish();

            }
        });



    }

    public void init(){
        street = findViewById(R.id.address_street);
        city = findViewById(R.id.address_city);
        state = findViewById(R.id.address_state);
        pincode = findViewById(R.id.address_pincode);
        name = findViewById(R.id.address_name);
        moobile = findViewById(R.id.address_mob);
        saveLayoutAction = findViewById(R.id.save_new_address);
        streetErr = findViewById(R.id.streetErrTxt);
        cityErr = findViewById(R.id.cityErrTxt);
        stateErr = findViewById(R.id.stateErrTxt);
        pincodeErr = findViewById(R.id.pincodeErrTxt);
        nameErr = findViewById(R.id.nameErrTxt);
        moobileErr = findViewById(R.id.mobileErrTxt);

    }
//    public void addAddressList(Address addresslist) {
//        this.addressList.add(0, addresslist);
//    }
//    public ArrayList<Address> getAddressList(){ return this.addressList; }

}
