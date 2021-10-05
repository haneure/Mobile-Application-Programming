package id.ac.umn.sfxlibraryandpreviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarSfxAdapter extends RecyclerView.Adapter<DaftarSfxAdapter.ItemSfxViewHolder>{
    private LinkedList<SumberSfx> mDaftarSfx;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarSfxAdapter(Context context, LinkedList<SumberSfx> daftarVideo) {
        this.mContext = context;
        this.mDaftarSfx = daftarVideo;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemSfxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.sfx_item_layout, parent, false);
        return new ItemSfxViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemSfxViewHolder holder, int position) {
        SumberSfx mSumberSfx = mDaftarSfx.get(position);

        holder.tvJudul.setText(mSumberSfx.getJudul());
        holder.tvKeterangan.setText(mSumberSfx.getKeterangan());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDaftarSfx.remove(mSumberSfx);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDaftarSfx.size();
    }

    public class ItemSfxViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvJudul;
        private TextView tvKeterangan;
        private ImageButton btnDelete;
        private DaftarSfxAdapter mAdapter;
        private int mPosisi;
        private SumberSfx mSumberSfx;

        public ItemSfxViewHolder(@NonNull View itemView, DaftarSfxAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mPosisi = getLayoutPosition();
            mSumberSfx = mDaftarSfx.get(mPosisi);
            Intent detailIntent = new Intent(mContext, DetailSfx.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetailSfx", mSumberSfx);
            detailIntent.putExtras(bundle);
            mContext.startActivity(detailIntent);
        }
    }
}
