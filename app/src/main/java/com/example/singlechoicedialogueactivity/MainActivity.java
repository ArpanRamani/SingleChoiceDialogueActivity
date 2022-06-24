package com.example.singlechoicedialogueactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnSingleDialog,btnMultiDialog;
    String[]  List = new String[5];
    boolean[]  SelectTestItem = new boolean[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
    }

    private void InitView() {

        btnSingleDialog = findViewById(R.id.btnSingleDialog);
        btnMultiDialog = findViewById(R.id.btnMultiDialog);


        btnSingleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleChoiceDialog();
            }
        });

        btnMultiDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                MultiChoiceDialog();
            }
        });
    }

    private void MultiChoiceDialog() {


        List[0] = "Pizza";
        List[1] = "Burger";
        List[2] = "Sandwich";
        List[3] = "HotDog";
        List[4] = "Noodles";

        SelectTestItem[0] = true;
        SelectTestItem[1] = false;
        SelectTestItem[2] = false;
        SelectTestItem[3] = true;
        SelectTestItem[4] = true;

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Select item");
        dialog.setMultiChoiceItems(List, SelectTestItem, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i, boolean isChecked) {

                Toast.makeText(MainActivity.this, ""+List[i]+"=====>"+isChecked, Toast.LENGTH_SHORT).show();

            }
        });

        dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Yes Button is click", Toast.LENGTH_SHORT).show();

            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "CANCEL Button is click", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        dialog.setCancelable(false);
        dialog.show();

    }

    private void SingleChoiceDialog() {

        List[0] = "Pizza";
        List[1] = "Burger";
        List[2] = "Sandwich";
        List[3] = "HotDog";
        List[4] = "Noodles";

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Select item");
        dialog.setSingleChoiceItems(List, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, ""+List[i], Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Yes Button is click", Toast.LENGTH_SHORT).show();

            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "CANCEL Button is click", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        dialog.setCancelable(false);
        dialog.show();

    }
}