package spansize;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.rcdemo.R;

/**
 * Describe the function of the class
 *
 * @author lemon
 * @date 2017/3/24
 * @time 17:22
 * @Email lemonqsj@163.com
 * @description Describe the place where the class needs to pay attention.
 */

public class SpanSizeActivity extends AppCompatActivity {

    private RecyclerView mRc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span_size);
        mRc = (RecyclerView) findViewById(R.id.re);

        GridLayoutManager layoutManager = new GridLayoutManager(this,4,GridLayoutManager.VERTICAL,false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position % 5 == 0){
                    return 4;
                }else if(position % 5 == 1){
                    return 3;
                }else if(position % 5 == 2){
                    return 1;
                }else{
                    return 5;
                }
            }
        });

        mRc.setLayoutManager(layoutManager);
        myAdapter adapter = new myAdapter();
        mRc.setAdapter(adapter);

    }

    private class myAdapter extends RecyclerView.Adapter{
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_linear_list,parent,false)) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView viewById = (TextView) holder.itemView.findViewById(R.id.tv_rc);
            viewById.setText(String.valueOf(position));
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}
