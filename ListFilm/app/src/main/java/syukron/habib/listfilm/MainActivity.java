package syukron.habib.listfilm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private String [] filmTitles = {"Thor Ragnarok","Doctor Strange","Harry Potter","Captain America",
//            "Suicide Squad","Justice League","Resident Evil Final Chapter","Passenger","Interstellar","Zootopia","La La Land",
//            "One Piece Film: Gold","Fantastic Beasts & Where to Find Them"};

    private ArrayList<Movie> movies = new ArrayList<>();

    ArrayAdapter<Movie> adapter;
    ListView listView;

    private void initMovies(){
        movies.add(new Movie("Thor Ragnarok", "Film lanjutan dari Thor:The dark world", 8.0, 2018));
        movies.add(new Movie("Doctor Strange", "Film tentang dunia sihir Marvel", 8.5, 2016));
        movies.add(new Movie("Suicide Squad", "Menceritakan para penjahat DC Comic yang mendapat misi khusus", 7.5, 2016));
        movies.add(new Movie("Passenger", "Film yang menceritakan 2 orang penumpang kapal luar angkasa yang mengalami malfungsi", 8.0, 2016));
        movies.add(new Movie("Zootopia", "Film Animasi tentang seekor kelinci yang ingin menjadi polisi", 8.2, 2016));
        movies.add(new Movie("One Piece Film: Gold", "Film Animasi tentang lanjutan perjalanan Bajak Laut Topi jerami di kasino"+
                " terbesar di dunia Grand Tessoro", 8.6, 2016));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMovies();
        adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);

        Button btn =(Button)findViewById(R.id.tambah);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent pindah = new Intent(MainActivity.this,TambahList.class);
                startActivity(pindah);
                //menghubungkan antar activity dengan intent

            }
        });

        listView = (ListView) findViewById(R.id.listFilm);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                String item = ((TextView)view).getText().toString();
//                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();

                Movie selectedMovie = movies.get(position);
                Intent intent = new Intent(getBaseContext(), DatailActivity.class);
                intent.putExtra("syukron.habib.listfilm", selectedMovie);
                startActivity(intent);
            }
        });
    }
    public void formTambah(View view){
        Intent intent = new Intent(this, TambahList.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                Movie newMovie = (Movie) data.getSerializableExtra("listfilm.result");
                movies.add(newMovie);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
