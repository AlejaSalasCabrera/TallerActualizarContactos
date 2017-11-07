package com.example.jonmid.contactosbasededatos.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.contactosbasededatos.ContactsActivity;
import com.example.jonmid.contactosbasededatos.Helpers.SqliteHelper;
import com.example.jonmid.contactosbasededatos.R;

public class DeleteActivity extends AppCompatActivity {

    TextView textViewId;
    TextView textViewName;
    TextView textViewPhone;
    TextView textViewEmail;
    SqliteHelper sqliteHelper;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        textViewId = (TextView) findViewById(R.id.id_tv_delete_id);
        textViewName = (TextView) findViewById(R.id.id_tv_delete_name);
        textViewPhone = (TextView) findViewById(R.id.id_tv_delete_phone);
        textViewEmail = (TextView) findViewById(R.id.id_tv_delete_email);

        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);

        textViewId.setText( getIntent().getExtras().getString("id") );
        textViewName.setText( getIntent().getExtras().getString("name") );
        textViewPhone.setText( getIntent().getExtras().getString("phone") );
        textViewEmail.setText( getIntent().getExtras().getString("email") );

        id = Integer.parseInt(getIntent().getExtras().getString("id"));
    }

    public void onClickCancelDelete(View view){
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void onClickDeleteContact(View view){


        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        db.execSQL("delete from users where id = "+ id);
        Toast.makeText(this, "Contacto eliminado correctamente", Toast.LENGTH_SHORT).show();
        onClickCancelDelete(view);
    }
}
