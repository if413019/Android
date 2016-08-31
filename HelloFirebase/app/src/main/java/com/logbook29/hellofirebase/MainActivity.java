package com.logbook29.hellofirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView fireData;
    Firebase ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        fireData = (TextView) findViewById(R.id.firebase_textview);
//        ref = new Firebase("https://wirasetiawan29.firebaseio.com/test");

        ref = new Firebase("https://jojojanus.firebaseio.com/chates/");
        Firebase userId = ref.child("users/0948fea0ae0e68a8550ce9950f698ab2/room");
        userId.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String superData = (String) dataSnapshot.getValue();
                fireData.setText(superData);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
