package com.bieitosousa.pmdm02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/*
        ==========================================================================================
        =                       ICON UPDATE                                                     =
        ==========================================================================================
        #  PATH : app/src/main/AndroidManifest.xml
        #   <application
            ...
             android:icon="@mipmap/{NAME_IMAGEN}}"
        # add image file in
            app/src/main/res/drawable-v24 --> round_perm_device_information_24.xml
            app/src/main/res/mipmap-hdpi -->  round_perm_device_information_black_18.png
            app/src/main/res/mipmap-mdpi -->   ...
            app/src/main/res/mipmap-xhdpi -->  ...
            app/src/main/res/mipmap-xxhdpi --> ...
            app/src/main/res/mipmap-xxxhdpi --> ...
        ==========================================================================================
        =                       JAVA -> ANDROID                                                  =
        ==========================================================================================
        #   [https://developer.android.com/guide]
        #   INIT    :
                |public class {CLASSNAME} extends AppCompatActivity {
                | @Override
                | protected void onCreate(Bundle savedInstanceState) {
                |       super.onCreate(savedInstanceState);
                |       setContentView(R.layout.activity_main);
                |       $$_JAVA_OPERATIONS_$$
                |  }
        --------------------------------------------------------------
        #   OPERATIONS    :
            --> [   -   -   -   GET_ID   -   -   -   -   ]
                |   type name = (type) findViewById(R.id.${NAME_ID_XML});
                |   EXAMPLE:
                |   TextView textView_header = (TextView) findViewById(R.id.textView_header);
                ---------------------------------------------
            --> [   -   -   -   Toast   -   -   -   -   ]
                |   DEF: Mensaje emergente
                |   Toast.makeText( context,String_mensaje, {Toast.LENGTH_LONG|Toast.LENGTH_SHORT});
                |  EXAMPLE:
                | Toast toast = Toast.makeText(
                |            MainActivity.this, getString(R.string.errorEntero), Toast.LENGTH_LONG);
                | toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                | toast.show();
                 ---------------------------------------------
            --> [   -   -   -   Log   -   -   -   -   ]
                |   DEF: Mensaje por consola
                | Log.e(String, String) (error)
                | Log.i(String, String) (información)
                | Log.w(String, String) (advertencia)
                | Log.d(String, String) (depuración)
                | Log.v(String, String) (registro detallado)
                | Se pone normalmente una etiqueta descriptiva
                |     --> private static final String TAG = "MyActivity";
                |  EXAMPLE:
                | Log.d(TAG_onCreate_button_onClick, "Exception" + e.getMessage());
        --------------------------------------------------------------
        #   CICLO DE VIDA  una actividad    :
        [https://developer.android.com/guide/components/activities/activity-lifecycle?hl=es]
                |   @Override
                |   public void onCreate(Bundle savedInstanceState) {
                |   }
                |   Explicacion :
                | Input ->   [Bundle savedInstanceState]
                | Object Bundle --> [ que contiene el estado ya guardado de la actividad.]
                |   (== null) --> Si la actividad nunca existió, el valor del objeto Bundle es nulo.
        --------------------------------------------------------------
        ==========================================================================================
        =                       TEXTO [res\values\strings.xml]                                  =
        ==========================================================================================
        #   [https://developer.android.com/guide/topics/resources/string-resource?hl=es#java]
        #   RUTA    :   PMDM02\app\src\main\res\values\strings.xml
        #   JAVA    :   getString(  R.string.string_name  )
        #   XML     :   @string/string_name
        ==========================================================================================
        =                       COLOR [res\values\colors.xml]                                  =
        ==========================================================================================
        #   deprecate -->[https://developer.android.com/guide/topics/resources/more-resources#Color]
        #   actual -->
        [https://stackoverflow.com/questions/31590714/getcolorint-id-deprecated-on-android-6-0-marshmallow-api-23]
        #   RUTA    :   PMDM02\app\src\main\res\values\colors.xml
        #   JAVA    :   ContextCompat.getColor(this, R.color.orange_primary)
        #   XML     :  @[package:]color/color_name
        ==========================================================================================
*/
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private static final String TAG_onCreate = TAG + " : onCreate";
    private static final String TAG_onCreate_button_onClick = TAG_onCreate
            + " : button_action_calculate : onClick";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // init main activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Resources res = getResources(); // to access res/ to  take color and other parameters
            Log.i(TAG_onCreate, " - START -");
            // take inputs
            String preRequest = getString(R.string.preRequest);
            String postRequest = getString(R.string.postRequest);
            final TextView textView_header = (TextView) findViewById(R.id.textView_header);
            final TextView textView_description = (TextView) findViewById(R.id.textView_description);
            final EditText editText_int_Input = (EditText) findViewById(R.id.editText_int_Input);
            final TextView textView_Label_position = (TextView) findViewById(R.id.textView_Label_position);
            final Button button_action_calculate = (Button) findViewById(R.id.button_action_calculate);
            final TextView textView_request_action = (TextView) findViewById(R.id.textView_request_action);
            // set atributes for the inputs
            //header
            textView_header.setText(getString(R.string.header));
            textView_header.setTextColor(ContextCompat.getColor(this, R.color.orange_primary));
            //description
            textView_description.setText(getString(R.string.description));
            //button
            button_action_calculate.setText(getString(R.string.button_action_calculate_text));
            button_action_calculate.setTextColor(ContextCompat.getColor(this, R.color.white));
            button_action_calculate.setBackgroundColor(ContextCompat.getColor(this, R.color.orange_primary));
            // input label
            textView_Label_position.setText(getString(R.string.labelPosition));
            textView_Label_position.setTextColor(ContextCompat.getColor(this, R.color.orange_primary));
            // Events --> On
            button_action_calculate.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                // take atributes for the inputs
                                final String inputNumberString = editText_int_Input.getText().toString(); // input in type String
                                final int inputNumberInt = Integer.parseInt(inputNumberString);
                                final String finalRequest = preRequest + " [ " + inputNumberInt + " ] " + postRequest + "=> [ ";
                                // Filtro numero  entero  menor o igual que 0 , Ó , mayor o igual a 10000
                                if (inputNumberInt <= PrimeCalculator.LESS || inputNumberInt >= PrimeCalculator.GREATER){
                                    throw new Exception( getString(  R.string.errorEntero));
                                }
                                // calculate outputs
                                int numberRequest = PrimeCalculator.numberOfPrimoInt(inputNumberInt);

                                // request ouputs
                                textView_request_action.setText(finalRequest + numberRequest + " ]");
                            } catch (NumberFormatException nfe) {
                                Toast toast = Toast.makeText(MainActivity.this, getString(R.string.errorEntero), Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                                toast.show();
                                Log.d(TAG_onCreate_button_onClick, "NumberFormatException -->  " + getString(  R.string.errorEntero));
                            } catch (Exception e) {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                Log.d(TAG_onCreate_button_onClick, "Exception" + e.getMessage());
                            }
                        }
                    });
        } catch (Exception e) {
            Log.i(TAG_onCreate, "MainActivity" + e.getMessage());
        }
    }
}