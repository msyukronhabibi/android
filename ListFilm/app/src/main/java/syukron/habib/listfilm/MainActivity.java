package syukron.habib.listfilm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private String [] filmTitles = {"Thor Ragnarok","Doctor Strange","Harry Potter","Captain America",
//            "Suicide Squad","Justice League","Resident Evil Final Chapter","Passenger","Interstellar","Zootopia","La La Land",
//            "One Piece Film: Gold","Fantastic Beasts & Where to Find Them"};

    private ArrayList<Movie> movies = new ArrayList<>();

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
        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);

        ListView listView = (ListView) findViewById(R.id.list_film);
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
}
