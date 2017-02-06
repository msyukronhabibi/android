package syukron.habib.tipscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View view){
        EditText input_tagih = (EditText) findViewById(R.id.input_tagih);
        EditText input_persen = (EditText) findViewById(R.id.input_persen);
        EditText input_jumlah = (EditText) findViewById(R.id.input_jumlah);
        TextView result = (TextView) findViewById(R.id.result);

        double tagih, persen, jumlah;
        String hasil = "";
        tagih = Double.parseDouble(input_tagih.getText().toString());
        persen = Double.parseDouble(input_persen.getText().toString());
        jumlah = Double.parseDouble(input_jumlah.getText().toString());

        hasil = "Tips = "+((tagih*persen)/100)+"\n";
        hasil += "Total = "+(tagih+(tagih*(persen/100)))+"\n";
        hasil += "Per Orang = "+((tagih+(tagih*(persen)/100))/jumlah);

        result.setText(hasil);
    }
}
