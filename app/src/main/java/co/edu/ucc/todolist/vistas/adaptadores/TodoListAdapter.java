package co.edu.ucc.todolist.vistas.adaptadores;

import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.edu.ucc.todolist.R;
import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 12-Sep-17.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ItemTodoList> {

    private List<Tarea> dataset;

    public TodoListAdapter(List<Tarea> dataset) {
        super();
        this.dataset = dataset;
    }

    @Override
    public ItemTodoList onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new ItemTodoList(view);
    }

    @Override
    public void onBindViewHolder(ItemTodoList holder, int position) {
        Tarea tarea = dataset.get(position);

        holder.tvTarea.setText(tarea.getNombre());
        holder.chkTarea.setChecked(tarea.isRealizada());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ItemTodoList extends RecyclerView.ViewHolder {

        //@BindView(R.id.chkTarea)
        AppCompatCheckBox chkTarea;

        //@BindView(R.id.tvTarea)
        TextView tvTarea;

        public ItemTodoList(View itemView) {
            super(itemView);
            //ButterKnife.bind(itemView);

            chkTarea = (AppCompatCheckBox) itemView.findViewById(R.id.chkTarea);
            tvTarea = (TextView) itemView.findViewById(R.id.tvTarea);
        }
    }
}
