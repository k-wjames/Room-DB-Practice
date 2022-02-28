package ke.co.ideagalore.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(view.getContext());
                dialog.setContentView(R.layout.user_dialog);
                //Initialize the width and height
                int width= WindowManager.LayoutParams.MATCH_PARENT;
                int height=WindowManager.LayoutParams.WRAP_CONTENT;
                //Set layout
                dialog.getWindow().setLayout(width, height);
                //Show the dialog
                dialog.show();

                EditText name, designation,organisation,city, email, officeLine, mobileLine, fax;
                name=dialog.findViewById(R.id.edt_name);
                designation=dialog.findViewById(R.id.edt_designation);
                organisation=dialog.findViewById(R.id.edt_organisation);
                city=dialog.findViewById(R.id.edt_city);
                email=dialog.findViewById(R.id.edt_email);
                officeLine=dialog.findViewById(R.id.edt_direct_line);
                mobileLine=dialog.findViewById(R.id.edt_mobile_line);
                fax=dialog.findViewById(R.id.edt_fax);
                Button saveCard=dialog.findViewById(R.id.btn_save);
            }
        });
    }
}