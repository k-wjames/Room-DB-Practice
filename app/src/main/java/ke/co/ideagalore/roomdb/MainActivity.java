package ke.co.ideagalore.roomdb;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                EditText name;
                EditText designation;
                EditText organisation;
                EditText city;
                EditText email;
                EditText officeLine;
                EditText mobileLine;
                EditText fax;
                name = dialog.findViewById(R.id.edt_name);
                designation = dialog.findViewById(R.id.edt_designation);
                organisation = dialog.findViewById(R.id.edt_organisation);
                city = dialog.findViewById(R.id.edt_city);
                email = dialog.findViewById(R.id.edt_email);
                officeLine = dialog.findViewById(R.id.edt_direct_line);
                mobileLine = dialog.findViewById(R.id.edt_mobile_line);
                fax = dialog.findViewById(R.id.edt_fax);
                Button saveCard = dialog.findViewById(R.id.btn_save);

                saveCard.setOnClickListener(view1 -> {
                    //Validat fields then Save new user card

                    String uName, uDesignation, uOrganisation, uCity, uEmail;
                    double uOfficeLine, uMobileLine, uFax;

                    uName=name.getText().toString().trim();
                    uDesignation=designation.getText().toString().trim();
                    uOrganisation=organisation.getText().toString().trim();
                    uCity=city.getText().toString().trim();
                    uEmail=email.getText().toString().toLowerCase().trim();
                    uOfficeLine=Double.parseDouble(officeLine.getText().toString().trim());
                    uMobileLine=Double.parseDouble(mobileLine.getText().toString().toString());
                    uFax=Double.parseDouble(fax.getText().toString().trim());

                });
            }
        });
    }
}