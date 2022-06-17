package com.example.speedtracks.ui.notifications

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.speedtracks.databinding.FragmentNotificationsBinding
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.example.speedtracks.*

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
            binding.myShoeBtn2.isVisible = true
            binding.divider3.isVisible = true
            binding.divider4.isVisible = true
            binding.divider5.isVisible = true
            binding.divider6.isVisible = true
            binding.imageView.isVisible= true
            binding.imageView2.isVisible = true
            binding.imageView3.isVisible = true
            binding.textView7.isVisible = true
            binding.textView8.isVisible = true
            binding.textView9.isVisible = true
            binding.progressBar.isVisible = true
            binding.progressBar2.isVisible = true
            binding.progressBar3.isVisible = true

            binding.progressBar.apply {
                progressMax = 500f
                setProgressWithAnimation(100f,1000)
                progressBarWidth = 5f
                backgroundProgressBarWidth = 7f
                progressBarColor = Color.GREEN
                roundBorder = true
                backgroundProgressBarColor = Color.WHITE
            }
            binding.progressBar2.apply {
                progressMax = 500f
                setProgressWithAnimation(300f,1000)
                progressBarWidth = 5f
                backgroundProgressBarWidth = 7f
                progressBarColor = Color.RED
                roundBorder = true
                backgroundProgressBarColor = Color.WHITE
            }
            binding.progressBar3.apply {
                progressMax = 500f
                setProgressWithAnimation(240f,1000)
                progressBarWidth = 5f
                backgroundProgressBarWidth = 7f
                progressBarColor = Color.YELLOW
                roundBorder = true
                backgroundProgressBarColor = Color.WHITE
            }

            //binding.listviewProfile.isVisible = true
        }
        binding.myShoeBtn2.setOnClickListener {
            binding.myShoeBtn.isVisible = true
            binding.myShoeBtn2.isVisible = false
            binding.divider3.isVisible = false
            binding.divider4.isVisible = false
            binding.divider5.isVisible = false
            binding.divider6.isVisible = false
            binding.imageView.isVisible= false
            binding.imageView2.isVisible = false
            binding.imageView3.isVisible = false
            binding.textView7.isVisible = false
            binding.textView8.isVisible = false
            binding.textView9.isVisible = false
            binding.progressBar.isVisible = false
            binding.progressBar2.isVisible = false
            binding.progressBar3.isVisible = false

            //binding.listviewProfile.isVisible = true
        }
        binding.textView7.setOnClickListener {
            val i = Intent(context, shoeDetails::class.java)
            i.putExtra("Title","Nike")
            i.putExtra("Model","Revolution 6 FlyEase")
            i.putExtra("KmUsed","100")
            i.putExtra("KmEstimated","500")
            startActivity(i)

        }
        binding.textView8.setOnClickListener {
            val o = Intent(context, shoeDetails::class.java)
            o.putExtra("Title","Asics")
            o.putExtra("Model","Gel Lyte iii")
            o.putExtra("KmUsed","300")
            o.putExtra("KmEstimated","500")
            startActivity(o)
        }
        binding.textView9.setOnClickListener {
            val u = Intent(context, shoeDetails::class.java)
            u.putExtra("Title","Adidas")
            u.putExtra("Model","Trail Blazer")
            u.putExtra("KmUsed","240")
            u.putExtra("KmEstimated","500")
            startActivity(u)
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

           // val shoe = UserShoes(shoeid[i], progress[i])
          //  shoeArrayList.add(shoe)

        }

        //binding.listviewProfile.adapter = ShoeAdapter( arrayList = this.shoeArrayList, context =


        return root


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
                .inflate(R.layout.list_item, viewGroup, false)

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



