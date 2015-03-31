package com.luft.user.xga;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ga extends ActionBarActivity {

    private static final String TAG = ga.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ga);

        ActivityTracker.sendView(this, TAG);

        final Button ok = (Button)findViewById(R.id.button1);

        ok.setOnClickListener(new OnClickListener() {
            //@Override
            //public void onClick(View v) {
              //  mConfirm.run();
            @Override
            public void onClick(View arg0) {

                TextView textview = (TextView)findViewById(R.id.txt1);
                textview.setText("Start GA");
                ActivityTracker.sendEvent(getApplicationContext(), ActivityTracker.CAT_PREF, "Orz", "", 0L);
                CommandUtil.execute("/data/local/tmp/mxb_ga.sh -n -t Tracker");
                // CommandUtil.execute("am start --user 0 -n com.mbx.settingsmbox/.SettingsMboxActivity -a android.intent.action.MAIN -c android.intent.category.LAUNCHER");
                CommandUtil.execute("am start  --user 0 -n org.xbmc.xbmc/.Splash -a android.intent.action.MAIN -c android.intent.category.LAUNCHER");
                //Thread.sleep(5)
                textview.setText("<统计>");



            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ga, menu);
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
