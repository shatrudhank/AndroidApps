package in.studolite.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(new EmployeeAdapter(EmployeeData.getEmployeeData()));

    }

}


class EmployeeAdapter extends  RecyclerView.Adapter<EmployeeHolder>
{
    List<Emplyee> emplyeeList;

    EmployeeAdapter(List<Emplyee> emplyeeList)
    {
        this.emplyeeList=emplyeeList;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        Emplyee emplyee=emplyeeList.get(position);
        holder.empIdTv.setText(emplyee.getId());
        holder.empNameTv.setText(emplyee.getName());
        holder.empDpt.setText(emplyee.getDepartment());
    }

    @Override
    public int getItemCount() {
        return emplyeeList.size();
    }
}

class  EmployeeHolder extends RecyclerView.ViewHolder
{
    TextView empIdTv;
    TextView empNameTv;
    TextView empDpt;
    EmployeeHolder(View view)
    {
        super(view);
        this.empIdTv=view.findViewById(R.id.empId);
        this.empNameTv=view.findViewById(R.id.empName);
        this.empDpt=view.findViewById(R.id.empDpt);
    }
}

