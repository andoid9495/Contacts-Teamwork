package com.example.contact.Contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by SONY1 on 11/15/2015.
 */
public class NewContact extends Activity
{
    private static final int REQUEST_SETIMAGE =100 ;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        ImageView contactImage=(ImageView)findViewById(R.id.imageView_ContactImage);
        contactImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpg");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,REQUEST_SETIMAGE);
            }
        });
    }

    public void save(View v)
    {
        String contactName=((EditText)findViewById(R.id.editText_ContactName)).getText().toString();
        String contactPhone=((EditText)findViewById(R.id.editText_ContactPhone)).getText().toString();
        String contactEmail=((EditText)findViewById(R.id.editText_ContactEmail)).getText().toString();
        String contactAddress=((EditText)findViewById(R.id.editText_ContactAddress)).getText().toString();
        ImageView contactImage=(ImageView)findViewById(R.id.imageView_ContactImage);

        Contact contact=new Contact(contactName,contactPhone,contactEmail,contactAddress,contactImage);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_SETIMAGE&& resultCode==RESULT_OK)
        {
            ImageView contactImage=(ImageView)findViewById(R.id.imageView_ContactImage);

        }
    }
}
