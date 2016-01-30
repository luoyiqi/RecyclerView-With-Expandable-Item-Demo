package mrzulkarnine.com.recyclerviewwithexpandableitemdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableWeightLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zul on 31/01/2016.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<Note> notes;


    public NoteAdapter() {
        notes = new ArrayList<>();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ExpandableWeightLayout expandLayout;
        public TextView noteTitle, noteContent;
        public ViewHolder(View itemView) {
            super(itemView);
            expandLayout = (ExpandableWeightLayout) itemView.findViewById(R.id.expandableLayout);
            noteContent = (TextView) itemView.findViewById(R.id.noteContent);
            noteTitle = (TextView) itemView.findViewById(R.id.noteTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    expandLayout.toggle();
                }
            });
        }

    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.noteTitle.setText(notes.get(position).getTitle());
        holder.noteContent.setText(notes.get(position).getContent());
        holder.expandLayout.collapse();
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void addNote(Note note){
        notes.add(note);

    }

}