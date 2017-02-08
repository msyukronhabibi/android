package syukron.habib.shopreceipt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA = "syukron.habib.shopreceipt.Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View view) {
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        EditText input3 = (EditText) findViewById(R.id.input3);
        EditText input4 = (EditText) findViewById(R.id.input4);
        EditText input5 = (EditText) findViewById(R.id.input5);
        EditText input6 = (EditText) findViewById(R.id.input6);

        double sd, softcase, headset, FD, modem, joystick;
        String hasil = "";
        sd = Double.parseDouble(input1.getText().toString());
        softcase = Double.parseDouble(input2.getText().toString());
        headset = Double.parseDouble(input3.getText().toString());
        FD = Double.parseDouble(input3.getText().toString());
        modem = Double.parseDouble(input3.getText().toString());
        joystick = Double.parseDouble(input3.getText().toString());

        hasil = "Micro SD"+ "\t"+"\t"+"\t"+"\t" +sd+ "\t"+"\t"+"\t"+"\t" +(sd*20000)+"\n";
        hasil += "Softcase"+ "\t"+"\t"+"\t"+"\t" +softcase+ "\t"+"\t"+"\t"+"\t" +(softcase*50000)+"\n";
        hasil += "Headset"+ "\t"+"\t"+"\t"+"\t" +headset+ "\t"+"\t"+"\t"+"\t" +(headset*55000)+"\n";
        hasil += "Flashdisk 16Gb"+ "\t"+"\t"+"\t"+"\t" +FD+ "\t"+"\t"+"\t"+"\t" +(FD*75000)+"\n";
        hasil += "Modem"+ "\t"+"\t"+"\t"+"\t" +modem+ "\t"+"\t"+"\t"+"\t" +(modem*150000)+"\n";
        hasil += "Joystick"+ "\t"+"\t"+"\t"+"\t" +joystick+ "\t"+"\t"+"\t"+"\t" +(joystick*70000)+"\n";
        hasil += "Total"+ "\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+((sd*20000)+(softcase*50000)+(headset*55000)+(FD*75000)+(modem*150000)+(joystick*70000));

        TextView result = (TextView) findViewById(R.id.txt_message);
        result.setText(hasil);
        Intent intent = new Intent(this, ReceiptList.class);
        intent.putExtra(EXTRA, result.getText().toString());
        startActivity(intent);
    }
}
