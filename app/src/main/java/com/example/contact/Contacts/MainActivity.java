package com.example.contact.Contacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;


public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText dial_editText = (EditText) findViewById(R.id.dial_editText);

        dial_editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(dial_editText.getWindowToken(), 0);
            }

        });


        //Tab Related Code
        TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();



        TabHost.TabSpec tabSpec=tabHost.newTabSpec("Dial");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Dial");
        tabHost.addTab(tabSpec);

        tabSpec=tabHost.newTabSpec("Call Logs");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Call Logs");
        tabHost.addTab(tabSpec);



        tabSpec=tabHost.newTabSpec("Contacts");
        tabSpec.setContent(R.id.tab4);
        tabSpec.setIndicator("Contacts");
        tabHost.addTab(tabSpec);

        tabSpec=tabHost.newTabSpec("Contacts Image");
        tabSpec.setContent(R.id.tab5);
        tabSpec.setIndicator("Contacts Image");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(2);


        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "1");
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "2");
            }
        });

        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "3");
            }
        });

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "4");
            }
        });

        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "5");
            }
        });

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "6");
            }
        });

        button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "7");
            }
        });

        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "8");
            }
        });

        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "9");
            }
        });

        button = (Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "*");
            }
        });

        button = (Button) findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "0");
            }
        });

        button = (Button) findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dial_editText.setText(dial_editText.getText().toString() + "#");
            }
        });

        button = (Button) findViewById(R.id.button13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //send sms
            }
        });

        button = (Button) findViewById(R.id.button14);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //call
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                EditText temp=(EditText)findViewById(R.id.dial_editText);
                String callNumber=temp.getText().toString();
                callIntent.setData(Uri.parse(callNumber));
                startActivity(callIntent);
            }
        });

        button = (Button) findViewById(R.id.button15);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //delete character
                String phoneNumber = dial_editText.getText().toString();
                String editedNumber = "";
                for (int i = 0; i < phoneNumber.length() - 1; i++) {
                    editedNumber += phoneNumber.charAt(i);
                }
                dial_editText.setText(editedNumber);
            }
        });

        button=(Button)findViewById(R.id.button_addNewContact);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,NewContact.class);
                startActivity(intent);
            }
        });

//        button=(Button)findViewById(R.id.button_addNewContact);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                EditText temp=(EditText)findViewById(R.id.editText_contactName);
//                String name=temp.getText().toString();
//
//                temp=(EditText)findViewById(R.id.editText_contactEmail);
//                String email=temp.getText().toString();
//
//                temp=(EditText)findViewById(R.id.editText_contactPhone);
//                String phone=temp.getText().toString();
//
//                temp=(EditText)findViewById(R.id.editText_contactAddress);
//                String address=temp.getText().toString();
//
//                ImageView image=(ImageView)findViewById(R.id.editText_contactImage);
//                Contact newContact=new Contact(name,phone,email,address,image);
//            }
//        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
