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

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    /**
     * Sensor update frequency in microseconds, default 200000
     */
    private static int SAMPLING_RATE = 200000;

    private static SensorManager mSensorManager;
    private static Sensor mAccelerometer;
    private static Sensor mGravity;
    private static Sensor mMagnetometer;

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
            float accelerometer_x = event.values[0];
            float accelerometer_y = event.values[1];
            float accelerometer_z = event.values[2];

            Log.d("SENSORS", "accelerometer_x= " + accelerometer_x);
            Log.d("SENSORS", "accelerometer_y= " + accelerometer_y);
            Log.d("SENSORS", "accelerometer_z= " + accelerometer_z);
        }

        if (sensor.getType() == Sensor.TYPE_GRAVITY) {
            // gravity data
            float gravity_x = event.values[0];
            float gravity_y = event.values[1];
            float gravity_z = event.values[2];

            Log.d("SENSORS", "gravity_x= " + gravity_x);
            Log.d("SENSORS", "gravity_y= " + gravity_y);
            Log.d("SENSORS", "gravity_z= " + gravity_z);
        }

        if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            // magnetometer data
            float magnetometer_x = event.values[0];
            float magnetometer_y = event.values[1];
            float magnetometer_z = event.values[2];

            Log.d("SENSORS", "magnetometer_x= " + magnetometer_x);
            Log.d("SENSORS", "magnetometer_y= " + magnetometer_y);
            Log.d("SENSORS", "magnetometer_z= " + magnetometer_z);
        }
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
