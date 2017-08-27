package br.com.jsonobjectexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private JSONObject mJsonObject;
    private JSONArray mJsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = objectToJson(createPerson());
        Toast.makeText(this, json, Toast.LENGTH_LONG).show();

        Person person = jsonToObject(json);
        Toast.makeText(this, person.toString(), Toast.LENGTH_LONG).show();
    }

    private String objectToJson(Person person) {
        mJsonObject = new JSONObject();
        mJsonArray = new JSONArray();

        try {
            mJsonObject.put("name", person.name);

            for (Phone phone: person.getPhones()) {
                JSONObject aux = new JSONObject();
                aux.put("phone", phone.phone);
                mJsonArray.put(aux);
            }

            mJsonObject.put("phones", mJsonArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mJsonObject.toString();
    }

    private Person jsonToObject(String json) {
        Person person = new Person();

        try {
            mJsonObject = new JSONObject(json);
            mJsonArray = new JSONArray();

            person = new Person(mJsonObject.getString("name"));

            mJsonArray = mJsonObject.getJSONArray("phones");
            for (int x = 0; x < mJsonArray.length(); x++) {
                Phone phone = new Phone(mJsonArray.getJSONObject(x).getString("phone"));
                person.addPhone(phone);
            }

            return person;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return person;
    }

    private Person createPerson() {
        Person person = new Person("Anderson Vinicius");
        person.addPhone(new Phone("453223-2255"));
        person.addPhone(new Phone("453223-8795"));

        return person;
    }
}
