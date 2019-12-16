package androidportfolio.andreymerkurev.culinaryapp.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import androidportfolio.andreymerkurev.culinaryapp.R;
import androidportfolio.andreymerkurev.culinaryapp.app.App;
import androidportfolio.andreymerkurev.culinaryapp.model.PicassoLoader;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.InnerViewHolder>{
    private IRecyclerMainPresenter iRecyclerMainPresenter;
    private View.OnClickListener clickListener;

    @Inject
    PicassoLoader picassoLoader;

    public RecyclerViewAdapter(IRecyclerMainPresenter iRecyclerMainPresenter, View.OnClickListener clickListener) {
        App.getAppComponent().inject(this);
        this.iRecyclerMainPresenter = iRecyclerMainPresenter;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public InnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new InnerViewHolder(view, clickListener);
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
        private ImageView imageView;
        private int position = 0;

        public InnerViewHolder(@NonNull View itemView, @Nullable View.OnClickListener itemClickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);

            if (itemClickListener != null) {
                imageView.setOnClickListener(view1 -> {
                    iRecyclerMainPresenter.onClick(view1, position);
                });
            }
        }

        @Override
        public void setImage(String url) {
            picassoLoader.loadImage(url, imageView);
        }

        @Override
        public int getPos() {
            return position;
        }
    }
}
