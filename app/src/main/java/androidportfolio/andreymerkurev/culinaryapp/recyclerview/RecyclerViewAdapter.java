package androidportfolio.andreymerkurev.culinaryapp.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import androidportfolio.andreymerkurev.culinaryapp.R;
import androidportfolio.andreymerkurev.culinaryapp.app.App;
import androidportfolio.andreymerkurev.culinaryapp.model.PicassoLoader;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.InnerViewHolder>{
    private IRecyclerMainPresenter iRecyclerMainPresenter;

    @Inject
    PicassoLoader picassoLoader;

    public RecyclerViewAdapter(IRecyclerMainPresenter iRecyclerMainPresenter) {
        App.getAppComponent().inject(this);
        this.iRecyclerMainPresenter = iRecyclerMainPresenter;
    }

    @NonNull
    @Override
    public InnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new InnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerViewHolder holder, int position) {
        holder.position = position;
        iRecyclerMainPresenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return iRecyclerMainPresenter.getItemCount();
    }

    class InnerViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
        private int position = 0;
        private ImageView imageView;
        private TextView tvTitle;
        private TextView tvDescription;
        private ImageView ivDuration;
        private ImageView ivLevel;

        public InnerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            ivDuration = itemView.findViewById(R.id.iv_duration);
            ivLevel = itemView.findViewById(R.id.iv_level);
            ivDuration.setImageResource(R.drawable.smile);
        }

        @Override
        public int getPos() {
            return position;
        }

        @Override
        public void setImage(String url) {
            picassoLoader.loadImage(url, imageView);
        }

        @Override
        public void setTitle(String title) {
            tvTitle.setText(title);
        }

        @Override
        public void setDescription(String description) {
            tvDescription.setText(description);
        }

        @Override
        public void setDuration(int duration) {
            if (duration >= 0 && duration <= 20) ivDuration.setImageResource(R.drawable.duration_15);
                else if (duration > 20 && duration <= 30) ivDuration.setImageResource(R.drawable.duration_30);
                    else if (duration > 30) ivDuration.setImageResource(R.drawable.duration_60);
        }

        @Override
        public void setLevel(int level) {
            switch(level) {
                case 1: ivLevel.setImageResource(R.drawable.child); break;
                case 2: ivLevel.setImageResource(R.drawable.adult); break;
                case 3: ivLevel.setImageResource(R.drawable.chief); break;
                default: ivLevel.setImageResource(R.drawable.smile); break;
            }
        }
    }
}
