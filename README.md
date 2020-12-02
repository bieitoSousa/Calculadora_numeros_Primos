# Calculadora_numeros_Primos

### ICONO

```javascript

        ==========================================================================================
        =                       ICON UPDATE                                                     =
        ==========================================================================================
        [1]	descargo los iconos --> Android, PNG
	            [NORMAL]
	            https://material.io/resources/icons/?icon=calculate&style=sharp
	            [REDONDO]
	            https://material.io/resources/icons/?icon=calculate&style=round

        [2]	pego las imagenes en los archivos :
	            XML --> app/src/main/res/drawable
	            PNG -------------------------------
	            app/src/main/res/mipmap-hdpi
	            app/src/main/res/mipmap-mdpi
	            app/src/main/res/mipmap-xhdpi
	            app/src/main/res/mipmap-xxhdpi
	            app/src/main/res/mipmap-xxxhdpi
	            ------------------------------------
        [3] EN --> app/src/main/res/mipmap-anydpi-v26
        	    me creo un archivo lincando el xml (vector -> app/src/main/res/drawable)
        	    y le doy formato :
        	    -----------------------------------------------------------------------------
        	    	<?xml version="1.0" encoding="utf-8"?>
        	    		<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
        	    		<background android:drawable="@color/orange_primary"/>
        	    		<foreground android:drawable="@drawable/round_calculate_24"/>
        	    		</adaptive-icon>
        	    -------------------------------------------------------------------------------
        	    <?xml version="1.0" encoding="utf-8"?>
        	    	<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
        	    	<background android:drawable="@color/orange_primary"/>
        	    	<foreground android:drawable="@drawable/sharp_calculate_24"/>
        	    </adaptive-icon>
        	    -------------------------------------------------------------------------------
        [4] EN app/src/main/AndroidManifest.xml --> linco el xml del formato
        	   <application
                [...]
                android:icon="@mipmap/sharp_calculate"
                android:roundIcon="@mipmap/round_calculate"
        	-------------------------------------------------------------------------------
        Forma rapida -> click derecho /res --> new --> imagen Assert

```

##  JAVA

```javascript
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
        

```
##  XML


```javascript
        
    ==========================================================================================
    =                                     LAYOUT                                          =
    ==========================================================================================
    #  constraintlayout   {Layout inicial}
        |   xmlns:tools="http://schemas.android.com/tools"              => ?¿
        |   xmlns:app="http://schemas.android.com/apk/res-auto"         => ?¿
        |   xmlns:android="http://schemas.android.com/apk/res/android   => ?¿
        |   tools:context=".MainActivity"                               => se ejecuta .{class}
        |_____________________________________________________________________________________
    #  FrameLayout      [Esquina superior izquierda, superposicion]
    #  LinearLayout     orientation = [vertical]    => Ajuste al padre, al contenido
    #  LinearLayout     orientation = [horizontal]    => Ajuste al padre, al contenido
    #  RelativeLayout   [center, booton , top]

    ==========================================================================================
    =                                     ATRIBUTES                                          =
    ==========================================================================================
    #  layout_width     ["match_parent" | "wrap_content"]    => Ajuste al padre, al contenido
    #  layout_height    ["match_parent" | "wrap_content"]    => Ajuste al padre, al contenido
    #  layout_weight    [number]
    #  textSize         [number+"sp" ]                       => Tamaño de letra
    #  textStyle        [bold|italic]                        => estilo en el texto
    #  text             [String text]                        => añadir un texto
    ==========================================================================================
        
       
```       
