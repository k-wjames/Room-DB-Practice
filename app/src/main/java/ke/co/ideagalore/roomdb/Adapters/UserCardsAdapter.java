package ke.co.ideagalore.roomdb.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ke.co.ideagalore.roomdb.Models.CardModel;
import ke.co.ideagalore.roomdb.R;
import ke.co.ideagalore.roomdb.Repositories.RoomDB;

public class UserCardsAdapter extends RecyclerView.Adapter<UserCardsAdapter.ViewHolder> {

    List<CardModel> cardModels;
    Activity context;
    RoomDB database;

    public UserCardsAdapter(List<CardModel> cardModels, Activity context) {
        this.cardModels = cardModels;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserCardsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserCardsAdapter.ViewHolder holder, int position) {

        //Initialize the user card model
        CardModel cardModel=cardModels.get(position);

        holder.name.setText(cardModel.getName());
        holder.designation.setText(cardModel.getDesignation());
        holder.organisation.setText(cardModel.getOrganisation());
        holder.city.setText(cardModel.getCity());
        holder.email.setText(cardModel.getEmail());
        holder.directLine.setText(cardModel.getDirectLine()+"");
        holder.mobileLine.setText(cardModel.getMobileLine()+"");
        holder.fax.setText(cardModel.getFax()+"");


        //Initialize Room Database
        database=RoomDB.getInstance(context);

    }

    @Override
    public int getItemCount() {
        return cardModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, designation, organisation,city, email,directLine, mobileLine, fax;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.text_name);
            designation=itemView.findViewById(R.id.text_designation);
            organisation=itemView.findViewById(R.id.text_organisation);
            city=itemView.findViewById(R.id.text_city);
            email=itemView.findViewById(R.id.text_email);
            directLine=itemView.findViewById(R.id.text_direct_line);
            mobileLine=itemView.findViewById(R.id.text_mobile_line);
            fax=itemView.findViewById(R.id.text_fax);
        }
    }
}
