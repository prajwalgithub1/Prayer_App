package com.msquare.prarthananjali;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DharmaShik extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Versions> versionsList;

    TextView language_dialog,helloworldtext;
    boolean lang_selected=true;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dharma_shik);

        getSupportActionBar().setTitle(" धर्मशिक्षण");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        language_dialog = (TextView)findViewById(R.id.dialog_language);
        helloworldtext = (TextView)findViewById(R.id.textview);







        // single item array instance to store
        // which element is selected by user
        // initially it should be set to zero meaning
        // none of the element is selected by default
        final int[] checkedItem = {-1};

        // handle the button to open the alert dialog with
        // the single item selection when clicked
        language_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // AlertDialog builder instance to build the alert dialog
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DharmaShik.this);

                // set the custom icon to the alert dialog


                // title of the alert dialog
                alertDialog.setTitle("Choose an language");

                // list of the items to be displayed to
                // the user in the form of list
                // so that user can select the item from
                //             final String[] listItems = new String[]{"English", "Marathi (मराठी )", "Machine Learning"};

                final String[] language ={"English","मराठी "};

                int checkItem;

                if(lang_selected)
                {
                    checkItem=0;

                }
                else {
                    checkItem=1;

                }

                // the function setSingleChoiceItems is the function which builds
                // the alert dialog with the single item selection
                alertDialog.setSingleChoiceItems(language, checkedItem[0], new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        // update the selected item which is selected by the user
                        // so that it should be selected when user opens the dialog next time
                        // and pass the instance to setSingleChoiceItems method
                        checkedItem[0] = i;




                        language_dialog.setText(language[i]);

                        if(language[i].equals("English"))
                        {

                            initData();
                            setRecyclerView();
                            context = LocalHelper.setLocale(DharmaShik.this,"en");
                            resources=context.getResources();
                            helloworldtext.setText(resources.getString(R.string.language));

                        }




                        if(language[i].equals("मराठी "))
                        {

                            initData2();
                            setRecyclerView2();
                            context = LocalHelper.setLocale(DharmaShik.this,"hi");
                            resources=context.getResources();
                            helloworldtext.setText(resources.getString(R.string.language));

                        }



                        // now also update the TextView which previews the selected item
                        helloworldtext.setText("Selected Language is : " + language[i]);

                        // when selected an item the dialog should be closed with the dismiss method
                        dialog.dismiss();
                    }
                });

                // set the negative button if the user
                // is not interested to select or change
                // already selected item
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                // create and build the AlertDialog instance
                // with the AlertDialog builder instance
                AlertDialog customAlertDialog = alertDialog.create();

                // show the alert dialog when the button is clicked
                customAlertDialog.show();
            }
        });




        recyclerView = findViewById(R.id.recyclerView);


        initData2();
        setRecyclerView2();


    }

    private void setRecyclerView() {
        VersionAdapter versionAdapter = new VersionAdapter(versionsList);
        recyclerView.setAdapter(versionAdapter);
        recyclerView.setHasFixedSize(true);

    }

    private void initData() {

        versionsList = new ArrayList<>();
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));

    }



    private void setRecyclerView2() {
        VersionAdapter versionAdapter = new VersionAdapter(versionsList);
        recyclerView.setAdapter(versionAdapter);
        recyclerView.setHasFixedSize(true);

    }

    private void initData2() {

        versionsList = new ArrayList<>();
        versionsList.add(new Versions("13.1 वर्ग-I", " ", " ", " ग "));

        versionsList.add(new Versions("13.2 वर्ग-II", " ", " ", " ग "));

        versionsList.add(new Versions("13.3 वर्ग-III", " ", " ", " ग "));

        versionsList.add(new Versions("13.4 वर्ग-IV", " ", " ", " ग "));

        versionsList.add(new Versions("13.5 वर्ग-V", " ", " ", " ग "));

        versionsList.add(new Versions("13.6 वर्ग-VI", " ", " ", " ग "));

        versionsList.add(new Versions("13.7 वर्ग-VII", " ", " ", " ग "));

        versionsList.add(new Versions("13.8 वर्ग-VIII", " ", " ", " ग "));

        versionsList.add(new Versions("13.9 वर्ग-IX", " ", " ", " ग "));

        versionsList.add(new Versions("13.10 वर्ग-X", " ", " ", " ग "));

        versionsList.add(new Versions("13.11 वर्ग-XI", " ", " ", " ग "));


    }



}