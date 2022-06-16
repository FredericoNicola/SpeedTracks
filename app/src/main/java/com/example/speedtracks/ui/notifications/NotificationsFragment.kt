package com.example.speedtracks.ui.notifications

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.speedtracks.MainActivity
import com.example.speedtracks.ShoeAdapter
import com.example.speedtracks.UserShoes
import com.example.speedtracks.databinding.FragmentNotificationsBinding
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.example.speedtracks.R

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private lateinit var shoeArrayList: ArrayList<UserShoes>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.myShoeBtn.setOnClickListener {
            binding.myShoeBtn.isVisible = false
            binding.listviewProfile.isVisible = true
        }

        notificationsViewModel.text.observe(viewLifecycleOwner) {
        }

        val shoeid = arrayOf(
            "Nike air","adidas","asics"
        )
        val progress = intArrayOf(
            10,50,60
        )

        shoeArrayList = ArrayList()

        for ( i in shoeid.indices  ) {

            val shoe = UserShoes(shoeid[i], progress[i])
            shoeArrayList.add(shoe)

        }

        binding.listviewProfile.adapter = ShoeAdapter( arrayList = this.shoeArrayList, context =


        return root)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class CustomAdapter(private val dataSet: Array<String>) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView

            init {
                // Define click listener for the ViewHolder's View.
                textView = view.findViewById(R.id.textView)
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_view, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.textView.text = dataSet[position]
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size

    }
}
