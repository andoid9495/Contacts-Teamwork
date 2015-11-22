package com.example.contact.Contacts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by SONY1 on 11/15/2015.
 */
public class AddNewContact extends Activity
{

    ContactsDataSource dataSource;


    private static final int REQUEST_SETIMAGE =100 ;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        dataSource=new ContactsDataSource(this);

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

        Button button_saveNewContact= (Button) findViewById(R.id.button_saveNewContact);
        button_saveNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String contactName=((EditText)findViewById(R.id.editText_ContactName)).getText().toString();
                String contactPhone=((EditText)findViewById(R.id.editText_ContactPhone)).getText().toString();
                String contactEmail=((EditText)findViewById(R.id.editText_ContactEmail)).getText().toString();
                String contactAddress=((EditText)findViewById(R.id.editText_ContactAddress)).getText().toString();
                ImageView contactImage=(ImageView)findViewById(R.id.imageView_ContactImage);

                Contact contact=new Contact(contactName,contactPhone,contactEmail,contactAddress,convertToBitmap(contactImage));

                dataSource.open();
                dataSource.insert(contact);
                Toast.makeText(AddNewContact.this,"New Contact Added",Toast.LENGTH_SHORT).show();

                dataSource.close();
                finish();
            }
        });


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

    public Bitmap convertToBitmap(ImageView imageView)
    {
        Bitmap bitmap = Bitmap.createBitmap(
                imageView.getWidth(),
                imageView.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        imageView.draw(canvas);
        return bitmap;
    }
}
