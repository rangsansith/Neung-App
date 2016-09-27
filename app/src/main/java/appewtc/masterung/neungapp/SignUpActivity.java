package appewtc.masterung.neungapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    //Explicit
    private EditText nameEditText, surnameEditText, userEditText, passwordEditText;
    private ImageView imageView;
    private String nameString, surnameString, userString, passwordString, imageString;
    private boolean aBoolean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        surnameEditText = (EditText) findViewById(R.id.editText2);
        userEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);
        imageView = (ImageView) findViewById(R.id.imageView);

        //Image Controller
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "โปรดเลือกรูปภาพ"), 0);

            }   // onClick
        });


    }   // Main Method

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 0) && (resultCode == RESULT_OK)) {

            aBoolean = false;

        }   // if

    }   // onActivityResult

    public void clickSignUpSign(View view) {

        //Get Value From Edit Text
        nameString = nameEditText.getText().toString().trim();
        surnameString = surnameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (nameString.equals("") || surnameString.equals("") ||
                userString.equals("") || passwordString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert(this, "มีช่องว่าง",
                    "กรุณากรอกทุกช่อง ด้วยคะ");
            myAlert.myDialog();
        } else if (aBoolean) {
            //Non Choose Image
            MyAlert myAlert = new MyAlert(this, "ยังไม่ได้เลือกรูป",
                    "กรุณาคลิกที่รูปภาพ เพื่อเลื่อกรูป");
            myAlert.myDialog();
        } else {
            //Choose Image Finish
        }



    }   // clickSignUpSign



}   // Main Class
