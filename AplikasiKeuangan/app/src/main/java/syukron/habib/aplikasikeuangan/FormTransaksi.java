package syukron.habib.aplikasikeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormTransaksi extends AppCompatActivity {

    private String [] jenisStr = {"Pemasukan","Pengeluaran"};
    private EditText editNama, editJumlah, editKeterangan;
    private Spinner spnJenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_transaksi);

        spnJenis = (Spinner) findViewById(R.id.spin_jenis);
        ArrayAdapter adapter =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnJenis.setAdapter(adapter);

        editNama = (EditText) findViewById(R.id.inp_nama);
        editJumlah = (EditText) findViewById(R.id.inp_jumlah);
        editKeterangan = (EditText) findViewById(R.id.inp_ket);
    }

    public void saveTransaksi(View view){
        TransaksiHelper dbHelper = new TransaksiHelper(this);
        String nama = editNama.getText().toString();
        int jenis = spnJenis.getSelectedItemPosition()+1;
        int jumlah = Integer.parseInt(editJumlah.getText().toString());
        String keterangan = editKeterangan.getText().toString();

        dbHelper.insertTransaksi(nama, jenis, jumlah, keterangan);

        Log.d("form.transaksi", nama+" - "+Integer.toString(jenis)+" - "+Integer.toString(jumlah)
                                +" - "+keterangan);
        Toast.makeText(this, "Transaksi "+nama+" berhasil disimpan", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, MainActivity.class));
    }
}
