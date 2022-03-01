package ke.co.ideagalore.roomdb.UI;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import ke.co.ideagalore.roomdb.Adapters.UserCardsAdapter;
import ke.co.ideagalore.roomdb.Models.CardModel;
import ke.co.ideagalore.roomdb.R;
import ke.co.ideagalore.roomdb.Repositories.RoomDB;

public class MyUserCards extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    List<CardModel> cardModelList;
    RoomDB database;
    CardModel cardModel;
    UserCardsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_user_cards);
        recyclerView = findViewById(R.id.recyclcerview);
        //Initialize database
        database = RoomDB.getInstance(this);

        //Now store database value in data list
        cardModelList = database.userCardDao().getAllUserCards();

        //Initialize linearLayoutmanager
        layoutManager = new LinearLayoutManager(this);

        //Set layout manager
        recyclerView.setLayoutManager(layoutManager);

        //Initialise the adapter
        adapter = new UserCardsAdapter(cardModelList, MyUserCards.this);

        //Now set the adapter
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.user_dialog);
                //Initialize the width and height
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                //Set layout
                dialog.getWindow().setLayout(width, height);
                //Show the dialog
                dialog.show();

                EditText name = dialog.findViewById(R.id.edt_name);
                ;
                EditText designation = dialog.findViewById(R.id.edt_designation);
                EditText organisation = dialog.findViewById(R.id.edt_organisation);
                EditText city = dialog.findViewById(R.id.edt_city);
                EditText email = dialog.findViewById(R.id.edt_email);
                EditText officeLine = dialog.findViewById(R.id.edt_direct_line);
                EditText mobileLine = dialog.findViewById(R.id.edt_mobile_line);
                EditText fax = dialog.findViewById(R.id.edt_fax);

                Button saveCard = dialog.findViewById(R.id.btn_save);

                saveCard.setOnClickListener(view1 -> {
                    //Validate fields then Save new user card

                    String uName, uDesignation, uOrganisation, uCity, uEmail;
                    double uOfficeLine, uMobileLine, uFax;

                    uName = name.getText().toString().trim();
                    uDesignation = designation.getText().toString().trim();
                    uOrganisation = organisation.getText().toString().trim();
                    uCity = city.getText().toString().trim();
                    uEmail = email.getText().toString().toLowerCase().trim();
                    uOfficeLine = Double.parseDouble(officeLine.getText().toString().trim());
                    uMobileLine = Double.parseDouble(mobileLine.getText().toString().toString());
                    uFax = Double.parseDouble(fax.getText().toString().trim());

                    //Continue with code to save new User Card
                    cardModel = new CardModel();
                    cardModel.setName(uName);
                    cardModel.setDesignation(uDesignation);
                    cardModel.setOrganisation(uOrganisation);
                    cardModel.setCity(uCity);
                    cardModel.setEmail(uEmail);
                    cardModel.setDirectLine(uOfficeLine);
                    cardModel.setMobileLine(uMobileLine);
                    cardModel.setFax(uFax);

                    //Insert the data into the database

                    database.userCardDao().insert(cardModel);
                    dialog.dismiss();

                    //Reset fields
                    name.setText("");
                    designation.setText("");
                    organisation.setText("");
                    city.setText("");
                    email.setText("");
                    officeLine.setText("");
                    mobileLine.setText("");
                    fax.setText("");

                    //Notify when data is inserted
                    cardModelList.clear();
                    cardModelList.addAll(database.userCardDao().getAllUserCards());
                    adapter.notifyDataSetChanged();


                });
            }
        });
    }
}