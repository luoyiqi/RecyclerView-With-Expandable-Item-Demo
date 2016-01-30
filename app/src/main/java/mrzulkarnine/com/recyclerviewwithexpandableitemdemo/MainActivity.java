package mrzulkarnine.com.recyclerviewwithexpandableitemdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private static final String NOTE_TITLE = "title" ;
    private static final String NOTE_CONTENT = "content" ;
    private NoteAdapter noteAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLLM;
    private Note note;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteAdapter = new NoteAdapter();
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        mLLM = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLLM);
        recyclerView.setAdapter(noteAdapter);
        try {
            loadNotes();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void loadNotes() throws JSONException {
        jsonArray = new JSONArray(getJSONString());
        for(int i=0; i < jsonArray.length(); i++){
            jsonObject = jsonArray.getJSONObject(i);
            note = new Note(jsonObject.getString(NOTE_TITLE),  jsonObject.getString(NOTE_CONTENT));
            noteAdapter.addNote(note);

        }
        noteAdapter.notifyDataSetChanged();
    }



    private String getJSONString(){

        String json = null;
        try {

            InputStream is = getAssets().open("notes.json"); // go to main/asset directory to see notes.json

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


}
