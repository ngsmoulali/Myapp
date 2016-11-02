package com.example.rishi.myapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rishi.myapp.Utils.Sendmail;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etPhone, etMail, etPassword, etCpassword,etDob;
    RadioGroup rgGroup;
    RadioButton rbMale, rbFemale, rbOthers;
    Button btnSubmit;
    ImageButton ibDob;
    private Calendar cal;
    private int year,month,day,id;
    String email, emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public SharedPreferences preferences;
    public static final String ID_UNAME="ID_UNAME",ID_MOBILE="ID_MOBILE",ID_MAIL="ID_MAIL",ID_DOB="ID_DOB",is_male="is_male",is_female="is_female",is_others="is_others";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etMail = (EditText) findViewById(R.id.etMail);
        etDob=(EditText)findViewById(R.id.etDob) ;
        rgGroup = (RadioGroup) findViewById(R.id.rgGroup);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        rbOthers = (RadioButton) findViewById(R.id.rbOthers);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        ibDob=(ImageButton)findViewById(R.id.ibDob);
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        ibDob.setOnClickListener(this);
        email=etMail.getText().toString().trim();
        loadPreferences();
        loadGenderPreference();
        submit();



    }

    @Override
    protected void onPause() {
        super.onPause();
        savePreferences(ID_UNAME,etName.getText().toString());
        savePreferences(ID_MOBILE,etPhone.getText().toString());
        savePreferences(ID_MAIL,etMail.getText().toString());
        savePreferences(ID_DOB,etDob.getText().toString());
        saveGenderpreferences();

    }

    @Override
    protected void onStop() {
        super.onStop();

        savePreferences(ID_UNAME,etName.getText().toString());
        savePreferences(ID_MOBILE,etPhone.getText().toString());
        savePreferences(ID_MAIL,etMail.getText().toString());
        savePreferences(ID_DOB,etDob.getText().toString());
        saveGenderpreferences();

    }



    @Override
    public void onClick(View v) {
        showDialog(0);
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            Calendar userAge = new GregorianCalendar(selectedYear,selectedMonth,selectedDay);
            Calendar minAdultAge = new GregorianCalendar();
            minAdultAge.add(Calendar.YEAR, -16);
            if (minAdultAge.before(userAge)) {
                final Animation animAlpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_alpha);
                etDob.startAnimation(animAlpha);
                etDob.setError("Your age Must be above 16");
            }
            else {
                etDob.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                        + selectedYear);
            }
        }
    };

            public void submit() {
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(validations()) {
                            emailSent();

                            if(emailSent()==true) {
                                Toast toast=Toast.makeText(getBaseContext(),"Registration is successful .check your mail for password",Toast.LENGTH_SHORT);
                                toast.show();
                                clear();
                            }
                            else{
                                Toast toast=Toast.makeText(getBaseContext(),"Plz check your internet connection",Toast.LENGTH_SHORT);
                                toast.show();
                            }

                        }

                    }

                });
            }
    //Validations for fields
    public  boolean validations(){
        if (TextUtils.isEmpty(etName.getText().toString())) {
            final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
            etName.startAnimation(animAlpha);
            etName.setError("Enter Your Name");
            return false;
        }
        if (TextUtils.isEmpty(etPhone.getText().toString()) || etPhone.getText().length() != 10) {
            final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
            etPhone.startAnimation(animAlpha);
            etPhone.setError("Enter Your 10 Digit MobileNumber");
            return false;
        }
       /* if (TextUtils.isEmpty(etPassword.getText().toString()) || etPassword.getText().length() < 6) {
            final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
            etPassword.startAnimation(animAlpha);
            etPassword.setError("Enter Password Above 6 Characters");
            return false;
        }
        if (etCpassword.getText().length() != etPassword.getText().length() || etCpassword.getText().equals(etPassword.getText().toString())) {
            final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
            etCpassword.startAnimation(animAlpha);
            etCpassword.setError("Password and confirm Password should be same");
            return false;
        }*/

        if (TextUtils.isEmpty(etMail.getText().toString())) {
            final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
            etMail.startAnimation(animAlpha);
            etMail.setError("Enter Valid Email-ID");
            return false;
        } else {
            Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(etMail.getText().toString());
            if (!matcher.find()) {
                final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
                etMail.startAnimation(animAlpha);
                etMail.setError("Enter Valid Email-ID");
                return false;
            }
        }
        if(TextUtils.isEmpty(etDob.getText().toString())){
            final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
            etDob.startAnimation(animAlpha);
            etDob.setError("Enter DateofBirth");
            return false;
        }

        if (rgGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getBaseContext(), "Select Gender", Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;


    }
    //Generate random password
    public static String generateRandomPassword() {
        Random generator = new Random();
        String password = String.valueOf (generator.nextInt(96) + 32);
       return password;

    }

    //Seding mail for succesfull registration
    public boolean emailSent(){

        String toEmail = etMail.getText().toString().trim();
        String subject="Registration Confirmation";
        String message="Hello "+etName.getText().toString()+" Your Registraion is Succesfull" +"and you password is"+generateRandomPassword().toString();
        Sendmail sm = new Sendmail(this, toEmail, subject, message);

        //Executing sendmail to send email
        sm.execute();
        savePreferences(ID_UNAME,etName.getText().toString());
        savePreferences(ID_MOBILE,etPhone.getText().toString());
        savePreferences(ID_MAIL,etMail.getText().toString());
        savePreferences(ID_DOB,etDob.getText().toString());
        saveGenderpreferences();
        return true;
    }
    public void clear(){
        etName.setText("");
        etPhone.setText("");
        etMail.setText("");
        etDob.setText("");
        rgGroup.clearCheck();
    }
    //load genderPreferences
    public void loadGenderPreference(){
        preferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(preferences.getBoolean("is_male", false)){
            rbMale.setChecked(true);
        }
        else if (preferences.getBoolean("is_female", false)) {
            rbFemale.setChecked(true);
        }
        else{
            rbOthers.setChecked(true);
        }
    }
    public void saveGenderpreferences(){
        preferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor=preferences.edit();
        rgGroup = (RadioGroup) findViewById(R.id.rgGroup);
        int selectedId = rgGroup.getCheckedRadioButtonId();
        if(selectedId == R.id.rbMale) {
            editor.putBoolean("is_male", true);
        }
        else if(selectedId == R.id.rbFemale) {
            editor.putBoolean("is_female", true);
        }
        else{
            editor.putBoolean("is_others", false);
        }
        editor.commit();
    }
    //saving SharedPreferencess
    public void savePreferences(String key,String value){
        preferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(key,value);


        editor.commit();

    }
    //load Sharedpreferences
    public  void loadPreferences(){
        preferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        etName.setText(preferences.getString(ID_UNAME,etName.getText().toString()));
        etPhone.setText(preferences.getString(ID_MOBILE,etPhone.getText().toString()));
        etMail.setText(preferences.getString(ID_MAIL,etMail.getText().toString()));
        etDob.setText(preferences.getString(ID_DOB,etDob.getText().toString()));

    }



    }



