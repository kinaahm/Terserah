package id.sch.smktelkom_mlg.tugas01.xirpl2026.terserah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTahun;
    RadioGroup rgJk;
    Spinner spKota;
    CheckBox cb1, cb2, cb3;
    Button bOk;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextKelas);

        rgJk = (RadioGroup) findViewById(R.id.radioGroupJk);

        spKota = (Spinner) findViewById(R.id.spinnerKota);

        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);

        bOk = (Button) findViewById(R.id.buttonOK);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);;

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        String hasil = null;
        String asal = spKota.getSelectedItem().toString();
        String posisi = "\nKelas Anda           : ";

        int startlen = posisi.length();
        if (cb1.isChecked()) posisi += cb1.getText() + ",";
        if (cb2.isChecked()) posisi += cb2.getText() + ",";
        if (cb3.isChecked()) posisi += cb3.getText() + ",";

        if (posisi.length() == startlen) posisi += "Tidak ada pada pilihan";

        if (rgJk.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJk.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Tahun Belum Diisi");
        } else if (tahun.length() > 2) {
            etTahun.setError("Format Umur Salah");
        } else {
            etNama.setError(null);
        }
        tvHasil.setText("**************** ( METIC ) ****************" + "\nNama         : " + nama + " \nKelas         : " + tahun +
                "\nJenis Kelamin     : " + hasil + "\nAsal Kota       : " + asal + posisi);
    }

}
