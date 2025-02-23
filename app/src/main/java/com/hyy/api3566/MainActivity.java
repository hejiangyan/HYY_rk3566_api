package com.hyy.api3566;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.youngfeel.yf_rk356x_api.YF_RK356x_API_Manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Youngfeel_test_api";
    public TextView tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    public Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt9_1,bt10;
    public Button bt11,bt12,bt13,bt14,bt15,bt16,bt17,bt18,bt19,bt20;
    public Button bt21,bt22,bt23,bt24,bt25,bt26;
    public Spinner spinner1;
    public boolean nav_bar_flag = true;
    public boolean status_bar_display_flag = true;
    public boolean status_bar_show_hide_flag = true;
    private ArrayAdapter<String> arr_adapter;
    ArrayList<String> data_list;
    YF_RK356x_API_Manager yfapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //yfapi = new YF_RK356x_API_Manager(this);
        tv0 = (TextView)findViewById(R.id.textView0);
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        tv4 = (TextView)findViewById(R.id.textView4);
        tv5 = (TextView)findViewById(R.id.textView5);
        tv6 = (TextView)findViewById(R.id.textView6);
        tv7 = (TextView)findViewById(R.id.textView7);
        tv8 = (TextView)findViewById(R.id.textView8);
        tv9 = (TextView)findViewById(R.id.textView9);


        bt1 = (Button)findViewById(R.id.button1);
        bt2 = (Button)findViewById(R.id.button2);
        bt3 = (Button)findViewById(R.id.button3);
        bt4 = (Button)findViewById(R.id.button4);
        bt5 = (Button)findViewById(R.id.button5);
        bt6 = (Button)findViewById(R.id.button6);
        bt7 = (Button)findViewById(R.id.button7);
        bt8 = (Button)findViewById(R.id.button8);
        bt9 = (Button)findViewById(R.id.button9);
        bt9_1 = (Button)findViewById(R.id.button9_1);
        bt10 = (Button)findViewById(R.id.button10);
        bt11 = (Button)findViewById(R.id.button11);
        bt12 = (Button)findViewById(R.id.button12);
        bt13 = (Button)findViewById(R.id.button13);
        bt14 = (Button)findViewById(R.id.button14);
        bt15 = (Button)findViewById(R.id.button15);
        bt16 = (Button)findViewById(R.id.button16);
        bt17 = (Button)findViewById(R.id.button17);
        bt18 = (Button)findViewById(R.id.button18);
        bt19 = (Button)findViewById(R.id.button19);
        bt20 = (Button)findViewById(R.id.button20);
        bt21 = (Button)findViewById(R.id.button21);
        bt22 = (Button)findViewById(R.id.button22);
        bt23 = (Button)findViewById(R.id.button23);
        bt24 = (Button)findViewById(R.id.button24);
        bt25 = (Button)findViewById(R.id.button25);
        bt26 = (Button)findViewById(R.id.button26);

        bt10.setVisibility(View.GONE);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        data_list = new ArrayList<String>();
        data_list.add("please select rotation dagree ");
        data_list.add("0");
        data_list.add("90");
        data_list.add("180");
        data_list.add("270");


        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arr_adapter);
        spinner1.setSelection(0, true);

        yfapi = new YF_RK356x_API_Manager(this);
        tv0.setText("APIVersion: "+ yfapi.yfgetAPIVersion());
        getsysteminfo();
        displaybttest();
    }

    private void getsysteminfo(){
        tv1.setText("DeviceModel: " + yfapi.yfgetAndroidDeviceModel());
        tv2.setText("AndroidVersion: " + yfapi.yfgetAndroidVersion());
        tv3.setText("SerialNumber: " + yfapi.yfgetSerialNumber());
        tv4.setText("KernelVersion: " + yfapi.yfgetKernelVersion());
        tv5.setText("FirmwareVersion: " + yfapi.yfgetFirmwareVersion());
        tv6.setText("BuildDate: " + yfapi.yfgetBuildDate());
        tv7.setText("DDR size: " + yfapi.yfgetRAMSize());
        tv8.setText("Internal Storage Memory size:" + yfapi.yfgetInternalStorageMemory());
        tv9.setText("AvailableInternal Internal Storage Memory size:" + yfapi.yfgetAvailableInternalMemorySize());
    }

    private void displaybttest(){
        bt1.setText("shutdown");
        bt1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                yfapi.yfShutDown();
            }
        });

        bt2.setText("reboot");
        bt2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                yfapi.yfReboot();
            }
        });

        bt3.setText("lcd backlight on");
        bt3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                yfapi.yfSetLCDOn();
            }
        });

        bt4.setText("lcd backlight off");
        bt4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                yfapi.yfSetLCDOff();
            }
        });

        bt5.setText("take screenshot");
        bt5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String picname = (int)(Math.random()*50)+"screenshot.png";
                yfapi.yfTakeScreenshot("/mnt/sdcard", picname);
                Toast.makeText(getApplicationContext(), "save picture to /mnt/sdcard/"+picname, Toast.LENGTH_SHORT).show();
            }
        });


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position != 0){
                    Spinner spinner=(Spinner) parent;
                    String degree = spinner.getItemAtPosition(position).toString();
                    yfapi.yfsetRotation(degree);
                    Toast.makeText(getApplicationContext(), "set rotaion to "+spinner.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        bt6.setText("get Screen Height");
        bt6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "screen height:"+yfapi.yfgetScreenHeight(), Toast.LENGTH_LONG).show();
            }
        });

        bt7.setText("get Screen Width");
        bt7.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "screen width:"+ yfapi.yfgetScreenWidth(), Toast.LENGTH_LONG).show();
            }
        });

        bt8.setText("set NavigationBar Visibility");
        bt8.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                nav_bar_flag = !nav_bar_flag;
                yfapi.yfsetNavigationBarVisibility(nav_bar_flag);
            }
        });

        bt9.setText("set StatusBar Display");
        bt9.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                    yfapi.yfsetStatusBarDisplay(true);
            }
        });

        bt9_1.setText("set StatusBar Undisplay");
        bt9_1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                yfapi.yfsetStatusBarDisplay(false);
            }
        });

        bt11.setText("slient install apk");
        bt11.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String path = "/sdcard/Demo.apk";
                yfapi.yfslientinstallapk(path);
                Toast.makeText(getApplicationContext(), "install apk ok", Toast.LENGTH_LONG).show();
            }
        });

        bt12.setText("get mac address");
        bt12.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "EthMacAddress:"+yfapi.yfgetEthMacAddress(), Toast.LENGTH_LONG).show();

            }
        });

        bt13.setText("get Ip Address");
        bt13.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "EthIPAddress:"+yfapi.yfgetIpAddress(), Toast.LENGTH_LONG).show();

            }
        });

        bt14.setText("switch ethernet STATIC and set Ip Address");
        bt14.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                yfapi.yfsetEthIPAddress("192.168.1.125", "255.255.255.0", "192.168.1.1", "192.168.1.1");
                Toast.makeText(getApplicationContext(), "set IP Address:192.168.1.125", Toast.LENGTH_LONG).show();

            }
        });

        bt25.setText("Swtich ethernet to DHCP");
        bt25.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                yfapi.yfsetEthDhcp();
                Toast.makeText(getApplicationContext(), "Swtich ethernet to DHCP", Toast.LENGTH_LONG).show();

            }
        });

        bt26.setText("get ethernet status");
        bt26.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "ethernet is " + (yfapi.yfgetEthStatus()?"DHCP MODE":"STATIC MODE"), Toast.LENGTH_LONG).show();

            }
        });

        bt15.setText("get SD Path");
        bt15.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SD path:"+yfapi.yfgetSDPath(), Toast.LENGTH_LONG).show();

            }
        });

        bt16.setText("get Internal SD Path");
        bt16.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SD Path:"+yfapi.yfgetInternalSDPath(), Toast.LENGTH_LONG).show();

            }
        });

        bt17.setText("get USB Disk Path");
        bt17.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "USB Disk Path:"+yfapi.yfgetUSBPath(), Toast.LENGTH_LONG).show();

            }
        });

        bt18.setText("get Current NET TYPE");
        bt18.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Current net type:"+yfapi.yfgetCurrentNetType(), Toast.LENGTH_LONG).show();

            }
        });

        bt19.setText("set 2 minutes to shutdown and 2 minutes to power on");
        bt19.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar mCalendar=Calendar.getInstance();
                int mYear,mMonth,mDay,mHour,mMinute;
                int offmYear,offmMonth,offmDay,offmHour,offmMinute;
                long time=System.currentTimeMillis();
                mCalendar.setTimeInMillis(time + 240000);
                mYear=mCalendar.get(Calendar.YEAR);
                mMonth=mCalendar.get(Calendar.MONTH) + 1;
                mDay=mCalendar.get(Calendar.DAY_OF_MONTH);
                mHour=mCalendar.get(Calendar.HOUR_OF_DAY);
                mMinute=mCalendar.get(Calendar.MINUTE);

                mCalendar.setTimeInMillis(time + 120000);
                offmYear=mCalendar.get(Calendar.YEAR);
                offmMonth=mCalendar.get(Calendar.MONTH) + 1;
                offmDay=mCalendar.get(Calendar.DAY_OF_MONTH);
                offmHour=mCalendar.get(Calendar.HOUR_OF_DAY);
                offmMinute=mCalendar.get(Calendar.MINUTE);

                int[] timeonArray = {mYear, mMonth, mDay, mHour, mMinute};
                int[] timeoffArray = {offmYear, offmMonth, offmDay, offmHour, offmMinute};
                Toast.makeText(getApplicationContext(), "The manchine will be shutdown at "+ timeoffArray[0]+"/"+timeoffArray[1]+"/"+timeoffArray[2]+":"+timeoffArray[3]+":"+timeoffArray[4]+"\n"+"reboot at "+ timeonArray[0]+"/"+timeonArray[1]+"/"+timeonArray[2]+":"+timeonArray[3]+":"+timeonArray[4]+"\n", Toast.LENGTH_LONG).show();
                //yfapi.yfsetOnOffTime(timeonArray, timeoffArray, true);

                Intent intent = new Intent("com.android.yf_set_timer_swtich");
                // { 2016, 12, 12, 17, 55 };时间格式
                intent.putExtra("timeon", timeonArray);
                intent.putExtra("timeoff", timeoffArray);
                intent.putExtra("enable", true);
                sendBroadcast(intent);

            }
        });

        bt20.setText("set humansensor timeout 30s");
        bt20.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                yfapi.yfsetHumanSensor(30);
            }
        });


        bt21.setText("TEST yf_slient_install2");
        bt21.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
               Intent intent = new Intent();
                intent.setAction("com.android.yf_slient_install");
                intent.putExtra("path","/storage/emulated/0/YF_reboot.apk");
                intent.putExtra("isboot",true);
                sendBroadcast(intent);
            }
        });

        bt22.setText("Build.getSerial()");
        bt22.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Build.getSerial():"+Build.getSerial(), Toast.LENGTH_LONG).show();
            }
        });

        bt23.setText("** Factory Reset **");   // 需要系统签名
        bt23.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.FACTORY_RESET");
                intent.setPackage("android");
                intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);
                intent.putExtra("android.intent.extra.REASON", "MasterClearConfirm");
                intent.putExtra("android.intent.extra.WIPE_EXTERNAL_STORAGE", true);
                intent.putExtra("com.android.internal.intent.extra.WIPE_ESIMS", true);
                sendBroadcast(intent);
            }
        });

        bt24.setText("clear memory");    // 需要系统签名
        bt24.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
                ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                List infoList = am.getRunningAppProcesses();
                List serviceInfos = am.getRunningServices(100);
                long beforeMem = getAvailMemory();

                Log.d(TAG, "-----------before memory info : " + beforeMem);

                int count = 0;
                PackageManager pm = getPackageManager();

                if (infoList != null) {
                    for (int i = 0; i < infoList.size(); ++i) {
                        ActivityManager.RunningAppProcessInfo appProcessInfo = (ActivityManager.RunningAppProcessInfo) infoList.get(i);

                        Log.d(TAG, "process name : " + appProcessInfo.processName);

                        //importance 该进程的重要程度 分为几个级别，数值越低就越重要。
                        Log.d(TAG, "importance : " + appProcessInfo.importance);

                        // 一般数值大于RunningAppProcessInfo.IMPORTANCE_SERVICE的进程都长时间没用或者空进程了
                        // 一般数值大于RunningAppProcessInfo.IMPORTANCE_VISIBLE的进程都是非可见进程，也就是在后台运行着
                        if (appProcessInfo.importance > ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE) {
                            String[] pkgList = appProcessInfo.pkgList;

                            for (int j = 0; j < pkgList.length; ++j) {//pkgList 得到该进程下运行的包名
                                String appName = null;

                                try {
                                    appName = (String) pm.getApplicationLabel(pm.getApplicationInfo(pkgList[j], 0));
                                } catch (PackageManager.NameNotFoundException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                Log.d(TAG, "It will be killed, package name : " + pkgList[j]+" -- "+appName );
                                am.killBackgroundProcesses(pkgList[j]);
                                count++;
                            }
                        }
                    }
                }

                long afterMem = getAvailMemory();
                Log.d(TAG, "----------- after memory info : " + afterMem);
                Toast.makeText(getApplicationContext(), "clear " + count + " process, "
                        + (afterMem - beforeMem) + "M", Toast.LENGTH_LONG).show();
            }
        });

    }

    private long getAvailMemory() {
        // 获取android当前可用内存大小
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();

        am.getMemoryInfo(mi);
        //mi.availMem; 当前系统的可用内存
        //return Formatter.formatFileSize(context, mi.availMem);// 将获取的内存大小规格化
        Log.d(TAG, "可用内存---->>>" + mi.availMem / (1024 * 1024));
        return mi.availMem / (1024 * 1024);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }
}