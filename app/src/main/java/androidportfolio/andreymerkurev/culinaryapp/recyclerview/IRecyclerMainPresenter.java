package androidportfolio.andreymerkurev.culinaryapp.recyclerview;

import android.view.View;

public interface IRecyclerMainPresenter {
    void bindView(IViewHolder iViewHolder);
    int getItemCount();
    void onClick(View v, int position);
}
