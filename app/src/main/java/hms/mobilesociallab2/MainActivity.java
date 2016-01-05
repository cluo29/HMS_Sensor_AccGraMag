package hms.mobilesociallab2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    /**
     * Sensor update frequency in microseconds, default 200000
     */
    private static int SAMPLING_RATE = 200000;

    private static SensorManager mSensorManager;
    private static Sensor mAccelerometer;
    private static Sensor mGravity;
    private static Sensor mMagnetometer;

    private static float accelerometer_x = 0;
    private static float accelerometer_y = 0;
    private static float accelerometer_z = 0;

    private static float gravity_x = 0;
    private static float gravity_y = 0;
    private static float gravity_z = 0;

    private static float magnetometer_x = 0;
    private static float magnetometer_y = 0;
    private static float magnetometer_z = 0;

    private static TextView Text_Accelerometer_x;
    private static TextView Text_Accelerometer_y;
    private static TextView Text_Accelerometer_z;
    private static TextView Text_Gravity_x;
    private static TextView Text_Gravity_y;
    private static TextView Text_Gravity_z;
    private static TextView Text_Magnetometer_x;
    private static TextView Text_Magnetometer_y;
    private static TextView Text_Magnetometer_z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        mSensorManager.registerListener(this, mAccelerometer, SAMPLING_RATE);

        mSensorManager.registerListener(this, mGravity, SensorManager.SENSOR_DELAY_NORMAL);

        mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);

        setContentView(R.layout.activity_main);

        Text_Accelerometer_x = (TextView)findViewById(R.id.Accelerometer_x);

        Text_Accelerometer_y = (TextView)findViewById(R.id.Accelerometer_y);

        Text_Accelerometer_z = (TextView)findViewById(R.id.Accelerometer_z);

        Text_Gravity_x = (TextView)findViewById(R.id.Gravity_x);

        Text_Gravity_y = (TextView)findViewById(R.id.Gravity_y);

        Text_Gravity_z = (TextView)findViewById(R.id.Gravity_z);

        Text_Magnetometer_x = (TextView)findViewById(R.id.Magnetometer_x);

        Text_Magnetometer_y = (TextView)findViewById(R.id.Magnetometer_y);

        Text_Magnetometer_z = (TextView)findViewById(R.id.Magnetometer_z);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;


        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // accelerometer data
            accelerometer_x = event.values[0];
            accelerometer_y = event.values[1];
            accelerometer_z = event.values[2];

            Log.d("SENSORS", "accelerometer_x= " + accelerometer_x);
            Log.d("SENSORS", "accelerometer_y= " + accelerometer_y);
            Log.d("SENSORS", "accelerometer_z= " + accelerometer_z);
        }

        if (sensor.getType() == Sensor.TYPE_GRAVITY) {
            // gravity data
            gravity_x = event.values[0];
            gravity_y = event.values[1];
            gravity_z = event.values[2];

            Log.d("SENSORS", "gravity_x= " + gravity_x);
            Log.d("SENSORS", "gravity_y= " + gravity_y);
            Log.d("SENSORS", "gravity_z= " + gravity_z);
        }

        if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            // magnetometer data
            magnetometer_x = event.values[0];
            magnetometer_y = event.values[1];
            magnetometer_z = event.values[2];

            Log.d("SENSORS", "magnetometer_x= " + magnetometer_x);
            Log.d("SENSORS", "magnetometer_y= " + magnetometer_y);
            Log.d("SENSORS", "magnetometer_z= " + magnetometer_z);
        }


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Text_Accelerometer_x.setText("Accelerometer X = "+accelerometer_x);
                Text_Accelerometer_y.setText("Accelerometer Y = "+accelerometer_y);
                Text_Accelerometer_z.setText("Accelerometer Z = "+accelerometer_z);
                Text_Gravity_x.setText("Gravity X = "+gravity_x);
                Text_Gravity_y.setText("Gravity Y = "+gravity_y);
                Text_Gravity_z.setText("Gravity Z = "+gravity_z);
                Text_Magnetometer_x.setText("Magnetometer X = "+magnetometer_x);
                Text_Magnetometer_y.setText("Magnetometer Y = "+magnetometer_y);
                Text_Magnetometer_z.setText("Magnetometer Z = "+magnetometer_z);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
