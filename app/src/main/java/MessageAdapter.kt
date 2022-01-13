import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import fr.pf.pfbaseapp.R

class MessageAdapter(messages : List<Message>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>(){

    val mMessages : List<Message> = messages

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val messageContent : TextView = view.findViewById(R.id.messageContent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.layout_item_message, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message : Message = mMessages.get(position)
        var contentTextView = holder.messageContent
        contentTextView.setText(message.content.toString())
    }

    override fun getItemCount(): Int {
        return mMessages.size
    }

}